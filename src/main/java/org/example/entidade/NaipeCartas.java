package org.example.entidade;

public enum NaipeCartas {
    COPAS(1, "♥"),
    ESPADAS(2,"♠"),
    PAUS(3, "♣"),
    OUROS(4, "♦");

    private int valor;

    private String naipe;

    private NaipeCartas(int valor, String naipe) {
        this.valor = valor;
        this.naipe = naipe;
    }

    public static final int quantidadeNaipes= NaipeCartas.values().length;

    public static NaipeCartas fromValor(int valor){
        for(NaipeCartas naipeCarta: NaipeCartas.values()){
            if(naipeCarta.getValor() == valor){
                return naipeCarta;
            }
        }
        throw new RuntimeException("Naipe Inválido!");
    }

    public int getValor() {

        return valor;
    }

    public String getNaipe() {
        return naipe;
    }
}
