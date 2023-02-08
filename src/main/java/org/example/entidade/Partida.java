package org.example.entidade;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Partida {

    public static final int QUANTIDADECARTASCOMUNITARIAS = 5;
    private ArrayList<Jogador> jogadoresPartida;
    private int pot;
    private Carta[] cartasComunitarias = new Carta[QUANTIDADECARTASCOMUNITARIAS];
    private int apostaCorrente;
    private Jogador dealer;

    public Partida(ArrayList<Jogador> jogadoresMao) {
        this.jogadoresPartida = jogadoresMao;
        this.pot = 0;
        this.apostaCorrente = 0;
        this.dealer = definirDealer();
    }

    public void receberAposta(int pot) {
        this.pot += pot;
    }

    public ArrayList<Jogador> getJogadoresPartida() {
        return jogadoresPartida;
    }

    public int getPot() {
        return pot;
    }

    public int getApostaCorrente() {
        return apostaCorrente;
    }

    public void removerJogadorDaPartida(Jogador jogador){
        jogadoresPartida.remove(jogador);
    }

    public Carta getCartaMesa(int posicao){
        return cartasComunitarias[posicao];
    }

    public Jogador getDealer() {
        return dealer;
    }

    public Jogador definirDealer(){
        return getRandomPlayer(jogadoresPartida);
    }

    public Jogador getRandomPlayer(List<Jogador> playes){
        Random rand = new Random();
        return playes.get(rand.nextInt(playes.size()));
    }

    public void receberCartasPartida(Carta[] cartas){
        this.cartasComunitarias = cartas;
    }

}
