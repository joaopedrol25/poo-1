package heranca.exercicio;

public class DemoIngresso {
    public static void main(String[] args) {
        Ingresso inteira = new Ingresso("Mostra de cinema", 2501);
        IngressoEstudantil meia = new IngressoEstudantil("Mostra de cinema", 2501, "2026-017");

        System.out.println(inteira.resumo());
        System.out.println(meia.resumo());
        System.out.println("Matrícula apresentada: " + meia.matricula());
    }
}
