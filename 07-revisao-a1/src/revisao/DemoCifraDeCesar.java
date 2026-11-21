package revisao;

public class DemoCifraDeCesar {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Alex");
        GerenciadorCifras gerenciador = new GerenciadorCifras(2, usuario);

        gerenciador.processarMensagem("Abc-2!", 2);
        gerenciador.processarMensagem("Bom Dia, IFF!", 1);
        for (int indice = 0; indice < 2; indice++) {
            Mensagem mensagem = gerenciador.buscarMensagemPorIndice(indice);
            System.out.println(new String(mensagem.obterTextoCifrado()));
        }
        if (!gerenciador.processarMensagem("Outro teste.", 0)) {
            System.out.println("Histórico cheio.");
        }
        System.out.printf("%s processou %d mensagens. Vagas restantes: %d.%n",
                usuario.getNome(), usuario.getMensagensCifradas(), gerenciador.mensagensRestantes());
    }
}
