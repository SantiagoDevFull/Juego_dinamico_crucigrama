package Vista;

import Controlador.ControlNota;
import Modelo.Nota;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class frmDocente extends javax.swing.JFrame {

    int xMouse;
    int yMouse;
    
    
    ControlNota daoNota = new ControlNota();
    ArrayList<Nota>lista=daoNota.ListarNotas();

    public frmDocente() {
        initComponents();
        Listar();
        MostrarFondoImagen("fondoDocente");
    }
    
    public void MostrarFondoImagen(String cadena) {
        String ruta = new File("src").getAbsolutePath();
        ruta = ruta + "\\main\\java\\Imagenes\\" + cadena + ".jpg";
        ImageIcon img = new ImageIcon(ruta);

        Image imgesc = img.getImage().getScaledInstance(lblImagenFondo.getWidth(), lblImagenFondo.getHeight(), Image.SCALE_SMOOTH);

        lblImagenFondo.setIcon(new ImageIcon(imgesc));
    }

    public void Listar() {
        DefaultTableModel dt = (DefaultTableModel) TABLA.getModel();
        dt.setRowCount(0);

        for (Nota obj : daoNota.ListarNotas()) {
            Object[] fila = {obj.getUsuario().getIdUsu(), obj.getUsuario().getNomUsu(), obj.getUsuario().getPatUsu(), obj.getUsuario().getMatUsu(),
                obj.getNota(), obj.getTiempo(), obj.getFecha()};
            dt.addRow(fila);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABLA = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtFiltrar = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblImagenFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro de Participantes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, -1, -1));

        TABLA.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        TABLA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "A. PATERNO", "A. MATERNO", "NOTA", "TIEMPO", "FECHA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TABLA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TABLA.setRowHeight(32);
        TABLA.setSelectionBackground(new java.awt.Color(0, 0, 255));
        TABLA.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TABLA);
        if (TABLA.getColumnModel().getColumnCount() > 0) {
            TABLA.getColumnModel().getColumn(0).setResizable(false);
            TABLA.getColumnModel().getColumn(0).setPreferredWidth(1);
            TABLA.getColumnModel().getColumn(1).setResizable(false);
            TABLA.getColumnModel().getColumn(2).setResizable(false);
            TABLA.getColumnModel().getColumn(3).setResizable(false);
            TABLA.getColumnModel().getColumn(4).setResizable(false);
            TABLA.getColumnModel().getColumn(4).setPreferredWidth(1);
            TABLA.getColumnModel().getColumn(5).setResizable(false);
            TABLA.getColumnModel().getColumn(6).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 670, 190));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Filtrar :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, -1, -1));

        txtFiltrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtFiltrar.setForeground(new java.awt.Color(0, 0, 255));
        txtFiltrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltrarKeyReleased(evt);
            }
        });
        getContentPane().add(txtFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 390, 30));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 430, 20));

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("X");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, -1, 40));

        jButton2.setBackground(new java.awt.Color(255, 255, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Ordenar Notas");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 130, -1, -1));

        lblImagenFondo.setText("jLabel3");
        lblImagenFondo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lblImagenFondoMouseDragged(evt);
            }
        });
        lblImagenFondo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblImagenFondoMousePressed(evt);
            }
        });
        getContentPane().add(lblImagenFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtFiltrarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltrarKeyReleased

        DefaultTableModel dt = (DefaultTableModel) TABLA.getModel();
        dt.setRowCount(0);

        lista.removeAll(lista);
        for (Nota obj : daoNota.ListarNotas()) {
            if (obj.getUsuario().getNomUsu().toUpperCase().contains(txtFiltrar.getText().toUpperCase()) || obj.getUsuario().getPatUsu().toUpperCase().contains(txtFiltrar.getText().toUpperCase()) || obj.getUsuario().getMatUsu().toUpperCase().contains(txtFiltrar.getText().toUpperCase()) || obj.getTiempo().contains(txtFiltrar.getText()) || obj.getFecha().contains(txtFiltrar.getText())) {
                Object[] fila = {obj.getUsuario().getIdUsu(), obj.getUsuario().getNomUsu(), obj.getUsuario().getPatUsu(), obj.getUsuario().getMatUsu(),
                    obj.getNota(), obj.getTiempo(), obj.getFecha()};
                dt.addRow(fila);
                lista.add(obj);
            }
        }

    }//GEN-LAST:event_txtFiltrarKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lblImagenFondoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenFondoMousePressed
        xMouse=evt.getX();
        yMouse=evt.getY();
    }//GEN-LAST:event_lblImagenFondoMousePressed

    private void lblImagenFondoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenFondoMouseDragged
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        
        setLocation(x-xMouse,y-yMouse);
    }//GEN-LAST:event_lblImagenFondoMouseDragged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        DefaultTableModel dt=(DefaultTableModel)TABLA.getModel();
        dt.setRowCount(0);
        Collections.sort(lista, Comparator.comparingDouble(Nota::getNota).reversed());

        // Imprimir la lista ordenada
        for (Nota obj : lista) {
            Object[]fila={obj.getUsuario().getIdUsu(), obj.getUsuario().getNomUsu(), obj.getUsuario().getPatUsu(), obj.getUsuario().getMatUsu(),
                    obj.getNota(), obj.getTiempo(), obj.getFecha()};
            dt.addRow(fila);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(frmDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDocente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TABLA;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblImagenFondo;
    private javax.swing.JTextField txtFiltrar;
    // End of variables declaration//GEN-END:variables
}
