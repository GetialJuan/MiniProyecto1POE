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
    
    public Casino()
    {
        rondas = new ArrayList();
        rondas.add(new Ronda());
        rondaActual = 0;
        jugadorALanzar = (int) (Math.random() * (2-1));
    }
    
    public void lanzarDados()
    {
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
            rondas.get(rondaActual).sumarPuntajeAJugador(1, resuldadoDados1);
            rondas.get(rondaActual).sumarPuntajeAJugador(2, resuldadoDados2);
        }
    }
    
    public void jugarOtraRonda()
    {
        rondas.add(new Ronda());
        rondaActual += 1;
    }
}
