package org.example.interfaces;

import org.example.entidade.Carta;

public interface PartidaService {
    void embaralhar();
    void darCartasJogadores();

    void darCartasMesa();
    void definirJogadorDaVez(int posicaoUltimoJogador);
    Carta[] virarCartasFlop();
    void virarCartasTurn();
    void virarCartasRives();

}
