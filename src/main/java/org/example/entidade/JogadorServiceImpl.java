package org.example.entidade;

import org.example.interfaces.JogadorService;

public class JogadorServiceImpl implements JogadorService {

    private Mao mao;
    private Jogador jogador;

    public JogadorServiceImpl(Mao mao, Jogador jogador) {
        this.mao = mao;
        this.jogador = jogador;
    }

    @Override
    public void apostar(int valor) {
        jogador.apostar(valor);
        mao.setPot(mao.getPot() + valor);
    }

    @Override
    public void cobrir() {
        int valor = mao.getApostaCorrente();
        jogador.apostar(valor);
        mao.setPot(mao.getPot()+ valor);
    }

    @Override
    public void correr() {
        mao.removerJogadorDaMao(jogador);
    }
}
