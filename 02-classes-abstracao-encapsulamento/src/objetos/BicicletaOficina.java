package objetos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/** Modelo do mesmo tipo de objeto para o controle da manutenção. */
public final class BicicletaOficina {
    private final String codigo;
    private LocalDate ultimaRevisao;

    public BicicletaOficina(String codigo, LocalDate ultimaRevisao) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Informe o código da bicicleta.");
        }
        this.codigo = codigo;
        this.ultimaRevisao = Objects.requireNonNull(ultimaRevisao, "Informe a revisão inicial.");
    }

    public String getCodigo() {
        return codigo;
    }

    public void registrarRevisao(LocalDate data) {
        Objects.requireNonNull(data, "Informe a data da revisão.");
        if (data.isBefore(ultimaRevisao)) {
            throw new IllegalArgumentException("A revisão não pode anteceder a última registrada.");
        }
        ultimaRevisao = data;
    }

    public long diasDesdeUltimaRevisao(LocalDate dataConsulta) {
        Objects.requireNonNull(dataConsulta, "Informe a data da consulta.");
        if (dataConsulta.isBefore(ultimaRevisao)) {
            throw new IllegalArgumentException("A consulta deve ser a partir da última revisão.");
        }
        return ChronoUnit.DAYS.between(ultimaRevisao, dataConsulta);
    }
}
