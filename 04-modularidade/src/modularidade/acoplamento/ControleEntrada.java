package modularidade.acoplamento;

import java.util.Objects;

public final class ControleEntrada {
    private final boolean laboratorioAberto;

    public ControleEntrada(boolean laboratorioAberto) {
        this.laboratorioAberto = laboratorioAberto;
    }

    public boolean liberar(ReservaLaboratorio reserva) {
        Objects.requireNonNull(reserva);
        return laboratorioAberto && reserva.autorizaEntrada();
    }
}
