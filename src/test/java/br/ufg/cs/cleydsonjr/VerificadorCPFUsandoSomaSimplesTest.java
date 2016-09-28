package br.ufg.cs.cleydsonjr;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class VerificadorCPFUsandoSomaSimplesTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    private VerificadorCPF verificador;

    @Before
    public void setUp() {
        verificador = new VerificadorCPF();
    }

    @Test
    public void deveLancarExcacaoParaCPFComNumeroInvalidoDeDigitos() throws Exception {
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("CPF com número incorreto de dígitos fornecido");

        // Criando array com 3 digitos
        int[] cpfVerificar = new int[3];

        verificador.verifiqueUsandoSomaSimples(cpfVerificar);
    }

    @Test
    public void deveRetornarSucessoAoReceberUmCPFValido() throws Exception {
        // Criando array contendo os digitos de um CPF válido
        int[] cpfVerificar = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 9};

        boolean resultado = verificador.verifiqueUsandoSomaSimples(cpfVerificar);

        Assert.assertTrue("O resultado da verificação deveria retornar verdadeiro", resultado);
    }

    @Test
    public void deveRetornarFalhaAoReceberUmCPFInvalido() throws Exception {
        // Criando array contendo os digitos de um CPF inválido
        int[] cpfVerificar = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 1};

        boolean resultado = verificador.verifiqueUsandoSomaSimples(cpfVerificar);

        Assert.assertFalse("O resultado da verificação deveria retornar falso", resultado);
    }

}