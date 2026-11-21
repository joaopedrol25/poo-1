package polimorfismo.temperaturas;

import java.util.Locale;

public final class PainelDeTemperatura {
    public String exibir(FonteTemperatura fonte) {
        return String.format(Locale.ROOT, "%.1f °C", fonte.temperaturaEmCelsius());
    }
}
