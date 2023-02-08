package org.example.entidade;

public class Jogador {

    public static final int QUANTIDADECARTASJOGADOR = 2;

    private String nome;

    private boolean jogando;

    private int montanteFichas;

    private Carta [] cartasJogador = new Carta[QUANTIDADECARTASJOGADOR];


    public Jogador(String nome) {
        this.jogando = true;

        this.nome = nome;

        this.montanteFichas = 10000;
    }

    public void apostar(int valor){
        this.montanteFichas -= valor;
    }

    public void receberPot(int valor){
        this.montanteFichas += valor;
    }

    public String getNome() {
        return nome;
    }

    public boolean isJogando() {
        return jogando;
    }

    public int getMontanteFichas() {
        return montanteFichas;
    }

    public void setJogando(boolean jogando) {
        this.jogando = jogando;
    }

    public Carta[] getCartasJogador() {
        return cartasJogador;
    }

    public Carta getCartaJogador(int posicao) {
        return cartasJogador[posicao];
    }

    public void setCartasJogador(Carta carta, int posicao){
        this.cartasJogador[posicao] = carta;
    }



}
