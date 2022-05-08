/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Juan
 */
public class VentanaJuego extends JFrame 
{
    private JLabel lblLanzamientosRestantes;
    private JLabel lblLanzamientosJugador1;
    private JLabel lblLanzamientosJugador2;
    private JLabel lblLanzamientosEmpates;
    private JLabel lblJugadorGanador;
    private JLabel lblPuntajeJugador1;
    private JLabel lblPuntajeJugador2;
    private JLabel lblTiempo;
    private JLabel lblJugadorALanzar;
    private JLabel lblDado1;
    private JLabel lblDado2;
    
    //casino
    
    public VentanaJuego()
    {
        iniciarComponentes();
        setSize(700,300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("CasinoUnivalle");
    }
    
    private void iniciarComponentes()
    {
        
    }
    
}
