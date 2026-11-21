package fundamentos;

import java.util.Locale;

public class DemoStrings {
    public static void main(String[] args) {
        String titulo = "  Introdução à POO  ";
        String semEspacosExternos = titulo.strip();
        String tituloEmMaiusculas = semEspacosExternos.toUpperCase(Locale.ROOT);
        System.out.println(tituloEmMaiusculas);
        System.out.println("Primeiro char: " + semEspacosExternos.charAt(0));
        System.out.println("Vogais: " + contarVogais(semEspacosExternos));

        String linguagem = "Java";
        String entrada = new String(new char[] {'J', 'a', 'v', 'a'});
        System.out.println("Mesmo conteúdo? " + linguagem.equals(entrada));
        System.out.println("Mesma referência? " + (linguagem == entrada));

        StringBuilder codigo = new StringBuilder("POO");
        codigo.append('-').append(1);
        String codigoFinal = codigo.toString();
        System.out.println("Código montado: " + codigoFinal);
    }

    static int contarVogais(String texto) {
        String minusculo = texto.toLowerCase(Locale.ROOT);
        String vogais = "aeiouáàâãéêíóôõú";
        int total = 0;
        for (int indice = 0; indice < minusculo.length(); indice++) {
            if (vogais.indexOf(minusculo.charAt(indice)) >= 0) {
                total++;
            }
        }
        return total;
    }
}
