/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test_server_client_GUI;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.util.SystemInfo;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Admin
 */
public class MacOSLookAndFeel {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Cài đặt FlatLaf cho macOS
                UIManager.setLookAndFeel(new FlatLightLaf());
                if (SystemInfo.isMacOS) {
                    UIManager.put("Application.useScreenMenuBar", true);
                    UIManager.put("System.font", "Helvetica Neue");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            new MacOSLookAndFeel().createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("macOS Look and Feel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Tạo JMenuBar và các menu item
        JMenuBar jMenuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem aboutMenuItem = new JMenuItem("About");
        JMenuItem preferencesMenuItem = new JMenuItem("Preferences");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        fileMenu.add(aboutMenuItem);
        fileMenu.add(preferencesMenuItem);
        fileMenu.add(exitMenuItem);
        jMenuBar.add(fileMenu);

        // Cấu hình cho macOS
        macOSConfig(jMenuBar, aboutMenuItem, preferencesMenuItem, exitMenuItem);

        frame.setJMenuBar(jMenuBar);
        frame.setVisible(true);
    }

    private void macOSConfig(JMenuBar jMenuBar, JMenuItem aboutMenuItem, JMenuItem preferencesMenuItem, JMenuItem exitMenuItem) {
        if (SystemInfo.isMacOS) {
            // Ẩn các menu item mà macOS đã có
            aboutMenuItem.setVisible(false);
            preferencesMenuItem.setVisible(false);
            exitMenuItem.setVisible(false);

            // Không sử dụng HTML text trong menu items trên macOS
            JMenuItem htmlMenuItem = new JMenuItem();
            htmlMenuItem.setText("some text");

            if (SystemInfo.isMacFullWindowContentSupported) {
                // Mở rộng nội dung cửa sổ vào thanh tiêu đề và làm cho thanh tiêu đề trong suốt
                JFrame rootFrame = (JFrame) SwingUtilities.getWindowAncestor(jMenuBar);
                rootFrame.getRootPane().putClientProperty("apple.awt.fullWindowContent", true);
                rootFrame.getRootPane().putClientProperty("apple.awt.transparentTitleBar", true);

                // Ẩn tiêu đề cửa sổ
                if (SystemInfo.isJava_17_orLater) {
                    rootFrame.getRootPane().putClientProperty("apple.awt.windowTitleVisible", false);
                } else {
                    rootFrame.setTitle(null);
                }
            }

            // Bật chế độ toàn màn hình cho cửa sổ này (Java 8 - 10)
            if (!SystemInfo.isJava_11_orLater) {
                JFrame rootFrame = (JFrame) SwingUtilities.getWindowAncestor(jMenuBar);
                rootFrame.getRootPane().putClientProperty("apple.awt.fullscreenable", true);
            }
        }
    }
}
