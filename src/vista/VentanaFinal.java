/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
    private JLabel lblRondaActual;
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
        lblRondaActual = new JLabel(casino.getRondaActual()+"");
        //lblJugadorVencedor = new JLabel(casino)
        
        //Se crea el contenedro principal
        contPrincipal = getContentPane();
        contPrincipal.setLayout(new GridLayout(5,1));
    }
    
    
}
