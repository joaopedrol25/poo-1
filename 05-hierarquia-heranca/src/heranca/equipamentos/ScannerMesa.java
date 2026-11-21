package heranca.equipamentos;

public final class ScannerMesa extends Equipamento {
    public ScannerMesa(String identificacao) {
        super(identificacao);
    }

    public String digitalizar(int paginas) {
        exigirLigado();
        if (paginas <= 0) {
            throw new IllegalArgumentException("Informe uma quantidade positiva de páginas.");
        }
        return "%s digitalizou %d página(s).".formatted(identificacao(), paginas);
    }
}
