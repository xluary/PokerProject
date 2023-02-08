package org.example.entidade;

public enum AcoesJogador {
    CORRER(1, "Correr"),
    APOSTAR(2, "Apostar"),
    MESA(3, "Mesa");

    private int opcao;
    private String label;

    AcoesJogador(int opcao, String label) {
        this.opcao = opcao;
        this.label = label;
    }

    public int getOpcao() {
        return opcao;
    }

    public String getLabel() {
        return label;
    }
}
