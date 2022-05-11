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
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import logica.Casino;

/**
 *
 * @author Juan Sebastian Getial <getial.juan@correounivalle.edu.co>
 * @author Sebastian Idrovo Avirama <>
 * Clase que representa la ventana del menu del juego de dados
 */
public class VentanaMenu extends JFrame
{
    //casino
    private Casino casino;
    
    private JFrame frame = new JFrame();
    private Container contenedorPrincipal;
    private JLabel encabezado;
    private JLabel lblModoDeJuego;
    private JLabel lblNRondas;
    private JLabel lblNombre1;
    private JLabel lblNombre2;
    private JComboBox cmbModoDeJuego;
    private JPanel pnlNRondas;
    private JPanel pnlModoDeJuego;
    private JPanel pnlNombres;
    private JTextField txtNRondas;
    private JTextField txtNombre1;
    private JTextField txtNombre2;
    private JButton btnIniciarJuego;
    private File imagenEncabezado;
    
    public VentanaMenu() throws IOException, ParseException
    {
        iniciarComponentes();
        frame.setSize(700,300);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("CasinoUnivalle");
        
    }
    
    //Constructoe que recibe un casino
    public VentanaMenu(Casino casino) throws IOException, ParseException
    {
        this.casino = casino;
        iniciarComponentes();
        frame.setSize(700,300);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("CasinoUnivalle");
    }
    
    private void iniciarComponentes() throws IOException, ParseException
    {
        //Obtenemos la ruta absoluta de "CasinoUnivalle"
        String rutaArchivo = new File("").getAbsolutePath();
        
        //Concatenamos la ruta absoluta de "CasinoUnivalle" con la ruta de casino.png
        String casinoUnivalle = rutaArchivo.concat("\\src\\imagenes\\casino.png");
        
        //Se carga la imagen del encabezado
        imagenEncabezado = new File(casinoUnivalle);
        BufferedImage bufferedImagenEncabezado = ImageIO.read(imagenEncabezado);
        ImageIcon iconEncabezado = new ImageIcon(bufferedImagenEncabezado);
        
        encabezado = new JLabel();
        //Se agrega la imagen del encabezado
        encabezado.setIcon(iconEncabezado);
        
        //Se crea la lista de opciones del n jugadores
        cmbModoDeJuego = new JComboBox<String>();
        cmbModoDeJuego.addItem("Jugador vs CPU");
        cmbModoDeJuego.addItem("Jugador vs Jugador");
        cmbModoDeJuego.addActionListener(new ManejadorDeEventos());
        
        //Se cre la seccion de Mdodo de Juego
        lblModoDeJuego = new JLabel("Seleccione el modo de juego: ");
        lblModoDeJuego.setHorizontalAlignment(SwingConstants.CENTER);
       
        pnlModoDeJuego = new JPanel();
        pnlModoDeJuego.setLayout(new GridLayout(1,2));
        pnlModoDeJuego.add(lblModoDeJuego);
        pnlModoDeJuego.add(cmbModoDeJuego);
        
        //Se cre la seccon de n Rondas
        pnlNRondas = new JPanel();
        pnlNRondas.setLayout(new GridLayout(1,2));
        lblNRondas = new JLabel("Escriba el numero de rondas : ");
        lblNRondas.setHorizontalAlignment(SwingConstants.CENTER);
        txtNRondas = new JTextField("10");
        pnlNRondas.add(lblNRondas);
        pnlNRondas.add(txtNRondas);
        
        //Se crea la nombres de Juagadores
        lblNombre1 = new JLabel("Nombre del Jugador 1");
        lblNombre1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombre2 = new JLabel("Nombre del Jugador 2");
        lblNombre2.setHorizontalAlignment(SwingConstants.CENTER);
        txtNombre1 = new JTextField("Jugador 1");
        txtNombre2 = new JTextField("CPU");
        txtNombre2.setEnabled(false);
        
        pnlNombres = new JPanel();
        pnlNombres.setLayout(new GridLayout(2,2));
        pnlNombres.add(lblNombre1);
        pnlNombres.add(lblNombre2);
        pnlNombres.add(txtNombre1);
        pnlNombres.add(txtNombre2);
        
        //Se instancia el btnInciarjugar
        btnIniciarJuego = new JButton("Iniciar Juego");
        btnIniciarJuego.addActionListener(new ManejadorDeEventos());
        
        //Se crea el contenedro principal
        contenedorPrincipal = getContentPane();
        contenedorPrincipal.setLayout(new GridLayout(5,1));
        contenedorPrincipal.add(encabezado);
        contenedorPrincipal.add(pnlModoDeJuego);
        contenedorPrincipal.add(pnlNRondas);
        contenedorPrincipal.add(pnlNombres);
        contenedorPrincipal.add(btnIniciarJuego);
        
        //Se añade al frame
        frame.add(contenedorPrincipal);
        
    }
    
    private class ManejadorDeEventos implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            
            //Variable que indicara si no se ha cambiado el nombre del jugador 2
            boolean modoCPU = ((cmbModoDeJuego.getSelectedItem().toString()) == "Jugador vs Jugador") && (txtNombre2.getText().equals("CPU"));
            modoCPU = !modoCPU;
            
            //Si el btnIniciarJuego es presionado
            if (e.getSource() == btnIniciarJuego && modoCPU){
                
                JOptionPane.showMessageDialog(null, "El juego ha iniciado");
                
                frame.dispose();
                //Se verifica si hay o no un casino
                if(casino == null)
                {
                    casino = new Casino(txtNombre1.getText(), 
                            txtNombre2.getText(), 
                    Integer.parseInt(txtNRondas.getText()));
                }
                else
                {
                    casino.nuevaRondaDiferente(txtNombre1.getText(), 
                            txtNombre2.getText());
                    casino.setLanzamientosARealizar(
                            Integer.parseInt(txtNRondas.getText()));
                }
                
                //Se crea la ventana del juego
                try {
                    VentanaJuego ventanaJuego = new VentanaJuego(casino); 
                } catch (IOException ex) {
                    Logger.getLogger(VentanaMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            //Si cmbModoDeJuego es presionado
            } else if (e.getSource() == cmbModoDeJuego){
                switch (cmbModoDeJuego.getSelectedItem().toString()) 
                {
                    case "Jugador vs CPU":
                        txtNombre2.setEnabled(false);
                        txtNombre2.setText("CPU");
                        break;
                    case "Jugador vs Jugador":
                        txtNombre2.setEnabled(true);
                        break;
                    default:
                        throw new AssertionError();
                }
                
            } else if (e.getSource() == btnIniciarJuego && modoCPU == false){
                JOptionPane.showMessageDialog(null, "Por favor, cambia el nombre de Jugador2 por uno diferente a -CPU-");
            }
            
        } 
        
    }
}
