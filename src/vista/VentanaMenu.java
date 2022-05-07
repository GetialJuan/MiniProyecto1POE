/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Juan
 */
public class VentanaMenu extends JFrame{
    private Container contenedorPrincipal;
    private JLabel encabezado;
    private JLabel lblModoDeJuego;
    private JLabel lblNRondas;
    private JLabel lblNombre1;
    private JLabel lblNombre2;
    private JComboBox cmbNJugadores;
    private JPanel pnlNRondas;
    private JPanel pnlModoDeJuego;
    private JPanel pnlNombres;
    private JFormattedTextField txtNRondas;
    private JTextField txtNombre1;
    private JTextField txtNombre2;
    private JButton btnIniciarJuego;
    private File imagenEncabezado;
    
    public VentanaMenu() throws IOException, ParseException
    {
        iniciarComponentes();
        setSize(700,300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("CasinoUnivalle");
    }
    
    private void iniciarComponentes() throws IOException, ParseException
    {
        //Se carga la imagen del encabezado
        imagenEncabezado = new File("C:\\Users\\Juan\\Documents\\NetBeansProjects\\CasinoUnivalle\\src\\imagenes\\casino.png");
        BufferedImage bufferedImagenEncabezado = ImageIO.read(imagenEncabezado);
        ImageIcon iconEncabezado = new ImageIcon(bufferedImagenEncabezado);
        
        encabezado = new JLabel();
        //Se agrega la imagen del encabezado
        encabezado.setIcon(iconEncabezado);
        
        //Se crea la lista de opciones del n jugadores
        cmbNJugadores = new JComboBox<String>();
        cmbNJugadores.addItem("Jugador vs CPU");
        cmbNJugadores.addItem("Jugador vs Jugador");
        
        //Se cre la seccion de Mdodo de Juego
        lblModoDeJuego = new JLabel("Seleccione el modo de juego: ");
        lblModoDeJuego.setHorizontalAlignment(SwingConstants.CENTER);
       
        pnlModoDeJuego = new JPanel();
        pnlModoDeJuego.setLayout(new GridLayout(1,2));
        pnlModoDeJuego.add(lblModoDeJuego);
        pnlModoDeJuego.add(cmbNJugadores);
        
        //Se cre la seccon de n Rondas
        pnlNRondas = new JPanel();
        pnlNRondas.setLayout(new GridLayout(1,2));
        lblNRondas = new JLabel("Escriba el numero de rondas : ");
        lblNRondas.setHorizontalAlignment(SwingConstants.CENTER);
        txtNRondas = new JFormattedTextField(new MaskFormatter("##"));
        pnlNRondas.add(lblNRondas);
        pnlNRondas.add(txtNRondas);
        
        //Se crea la nombres de Juagadores
        lblNombre1 = new JLabel("Nombre del Jugador 1");
        lblNombre1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombre2 = new JLabel("Nombre del Jugador 2");
        lblNombre2.setHorizontalAlignment(SwingConstants.CENTER);
        txtNombre1 = new JTextField("Jugador 1");
        txtNombre2 = new JTextField("CPU");
        
        pnlNombres = new JPanel();
        pnlNombres.setLayout(new GridLayout(2,2));
        pnlNombres.add(lblNombre1);
        pnlNombres.add(lblNombre2);
        pnlNombres.add(txtNombre1);
        pnlNombres.add(txtNombre2);
        
        //Se instancia el btnInciarjugar
        btnIniciarJuego = new JButton("Iniciar Juego");
        
        //Se crea el contenedro principal
        contenedorPrincipal = getContentPane();
        contenedorPrincipal.setLayout(new GridLayout(5,1));
        contenedorPrincipal.add(encabezado);
        contenedorPrincipal.add(pnlModoDeJuego);
        contenedorPrincipal.add(pnlNRondas);
        contenedorPrincipal.add(pnlNombres);
        contenedorPrincipal.add(btnIniciarJuego);
        
    }
}
