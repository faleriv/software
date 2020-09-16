/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import codigo.Funciones;
import conexion.Conexion;
import conexion.Procedimientos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author valer
 */
public class cl_consultar extends javax.swing.JFrame {

    static ResultSet res;
    
    mcp_registrarContrato mrc;
    public String codigo;
    public String estado;
    boolean es_arrendado;
    /**
     * Creates new form Consultar_Cliente
     */
    
         
    public cl_consultar(int valor)
    {
        initComponents();
        this.setLocationRelativeTo(null);
        iniciarComponetes(valor);
        mrc = new mcp_registrarContrato();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
       
    }
    public void cargarTabla(String query) throws SQLException
    {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);
        res = conexion.Conexion.consulta(query);
        try
        {
            while(res.next())
            {
                Vector v = new Vector();
                v.add(res.getString(1));
                v.add(res.getString(2));
                v.add(res.getString(3));
                v.add(res.getString(4));
                v.add(res.getString(5));
                v.add(res.getString(6));
                v.add(res.getString(7));
                v.add(res.getString(8));
                v.add(res.getString(9));
                v.add(res.getString(10));
                modelo.addRow(v);
                jTable1.setModel(modelo);
                
            }
        }
        catch(SQLException e)
        {
        
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void iniciarComponetes(int value)
    {
        //cliente|consultar ->0
        //cliente|editar ->1
        //contrato | crear contrato -->2
        //3-> cambia de estado un equipo
        switch (value)
        {
                case 0:
                    jButton_seleccionar.setVisible(false);
                    cl_jL_cliente.setVisible(false);
                    cl_jTB_crearContrato.setVisible(false);
                    setTitle("SIGEB | Consulta cliente");
                    cambia_estado_boton.setVisible(false);
                    cl_jL_cliente1.setVisible(false);
                break;
                case 1:
                    jButton_seleccionar.setVisible(true);
                    cl_jL_cliente.setVisible(false);
                    cl_jTB_crearContrato.setVisible(false);
                    cambia_estado_boton.setVisible(false);
                    cl_jL_cliente1.setVisible(false);
                    setTitle("SIGEB | Actualización cliente");
                break;
                case 2:
                    //crear contrato
                    
                    jButton_seleccionar.setVisible(true);
                    cl_jL_cliente.setVisible(true);
                    cl_jTB_crearContrato.setVisible(true);
                    jButton_seleccionar.setVisible(false);
                    cambia_estado_boton.setVisible(false);
                    cl_jL_cliente1.setVisible(false);
                    setTitle("SIGEB | Creación contrato | Selección cliente");
                break;
                case 3:
                    //cambiar estado
                    cl_jL_cliente1.setVisible(false);
                    cambia_estado_boton.setVisible(true);
                    jButton_seleccionar.setVisible(false);                   
                    cl_jL_cliente.setVisible(false);
                    cl_jL_cliente1.setVisible(false);
                    cl_jTB_crearContrato.setVisible(false);
                    

                    setTitle("SIGEB | Selección dueño o arrendatario del equipo");
        }
    
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cl_jTF_buscar = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton_seleccionar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        cl_jL_cliente = new javax.swing.JLabel();
        cl_jTB_crearContrato = new javax.swing.JToggleButton();
        cl_jCB_ruc = new javax.swing.JComboBox<>();
        cambia_estado_boton = new javax.swing.JToggleButton();
        cl_jL_cliente1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cl_jTF_buscar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        cl_jTF_buscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cl_jTF_buscarFocusLost(evt);
            }
        });
        cl_jTF_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cl_jTF_buscarActionPerformed(evt);
            }
        });

        jToggleButton1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jToggleButton1.setText("Buscar");
        jToggleButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "RUC", "Empresa", "Nombres Representante", "Apellidos Representante", "Teléfono Conv", "Celular", "Provincia", "Ciudad", "Parroquia", "Estado"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setText("Seleccione el campo de búsqueda:");

        jButton_seleccionar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton_seleccionar.setText("Seleccionar");
        jButton_seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_seleccionarActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton1.setText("Regresar");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cl_jL_cliente.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        cl_jL_cliente.setText("Seleccione un cliente a quien se prestará el servicio");

        cl_jTB_crearContrato.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        cl_jTB_crearContrato.setText("Siguiente");
        cl_jTB_crearContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cl_jTB_crearContratoActionPerformed(evt);
            }
        });

        cl_jCB_ruc.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        cl_jCB_ruc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ruc", "Nombre Representante", "Nombre Empresa", "Estado Activo", "Estado Inactivo" }));
        cl_jCB_ruc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cl_jCB_rucItemStateChanged(evt);
            }
        });
        cl_jCB_ruc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cl_jCB_rucActionPerformed(evt);
            }
        });

        cambia_estado_boton.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        cambia_estado_boton.setText("Seleccionar");
        cambia_estado_boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambia_estado_botonActionPerformed(evt);
            }
        });

        cl_jL_cliente1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        cl_jL_cliente1.setText("Seleccione un cliente para realizar el contrato");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cambia_estado_boton)
                        .addGap(18, 18, 18)
                        .addComponent(cl_jTB_crearContrato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_seleccionar)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cl_jCB_ruc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cl_jTF_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cl_jL_cliente)
                            .addComponent(cl_jL_cliente1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cl_jL_cliente1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cl_jL_cliente)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(cl_jCB_ruc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cl_jTF_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_seleccionar)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cl_jTB_crearContrato)
                    .addComponent(cambia_estado_boton)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        int item = cl_jCB_ruc.getSelectedIndex();
        String campo ="";
        switch (item)
        {
            case 0:
                campo = "select * from cliente where ruc= '"+cl_jTF_buscar.getText()+"'";
                break;
            case 1:
                campo = "select * from cliente where nombre_representate= '"+cl_jTF_buscar.getText()+"'";
                break;
            case 2:
                campo = "select * from cliente where nombre_empresa= '"+cl_jTF_buscar.getText()+"'";
                break;
            case 3:
                campo = "select * from cliente where estado= 'activo'";
                break;
            case 4:
                campo = "select * from cliente where estado= 'inactivo'";
                break;
        }
        try {
            if(!campo.isEmpty())
                cargarTabla(campo);
            
        } catch (SQLException ex) {
            Logger.getLogger(cl_consultar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        menPrinci mp = new menPrinci();
        mp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton_seleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_seleccionarActionPerformed
        // TODO add your handling code here:
        //ACTUALIZAR
        //1 --> registrar
        //2 --> actualizar
        cl_registrar clr = new cl_registrar(2);
        clr.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton_seleccionarActionPerformed

    private void cl_jTB_crearContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cl_jTB_crearContratoActionPerformed
        // TODO add your handling code here:
        Procedimientos pr = new Procedimientos();
        
        int fila = jTable1.getSelectedRow();
        //consulta si el cliente tiene equipos
        
        if (fila != -1)
        {
            String ruc=jTable1.getModel().getValueAt(fila, 0).toString();
            if (pr.consultarSiExiste("ruc","equipo",ruc))
            {
                String valor=jTable1.getModel().getValueAt(fila, 0).toString();
                this.mrc.mcp_jTF_ruc.setText(valor);
                this.mrc.setVisible(true);
                this.setVisible(false);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "El cliente seleccionado no tiene equipos vendidos o arrendados. No se puede realizar un contrato con el mismo");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Error, seleccione una fila");
        }
        
        
    }//GEN-LAST:event_cl_jTB_crearContratoActionPerformed

    private void cl_jCB_rucItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cl_jCB_rucItemStateChanged
        // TODO add your handling code here:
      
    }//GEN-LAST:event_cl_jCB_rucItemStateChanged

    private void cl_jCB_rucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cl_jCB_rucActionPerformed
        // TODO add your handling code here:
      
        if (cl_jCB_ruc.getSelectedIndex() == 3 || cl_jCB_ruc.getSelectedIndex() == 4 )
        {
            cl_jTF_buscar.setEnabled(false);
        }
        else
            cl_jTF_buscar.setEnabled(true);
        
    }//GEN-LAST:event_cl_jCB_rucActionPerformed

    private void cl_jTF_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cl_jTF_buscarActionPerformed
    
    }//GEN-LAST:event_cl_jTF_buscarActionPerformed

    private void cambia_estado_botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambia_estado_botonActionPerformed
        // TODO add your handling code here:
        String ruc = jTable1.getModel().getValueAt(jTable1.getSelectedRow(),0).toString();
        if(jTable1.getSelectedRow()!= -1)
        {
            try {
                Procedimientos pr = new Procedimientos();
                pr.actualizarEquipo(codigo, estado, ruc);
                JOptionPane.showMessageDialog(null,"Equipo actualizado exitosamente");
                menPrinci mp = new menPrinci();
                mp.setVisible(true);
                this.setVisible(false);
                if(es_arrendado)
                    JOptionPane.showMessageDialog(null, "Genere un contrato con el cliente arrendatario de los equipos");
                
                
            } catch (SQLException ex) {
                Logger.getLogger(cl_consultar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Error, seleccione un cliente");
    }//GEN-LAST:event_cambia_estado_botonActionPerformed

    private void cl_jTF_buscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cl_jTF_buscarFocusLost
        // TODO add your handling code here:
        String condicion = this.cl_jCB_ruc.getSelectedItem().toString();
    Funciones fu = new Funciones();
    boolean resultado;
    switch (condicion){
        case "Ruc":
            resultado=fu.ValidacionRUC(this.cl_jTF_buscar.getText());
            if(!resultado){
                JOptionPane.showMessageDialog(null,"El Ruc Ingresado es incorrecto. Ingreselo nuevamente");
                this.cl_jTF_buscar.setText("");
            }
            break;
        case "Nombre Representante":
          resultado = fu.ValidacionNombreNumero(this.cl_jTF_buscar.getText(),1);
          resultado = fu.ValidacionNombreCaracteres(this.cl_jTF_buscar.getText());
          if(!resultado){
              JOptionPane.showMessageDialog(null,"El Nombre del Representante es incorrecto. Ingreselo nuevamente");
              this.cl_jTF_buscar.setText("");
          }
          break;
        case "Nombre Empresa":
          resultado = fu.ValidacionNombreNumero(this.cl_jTF_buscar.getText(),0);
          
          if(!resultado){
              JOptionPane.showMessageDialog(null,"El Nombre de la Empresa es incorrecto. Ingreselo nuevamente");
              this.cl_jTF_buscar.setText("");
          }
          break;
          
    }
        
    }//GEN-LAST:event_cl_jTF_buscarFocusLost

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
            java.util.logging.Logger.getLogger(cl_consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cl_consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cl_consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cl_consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cl_consultar(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton cambia_estado_boton;
    private javax.swing.JComboBox<String> cl_jCB_ruc;
    private javax.swing.JLabel cl_jL_cliente;
    private javax.swing.JLabel cl_jL_cliente1;
    private javax.swing.JToggleButton cl_jTB_crearContrato;
    private javax.swing.JTextField cl_jTF_buscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_seleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
