package heranca.equipamentos;

public class DemoEquipamentos {
    public static void main(String[] args) {
        Impressora3D impressora = new Impressora3D("IMP-101", 100);
        ScannerMesa scanner = new ScannerMesa("SCN-201");

        preparar(impressora);
        preparar(scanner);
        impressora.imprimirPeca(30);
        System.out.println("Filamento restante: " + impressora.filamentoEmGramas() + " g");
        System.out.println(scanner.digitalizar(3));
    }

    static void preparar(Equipamento equipamento) {
        equipamento.ligar();
    }
}
