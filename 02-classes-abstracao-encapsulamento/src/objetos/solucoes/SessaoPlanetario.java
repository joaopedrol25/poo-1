package objetos.solucoes;

import java.time.LocalDateTime;
import java.util.Objects;

public final class SessaoPlanetario {
    private final String titulo;
    private final LocalDateTime inicio;
    private final int capacidade;
    private int lugaresReservados;

    public SessaoPlanetario(String titulo, LocalDateTime inicio, int capacidade) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Informe o título da sessão.");
        }
        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade precisa ser positiva.");
        }
        this.titulo = titulo;
        this.inicio = Objects.requireNonNull(inicio, "Informe data e hora da sessão.");
        this.capacidade = capacidade;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public int lugaresDisponiveis() {
        return capacidade - lugaresReservados;
    }

    public boolean reservar(int quantidade) {
        validarQuantidade(quantidade);
        if (quantidade > lugaresDisponiveis()) {
            return false;
        }
        lugaresReservados += quantidade;
        return true;
    }

    public boolean cancelarReserva(int quantidade) {
        validarQuantidade(quantidade);
        if (quantidade > lugaresReservados) {
            return false;
        }
        lugaresReservados -= quantidade;
        return true;
    }

    private static void validarQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade precisa ser positiva.");
        }
    }
}
