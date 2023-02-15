package org.example.entidade;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BaralhoTest {

    @Test
    void teste_quandoContarBaralhoGerado_entaoDeveConter52cartas(){
        Baralho baralho = new Baralho();
        int esperado = 52;
        int resultado = baralho.contarCartasBaralho();
        assertEquals(esperado, resultado);
    }

    @Test
    void teste_quandoDerUmaCarta_entaoBaralhoDeveConter51cartas(){
        Baralho baralho = new Baralho();
        int esperado = 51;
        baralho.darCarta();
        int resultado = baralho.contarCartasBaralho();
        assertEquals(esperado, resultado);
    }

    @Test
    void teste_quandoDerUmaCartaEDevolverUmaCarta_entaoBaralhoDeveConter52cartas(){
        Baralho baralho = new Baralho();
        int esperado = 52;
        Carta carta = baralho.darCarta();
        baralho.devolverCartaToBaralho(carta);
        int resultado = baralho.contarCartasBaralho();
        assertEquals(esperado, resultado);
    }


}
