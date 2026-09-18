/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3;

/**
 *
 * @author purwanda.nurhidayat
 */

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class StatusColorRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(
            JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column) {

        Component c = super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);

        int modelRow = table.convertRowIndexToModel(row);

        String status = table.getModel()
                             .getValueAt(modelRow, 5)
                             .toString();        
        
//        String status = table.getModel().getValueAt(row, 5).toString();

        if ("TIDAK SINKRON".equals(status)) {
            c.setBackground(Color.YELLOW);
            c.setForeground(Color.BLACK);
        } else if ("SEDANG NGEJAR".equals(status)) {
            c.setBackground(Color.ORANGE);
            c.setForeground(Color.BLACK);
        } else if ("SINKRON".equals(status)) {
            c.setBackground(new Color(220, 255, 220));
            c.setForeground(Color.BLACK);
        } else {
            c.setBackground(Color.WHITE);
            c.setForeground(Color.BLACK);
        }

        if (isSelected) {
            c.setBackground(table.getSelectionBackground());
            c.setForeground(table.getSelectionForeground());
        }

        return c;
    }    
}
