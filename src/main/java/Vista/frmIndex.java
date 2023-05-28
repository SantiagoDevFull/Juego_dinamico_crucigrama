package Vista;

import Controlador.ControlNota;
import Controlador.ControlUsuario;
import Modelo.Nota;
import Modelo.Usuario;
import Utils.Recursos;
import java.applet.AudioClip;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.plaf.OptionPaneUI;

public class frmIndex extends javax.swing.JFrame {

    int xMouse;
    int yMouse;
    
    int re;
    private int cont = 1;
    private Clip sonido;
    private ControlUsuario dao = new ControlUsuario();
    private ControlNota daoNota = new ControlNota();
    private Recursos recursos = new Recursos();

    public frmIndex() {
        initComponents();
        MostrarIconos();
        MostrarFondoImagen("fondoIndex");
        PlaySonido();

    }

    public void PlaySonido() {
        try {
            sonido = AudioSystem.getClip();
            File a = new File("src\\main\\java\\Sonidos\\index.wav");
            sonido.open(AudioSystem.getAudioInputStream(a));
            sonido.start();

        } catch (Exception tipoError) {
            System.out.println("" + tipoError);
        }
    }

    public void MostrarIconos() {
        btnJugar.setIcon(new ImageIcon(recursos.ICONO_PLAY));
        btnSalir.setIcon(new ImageIcon(recursos.ICONO_SALIR));
        btnCreditos.setIcon(new ImageIcon(recursos.ICONO_CREDITOS));
        lblSonido.setIcon(new ImageIcon(recursos.ICONO_SONIDO_ON));
    }

    public void MostrarFondoImagen(String cadena) {
        String ruta = new File("src").getAbsolutePath();
        ruta = ruta + "\\main\\java\\Imagenes\\" + cadena + ".jpg";
        ImageIcon img = new ImageIcon(ruta);

        Image imgesc = img.getImage().getScaledInstance(lblimagenfondo.getWidth(), lblimagenfondo.getHeight(), Image.SCALE_SMOOTH);

        lblimagenfondo.setIcon(new ImageIcon(imgesc));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnJugar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnCreditos = new javax.swing.JButton();
        lblSonido = new javax.swing.JLabel();
        btnRegistrados = new javax.swing.JButton();
        lblimagenfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Gloucester MT Extra Condensed", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(218, 133, 102));
        jLabel1.setText("Matemáticas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, -1));

        btnJugar.setBackground(new java.awt.Color(0, 255, 51));
        btnJugar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnJugar.setText("JUGAR");
        btnJugar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });
        getContentPane().add(btnJugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 280, 130));

        btnSalir.setBackground(new java.awt.Color(255, 0, 0));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, 280, 130));

        btnCreditos.setBackground(new java.awt.Color(0, 0, 255));
        btnCreditos.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        btnCreditos.setText("CREDITOS");
        btnCreditos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreditosActionPerformed(evt);
            }
        });
        getContentPane().add(btnCreditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 280, 130));

        lblSonido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSonido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSonidoMouseClicked(evt);
            }
        });
        getContentPane().add(lblSonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 50));

        btnRegistrados.setBackground(new java.awt.Color(255, 255, 51));
        btnRegistrados.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnRegistrados.setText("Usuarios registrados");
        btnRegistrados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistradosActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 510, -1, -1));

        lblimagenfondo.setText("jLabel2");
        lblimagenfondo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lblimagenfondoMouseDragged(evt);
            }
        });
        lblimagenfondo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblimagenfondoMousePressed(evt);
            }
        });
        getContentPane().add(lblimagenfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int res = JOptionPane.showConfirmDialog(this, "¿Estas seguro que deseas salir del Juego?");

        if (res == 0) {
            JOptionPane.showMessageDialog(null, "VUELVE PRONTO PARA SEGUIR JUGANDO", "Saliendo ...", 1);
            System.exit(0);
        }


    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        sonido.stop();
        frmLogin vista = new frmLogin();
        vista.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnJugarActionPerformed

    private void btnCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreditosActionPerformed
        frmCreditos vista = new frmCreditos();
        vista.setVisible(true);

    }//GEN-LAST:event_btnCreditosActionPerformed

    private void lblSonidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSonidoMouseClicked

        if (cont % 2 != 0) {
            lblSonido.setIcon(new ImageIcon(recursos.ICONO_SONIDO_OFF));
            sonido.stop();
        } else {
            lblSonido.setIcon(new ImageIcon(recursos.ICONO_SONIDO_ON));
            sonido.start();
        }

        cont++;

    }//GEN-LAST:event_lblSonidoMouseClicked

    private void btnRegistradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistradosActionPerformed

        String res = JOptionPane.showInputDialog("INGRESAR CLAVE");
        re = Integer.parseInt(res);

        if (re == 123456) {

           frmDocente frm=new frmDocente();
           frm.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "CLAVE INCORRECTA");
        }

    }//GEN-LAST:event_btnRegistradosActionPerformed

    private void lblimagenfondoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblimagenfondoMousePressed
        xMouse=evt.getX();
        yMouse=evt.getY();
    }//GEN-LAST:event_lblimagenfondoMousePressed

    private void lblimagenfondoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblimagenfondoMouseDragged
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        
        setLocation(x-xMouse,y-yMouse);
    }//GEN-LAST:event_lblimagenfondoMouseDragged

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
            java.util.logging.Logger.getLogger(frmIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmIndex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreditos;
    private javax.swing.JButton btnJugar;
    private javax.swing.JButton btnRegistrados;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblSonido;
    private javax.swing.JLabel lblimagenfondo;
    // End of variables declaration//GEN-END:variables
}
