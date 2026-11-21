package fundamentos;

import java.util.Arrays;

public class VerificacaoFundamentos {
    public static void main(String[] args) {
        verificarOperadoresEFluxo();
        verificarStringsEVetores();
        verificarMatrizesEMetodos();
        verificarGabaritoFluxo();
        verificarGabaritoDados();
        verificarGabaritoMetodos();
        System.out.println("Fundamentos de Java: verificações concluídas.");
    }

    private static void verificarOperadoresEFluxo() {
        verificar(DemoOperadores.divisivelPor(12, 3), "divisibilidade");
        verificar(!DemoOperadores.divisivelPor(12, 0), "curto-circuito protege a divisão por zero");
        verificar(DemoControleFluxo.classificarNota(70).equals("aprovado"), "limite da aprovação");
        verificar(DemoControleFluxo.classificarNota(50).equals("recuperação"), "limite da recuperação");
        verificar(DemoControleFluxo.classificarNota(49).equals("reprovado"), "abaixo da recuperação");
        exigirArgumentoInvalido(() -> DemoControleFluxo.classificarNota(101));
        verificar(DemoControleFluxo.nomeTurno('X').equals("turno inválido"), "caso padrão do switch");
        verificar(DemoControleFluxo.somarAte(5) == 15, "soma de 1 a 5");
        verificar(DemoControleFluxo.somarAte(0) == 0, "laço sem iterações");
        verificar(DemoControleFluxo.contarDuplicacoes(Integer.MAX_VALUE) == 31, "duplicação sem overflow");
    }

    private static void verificarStringsEVetores() {
        verificar(DemoStrings.contarVogais("ÁÉ x") == 2, "contagem com acentos e caixa alta");
        verificar(DemoStrings.contarVogais("") == 0, "texto vazio");
        verificar(DemoVetores.somar(new int[] {Integer.MAX_VALUE, 1}) == 2_147_483_648L, "soma em long");
        verificar(DemoVetores.indiceDoMaior(new int[] {-4, -2, -2}) == 1, "primeiro maior em caso de empate");
        verificar(DemoVetores.indiceDoMaior(new int[0]) == -1, "vetor vazio");
    }

    private static void verificarMatrizesEMetodos() {
        long[] totais = DemoMatrizes.somarPorLinha(new int[][] {{2, 3}, {}, {4}});
        verificar(Arrays.equals(totais, new long[] {5, 0, 4}), "matriz com linhas de tamanhos diferentes");
        verificar(DemoMetodos.area(4) == 16, "sobrecarga com um argumento");
        verificar(DemoMetodos.area(4, 6) == 24, "sobrecarga com dois argumentos");
        int[] pontuacoes = {10, 12};
        DemoMetodos.bonificar(pontuacoes, 1, 5);
        verificar(Arrays.equals(pontuacoes, new int[] {10, 17}), "bônus muda apenas o elemento alvo");
    }

    private static void verificarGabaritoFluxo() {
        verificar(GabaritoFluxo.calcularLocacao(0, true) == 0, "locação de zero horas");
        verificar(GabaritoFluxo.calcularLocacao(2, false) == 2_100, "última hora da primeira faixa");
        verificar(GabaritoFluxo.calcularLocacao(3, false) == 2_575, "primeira hora adicional");
        verificar(GabaritoFluxo.calcularLocacao(3, true) == 2_318, "desconto truncado em centavos");
        verificar(GabaritoFluxo.calcularLocacao(24, false) == 12_550, "duração máxima da locação");
        exigirArgumentoInvalido(() -> GabaritoFluxo.calcularLocacao(25, false));
        verificar(GabaritoFluxo.maiorSequenciaAcima(new int[] {80, 90, 85, 70, 71, 70}, 80) == 2,
                "igualdade com o limite interrompe a sequência");
        verificar(GabaritoFluxo.maiorSequenciaAcima(new int[] {10, 90, 99, 100}, 80) == 3, "sequência final");
        verificar(GabaritoFluxo.maiorSequenciaAcima(new int[0], 80) == 0, "sem leituras");
        exigirArgumentoInvalido(() -> GabaritoFluxo.maiorSequenciaAcima(new int[] {101}, 100));
    }

    private static void verificarGabaritoDados() {
        verificar(GabaritoDados.normalizarCodigo("  iFf-230 ").equals("IFF-230"), "normalização do código");
        exigirArgumentoInvalido(() -> GabaritoDados.normalizarCodigo("IW-20"));
        exigirArgumentoInvalido(() -> GabaritoDados.normalizarCodigo("ÉFF-230"));
        exigirArgumentoInvalido(() -> GabaritoDados.normalizarCodigo("IFF-２30"));
        int[] esquerda = {1, 3, 3};
        int[] direita = {-2, 3, 4};
        verificar(Arrays.equals(GabaritoDados.mesclarOrdenados(esquerda, direita), new int[] {-2, 1, 3, 3, 3, 4}),
                "mesclagem mantém duplicatas");
        verificar(Arrays.equals(GabaritoDados.mesclarOrdenados(new int[0], direita), direita), "lado esquerdo vazio");
        verificar(Arrays.equals(GabaritoDados.mesclarOrdenados(esquerda, new int[0]), esquerda), "lado direito vazio");
        verificar(Arrays.equals(esquerda, new int[] {1, 3, 3}) && Arrays.equals(direita, new int[] {-2, 3, 4}),
                "mesclagem preserva as entradas");
        verificar(GabaritoDados.indiceMenosOcupado(new int[][] {{1, 1}, {0, 1}, {1, 0, 0}}) == 1,
                "primeira linha menos ocupada entre empatadas");
        verificar(GabaritoDados.indiceMenosOcupado(new int[][] {{1}, {}}) == 1, "linha vazia");
        verificar(GabaritoDados.indiceMenosOcupado(new int[0][]) == -1, "sem bancadas");
        exigirArgumentoInvalido(() -> GabaritoDados.indiceMenosOcupado(new int[][] {{}, {2}}));
    }

    private static void verificarGabaritoMetodos() {
        verificar(GabaritoMetodos.volumeUsado(3, 5) == 15, "tamanhos iguais");
        verificar(GabaritoMetodos.volumeUsado(new int[] {4, 7, 5}) == 16, "tamanhos diferentes");
        verificar(GabaritoMetodos.volumeUsado(0, 5) == 0, "zero fotos");
        verificar(GabaritoMetodos.volumeUsado(new int[0]) == 0, "álbum vazio");
        verificar(GabaritoMetodos.volumeUsado(Integer.MAX_VALUE, 2) == 4_294_967_294L, "produto em long");
        exigirArgumentoInvalido(() -> GabaritoMetodos.volumeUsado(1, 0));
        exigirArgumentoInvalido(() -> GabaritoMetodos.volumeUsado(-1, 5));
        exigirArgumentoInvalido(() -> GabaritoMetodos.volumeUsado(new int[] {4, -5}));
    }

    private static void exigirArgumentoInvalido(Runnable operacao) {
        try {
            operacao.run();
        } catch (IllegalArgumentException esperado) {
            return;
        }
        throw new AssertionError("O argumento inválido deveria ter sido rejeitado.");
    }

    private static void verificar(boolean condicao, String caso) {
        if (!condicao) {
            throw new AssertionError("Falha na verificação de " + caso);
        }
    }
}
