package org.example.entidade;

import org.example.interfaces.MesaService;
import org.example.interfaces.PartidaService;

import java.util.Map;

import static org.example.entidade.Jogador.QUANTIDADECARTASJOGADOR;
import static org.example.entidade.Partida.QUANTIDADECARTASCOMUNITARIAS;


public class PartidaServiceImpl implements PartidaService {

    private int QUANTIDADECARTASFLOP = 3;

    private int CARTATURN = 4;

    private int CARTARIVER = 5;

    private Partida partida;
    private Baralho baralho;

    private MesaService mesa;


    public PartidaServiceImpl(Partida partida, Baralho baralho, MesaService mesa) {
        this.mesa = mesa;
        this.partida = partida;
        this.baralho = baralho;
    }

    @Override
    public void embaralhar() {
        baralho.embaralhar();
    }

    @Override
    public void darCartasJogadores() {
        for (Map.Entry<Jogador, Integer> jogadoresPosicao: partida.getJogadoresNaPartida().entrySet()) {
            Jogador jogador = jogadoresPosicao.getKey();
            Carta[] cartasJogador = new Carta[QUANTIDADECARTASJOGADOR];
            for (int i= 0; i< cartasJogador.length; i++){
                Carta carta = baralho.darCarta();
                cartasJogador[i]= carta;
            }
            jogador.receberCartas(cartasJogador);
        }

    }

    @Override
    public void darCartasMesa() {
        Carta[] cartasComunitarias = new Carta[QUANTIDADECARTASCOMUNITARIAS];
        for(int i=0; i< cartasComunitarias.length; i++){
            Carta carta = baralho.darCarta();
            cartasComunitarias[i]= carta;
        }
        partida.receberCartasPartida(cartasComunitarias);
    }

    @Override
    public void definirJogadorDaVez(int posicaoUltimoJogador) {



    }

    @Override
    public Carta[] virarCartasFlop() {
        Carta[] cartasFlop = new Carta[QUANTIDADECARTASFLOP];
        for(int i=0; i<QUANTIDADECARTASFLOP; i++){
            cartasFlop[i]= partida.getCartaMesa(i);
        }
        return cartasFlop;
    }

    @Override
    public void virarCartasTurn() {

        System.out.println(partida.getCartaMesa(CARTATURN).getCartaComNaipe());
    }

    @Override
    public void virarCartasRives() {
        System.out.println(partida.getCartaMesa(CARTARIVER).getCartaComNaipe());

    }


}
