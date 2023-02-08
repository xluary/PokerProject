package org.example.entidade;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mao {

    public static final int QUANTIDADECARTASMESA = 5;

    private Mesa mesa;
    private ArrayList<Jogador> jogadoresMao;
    private int pot;

    private Carta[] cartaMesa = new Carta[QUANTIDADECARTASMESA];

    private int apostaCorrente;

    private Jogador dealer;

    public Mao(Mesa mesa, ArrayList<Jogador> jogadoresMao) {
        this.jogadoresMao = jogadoresMao;
        this.pot = 0;
        this.apostaCorrente = 0;
        this.mesa = mesa;
        this.dealer = definirDealer();
    }

    public void setPot(int pot) {
        this.pot = pot;
    }

    public ArrayList<Jogador> getJogadoresMao() {
        return jogadoresMao;
    }

    public int getPot() {
        return pot;
    }

    public int getApostaCorrente() {
        return apostaCorrente;
    }

    public void setApostaCorrente(int apostaCorrente) {
        this.apostaCorrente = apostaCorrente;
    }

    public void removerJogadorDaMao(Jogador jogador){
        jogadoresMao.remove(jogador);
    }

    public Carta[] getCartasMesa() {
        return cartaMesa;
    }

    public Carta getCartaMesa(int posicao){
        return cartaMesa[posicao];
    }

    public void setCartaMesa(Carta[] cartaMesa) {
        this.cartaMesa = cartaMesa;
    }

    public Jogador getDealer() {
        return dealer;
    }

    public Jogador definirDealer(){
        return getRandomPlayer(jogadoresMao);
    }

    public Jogador getRandomPlayer(List<Jogador> playes){
        Random rand = new Random();
        return playes.get(rand.nextInt(playes.size()));
    }

}
