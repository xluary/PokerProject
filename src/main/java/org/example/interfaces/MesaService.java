package org.example.interfaces;

import org.example.entidade.Jogador;
import org.example.excessoes.LugarOcupadoExpection;

import java.util.Map;

public interface MesaService {
    void sentarMesa(Integer posicao, Jogador jogador) throws LugarOcupadoExpection;

    void levantarMesa(Jogador jogador);

    int quantidadeJogadoresNaMesa();

    public Map<Jogador,Integer> getJogadoresNaMesa();


}
