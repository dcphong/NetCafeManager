/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.server;

import dao.AccountDAO;
import dao.EmployeeDAO;
import entity.Account;
import entity.Employee;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import main_server.MainTest;
import utils.Auth;
import utils.RoundedPanel;
import utils.Xnoti;

/**
 *
 * @author ASUS
 */
public class DangNhapJDialog extends javax.swing.JDialog {
    
    AccountDAO accountDAO = new AccountDAO();
    EmployeeDAO employeeDAO = new EmployeeDAO();
    private Employee employee;
    private Account account;

    /**
     * Creates new form DangNhapJDialog
     */
    public DangNhapJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, true);
        setUndecorated(true); // Bỏ thanh điều khiển
        initComponents();

        init();
    }

    public void init() {
        // Đặt kích thước cho JDialog
        setSize(new Dimension(1920, 1080));

        // Đặt kích thước ưu tiên cho JPanel pnlChinh
        pnlChinh.setPreferredSize(new Dimension(1920, 1080));
        pnlAnh.setPreferredSize(new Dimension(1920, 1080));
        lblAnh.setPreferredSize(new Dimension(1920, 1080));
    }

    public Integer getEmployeeID() {
        return employee.getId();
    }
    
    private Boolean ValiDateForm() {

        try {
            if (txtDangNhap.getText().trim().isEmpty()) {
                Xnoti.msg(this, "Không để trống tên đăng nhập", "Thông báo trống");
                return false;
            }
            if (txtMatKhau.getText().trim().isEmpty()) {
                Xnoti.msg(this, "Không để trống mật khẩu", "Thông báo trống");
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    private void login() {
        
        if (ValiDateForm()) {
            try {
                account = accountDAO.selectByUsernameAndPassword(txtDangNhap.getText(), txtMatKhau.getText());
                if (account == null) {
                    Xnoti.msg(this, "Sai tài khoản hoặc mật khẩu", "Thông báo");
                    return;
                }
                if (Auth.isMembers(account)) {
                    Xnoti.msg(this, "Bạn Không có quyền", "Thông báo");
                    return;
                }
                
                employee = employeeDAO.selectByAccountID(account.getId());
                if (employee == null) {
                    Xnoti.msg(this, "Không có nhân viên với accountID: " + account.getId(), "Thông báo");
                    return;
                }
            } catch (Exception ex) {
                Logger.getLogger(DangNhapJDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
            MainTest.mainForm.setVisible(true);
            MainTest.mainForm.getLblUserName().setText(employee.getName());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlChinh = new javax.swing.JPanel();
        pnlAnh = new javax.swing.JPanel();
        pnlFormDangNhap = new RoundedPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDangNhap = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblAnh = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlAnh.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Source Code Pro", 1, 24)); // NOI18N
        jLabel1.setText("ĐĂNG NHẬP");

        jLabel2.setFont(new java.awt.Font("Source Code Pro", 3, 18)); // NOI18N
        jLabel2.setText("Tài khoản:");

        jLabel3.setFont(new java.awt.Font("Source Code Pro", 3, 18)); // NOI18N
        jLabel3.setText("Mật khẩu:");

        txtDangNhap.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        txtMatKhau.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        btnLogin.setFont(new java.awt.Font("Source Code Pro", 1, 16)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Source Code Pro", 1, 16)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(204, 0, 0));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFormDangNhapLayout = new javax.swing.GroupLayout(pnlFormDangNhap);
        pnlFormDangNhap.setLayout(pnlFormDangNhapLayout);
        pnlFormDangNhapLayout.setHorizontalGroup(
            pnlFormDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormDangNhapLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(202, 202, 202))
            .addGroup(pnlFormDangNhapLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnlFormDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlFormDangNhapLayout.createSequentialGroup()
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFormDangNhapLayout.createSequentialGroup()
                        .addGroup(pnlFormDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(32, 32, 32)
                        .addGroup(pnlFormDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMatKhau)
                            .addComponent(txtDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        pnlFormDangNhapLayout.setVerticalGroup(
            pnlFormDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormDangNhapLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(pnlFormDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(pnlFormDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(26, 26, 26)
                .addGroup(pnlFormDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        pnlAnh.add(pnlFormDangNhap);
        pnlFormDangNhap.setBounds(620, 390, 550, 280);

        lblAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BGLogin.jpg"))); // NOI18N
        pnlAnh.add(lblAnh);
        lblAnh.setBounds(0, -130, 1920, 1340);

        javax.swing.GroupLayout pnlChinhLayout = new javax.swing.GroupLayout(pnlChinh);
        pnlChinh.setLayout(pnlChinhLayout);
        pnlChinhLayout.setHorizontalGroup(
            pnlChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChinhLayout.createSequentialGroup()
                .addComponent(pnlAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 1920, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );
        pnlChinhLayout.setVerticalGroup(
            pnlChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 1111, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlChinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlChinh, javax.swing.GroupLayout.PREFERRED_SIZE, 1082, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        login();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DangNhapJDialog dialog = new DangNhapJDialog(new javax.swing.JFrame(), true);

                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JPanel pnlAnh;
    private javax.swing.JPanel pnlChinh;
    private javax.swing.JPanel pnlFormDangNhap;
    private javax.swing.JTextField txtDangNhap;
    private javax.swing.JPasswordField txtMatKhau;
    // End of variables declaration//GEN-END:variables

    private void setExtendedState(int MAXIMIZED_BOTH) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
