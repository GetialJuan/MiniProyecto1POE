/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logica.Casino;

/**
 *
 * @author Juan
 */
public class VentanaJuego extends JFrame 
{
    //Casino
    private Casino casino;
    
    //JFrames
    private JFrame frame = new JFrame();
    
    //JLabels
    private JLabel encabezado;
    private JLabel titulo; 
    private JLabel lblLanzamientosARealizar;
        //Nombres de los jugadores
    private JLabel lblNombreJugador1, lblNombreJugador2;
        //Lanzamientos de los jugadores
    private JLabel lblLanzamientosJugador1, lblLanzamientosJugador2;
    private JLabel lblLanzamientosEmpates;
    private JLabel lblLanzamientosRestantes;
    private JLabel lblJugadorGanador; 
        //Puntajes de los jugadores
    private JLabel lblPuntajeJugador1, lblPuntajeJugador2;
    private JLabel lblJugadorALanzar;
    private JLabel lblTiempo; 
        //Lables de los dados
    private JLabel lblDado1, lblDado2; 
    
    //JButtons
    private JButton lanzarJugador1, lanzarJugador2;
    
    //JPanels
        //JPanels de segundo grado
    private JPanel parteSuperior, parteInferior;
        //JPanels de tercer grado
    private JPanel parteInferiorJugador1, parteInferiorJugador2, parteSuperior2;
    
    //Files
    private File imagenEncabezado;
    private File imagenDado1;
    private File imagenDado2;
    private File imagenDado3;
    private File imagenDado4;
    private File imagenDado5;
    private File imagenDado6;
    
    //Container
    private Container contenedorPrincipal;

    public VentanaJuego(Casino casinoInput)
    {
        iniciarComponentes(casinoInput);
        frame.setSize(700,800);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("CasinoUnivalle");
    }
    
    private void iniciarComponentes(Casino casinoInput)
    {
        //Obtenemos la ruta absoluta
        String rutaArchivo = new File("").getAbsolutePath();
        
        //Concatenamos la ruta absoluta de "CasinoUnivalle" con la ruta de todos los .png a utilizar
        String encabezadoCasinoRuta = rutaArchivo.concat("\\src\\imagenes\\casino.png");
        String dado1Ruta = rutaArchivo.concat("\\src\\imagenes\\dado1.png");
        String dado2Ruta = rutaArchivo.concat("\\src\\imagenes\\dado2.png");
        String dado3Ruta = rutaArchivo.concat("\\src\\imagenes\\dado3.png");
        String dado4Ruta = rutaArchivo.concat("\\src\\imagenes\\dado4.png");
        String dado5Ruta = rutaArchivo.concat("\\src\\imagenes\\dado5.png");
        String dado6Ruta = rutaArchivo.concat("\\src\\imagenes\\dado6.png");
        
        //Parte Superior
        //Se carga la imagen del encabezado
        imagenEncabezado = new File(encabezadoCasinoRuta);
        BufferedImage bufferedImagenEncabezado = ImageIO.read(imagenEncabezado);
        ImageIcon iconEncabezado = new ImageIcon(bufferedImagenEncabezado);
        encabezado = new JLabel();
        
        //Se agrega la imagen del encabezado
        encabezado.setIcon(iconEncabezado);
        
        
        
        
        
    }
    
}
