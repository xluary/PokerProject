package org.example.entidade;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Mesa{

    public static final int QUANTIDADEMINDEJOGADORES = 2;

    public static final int QUANTIDADEMAXDEJOGADORES = 23;
    public static int id = 0;
    private int numero;

    private Map<Jogador, Integer> jogadoresNaMesa = new HashMap<>();

    private boolean[] lugares = new boolean[QUANTIDADEMAXDEJOGADORES];

    public Mesa() {
        this.numero = id++;

        for (int i=0; i<QUANTIDADEMAXDEJOGADORES; i++){
            lugares[i]= false;
        }
    }


    public void sentarNaMesa (Integer posicao, Jogador jogador){
        lugares[posicao] = true;
        jogadoresNaMesa.put(jogador, posicao);
    }

    public void levantarDaMesa (Jogador jogador){
        int posicao = posicaoJogadorMesa(jogador);
        lugares[posicao] = false;
        jogadoresNaMesa.remove(jogador);
    }

    public int getNumero() {
        return numero;
    }

    public Map<Jogador, Integer> getJogadoresNaMesa() {
        return getJogadoresNaMesaOrdenado();
    }

    public Map<Jogador, Integer> getJogadoresNaMesaOrdenado(){
        Map<Jogador, Integer> jogadoresOrdenados = jogadoresNaMesa.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return jogadoresOrdenados;
    }

    public boolean[] getLugares() {
        return lugares;
    }

    public int posicaoJogadorMesa(Jogador jogador){
        return jogadoresNaMesa.get(jogador);
    }
}
