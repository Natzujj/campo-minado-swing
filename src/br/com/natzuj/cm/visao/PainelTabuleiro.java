package br.com.natzuj.cm.visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import br.com.natzuj.cm.modelo.Tabuleiro;

public class PainelTabuleiro extends JPanel{
    public PainelTabuleiro(Tabuleiro tabuleiro) {

        setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));

        tabuleiro.paraCadaCampo(c -> add(new BotaoCampo(c)));

        tabuleiro.registrarObservador(e -> {
            SwingUtilities.invokeLater(() -> {
                if (e.isGanhou()) {
                    // JOptionPane.showMessageDialog(this, "VOCE GANHOU! PARABENS :) ");
                    mostrarMensagemVitoria();
                } else {
                    // JOptionPane.showMessageDialog(this, "VOCE PERDEU! :( ");
                    mostrarMensagemDerrota();
                }
                tabuleiro.reiniciar();
            });

        });
    }
    
    private void mostrarMensagemVitoria() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(255, 255, 204));

        ImageIcon trophyIcon = new ImageIcon(getClass().getResource("/resources/trophy.png"));
        JLabel label = new JLabel(
                "<html><h1 style='color: green;'>VOCÊ GANHOU!</h1><p>Parabéns, você encontrou todas as minas!</p></html>",
                trophyIcon, JLabel.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);

        panel.add(label, BorderLayout.CENTER);

        JOptionPane.showMessageDialog(this, panel, "Vitória!", JOptionPane.PLAIN_MESSAGE);
    }

    private void mostrarMensagemDerrota() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(255, 204, 204));

        ImageIcon bombIcon = new ImageIcon(getClass().getResource("/resources/explode.png"));
        JLabel label = new JLabel("<html><h1 style='color: red;'>VOCÊ PERDEU!</h1><p>Infelizmente você clicou em uma mina!</p></html>", bombIcon, JLabel.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);

        panel.add(label, BorderLayout.CENTER);

        JOptionPane.showMessageDialog(this, panel, "Derrota!", JOptionPane.PLAIN_MESSAGE);
    }
}
