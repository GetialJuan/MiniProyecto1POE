/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author Juan Sebastian Getial Getial <getial.juan@correounivalle.edu.co>
 * @author Sebastian Idrovo Avirama <idrobo.sebastian@correounivalle.edu.co>
 * @profesor Luis Yovany Romo Portilla
 * Clase que representa una ronda del juego de dados
 */
public class Ronda 
{
    private int puntajeJugador1;
    private int puntajeJugador2;
    private int lanzamientosARealizar;
    private int lanzamientosRestantes;
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
        lanzamientosRealizadosJugador1 = 0;
        lanzamientosRealizadosJugador2 = 0;
        this.nombreJugador1 = nombreJugador1;
        this.nombreJugador2 = nombreJugador2;
    }

    public int getPuntajeJugador1() {
        return puntajeJugador1;
    }

    public int getPuntajeJugador2() {
        return puntajeJugador2;
    }

    public int getLanzamientosARealizar() {
        return lanzamientosARealizar;
    }

    public int getLanzamientosRestantes() {
        return lanzamientosRestantes;
    }

    public int getLanzamientosRealizadosJugador1() {
        return lanzamientosRealizadosJugador1;
    }

    public int getLanzamientosRealizadosJugador2() {
        return lanzamientosRealizadosJugador2;
    }

    public int getLanzamientosEmpatados() {
        return lanzamientosEmpatados;
    }

    public String getNombreJugador1() {
        return nombreJugador1;
    }

    public String getNombreJugador2() {
        return nombreJugador2;
    }
    
    public String getGanador()
    {
        if(puntajeJugador1 > puntajeJugador2)
        {
            return nombreJugador1;
        }
        else
        {
            return nombreJugador2;
        }
    }
    
    public String getPerdedor()
    {
        if(puntajeJugador1 < puntajeJugador2)
        {
            return nombreJugador1;
        }
        else
        {
            return nombreJugador2;
        }
    }
    
    public int getPuntajeGanador()
    {
        if(puntajeJugador1 > puntajeJugador2)
        {
            return puntajeJugador1;
        }
        else
        {
            return puntajeJugador2;
        }
    }
    
    public int getPuntajePerdedor()
    {
        if(puntajeJugador1 < puntajeJugador2)
        {
            return puntajeJugador1;
        }
        else
        {
            return puntajeJugador2;
        }
    }
    
    public void sumarPuntajeAJugador(int cualJugador, int puntajeASumar)
    {
        switch (cualJugador) {
            case 1:
                puntajeJugador1 += puntajeASumar;
                break;
            case 2:
                puntajeJugador2 += puntajeASumar;
                break;
            default:
                throw new AssertionError();
        }
    }
    
    public void añadirLanzamientoEmpatado()
    {
        lanzamientosEmpatados += 1;
    }
    
    public void restarLanzamiento()
    {
        lanzamientosRestantes -= 1;
    }
    
    public void añadirLanzamientoRealizadoAJugador(int cualJugador)
    {
        switch (cualJugador) {
            case 1:
                lanzamientosRealizadosJugador1 += 1;
                break;
            case 2:
                lanzamientosRealizadosJugador2 += 1;
                break;
            default:
                throw new AssertionError();
        }
    }
    
    public void invalidarLanzamientosPorEmpate()
    {
        lanzamientosRealizadosJugador1 -= 1;
        lanzamientosRealizadosJugador2 -= 1;
    }
    
    public void setLanzamientosARealizar(int lanzamientosARealizar)
    {
        this.lanzamientosARealizar = lanzamientosARealizar;
        lanzamientosRestantes = lanzamientosARealizar;
    }
    
}
