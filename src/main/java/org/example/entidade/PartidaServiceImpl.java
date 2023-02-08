package org.example.entidade;

import org.example.interfaces.PartidaService;

import static org.example.entidade.Jogador.QUANTIDADECARTASJOGADOR;
import static org.example.entidade.Partida.QUANTIDADECARTASCOMUNITARIAS;


public class PartidaServiceImpl implements PartidaService {

    private int QUANTIDADECARTASFLOP = 3;

    private int CARTATURN = 4;

    private int CARTARIVER = 5;

    private Partida partida;
    private Baralho baralho;


    public PartidaServiceImpl(Partida partida, Baralho baralho) {
        this.partida = partida;
        this.baralho = baralho;
    }

    @Override
    public void embaralhar() {
        baralho.embaralhar();
    }

    @Override
    public void darCartasJogadores() {
        for (Jogador jogador: partida.getJogadoresPartida()) {
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
    public void definirJogadorDaVez() {


    }

    @Override
    public void virarCartasFlop() {
        for(int i=0; i<QUANTIDADECARTASFLOP; i++){
            System.out.println(partida.getCartaMesa(i).getCartaComNaipe());
        }
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
