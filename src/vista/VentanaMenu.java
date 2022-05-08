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
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Juan
 */
public class VentanaMenu extends JFrame{
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
    private JFormattedTextField txtNRondas;
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
    
    private class ManejadorDeEventos implements MouseListener, ActionListener
    {
        public void habilitarNombre2()
        {
            switch (cmbModoDeJuego.getSelectedItem().toString()) 
            {
                case "Solitario":
                    txtNombre2.setEnabled(false);
                    break;
                case "Jugador vs Jugador":
                    txtNombre2.setEnabled(true);
                    break;
                default:
                    throw new AssertionError();
            }
            //if(cmbModoDeJuego.getSelectedItem().toString() == "Solitario")
                
        }

        @Override
        public void mouseClicked(MouseEvent e) 
        {
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

        @Override
        public void actionPerformed(ActionEvent e) {
            
            //Si el btnIniciarJuego es presionado
            if (e.getSource() == btnIniciarJuego){
                JOptionPane.showMessageDialog(null, "El juego ha iniciado");
                
                frame.dispose();
                //Esto se daño: VentanaJuego VentanaDeJuego = new VentanaJuego();
                
                
            
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
            }
            
            
            
            
            
        }
        
    }
}
