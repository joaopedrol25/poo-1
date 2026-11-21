package associacoes.planetario;

public final class VerificacaoPlanetario {
    public static void main(String[] args) {
        Sessao noite = new Sessao("Céu de inverno", 2);
        Sessao tarde = new Sessao("Jornada lunar", 2);
        Visitante iris = new Visitante("V1", "Íris");
        Visitante mesmoCadastro = new Visitante(" V1 ", "Íris");
        Visitante rui = new Visitante("V2", "Rui");

        assert noite.vagasDisponiveis() == 2 : "Uma sessão nova começa vazia.";
        boolean primeiroAssento = noite.reservar(2, iris);
        boolean assentoOcupado = noite.reservar(2, rui);
        boolean visitanteRepetido = noite.reservar(1, mesmoCadastro);
        boolean assentoInvalido = noite.reservar(0, rui);
        boolean outraSessao = tarde.reservar(1, iris);

        assert primeiroAssento && outraSessao : "A pessoa pode participar de sessões diferentes.";
        assert !assentoOcupado : "Um assento não pode ter dois visitantes.";
        assert !visitanteRepetido : "Cada código pode aparecer uma vez por sessão.";
        assert !assentoInvalido : "Os assentos começam no número 1.";
        assert noite.reservaNoAssento(3) == null : "Uma consulta fora da capacidade retorna null.";
        assert noite.reservaNoAssento(2).assento() == 2 : "O número público do assento começa em 1.";
        assert noite.reservaNoAssento(2).visitante() == iris : "A associação preserva a instância cadastrada.";
        assert noite.vagasDisponiveis() == 1 : "As recusas preservam a ocupação.";

        boolean cancelouAssentoAlheio = noite.cancelar(2, rui);
        boolean cancelouProprioAssento = noite.cancelar(2, mesmoCadastro);
        assert !cancelouAssentoAlheio && cancelouProprioAssento : "O cancelamento exige o código do titular.";
        assert noite.reservaNoAssento(2) == null : "O cancelamento deixa o assento livre.";
        assert noite.vagasDisponiveis() == 2 : "A vaga é devolvida à sessão.";
        assert tarde.vagasDisponiveis() == 1 : "Cancelar uma sessão preserva as demais.";

        boolean ocupouPrimeiroAssento = noite.reservar(1, iris);
        boolean ocupouUltimoAssento = noite.reservar(2, rui);
        assert ocupouPrimeiroAssento && ocupouUltimoAssento : "As duas extremidades do array aceitam reservas.";
        assert noite.vagasDisponiveis() == 0 : "Os assentos podem ser todos ocupados.";
    }
}
