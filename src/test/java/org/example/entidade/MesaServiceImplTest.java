package org.example.entidade;

import org.example.excessoes.LugarOcupadoExpection;
import org.example.interfaces.PartidaService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class MesaServiceImplTest {

    Partida partida;
    Mesa mesa;
    Baralho baralho;
    PartidaService partidaService;

    MesaServiceImpl mesaService;

    Jogador jogador1;
    Jogador jogador2;
    Jogador jogador3;

    @BeforeEach
    public void init(){

        jogador1 = new Jogador("Isabella");
        jogador2 = new Jogador("Maria");
        jogador3 = new Jogador("Paulo");

        mesa = new Mesa();
        mesaService = new MesaServiceImpl(mesa);
    }


    @Test
    void testeClasseMesa_quandoSentarNaMesaELugarOcupado_entaoLancarExcessao() throws LugarOcupadoExpection {

        mesaService.sentarMesa(6, jogador1);
        mesaService.sentarMesa(2, jogador2);

        Exception exception = assertThrows(LugarOcupadoExpection.class, () -> {
            mesaService.sentarMesa(6, jogador3);});
    }

    @Test
    void testeClasseMesa_quandoJogadoresSentaremMesa_entaoRetornaJogadoresOrdenados() throws LugarOcupadoExpection {

        mesaService.sentarMesa(6, jogador1);
        mesaService.sentarMesa(2, jogador2);
        mesaService.sentarMesa(4, jogador3);
        Map<Jogador, Integer> posicaoJogadores = mesa.getJogadoresNaMesa();

        assertThat(posicaoJogadores).containsExactly(entry(jogador2, 2), entry(jogador3, 4), entry(jogador1, 6));
    }

    @Test
    void testeClasseMesa_quandoJogadorLevantarMesa_entaoReduzONumeroDeJogadores() throws LugarOcupadoExpection {

        mesaService.sentarMesa(6, jogador1);
        mesaService.sentarMesa(2, jogador2);
        mesaService.sentarMesa(4, jogador3);

        int quantidadeJogadoresEsperado = 3;
        int quantidadeJogadoresNaMesa= mesaService.quantidadeJogadoresNaMesa();
        assertEquals(quantidadeJogadoresEsperado, quantidadeJogadoresNaMesa);

        mesaService.levantarMesa(jogador1);
        int quantidadeJogadoresEsperadoAtulizado = 2;
        int quantidadeAtualizadaJogadores = mesaService.quantidadeJogadoresNaMesa();
        assertEquals(quantidadeJogadoresEsperadoAtulizado, quantidadeAtualizadaJogadores);
    }

}