package associacoes.perfil;

public final class VerificacaoPerfil {
    public static void main(String[] args) {
        Perfil primeiro = new Perfil("Primeiro");
        Perfil segundo = new Perfil("Segundo");

        assert primeiro.configuracao() == primeiro.configuracao() : "O perfil mantém sua configuração.";
        assert primeiro.configuracao() != segundo.configuracao() : "Cada perfil cria sua configuração.";

        primeiro.configuracao().alterarLembretes(false);
        assert !primeiro.configuracao().recebeLembretes() : "A preferência foi alterada.";
        assert segundo.configuracao().recebeLembretes() : "Uma alteração afeta apenas o perfil editado.";
    }
}
