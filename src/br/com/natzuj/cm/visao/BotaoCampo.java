package br.com.natzuj.cm.visao;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import br.com.natzuj.cm.modelo.Campo;
import br.com.natzuj.cm.modelo.CampoEvento;
import br.com.natzuj.cm.modelo.CampoObservador;

public class BotaoCampo extends JButton implements CampoObservador {

    private final Color BR_PADRAO = new Color(184, 184, 184);
    private final Color BR_MARCAR = new Color(8, 179, 247);
    private final Color BR_EXPLODIR = new Color(189, 66, 68);
    private final Color TEXTO_VERDE = new Color(0, 100, 0);

    private Campo campo;

    public BotaoCampo(Campo campo) {
        this.campo = campo;
        setBorder(BorderFactory.createBevelBorder(0));
        setBackground(BR_PADRAO);
        campo.registrarObservador(this);
    }

    @Override
    public void eventoOcorreu(Campo campo, CampoEvento evento) {
        switch (evento) {
            case ABRIR:
                aplicarEstiloAbrir();
                break;
            case MARCAR:
                aplicarEstiloMarcar();
                break;
            case EXPLODIR:
                aplicarEstilExplodir();
                break;
            default:
                aplicarEstiloPadrao();
        }
    }

    private void aplicarEstiloPadrao() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'aplicarEstiloPadrao'");
    }

    private void aplicarEstilExplodir() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'aplicarEstilExplodir'");
    }

    private void aplicarEstiloMarcar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'aplicarEstiloMarcar'");
    }

    private void aplicarEstiloAbrir() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'aplicarEstiloAbrir'");
    }
}
