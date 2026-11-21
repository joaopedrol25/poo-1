package projeto;

import java.time.LocalDate;
import java.util.List;

import projeto.equipamentos.Equipamento;
import projeto.equipamentos.EquipamentoEletrico;
import projeto.equipamentos.EquipamentoManual;
import projeto.locacao.Associado;
import projeto.locacao.CentralLocacoes;
import projeto.locacao.Locacao;

public final class VerificacaoOficina {
    public static void main(String[] args) {
        validarValores();
        validarCicloDeLocacao();
    }

    private static void validarValores() {
        Equipamento manual = new EquipamentoManual("M", "Chave", 500);
        Equipamento eletrico = new EquipamentoEletrico("E", "Furadeira", 1500, 300);

        assert manual.calcularValorEmCentavos(2) == 1000;
        assert eletrico.calcularValorEmCentavos(2) == 3300;
        assert eletrico.calcularValorEmCentavos(1) == 1800;
        esperarFalha(IllegalArgumentException.class, () -> eletrico.calcularValorEmCentavos(0));
        esperarFalha(IllegalArgumentException.class,
                () -> new EquipamentoEletrico("E", "Serra", 1000, -1));
        Equipamento comTaxaInvalida = new Equipamento("P", "Protótipo", 100) {
            @Override
            protected long taxaFixaEmCentavos() {
                return -101;
            }
        };
        esperarFalha(IllegalStateException.class, () -> comTaxaInvalida.calcularValorEmCentavos(1));
        Equipamento caro = new EquipamentoManual("C", "Calibrador", Long.MAX_VALUE);
        esperarFalha(ArithmeticException.class, () -> caro.calcularValorEmCentavos(2));
    }

    private static void validarCicloDeLocacao() {
        CentralLocacoes central = new CentralLocacoes();
        Associado pessoa = new Associado("Lia");
        LocalDate inicio = LocalDate.of(2026, 6, 10);
        Equipamento serra = new EquipamentoManual("S", "Serra manual", 800);
        central.cadastrar(serra);

        esperarFalha(IllegalArgumentException.class, () -> central.cadastrar(serra));
        esperarFalha(IllegalArgumentException.class, () -> central.abrir("X", pessoa, inicio, 1));
        esperarFalha(IllegalArgumentException.class, () -> central.abrir("S", pessoa, inicio, 0));
        assert central.historico().isEmpty();

        Locacao primeira = central.abrir("S", pessoa, inicio, 1);
        assert primeira.equipamento() == serra;
        assert primeira.devolucaoPrevista().equals(inicio.plusDays(1));
        assert primeira.devolucaoReal().isEmpty();
        esperarFalha(IllegalStateException.class, () -> central.abrir("S", pessoa, inicio, 2));
        esperarFalha(IllegalArgumentException.class, () -> central.devolver(primeira, inicio.minusDays(1)));
        esperarFalha(IllegalArgumentException.class, () -> new CentralLocacoes().devolver(primeira, inicio));
        assert primeira.estaAberta();
        assert central.historico().size() == 1;

        List<Locacao> consulta = central.historico();
        esperarFalha(UnsupportedOperationException.class, consulta::clear);
        central.devolver(primeira, inicio);
        assert primeira.devolucaoReal().orElseThrow().equals(inicio);
        Locacao segunda = central.abrir("S", pessoa, inicio, 2);
        esperarFalha(IllegalStateException.class, () -> central.devolver(primeira, inicio));
        assert !primeira.estaAberta() && segunda.estaAberta();
        assert consulta.size() == 1 && central.historico().size() == 2;
    }

    private static void esperarFalha(Class<? extends RuntimeException> tipo, Runnable acao) {
        try {
            acao.run();
        } catch (RuntimeException erro) {
            if (tipo.isInstance(erro)) {
                return;
            }
            throw erro;
        }
        throw new AssertionError("Falha esperada: " + tipo.getSimpleName());
    }
}
