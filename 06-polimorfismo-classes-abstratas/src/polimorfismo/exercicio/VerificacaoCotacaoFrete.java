package polimorfismo.exercicio;

public class VerificacaoCotacaoFrete {
    public static void main(String[] args) {
        Frete padrao = new FretePadrao();
        Frete expresso = new FreteExpresso();
        Frete retirada = new Retirada();
        assert padrao.cotarEmCentavos(1) == 1050;
        assert padrao.cotarEmCentavos(1000) == 1050;
        assert padrao.cotarEmCentavos(1001) == 1200;
        assert expresso.cotarEmCentavos(1500) == 2260;
        assert expresso.cotarEmCentavos(30_000) == 10_100;
        assert retirada.cotarEmCentavos(1500) == 0;

        for (Frete frete : new Frete[]{padrao, expresso, retirada}) {
            conferirPesoInvalido(frete, 0);
            conferirPesoInvalido(frete, 30_001);
        }
    }

    private static void conferirPesoInvalido(Frete frete, int peso) {
        try {
            frete.cotarEmCentavos(peso);
            throw new AssertionError("Peso inválido aceito pela modalidade " + frete.modalidade());
        } catch (IllegalArgumentException esperado) {
            assert esperado.getMessage().contains("peso");
        }
    }
}
