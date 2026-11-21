package associacoes.oficinas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class AgendaOficinas {
    private final List<Inscricao> inscricoes = new ArrayList<>();

    public boolean inscrever(Participante participante, Oficina oficina, LocalDate data) {
        Objects.requireNonNull(participante, "Informe o participante.");
        Objects.requireNonNull(oficina, "Informe a oficina.");
        Objects.requireNonNull(data, "Informe a data.");

        for (Inscricao inscricao : inscricoes) {
            if (inscricao.participante() == participante && inscricao.oficina() == oficina) {
                return false;
            }
        }

        inscricoes.add(new Inscricao(participante, oficina, data));
        return true;
    }

    public List<Oficina> oficinasDe(Participante participante) {
        Objects.requireNonNull(participante, "Informe o participante.");
        List<Oficina> resultado = new ArrayList<>();
        for (Inscricao inscricao : inscricoes) {
            if (inscricao.participante() == participante) {
                resultado.add(inscricao.oficina());
            }
        }
        return List.copyOf(resultado);
    }

    public List<Inscricao> inscricoesEm(Oficina oficina) {
        Objects.requireNonNull(oficina, "Informe a oficina.");
        List<Inscricao> resultado = new ArrayList<>();
        for (Inscricao inscricao : inscricoes) {
            if (inscricao.oficina() == oficina) {
                resultado.add(inscricao);
            }
        }
        return List.copyOf(resultado);
    }
}
