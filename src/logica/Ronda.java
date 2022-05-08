/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author Juan
 */
public class Ronda 
{
    private int puntajeJugador1;
    private int puntajeJugador2;
    private int lanzamientosARealizar;
    private int lanzamientosRealizados;
    private int lanzamientosRealizadosJugador1;
    private int lanzamientosRealizadosJugador2;
    private int lanzamientosEmpatados;
    private String nombreJugador1;
    private String nombreJugador2;
    
    public Ronda(String nombreJugador1, String nombreJugador2)
    {
        puntajeJugador1 = 0;
        puntajeJugador2 = 0;
        lanzamientosEmpatados = 0;
        lanzamientosRealizados = 0;
        lanzamientosRealizadosJugador1 = 0;
        lanzamientosRealizadosJugador2 = 0;
        this.nombreJugador1 = nombreJugador1;
        this.nombreJugador2 = nombreJugador2;
    }
    
    public void sumarPuntajeAJugador(int cualJugador, int puntajeASumar)
    {
        switch (cualJugador) {
            case 1:
                puntajeJugador1 += puntajeASumar;
                añadirLanzamientoRealizadoAJugador(1);
                break;
            case 2:
                puntajeJugador2 += puntajeASumar;
                añadirLanzamientoRealizadoAJugador(2);
                break;
            default:
                throw new AssertionError();
        }
        
        añadirLanzamientoRealizado();
    }
    
    public void añadirLanzamientoEmpatado()
    {
        lanzamientosEmpatados += 1;
    }
    
    public void añadirLanzamientoRealizado()
    {
        lanzamientosRealizados += 1;
    }
    
    public void añadirLanzamientoRealizadoAJugador(int cualJugador)
    {
        switch (cualJugador) {
            case 1:
                lanzamientosRealizadosJugador1 += 1;
                break;
            case 2:
                lanzamientosRealizadosJugador2 += 1;
            default:
                throw new AssertionError();
        }
    }
    
    public void invalidarLanzamientosPorEmpate()
    {
        lanzamientosRealizados -= 1;
        lanzamientosRealizadosJugador1 -= 1;
        lanzamientosRealizadosJugador2 -= 1;
    }
    
    public void setLanzamientosARealizar(int lanzamientosARealizar)
    {
        this.lanzamientosARealizar = lanzamientosARealizar;
    }
    
}
