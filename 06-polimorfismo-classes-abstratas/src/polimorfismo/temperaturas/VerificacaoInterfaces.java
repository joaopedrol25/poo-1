package polimorfismo.temperaturas;

public class VerificacaoInterfaces {
    public static void main(String[] args) {
        PainelDeTemperatura painel = new PainelDeTemperatura();

        assert painel.exibir(new LeituraManual(21.5)).equals("21.5 °C");
        assert painel.exibir(new TermometroEmFahrenheit(77)).equals("25.0 °C");
        assert painel.exibir(new TermometroEmFahrenheit(32)).equals("0.0 °C");
        assert painel.exibir(new TermometroEmFahrenheit(-40)).equals("-40.0 °C");
    }
}
