package netflix;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ismail
 */
public class Netflix extends javax.swing.JFrame {

    private static Connection con;
    private static Statement statement;
    private static ResultSet resultSet;
    private static String ad;
    private static String mail;
    private static String sifre;
    private static String dogumTarihi;
    private static String sql;
  //  private static int kullanıcıID;

    public static String getMail() {
        return mail;
    }

    public static String getSifre() {
        return sifre;
    }

    public Netflix() {
        initComponents();
    }

   /* public static int getKullanıcıID() {
        return kullanıcıID;
    }
*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jFrame1 = new javax.swing.JFrame();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        girisMail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        kayitMail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        girisYap = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton13 = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        kayitOl = new javax.swing.JButton();
        kayitSifre = new javax.swing.JTextField();
        girisSifre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jTextPane2);

        setMinimumSize(new java.awt.Dimension(1300, 700));
        getContentPane().setLayout(null);

        jLabel2.setText("GİRİŞ YAPMAK İÇİN AŞAĞIDAKİ İSTENENLERİ DOLDURUN");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 60, 380, 60);

        jLabel3.setText("E-Mail");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 130, 40, 16);
        getContentPane().add(girisMail);
        girisMail.setBounds(120, 130, 193, 30);

        jLabel4.setText("Şifre");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(70, 180, 30, 16);

        jLabel1.setText("KAYIT OLMAK İÇİN AŞAĞIDA İSTENENLERİ DOLDURUN");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(450, 80, 311, 16);

        jLabel5.setText("E-Mail");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(450, 120, 99, 16);
        getContentPane().add(kayitMail);
        kayitMail.setBounds(520, 110, 206, 30);

        jLabel6.setText("Şifre");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(450, 170, 30, 16);

        jLabel8.setText("Adınız");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(450, 210, 40, 20);
        getContentPane().add(jTextField5);
        jTextField5.setBounds(520, 210, 204, 30);

        girisYap.setText("Giriş Yap");
        girisYap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                girisYapActionPerformed(evt);
            }
        });
        getContentPane().add(girisYap);
        girisYap.setBounds(60, 260, 298, 47);

        jLabel7.setText("Tür Seçin(3 farklı tür)");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(550, 280, 130, 29);

        jRadioButton2.setText("Belgesel");
        getContentPane().add(jRadioButton2);
        jRadioButton2.setBounds(460, 350, 81, 28);

        jRadioButton1.setText("Aksiyon");
        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(460, 310, 77, 28);

        jRadioButton3.setText("Bilim Kurgu ve Fantastik");
        getContentPane().add(jRadioButton3);
        jRadioButton3.setBounds(460, 390, 168, 28);

        jRadioButton4.setText("Bilim ve Doğa");
        getContentPane().add(jRadioButton4);
        jRadioButton4.setBounds(460, 430, 108, 28);

        jRadioButton5.setText("Çocuk ve Aile");
        getContentPane().add(jRadioButton5);
        jRadioButton5.setBounds(460, 470, 108, 28);

        jRadioButton6.setText("Dramalar");
        getContentPane().add(jRadioButton6);
        jRadioButton6.setBounds(660, 310, 85, 28);

        jRadioButton7.setText("Gerilim");
        getContentPane().add(jRadioButton7);
        jRadioButton7.setBounds(660, 350, 72, 28);

        jRadioButton8.setText("Komedi");
        getContentPane().add(jRadioButton8);
        jRadioButton8.setBounds(660, 390, 75, 28);

        jRadioButton9.setText("Korku");
        getContentPane().add(jRadioButton9);
        jRadioButton9.setBounds(660, 430, 66, 28);

        jRadioButton10.setText("Romantizm");
        getContentPane().add(jRadioButton10);
        jRadioButton10.setBounds(660, 470, 96, 28);

        jRadioButton11.setText("Anime");
        getContentPane().add(jRadioButton11);
        jRadioButton11.setBounds(460, 510, 99, 28);

        jRadioButton13.setText("Reality Program");
        getContentPane().add(jRadioButton13);
        jRadioButton13.setBounds(660, 510, 120, 28);

        jLabel10.setText("Doğum Tarihi (gün,ay,yıl)");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(380, 250, 140, 50);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(520, 250, 200, 30);

        kayitOl.setText("Kayıt Ol");
        kayitOl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kayitOlActionPerformed(evt);
            }
        });
        getContentPane().add(kayitOl);
        kayitOl.setBounds(530, 570, 166, 47);
        getContentPane().add(kayitSifre);
        kayitSifre.setBounds(520, 160, 210, 30);
        getContentPane().add(girisSifre);
        girisSifre.setBounds(120, 180, 190, 30);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/netflix/xyz.jpg"))); // NOI18N
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 0, 1290, 660);

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    private void girisYapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_girisYapActionPerformed
        // TODO add your handling code here:
        // Bu event giriş yap butonuna basıldığı zaman 
        sifre = girisSifre.getText(); // girisSifre textfieldına girilen texti sifre stringine atar.
        mail = girisMail.getText();  //girisMail textfieldına girilen texti mail stringine atar.
        sql = "Select Email,Sifre from Kullanici Where Sifre = '" + sifre + "' and Email = '" + mail + "' "; // mail ve şifre bilgilerinin doğruluğunu sorgulamak için yazdığımız sql sorgusu.
        try {
           ResultSet rs =  statement.executeQuery(sql);
         if(rs.next())
         {
             JOptionPane.showMessageDialog(this, "Giriş başarılı");
             aramaEkranıJFrame ekran2 = new aramaEkranıJFrame();
            ekran2.setVisible(true);
           
         }
         else{
             
             JOptionPane.showMessageDialog(this, "Hatalı e-mail ya da şifre");
             
         }
            
        } catch (Exception e) {
            
            System.out.println(e);
        }

    }//GEN-LAST:event_girisYapActionPerformed

    private void kayitOlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kayitOlActionPerformed
        // TODO add your handling code here:
        ad = jTextField5.getText(); // jTextField5 textfieldına girilen texti ad stringine atar.
        mail = kayitMail.getText(); // kayitMail textfieldına girilen texti mail stringine atar.
        sifre = kayitSifre.getText(); // kayitSifre textfieldına girilen texti sifre  stringine atar.
        dogumTarihi = jTextField3.getText(); // jTextField3 textfieldına girilen texti dogumTarihi  stringine atar.
        sql = "INSERT INTO Kullanici(Ad,Email,Sifre,DogumTarihi) VALUES('" + ad + "','" + mail + "','" + sifre + "','" + dogumTarihi + "')"; // kullanıcı bilgilerini veritabanına ekleyen sorgu.
        try {
            statement.executeUpdate(sql);
           // System.out.println("kayıt eklendi");
           JOptionPane.showMessageDialog(this,"Kayıt başarıyla eklendi");
        } catch (Exception e) {
            //System.out.println("Bu mail alınmış");
            JOptionPane.showMessageDialog(this, "Bu mail alınmış ya da eksik bilgi girildi");
        }
    }//GEN-LAST:event_kayitOlActionPerformed

    public static void main(String args[]) {

        Connection();

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Netflix.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Netflix.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Netflix.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Netflix.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Netflix().setVisible(true);
            }
        });
    }

    private static void Connection() { // veritabanımıza bağlanmamızı sağlayan method.
        try {

            con = DriverManager.getConnection("jdbc:ucanaccess://netflix.accdb");
            // veri tabanina baglanti saglaniyor.
            statement = con.createStatement();
            //baglantidan ifade olusturuldu.
            System.out.println("bağlandı");
        } catch (Exception ee) {
            System.out.println("Veri tabanına bağlantı sağlanamadı" + ee);
        }
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField girisMail;
    private javax.swing.JTextField girisSifre;
    private javax.swing.JButton girisYap;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton13;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextField kayitMail;
    private javax.swing.JButton kayitOl;
    private javax.swing.JTextField kayitSifre;
    // End of variables declaration//GEN-END:variables
}
