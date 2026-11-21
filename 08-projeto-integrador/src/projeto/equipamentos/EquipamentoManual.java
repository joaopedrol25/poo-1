package projeto.equipamentos;

public final class EquipamentoManual extends Equipamento {
    public EquipamentoManual(String codigo, String descricao, long diariaEmCentavos) {
        super(codigo, descricao, diariaEmCentavos);
    }

    @Override
    protected long taxaFixaEmCentavos() {
        return 0;
    }
}
