package projeto.locacao;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

import projeto.equipamentos.Equipamento;

public final class Locacao {
    private final Equipamento equipamento;
    private final Associado associado;
    private final LocalDate inicio;
    private final LocalDate devolucaoPrevista;
    private final long valorEmCentavos;
    private LocalDate devolucaoReal;

    Locacao(Equipamento equipamento, Associado associado, LocalDate inicio, int dias) {
        this.equipamento = Objects.requireNonNull(equipamento, "Equipamento");
        this.associado = Objects.requireNonNull(associado, "Associado");
        this.inicio = Objects.requireNonNull(inicio, "Início");
        this.valorEmCentavos = equipamento.calcularValorEmCentavos(dias);
        this.devolucaoPrevista = inicio.plusDays(dias);
    }

    public Equipamento equipamento() {
        return equipamento;
    }

    public Associado associado() {
        return associado;
    }

    public LocalDate devolucaoPrevista() {
        return devolucaoPrevista;
    }

    public long valorEmCentavos() {
        return valorEmCentavos;
    }

    public boolean estaAberta() {
        return devolucaoReal == null;
    }

    public Optional<LocalDate> devolucaoReal() {
        return Optional.ofNullable(devolucaoReal);
    }

    void registrarDevolucao(LocalDate data) {
        Objects.requireNonNull(data, "Data da devolução");
        if (!estaAberta()) {
            throw new IllegalStateException("Locação já devolvida.");
        }
        if (data.isBefore(inicio)) {
            throw new IllegalArgumentException("A devolução deve ocorrer a partir da retirada.");
        }
        devolucaoReal = data;
    }
}
