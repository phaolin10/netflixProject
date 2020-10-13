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
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author PC
 */
public class aramaEkranıJFrame extends javax.swing.JFrame {

    private static Connection con;
    private static Statement st;
    private static ResultSet rs;
    private static String sql;
    private static String değer;
    private static int filmID;
    private static int programZaman;
    private static String tur;
    private static int bolumSayi;

    İzlemeEkranı izlemeEkranı = new İzlemeEkranı(filmID, programZaman, tur, bolumSayi);

    private DefaultTableModel dm = new DefaultTableModel(new String[]{"no", "adı", "tipi", "bölüm sayısı", "bölüm uzunluğu"}, 0);

    public aramaEkranıJFrame() {
        Connection();

        initComponents();
        CreateColumns();
        TabloDoldur();

    }

    private void CreateColumns() { // tablomuza kolon ekleyen method.
        dm = (DefaultTableModel) jTable1.getModel();

        dm.addColumn("no");
        dm.addColumn("adı");
        dm.addColumn("tipi");
        dm.addColumn("bölüm sayısı");
        dm.addColumn("bölüm uzunluğu");
      //  dm.addColumn("tür");

    }

    public void TabloDoldur() { // veritabanımızdaki program bilgilerini tabloya dolduran method.
       // sql = "Select Program.ProgramID ,Program.ProgramAdi , Program.ProgramTipi , Program.BolumSayisi, Program.BolumUzunlugu , Tur.TurAdi  Concat(right (Tur.TurAdi))  from Program,ProgramTur,Tur Where Tur.TurID = ProgramTur.TurID  ";

        sql = "select * from Program";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int a = rs.getInt("ProgramID");
                String b = rs.getString("ProgramAdi").toLowerCase();
                String c = rs.getString("ProgramTipi").toLowerCase();
                int d = rs.getInt("BolumSayisi");
                int e = rs.getInt("BolumUzunlugu");
                
               // String f = rs.getString("TurAdi").toLowerCase();
                dm.addRow(new Object[]{a, b, c, d, e});

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void AdAra(String aranan) { // textfielda girilen harflere göre program ismi arayan method.
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dm);

        jTable1.setRowSorter(tr);

        tr.setRowFilter(RowFilter.regexFilter(aranan));

        if (aranan.trim().length() == 0) {
            tr.setRowFilter(null);
        } else {
            tr.setRowFilter(RowFilter.regexFilter(aranan));
        }

    }

    private void TürAra(String aranan) { // comboboxta seçilen türe göre arama yapan method.
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dm);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(aranan));
        if (aranan != "none") {
            tr.setRowFilter(RowFilter.regexFilter(aranan));
        } else {
            jTable1.setRowSorter(tr);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        getContentPane().setLayout(null);

        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("Arama yapmak için film ismi girin");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 20, 190, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "aksiyon ve macera", "belgesel", "bilim kurgu ve fantastik yapımlar", "bilim ve doğa", "çocuk ve aile", "dramalar", "gerilim", "korku", "komedi", "romantizm", "anime", "reality program" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1İtemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(810, 20, 140, 30);

        jTextField1.setBackground(new java.awt.Color(153, 0, 0));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(220, 20, 270, 30);

        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Türe göre arama yapmak için seçin");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(580, 30, 200, 20);

        jTextField2.setBackground(new java.awt.Color(153, 0, 0));
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(220, 20, 270, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 100, 990, 460);

        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("İZLEMEK İSTEDİĞİNİZ FİLME 1 KEZ TIKLAYIN");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(300, 66, 420, 30);

        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/netflix/abc.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 990, 560);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // jTextField1 textfieldına girilen texti tuttuğumuz event.
        String aranan = jTextField1.getText().toLowerCase();
        AdAra(aranan);
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jComboBox1İtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1İtemStateChanged
        // jComboBox1 comboboxında seçilen türü tuttuğumuz event.
        String aranan = jComboBox1.getSelectedItem().toString();
        TürAra(aranan);
// TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1İtemStateChanged

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dm);
        //   String index = jTable1.getModel()
        int tablo1satir = jTable1.getSelectedRow();//Hangi satır olduğunu alıyor.
        int tablo1sutun = jTable1.getSelectedColumn();//Hangi sutun olduğunu alıyor

        String secilenIndex = String.valueOf(jTable1.getValueAt(tablo1satir, tablo1sutun));
        int filmID = Integer.valueOf(secilenIndex);// filmID sini veritabanına yazmak için tablomuzdan filmID değişkenine film numarasını atadık
        //  System.out.println(secilenIndex);

        String sayi = jTable1.getModel().getValueAt(tablo1satir, 3).toString();
        int bolumSayi = Integer.valueOf(sayi); // bolumsayisini veritabanında sorgu yapabilmek için ve izlemeEkranı classında kullanmak için atadık.
        // System.out.println("aaaa"+bolumSayi);

        String Zaman = jTable1.getModel().getValueAt(tablo1satir, 4).toString();
        int programZaman = Integer.valueOf(Zaman); // program zamanını İzlemeEkranı classında izlenen süre , ve kalınan bölüm değişkenlerini bulmak için programZaman değişkenine atadık.

        String tur = jTable1.getModel().getValueAt(tablo1satir, 2).toString();

        İzlemeEkranı izlemeEkranı = new İzlemeEkranı(filmID, programZaman, tur, bolumSayi); // değişkenlerimizi izleme ekranına veritabanı yazdırma işlemi için gönderdik.
        izlemeEkranı.setVisible(true);


    }//GEN-LAST:event_jTable1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

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

}
