/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import logica.Casino;

/**
 *
 * @author Sebastian Idrovo Avirama <idrobo.sebastian@correounivalle.edu.co>
 * @author Juan Sebastian Getial <getial.juan@correounivalle.edu.co>
 * @profesor Luis Yovany Romo Portilla
 * Clase que representa la ventana del juego de dados
 */
public class VentanaJuego extends JFrame 
{
    //Casino
    private Casino casino;
    
    //JFrames
    private JFrame frame = new JFrame();
    
    //Timer
    private Timer TimerTiempo;
    
    //JLabels
    private JLabel lblEncabezado;
    private JLabel lblTitulo;
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
    private JButton btnLanzarJugador1, btnLanzarJugador2;
    
    //JPanels
        //JPanels de segundo grado
    private JPanel pnlSuperior, pnlInferior;
        //JPanels de tercer grado
    private JPanel pnlInferiorJugador1, pnlInferiorJugador2, pnlSuperior2, pnlDados;
    
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

    public VentanaJuego(Casino casinoInput) throws IOException
    {
        iniciarComponentes(casinoInput);
        frame.setSize(700,800);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("CasinoUnivalle");
    }
    
    int k = 0;
    
    private void iniciarComponentes(Casino casinoInput) throws IOException
    {
        //Guardamos Casino
        casino = casinoInput;
        
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
        lblEncabezado = new JLabel();
        
        
        
        //Se agrega la imagen del encabezado
        lblEncabezado.setIcon(iconEncabezado);
        
        //Titulo
        lblTitulo = new JLabel("---JUEGO DE DADOS---"); 
        lblTitulo.setFont(new Font("Century Gothic", Font.BOLD, 32));
        lblTitulo.setForeground(Color.RED);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        
        //Timer
        lblTiempo = new JLabel("Tiempo transcurrido: 0 segundos");
        lblTiempo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        lblTiempo.setHorizontalAlignment(SwingConstants.CENTER);
        TimerTiempo = new Timer(1000, new ManejadorDeEventos());
        TimerTiempo.start();
        
        //JugadorGanador
        lblJugadorGanador = new JLabel ("Jugador parcialmente ganador: ");
        lblJugadorGanador.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        lblJugadorGanador.setHorizontalAlignment(SwingConstants.CENTER);
        
        //LanzamientosARealizar
        lblLanzamientosARealizar = new JLabel("Lanzamientos a realizar: " + 
                casino.getRondas().get(casino.getRondaActual()).
                        getLanzamientosARealizar());
        lblLanzamientosARealizar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        lblLanzamientosARealizar.setHorizontalAlignment(SwingConstants.CENTER);
        
        //LanzamientosRealizados
        lblLanzamientosRestantes = new JLabel("Lanzamientos restantes: " + 
                casino.getRondas().get(casino.getRondaActual()).getLanzamientosRestantes());
        lblLanzamientosRestantes.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        lblLanzamientosRestantes.setHorizontalAlignment(SwingConstants.CENTER);
        
        //LanzamientosEmpates
        lblLanzamientosEmpates = new JLabel ("Lanzamientos con empate: " + 
                casino.getRondas().get(casino.getRondaActual()).
                        getLanzamientosEmpatados());
        lblLanzamientosEmpates.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
        lblLanzamientosEmpates.setHorizontalAlignment(SwingConstants.CENTER);
        
        //Dados
        imagenDado1 = new File(dado3Ruta);
        BufferedImage bufferedImagenDado1 = ImageIO.read(imagenDado1);
        ImageIcon iconDado1 = new ImageIcon(bufferedImagenDado1);
        lblDado1 = new JLabel();
        lblDado1.setHorizontalAlignment(SwingConstants.CENTER);
        
            //Se agrega imagen
        lblDado1.setIcon(iconDado1);
        
        imagenDado2 = new File(dado2Ruta);
        BufferedImage bufferedImagenDado2 = ImageIO.read(imagenDado2);
        ImageIcon iconDado2 = new ImageIcon(bufferedImagenDado2);
        lblDado2 = new JLabel();
        lblDado2.setHorizontalAlignment(SwingConstants.CENTER);
        
            //Se agrega imagen
        lblDado2.setIcon(iconDado2);
        
        //Parte Inferior
        
        //Parte izquierda
        //NombreJugador1
        lblNombreJugador1 = new JLabel (casino.getRondas().get(casino.
                getRondaActual()).getNombreJugador1());
        lblNombreJugador1.setFont(new Font("Century Schoolbook", Font.BOLD, 28));
        lblNombreJugador1.setForeground(Color.BLUE);
        lblNombreJugador1.setHorizontalAlignment(SwingConstants.CENTER);
        
        //LanzamientosJugador1
        lblLanzamientosJugador1 = new JLabel ("Lanzamientos: " + casino.
                getRondas().get(casino.getRondaActual()).
                getLanzamientosRealizadosJugador1() + "");
        lblLanzamientosJugador1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        
        //PuntajeJugador1
        lblPuntajeJugador1 = new JLabel ("Puntaje: " + casino.getRondas().
                get(casino.getRondaActual()).getPuntajeJugador1() + "");
        lblPuntajeJugador1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        
        //LanzarJugador1
        btnLanzarJugador1 = new JButton ("Lanzar");
        btnLanzarJugador1.addActionListener(new ManejadorDeEventos());
        btnLanzarJugador1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        
        
        //Parte Derecha
        //NombreJugador2
        lblNombreJugador2 = new JLabel (casino.getRondas().get(casino.
                getRondaActual()).getNombreJugador2());
        lblNombreJugador2.setFont(new Font("Century Schoolbook", Font.BOLD, 28));
        lblNombreJugador2.setForeground(Color.BLUE);
        lblNombreJugador2.setHorizontalAlignment(SwingConstants.CENTER);
        
        //LanzamientosJugador2
        lblLanzamientosJugador2 = new JLabel ("Lanzamientos: " + casino.
                getRondas().get(casino.getRondaActual()).
                getLanzamientosRealizadosJugador2()+ "");
        lblLanzamientosJugador2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        
        //PuntajeJugador2
        lblPuntajeJugador2 = new JLabel ("Puntaje: " + casino.getRondas().get(casino.
                getRondaActual()).getPuntajeJugador2() + "");
        lblPuntajeJugador2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        
        //LanzarJugador2
        btnLanzarJugador2 = new JButton ("Lanzar");
        btnLanzarJugador2.addActionListener(new ManejadorDeEventos());
        btnLanzarJugador2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        
        //JugadorALanzar
        
        String jugadorALanzar;
        switch (casino.getJugadorALanzar()) {
            case 1:
                jugadorALanzar = casino.getRondas().get(casino.
                        getRondaActual()).getNombreJugador1();
                btnLanzarJugador2.setEnabled(false);
                
                break;
            case 2:
                jugadorALanzar = casino.getRondas().get(casino.
                        getRondaActual()).getNombreJugador2();
                btnLanzarJugador1.setEnabled(false);
                break;
            default:
                throw new AssertionError();
        }
        lblJugadorALanzar = new JLabel ("Próximo jugador a lanzar: " + 
                jugadorALanzar);
        lblJugadorALanzar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
        lblJugadorALanzar.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        //CONFIGURACIÓN JPANELS
        //pnlInferiorJugador1
        pnlInferiorJugador1 = new JPanel();
        pnlInferiorJugador1.setLayout(new GridLayout(4,1));
        pnlInferiorJugador1.add(lblNombreJugador1);
        pnlInferiorJugador1.add(lblLanzamientosJugador1);
        pnlInferiorJugador1.add(lblPuntajeJugador1);
        pnlInferiorJugador1.add(btnLanzarJugador1);
        
        //pnlInferiorJugador2
        pnlInferiorJugador2 = new JPanel();
        pnlInferiorJugador2.setLayout(new GridLayout(4,1));
        pnlInferiorJugador2.add(lblNombreJugador2);
        pnlInferiorJugador2.add(lblLanzamientosJugador2);
        pnlInferiorJugador2.add(lblPuntajeJugador2);
        pnlInferiorJugador2.add(btnLanzarJugador2);
        
        //pnlSuperior2
        pnlSuperior2 = new JPanel();
        pnlSuperior2.setLayout(new GridLayout(2,2));
        pnlSuperior2.add(lblTiempo);
        pnlSuperior2.add(lblJugadorGanador);
        pnlSuperior2.add(lblLanzamientosARealizar);
        pnlSuperior2.add(lblLanzamientosRestantes);
        
        //pnlDados
        pnlDados = new JPanel();
        pnlDados.setLayout(new GridLayout(1,2));
        pnlDados.add(lblDado1);
        pnlDados.add(lblDado2);
        
        //pnlSuperior
        pnlSuperior = new JPanel();
        pnlSuperior.setLayout(new GridLayout(5,1));
        pnlSuperior.add(lblEncabezado);
        pnlSuperior.add(lblTitulo);
        pnlSuperior.add(pnlSuperior2);
        pnlSuperior.add(lblLanzamientosEmpates);
        pnlSuperior.add(lblJugadorALanzar);
        
        //pnlInferior
        pnlInferior = new JPanel();
        pnlInferior.setLayout(new GridLayout(1,2));
        pnlInferior.add(pnlInferiorJugador1);
        pnlInferior.add(pnlInferiorJugador2);
        
        //contenedorPrincipal
        contenedorPrincipal = new Container();
        contenedorPrincipal.setLayout(new GridLayout(3,1));
        contenedorPrincipal.add(pnlSuperior);
        contenedorPrincipal.add(pnlDados);
        contenedorPrincipal.add(pnlInferior);
        
        //Se añade al Frame
        frame.add(contenedorPrincipal);
        
        
        
    }

private int contadorLanzamientos = 0;
    
    private class ManejadorDeEventos implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            
            
            if(e.getSource() == btnLanzarJugador1 || e.getSource() == btnLanzarJugador2)
            {
                    
                //ENCARGADA DE SUMAR Y EVALUAR PUNTAJES
                casino.lanzarDados();
                contadorLanzamientos = contadorLanzamientos + 1;
                
                
                //Se cambia el juagador a lanzar
                String jugadorALanzar;
                switch (casino.getJugadorALanzar()) {
                    case 1:
                        casino.sumarPuntajeDeLanzamiento2();
                        jugadorALanzar = casino.getRondas().get(casino.
                                getRondaActual()).getNombreJugador1();
                        break;
                    case 2:
                        casino.sumarPuntajeDeLanzamiento1();
                        jugadorALanzar = casino.getRondas().get(casino.
                                getRondaActual()).getNombreJugador2();
                        break;
                    default:
                        throw new AssertionError();
                }
                
                //Cada dos lanzamientos se comprueban los puntajes de caja jugador (En caso de empate);
                if(contadorLanzamientos % 2 == 0)
                {
                    casino.sumarPuntajesDeLanzamiento();
                }
                
                //Se ajusta el nuevo valor de cada lbl
                lblJugadorALanzar.setText("Próximo jugador a lanzar: " + 
                        jugadorALanzar);
                
                lblLanzamientosJugador1.setText("Lanzamientos: " + casino.
                getRondas().get(casino.getRondaActual()).
                getLanzamientosRealizadosJugador1()+ "");
                
                lblLanzamientosJugador2.setText("Lanzamientos: " + casino.
                getRondas().get(casino.getRondaActual()).
                getLanzamientosRealizadosJugador2()+ "");
                
                lblPuntajeJugador1.setText("Puntaje: " + casino.getRondas().
                        get(casino.getRondaActual()).getPuntajeJugador1() + "");
                
                lblPuntajeJugador2.setText("Puntaje: " + casino.getRondas().
                        get(casino.getRondaActual()).getPuntajeJugador2() + "");
                
                lblLanzamientosEmpates.setText("Lanzamientos con empate: " + 
                        casino.getRondas().get(casino.getRondaActual()).
                                getLanzamientosEmpatados());
                
                lblJugadorGanador.setText("Jugador parcialmente ganador: " + 
                        casino.getRondas().get(casino.getRondaActual()).
                                getGanador());
                
                lblLanzamientosRestantes.setText("Lanzamientos restantes: " + 
                casino.getRondas().get(casino.getRondaActual()).
                        getLanzamientosRestantes());
                
                //Se verifica si se acabaron los lanzamientois
                if(casino.getRondas().get(casino.getRondaActual()).
                        getLanzamientosRestantes() <= 0)
                {
                    frame.dispose();
                    VentanaFinal ventanaFinal = new VentanaFinal(casino);
                }
                
                //Habilita y deshabilita los respectivos botones
                if(e.getSource() == btnLanzarJugador1){
                    btnLanzarJugador1.setEnabled(false);
                    btnLanzarJugador2.setEnabled(true);
                    
                } else if (e.getSource() == btnLanzarJugador2){
                    btnLanzarJugador1.setEnabled(true);
                    btnLanzarJugador2.setEnabled(false);
                }
                
                
                //ENCARGADA DE CAMBIAR LOS PNG's DE LOS DADOS
                
                //Obtenemos la ruta absoluta
                String rutaArchivo = new File("").getAbsolutePath();
                
                //Concatenamos la ruta absoluta de "CasinoUnivalle" con la ruta de todos los .png a utilizar
                String dado1Ruta = rutaArchivo.concat("\\src\\imagenes\\dado1.png");
                String dado2Ruta = rutaArchivo.concat("\\src\\imagenes\\dado2.png");
                String dado3Ruta = rutaArchivo.concat("\\src\\imagenes\\dado3.png");
                String dado4Ruta = rutaArchivo.concat("\\src\\imagenes\\dado4.png");
                String dado5Ruta = rutaArchivo.concat("\\src\\imagenes\\dado5.png");
                String dado6Ruta = rutaArchivo.concat("\\src\\imagenes\\dado6.png");
                
                int dado1 = casino.getDado1();
                int dado2 = casino.getDado2();
                
                //Cambio de imágenes para dado1
                if (dado1 == 1){
                    try {
                        imagenDado1 = new File(dado1Ruta);
                        BufferedImage bufferedImagenDado1 = ImageIO.read(imagenDado1);
                        ImageIcon iconDado1 = new ImageIcon(bufferedImagenDado1);
                        
                        //Se agrega imagen
                        lblDado1.setIcon(iconDado1);
                    } catch (IOException ex) {
                        Logger.getLogger(VentanaJuego.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                } else if (dado1 == 2){
                    try {
                        imagenDado1 = new File(dado2Ruta);
                        BufferedImage bufferedImagenDado1 = ImageIO.read(imagenDado1);
                        ImageIcon iconDado1 = new ImageIcon(bufferedImagenDado1);
                        
                        //Se agrega imagen
                        lblDado1.setIcon(iconDado1);
                    } catch (IOException ex) {
                        Logger.getLogger(VentanaJuego.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                } else if (dado1 == 3){
                    try {
                        imagenDado1 = new File(dado3Ruta);
                        BufferedImage bufferedImagenDado1 = ImageIO.read(imagenDado1);
                        ImageIcon iconDado1 = new ImageIcon(bufferedImagenDado1);
                        
                        //Se agrega imagen
                        lblDado1.setIcon(iconDado1);
                    } catch (IOException ex) {
                        Logger.getLogger(VentanaJuego.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                } else if (dado1 == 4){
                    try {
                        imagenDado1 = new File(dado4Ruta);
                        BufferedImage bufferedImagenDado1 = ImageIO.read(imagenDado1);
                        ImageIcon iconDado1 = new ImageIcon(bufferedImagenDado1);
                        
                        //Se agrega imagen
                        lblDado1.setIcon(iconDado1);
                    } catch (IOException ex) {
                        Logger.getLogger(VentanaJuego.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                } else if (dado1 == 5){
                    try {
                        imagenDado1 = new File(dado5Ruta);
                        BufferedImage bufferedImagenDado1 = ImageIO.read(imagenDado1);
                        ImageIcon iconDado1 = new ImageIcon(bufferedImagenDado1);
                        
                        //Se agrega imagen
                        lblDado1.setIcon(iconDado1);
                    } catch (IOException ex) {
                        Logger.getLogger(VentanaJuego.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                } else if (dado1 == 6){
                    try {
                        imagenDado1 = new File(dado6Ruta);
                        BufferedImage bufferedImagenDado1 = ImageIO.read(imagenDado1);
                        ImageIcon iconDado1 = new ImageIcon(bufferedImagenDado1);
                        
                        //Se agrega imagen
                        lblDado1.setIcon(iconDado1);
                    } catch (IOException ex) {
                        Logger.getLogger(VentanaJuego.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                
                //Cambio de imágenes para Dado2
                if (dado2 == 1){
                    try {
                        imagenDado1 = new File(dado1Ruta);
                        BufferedImage bufferedImagenDado1 = ImageIO.read(imagenDado1);
                        ImageIcon iconDado1 = new ImageIcon(bufferedImagenDado1);
                        
                        //Se agrega imagen
                        lblDado2.setIcon(iconDado1);
                    } catch (IOException ex) {
                        Logger.getLogger(VentanaJuego.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                } else if (dado2 == 2){
                    try {
                        imagenDado1 = new File(dado2Ruta);
                        BufferedImage bufferedImagenDado1 = ImageIO.read(imagenDado1);
                        ImageIcon iconDado1 = new ImageIcon(bufferedImagenDado1);
                        
                        //Se agrega imagen
                        lblDado2.setIcon(iconDado1);
                    } catch (IOException ex) {
                        Logger.getLogger(VentanaJuego.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                } else if (dado2 == 3){
                    try {
                        imagenDado1 = new File(dado3Ruta);
                        BufferedImage bufferedImagenDado1 = ImageIO.read(imagenDado1);
                        ImageIcon iconDado1 = new ImageIcon(bufferedImagenDado1);
                        
                        //Se agrega imagen
                        lblDado2.setIcon(iconDado1);
                    } catch (IOException ex) {
                        Logger.getLogger(VentanaJuego.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                } else if (dado2 == 4){
                    try {
                        imagenDado1 = new File(dado4Ruta);
                        BufferedImage bufferedImagenDado1 = ImageIO.read(imagenDado1);
                        ImageIcon iconDado1 = new ImageIcon(bufferedImagenDado1);
                        
                        //Se agrega imagen
                        lblDado2.setIcon(iconDado1);
                    } catch (IOException ex) {
                        Logger.getLogger(VentanaJuego.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                } else if (dado2 == 5){
                    try {
                        imagenDado1 = new File(dado5Ruta);
                        BufferedImage bufferedImagenDado1 = ImageIO.read(imagenDado1);
                        ImageIcon iconDado1 = new ImageIcon(bufferedImagenDado1);
                        
                        //Se agrega imagen
                        lblDado2.setIcon(iconDado1);
                    } catch (IOException ex) {
                        Logger.getLogger(VentanaJuego.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                } else if (dado2 == 6){
                    try {
                        imagenDado1 = new File(dado6Ruta);
                        BufferedImage bufferedImagenDado1 = ImageIO.read(imagenDado1);
                        ImageIcon iconDado1 = new ImageIcon(bufferedImagenDado1);
                        
                        //Se agrega imagen
                        lblDado2.setIcon(iconDado1);
                    } catch (IOException ex) {
                        Logger.getLogger(VentanaJuego.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                
                
                //MODO CPU
                String nombreJugador = casino.getRondas().get(casino.getRondaActual()).getNombreJugador2();
                String nombreCPU = "CPU";
                
                if(nombreJugador.equals(nombreCPU)){
                    if(btnLanzarJugador2.isEnabled() == true){
                        btnLanzarJugador2.doClick();
                    }
                    
                } 
                
            } else {
                //Encargada del tiempo
                lblTiempo.setText("Tiempo transcurrido: " + String.valueOf(k) + " segundos");
                k++;
            }
            
        }
        
    }
    
}
