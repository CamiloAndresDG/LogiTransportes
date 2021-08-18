/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaRecursos;


import co.logitransportes.logic.capaVista.Principal;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author contr
 */
public class VentanaDialog extends JDialog {

    private Principal principal;
    private JPanel jPanel;

    public VentanaDialog(Principal principal, JPanel jPanel, String titulo, boolean modal, boolean marco) {
        super(principal, titulo, modal);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setUndecorated(marco);
        this.principal = principal;
        this.jPanel = jPanel;
        this.jPanel.setVisible(true);
        this.add(this.jPanel);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(this.principal);
    }
}
