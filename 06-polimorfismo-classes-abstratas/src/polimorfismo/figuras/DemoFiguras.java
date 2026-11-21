package polimorfismo.figuras;

import java.util.Locale;

public class DemoFiguras {
    public static void main(String[] args) {
        Figura[] figuras = {
            new Circulo("Círculo do painel", 2),
            new Retangulo("Retângulo da placa", 3, 4)
        };
        for (Figura figura : figuras) {
            System.out.println(figura.etiqueta());
        }
        System.out.printf(Locale.ROOT, "Área total: %.2f cm²%n", areaTotal(figuras));
    }

    static double areaTotal(Figura[] figuras) {
        double total = 0;
        for (Figura figura : figuras) {
            total += figura.areaEmCentimetrosQuadrados();
        }
        return total;
    }
}
