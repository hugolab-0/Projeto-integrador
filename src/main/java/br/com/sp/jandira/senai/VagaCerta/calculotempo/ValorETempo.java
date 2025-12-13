package br.com.sp.jandira.senai.VagaCerta.calculotempo;

public class ValorETempo {

    // Guarda o tempo em milissegundos
    private static long inicio;
    private static long fim;

    //Inicia o timer (entrada do carro)
    public static void iniciarContador() {
        inicio = System.currentTimeMillis();
        fim = 0;
    }

    //Finaliza o timer (saída do carro)

    public static void finalizarContador() {
        fim = System.currentTimeMillis();
    }

    //Subtrai o início do fim e retorna o tempo em minutos

    public static long calcularTempoEmMinutos() {

        if (inicio == 0 || fim == 0) {
            throw new IllegalStateException("Timer não iniciado ou não finalizado.");
        }

        long diferencaMillis = fim - inicio;

        return diferencaMillis / 1000 / 60;
    }

    //Calcula o valor a pagar com base no tempo

    public static double calcularValor() {

        long minutos = calcularTempoEmMinutos();

        // converte minutos para horas reais (decimal)
        double horas = minutos / 60.0;

        // R$10 por hora, sem arredondar
        return horas * 10.0;
    }
    // Retorna o tempo inicial (em millis)
    public static long getInicio() {
        return inicio;
    }


     // Retorna o tempo final (em millis)

    public static long getFim() {
        return fim;
    }
}