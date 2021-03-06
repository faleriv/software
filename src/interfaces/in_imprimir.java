/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import codigo.Funciones;
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
public class in_imprimir extends javax.swing.JFrame {

    /**
     * Creates new form in_imprimir
     */
    static ResultSet rs;
    Funciones fu = new Funciones();
    public in_imprimir() {
        initComponents();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//cuando se cierra la ventana se acabe el programa
        setTitle("SIGEB | Impresión reporte"); //Poner el título
        //this.setLocation(500,100); //posición inicial de la ventana. Pongo lo que yo quiero
        this.setLocationRelativeTo(null); //posición en el centro de la pantalla
        this.in_jPRUC.setVisible(false);
//        this.in_jTBGenerar.setEnabled(false);
    }
    public void CargaTabla(String sentencia, int valor, String[] cabecera){
        //1--->cabecera con ruc //2-->cabecera sin ruc
        DefaultTableModel modelo = new DefaultTableModel(null,cabecera);
        rs=conexion.Conexion.consulta(sentencia);
        Vector v = new Vector();
        try{
        if(valor==1){
            while(rs.next()){
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));   
                modelo.addRow(v);
                this.in_jTImpresion.setModel(modelo);
            }
        }else if (valor ==2){
            while(rs.next()){
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                modelo.addRow(v);
                this.in_jTImpresion.setModel(modelo);
            }
        }
    }   catch (SQLException ex) {
            Logger.getLogger(in_imprimir.class.getName()).log(Level.SEVERE, null, ex);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jRDisponible = new javax.swing.JRadioButton();
        jRArriendo = new javax.swing.JRadioButton();
        jRMantenimiento = new javax.swing.JRadioButton();
        jRDañados = new javax.swing.JRadioButton();
        in_jPRUC = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        in_jTRuc = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jToggleButton2 = new javax.swing.JToggleButton();
        jTBImprimir = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        in_jTImpresion = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        in_jTBGenerar = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jRDisponible.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jRDisponible.setText("Equipos disponibles");
        jRDisponible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRDisponibleActionPerformed(evt);
            }
        });

        jRArriendo.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jRArriendo.setText("Equipos arrendados por un cliente");
        jRArriendo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRArriendoActionPerformed(evt);
            }
        });

        jRMantenimiento.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jRMantenimiento.setText("Equipos en mantenimiento");
        jRMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRMantenimientoActionPerformed(evt);
            }
        });

        jRDañados.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jRDañados.setText("Equipos dañados");
        jRDañados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRDañadosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setText("Número de ruc:");

        in_jTRuc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                in_jTRucFocusLost(evt);
            }
        });
        in_jTRuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                in_jTRucActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout in_jPRUCLayout = new javax.swing.GroupLayout(in_jPRUC);
        in_jPRUC.setLayout(in_jPRUCLayout);
        in_jPRUCLayout.setHorizontalGroup(
            in_jPRUCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(in_jPRUCLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(in_jTRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        in_jPRUCLayout.setVerticalGroup(
            in_jPRUCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, in_jPRUCLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(in_jPRUCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(in_jTRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jToggleButton2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jToggleButton2.setText("Retornar");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jTBImprimir.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jTBImprimir.setText("Imprimir");
        jTBImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTBImprimirActionPerformed(evt);
            }
        });

        in_jTImpresion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(in_jTImpresion);

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel7.setText("Información a imprimir en el reporte:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTBImprimir)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton2))
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton2)
                    .addComponent(jTBImprimir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        in_jTBGenerar.setText("Generar");
        in_jTBGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                in_jTBGenerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(in_jPRUC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(89, 89, 89))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRDisponible)
                            .addComponent(jRArriendo)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jRDañados)
                                .addGap(18, 18, 18)
                                .addComponent(in_jTBGenerar)))
                        .addContainerGap(200, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jRMantenimiento)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRArriendo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(in_jPRUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRDisponible)
                .addGap(2, 2, 2)
                .addComponent(jRMantenimiento)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRDañados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(in_jTBGenerar)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel5.setText("Rol:");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel6.setText("Imprimir un reporte que contenga:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(167, 167, 167)
                    .addComponent(jLabel5)
                    .addContainerGap(118, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(139, 139, 139)
                    .addComponent(jLabel5)
                    .addContainerGap(295, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRDañadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRDañadosActionPerformed
        // TODO add your handling code here:
        if(this.jRDañados.isSelected()){
            this.in_jPRUC.setVisible(false);
            this.jRArriendo.setSelected(false);
            this.jRDisponible.setSelected(false);
            this.jRMantenimiento.setSelected(false);
        }  
    }//GEN-LAST:event_jRDañadosActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        menPrinci mp = new menPrinci();
        mp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jTBImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTBImprimirActionPerformed
fu.imprimirTabla(in_jTImpresion,"Reporte Equipos","THEBLOOP", true);        // TODO add your handling code here:

    }//GEN-LAST:event_jTBImprimirActionPerformed

    private void jRArriendoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRArriendoActionPerformed
        if(this.jRArriendo.isSelected()){
            this.in_jPRUC.setVisible(true);
            this.jRDañados.setSelected(false);
            this.jRDisponible.setSelected(false);
            this.jRMantenimiento.setSelected(false);
        }
    }//GEN-LAST:event_jRArriendoActionPerformed

    private void jRDisponibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRDisponibleActionPerformed
        if(this.jRDisponible.isSelected()){
            this.in_jPRUC.setVisible(false);
            this.jRArriendo.setSelected(false);
            this.jRDañados.setSelected(false);
            this.jRMantenimiento.setSelected(false);
        }
    }//GEN-LAST:event_jRDisponibleActionPerformed

    private void jRMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRMantenimientoActionPerformed
        if(this.jRMantenimiento.isSelected()){
            this.in_jPRUC.setVisible(false);
            this.jRArriendo.setSelected(false);
            this.jRDañados.setSelected(false);
            this.jRDisponible.setSelected(false);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jRMantenimientoActionPerformed

    private void in_jTRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_in_jTRucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_in_jTRucActionPerformed

    private void in_jTRucFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_in_jTRucFocusLost
       boolean resultado=fu.ValidacionRUC(this.in_jTRuc.getText());
       if(!resultado){
           JOptionPane.showMessageDialog(null, "Nuúmero de RUC invalido", "Error Ingreso RUC", JOptionPane.ERROR_MESSAGE);
           this.in_jTRuc.requestFocus();
       }else{
           this.in_jTBGenerar.requestFocus();
       }
    }//GEN-LAST:event_in_jTRucFocusLost

    private void in_jTBGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_in_jTBGenerarActionPerformed
        String sentencia = null;
        String cabecera1[]={"RUC","Código de equipo","Nombre de equipo","Estado de equipo"};
        String cabecera2[]={"Código de equipo","Nombre de equipo","Estado de equipo"};
        if(!this.jRArriendo.isSelected()&&!this.jRDañados.isSelected()&&!this.jRDisponible.isSelected()&&!this.jRMantenimiento.isSelected()){
        JOptionPane.showMessageDialog(null, "Seleccione una opcion", "Error Generacion", JOptionPane.ERROR_MESSAGE);
        }else{
        if(this.jRArriendo.isSelected()){
            sentencia = "select ruc,cod_equipo,nombre_equipo, estado_equipo from Equipo where ruc ='"+this.in_jTRuc.getText()+"'";
            this.CargaTabla(sentencia,1, cabecera1);
        }else{
           if(this.jRDisponible.isSelected()){
               sentencia = "select cod_equipo,nombre_equipo, estado_equipo from Equipo where estado_equipo ='Disponible'";
           }else if (this.jRMantenimiento.isSelected()){
               sentencia = "select cod_equipo,nombre_equipo, estado_equipo from Equipo where estado_equipo ='Mantenimiento'";
           }else if(this.jRDañados.isSelected()){
               sentencia = "select cod_equipo,nombre_equipo, estado_equipo from Equipo where estado_equipo ='Dañado'";
           }
           this.CargaTabla(sentencia, 2, cabecera2);
            
        }
        }
    }//GEN-LAST:event_in_jTBGenerarActionPerformed

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
            java.util.logging.Logger.getLogger(in_imprimir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(in_imprimir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(in_imprimir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(in_imprimir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new in_imprimir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JPanel in_jPRUC;
    private javax.swing.JToggleButton in_jTBGenerar;
    private javax.swing.JTable in_jTImpresion;
    private javax.swing.JTextField in_jTRuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRArriendo;
    private javax.swing.JRadioButton jRDañados;
    private javax.swing.JRadioButton jRDisponible;
    private javax.swing.JRadioButton jRMantenimiento;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jTBImprimir;
    private javax.swing.JToggleButton jToggleButton2;
    // End of variables declaration//GEN-END:variables
}
