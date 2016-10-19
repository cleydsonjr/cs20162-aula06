package br.ufg.cs.cleydsonjr;

/**
 * Classe auxiliar contendo métodos para verificação de validade de um CPF fornecido.
 */
public class VerificadorCPF {

    /**
     * Representação do tamanho padrão de um CPF.
     */
    private static final int TAMANHO_CPF = 11;

    /**
     * Representação do número Zero.
     */
    private static final int ZERO = 0;

    /**
     * Representação do número Um.
     */
    private static final int UM = 1;

    /**
     * Representação do número Dois.
     */
    private static final int DOIS = 2;

    /**
     * Representação do número Três.
     */
    private static final int TRES = 3;

    /**
     * Representação do número Quatro.
     */
    private static final int QUATRO = 4;

    /**
     * Representação do número Cinco.
     */
    private static final int CINCO = 5;

    /**
     * Representação do número Seis.
     */
    private static final int SEIS = 6;

    /**
     * Representação do número Zero.
     */
    private static final int SETE = 7;

    /**
     * Representação do número Zero.
     */
    private static final int OITO = 8;

    /**
     * Representação do número Nove.
     */
    private static final int NOVE = 9;

    /**
     * Representação do número Dez.
     */
    private static final int DEZ = 10;

    /**
     * Verifica a validade de um CPF fornecido usando um algoritimo baseado em soma simples dos digitos.
     * Equivalente ao "Algoritimo 22" da especificação da atividade: ´CPF(d[])´
     *
     * @param cpfInformado Array de inteiros contendo os 11 digitos do CPF
     * @return O resultado da verificação se o CPF informado é válido
     */
    public final boolean verifiqueUsandoSomaSimples(final int[] cpfInformado) {
        // Verificando se o Array fornecido tem o tamanho correto
        valideArrayFornecido(cpfInformado);

        // Extraindo digitos do Array
        int digito1 = cpfInformado[ZERO];
        int digito2 = cpfInformado[UM];
        int digito3 = cpfInformado[DOIS];
        int digito4 = cpfInformado[TRES];
        int digito5 = cpfInformado[QUATRO];
        int digito6 = cpfInformado[CINCO];
        int digito7 = cpfInformado[SEIS];
        int digito8 = cpfInformado[SETE];
        int digito9 = cpfInformado[OITO];
        int digito10 = cpfInformado[NOVE];
        int digito11 = cpfInformado[DEZ];

        // Somando primeros NOVE digitos multiplicando os pesos
        int primeiraSoma = digito1;
        primeiraSoma += DOIS * digito2;
        primeiraSoma += TRES * digito3;
        primeiraSoma += QUATRO * digito4;
        primeiraSoma += CINCO * digito5;
        primeiraSoma += SEIS * digito6;
        primeiraSoma += SETE * digito7;
        primeiraSoma += OITO * digito8;
        primeiraSoma += NOVE * digito9;

        // Somando digitos 2 a DEZ multiplicando os pesos
        int segundaSoma = digito2;
        segundaSoma += DOIS * digito3;
        segundaSoma += TRES * digito4;
        segundaSoma += QUATRO * digito5;
        segundaSoma += CINCO * digito6;
        segundaSoma += SEIS * digito7;
        segundaSoma += SETE * digito8;
        segundaSoma += OITO * digito9;
        segundaSoma += NOVE * digito10;

        // Obtendo primeiro digito verificador
        int digitoVerificador1 = (primeiraSoma % TAMANHO_CPF) % DEZ;
        // Obtendo segundo digito verificador
        int digitoVerificador2 = (segundaSoma % TAMANHO_CPF) % DEZ;

        // Comparando digitos calculados com os fornecidos
        return digitoVerificador1 == digito10 && digitoVerificador2 == digito11;
    }

    /**
     * Verifica a validade de um CPF fornecido usando uma variação do algoritimo similar avaliação de um
     * polinômio pelo Método de Horner.
     * Equivalente ao "Algoritimo 23" da especificação da atividade: ´CPF2(d[])´
     *
     * @param cpfInformado Array de inteiros contendo os 11 digitos do CPF
     * @return O resultado da verificação se o CPF informado é válido
     */
    public final boolean verifiqueUsandoLoop(final int[] cpfInformado) {
        // Verificando se o Array fornecido tem o tamanho correto
        valideArrayFornecido(cpfInformado);

        int digito10 = cpfInformado[NOVE];
        int digito11 = cpfInformado[DEZ];

        int primeiraSoma = cpfInformado[OITO];
        int segundaSoma = cpfInformado[OITO];

        // Iterando sobre digitos para obter as somas
        for (int i = SETE; i >= ZERO; i--) {
            primeiraSoma += cpfInformado[i];
            segundaSoma += primeiraSoma;
        }

        // Obtendo primeiro digito verificador
        int digitoVerificador1 = (segundaSoma % TAMANHO_CPF) % DEZ;

        // Obtendo segundo digito verificador
        int auxiliar = segundaSoma - primeiraSoma + NOVE * digitoVerificador1;
        int digitoVerificador2 = (auxiliar % TAMANHO_CPF) % DEZ;

        // Comparando digitos calculados com os fornecidos
        return digitoVerificador1 == digito10 && digitoVerificador2 == digito11;
    }

    /**
     * Verifica a validade de um CPF fornecido usando variação do algoritimo "verifiqueUsandoLoop", removendo o Loop.
     *
     * @param cpfInformado Array de inteiros contendo os 11 digitos do CPF
     * @return O resultado da verificação se o CPF informado é válido
     */
    public final boolean verifiqueUsandoLoopDesenvolvido(final int[] cpfInformado) {
        // Verificando se o Array fornecido tem o tamanho correto
        valideArrayFornecido(cpfInformado);

        // Extraindo digitos do Array
        int digito1 = cpfInformado[ZERO];
        int digito2 = cpfInformado[UM];
        int digito3 = cpfInformado[DOIS];
        int digito4 = cpfInformado[TRES];
        int digito5 = cpfInformado[QUATRO];
        int digito6 = cpfInformado[CINCO];
        int digito7 = cpfInformado[SEIS];
        int digito8 = cpfInformado[SETE];
        int digito9 = cpfInformado[OITO];
        int digito10 = cpfInformado[NOVE];
        int digito11 = cpfInformado[DEZ];

        // Obtendo primeira soma
        int primeiraSoma = digito9 + digito8 + digito7 + digito6 + digito5 + digito4 + digito3 + digito2 + digito1;

        // Obtendo segunda soma
        int segundaSoma = digito9 * NOVE;
        segundaSoma += digito8 * OITO;
        segundaSoma += digito7 * SETE;
        segundaSoma += digito6 * SEIS;
        segundaSoma += digito5 * CINCO;
        segundaSoma += digito4 * QUATRO;
        segundaSoma += digito3 * TRES;
        segundaSoma += digito2 * DOIS;
        segundaSoma += digito1;

        // Obtendo primeiro digito verificador
        int digitoVerificador1 = (segundaSoma % TAMANHO_CPF) % DEZ;

        // Obtendo segundo digito verificador
        int auxiliar = segundaSoma - primeiraSoma + NOVE * digitoVerificador1;
        int digitoVerificador2 = (auxiliar % TAMANHO_CPF) % DEZ;

        // Comparando digitos calculados com os fornecidos
        return digitoVerificador1 == digito10 && digitoVerificador2 == digito11;
    }

    /**
     * Metodo auxiliar para validação simples do array com os digitos de um CPF.
     *
     * @param cpfInformado Array com CPF para validar
     */
    private void valideArrayFornecido(final int[] cpfInformado) {
        // Array deve ter 11 digitos
        if (cpfInformado.length != TAMANHO_CPF) {
            throw new IllegalArgumentException("CPF com número incorreto de dígitos fornecido");
        }
    }

}
