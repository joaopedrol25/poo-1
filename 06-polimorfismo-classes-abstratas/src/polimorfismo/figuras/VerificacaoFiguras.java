package polimorfismo.figuras;

public class VerificacaoFiguras {
    public static void main(String[] args) {
        Figura circulo = new Circulo("Círculo", 2);
        Figura retangulo = new Retangulo("Placa", 3, 4);
        assert circulo.etiqueta().equals("Círculo: 12.57 cm²");
        assert retangulo.areaEmCentimetrosQuadrados() == 12.0;
        assert Math.abs(DemoFiguras.areaTotal(new Figura[]{circulo, retangulo})
            - (Math.PI * 4 + 12)) < 0.000001;
        assert DemoFiguras.areaTotal(new Figura[0]) == 0.0;

        Figura placaGrande = new Retangulo("Placa grande", 50_000, 50_000);
        assert placaGrande.areaEmCentimetrosQuadrados() == 2_500_000_000.0;

        try {
            new Circulo("Círculo vazio", 0);
            throw new AssertionError("Raio zero aceito.");
        } catch (IllegalArgumentException esperado) {
            assert esperado.getMessage().contains("positiva");
        }
    }
}
