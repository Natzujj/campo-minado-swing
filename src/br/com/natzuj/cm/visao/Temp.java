package br.com.natzuj.cm.visao;

import br.com.natzuj.cm.modelo.Tabuleiro;

public class Temp {
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro(3, 3, 9);
        tabuleiro.registrarObservador(e -> {
            if (e.isGanhou()) {
                System.out.println("Ganhou");
            } else {
                System.out.println("Perdeu");
            }
        });
        tabuleiro.alternarMarcacaoHack();
    }
}
