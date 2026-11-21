package objetos;

public class DemoEncapsulamento {
    public static void main(String[] args) {
        CartaoTransporte cartao = new CartaoTransporte("T-42", "Passe escolar");
        cartao.recarregar(1_000);
        System.out.println("Primeira passagem: " + cartao.pagarPassagem(480));
        System.out.println("Segunda passagem: " + cartao.pagarPassagem(480));
        System.out.println("Terceira passagem: " + cartao.pagarPassagem(480));
        System.out.println("Saldo em centavos: " + cartao.getSaldoEmCentavos());

        cartao.setApelido("Trajeto para o campus");
        System.out.println("Apelido atualizado: " + cartao.getApelido());
    }
}
