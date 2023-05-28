package Vista;

import Controlador.ControlUsuario;
import Modelo.Usuario;
import Utils.Recursos;
import java.awt.Image;
import java.io.File;
import java.time.LocalDate;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class frmLogin extends javax.swing.JFrame {

    int xMouse;
    int yMouse;
    
    private Clip sonido;
    private int cont = 1;
    ControlUsuario dao = new ControlUsuario();
    Recursos recursos = new Recursos();
    static Usuario u = null;
    static Usuario obj = null;

    public frmLogin() {
        initComponents();
        MostrarFondoImagen("fondoLogin");
        MostrarIconos();
        PlaySonido();
    }

    public void PlaySonido() {
        try {
            sonido = AudioSystem.getClip();
            File a = new File("src\\main\\java\\Sonidos\\login.wav");
            sonido.open(AudioSystem.getAudioInputStream(a));
            sonido.start();

        } catch (Exception tipoError) {
            System.out.println("" + tipoError);
        }
    }

    public void MostrarIconos() {
        btnSalir.setIcon(new ImageIcon(recursos.ICONO_SALIRLOGIN));
        btnIniciar.setIcon(new ImageIcon(recursos.ICONO_INICIARLOGIN));
        lblSonido.setIcon(new ImageIcon(recursos.ICONO_SONIDO_ON));
    }

    public void MostrarFondoImagen(String cadena) {
        String ruta = new File("src").getAbsolutePath();
        ruta = ruta + "\\main\\java\\Imagenes\\" + cadena + ".jpg";
        ImageIcon img = new ImageIcon(ruta);

        Image imgesc = img.getImage().getScaledInstance(lblImagenFondo.getWidth(), lblImagenFondo.getHeight(), Image.SCALE_SMOOTH);

        lblImagenFondo.setIcon(new ImageIcon(imgesc));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        btnIniciar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        lblSonido = new javax.swing.JLabel();
        lblImagenFondo = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 255));
        jLabel1.setText("Correo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, 30));

        txtCorreo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtCorreo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtCorreo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 230, 50));

        btnIniciar.setBackground(new java.awt.Color(0, 255, 0));
        btnIniciar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnIniciar.setText("Iniciar Sesión");
        btnIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 230, 50));

        jLabel3.setFont(new java.awt.Font("Matura MT Script Capitals", 1, 48)); // NOI18N
        jLabel3.setText("Iniciar Sesión");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 350, 320));

        btnSalir.setBackground(new java.awt.Color(255, 0, 0));
        btnSalir.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir del Juego");
        btnSalir.setBorder(null);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 190, 60));

        lblSonido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSonido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSonidoMouseClicked(evt);
            }
        });
        getContentPane().add(lblSonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 50));

        lblImagenFondo.setText("jLabel4");
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
        getContentPane().add(lblImagenFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed

        String correo = txtCorreo.getText();

        if (correo.trim().length() <= 0) {
            JOptionPane.showMessageDialog(null, "[ DEBES INGRESAR UN NOMBRE O APODO ]", "NOMBRE O APODO VACIO", 2);
            return;
        }

        u = dao.IniciarSesionUsuario(correo);

        if (u != null) {

            LocalDate f = LocalDate.now();
            String fecha = "" + f;

            if (!u.getNota().getFecha().equalsIgnoreCase(fecha)) {
                sonido.stop();
                frmPrincipal vista = new frmPrincipal();
                vista.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Usted ya jugó el dia de hoy, vuelva mañana");
            }

        } else {
             obj = dao.Login(correo);

            if (obj != null) {
                sonido.stop();
                frmPrincipal vista = new frmPrincipal();
                vista.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Correo incorrecto");
            }
        }


    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int res = JOptionPane.showConfirmDialog(this, "¿ Estas seguro que deseas salir del Juego ?");

        if (res == 0) {
            sonido.stop();
            frmIndex vista = new frmIndex();
            vista.setVisible(true);
            this.dispose();

        }

    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblImagenFondo;
    private javax.swing.JLabel lblSonido;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables
}
