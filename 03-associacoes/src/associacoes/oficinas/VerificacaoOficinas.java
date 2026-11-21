package associacoes.oficinas;

import java.time.LocalDate;
import java.util.List;

public final class VerificacaoOficinas {
    public static void main(String[] args) {
        AgendaOficinas agenda = new AgendaOficinas();
        Participante participante = new Participante("Helena");
        Participante homonima = new Participante("Helena");
        Oficina robotica = new Oficina("Robótica");
        Oficina desenho = new Oficina("Desenho");
        LocalDate data = LocalDate.of(2026, 6, 10);

        boolean primeiraInscricao = agenda.inscrever(participante, robotica, data);
        boolean inscricaoRepetida = agenda.inscrever(participante, robotica, data.plusDays(1));
        boolean segundaOficina = agenda.inscrever(participante, desenho, data);
        boolean outraPessoa = agenda.inscrever(homonima, robotica, data);

        assert primeiraInscricao && segundaOficina && outraPessoa : "Novas combinações são aceitas.";
        assert !inscricaoRepetida : "O mesmo par participante e oficina só pode ocorrer uma vez.";
        assert agenda.oficinasDe(participante).equals(List.of(robotica, desenho)) : "Uma pessoa tem várias oficinas.";
        assert agenda.inscricoesEm(robotica).size() == 2 : "Uma oficina tem várias pessoas.";
        assert agenda.inscricoesEm(robotica).get(0).data().equals(data) : "Uma repetição preserva a data original.";
        assert agenda.inscricoesEm(new Oficina("Robótica")).isEmpty() : "As consultas usam a identidade da oficina.";
    }
}
