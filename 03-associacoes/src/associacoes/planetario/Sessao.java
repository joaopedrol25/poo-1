package associacoes.planetario;

import java.util.Objects;

public final class Sessao {
    private final String titulo;
    private final Reserva[] reservas;

    public Sessao(String titulo, int capacidade) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Informe o título da sessão.");
        }
        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade deve ser positiva.");
        }
        this.titulo = titulo.strip();
        this.reservas = new Reserva[capacidade];
    }

    public String titulo() {
        return titulo;
    }

    public boolean reservar(int assento, Visitante visitante) {
        Objects.requireNonNull(visitante, "Informe o visitante.");
        if (!assentoValido(assento) || reservas[assento - 1] != null) {
            return false;
        }
        for (Reserva reserva : reservas) {
            if (reserva != null && reserva.visitante().codigo().equals(visitante.codigo())) {
                return false;
            }
        }
        reservas[assento - 1] = new Reserva(assento, visitante);
        return true;
    }

    public Reserva reservaNoAssento(int assento) {
        return assentoValido(assento) ? reservas[assento - 1] : null;
    }

    public boolean cancelar(int assento, Visitante visitante) {
        Objects.requireNonNull(visitante, "Informe o visitante.");
        Reserva reserva = reservaNoAssento(assento);
        if (reserva == null || !reserva.visitante().codigo().equals(visitante.codigo())) {
            return false;
        }
        reservas[assento - 1] = null;
        return true;
    }

    public int vagasDisponiveis() {
        int vagas = 0;
        for (Reserva reserva : reservas) {
            if (reserva == null) {
                vagas++;
            }
        }
        return vagas;
    }

    private boolean assentoValido(int assento) {
        return assento >= 1 && assento <= reservas.length;
    }
}
