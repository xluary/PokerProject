package org.example.entidade;

import org.example.interfaces.JogadorService;
import org.example.interfaces.PartidaService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

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

//    @BeforeEach
//    public void init(){
//
//        jogador1 = new Jogador("Isabella");
//        jogador2 = new Jogador("Maria");
//        jogador3 = new Jogador("Paulo");
//
//        ArrayList<Jogador> listJogadores = new ArrayList<>();
//        listJogadores.add(jogador1);
//        listJogadores.add(jogador2);
//        listJogadores.add(jogador3);
//
//        mesa = new Mesa();
//        mesaService = new MesaServiceImpl(mesa);
//        partida = new Partida(mesa);
//        baralho = new Baralho();
//        partidaService = new PartidaServiceImpl(partida, baralho, mesaService);
//    }

    @Test
    void testePartidaService_quandoDarCartasMesa_entaoCartasPartidaRecebe5Cartas()  {
        jogador1 = new Jogador("Isabella");
        jogador2 = new Jogador("Maria");
        jogador3 = new Jogador("Paulo");

        ArrayList<Jogador> listJogadores = new ArrayList<>();
        listJogadores.add(jogador1);
        listJogadores.add(jogador2);
        listJogadores.add(jogador3);

        mesa = new Mesa();
        mesaService = new MesaServiceImpl(mesa);
        partida = new Partida(mesaService);
        baralho = new Baralho();
        partidaService = new PartidaServiceImpl(partida, baralho, mesaService);


        partidaService.darCartasMesa();
        int quantidadeCartasEsperado = 5;
        int quantidadeCartasResultado = partida.getCartasComunitarias().length;
        Assertions.assertEquals(quantidadeCartasEsperado, quantidadeCartasResultado);
    }

    @Test
    void testePartidaService_quandoVirarCartasFlop_entaoCartas123Copas()  {
        partidaService.darCartasMesa();
        Carta[] cartas = partidaService.virarCartasFlop();
    }
}