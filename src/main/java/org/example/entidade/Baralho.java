package org.example.entidade;

import org.example.interfaces.JogadorService;

import java.util.ArrayList;
import java.util.Collections;

import static org.example.entidade.Carta.*;

public class Baralho {
    private ArrayList<Carta> baralho = new ArrayList<>();

    public Baralho() {

        for(NaipeCartas naipe: NaipeCartas.values()){
            for(int j=VALORMINCARTA; j<=VALORMAXCARTA; j++){
                baralho.add(new Carta(j, naipe.getValor()));
            }
        }
    }

    public void embaralhar(){
        Collections.shuffle(baralho);;
    }

    public Carta darCarta(){
        Carta carta = baralho.get(0);
        baralho.remove(0);
        return carta;
    }

    public void devolverCartaToBaralho (Carta carta){
        baralho.add(carta);
    }

    public int contarCartasBaralho(){
        return baralho.size();
    }

    public ArrayList<Carta> getBaralho() {
        return baralho;
    }


}
