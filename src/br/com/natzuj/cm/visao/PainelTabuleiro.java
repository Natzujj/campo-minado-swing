package br.com.natzuj.cm.visao;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import br.com.natzuj.cm.modelo.Tabuleiro;

public class PainelTabuleiro extends JPanel{
    public PainelTabuleiro(Tabuleiro tabuleiro) {
    
        setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));

        tabuleiro.paraCadaCampo(c -> add(new BotaoCampo(c)));

        tabuleiro.registrarObservador(e -> {
            SwingUtilities.invokeLater(() -> {          
                if (e.isGanhou()) {
                    JOptionPane.showMessageDialog(this, "VOCE GANHOU! PARABENS :) ");
                } else {
                    JOptionPane.showMessageDialog(this, "VOCE PERDEU! :( ");
                }
                tabuleiro.reiniciar();
            });

        });
    }
}
