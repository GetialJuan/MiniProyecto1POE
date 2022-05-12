/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Juan Sebastian Getial Getial <getial.juan@correounivalle.edu.co>
 * @author Sebastian Idrovo Avirama <idrobo.sebastian@correounivalle.edu.co>
 * @profesor Luis Yovany Romo Portilla
 * Clase que representa la logica del casino (juego de dados)
 */
public class Casino 
{
    private List<Ronda> rondas;
    private int rondaActual;
    private int resuldadoDados1;
    private int resuldadoDados2;
    private int dado1;
    private int dado2;
    private int jugadorALanzar;
    private String nombreJugador1;
    private String nombreJugador2;

    public int getResuldadoDados1() {
        return resuldadoDados1;
    }

    public int getResuldadoDados2() {
        return resuldadoDados2;
    }

    public int getJugadorALanzar() {
        return jugadorALanzar;
    }

    public String getNombreJugador1() {
        return nombreJugador1;
    }

    public String getNombreJugador2() {
        return nombreJugador2;
    }
    
    public Casino(String nombreJugador1, String nombreJugador2, int lanzamientosARealizar)
    {
        this.nombreJugador1 = nombreJugador1;
        this.nombreJugador2 = nombreJugador2;
        rondas = new ArrayList();
        rondas.add(new Ronda(nombreJugador1, nombreJugador2));
        rondaActual = 0;
        rondas.get(rondaActual).setLanzamientosARealizar(lanzamientosARealizar);
        System.out.println(nombreJugador2);
        if(!nombreJugador2.equals("CPU"))
        {
            jugadorALanzar = (int) (Math.random() * (3-1)) + 1;
        }
        else
        {
            jugadorALanzar = 1;
        }
    }
    
    public void lanzarDados()
    {   
        rondas.get(rondaActual).
                añadirLanzamientoRealizadoAJugador(jugadorALanzar);
        
        dado1 = (int) (Math.random() * (7-1)) + 1;
        dado2 = (int) (Math.random() * (7-1)) + 1;
        
        switch (jugadorALanzar) 
        {
            case 1:
                resuldadoDados1 = dado1 + dado2;
                //System.out.println("P1 RES: " + resuldadoDados1);
                jugadorALanzar = 2;
                break;
            case 2:
                resuldadoDados2 = dado1 + dado2;
                //System.out.println("P2 RES: " + resuldadoDados2);
                jugadorALanzar = 1;
                break;
            default:
                throw new AssertionError();
        }
        
    }
    
    public void sumarPuntajeDeLanzamiento1(){
        rondas.get(rondaActual).sumarPuntajeAJugador(1, resuldadoDados1);
    }
    
    public void sumarPuntajeDeLanzamiento2(){
        rondas.get(rondaActual).sumarPuntajeAJugador(2, resuldadoDados2);
    }
    
    public void sumarPuntajesDeLanzamiento()
    {
        if(resuldadoDados1 != resuldadoDados2)
        {
            rondas.get(rondaActual).restarLanzamiento();
        }
        else
        {
            rondas.get(rondaActual).añadirLanzamientoEmpatado();
            rondas.get(rondaActual).invalidarLanzamientosPorEmpate();
            rondas.get(rondaActual).sumarPuntajeAJugador(1, -resuldadoDados1);
            rondas.get(rondaActual).sumarPuntajeAJugador(2, -resuldadoDados2);
        }
    }
    
    public void nuevaRondaIgual()
    {
        //Se guardan  y agregan las mismas configutraciones
        int lanzamientosARealizar = rondas.get(rondaActual).getLanzamientosARealizar();
        
        rondas.add(new Ronda(rondas.get(rondaActual).getNombreJugador1(), 
                rondas.get(rondaActual).getNombreJugador2()));
        
        //Se aumenta la ronda actual
        rondaActual += 1;
        
        //Se establecen los mismos lanzamientos
        rondas.get(rondaActual).setLanzamientosARealizar(lanzamientosARealizar);
        setJugadorALanzar();
    }
    
    public void nuevaRondaDiferente(String _nombreJugador1, String _nombreJugador2)
    {
        rondaActual += 1;
        rondas.add(new Ronda(_nombreJugador1, _nombreJugador2));
        setJugadorALanzar();
    }
    
    //Getter's
    public List<Ronda> getRondas() {
        return rondas;
    }

    public int getRondaActual() {
        return rondaActual;
    }

    public int getDado1() {
        return dado1;
    }

    public int getDado2() {
        return dado2;
    }
    
    
    
    //Setters
    public void setNombreJugador1(String nombreJugador1)
    {
        this.nombreJugador1 = nombreJugador1;
    }
    
    public void setNombreJugador2(String nombreJugador2)
    {
        this.nombreJugador2 = nombreJugador2;
    }
    
    public void setLanzamientosARealizar(int lanzamientosARealizar)
    {
        rondas.get(rondaActual).setLanzamientosARealizar(lanzamientosARealizar);
    }
    
    public int getRondaRecord()
    {
        int puntajeRecord = 0;
        int rondaRecord = 0;
        for(int i = 0; i<rondas.size(); i++)
        {
            if(puntajeRecord < rondas.get(i).getPuntajeGanador())
            {
                puntajeRecord = rondas.get(i).getPuntajeGanador();
                rondaRecord = i;
            }
        }
        
        return rondaRecord;
    }
    
    public void setJugadorALanzar()
    {
        if(!rondas.get(getRondaActual()).getNombreJugador2().equals("CPU"))
        {
            jugadorALanzar = (int) (Math.random() * (3-1)) + 1;
        }
        else
        {
            jugadorALanzar = 1;
        }
    }
}
