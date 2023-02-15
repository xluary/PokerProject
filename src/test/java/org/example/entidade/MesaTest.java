package org.example.entidade;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MesaTest {

    @Test
    public void quandoSentarNaMesa_EntaoNumeroDeJogadoresNaMesaIgualUm(){
        Mesa mesa = new Mesa();
        Jogador jogador = new Jogador("Isabella");
        mesa.sentarNaMesa(1, jogador);
        int resultado = mesa.quantidadeDePessoasNaMesa();
        int esperado = 1;
        assertEquals(esperado, resultado);
    }

    @Test
    public void quandoLevantarDaMesa_EntaoNumeroDeJogadoresIgualZero(){
        Mesa mesa = new Mesa();
        Jogador jogador = new Jogador("Isabella");
        mesa.sentarNaMesa(1, jogador);
        mesa.levantarDaMesa(jogador);
        int esperado = 0;
        int resultado = mesa.quantidadeDePessoasNaMesa();
        assertEquals(esperado, resultado);
    }

}
