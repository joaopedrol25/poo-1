package heranca.transporte;

public class VerificacaoComposicao {
    public static void main(String[] args) {
        BicicletaEletrica eletrica = new BicicletaEletrica(1);
        DemoComposicao.testarPedal(eletrica);
        assert eletrica.voltasCompletas() == 1;
        assert eletrica.cargaRestante() == 1;

        boolean primeiraAssistida = eletrica.pedalarComAuxilio();
        boolean segundaAssistida = eletrica.pedalarComAuxilio();
        assert primeiraAssistida;
        assert !segundaAssistida;
        assert eletrica.voltasCompletas() == 2;
        assert eletrica.cargaRestante() == 0;

        DemoComposicao.testarPedal(eletrica);
        assert eletrica.voltasCompletas() == 3;
        eletrica.recarregar();
        assert eletrica.cargaRestante() == 1;
    }
}
