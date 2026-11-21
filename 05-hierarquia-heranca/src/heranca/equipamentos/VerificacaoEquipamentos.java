package heranca.equipamentos;

public class VerificacaoEquipamentos {
    public static void main(String[] args) {
        Impressora3D impressora = new Impressora3D("IMP-101", 30);
        ScannerMesa scanner = new ScannerMesa("SCN-201");

        assert !impressora.estaLigado();
        try {
            impressora.imprimirPeca(5);
            throw new AssertionError("Impressão aceita com o equipamento desligado.");
        } catch (IllegalStateException esperado) {
            assert impressora.filamentoEmGramas() == 30;
        }

        DemoEquipamentos.preparar(impressora);
        DemoEquipamentos.preparar(scanner);
        assert impressora.estaLigado();
        assert scanner.digitalizar(1).equals("SCN-201 digitalizou 1 página(s).");

        try {
            impressora.imprimirPeca(31);
            throw new AssertionError("Impressão aceita sem filamento suficiente.");
        } catch (IllegalStateException esperado) {
            assert impressora.filamentoEmGramas() == 30;
        }

        impressora.imprimirPeca(30);
        assert impressora.filamentoEmGramas() == 0;
        scanner.desligar();
        assert !scanner.estaLigado();
    }
}
