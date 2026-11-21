package polimorfismo.exercicio;

public class DemoCotacaoFrete {
    public static void main(String[] args) {
        int pesoEmGramas = 1500;
        Frete[] fretes = { new FretePadrao(), new FreteExpresso(), new Retirada() };

        for (Frete frete : fretes) {
            System.out.printf("%s: %d centavo(s)%n",
                frete.modalidade(), frete.cotarEmCentavos(pesoEmGramas));
        }
    }
}
