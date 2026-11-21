package modularidade.acoplamento;

import java.util.Set;

public final class DemoAcoplamento {
    public static void main(String[] args) {
        ReservaAntiga antiga = new ReservaAntiga(
                new PesquisadorAntigo(new IdentificacaoAntiga(Credencial.OPERACAO_DE_EQUIPAMENTOS)));
        System.out.println("Antes, com uma credencial: " + liberarAntes(antiga, true));

        Pesquisador pesquisador = new Pesquisador(
                Set.of(Credencial.VISITANTE, Credencial.OPERACAO_DE_EQUIPAMENTOS));
        ReservaLaboratorio reserva = new ReservaLaboratorio(pesquisador);
        ControleEntrada controle = new ControleEntrada(true);
        System.out.println("Depois, com várias credenciais: " + controle.liberar(reserva));
    }

    // As classes abaixo reproduzem a representação anterior apenas para esta comparação.
    private record IdentificacaoAntiga(Credencial credencial) {
    }

    private record PesquisadorAntigo(IdentificacaoAntiga identificacao) {
    }

    private record ReservaAntiga(PesquisadorAntigo responsavel) {
    }

    private static boolean liberarAntes(ReservaAntiga reserva, boolean laboratorioAberto) {
        return laboratorioAberto
                && reserva.responsavel().identificacao().credencial() == Credencial.OPERACAO_DE_EQUIPAMENTOS;
    }
}
