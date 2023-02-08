package org.example.entidade;

import org.example.excessoes.LugarOcupadoExpection;
import org.example.interfaces.JogadorService;
import org.example.interfaces.PartidaService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.junit.jupiter.api.Assertions.*;

public class PartidaServiceImplTest {

    Partida partida;
    Mesa mesa;
    Baralho baralho;
    PartidaService partidaService;

    JogadorService jogadas;
    MesaServiceImpl mesaService;

    Jogador jogador1;
    Jogador jogador2;
    Jogador jogador3;

    @BeforeEach
    public void init(){

        jogador1 = new Jogador("Isabella");
        jogador2 = new Jogador("Maria");
        jogador3 = new Jogador("Paulo");

        ArrayList<Jogador> listJogadores = new ArrayList<>();
        listJogadores.add(jogador1);
        listJogadores.add(jogador2);
        listJogadores.add(jogador3);

        mesa = new Mesa();
        mesaService = new MesaServiceImpl(mesa);
        partida = new Partida(listJogadores);
        baralho = new Baralho();
        partidaService = new PartidaServiceImpl(partida, baralho);
    }


    @Test
    void test_SentarNaMesa_quandoLugarOcupado_entaoLancarExcessao() throws LugarOcupadoExpection {

        mesaService.sentarMesa(6, jogador1);
        mesaService.sentarMesa(2, jogador2);

        Exception exception = assertThrows(LugarOcupadoExpection.class, () -> {
            mesaService.sentarMesa(6, jogador3);});
    }

    @Test
    void getJogadoresOrdenados(){

        mesa.sentarNaMesa(6, jogador1);
        mesa.sentarNaMesa(2, jogador2);
        mesa.sentarNaMesa(4, jogador3);
        Map<Jogador, Integer> posicaoJogadores = mesa.getJogadoresNaMesa();

        assertThat(posicaoJogadores).containsExactly(entry(jogador2, 2), entry(jogador3, 4), entry(jogador1, 6));
    }
}