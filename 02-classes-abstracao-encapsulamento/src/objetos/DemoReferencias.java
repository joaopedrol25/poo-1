package objetos;

public class DemoReferencias {
    public static void main(String[] args) {
        CartaoTransporte primeiro = new CartaoTransporte("T-42", "Passe escolar");
        CartaoTransporte alias = primeiro;
        CartaoTransporte segundo = new CartaoTransporte("T-42", "Passe escolar");

        alias.recarregar(500);
        System.out.println("primeiro == alias: " + (primeiro == alias));
        System.out.println("primeiro == segundo: " + (primeiro == segundo));
        System.out.println("Códigos iguais: " + primeiro.getCodigo().equals(segundo.getCodigo()));
        System.out.println("Saldo do primeiro: " + primeiro.getSaldoEmCentavos());
        System.out.println("Saldo do segundo: " + segundo.getSaldoEmCentavos());
    }
}
