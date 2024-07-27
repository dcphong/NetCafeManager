/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.Font;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Admin
 */
public class InitTable {
    public static void initTable(javax.swing.JTable tbl, int indexColumn){
        // Tạo một Font mới với kiểu chữ "Times New Roman" và kích thước 24
        Font headerFont = new Font("Times New Roman", Font.BOLD, 20);

        // Lấy tiêu đề của bảng và đặt font mới
        JTableHeader tableHeader = tbl.getTableHeader();
        tableHeader.setFont(headerFont);
        
          // Tạo một DefaultTableCellRenderer để căn giữa tiêu đề
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tableHeader.getDefaultRenderer();
        renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        
        // Tạo một DefaultTableCellRenderer để căn phải cột thứ 5
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
        
        tbl.getColumnModel().getColumn(indexColumn).setCellRenderer(rightRenderer);

        // Đảm bảo rằng bảng và tiêu đề bảng được cập nhật
        tbl.repaint(); 
    }
}
