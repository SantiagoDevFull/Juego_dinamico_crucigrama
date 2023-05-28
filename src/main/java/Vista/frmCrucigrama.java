package Vista;

import Controlador.ControlNota;
import Controlador.ControlPregunta;
import Controlador.ControlUsuario;
import Modelo.Nota;
import Modelo.Pregunta;
import Modelo.Usuario;
import Utils.Recursos;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class frmCrucigrama extends javax.swing.JFrame {

    int xMouse;
    int yMouse;
    
    private Random random = new Random();

    private Recursos recursos = new Recursos();
    private ControlUsuario dao = new ControlUsuario();
    private ControlPregunta daoPre = new ControlPregunta();
    private ControlNota daoNota = new ControlNota();

    private Usuario u = null;

    private String pregunta1 = "";
    private String pregunta2 = "";
    private String pregunta3 = "";
    private String pregunta4 = "";
    private String pregunta5 = "";
    private String pregunta6 = "";
    private String pregunta7 = "";
    private String pregunta8 = "";

    private Pregunta P1 = null;
    private Pregunta P2 = null;
    private Pregunta P3 = null;
    private Pregunta P4 = null;
    private Pregunta P5 = null;
    private Pregunta P6 = null;
    private Pregunta P7 = null;
    private Pregunta P8 = null;

    private ArrayList<Pregunta> PreguntaUno = daoPre.ListarPreguntas(1);
    private ArrayList<Pregunta> PreguntaDos = daoPre.ListarPreguntas(2);
    private ArrayList<Pregunta> PreguntaTres = daoPre.ListarPreguntas(3);
    private ArrayList<Pregunta> PreguntaCuatro = daoPre.ListarPreguntas(4);
    private ArrayList<Pregunta> PreguntaCinco = daoPre.ListarPreguntas(5);
    private ArrayList<Pregunta> PreguntaSeis = daoPre.ListarPreguntas(6);
    private ArrayList<Pregunta> PreguntaSiete = daoPre.ListarPreguntas(7);
    private ArrayList<Pregunta> PreguntaOcho = daoPre.ListarPreguntas(8);

    private Timer tiempo;
    private int centesimas_segundos = 0;
    private int segundos = 0;
    private int minutos = 0;
    private int horas = 0;

    public frmCrucigrama() {
        initComponents();
        u = frmPrincipal.usu;

        lblUsuarioNombre.setText(u.getNomUsu() + " " + u.getPatUsu() + " " + u.getMatUsu());

        MostrarImagenFondo("fondoCrucigrama");
        GenerarPreguntas();
        MostrarPreguntas();
        tiempo = new Timer(10, acciones);

        tiempo.start();
        btnIniciar.setText("Finalizar");
        btnSalir.setEnabled(false);

        MostrarIconos();
    }

    public void ActualizarCronometro() {

        String texto = (horas <= 9 ? "0" : "") + horas + ":" + (minutos <= 9 ? "0" : "") + minutos + ":" + (segundos <= 9 ? "0" : "") + segundos + ":" + (centesimas_segundos <= 9 ? "0" : "") + centesimas_segundos;
        lblReloj.setText(texto);

    }

    public void MostrarIconos() {
        btnSalir.setIcon(new ImageIcon(recursos.ICONO_SALIRLOGIN));
    }

    private ActionListener acciones = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {

            centesimas_segundos++;
            if (centesimas_segundos == 100) {
                segundos++;
                centesimas_segundos = 0;
            }

            if (segundos == 60) {
                minutos++;
                segundos = 0;
            }

            if (minutos == 60) {
                horas++;
                minutos = 0;
            }

            if (horas == 24) {
                horas = 0;
            }
            ActualizarCronometro();
        }

    };



    public void GenerarPreguntas() {

        int indice1 = random.nextInt(PreguntaUno.size());
        P1 = new Pregunta();
        P1 = PreguntaUno.get(indice1);

        int indice2 = random.nextInt(PreguntaDos.size());
        P2 = new Pregunta();
        P2 = PreguntaDos.get(indice2);

        int indice3 = random.nextInt(PreguntaTres.size());
        P3 = new Pregunta();
        P3 = PreguntaTres.get(indice3);

        int indice4 = random.nextInt(PreguntaCuatro.size());
        P4 = new Pregunta();
        P4 = PreguntaCuatro.get(indice4);

        int indice5 = random.nextInt(PreguntaCinco.size());
        P5 = new Pregunta();
        P5 = PreguntaCinco.get(indice5);

        int indice6 = random.nextInt(PreguntaSeis.size());
        P6 = new Pregunta();
        P6 = PreguntaSeis.get(indice6);

        int indice7 = random.nextInt(PreguntaSiete.size());
        P7 = new Pregunta();
        P7 = PreguntaSiete.get(indice7);

        int indice8 = random.nextInt(PreguntaOcho.size());
        P8 = new Pregunta();
        P8 = PreguntaOcho.get(indice8);

    }

    public void MostrarPreguntas() {
        lblP1.setText((P1.getPregunta()));
        lblP2.setText((P2.getPregunta()));
        lblP3.setText((P3.getPregunta()));
        lblP4.setText((P4.getPregunta()));
        lblP5.setText((P5.getPregunta()));
        lblP6.setText((P6.getPregunta()));
        lblP7.setText((P7.getPregunta()));
        lblP8.setText((P8.getPregunta()));
    }

    public void Parar() {
        tiempo.stop();

        btnIniciar.setEnabled(false);
        btnSalir.setEnabled(true);
    }

    public void MostrarImagenFondo(String cadena) {
        String ruta = new File("src").getAbsolutePath();
        ruta = ruta + "\\main\\java\\Imagenes\\" + cadena + ".jpg";
        ImageIcon img = new ImageIcon(ruta);

        Image imgesc = img.getImage().getScaledInstance(lblImagenFondo.getWidth(), lblImagenFondo.getHeight(), Image.SCALE_SMOOTH);

        lblImagenFondo.setIcon(new ImageIcon(imgesc));
    }

    public boolean VerificarLLeno() {

        boolean res = true;

        pregunta1 = txtP1a.getText().trim() + txtP1b.getText().trim() + txtP1c.getText().trim() + txtP1d.getText().trim() + txtP1e.getText().trim() + txtP1f.getText().trim() + txtP1g.getText().trim() + txtP1h.getText().trim() + txtP1i.getText().trim();
        pregunta2 = txtP2a.getText().trim() + txtP2b.getText().trim() + txtP2c.getText().trim() + txtP2d.getText().trim() + txtP2e.getText().trim();
        pregunta3 = txtP3a.getText().trim() + txtP3b.getText().trim() + txtP3c.getText().trim() + txtP3d.getText().trim() + txtP3e.getText().trim() + txtP3f.getText().trim();
        pregunta4 = txtP4a.getText().trim() + txtP4b.getText().trim() + txtP4c.getText().trim() + txtP4d.getText().trim() + txtP4e.getText().trim() + txtP4f.getText().trim() + txtP4g.getText().trim() + txtP4h.getText().trim() + txtP4i.getText().trim() + txtP4j.getText().trim();
        pregunta5 = txtP1i.getText().trim() + txtP5b.getText().trim() + txtP5c.getText().trim() + txtP5d.getText().trim();
        pregunta6 = txtP1f.getText().trim() + txtP6b.getText().trim() + txtP6c.getText().trim() + txtP6d.getText().trim();
        pregunta7 = txtP2e.getText().trim() + txtP7b.getText().trim() + txtP7c.getText().trim() + txtP7d.getText().trim() + txtP1a.getText().trim();
        pregunta8 = txtP2d.getText().trim() + txtP8b.getText().trim() + txtP8c.getText().trim() + txtP3e.getText().trim() + txtP4a.getText().trim();

        if (pregunta1.length() != 9 || pregunta2.length() != 5 || pregunta3.length() != 6 || pregunta4.length() != 10 || pregunta5.length() != 4 || pregunta6.length() != 4 || pregunta7.length() != 5 || pregunta8.length() != 5) {
            res = false;
        }
        return res;

    }

    public float NotaFinal() {

        float nota = 0;

        if (P1.getRespuesta().equalsIgnoreCase(pregunta1)) {
            nota = nota + 2.5f;
        } else {
            txtP1a.setForeground(Color.red);
            txtP1b.setForeground(Color.red);
            txtP1c.setForeground(Color.red);
            txtP1d.setForeground(Color.red);
            txtP1e.setForeground(Color.red);
            txtP1f.setForeground(Color.red);
            txtP1g.setForeground(Color.red);
            txtP1h.setForeground(Color.red);
            txtP1i.setForeground(Color.red);
        }
        if (P2.getRespuesta().equalsIgnoreCase(pregunta2)) {
            nota = nota + 2.5f;
        } else {
            txtP2a.setForeground(Color.red);
            txtP2b.setForeground(Color.red);
            txtP2c.setForeground(Color.red);
            txtP2d.setForeground(Color.red);
            txtP2e.setForeground(Color.red);
        }
        if (P3.getRespuesta().equalsIgnoreCase(pregunta3)) {
            nota = nota + 2.5f;
        } else {
            txtP3a.setForeground(Color.red);
            txtP3b.setForeground(Color.red);
            txtP3c.setForeground(Color.red);
            txtP3d.setForeground(Color.red);
            txtP3e.setForeground(Color.red);
            txtP3f.setForeground(Color.red);
        }
        if (P4.getRespuesta().equalsIgnoreCase(pregunta4)) {
            nota = nota + 2.5f;
        } else {
            txtP4a.setForeground(Color.red);
            txtP4b.setForeground(Color.red);
            txtP4c.setForeground(Color.red);
            txtP4d.setForeground(Color.red);
            txtP4e.setForeground(Color.red);
            txtP4f.setForeground(Color.red);
            txtP4g.setForeground(Color.red);
            txtP4h.setForeground(Color.red);
            txtP4i.setForeground(Color.red);
            txtP4j.setForeground(Color.red);
        }
        if (P5.getRespuesta().equalsIgnoreCase(pregunta5)) {
            nota = nota + 2.5f;
        } else {
            txtP1i.setForeground(Color.red);
            txtP5b.setForeground(Color.red);
            txtP5c.setForeground(Color.red);
            txtP5d.setForeground(Color.red);
        }
        if (P6.getRespuesta().equalsIgnoreCase(pregunta6)) {
            nota = nota + 2.5f;
        } else {
            txtP1f.setForeground(Color.red);
            txtP6b.setForeground(Color.red);
            txtP6c.setForeground(Color.red);
            txtP6d.setForeground(Color.red);
        }
        if (P7.getRespuesta().equalsIgnoreCase(pregunta7)) {
            nota = nota + 2.5f;
        } else {
            txtP2e.setForeground(Color.red);
            txtP7b.setForeground(Color.red);
            txtP7c.setForeground(Color.red);
            txtP7d.setForeground(Color.red);
            txtP1a.setForeground(Color.red);
        }
        if (P8.getRespuesta().equalsIgnoreCase(pregunta8)) {
            nota = nota + 2.5f;
        } else {
            txtP2d.setForeground(Color.red);
            txtP8b.setForeground(Color.red);
            txtP8c.setForeground(Color.red);
            txtP3e.setForeground(Color.red);
            txtP4a.setForeground(Color.red);
        }

        return nota;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField19 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        btnIniciar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnNota = new javax.swing.JButton();
        lblReloj = new javax.swing.JLabel();
        txtP2b = new javax.swing.JTextField();
        txtP2c = new javax.swing.JTextField();
        txtP8b = new javax.swing.JTextField();
        txtP7b = new javax.swing.JTextField();
        txtP2a = new javax.swing.JTextField();
        txtP7c = new javax.swing.JTextField();
        txtP7d = new javax.swing.JTextField();
        txtP1b = new javax.swing.JTextField();
        txtP2e = new javax.swing.JTextField();
        txtP1c = new javax.swing.JTextField();
        txtP1d = new javax.swing.JTextField();
        txtP1e = new javax.swing.JTextField();
        txtP6b = new javax.swing.JTextField();
        txtP1g = new javax.swing.JTextField();
        txtP1h = new javax.swing.JTextField();
        txtP5b = new javax.swing.JTextField();
        txtP1a = new javax.swing.JTextField();
        txtP6c = new javax.swing.JTextField();
        txtP6d = new javax.swing.JTextField();
        txtP1f = new javax.swing.JTextField();
        txtP5c = new javax.swing.JTextField();
        txtP5d = new javax.swing.JTextField();
        txtP1i = new javax.swing.JTextField();
        txtP8c = new javax.swing.JTextField();
        txtP3c = new javax.swing.JTextField();
        txtP4b = new javax.swing.JTextField();
        txtP2d = new javax.swing.JTextField();
        txtP4c = new javax.swing.JTextField();
        txtP4d = new javax.swing.JTextField();
        txtP4e = new javax.swing.JTextField();
        txtP4f = new javax.swing.JTextField();
        txtP4g = new javax.swing.JTextField();
        txtP4h = new javax.swing.JTextField();
        txtP4i = new javax.swing.JTextField();
        txtP4j = new javax.swing.JTextField();
        txtP4a = new javax.swing.JTextField();
        txtP3d = new javax.swing.JTextField();
        txtP3b = new javax.swing.JTextField();
        txtP3a = new javax.swing.JTextField();
        txtP3f = new javax.swing.JTextField();
        txtP3e = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblUsuarioNombre = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        lblP2 = new javax.swing.JEditorPane();
        jScrollPane10 = new javax.swing.JScrollPane();
        lblP3 = new javax.swing.JEditorPane();
        jScrollPane11 = new javax.swing.JScrollPane();
        lblP5 = new javax.swing.JEditorPane();
        jScrollPane12 = new javax.swing.JScrollPane();
        lblP1 = new javax.swing.JEditorPane();
        jScrollPane13 = new javax.swing.JScrollPane();
        lblP6 = new javax.swing.JEditorPane();
        jScrollPane14 = new javax.swing.JScrollPane();
        lblP7 = new javax.swing.JEditorPane();
        jScrollPane15 = new javax.swing.JScrollPane();
        lblP8 = new javax.swing.JEditorPane();
        jScrollPane16 = new javax.swing.JScrollPane();
        lblP4 = new javax.swing.JEditorPane();
        lblImagenFondo = new javax.swing.JLabel();

        jTextField19.setText("U");

        jTextField18.setText("Q");

        jTextField21.setText("L");

        jTextField20.setText("I");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setBackground(new java.awt.Color(255, 0, 0));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 730, 80, 60));

        btnIniciar.setBackground(new java.awt.Color(0, 255, 0));
        btnIniciar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnIniciar.setText("Inciar");
        btnIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, -1, -1));

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Calificación");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 130, -1));

        btnNota.setBackground(new java.awt.Color(0, 0, 255));
        btnNota.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnNota.setForeground(new java.awt.Color(255, 255, 255));
        btnNota.setText("00");
        btnNota.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 130, 70));

        lblReloj.setFont(new java.awt.Font("Cooper Black", 0, 36)); // NOI18N
        lblReloj.setText("00:00:00:00");
        getContentPane().add(lblReloj, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        txtP2b.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP2b.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP2b.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtP2bKeyTyped(evt);
            }
        });
        getContentPane().add(txtP2b, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 60, 40, 40));

        txtP2c.setEditable(false);
        txtP2c.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP2c.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP2c.setText("C");
        getContentPane().add(txtP2c, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, 40, 40));

        txtP8b.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP8b.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP8b.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtP8bKeyTyped(evt);
            }
        });
        getContentPane().add(txtP8b, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 160, 40, 40));

        txtP7b.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP7b.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP7b.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtP7bKeyTyped(evt);
            }
        });
        getContentPane().add(txtP7b, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, 40, 40));

        txtP2a.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP2a.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP2a.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtP2aKeyTyped(evt);
            }
        });
        getContentPane().add(txtP2a, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 40, 40));

        txtP7c.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP7c.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP7c.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtP7cKeyTyped(evt);
            }
        });
        getContentPane().add(txtP7c, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 210, 40, 40));

        txtP7d.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP7d.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP7d.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtP7dKeyTyped(evt);
            }
        });
        getContentPane().add(txtP7d, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, 40, 40));

        txtP1b.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP1b.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP1b.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtP1bKeyTyped(evt);
            }
        });
        getContentPane().add(txtP1b, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 40, 40));

        txtP2e.setEditable(false);
        txtP2e.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP2e.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP2e.setText("A");
        getContentPane().add(txtP2e, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 210, 40, 40));

        txtP1c.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP1c.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP1c.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtP1cKeyTyped(evt);
            }
        });
        getContentPane().add(txtP1c, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, 40, 40));

        txtP1d.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP1d.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP1d.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtP1dKeyTyped(evt);
            }
        });
        getContentPane().add(txtP1d, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, 40, 40));

        txtP1e.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP1e.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP1e.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtP1eKeyTyped(evt);
            }
        });
        getContentPane().add(txtP1e, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 410, 40, 40));

        txtP6b.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP6b.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP6b.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtP6bKeyTyped(evt);
            }
        });
        getContentPane().add(txtP6b, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 460, 40, 40));

        txtP1g.setEditable(false);
        txtP1g.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP1g.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP1g.setText("I");
        getContentPane().add(txtP1g, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 510, 40, 40));

        txtP1h.setEditable(false);
        txtP1h.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP1h.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP1h.setText("Ó");
        getContentPane().add(txtP1h, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 560, 40, 40));

        txtP5b.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP5b.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP5b.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtP5bKeyTyped(evt);
            }
        });
        getContentPane().add(txtP5b, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 610, 40, 40));

        txtP1a.setEditable(false);
        txtP1a.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP1a.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP1a.setText("O");
        txtP1a.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtP1aKeyTyped(evt);
            }
        });
        getContentPane().add(txtP1a, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 40, 40));

        txtP6c.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP6c.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP6c.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtP6cKeyTyped(evt);
            }
        });
        getContentPane().add(txtP6c, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 460, 40, 40));

        txtP6d.setEditable(false);
        txtP6d.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP6d.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP6d.setText("O");
        getContentPane().add(txtP6d, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 460, 40, 40));

        txtP1f.setEditable(false);
        txtP1f.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP1f.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP1f.setText("C");
        getContentPane().add(txtP1f, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 460, 40, 40));

        txtP5c.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP5c.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP5c.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtP5cKeyTyped(evt);
            }
        });
        getContentPane().add(txtP5c, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 610, 40, 40));

        txtP5d.setEditable(false);
        txtP5d.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP5d.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP5d.setText("O");
        getContentPane().add(txtP5d, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 610, 40, 40));

        txtP1i.setEditable(false);
        txtP1i.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP1i.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP1i.setText("N");
        getContentPane().add(txtP1i, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 610, 40, 40));

        txtP8c.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP8c.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP8c.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtP8cKeyTyped(evt);
            }
        });
        getContentPane().add(txtP8c, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 160, 40, 40));

        txtP3c.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP3c.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP3c.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtP3cKeyTyped(evt);
            }
        });
        getContentPane().add(txtP3c, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 260, 40, 40));

        txtP4b.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP4b.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP4b.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtP4bKeyTyped(evt);
            }
        });
        getContentPane().add(txtP4b, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 210, 40, 40));

        txtP2d.setEditable(false);
        txtP2d.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP2d.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP2d.setText("T");
        getContentPane().add(txtP2d, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 160, 40, 40));

        txtP4c.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP4c.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP4c.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtP4cKeyTyped(evt);
            }
        });
        getContentPane().add(txtP4c, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 260, 40, 40));

        txtP4d.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP4d.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP4d.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtP4dKeyTyped(evt);
            }
        });
        getContentPane().add(txtP4d, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 310, 40, 40));

        txtP4e.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP4e.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP4e.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtP4eKeyTyped(evt);
            }
        });
        getContentPane().add(txtP4e, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 360, 40, 40));

        txtP4f.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP4f.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP4f.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtP4fKeyTyped(evt);
            }
        });
        getContentPane().add(txtP4f, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 410, 40, 40));

        txtP4g.setEditable(false);
        txtP4g.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP4g.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP4g.setText("C");
        getContentPane().add(txtP4g, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 460, 40, 40));

        txtP4h.setEditable(false);
        txtP4h.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP4h.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP4h.setText("I");
        getContentPane().add(txtP4h, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 510, 40, 40));

        txtP4i.setEditable(false);
        txtP4i.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP4i.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP4i.setText("Ó");
        getContentPane().add(txtP4i, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 560, 40, 40));

        txtP4j.setEditable(false);
        txtP4j.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP4j.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP4j.setText("N");
        getContentPane().add(txtP4j, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 610, 40, 40));

        txtP4a.setEditable(false);
        txtP4a.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP4a.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP4a.setText("A");
        getContentPane().add(txtP4a, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 160, 40, 40));

        txtP3d.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP3d.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP3d.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtP3dKeyTyped(evt);
            }
        });
        getContentPane().add(txtP3d, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 210, 40, 40));

        txtP3b.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP3b.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP3b.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtP3bKeyTyped(evt);
            }
        });
        getContentPane().add(txtP3b, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 310, 40, 40));

        txtP3a.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP3a.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP3a.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtP3aKeyTyped(evt);
            }
        });
        getContentPane().add(txtP3a, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 360, 40, 40));

        txtP3f.setEditable(false);
        txtP3f.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP3f.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP3f.setText("O");
        getContentPane().add(txtP3f, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 110, 40, 40));

        txtP3e.setEditable(false);
        txtP3e.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtP3e.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP3e.setText("L");
        getContentPane().add(txtP3e, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 160, 40, 40));

        jButton1.setBackground(new java.awt.Color(255, 255, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton1.setText("2");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton2.setText("3");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 420, -1, -1));

        jButton3.setBackground(new java.awt.Color(255, 255, 51));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton3.setText("4");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 120, -1, -1));

        jButton4.setBackground(new java.awt.Color(255, 255, 51));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton4.setText("5");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 620, -1, -1));

        jButton5.setBackground(new java.awt.Color(255, 255, 51));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton5.setText("6");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, -1, -1));

        jButton6.setBackground(new java.awt.Color(255, 255, 51));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton6.setText("7");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 220, -1, -1));

        jButton7.setBackground(new java.awt.Color(255, 255, 51));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton7.setText("8");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, -1, -1));

        jButton8.setBackground(new java.awt.Color(255, 255, 51));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton8.setText("1");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, -1, -1));

        jButton9.setBackground(new java.awt.Color(0, 255, 255));
        jButton9.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton9.setText("1");
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, -1, -1));

        jButton10.setBackground(new java.awt.Color(0, 255, 255));
        jButton10.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton10.setText("2");
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, -1, -1));

        jButton11.setBackground(new java.awt.Color(0, 255, 255));
        jButton11.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton11.setText("3");
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, -1, -1));

        jButton12.setBackground(new java.awt.Color(0, 255, 255));
        jButton12.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton12.setText("4");
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 520, -1, -1));

        jButton13.setBackground(new java.awt.Color(0, 255, 255));
        jButton13.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton13.setText("5");
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 680, -1, -1));

        jButton14.setBackground(new java.awt.Color(0, 255, 255));
        jButton14.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton14.setText("6");
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 680, -1, -1));

        jButton15.setBackground(new java.awt.Color(0, 255, 255));
        jButton15.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton15.setText("7");
        jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 680, -1, -1));

        jButton16.setBackground(new java.awt.Color(0, 255, 255));
        jButton16.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton16.setText("8");
        jButton16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 680, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 30));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, 1000, 10));

        lblUsuarioNombre.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblUsuarioNombre.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblUsuarioNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 610, 30));

        lblP2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane9.setViewportView(lblP2);

        getContentPane().add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 210, 100));

        lblP3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane10.setViewportView(lblP3);

        getContentPane().add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 210, 100));

        lblP5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane11.setViewportView(lblP5);

        getContentPane().add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 710, 210, 100));

        lblP1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane12.setViewportView(lblP1);

        getContentPane().add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 210, 100));

        lblP6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane13.setViewportView(lblP6);

        getContentPane().add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 710, 210, 100));

        lblP7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane14.setViewportView(lblP7);

        getContentPane().add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 710, 210, 100));

        lblP8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane15.setViewportView(lblP8);

        getContentPane().add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 710, 210, 100));

        lblP4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane16.setViewportView(lblP4);

        getContentPane().add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 540, 210, 100));

        lblImagenFondo.setText("jLabel1");
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
        getContentPane().add(lblImagenFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 830));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int res = JOptionPane.showConfirmDialog(this, "¿ Estás seguro que deseas salir del Juego Crucigrama ?");

        if (res == 0) {

            frmLogin vista = new frmLogin();
            vista.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed

        if (VerificarLLeno() == true) {

            Parar();
            btnNota.setText("" + NotaFinal());

            String tiempo = lblReloj.getText();
            LocalDate f = LocalDate.now();
            String fecha = "" + f;

            Nota obj = new Nota(0, NotaFinal(), tiempo, fecha, u);

            int res = daoNota.RegistrarNota(obj);

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "TU NOTA ES : " + NotaFinal() + "\nTU TIEMPO FUE : " + lblReloj.getText());
            } else {
                JOptionPane.showMessageDialog(null, "HUBO UN PROBLEMA AL REGISTRAR TU TAREA");
            }

        } else {
            JOptionPane.showMessageDialog(null, "[ COMPLETE TODAS LAS CASILLAS ]");
        }

    }//GEN-LAST:event_btnIniciarActionPerformed

    private void txtP1aKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP1aKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtP1aKeyTyped

    private void txtP1bKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP1bKeyTyped
        if (txtP1b.getText().length() >= 1) {
            evt.consume();
            Toolkit.getDefaultToolkit();
        }
    }//GEN-LAST:event_txtP1bKeyTyped

    private void txtP1cKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP1cKeyTyped
        if (txtP1c.getText().length() >= 1) {
            evt.consume();
            Toolkit.getDefaultToolkit();
        }
    }//GEN-LAST:event_txtP1cKeyTyped

    private void txtP1dKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP1dKeyTyped
        if (txtP1d.getText().length() >= 1) {
            evt.consume();
            Toolkit.getDefaultToolkit();
        }
    }//GEN-LAST:event_txtP1dKeyTyped

    private void txtP1eKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP1eKeyTyped
        if (txtP1e.getText().length() >= 1) {
            evt.consume();
            Toolkit.getDefaultToolkit();
        }
    }//GEN-LAST:event_txtP1eKeyTyped

    private void txtP2aKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP2aKeyTyped
        if (txtP2a.getText().length() >= 1) {
            evt.consume();
            Toolkit.getDefaultToolkit();
        }
    }//GEN-LAST:event_txtP2aKeyTyped

    private void txtP2bKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP2bKeyTyped
        if (txtP2b.getText().length() >= 1) {
            evt.consume();
            Toolkit.getDefaultToolkit();
        }
    }//GEN-LAST:event_txtP2bKeyTyped

    private void txtP3aKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP3aKeyTyped
        if (txtP3a.getText().length() >= 1) {
            evt.consume();
            Toolkit.getDefaultToolkit();
        }
    }//GEN-LAST:event_txtP3aKeyTyped

    private void txtP3bKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP3bKeyTyped
        if (txtP3b.getText().length() >= 1) {
            evt.consume();
            Toolkit.getDefaultToolkit();
        }
    }//GEN-LAST:event_txtP3bKeyTyped

    private void txtP3cKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP3cKeyTyped
        if (txtP3c.getText().length() >= 1) {
            evt.consume();
            Toolkit.getDefaultToolkit();
        }
    }//GEN-LAST:event_txtP3cKeyTyped

    private void txtP3dKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP3dKeyTyped
        if (txtP3d.getText().length() >= 1) {
            evt.consume();
            Toolkit.getDefaultToolkit();
        }
    }//GEN-LAST:event_txtP3dKeyTyped

    private void txtP4bKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP4bKeyTyped
        if (txtP4b.getText().length() >= 1) {
            evt.consume();
            Toolkit.getDefaultToolkit();
        }
    }//GEN-LAST:event_txtP4bKeyTyped

    private void txtP4cKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP4cKeyTyped
        if (txtP4c.getText().length() >= 1) {
            evt.consume();
            Toolkit.getDefaultToolkit();
        }
    }//GEN-LAST:event_txtP4cKeyTyped

    private void txtP4dKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP4dKeyTyped
        if (txtP4d.getText().length() >= 1) {
            evt.consume();
            Toolkit.getDefaultToolkit();
        }
    }//GEN-LAST:event_txtP4dKeyTyped

    private void txtP4eKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP4eKeyTyped
        if (txtP4e.getText().length() >= 1) {
            evt.consume();
            Toolkit.getDefaultToolkit();
        }
    }//GEN-LAST:event_txtP4eKeyTyped

    private void txtP4fKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP4fKeyTyped
        if (txtP4f.getText().length() >= 1) {
            evt.consume();
            Toolkit.getDefaultToolkit();
        }
    }//GEN-LAST:event_txtP4fKeyTyped

    private void txtP5bKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP5bKeyTyped
        if (txtP5b.getText().length() >= 1) {
            evt.consume();
            Toolkit.getDefaultToolkit();
        }
    }//GEN-LAST:event_txtP5bKeyTyped

    private void txtP5cKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP5cKeyTyped
        if (txtP5c.getText().length() >= 1) {
            evt.consume();
            Toolkit.getDefaultToolkit();
        }
    }//GEN-LAST:event_txtP5cKeyTyped

    private void txtP6bKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP6bKeyTyped
        if (txtP6b.getText().length() >= 1) {
            evt.consume();
            Toolkit.getDefaultToolkit();
        }
    }//GEN-LAST:event_txtP6bKeyTyped

    private void txtP6cKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP6cKeyTyped
        if (txtP6c.getText().length() >= 1) {
            evt.consume();
            Toolkit.getDefaultToolkit();
        }
    }//GEN-LAST:event_txtP6cKeyTyped

    private void txtP7bKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP7bKeyTyped
        if (txtP7b.getText().length() >= 1) {
            evt.consume();
            Toolkit.getDefaultToolkit();
        }
    }//GEN-LAST:event_txtP7bKeyTyped

    private void txtP7cKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP7cKeyTyped
        if (txtP7c.getText().length() >= 1) {
            evt.consume();
            Toolkit.getDefaultToolkit();
        }
    }//GEN-LAST:event_txtP7cKeyTyped

    private void txtP7dKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP7dKeyTyped
        if (txtP7d.getText().length() >= 1) {
            evt.consume();
            Toolkit.getDefaultToolkit();
        }
    }//GEN-LAST:event_txtP7dKeyTyped

    private void txtP8bKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP8bKeyTyped
        if (txtP8b.getText().length() >= 1) {
            evt.consume();
            Toolkit.getDefaultToolkit();
        }
    }//GEN-LAST:event_txtP8bKeyTyped

    private void txtP8cKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP8cKeyTyped
        if (txtP8c.getText().length() >= 1) {
            evt.consume();
            Toolkit.getDefaultToolkit();
        }
    }//GEN-LAST:event_txtP8cKeyTyped

    private void lblImagenFondoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenFondoMousePressed
       xMouse=evt.getX();
       yMouse=evt.getY();
    }//GEN-LAST:event_lblImagenFondoMousePressed

    private void lblImagenFondoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenFondoMouseDragged
       int x=evt.getXOnScreen();
       int y=evt.getYOnScreen();
        setLocation(x-xMouse,y-yMouse);
    }//GEN-LAST:event_lblImagenFondoMouseDragged

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
            java.util.logging.Logger.getLogger(frmCrucigrama.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCrucigrama.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCrucigrama.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCrucigrama.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCrucigrama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnNota;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JLabel lblImagenFondo;
    private javax.swing.JEditorPane lblP1;
    private javax.swing.JEditorPane lblP2;
    private javax.swing.JEditorPane lblP3;
    private javax.swing.JEditorPane lblP4;
    private javax.swing.JEditorPane lblP5;
    private javax.swing.JEditorPane lblP6;
    private javax.swing.JEditorPane lblP7;
    private javax.swing.JEditorPane lblP8;
    private javax.swing.JLabel lblReloj;
    private javax.swing.JLabel lblUsuarioNombre;
    private javax.swing.JTextField txtP1a;
    private javax.swing.JTextField txtP1b;
    private javax.swing.JTextField txtP1c;
    private javax.swing.JTextField txtP1d;
    private javax.swing.JTextField txtP1e;
    private javax.swing.JTextField txtP1f;
    private javax.swing.JTextField txtP1g;
    private javax.swing.JTextField txtP1h;
    private javax.swing.JTextField txtP1i;
    private javax.swing.JTextField txtP2a;
    private javax.swing.JTextField txtP2b;
    private javax.swing.JTextField txtP2c;
    private javax.swing.JTextField txtP2d;
    private javax.swing.JTextField txtP2e;
    private javax.swing.JTextField txtP3a;
    private javax.swing.JTextField txtP3b;
    private javax.swing.JTextField txtP3c;
    private javax.swing.JTextField txtP3d;
    private javax.swing.JTextField txtP3e;
    private javax.swing.JTextField txtP3f;
    private javax.swing.JTextField txtP4a;
    private javax.swing.JTextField txtP4b;
    private javax.swing.JTextField txtP4c;
    private javax.swing.JTextField txtP4d;
    private javax.swing.JTextField txtP4e;
    private javax.swing.JTextField txtP4f;
    private javax.swing.JTextField txtP4g;
    private javax.swing.JTextField txtP4h;
    private javax.swing.JTextField txtP4i;
    private javax.swing.JTextField txtP4j;
    private javax.swing.JTextField txtP5b;
    private javax.swing.JTextField txtP5c;
    private javax.swing.JTextField txtP5d;
    private javax.swing.JTextField txtP6b;
    private javax.swing.JTextField txtP6c;
    private javax.swing.JTextField txtP6d;
    private javax.swing.JTextField txtP7b;
    private javax.swing.JTextField txtP7c;
    private javax.swing.JTextField txtP7d;
    private javax.swing.JTextField txtP8b;
    private javax.swing.JTextField txtP8c;
    // End of variables declaration//GEN-END:variables
}
