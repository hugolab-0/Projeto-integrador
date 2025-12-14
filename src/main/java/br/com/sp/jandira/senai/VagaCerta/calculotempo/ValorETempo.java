package br.com.sp.jandira.senai.VagaCerta.calculotempo;

public class ValorETempo {

    private static long inicio = -1;
    private static long fim = -1;

    private static final double VALOR_POR_HORA = 10.0;

    // chama quando o carro ENTRA
    public static void iniciarContador() {
        inicio = System.currentTimeMillis();
        fim = -1;
    }

    // chama quando o carro SAI
    public static void finalizarContador() {
        if (inicio == -1) return;
        fim = System.currentTimeMillis();
    }

    // tempo total em minutos
    public static long getTempoEmMinutos() {
        if (inicio == -1 || fim == -1 || fim < inicio) {
            return 0;
        }
        return (fim - inicio) / 60000;
    }

    // valor a pagar (SEM arredondar)
    public static double getValorAPagar() {
        double horas = getTempoEmMinutos() / 60.0;
        return horas * VALOR_POR_HORA;
    }

    // texto pronto: "120 minutos"
    public static String getTempoFormatado() {
        return getTempoEmMinutos() + " minutos";
    }

    // texto pronto: "R$ 20.50"
    public static String getValorFormatado() {
        return "R$ " + String.format("%.2f", getValorAPagar());
    }
}