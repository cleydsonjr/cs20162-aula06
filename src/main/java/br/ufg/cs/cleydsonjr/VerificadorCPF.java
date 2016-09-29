package br.ufg.cs.cleydsonjr;

/**
 * Classe auxiliar contendo métodos para verificação de validade de um CPF fornecido.
 */
public class VerificadorCPF {
    private static final int TAMANHO_CPF = 11;

    /**
     * Verifica a validade de um CPF fornecido usando um algoritimo baseado em soma simples dos digitos
     * Equivalente ao "Algoritimo 22" da especificação da atividade: ´CPF(d[])´
     *
     * @param cpfInformado Array de inteiros contendo os 11 digitos do CPF
     * @return O resultado da verificação se o CPF informado é válido
     */
    public boolean verifiqueUsandoSomaSimples(int[] cpfInformado) {
        // Verificando se o Array fornecido tem o tamanho correto
        valideArrayFornecido(cpfInformado);

        // Extraindo digitos do Array
        int digito1 = cpfInformado[0];
        int digito2 = cpfInformado[1];
        int digito3 = cpfInformado[2];
        int digito4 = cpfInformado[3];
        int digito5 = cpfInformado[4];
        int digito6 = cpfInformado[5];
        int digito7 = cpfInformado[6];
        int digito8 = cpfInformado[7];
        int digito9 = cpfInformado[8];
        int digito10 = cpfInformado[9];
        int digito11 = cpfInformado[10];

        // Somando primeros 9 digitos multiplicando os pesos
        int primeiraSoma = digito1 + 2 * digito2 + 3 * digito3 + 4 * digito4 + 5 * digito5 + 6 * digito6 + 7 * digito7 + 8 * digito8 + 9 * digito9;
        // Somando digitos 2 a 10 multiplicando os pesos
        int segundaSoma = digito2 + 2 * digito3 + 3 * digito4 + 4 * digito5 + 5 * digito6 + 6 * digito7 + 7 * digito8 + 8 * digito9 + 9 * digito10;

        // Obtendo primeiro digito verificador
        int digitoVerificador1 = (primeiraSoma % 11) % 10;
        // Obtendo segundo digito verificador
        int digitoVerificador2 = (segundaSoma % 11) % 10;

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
    public boolean verifiqueUsandoLoop(int[] cpfInformado) {
        // Verificando se o Array fornecido tem o tamanho correto
        valideArrayFornecido(cpfInformado);

        int digito10 = cpfInformado[9];
        int digito11 = cpfInformado[10];

        int primeiraSoma = cpfInformado[8];
        int segundaSoma = cpfInformado[8];

        // Iterando sobre digitos para obter as somas
        for (int i = 7; i >= 0; i--) {
            primeiraSoma += cpfInformado[i];
            segundaSoma += primeiraSoma;
        }

        // Obtendo primeiro digito verificador
        int digitoVerificador1 = (segundaSoma % 11) % 10;

        // Obtendo segundo digito verificador
        int auxiliar = segundaSoma - primeiraSoma + 9 * digitoVerificador1;
        int digitoVerificador2 = (auxiliar % 11) % 10;

        // Comparando digitos calculados com os fornecidos
        return digitoVerificador1 == digito10 && digitoVerificador2 == digito11;
    }

    /**
     * Verifica a validade de um CPF fornecido usando uma variação do algoritimo "verifiqueUsandoLoop", removendo o Loop
     *
     * @param cpfInformado Array de inteiros contendo os 11 digitos do CPF
     * @return O resultado da verificação se o CPF informado é válido
     */
    public boolean verifiqueUsandoLoopDesenvolvido(int[] cpfInformado) {
        // Verificando se o Array fornecido tem o tamanho correto
        valideArrayFornecido(cpfInformado);

        // Extraindo digitos do Array
        int digito1 = cpfInformado[0];
        int digito2 = cpfInformado[1];
        int digito3 = cpfInformado[2];
        int digito4 = cpfInformado[3];
        int digito5 = cpfInformado[4];
        int digito6 = cpfInformado[5];
        int digito7 = cpfInformado[6];
        int digito8 = cpfInformado[7];
        int digito9 = cpfInformado[8];
        int digito10 = cpfInformado[9];
        int digito11 = cpfInformado[10];

        // Obtendo primeira soma
        int primeiraSoma = digito9 + digito8 + digito7 + digito6 + digito5 + digito4 + digito3 + digito2 + digito1;
        // Obtendo segunda soma
        int segundaSoma = digito9 * 9 + digito8 * 8 + digito7 * 7 + digito6 * 6 + digito5 * 5 + digito4 * 4 + digito3 * 3 + digito2 * 2 + digito1;

        // Obtendo primeiro digito verificador
        int digitoVerificador1 = (segundaSoma % 11) % 10;

        // Obtendo segundo digito verificador
        int auxiliar = segundaSoma - primeiraSoma + 9 * digitoVerificador1;
        int digitoVerificador2 = (auxiliar % 11) % 10;

        // Comparando digitos calculados com os fornecidos
        return digitoVerificador1 == digito10 && digitoVerificador2 == digito11;
    }

    /**
     * Metodo auxiliar para validação simples do array com os digitos de um CPF
     *
     * @param cpfInformado Array com CPF para validar
     */
    private void valideArrayFornecido(int[] cpfInformado) {
        // Array deve ter 11 digitos
        if (cpfInformado.length != TAMANHO_CPF) {
            throw new IllegalArgumentException("CPF com número incorreto de dígitos fornecido");
        }
    }

}
