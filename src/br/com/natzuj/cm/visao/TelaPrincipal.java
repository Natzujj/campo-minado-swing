package br.com.natzuj.cm.visao;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import br.com.natzuj.cm.modelo.Tabuleiro;

public class TelaPrincipal extends JFrame {
    private StringBuilder input = new StringBuilder();
    public TelaPrincipal() {
        Tabuleiro tabuleiro = new Tabuleiro(16, 30, 50);

        PainelTabuleiro painelTabuleiro = new PainelTabuleiro(tabuleiro);
        add(painelTabuleiro);

        setTitle("Campo Minado!");
        setSize(690, 438);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setFocusable(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                input.append(e.getKeyChar());
                if (input.toString().endsWith("hack")) {
                    tabuleiro.alternarMarcacaoHack();
                    input.setLength(0); 
                }
            }
        });
    }
    public static void main(String[] args) {
        new TelaPrincipal();
    }
}
