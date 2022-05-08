/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import logica.Casino;

/**
 *
 * @author Juan
 */
public class VentanaFinal extends JFrame 
{
    //Casino
    private Casino casino;
    //Datos Ronda Finalizada
    private JLabel lblJugadorVencedor;
    private JLabel lblPuntajeVencedor;
    private JLabel lblJugadorPerdedor;
    private JLabel lblPuntajePerdedor;
    private JLabel lblCantidadDeLanzamientos;
    private JLabel lblCantidadDeEmpates;
    
    //Datos Rondas En General
    private JLabel lblJugadorConElRecord;
    private JLabel lblPuntajeRecord;
    private JLabel lblRondaDePuntajeRecord;
    
    //Botones
    private JButton btnNuevaRondaConLosMismosJugadores;
    private JButton btnNuevaRondaConOtrosJugadores;
    private JButton btnSalir;
    
    //Secciones
    private JPanel pnlEstadisticasDeRonda;
        //Tirulo
    private JLabel lblRondaActual;
    
    private JPanel pnlEstadisticasGenerales;
        //Titulo
    private JLabel lblEstadisticasGenerales;
    
    private JPanel pnlOpcionesDeNuevaRonda;
    
    //
    private Container contPrincipal;
    
    public VentanaFinal(Casino casino)
    {
        this.casino = casino;
        iniciarComponentes();
        setSize(700,300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("CasinoUnivalle");
    }
    
    private void iniciarComponentes()
    {
        //Seccion estadisticas de Ronda
        lblRondaActual = new JLabel("Ronda "+casino.getRondaActual()+"");
        lblRondaActual.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblJugadorVencedor = new JLabel("Ganador: ");
        lblJugadorPerdedor = new JLabel("Perdedor");
        lblPuntajeVencedor = new JLabel("Puntaje: ");
        lblPuntajePerdedor = new JLabel("Puntaje: ");
        lblCantidadDeLanzamientos = new JLabel("Lanzamientos realizados: ");
        lblCantidadDeEmpates = new JLabel("Empates: ");
        
        pnlEstadisticasDeRonda = new JPanel();
        pnlEstadisticasDeRonda.setLayout(new GridLayout(3,2));
        pnlEstadisticasDeRonda.add(lblJugadorVencedor);
        pnlEstadisticasDeRonda.add(lblJugadorPerdedor);
        pnlEstadisticasDeRonda.add(lblPuntajeVencedor);
        pnlEstadisticasDeRonda.add(lblPuntajePerdedor);
        pnlEstadisticasDeRonda.add(lblCantidadDeLanzamientos);
        pnlEstadisticasDeRonda.add(lblCantidadDeEmpates);
        
        //Seccion de estadisticas generales
        lblEstadisticasGenerales = new JLabel("Estadisticas Generales");
        lblEstadisticasGenerales.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblPuntajeRecord = new JLabel("Puntaje record: ");
        lblJugadorConElRecord = new JLabel("Hecho por: ");
        lblRondaDePuntajeRecord = new JLabel("En la ronda: ");
        
        pnlEstadisticasGenerales = new JPanel();
        pnlEstadisticasGenerales.setLayout(new GridLayout(1,3));
        pnlEstadisticasGenerales.add(lblPuntajeRecord);
        pnlEstadisticasGenerales.add(lblJugadorConElRecord);
        pnlEstadisticasGenerales.add(lblRondaDePuntajeRecord);
        
        //Seccion de nueva ronda
        btnNuevaRondaConLosMismosJugadores = new JButton("Nueva Ronda Igual");
        btnNuevaRondaConOtrosJugadores = new JButton("Nueva Ronda Diferente");
        btnSalir = new JButton("Salir Del Juego");
        
        pnlOpcionesDeNuevaRonda = new JPanel();
        pnlOpcionesDeNuevaRonda.setLayout(new GridLayout(1,3));
        pnlOpcionesDeNuevaRonda.add(btnNuevaRondaConLosMismosJugadores);
        pnlOpcionesDeNuevaRonda.add(btnNuevaRondaConOtrosJugadores);
        pnlOpcionesDeNuevaRonda.add(btnSalir);
        
        //Se crea el contenedro principal
        contPrincipal = getContentPane();
        contPrincipal.setLayout(new GridLayout(5,1));
        contPrincipal.add(lblRondaActual);
        contPrincipal.add(pnlEstadisticasDeRonda);
        contPrincipal.add(lblEstadisticasGenerales);
        contPrincipal.add(pnlEstadisticasGenerales);
        contPrincipal.add(pnlOpcionesDeNuevaRonda);
        
        //Se agregan los listeners
        btnNuevaRondaConOtrosJugadores.addMouseListener(new ManejadorDeEventos());
    }
    
    private class ManejadorDeEventos implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource() == btnNuevaRondaConOtrosJugadores)
            {
                try {
                    VentanaMenu ventanaMenu = new VentanaMenu(casino);
                } catch (IOException | ParseException ex) {
                    Logger.getLogger(VentanaFinal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(e.getSource() == btnNuevaRondaConLosMismosJugadores)
            {
                //esto tal vez se implemente asi
                //VentanaJuego ventanaJuego = new VentanaJuego(casino);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    }
    
}
