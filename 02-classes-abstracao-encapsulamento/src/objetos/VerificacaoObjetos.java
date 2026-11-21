package objetos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import objetos.solucoes.OrdemManutencao;
import objetos.solucoes.SessaoPlanetario;

public class VerificacaoObjetos {
    public static void main(String[] args) {
        verificarBicicletas();
        verificarCartao();
        verificarPainel();
        verificarSessao();
        verificarOrdem();
        System.out.println("Verificações de classes, abstração e encapsulamento concluídas.");
    }

    private static void verificarBicicletas() {
        BicicletaLocacao bicicleta = new BicicletaLocacao("B-1", 1_250);
        assert bicicleta.estaDisponivel();
        assert bicicleta.calcularValorEmCentavos(3) == 3_750;
        esperarExcecao(IllegalArgumentException.class, () -> bicicleta.calcularValorEmCentavos(0));
        assert bicicleta.alugar();
        assert !bicicleta.alugar();
        assert bicicleta.devolver();
        assert !bicicleta.devolver();

        LocalDate revisao = LocalDate.of(2026, 5, 10);
        BicicletaOficina oficina = new BicicletaOficina("B-1", revisao);
        assert oficina.diasDesdeUltimaRevisao(revisao.plusDays(10)) == 10;
        esperarExcecao(IllegalArgumentException.class, () -> oficina.registrarRevisao(revisao.minusDays(1)));
        assert oficina.diasDesdeUltimaRevisao(revisao) == 0;
        oficina.registrarRevisao(revisao.plusDays(2));
        assert oficina.diasDesdeUltimaRevisao(revisao.plusDays(10)) == 8;
        esperarExcecao(IllegalArgumentException.class, () -> oficina.diasDesdeUltimaRevisao(revisao));
    }

    private static void verificarCartao() {
        CartaoTransporte cartao = new CartaoTransporte("T-14", "Campus");
        CartaoTransporte alias = cartao;
        CartaoTransporte independente = new CartaoTransporte("T-14", "Campus");
        alias.recarregar(480);
        assert cartao.getSaldoEmCentavos() == 480;
        assert independente.getSaldoEmCentavos() == 0;
        assert cartao.pagarPassagem(480);
        assert cartao.getSaldoEmCentavos() == 0;
        assert !cartao.pagarPassagem(1);
        esperarExcecao(IllegalArgumentException.class, () -> cartao.recarregar(0));
        esperarExcecao(IllegalArgumentException.class, () -> cartao.setApelido(" "));
        assert cartao.getApelido().equals("Campus");

        cartao.recarregar(Long.MAX_VALUE);
        esperarExcecao(ArithmeticException.class, () -> cartao.recarregar(1));
        assert cartao.getSaldoEmCentavos() == Long.MAX_VALUE;
    }

    private static void verificarPainel() {
        int[] notas = {70, 90};
        PainelNotas painel = new PainelNotas(notas);
        notas[0] = 0;
        painel.copiarNotas()[1] = 0;
        assert Arrays.equals(painel.copiarNotas(), new int[]{70, 90});
        painel.alterarNota(1, 100);
        assert painel.calcularMedia() == 85;
        esperarExcecao(IllegalArgumentException.class, () -> painel.alterarNota(0, 101));
        esperarExcecao(IndexOutOfBoundsException.class, () -> painel.alterarNota(2, 100));
        esperarExcecao(IllegalArgumentException.class, () -> new PainelNotas(new int[0]));
        assert Arrays.equals(painel.copiarNotas(), new int[]{70, 100});
    }

    private static void verificarSessao() {
        SessaoPlanetario sessao = new SessaoPlanetario("O céu", LocalDateTime.of(2026, 6, 13, 15, 0), 12);
        assert sessao.reservar(12);
        assert !sessao.reservar(1);
        assert sessao.lugaresDisponiveis() == 0;
        assert !sessao.cancelarReserva(13);
        assert sessao.cancelarReserva(3);
        assert sessao.lugaresDisponiveis() == 3;
        esperarExcecao(IllegalArgumentException.class, () -> sessao.reservar(0));
    }

    private static void verificarOrdem() {
        OrdemManutencao ordem = new OrdemManutencao("OM-08", "Projetor");
        assert ordem.getEstado() == OrdemManutencao.Estado.ABERTA;
        assert !ordem.concluir("Relato");
        assert ordem.getRelatoFinal() == null;
        assert ordem.iniciar();
        assert !ordem.iniciar();
        esperarExcecao(IllegalArgumentException.class, () -> ordem.concluir(" "));
        assert ordem.getEstado() == OrdemManutencao.Estado.EM_ANDAMENTO;
        assert ordem.concluir("Projetor ajustado");
        assert !ordem.concluir("Outro relato");
        assert !ordem.iniciar();
        assert ordem.getEstado() == OrdemManutencao.Estado.CONCLUIDA;
        assert ordem.getRelatoFinal().equals("Projetor ajustado");
    }

    private static void esperarExcecao(Class<? extends RuntimeException> tipo, Runnable operacao) {
        try {
            operacao.run();
        } catch (RuntimeException excecao) {
            if (tipo.isInstance(excecao)) {
                return;
            }
            throw excecao;
        }
        throw new AssertionError("Exceção esperada: " + tipo.getSimpleName());
    }
}
