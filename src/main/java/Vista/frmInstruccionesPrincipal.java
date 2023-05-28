package Vista;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;

public class frmInstruccionesPrincipal extends javax.swing.JFrame {

    int xMouse;
    int yMouse;
    
    public frmInstruccionesPrincipal() {
        initComponents();
        Mostrar1("fondoInstrucciones");
    }

    public void Mostrar1(String cadena) {
        String ruta = new File("src").getAbsolutePath();
        ruta = ruta + "\\main\\java\\Imagenes\\" + cadena + ".png";
        ImageIcon img = new ImageIcon(ruta);

        Image imgesc = img.getImage().getScaledInstance(lblImagenFondo.getWidth(), lblImagenFondo.getHeight(), Image.SCALE_SMOOTH);

        lblImagenFondo.setIcon(new ImageIcon(imgesc));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        lblImagenFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButton1.setText("X");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 670, 60, 40));

        lblImagenFondo.setText("jLabel1");
        lblImagenFondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
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
        getContentPane().add(lblImagenFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1278, 725));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmInstruccionesPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmInstruccionesPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmInstruccionesPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmInstruccionesPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmInstruccionesPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblImagenFondo;
    // End of variables declaration//GEN-END:variables
}
