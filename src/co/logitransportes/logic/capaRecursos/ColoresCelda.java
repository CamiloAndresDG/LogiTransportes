/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaRecursos;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Camilo y Roberth
 */
public class ColoresCelda extends JTable {

    public Component prepareRender(TableCellRenderer renderer, int rowIndex, int columnIndex) {
        Component componente = super.prepareRenderer(renderer, rowIndex, columnIndex);
        
        if (getValueAt(rowIndex, columnIndex).getClass().equals(String.class)) {
            String valor = this.getValueAt(rowIndex, columnIndex).toString();
            if (valor.equals("true")) {
                componente.setBackground(Color.red);
                componente.setForeground(Color.WHITE);
            } else {
                componente.setBackground(Color.white);
                componente.setForeground(Color.black);
            }
            return componente;
        }
        return null;
    }
}
