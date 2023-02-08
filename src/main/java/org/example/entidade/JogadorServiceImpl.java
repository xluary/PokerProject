package org.example.entidade;

import org.example.interfaces.JogadorService;

public class JogadorServiceImpl implements JogadorService {

    private Partida partida;
    private Jogador jogador;

    public JogadorServiceImpl(Partida partida, Jogador jogador) {
        this.partida = partida;
        this.jogador = jogador;
    }

    @Override
    public void apostar(int valor) {
        jogador.apostar(valor);
        partida.receberAposta(valor);
    }

    @Override
    public void cobrir() {
        int valor = partida.getApostaCorrente();
        jogador.apostar(valor);
        partida.receberAposta(valor);
    }

    @Override
    public void correr() {
        partida.removerJogadorDaPartida(jogador);
    }
}
