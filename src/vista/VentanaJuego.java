/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
 * @author Juan
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
        lblTitulo = new JLabel("JUEGO DE DADOS");  
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        
        //Timer
        lblTiempo = new JLabel("Tiempo aquí");
        TimerTiempo = new Timer(1000, new ManejadorDeEventos());
        TimerTiempo.start();
        
        //JugadorGanador
        lblJugadorGanador = new JLabel ("Jugador parcialmente ganador: ");
        
        //LanzamientosARealizar
        lblLanzamientosARealizar = new JLabel("Lanzamientos a realizar: " + 
                casino.getRondas().get(casino.getRondaActual()).
                        getLanzamientosARealizar());
        
        //LanzamientosRealizados
        lblLanzamientosRestantes = new JLabel("Lanzamientos restantes: " + 
                casino.getRondas().get(casino.getRondaActual()).getLanzamientosRestantes());
        
        //LanzamientosEmpates
        lblLanzamientosEmpates = new JLabel ("Lanzamientos con empate: " + 
                casino.getRondas().get(casino.getRondaActual()).
                        getLanzamientosEmpatados());
        
        //Dados
        imagenDado1 = new File(dado1Ruta);
        BufferedImage bufferedImagenDado1 = ImageIO.read(imagenDado1);
        ImageIcon iconDado1 = new ImageIcon(bufferedImagenDado1);
        lblDado1 = new JLabel();
        
            //Se agrega imagen
        lblDado1.setIcon(iconDado1);
        
        imagenDado2 = new File(dado2Ruta);
        BufferedImage bufferedImagenDado2 = ImageIO.read(imagenDado2);
        ImageIcon iconDado2 = new ImageIcon(bufferedImagenDado2);
        lblDado2 = new JLabel();
        
            //Se agrega imagen
        lblDado2.setIcon(iconDado2);
        
        //JugadorALanzar
        
        String jugadorALanzar;
        switch (casino.getJugadorALanzar()) {
            case 1:
                jugadorALanzar = casino.getRondas().get(casino.
                        getRondaActual()).getNombreJugador1();
                break;
            case 2:
                jugadorALanzar = casino.getRondas().get(casino.
                        getRondaActual()).getNombreJugador2();
                break;
            default:
                throw new AssertionError();
        }
        lblJugadorALanzar = new JLabel ("Próximo jugador a lanzar: " + 
                jugadorALanzar);
        
        
        
        //Parte Inferior
        
        //Parte izquierda
        //NombreJugador1
        lblNombreJugador1 = new JLabel (casino.getRondas().get(casino.
                getRondaActual()).getNombreJugador1());
        
        //LanzamientosJugador1
        lblLanzamientosJugador1 = new JLabel ("Lanzamientos: " + casino.
                getRondas().get(casino.getRondaActual()).
                getLanzamientosRealizadosJugador1() + "");
        
        //PuntajeJugador1
        lblPuntajeJugador1 = new JLabel ("Puntaje: " + casino.getRondas().
                get(casino.getRondaActual()).getPuntajeJugador1() + "");
        
        //LanzarJugador1
        btnLanzarJugador1 = new JButton ("Lanzar");
        btnLanzarJugador1.addMouseListener(new ManejadorDeEventos());
        
        
        //Parte Derecha
        //NombreJugador2
        lblNombreJugador2 = new JLabel (casino.getRondas().get(casino.
                getRondaActual()).getNombreJugador2());
        
        //LanzamientosJugador2
        lblLanzamientosJugador2 = new JLabel ("Lanzamientos: " + casino.
                getRondas().get(casino.getRondaActual()).
                getLanzamientosRealizadosJugador2()+ "");
        
        //PuntajeJugador2
        lblPuntajeJugador2 = new JLabel ("Puntaje: " + casino.getRondas().get(casino.
                getRondaActual()).getPuntajeJugador2() + "");
        
        //LanzarJugador2
        btnLanzarJugador2 = new JButton ("Lanzar");
        btnLanzarJugador2.addMouseListener(new ManejadorDeEventos());
        
        
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
        pnlSuperior.setLayout(new GridLayout(6,1));
        pnlSuperior.add(lblEncabezado);
        pnlSuperior.add(lblTitulo);
        pnlSuperior.add(pnlSuperior2);
        pnlSuperior.add(lblLanzamientosEmpates);
        pnlSuperior.add(pnlDados);
        pnlSuperior.add(lblJugadorALanzar);
        
        //pnlInferior
        pnlInferior = new JPanel();
        pnlInferior.setLayout(new GridLayout(1,2));
        pnlInferior.add(pnlInferiorJugador1);
        pnlInferior.add(pnlInferiorJugador2);
        
        //contenedorPrincipal
        contenedorPrincipal = new Container();
        contenedorPrincipal.setLayout(new GridLayout(2,1));
        contenedorPrincipal.add(pnlSuperior);
        contenedorPrincipal.add(pnlInferior);
        
        //Se añade al Frame
        frame.add(contenedorPrincipal);
        
        
                
            
        
        
        
        
        
    }
    
    private class ManejadorDeEventos implements MouseListener, ActionListener
    {
        private int contadorLanzamientos = 0;
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource() == btnLanzarJugador1 || e.getSource() == btnLanzarJugador2)
            {
                casino.lanzarDados();
                contadorLanzamientos += 1;
                
                //Cada dos lanzamientos se suman los puntajes de caja jugador
                if(contadorLanzamientos % 2 == 0)
                {
                    casino.sumarPuntajesDeLanzamiento();
                }
                
                //Se cambia el juagador a a lanzr
                String jugadorALanzar;
                switch (casino.getJugadorALanzar()) {
                    case 1:
                        jugadorALanzar = casino.getRondas().get(casino.
                                getRondaActual()).getNombreJugador1();
                        break;
                    case 2:
                        jugadorALanzar = casino.getRondas().get(casino.
                                getRondaActual()).getNombreJugador2();;
                        break;
                    default:
                        throw new AssertionError();
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
                
            }
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            ///throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            lblTiempo.setText("Tiempo transcurrido: " + String.valueOf(k) + " segundos");
            k++;
        }
        
    }
    
}
