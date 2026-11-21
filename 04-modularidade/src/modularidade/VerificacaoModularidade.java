package modularidade;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import modularidade.acoplamento.ControleEntrada;
import modularidade.acoplamento.Credencial;
import modularidade.acoplamento.Pesquisador;
import modularidade.acoplamento.ReservaLaboratorio;
import modularidade.coesao.Bilheteria;
import modularidade.coesao.FormatadorIngresso;
import modularidade.coesao.Ingresso;
import modularidade.coesao.RegistroIngressos;
import modularidade.protocolo.ImpressoraEtiquetas;
import modularidade.solucoes.ExportadorPresencas;
import modularidade.solucoes.RegistroPresenca;

public final class VerificacaoModularidade {
    public static void main(String[] args) {
        verificarBilheteria();
        verificarEntrada();
        verificarImpressora();
        verificarExportacao();
    }

    private static void verificarBilheteria() {
        Bilheteria bilheteria = new Bilheteria("Mostra da Cidade", 2);
        Ingresso inteira = bilheteria.emitir(false);
        assert inteira.precoEmCentavos() == 2400;
        assert bilheteria.lugaresRestantes() == 1;

        Ingresso meia = bilheteria.emitir(true);
        assert meia.precoEmCentavos() == 1200;
        assert meia.numero() == 2;
        esperarFalha(IllegalStateException.class, () -> bilheteria.emitir(true));
        assert bilheteria.lugaresRestantes() == 0;
        esperarFalha(IllegalArgumentException.class, () -> new Bilheteria("Sessão", 0));

        FormatadorIngresso formatador = new FormatadorIngresso();
        assert formatador.formatar(meia).equals("Mostra da Cidade | Ingresso 2 | R$ 12,00");

        RegistroIngressos registro = new RegistroIngressos();
        registro.registrar(inteira);
        List<Ingresso> anterior = registro.registrados();
        registro.registrar(meia);
        assert anterior.equals(List.of(inteira));
        assert registro.registrados().equals(List.of(inteira, meia));
    }

    private static void verificarEntrada() {
        ControleEntrada aberto = new ControleEntrada(true);
        ControleEntrada fechado = new ControleEntrada(false);
        ReservaLaboratorio operador = reservaCom(Set.of(
                Credencial.VISITANTE, Credencial.OPERACAO_DE_EQUIPAMENTOS));

        assert aberto.liberar(operador);
        assert !fechado.liberar(operador);
        assert !aberto.liberar(reservaCom(Set.of(Credencial.VISITANTE)));
        assert !aberto.liberar(reservaCom(Set.of()));
    }

    private static ReservaLaboratorio reservaCom(Set<Credencial> credenciais) {
        return new ReservaLaboratorio(new Pesquisador(credenciais));
    }

    private static void verificarImpressora() {
        ImpressoraEtiquetas impressora = new ImpressoraEtiquetas();
        List<String> primeiro = impressora.imprimir(List.of("A", " B "));
        assert primeiro.equals(List.of("[A]", "[B]"));
        esperarFalha(IllegalArgumentException.class, () -> impressora.imprimir(List.of()));
        esperarFalha(IllegalArgumentException.class, () -> impressora.imprimir(List.of("C", " ")));

        List<String> segundo = impressora.imprimir(List.of("D"));
        assert segundo.equals(List.of("[D]"));
        assert primeiro.equals(List.of("[A]", "[B]"));
    }

    private static void verificarExportacao() {
        ExportadorPresencas exportador = new ExportadorPresencas();
        assert exportador.exportar(List.of()).equals("nome,presente\n");
        assert exportador.exportar(List.of(
                new RegistroPresenca(" Ana ", true),
                new RegistroPresenca("Bia", false)))
                .equals("nome,presente\nAna,sim\nBia,nao\n");
        esperarFalha(IllegalArgumentException.class, () -> exportador.exportar(List.of(
                new RegistroPresenca("Ana", true),
                new RegistroPresenca("Bia, Silva", false))));
        esperarFalha(IllegalArgumentException.class,
                () -> exportador.exportar(List.of(new RegistroPresenca("Quebra\nde linha", false))));

        List<RegistroPresenca> comNulo = new ArrayList<>();
        comNulo.add(null);
        esperarFalha(IllegalArgumentException.class, () -> exportador.exportar(comNulo));
        assert exportador.exportar(List.of(new RegistroPresenca("Bia", true)))
                .equals("nome,presente\nBia,sim\n");
    }

    private static void esperarFalha(Class<? extends RuntimeException> tipo, Runnable operacao) {
        try {
            operacao.run();
        } catch (RuntimeException erro) {
            if (tipo.isInstance(erro)) {
                return;
            }
            throw erro;
        }
        throw new AssertionError("Esperava " + tipo.getSimpleName());
    }
}
