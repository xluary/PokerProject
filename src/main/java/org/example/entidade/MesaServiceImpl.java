package org.example.entidade;

import org.example.excessoes.LugarOcupadoExpection;
import org.example.interfaces.MesaService;

public class MesaServiceImpl implements MesaService {
    Mesa mesa;

    public MesaServiceImpl(Mesa mesa) {
        this.mesa = mesa;
    }

    public void sentarMesa(Integer posicao, Jogador jogador) throws LugarOcupadoExpection {
            conferirLugarOcupado(posicao);
            mesa.sentarNaMesa(posicao, jogador);
    }

    private void conferirLugarOcupado(Integer posicao) throws LugarOcupadoExpection {
        boolean[] lugares = mesa.getLugares();
        if(lugares[posicao] == true){
            throw new LugarOcupadoExpection("Este lugar já está ocupado");
        }
    }
}
