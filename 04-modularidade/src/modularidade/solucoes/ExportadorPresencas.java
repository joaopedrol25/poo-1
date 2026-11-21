package modularidade.solucoes;

import java.util.List;

public final class ExportadorPresencas {
    public String exportar(List<RegistroPresenca> registros) {
        if (registros == null) {
            throw new IllegalArgumentException("Informe a lista de presenças.");
        }

        StringBuilder csv = new StringBuilder("nome,presente\n");
        for (RegistroPresenca registro : registros) {
            csv.append(formatarLinha(registro)).append('\n');
        }
        return csv.toString();
    }

    private String formatarLinha(RegistroPresenca registro) {
        if (registro == null || registro.nome() == null || registro.nome().isBlank()) {
            throw new IllegalArgumentException("Cada registro deve ter um nome.");
        }

        String nome = registro.nome();
        if (nome.indexOf(',') >= 0 || nome.indexOf('"') >= 0
                || nome.indexOf('\n') >= 0 || nome.indexOf('\r') >= 0) {
            throw new IllegalArgumentException("Use um nome com uma só linha, sem vírgulas ou aspas.");
        }
        return nome.strip() + "," + (registro.presente() ? "sim" : "nao");
    }
}
