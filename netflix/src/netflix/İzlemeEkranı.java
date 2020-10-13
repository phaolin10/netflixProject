/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflix;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ismail
 */
public class İzlemeEkranı extends javax.swing.JFrame {

    public long bitis;
    public long baslangıc;
    private static int programID;
    private static int programZaman;
    public static String mail;
    public static String sifre;
    private static int kullanıcıID;
    private static String sql;
    private static Connection con;
    private static Statement st;
    private static ResultSet rs;
    private static int kalinanBolum;
    private static String tür;
    private static int bolumSayi;
    private static int puan;

    /**
     * Creates new form İzlemeEkranı
     */
    public İzlemeEkranı(int programID, int programZaman, String tür, int bolumSayi) {
        Connection();
        Netflix netflix = new Netflix();
        mail = netflix.getMail();
        sifre = netflix.getSifre();
        kullanıcıID = kullanıcıIdBul();
        if (programID != 0) {
            System.out.println(kullanıcıID);
            this.programID = programID;
            this.programZaman = programZaman;
            this.tür = tür;
            this.bolumSayi = bolumSayi;
            System.out.println(this.programID);
            System.out.println(this.programZaman);
            System.out.println(tür);
            System.out.println("bolumsayisi" + bolumSayi);
            // System.out.println(this.tür);
            initComponents();
            KullaniciProgramYaz();

        }

    }

    public static int kullanıcıIdBul() { // gelen mail değişkenine göre kullanıcının ID sini bulan method.
        try {
            sql = "Select * from Kullanici Where Email = '" + mail + "' ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int kullanıcıID = rs.getInt("KullaniciID");
                // System.out.println(kullanıcıID);
                return kullanıcıID;
            }

        } catch (Exception a) {
            System.out.println(a);
        }
        return -1;
    }

    public static void KullaniciProgramYaz() // bu method KullaniciProgram tablosuna KalinanBolum dışındaki bilgileri yazar.
    {
        Connection();
        Date tarih = new Date();
        SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

        // System.out.println(dt.format(izlemeTarihi));
        try {
            sql = "Select KullaniciID,ProgramID from KullaniciProgram where KullaniciID = '" + kullanıcıID + "' and ProgramID = '" + programID + "'";
            // programın daha önce izlenip izlenmediğini aratan sorgumuz.
            // bu sorguyu kullanarak veritabanımıza bilgi aktarımı gerçekleştireceğiz.
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                if (kullanıcıID != 0 && programID != 0) { // koddaki bugdan dolayı llk kullanıcıID ve programID değişkenlerinin 0 olmasından kaynaklı oluşturulan koşul.
                    System.out.println("burayagirdi");
                    KullanıcıProgramDetay();
                }
            } else {
                if (kullanıcıID != 0 && programID != 0) { // koddaki bugdan dolayı llk kullanıcıID ve programID değişkenlerinin 0 olmasından kaynaklı oluşturulan koşul.
                    sql = "INSERT INTO KullaniciProgram(KullaniciID,ProgramID,IzlemeSuresi,IzlemeTarihi,KalinanBolum)VALUES('" + kullanıcıID + "','" + programID + "','" + programZaman + "','" + dt.format(tarih) + "',1)";
                    st = con.createStatement();
                    st.executeUpdate(sql);
                }
            }

        } catch (Exception e) {
            System.out.println("bbbb" + e);
        }
    }

    public static void KullanıcıProgramDetay() { // bu method KullaniciProgram tablosuna kullaniciID ve programID dışındaki bilgileri yazar.

        try {
            sql = "Select KalinanBolum from KullaniciProgram Where ProgramID = '" + programID + "' and  KullaniciID = '" + kullanıcıID + "' ";
            // giriş yapılan kullanıcının filmi ya da diziyi izleyip kaçıncı bölümde kaldığını sorgulayan ve kalinanBolum değişkenine atayacak sorgumuz.
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Date izlemeTarihi = new Date();                                               //
            SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss:");           // tarih oluşturma ve formatlama kısmı
            dt.format(izlemeTarihi);                                                      // 
            if (rs.next()) {
                kalinanBolum = rs.getInt("KalinanBolum");
                if (bolumSayi == 1) { // bölüm sayısı 1 ise izlenen programın film olduğunu anlatıp update sorgumuzu yaptığımız kısım.
                    System.out.println("izlenen program film");
                    kalinanBolum = 1;
                    sql = "UPDATE KullaniciProgram SET KalinanBolum= '" + kalinanBolum + "' ,IzlemeTarihi = '" + dt.format(izlemeTarihi) + "' Where ProgramID = '" + programID + "' and  KullaniciID = '" + kullanıcıID + "' ";
                    st.executeUpdate(sql);
                } else {              // bölüm sayısı 1 den farklı ise dizi veya tv show olduğunu anlayıp update sorgumuzu yaptığımız kısım.
                    System.out.println("izlenen program dizi veya tv show");

                    kalinanBolum++;
                    sql = "UPDATE KullaniciProgram SET KalinanBolum ='" + kalinanBolum + "', IzlemeTarihi = '" + dt.format(izlemeTarihi) + "' Where ProgramID = '" + programID + "' and  KullaniciID = '" + kullanıcıID + "' ";
                    // izlenen dizi veya tv showunun bilgilerini güncelleyen sql sorgumuz.
                    st.executeUpdate(sql);
                }

            }

        } catch (Exception e) {
            System.out.println("ddddd" + e);
        }

    }

    private static void Connection() { // veritabanımıza bağlandığımız method.
        try {

            con = DriverManager.getConnection("jdbc:ucanaccess://netflix.accdb");
            // veri tabanina baglanti saglaniyor.
            st = con.createStatement();
            //baglantidan ifade olusturuldu.
            System.out.println("bağlandı");
        } catch (Exception ee) {
            System.out.println("Veri tabanına bağlantı sağlanamadı" + ee);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(850, 400));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("İyi Seyirler...");
        jLabel1.setMaximumSize(new java.awt.Dimension(100, 100));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(320, 80, 290, 89);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Vermek istediğiniz puanı girin(1-10 arası)");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(210, 180, 460, 27);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(270, 230, 158, 23);

        jToggleButton1.setBackground(new java.awt.Color(153, 0, 0));
        jToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setText("Gönder");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton1);
        jToggleButton1.setBounds(460, 230, 100, 23);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/netflix/123.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 830, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        puan = Integer.valueOf(jTextField1.getText());
        System.out.println("puan" + puan);
        Connection();
        JOptionPane.showMessageDialog(this, "Puanınız Gönderildi.");
        try {
            sql = "UPDATE KullaniciProgram SET Puan = '" + puan + "' Where ProgramID = '" + programID + "' and  KullaniciID = '" + kullanıcıID + "' ";
            Statement st = con.createStatement();
            st.executeUpdate(sql);
           

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
