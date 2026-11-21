package heranca.transporte;

public class DemoComposicao {
    public static void main(String[] args) {
        Bicicleta urbana = new Bicicleta();
        BicicletaEletrica eletrica = new BicicletaEletrica(1);

        testarPedal(urbana);
        testarPedal(eletrica);
        System.out.println("Primeira volta assistida: " + eletrica.pedalarComAuxilio());
        System.out.println("Segunda volta assistida: " + eletrica.pedalarComAuxilio());

        testarPedal(eletrica);
        System.out.println("Voltas da bicicleta elétrica: " + eletrica.voltasCompletas());
        System.out.println("Carga restante: " + eletrica.cargaRestante());
    }

    static void testarPedal(Bicicleta bicicleta) {
        bicicleta.pedalarUmaVolta();
    }
}
