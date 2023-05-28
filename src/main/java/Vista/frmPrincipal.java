package Vista;

import Modelo.Usuario;
import Utils.Recursos;
import java.awt.Image;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class frmPrincipal extends javax.swing.JFrame {

    int xMouse;
    int yMouse;
    
    private int cont = 1;
    Clip sonido;
    Recursos recursos = new Recursos();

    public static Usuario usu=null;
    
    public frmPrincipal() {
        initComponents();

        if(frmLogin.u!=null){
            usu=frmLogin.u;
        }else{
            usu=frmLogin.obj;
        }
        
        MostrarDatosUsuario();
        MostrarIconos();
        MostrarImagenFondo("fondoImagenPrincipal");
        PlaySonido();
    }

    public void PlaySonido() {
        try {
            sonido = AudioSystem.getClip();
            File a = new File("src\\main\\java\\Sonidos\\principal.wav");
            sonido.open(AudioSystem.getAudioInputStream(a));
            sonido.start();

        } catch (Exception tipoError) {
            System.out.println("" + tipoError);
        }
    }

    public void MostrarDatosUsuario() {
        if(frmLogin.u!=null){
            lblNombre.setText("" + frmLogin.u.getNomUsu().toUpperCase()+" "+frmLogin.u.getPatUsu().toUpperCase()+" "+frmLogin.u.getMatUsu().toUpperCase());
        }else{
            lblNombre.setText("" + frmLogin.obj.getNomUsu().toUpperCase()+" "+frmLogin.obj.getPatUsu().toUpperCase()+" "+frmLogin.obj.getMatUsu().toUpperCase());
        } 
    }

    public void MostrarIconos() {
        btnSalir.setIcon(new ImageIcon(recursos.ICONO_SALIRLOGIN));
        btnInstrucciones.setIcon(new ImageIcon(recursos.ICONO_INSTRUCCIONES));
        lblSonido.setIcon(new ImageIcon(recursos.ICONO_SONIDO_ON));
    }

    public void MostrarImagenFondo(String cadena) {
        String ruta = new File("src").getAbsolutePath();
        ruta = ruta + "\\main\\java\\Imagenes\\" + cadena + ".jpg";
        ImageIcon img = new ImageIcon(ruta);

        Image imgesc = img.getImage().getScaledInstance(lblFondoImagen.getWidth(), lblFondoImagen.getHeight(), Image.SCALE_SMOOTH);

        lblFondoImagen.setIcon(new ImageIcon(imgesc));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBasico = new javax.swing.JButton();
        btnIntermedio = new javax.swing.JButton();
        btnAvanzado = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        btnInstrucciones = new javax.swing.JButton();
        lblSonido = new javax.swing.JLabel();
        lblFondoImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBasico.setBackground(new java.awt.Color(51, 255, 204));
        btnBasico.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        btnBasico.setForeground(new java.awt.Color(0, 0, 255));
        btnBasico.setText("BASICO");
        btnBasico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBasico.setEnabled(false);
        btnBasico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBasicoActionPerformed(evt);
            }
        });
        getContentPane().add(btnBasico, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, 150, -1));

        btnIntermedio.setBackground(new java.awt.Color(51, 255, 204));
        btnIntermedio.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        btnIntermedio.setForeground(new java.awt.Color(0, 0, 255));
        btnIntermedio.setText("INTERMEDIO");
        btnIntermedio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIntermedio.setEnabled(false);
        btnIntermedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIntermedioActionPerformed(evt);
            }
        });
        getContentPane().add(btnIntermedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, -1, -1));

        btnAvanzado.setBackground(new java.awt.Color(51, 255, 204));
        btnAvanzado.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        btnAvanzado.setForeground(new java.awt.Color(0, 0, 255));
        btnAvanzado.setText("AVANZADO");
        btnAvanzado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAvanzado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAvanzado, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 430, -1, -1));

        jLabel1.setFont(new java.awt.Font("Britannic Bold", 1, 50)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 51));
        jLabel1.setText("BIENVENIDO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, 60));

        lblNombre.setFont(new java.awt.Font("Britannic Bold", 1, 50)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(0, 255, 51));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 960, 60));

        btnSalir.setBackground(new java.awt.Color(255, 0, 0));
        btnSalir.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir del Juego");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, -1, 50));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Niveles disponibles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Leelawadee UI Semilight", 1, 16), new java.awt.Color(255, 255, 0))); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 510, 100));

        btnInstrucciones.setBackground(new java.awt.Color(255, 204, 204));
        btnInstrucciones.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        btnInstrucciones.setText("Instrucciones");
        btnInstrucciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInstrucciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInstruccionesActionPerformed(evt);
            }
        });
        getContentPane().add(btnInstrucciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 560, 210, 50));

        lblSonido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSonido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSonidoMouseClicked(evt);
            }
        });
        getContentPane().add(lblSonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 50));

        lblFondoImagen.setText("jLabel2");
        lblFondoImagen.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lblFondoImagenMouseDragged(evt);
            }
        });
        lblFondoImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblFondoImagenMousePressed(evt);
            }
        });
        getContentPane().add(lblFondoImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 620));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed

        int res = JOptionPane.showConfirmDialog(this, "¿ Estás seguro que deseas salir ?");

        if (res == 0) {
            frmLogin.u=null;
            usu=null;
            sonido.stop();
            frmLogin vista = new frmLogin();
            vista.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "!! GRACIAS POR QUEDARTE !!");
        }

    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBasicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBasicoActionPerformed
        sonido.stop();
        
        
    }//GEN-LAST:event_btnBasicoActionPerformed

    private void btnAvanzadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzadoActionPerformed

        int res = JOptionPane.showConfirmDialog(this, "En este juego al momento de Aceptar se iniciará un cronómetro ¿ ESTÁS LISTO ?");

        if (res == 0) {
            sonido.stop();
            frmCrucigrama vista = new frmCrucigrama();
            vista.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnAvanzadoActionPerformed

    private void btnIntermedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIntermedioActionPerformed
        sonido.stop();
       
        

    }//GEN-LAST:event_btnIntermedioActionPerformed

    private void btnInstruccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstruccionesActionPerformed
        frmInstruccionesPrincipal vista = new frmInstruccionesPrincipal();
        vista.setVisible(true);

    }//GEN-LAST:event_btnInstruccionesActionPerformed

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

    private void lblFondoImagenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFondoImagenMousePressed
       xMouse=evt.getX();
       yMouse=evt.getY();
    }//GEN-LAST:event_lblFondoImagenMousePressed

    private void lblFondoImagenMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFondoImagenMouseDragged
       int x=evt.getXOnScreen();
       int y=evt.getYOnScreen();
        setLocation(x-xMouse,y-yMouse);
    }//GEN-LAST:event_lblFondoImagenMouseDragged

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
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAvanzado;
    private javax.swing.JButton btnBasico;
    private javax.swing.JButton btnInstrucciones;
    private javax.swing.JButton btnIntermedio;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblFondoImagen;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSonido;
    // End of variables declaration//GEN-END:variables
}
