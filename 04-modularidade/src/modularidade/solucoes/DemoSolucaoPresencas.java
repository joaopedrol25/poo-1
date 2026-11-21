package modularidade.solucoes;

import java.util.List;

public final class DemoSolucaoPresencas {
    public static void main(String[] args) {
        ExportadorPresencas exportador = new ExportadorPresencas();
        String csv = exportador.exportar(List.of(
                new RegistroPresenca("Ana Reis", true),
                new RegistroPresenca("Bia Lima", false)));
        System.out.print(csv);
    }
}
