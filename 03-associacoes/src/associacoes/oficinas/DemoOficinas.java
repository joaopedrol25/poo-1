package associacoes.oficinas;

import java.time.LocalDate;

public final class DemoOficinas {
    public static void main(String[] args) {
        AgendaOficinas agenda = new AgendaOficinas();
        Participante helena = new Participante("Helena");
        Participante rui = new Participante("Rui");
        Oficina ceramica = new Oficina("Cerâmica");
        Oficina fotografia = new Oficina("Fotografia");
        LocalDate data = LocalDate.of(2026, 6, 10);

        agenda.inscrever(helena, ceramica, data);
        agenda.inscrever(helena, fotografia, data);
        agenda.inscrever(rui, fotografia, data.plusDays(1));

        System.out.println("Oficinas de Helena");
        for (Oficina oficina : agenda.oficinasDe(helena)) {
            System.out.println(oficina.titulo());
        }
        System.out.println("Inscrições em Fotografia");
        for (Inscricao inscricao : agenda.inscricoesEm(fotografia)) {
            System.out.println(inscricao.participante().nome() + " | " + inscricao.data());
        }
    }
}
