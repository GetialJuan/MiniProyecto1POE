/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class Casino 
{
    private List<Ronda> rondas;
    private int rondaActual;
    private int resuldadoDados1;
    private int resuldadoDados2;
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
        jugadorALanzar = (int) (Math.random() * (3-1)) + 1;
    }
    
    public void lanzarDados()
    {
        rondas.get(rondaActual).
                añadirLanzamientoRealizadoAJugador(jugadorALanzar);
        
        int dado1 = (int) (Math.random() * (6-1));
        int dado2 = (int) (Math.random() * (6-1));
        
        switch (jugadorALanzar) 
        {
            case 1:
                resuldadoDados1 = dado1 + dado2;
                jugadorALanzar = 2;
                break;
            case 2:
                resuldadoDados2 = dado1 + dado2;
                jugadorALanzar = 1;
                break;
            default:
                throw new AssertionError();
        }
        
    }
    
    public void sumarPuntajesDeLanzamiento()
    {
        if(resuldadoDados1 != resuldadoDados2)
        {
            rondas.get(rondaActual).restarLanzamiento();
            rondas.get(rondaActual).sumarPuntajeAJugador(1, resuldadoDados1);
            rondas.get(rondaActual).sumarPuntajeAJugador(2, resuldadoDados2);
        }
        else
        {
            rondas.get(rondaActual).añadirLanzamientoEmpatado();
            rondas.get(rondaActual).invalidarLanzamientosPorEmpate();
        }
    }
    
    public void nuevaRonda()
    {
        rondas.add(new Ronda(nombreJugador1, nombreJugador2));
        rondaActual += 1;
    }
    
    public List<Ronda> getRondas() {
        return rondas;
    }

    public int getRondaActual() {
        return rondaActual;
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
                rondaRecord = i;
            }
        }
        
        return rondaRecord;
    }
}
