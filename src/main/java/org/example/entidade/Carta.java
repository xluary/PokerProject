package org.example.entidade;

import static org.example.entidade.NaipeCartas.fromValor;

public class Carta implements Comparable<Carta>{

    private int numero;
    private int naipe;

    public static final int VALORMINCARTA = 1;
    public static final int VALORMAXCARTA = 13;

    public Carta(int numero, int naipe) {
        this.numero = numero;
        this.naipe = naipe;
    }

    public static String converterNumeroToFigura(int numero){
        String tipoFigura = null;
        switch (numero) {
            case 1:
                tipoFigura = "A";
                break;
            case 11:
                tipoFigura = "J";
                break;
            case 12:
                tipoFigura = "Q";
                break;
            case 13:
                tipoFigura = "K";
                break;
            default:
                tipoFigura = Integer.toString(numero);
        }
        return tipoFigura;
    }

    public static int converterFiguraToNumero(String figura){
        int tipoNumero = 0;
        switch (figura) {
            case "A":
                tipoNumero = 1;
                break;
            case "J":
                tipoNumero = 11;
                break;
            case "Q":
                tipoNumero = 12;
                break;
            case "K":
                tipoNumero = 13;
                break;
            default:
                tipoNumero = Integer.parseInt(figura);
        }
        return tipoNumero;
    }

    public String getCartaComNaipe(){
        return String.format("%s  %s \n", converterNumeroToFigura(numero), fromValor(naipe).getNaipe());
    }

    public int getNumero() {
        return numero;
    }

    public int getNaipe() {
        return naipe;
    }

    @Override
    public int compareTo(Carta outraCarta) {
        return (this.numero-outraCarta.getNumero());
    }
}
