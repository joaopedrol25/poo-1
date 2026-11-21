package objetos.solucoes;

public final class OrdemManutencao {
    public enum Estado {
        ABERTA,
        EM_ANDAMENTO,
        CONCLUIDA
    }

    private final String codigo;
    private final String equipamento;
    private Estado estado = Estado.ABERTA;
    private String relatoFinal;

    public OrdemManutencao(String codigo, String equipamento) {
        this.codigo = exigirTexto(codigo, "Informe o código da ordem.");
        this.equipamento = exigirTexto(equipamento, "Informe o equipamento.");
    }

    public String getCodigo() {
        return codigo;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public Estado getEstado() {
        return estado;
    }

    /** Retorna null até a conclusão bem-sucedida da ordem. */
    public String getRelatoFinal() {
        return relatoFinal;
    }

    public boolean iniciar() {
        if (estado != Estado.ABERTA) {
            return false;
        }
        estado = Estado.EM_ANDAMENTO;
        return true;
    }

    public boolean concluir(String relato) {
        if (estado != Estado.EM_ANDAMENTO) {
            return false;
        }
        relatoFinal = exigirTexto(relato, "Informe o relato da manutenção.");
        estado = Estado.CONCLUIDA;
        return true;
    }

    private static String exigirTexto(String texto, String mensagem) {
        if (texto == null || texto.isBlank()) {
            throw new IllegalArgumentException(mensagem);
        }
        return texto;
    }
}
