package polimorfismo.temperaturas;

public class DemoInterfaces {
    public static void main(String[] args) {
        PainelDeTemperatura painel = new PainelDeTemperatura();
        FonteTemperatura leituraManual = new LeituraManual(21.5);
        FonteTemperatura termometro = new TermometroEmFahrenheit(77);

        System.out.println("Leitura manual: " + painel.exibir(leituraManual));
        System.out.println("Leitura em Fahrenheit convertida: " + painel.exibir(termometro));
    }
}
