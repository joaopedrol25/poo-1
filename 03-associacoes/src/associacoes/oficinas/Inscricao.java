package associacoes.oficinas;

import java.time.LocalDate;

public final class Inscricao {
    private final Participante participante;
    private final Oficina oficina;
    private final LocalDate data;

    Inscricao(Participante participante, Oficina oficina, LocalDate data) {
        this.participante = participante;
        this.oficina = oficina;
        this.data = data;
    }

    public Participante participante() {
        return participante;
    }

    public Oficina oficina() {
        return oficina;
    }

    public LocalDate data() {
        return data;
    }
}
