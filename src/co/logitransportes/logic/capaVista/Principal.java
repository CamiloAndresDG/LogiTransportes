/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaVista;

//import co.logitransportes.logic.capaVista.paneles.TrabajadorIniciadoJPanel;
//import co.logitransportes.logic.capaVista.paneles.TrabajadoresJPanel;
//import co.logitransportes.logic.capaVista.paneles.EntregasJPanel;
//import co.logitransportes.logic.capaVista.paneles.EntregasProgresoJPanel;
//import co.logitransportes.logic.capaVista.paneles.ClientesJPanel;
import javax.swing.JPanel;

import AppPackage.AnimationClass;
import co.logitransportes.logic.capaFacade.FachadaCodificacion;
import co.logitransportes.logic.capaFacade.FachadaEmpresa;
import co.logitransportes.logic.capaFacade.FachadaEntrega;
import co.logitransportes.logic.capaFacade.FachadaLicencia;
import co.logitransportes.logic.capaFacade.FachadaPersona;
import co.logitransportes.logic.capaFacade.FachadaPropietario;
import co.logitransportes.logic.capaFacade.FachadaSatelite;
import co.logitransportes.logic.capaFacade.FachadaTrabajador;
import co.logitransportes.logic.capaFacade.FachadaUsuario;
import co.logitransportes.logic.capaFacade.FachadaVehiculo;
import co.logitransportes.logic.capaModelador.Administrativos;
import co.logitransportes.logic.capaModelador.Conductores;
import co.logitransportes.logic.capaModelador.Trabajadores;
import co.logitransportes.logic.capaModelador.Usuarios;
import co.logitransportes.logic.capaModelador.Personas;
import co.logitransportes.logic.capaVista.panelesIniciales.administrativos.AgregarTrabajadorJPanel;
import co.logitransportes.logic.capaVista.panelesIniciales.administrativos.EntregasJPanel;
import co.logitransportes.logic.capaVista.panelesIniciales.administrativos.TrabajadoresJPanel;

//
//import co.logitransportes.logic.capaRecursos.GestionA;
//import co.logitransportes.logic.capaVista.paneles.trabajadores.agregacion.AgregarClienteJPanel;
//import co.logitransportes.logic.capaVista.paneles.trabajadores.agregacion.AgregarEntregaJPanel;
//import co.logitransportes.logic.capaVista.paneles.trabajadores.agregacion.AgregarTrabajador;
//import co.logitransportes.logic.facade.FachadaEmpresa;
//import co.logitransportes.logic.facade.FachadaLicencia;
//import co.logitransportes.logic.facade.FachadaPersona;
//import co.logitransportes.logic.facade.FachadaPropietario;
//import co.logitransportes.logic.facade.FachadaSatelite;
//import co.logitransportes.logic.facade.FachadaTrabajador;
//import co.logitransportes.logic.facade.FachadaUsuario;
//import co.logitransportes.logic.facade.FachadaVehiculo;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author 306
 */
public class Principal extends javax.swing.JFrame {

//    public JFileChooser seleccionado = new JFileChooser();
//    public File archivo;
//    public byte[] bytesImg;
//    public GestionA gestion = new GestionA();
    public WindowDialog ventanaDialog;

//    private EntregasJPanel entregas;
//    private EntregasProgresoJPanel entregasProgresoJPanel;
//    TrabajadorIniciadoJPanel trabajadorIniciadoJPanel;
//    AgregarTrabajador agregarTrabajador;

    /*
    Conexion DB
     */
    public FachadaEmpresa fachadaEmpresa;
    public FachadaLicencia fachadaLicencia;
    public FachadaPersona fachadaPersona;
    public FachadaPropietario fachadaPropietario;
    public FachadaSatelite fachadaSatelite;
    public FachadaTrabajador fachadaTrabajador;
    public FachadaUsuario fachadaUsuario;
    public FachadaVehiculo fachadaVehiculo;
    public FachadaEntrega fachadaEntrega;
    public FachadaCodificacion fachadaCodificacion;

    private InicioSesionJPanel inicioSesionJPanel;
    private InicioJPanel inicioJPanel;
    private EntregasJPanel entregasJPanel;
//    private TrabajadorIniciadoJPanel trabajadorIniciadoJPanel;
    private TrabajadoresJPanel trabajadoresJPanel;
    private AgregarTrabajadorJPanel agregarTrabajadorJPanel;

    /**
     * Incializacion varibales para animaciones
     */
    public AnimationClass internet = new AnimationClass();
    public AnimationClass calculadora = new AnimationClass();
    public AnimationClass calendario = new AnimationClass();

    /*
    Inicializacion de variables generales
     */
    public Trabajadores trabajador;
    public Administrativos administrativo;
    public Conductores conductor;
    public Usuarios usuario;
    public Personas persona;

    /**
     * Creates new form Principal
     */
    public Principal() {
        /**
         * Inicializacion de conexiones
         */
        this.fachadaEmpresa = new FachadaEmpresa();
        this.fachadaLicencia = new FachadaLicencia();
        this.fachadaPersona = new FachadaPersona();
        this.fachadaPropietario = new FachadaPropietario();
//        this.fachadaSatelite = new FachadaSatelite();
        this.fachadaTrabajador = new FachadaTrabajador();
        this.fachadaUsuario = new FachadaUsuario();
//        this.fachadaVehiculo = new FachadaVehiculo();
        this.fachadaCodificacion = new FachadaCodificacion();
        this.fachadaEntrega = new FachadaEntrega();

        setTitle("LogiTransportes");
        setName("pricipalJFrame");
        setIconImage(new ImageIcon(getClass().getResource("../capaVista/imagenes/iconos/logo-mini.png")).getImage());

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setUndecorated(true);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);

        iniciar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                new Principal().setVisible(true);
            }
        });
    }

    //Navegacion desde inicio
    public void iniciar() {
        inicioSesionJPanel = new InicioSesionJPanel(this);
        inicioSesionJPanel.setVisible(true);
        add(inicioSesionJPanel);
        pack();
        setLocationRelativeTo(null);
    }

    /*Abrir una imagen*/
    protected void irAPantallaPrincipal(JPanel jPanel) {
        remove(jPanel);
        inicioJPanel = new InicioJPanel(this);
        inicioJPanel.setVisible(true);
        add(inicioJPanel);
        pack();
        setLocationRelativeTo(null);
    }

//    public void volverAInicio(JPanel jPanel) {
//        remove(jPanel);
//        inicioJPanel = new InicioJPanel(this);
//        inicioJPanel.setVisible(true);
//        add(inicioJPanel);
//        pack();
//        setLocationRelativeTo(null);
//    }
//
//    protected void irAEntregas(JPanel jPanel) {
//        remove(jPanel);
//        entregas = new EntregasJPanel(this);
//        entregas.setVisible(true);
//        add(entregas);
//        pack();
//        setLocationRelativeTo(null);
//    }
//
//    protected void irAEntregasActivas(JPanel jPanel) {
//        remove(jPanel);
//        entregasProgresoJPanel = new EntregasProgresoJPanel(this);
//        entregasProgresoJPanel.setVisible(true);
//        add(entregasProgresoJPanel);
//        pack();
//        setLocationRelativeTo(null);
//    }
//
//    public void irAClientes(JPanel jPanel) {
//        remove(jPanel);
//        clientes = new ClientesJPanel(this);
//        clientes.setVisible(true);
//        add(clientes);
//        pack();
//        setLocationRelativeTo(null);
//    }
//
//    // NOTAS
//    protected void irATrabajadores(JPanel jPanel) {
//        remove(jPanel);
//        trabajadoresJPanel = new TrabajadoresJPanel(this);
//        trabajadoresJPanel.setVisible(true);
//        add(trabajadoresJPanel);
//        pack();
//        setLocationRelativeTo(null);
//    }
//
//    public void volverAInicioTrabajadorIngresado(JPanel jPanel) {
//        remove(jPanel);
//        trabajadorIniciadoJPanel = new TrabajadorIniciadoJPanel(this);
//        trabajadorIniciadoJPanel.setVisible(true);
//        add(trabajadorIniciadoJPanel);
//        pack();
//        setLocationRelativeTo(null);
//    }
//
//    public void irAAgregarNuevaEntrega() {
//        agregarEntregaJPanel = new AgregarEntregaJPanel(this);
//        ventanaDialog = new WindowDialog(this, agregarEntregaJPanel, "Agregar nueva entrega", false, false, DISPOSE_ON_CLOSE);
//    }
//
//    public void irAAgregarNuevoCliente() {
//        agregarClienteJPanel = new AgregarClienteJPanel(this);
//        ventanaDialog = new WindowDialog(this, agregarClienteJPanel, "Agregar nueo cliente", false, false, DISPOSE_ON_CLOSE);
//    }
//    
//    public void irAAgregarNuevoTrabajador() {
//        agregarTrabajador = new AgregarTrabajador(this);
//        ventanaDialog = new WindowDialog(this, agregarTrabajador, "Agregar nueo cliente", false, false, DISPOSE_ON_CLOSE);
//    }
//    public void volverAInicioTrabajador(JPanel jPanel) {
//        remove(jPanel);
//        trabajadorIniciadoJPanel = new TrabajadorIniciadoJPanel(this);
//        trabajadorIniciadoJPanel.setVisible(true);
//        add(trabajadorIniciadoJPanel);
//        pack();
//        setLocationRelativeTo(null);
//    }

    /*Abrir una imagen*/
    protected void irAEntregas(JPanel jPanel) {
        remove(jPanel);
        entregasJPanel = new EntregasJPanel(this);
        entregasJPanel.setVisible(true);
        add(entregasJPanel);
        pack();
        setLocationRelativeTo(null);
    }

    /*Abrir una imagen*/
    protected void irATrabajador(JPanel jPanel) {
        remove(jPanel);
        trabajadoresJPanel = new TrabajadoresJPanel(this);
        trabajadoresJPanel.setVisible(true);
        add(trabajadoresJPanel);
        pack();
        setLocationRelativeTo(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    public void irAAgregarNuevoTrabajador() {
        agregarTrabajadorJPanel = new AgregarTrabajadorJPanel(this);
        ventanaDialog = new WindowDialog(this, agregarTrabajadorJPanel, "Agregar nuevo trabajador", false, false, DISPOSE_ON_CLOSE);
    }

    }
