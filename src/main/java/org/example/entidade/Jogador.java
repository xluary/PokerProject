package org.example.entidade;

public class Jogador {

    public static final int QUANTIDADECARTASJOGADOR = 2;

    private String nome;

    private boolean jogando;

    private int montanteFichas;

    private Carta [] cartasJogador = new Carta[QUANTIDADECARTASJOGADOR];

    public Jogador(String nome) {

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

    public int getMontanteFichas() {
        return montanteFichas;
    }

    public Carta[] getCartasJogador() {
        return cartasJogador;
    }

    public Carta getCartaJogador(int posicao) {
        return cartasJogador[posicao];
    }

    public void receberCartas(Carta[] cartas){
        this.cartasJogador = cartas;
    }

    public boolean isJogando() {
        return jogando;
    }
}
