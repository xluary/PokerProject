package org.example.entidade;

import org.example.interfaces.JogadorService;
import org.example.interfaces.PartidaService;

import java.util.List;
import java.util.Random;

import static org.example.entidade.Jogador.QUANTIDADECARTASJOGADOR;
import static org.example.entidade.Mao.QUANTIDADECARTASMESA;


public class PartidaServiceImpl implements PartidaService {

    private int QUANTIDADECARTASFLOP = 3;

    private int CARTATURN = 4;

    private int CARTARIVER = 5;

    private Mao mao;
    private Mesa mesa;
    private Baralho baralho;
    JogadorService jogadas;



    public PartidaServiceImpl(Mao mao, Mesa mesa, Baralho baralho) {
        this.mao = mao;
        this.mesa = mesa;
        this.baralho = baralho;
        this.jogadas = jogadas;
    }

    @Override
    public void embaralhar() {
        baralho.embaralhar();
    }

    @Override
    public void darCartasJogadores() {
        for (Jogador jogador: mao.getJogadoresMao()) {
            for (int i= 0; i<QUANTIDADECARTASJOGADOR; i++){
                Carta carta = baralho.darCarta();
                jogador.setCartasJogador(carta, i);
            }
        }

    }

    @Override
    public void darCartasMesa() {
        Carta[] cartasDaMao = new Carta[QUANTIDADECARTASMESA];
        for(int i=0; i<cartasDaMao.length; i++){
            Carta carta = baralho.darCarta();
            cartasDaMao[i]= carta;
        }
        mao.setCartaMesa(cartasDaMao);
    }

    @Override
    public void definirJogadorDaVez() {


    }

    @Override
    public void virarCartasFlop() {
        for(int i=0; i<QUANTIDADECARTASFLOP; i++){
            System.out.println(mao.getCartaMesa(i).getCartaComNaipe());
        }
    }

    @Override
    public void virarCartasTurn() {

        System.out.println(mao.getCartaMesa(CARTATURN).getCartaComNaipe());
    }

    @Override
    public void virarCartasRives() {
        System.out.println(mao.getCartaMesa(CARTARIVER).getCartaComNaipe());

    }


}
