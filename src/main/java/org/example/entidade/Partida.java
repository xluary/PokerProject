package org.example.entidade;

import org.example.interfaces.MesaService;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class Partida {

    public static final int QUANTIDADECARTASCOMUNITARIAS = 5;
    private Map<Jogador, Integer> jogadoresPartida;
    private int pot;
    private Carta[] cartasComunitarias = new Carta[QUANTIDADECARTASCOMUNITARIAS];
    private int apostaCorrente;
    private Jogador dealer;

    private MesaService mesa;

    public Partida(MesaService mesaService) {
        this.mesa = mesaService;
        this.pot = 0;
        this.apostaCorrente = 0;
        this.dealer = definirDealer();
    }

    public Map<Jogador, Integer> getJogadoresNaPartida(){
      Map<Jogador, Integer> jogadoresJogando= mesa.getJogadoresNaMesa();
      for(Map.Entry<Jogador, Integer> entry: mesa.getJogadoresNaMesa().entrySet()){
          if(entry.getKey().isJogando()){
              jogadoresJogando.put(entry.getKey(), entry.getValue());
          }

      }
        this.jogadoresPartida = jogadoresJogando;
        return jogadoresJogando;
    }

    public void receberAposta(int pot) {
        this.pot += pot;
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
        Map<Jogador, Integer> jogadoresNaPartida = getJogadoresNaPartida();
        return getRandomPlayer(jogadoresNaPartida);
    }

    public Jogador getRandomPlayer(Map<Jogador, Integer> playes){
        ArrayList <Integer> listaDeAssentosOcupados = new ArrayList<>();
        Jogador jogador = null;
        for(Map.Entry<Jogador, Integer> entry : playes.entrySet()){
            listaDeAssentosOcupados.add(entry.getValue());
        }
        Random rand = new Random();
        int posicaoAssentoOcupadoEscolhido = rand.nextInt(listaDeAssentosOcupados.size());
        int assento = listaDeAssentosOcupados.get(posicaoAssentoOcupadoEscolhido);
        for(Map.Entry<Jogador, Integer> entry : playes.entrySet()){
            if(entry.getValue().equals(assento)){
                jogador = entry.getKey();
            }
        }
        return jogador;
    }

    public void receberCartasPartida(Carta[] cartas){
        this.cartasComunitarias = cartas;
    }

    public Carta[] getCartasComunitarias() {
        return cartasComunitarias;
    }
}
