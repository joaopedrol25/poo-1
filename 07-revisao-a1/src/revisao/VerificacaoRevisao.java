package revisao;

public class VerificacaoRevisao {
    public static void main(String[] args) {
        verificarProdutorio();
        verificarMensagem();
        verificarHistorico();
        System.out.println("Revisão A1 conferida.");
    }

    private static void verificarProdutorio() {
        double esperado = 50.0 / 3;
        exigir(Math.abs(Produtorio.calcular(1, 3) - esperado) < 0.000001, "Produtório de 1 a 3");
        exigir(Produtorio.calcular(4, 4) == 4.25, "Produtório de um termo");
        exigir(Produtorio.calcular(Integer.MAX_VALUE, Integer.MAX_VALUE) == Integer.MAX_VALUE,
                "Último índice possível para um limite int");
        esperar(IllegalArgumentException.class, () -> Produtorio.calcular(0, 2));
        esperar(IllegalArgumentException.class, () -> Produtorio.calcular(3, 2));
    }

    private static void verificarMensagem() {
        Mensagem mensagem = new Mensagem("Abc-2! Áé", 2);
        esperar(IllegalStateException.class, mensagem::obterTextoCifrado);
        mensagem.cifrarMensagem();
        exigir(new String(mensagem.obterTextoCifrado()).equals("Cde-2! Áé"), "Caixa e pontuação");

        char[] copia = mensagem.obterTextoCifrado();
        copia[0] = 'X';
        exigir(mensagem.obterTextoCifrado()[0] == 'C', "Cópia defensiva");
        exigir(new Mensagem("X", -1).cifrarCaractere('X') == 'W', "Deslocamento negativo");
        esperar(IllegalArgumentException.class, () -> new Mensagem("", Integer.MAX_VALUE).cifrarCaractere('A'));
        esperar(IllegalArgumentException.class, () -> new Mensagem("z", 1).cifrarMensagem());

        Mensagem vazia = new Mensagem("", 1);
        vazia.cifrarMensagem();
        exigir(vazia.obterTextoCifrado().length == 0, "Mensagem vazia");
    }

    private static void verificarHistorico() {
        Usuario usuario = new Usuario("Alex");
        GerenciadorCifras historico = new GerenciadorCifras(2, usuario);
        exigir(historico.mensagensRestantes() == 2, "Capacidade inicial");
        exigir(historico.buscarMensagemPorIndice(-1) == null, "Índice negativo");
        exigir(historico.buscarMensagemPorIndice(0) == null, "Posição vazia");

        exigir(historico.processarMensagem("Abc", 2), "Primeira inclusão");
        esperar(IllegalArgumentException.class, () -> historico.processarMensagem("Z", 1));
        exigir(historico.mensagensRestantes() == 1, "Falha de cifragem mantém a vaga");
        exigir(usuario.getMensagensCifradas() == 1, "Falha de cifragem mantém o contador do usuário");
        exigir(historico.buscarMensagemPorIndice(1) == null, "Falha de cifragem mantém a posição vazia");

        exigir(historico.processarMensagem("Xy", 1), "Segunda inclusão");
        exigir(new String(historico.buscarMensagemPorIndice(1).obterTextoCifrado()).equals("Yz"),
                "Busca de mensagem armazenada");
        exigir(!historico.processarMensagem("Fim", 0), "Capacidade esgotada");
        exigir(historico.mensagensRestantes() == 0, "Nenhuma vaga restante");
        exigir(usuario.getMensagensCifradas() == 2, "Total de inclusões bem-sucedidas");
        exigir(historico.buscarMensagemPorIndice(2) == null, "Índice fora do histórico");

        GerenciadorCifras historicoVazio = new GerenciadorCifras(0, usuario);
        exigir(!historicoVazio.processarMensagem("A", 0), "Capacidade zero");
    }

    private static void exigir(boolean condicao, String descricao) {
        if (!condicao) {
            throw new AssertionError(descricao);
        }
    }

    private static void esperar(Class<? extends RuntimeException> tipo, Runnable operacao) {
        try {
            operacao.run();
        } catch (RuntimeException excecao) {
            if (tipo.isInstance(excecao)) {
                return;
            }
            throw new AssertionError("Exceção inesperada", excecao);
        }
        throw new AssertionError("Era esperada " + tipo.getSimpleName());
    }
}
