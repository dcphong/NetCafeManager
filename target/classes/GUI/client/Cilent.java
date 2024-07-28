package GUI.client;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import main_client.MainClient;
import utils.Xnoti;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author ASUS
 */
public class Cilent extends javax.swing.JFrame {
    private BigDecimal balance;
    private BigDecimal price;
    
    
    private int totalTime; // Tổng thời gian (tính bằng giây)
    private int ratePerHour; // Giá mỗi giờ
    private int ratePerSecond; // Giá mỗi giây
    private int usedTime; // Thời gian đã sử dụng (tính bằng giây)
    private int remainingTime; // Thời gian còn lại (tính bằng giây)
    private Timer timer;

    public Cilent() {
        setUndecorated(true);
        initComponents();
        setLocationToRight();
    }

//    void init(int totalTime, int ratePerHour) {
//        this.totalTime = totalTime * 60 * 60; // to second
//        this.ratePerHour = ratePerHour;
//        this.ratePerSecond = ratePerHour / 3600; // to second price
//        this.usedTime = 0;
//        this.remainingTime = totalTime;
//        this.timer = new Timer();
//        
//    }

    private void setLocationToRight() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = getWidth();
        int height = getHeight();
        int x = screenSize.width - width;
        int y = 0;  // or any other value depending on your requirement
        setLocation(x, y);
    }

    public void logout() {
        try {
            MainClient.client.logout();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Cilent.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        DangNhapJDialog dangNhap = new DangNhapJDialog(frame, true);
        dangNhap.setVisible(true);
        this.setVisible(false);
    }

    public void changePasswordFormTrue() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        DoiMatKhauJDialog doimatkhau = new DoiMatKhauJDialog(frame, true);
        doimatkhau.setVisible(true);
    }

    public void serviceFormTrue() {
        dichvu_text dichvu_text = new dichvu_text();
        dichvu_text.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dichvu_text.setVisible(true);
    }

    public void MessageFormTrue() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        TinNhanJDialog tinnhan = new TinNhanJDialog(frame, true);
        tinnhan.setVisible(true);
    }

    private void setBalanceClient(BigDecimal balance) {
        txtSoDu.setText(balance.toString());
    }

    public void getBalaceClient(){
        if(this.isVisible()){
            balance = MainClient.listBalanceClient.get(0);
            price = MainClient.listBalanceClient.get(1);
            this.setBalanceClient(balance);
        }
    }

    public void systemTray(String response) {
        Xnoti.showTrayMessage("New response from SERVER", response, TrayIcon.MessageType.INFO);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        pnlChinh = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblAnhBaner = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnDichVu = new javax.swing.JButton();
        btnDoiMatKhau = new javax.swing.JButton();
        btnTinNhan = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtTongThoiGian = new javax.swing.JTextField();
        txtThoiGianSuDung = new javax.swing.JTextField();
        txtThoiGianConLai = new javax.swing.JTextField();
        txtSoDu = new javax.swing.JTextField();
        txtTienDaSuDung = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlChinh.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlChinh.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Tổng thời gian:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Thời gian sử dụng:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Thời gian còn lại:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Số dư:");

        lblAnhBaner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BanerCilent2.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Tiền đã sử dụng:");

        btnDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CilentDichVu.png"))); // NOI18N
        btnDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDichVuActionPerformed(evt);
            }
        });

        btnDoiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CilentDoiMatKhau.png"))); // NOI18N
        btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhauActionPerformed(evt);
            }
        });

        btnTinNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CilentTinNhan.png"))); // NOI18N
        btnTinNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTinNhanActionPerformed(evt);
            }
        });

        btnDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CilentDanXuat.png"))); // NOI18N
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("UeserName");

        txtTongThoiGian.setFont(new java.awt.Font("Source Code Pro", 1, 14)); // NOI18N

        txtThoiGianSuDung.setFont(new java.awt.Font("Source Code Pro", 1, 14)); // NOI18N

        txtThoiGianConLai.setFont(new java.awt.Font("Source Code Pro", 1, 14)); // NOI18N

        txtSoDu.setFont(new java.awt.Font("Source Code Pro", 1, 14)); // NOI18N
        txtSoDu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoDuActionPerformed(evt);
            }
        });

        txtTienDaSuDung.setFont(new java.awt.Font("Source Code Pro", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAnhBaner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel6))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTongThoiGian)
                            .addComponent(txtThoiGianSuDung)
                            .addComponent(txtThoiGianConLai)
                            .addComponent(txtSoDu)
                            .addComponent(txtTienDaSuDung, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTinNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblAnhBaner, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)
                        .addGap(27, 27, 27))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtTongThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtThoiGianSuDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtThoiGianConLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSoDu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTienDaSuDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDoiMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addComponent(btnTinNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        pnlChinh.add(jPanel1);
        jPanel1.setBounds(0, 0, 340, 460);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/GiaoDienCilent.png"))); // NOI18N
        pnlChinh.add(jLabel10);
        jLabel10.setBounds(-10, -220, 360, 1070);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlChinh, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlChinh, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSoDuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoDuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoDuActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        // TODO add your handling code here:
        this.logout();
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void btnDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDichVuActionPerformed
        // TODO add your handling code here:
        this.serviceFormTrue();
    }//GEN-LAST:event_btnDichVuActionPerformed

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMatKhauActionPerformed
        // TODO add your handling code here:
        this.changePasswordFormTrue();
    }//GEN-LAST:event_btnDoiMatKhauActionPerformed

    private void btnTinNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTinNhanActionPerformed
        // TODO add your handling code here:
        this.MessageFormTrue();
    }//GEN-LAST:event_btnTinNhanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cilent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cilent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cilent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cilent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cilent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cilent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cilent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cilent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cilent().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnDichVu;
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JButton btnTinNhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAnhBaner;
    private javax.swing.JPanel pnlChinh;
    private javax.swing.JTextField txtSoDu;
    private javax.swing.JTextField txtThoiGianConLai;
    private javax.swing.JTextField txtThoiGianSuDung;
    private javax.swing.JTextField txtTienDaSuDung;
    private javax.swing.JTextField txtTongThoiGian;
    // End of variables declaration//GEN-END:variables

}
