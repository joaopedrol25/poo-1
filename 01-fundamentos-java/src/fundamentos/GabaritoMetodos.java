package fundamentos;

public class GabaritoMetodos {
    public static void main(String[] args) {
        System.out.println("F06 — 12 fotos iguais: " + volumeUsado(12, 5) + " MB");
        System.out.println("F06 — arquivos individuais: " + volumeUsado(new int[] {4, 7, 5}) + " MB");
    }

    static long volumeUsado(int quantidadeDeFotos, int megabytesPorFoto) {
        if (quantidadeDeFotos < 0) {
            throw new IllegalArgumentException("A quantidade de fotos não pode ser negativa.");
        }
        validarTamanho(megabytesPorFoto);
        return (long) quantidadeDeFotos * megabytesPorFoto;
    }

    static long volumeUsado(int[] tamanhosEmMegabytes) {
        long total = 0;
        for (int tamanho : tamanhosEmMegabytes) {
            validarTamanho(tamanho);
            total += tamanho;
        }
        return total;
    }

    private static void validarTamanho(int megabytes) {
        if (megabytes <= 0) {
            throw new IllegalArgumentException("Informe um tamanho positivo em megabytes.");
        }
    }
}
