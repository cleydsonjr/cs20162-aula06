package br.ufg.cs.cleydsonjr;

import org.junit.Before;
import org.junit.Test;

public class PerformaceVerificadorCPFTest {

    private VerificadorCPF verificador;

    @Before
    public void setUp() {
        verificador = new VerificadorCPF();
    }

    @Test
    public void comparacaoDePerformanceDasImplementacoes() throws Exception {
        // Criando array contendo os digitos de um CPF válido
        int[] cpfVerificar = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 9};

        Long tempoInicial = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            verificador.verifiqueUsandoSomaSimples(cpfVerificar);
        }
        Long tempoGastoSomaSimples = (System.nanoTime() - tempoInicial) / 100000;
        System.out.println("Tempo primeiro algoritmo: " + tempoGastoSomaSimples + "ms");

        tempoInicial = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            verificador.verifiqueUsandoLoop(cpfVerificar);
        }
        Long tempoGastoLoop = (System.nanoTime() - tempoInicial) / 100000;
        System.out.println("Tempo segundo algoritmo: " + tempoGastoLoop + "ms");

        tempoInicial = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            verificador.verifiqueUsandoLoopDesenvolvido(cpfVerificar);
        }
        Long tempoGastoLoopDesenvolvido = (System.nanoTime() - tempoInicial) / 100000;
        System.out.println("Tempo terceiro algoritmo: " + tempoGastoLoopDesenvolvido + "ms");
    }

}