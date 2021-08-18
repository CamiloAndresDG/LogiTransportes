/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaVista.panelesIniciales.administrativos;

import AppPackage.AnimationClass;
import co.logitransportes.logic.capaModelador.Empresas;
import co.logitransportes.logic.capaModelador.Entregas;
import co.logitransportes.logic.capaModelador.Personas;
import co.logitransportes.logic.capaModelador.Trabajadores;
import co.logitransportes.logic.capaModelador.Vehiculos;
import co.logitransportes.logic.capaRecursos.ColoresCelda;
import co.logitransportes.logic.capaVista.Principal;
import static java.awt.Frame.ICONIFIED;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Camilo y Roberth
 */
public class EntregasJPanel extends javax.swing.JPanel {

    Principal principal;
    private final DefaultTableModel modeloTabla;

    String data[][] = {};
    String headerConductor[] = {"ID", "Fecha", "Estado", "Estado Integridad", "Conductor", "Empresa"};
    private Entregas entregaEncontrada = null;
    Personas personaEncontrada = null;
    Empresas empresaEncontrada = null;

    /**
     * Creates new form EntregasJPanel
     */
    public EntregasJPanel(Principal principal) {
        this.principal = principal;
        modeloTabla = new DefaultTableModel(data, headerConductor);

        initComponents();

        jTableDatosEntregas.setModel(modeloTabla);
        actualizarListaEntregas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelNombresUsuario = new javax.swing.JLabel();
        jLabelBotonAgregarEntrega = new javax.swing.JLabel();
        jLabelTextAgregarEntrega = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDatosEntregas = new ColoresCelda();
        jPanelInfoEncontrada = new javax.swing.JPanel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabelTextFecha = new javax.swing.JLabel();
        jLabelTextEstado = new javax.swing.JLabel();
        jTextFieldConductor = new javax.swing.JTextField();
        jLabelTextConductor = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jTextFieldFecha = new javax.swing.JTextField();
        jLabelTextID = new javax.swing.JLabel();
        jTextFieldEstado = new javax.swing.JTextField();
        jTextFieldEmpresa = new javax.swing.JTextField();
        jLabelTextEmpresa = new javax.swing.JLabel();
        jLabelTextInfoDelConductor = new javax.swing.JLabel();
        jLabelTextInfoEmpresa = new javax.swing.JLabel();
        jLabelBotonConductor = new javax.swing.JLabel();
        jLabelBotonInfoEmpresa = new javax.swing.JLabel();
        jLabelTextModificarEntrega = new javax.swing.JLabel();
        jLabelTextVerUbi = new javax.swing.JLabel();
        jLabelBotonModificarEntrega = new javax.swing.JLabel();
        jLabelBotonVerUbi = new javax.swing.JLabel();
        jLabelTextInfoEntregas = new javax.swing.JLabel();
        jPanelBusqueda = new javax.swing.JPanel();
        jLabelTextCondicionesBusqueda = new javax.swing.JLabel();
        jTextFieldCondicionBusqueda = new javax.swing.JTextField();
        jRadioButtonTodos = new javax.swing.JRadioButton();
        jRadioButtonActivos = new javax.swing.JRadioButton();
        jRadioButtonCompletados = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelBuscar = new javax.swing.JLabel();
        jPanelVentana = new javax.swing.JPanel();
        jLabelMinimizar = new javax.swing.JLabel();
        jLabelCerrar = new javax.swing.JLabel();

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 60, 143)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelUsuario.setBackground(new java.awt.Color(0, 50, 168));
        jLabelUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(0, 50, 168));
        jLabelUsuario.setText("Bienvenido al panel de entregas");
        jPanel5.add(jLabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 245, -1, -1));

        jLabelNombresUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelNombresUsuario.setForeground(new java.awt.Color(0, 50, 168));
        jLabelNombresUsuario.setText("s");
        jPanel5.add(jLabelNombresUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 278, 195, -1));

        jLabelBotonAgregarEntrega.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBotonAgregarEntrega.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/logitransportes/logic/capaVista/imagenes/iconos/agregarEntrega.png"))); // NOI18N
        jLabelBotonAgregarEntrega.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabelBotonAgregarEntrega.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(jLabelBotonAgregarEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 130, 60));

        jLabelTextAgregarEntrega.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelTextAgregarEntrega.setText("Agregar nueva entrega");
        jPanel5.add(jLabelTextAgregarEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, -1, -1));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/logitransportes/logic/capaVista/imagenes/iconos/atras.png"))); // NOI18N
        jLabel15.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 700, 30, 40));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Atras");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 730, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 60, 143)));

        jTableDatosEntregas.setBackground(new java.awt.Color(207, 216, 220));
        jTableDatosEntregas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableDatosEntregas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableDatosEntregas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "FECHA", "ESTADO", "TRABAJADOR (CEDULA)", "EMPRESA (NIT)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDatosEntregas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDatosEntregasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDatosEntregas);

        jPanelInfoEncontrada.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jPanelInfoEncontrada.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 200, 10));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanelInfoEncontrada.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 200, 10));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jPanelInfoEncontrada.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 35, 200, 10));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jPanelInfoEncontrada.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 200, 10));

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jPanelInfoEncontrada.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 200, 10));

        jLabelTextFecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTextFecha.setForeground(new java.awt.Color(0, 50, 168));
        jLabelTextFecha.setText("Fecha:");
        jPanelInfoEncontrada.add(jLabelTextFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabelTextEstado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTextEstado.setForeground(new java.awt.Color(0, 50, 168));
        jLabelTextEstado.setText("Estado:");
        jPanelInfoEncontrada.add(jLabelTextEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jTextFieldConductor.setBackground(new java.awt.Color(240, 240, 240));
        jTextFieldConductor.setBorder(null);
        jPanelInfoEncontrada.add(jTextFieldConductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 190, 20));

        jLabelTextConductor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTextConductor.setForeground(new java.awt.Color(0, 50, 168));
        jLabelTextConductor.setText("Conductor:");
        jPanelInfoEncontrada.add(jLabelTextConductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jTextFieldID.setEditable(false);
        jTextFieldID.setBorder(null);
        jPanelInfoEncontrada.add(jTextFieldID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 190, 23));

        jTextFieldFecha.setBackground(new java.awt.Color(240, 240, 240));
        jTextFieldFecha.setBorder(null);
        jPanelInfoEncontrada.add(jTextFieldFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 190, 20));

        jLabelTextID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTextID.setForeground(new java.awt.Color(0, 50, 168));
        jLabelTextID.setText("ID:");
        jPanelInfoEncontrada.add(jLabelTextID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        jTextFieldEstado.setEditable(false);
        jTextFieldEstado.setBorder(null);
        jTextFieldEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEstadoActionPerformed(evt);
            }
        });
        jPanelInfoEncontrada.add(jTextFieldEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 190, 20));

        jTextFieldEmpresa.setEditable(false);
        jTextFieldEmpresa.setBorder(null);
        jPanelInfoEncontrada.add(jTextFieldEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 190, 20));

        jLabelTextEmpresa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTextEmpresa.setForeground(new java.awt.Color(0, 50, 168));
        jLabelTextEmpresa.setText("Empresa:");
        jPanelInfoEncontrada.add(jLabelTextEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabelTextInfoDelConductor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelTextInfoDelConductor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTextInfoDelConductor.setText("Info. del conductor");
        jPanelInfoEncontrada.add(jLabelTextInfoDelConductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 120, -1));

        jLabelTextInfoEmpresa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelTextInfoEmpresa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTextInfoEmpresa.setText("Info. de la empresa");
        jPanelInfoEncontrada.add(jLabelTextInfoEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 120, 20));

        jLabelBotonConductor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBotonConductor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/logitransportes/logic/capaVista/imagenes/iconos/conductorSMALL.png"))); // NOI18N
        jLabelBotonConductor.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabelBotonConductor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelBotonConductor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBotonConductorMouseClicked(evt);
            }
        });
        jPanelInfoEncontrada.add(jLabelBotonConductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 120, 50));

        jLabelBotonInfoEmpresa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBotonInfoEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/logitransportes/logic/capaVista/imagenes/iconos/empresaSMALL.png"))); // NOI18N
        jLabelBotonInfoEmpresa.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabelBotonInfoEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelBotonInfoEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBotonInfoEmpresaMouseClicked(evt);
            }
        });
        jPanelInfoEncontrada.add(jLabelBotonInfoEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 120, 60));

        jLabelTextModificarEntrega.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelTextModificarEntrega.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTextModificarEntrega.setText("Modificar entrega");
        jPanelInfoEncontrada.add(jLabelTextModificarEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 100, -1));

        jLabelTextVerUbi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelTextVerUbi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTextVerUbi.setText("Ver ubicación");
        jPanelInfoEncontrada.add(jLabelTextVerUbi, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 80, 20));

        jLabelBotonModificarEntrega.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBotonModificarEntrega.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/logitransportes/logic/capaVista/imagenes/iconos/editarSMALL.png"))); // NOI18N
        jLabelBotonModificarEntrega.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabelBotonModificarEntrega.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelBotonModificarEntrega.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBotonModificarEntregaMouseClicked(evt);
            }
        });
        jPanelInfoEncontrada.add(jLabelBotonModificarEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, 100, 50));

        jLabelBotonVerUbi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBotonVerUbi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/logitransportes/logic/capaVista/imagenes/iconos/mapa.png"))); // NOI18N
        jLabelBotonVerUbi.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabelBotonVerUbi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelInfoEncontrada.add(jLabelBotonVerUbi, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 80, 60));

        jLabelTextInfoEntregas.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTextInfoEntregas.setForeground(new java.awt.Color(0, 60, 143));
        jLabelTextInfoEntregas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTextInfoEntregas.setText("Información de las entregas");

        jPanelBusqueda.setBackground(new java.awt.Color(207, 216, 220));
        jPanelBusqueda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTextCondicionesBusqueda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTextCondicionesBusqueda.setForeground(new java.awt.Color(0, 60, 143));
        jLabelTextCondicionesBusqueda.setText("Condiciones de busqueda:");
        jPanelBusqueda.add(jLabelTextCondicionesBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, 30));

        jTextFieldCondicionBusqueda.setBackground(new java.awt.Color(207, 216, 220));
        jTextFieldCondicionBusqueda.setToolTipText("Solo se puede realizar la busqueda por medio del ID.");
        jTextFieldCondicionBusqueda.setBorder(null);
        jPanelBusqueda.add(jTextFieldCondicionBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 260, 30));

        jRadioButtonTodos.setBackground(new java.awt.Color(207, 216, 220));
        jRadioButtonTodos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButtonTodos.setText("Todos");
        jPanelBusqueda.add(jRadioButtonTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jRadioButtonActivos.setBackground(new java.awt.Color(207, 216, 220));
        jRadioButtonActivos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButtonActivos.setText("Activos");
        jRadioButtonActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonActivosActionPerformed(evt);
            }
        });
        jPanelBusqueda.add(jRadioButtonActivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, -1, -1));

        jRadioButtonCompletados.setBackground(new java.awt.Color(207, 216, 220));
        jRadioButtonCompletados.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButtonCompletados.setText("Completados");
        jRadioButtonCompletados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCompletadosActionPerformed(evt);
            }
        });
        jPanelBusqueda.add(jRadioButtonCompletados, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jPanelBusqueda.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 260, 10));

        jLabelBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/logitransportes/logic/capaVista/imagenes/iconos/buscar.png"))); // NOI18N
        jLabelBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBuscarMouseClicked(evt);
            }
        });
        jPanelBusqueda.add(jLabelBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 48, 48));

        jPanelVentana.setBackground(new java.awt.Color(255, 255, 255));

        jLabelMinimizar.setBackground(new java.awt.Color(204, 204, 204));
        jLabelMinimizar.setForeground(new java.awt.Color(204, 204, 204));
        jLabelMinimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/logitransportes/logic/capaVista/imagenes/iconos/minimizar.png"))); // NOI18N
        jLabelMinimizar.setToolTipText("Minimizar ventana");
        jLabelMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabelMinimizar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jLabelMinimizarFocusGained(evt);
            }
        });
        jLabelMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinimizarMouseClicked(evt);
            }
        });

        jLabelCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/logitransportes/logic/capaVista/imagenes/iconos/cerrar.png"))); // NOI18N
        jLabelCerrar.setToolTipText("Cerrar ventana");
        jLabelCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCerrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelVentanaLayout = new javax.swing.GroupLayout(jPanelVentana);
        jPanelVentana.setLayout(jPanelVentanaLayout);
        jPanelVentanaLayout.setHorizontalGroup(
            jPanelVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVentanaLayout.createSequentialGroup()
                .addComponent(jLabelMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );
        jPanelVentanaLayout.setVerticalGroup(
            jPanelVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelMinimizar, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
            .addComponent(jLabelCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTextInfoEntregas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelVentana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanelInfoEncontrada, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jPanelBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanelVentana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabelTextInfoEntregas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jPanelBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanelInfoEncontrada, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEstadoActionPerformed

    private void jRadioButtonCompletadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCompletadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonCompletadosActionPerformed

    private void jRadioButtonActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonActivosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonActivosActionPerformed

    private void jLabelMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizarMouseClicked
        principal.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jLabelMinimizarMouseClicked

    private void jLabelCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCerrarMouseClicked
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(principal, "¿Desea salir de la plataforma?", "Salir", dialog);
        if (result == 0) {
            ((Principal) SwingUtilities.getWindowAncestor(this)).dispose();
        }
    }//GEN-LAST:event_jLabelCerrarMouseClicked

    private void jLabelMinimizarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabelMinimizarFocusGained

    }//GEN-LAST:event_jLabelMinimizarFocusGained

    private void jTableDatosEntregasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDatosEntregasMouseClicked
        obtenerDatosSeleccionado();
    }//GEN-LAST:event_jTableDatosEntregasMouseClicked

    private void jLabelBotonConductorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBotonConductorMouseClicked
        JOptionPane.showMessageDialog(null, "Conductor\n"
                + "Nombres: " + personaEncontrada.getNombres()
                + "\nApellidos: " + personaEncontrada.getApellidos()
                + "\nNo° de cedula: " + personaEncontrada.getIdentificacion()
                + "\nNo° de celular: " + personaEncontrada.getCelularContacto()
        );
    }//GEN-LAST:event_jLabelBotonConductorMouseClicked

    private void jLabelBotonInfoEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBotonInfoEmpresaMouseClicked
        JOptionPane.showMessageDialog(null, "Empresa\n"
                + "NIT: " + empresaEncontrada.getNit()
                + "\nNombre: " + empresaEncontrada.getNombre()
                + "\nNo° de celular: " + empresaEncontrada.getNumeroContactoCel()
                + "\nNo° de telefono: " + empresaEncontrada.getNumeroContactoTel()
        );
    }//GEN-LAST:event_jLabelBotonInfoEmpresaMouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
//        principal.volverAInicioTrabajador(this);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabelBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBuscarMouseClicked
        String datoABuscar = jTextFieldCondicionBusqueda.getText();
        if (datoABuscar.equalsIgnoreCase("") || datoABuscar.equalsIgnoreCase(" ")) {
            /*if (jRadioButtonTodos.isSelected()) {
                actualizarListaTrabajadoresTodos("Todos");
            } else if (jRadioButtonAdministrativos.isSelected()) {
                actualizarListaTrabajadoresTodos("Administrativo");
            } else if (jRadioButtonConductor.isSelected()) {
                actualizarListaTrabajadoresTodos("Conductor");
            } else if (true) {

            }*/
        } else {
            //ASqui se realiza la busqueda
            Entregas entregaHallada = principal.fachadaEntrega.buscarEntrega(datoABuscar);
            if (entregaHallada != null) {
                actualizarListaAdministrativos(entregaHallada);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro la entrega con el ID " + datoABuscar + ".");
            }
        }
    }//GEN-LAST:event_jLabelBuscarMouseClicked

    private void jLabelBotonModificarEntregaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBotonModificarEntregaMouseClicked
//jTextFieldFecha
        Trabajadores trabajadorBuscado = principal.fachadaTrabajador.buscarTrabajador(jTextFieldConductor.getText());
        Vehiculos vehiculoBuscado = principal.fachadaVehiculo.buscarVehiculo("2");
        Date fechaNueva = Date.valueOf(jTextFieldFecha.getText());
        if (trabajadorBuscado != null) {
            Entregas entregaEditada = new Entregas(entregaEncontrada.getIdEntrega(), fechaNueva, entregaEncontrada.getEstado(), entregaEncontrada.getEstadoIntegridad(), entregaEncontrada.getEmpresa(), trabajadorBuscado, vehiculoBuscado);
            principal.fachadaEntrega.editarEntregas(entregaEncontrada);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontro a la persona con la cedula " + jTextFieldConductor.getText());
        }

    }//GEN-LAST:event_jLabelBotonModificarEntregaMouseClicked

    AnimationClass moverElementos = new AnimationClass();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabelBotonAgregarEntrega;
    private javax.swing.JLabel jLabelBotonConductor;
    private javax.swing.JLabel jLabelBotonInfoEmpresa;
    private javax.swing.JLabel jLabelBotonModificarEntrega;
    private javax.swing.JLabel jLabelBotonVerUbi;
    private javax.swing.JLabel jLabelBuscar;
    private javax.swing.JLabel jLabelCerrar;
    private javax.swing.JLabel jLabelMinimizar;
    private javax.swing.JLabel jLabelNombresUsuario;
    private javax.swing.JLabel jLabelTextAgregarEntrega;
    private javax.swing.JLabel jLabelTextCondicionesBusqueda;
    private javax.swing.JLabel jLabelTextConductor;
    private javax.swing.JLabel jLabelTextEmpresa;
    private javax.swing.JLabel jLabelTextEstado;
    private javax.swing.JLabel jLabelTextFecha;
    private javax.swing.JLabel jLabelTextID;
    private javax.swing.JLabel jLabelTextInfoDelConductor;
    private javax.swing.JLabel jLabelTextInfoEmpresa;
    private javax.swing.JLabel jLabelTextInfoEntregas;
    private javax.swing.JLabel jLabelTextModificarEntrega;
    private javax.swing.JLabel jLabelTextVerUbi;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelBusqueda;
    private javax.swing.JPanel jPanelInfoEncontrada;
    private javax.swing.JPanel jPanelVentana;
    private javax.swing.JRadioButton jRadioButtonActivos;
    private javax.swing.JRadioButton jRadioButtonCompletados;
    private javax.swing.JRadioButton jRadioButtonTodos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTable jTableDatosEntregas;
    private javax.swing.JTextField jTextFieldCondicionBusqueda;
    private javax.swing.JTextField jTextFieldConductor;
    private javax.swing.JTextField jTextFieldEmpresa;
    private javax.swing.JTextField jTextFieldEstado;
    private javax.swing.JTextField jTextFieldFecha;
    private javax.swing.JTextField jTextFieldID;
    // End of variables declaration//GEN-END:variables

    private void actualizarListaEntregas() {
        List<Entregas> lc = principal.fachadaEntrega.listaEntregas();
        if (!lc.isEmpty()) {
            modeloTabla.setRowCount(0);
            for (int i = 0; i < lc.size(); i++) {
                Entregas aux = lc.get(i);
                String[] d = {
                    aux.getIdEntrega(),
                    aux.getFecha().toString(),
                    aux.getEstado(),
                    aux.getEstadoIntegridad().toString(),
                    aux.getEmpresa().getNit(),
                    aux.getTrabajadorIdentificacion().getIdentificacion().getIdentificacion(),
                    aux.getVehiculoPlacas().getPlacas()
                };
                modeloTabla.addRow(d);
            }
        }
    }

    private void obtenerDatosSeleccionado() {
        // Obtenemos el primer dato del renglon seleccionado
        if (jTableDatosEntregas.getSelectedRow() != -1) {
            //Obtiene cedula
            String codigo = (String) modeloTabla.getValueAt(jTableDatosEntregas.getSelectedRow(), 0);

            //Se busca la cedula en la base de datos
            entregaEncontrada = principal.fachadaEntrega.buscarEntrega(codigo);

            jTextFieldID.setText(String.valueOf(entregaEncontrada.getIdEntrega()));
            jTextFieldFecha.setText(String.valueOf(entregaEncontrada.getFecha()));
            jTextFieldEstado.setText(String.valueOf(entregaEncontrada.getEstado()));

            personaEncontrada = principal.fachadaPersona.buscarPersona(entregaEncontrada.getTrabajadorIdentificacion().getIdentificacion().getIdentificacion());
            empresaEncontrada = principal.fachadaEmpresa.buscarEmpresa(entregaEncontrada.getEmpresa().getNit());

            jTextFieldConductor.setText(personaEncontrada.getNombres() + " " + personaEncontrada.getApellidos());

            jTextFieldEmpresa.setText(String.valueOf(entregaEncontrada.getEmpresa().getNombre()));
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un renglon primero.");
        }
    }

    private void actualizarListaAdministrativos(Entregas entregaHallada) {
        modeloTabla.setRowCount(0);
        String[] d = {entregaHallada.getIdEntrega(), entregaHallada.getFecha().toString(), entregaHallada.getEstado(), entregaHallada.getEstadoIntegridad().toString(), entregaHallada.getTrabajadorIdentificacion().getIdentificacion().toString(), entregaHallada.getEmpresa().getNit()};
        modeloTabla.addRow(d);
    }
}