package org.example.persistencia;

import org.example.entidade.Jogador;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

public class PersistenciaJogador {

    private ArrayList <Jogador> listaJogadores;

    private static PersistenciaJogador instance;

    public static PersistenciaJogador getInstance(){
        if(Objects.isNull(instance)){
            instance = new PersistenciaJogador();
        }
        return instance;
    }

    private PersistenciaJogador(){
        listaJogadores = new ArrayList<>();
    }
    public void adicionarJogador(Jogador jogador){
        if(Objects.isNull(listaJogadores)){
            listaJogadores = new ArrayList<>();
        }
        listaJogadores.add(jogador);
    }

    public Optional<Jogador> buscarPorNome(String nome) {
        for (Jogador jogador: listaJogadores) {
          if(jogador.getNome().equalsIgnoreCase(nome)){
              return Optional.of(jogador);
          }
        }
        return Optional.empty();
    }

    public ArrayList<Jogador> getListaJogadores() {
        return listaJogadores;
    }
}
