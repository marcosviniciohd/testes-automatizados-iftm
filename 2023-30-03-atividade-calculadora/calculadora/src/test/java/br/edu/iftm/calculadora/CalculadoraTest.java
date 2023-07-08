package br.edu.iftm.calculadora;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {
    private Calculadora calculadora;

    @Test
    public void testarConstrutorSemParamentroInicializaMemoriaComZero() {
        int resultadoEsperado = 0;
        calculadora = new Calculadora();
        int resultadoObtido = calculadora.getMemoria();

        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    public void testarConstrutorComParamentro() {
        int resultadoEsperado = 3;
        calculadora = new Calculadora(3);
        int resultadoObtido = calculadora.getMemoria();

        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    public void testarSomaEntreDoisInteirosSendoUmNegativo() {
        int resultadoEsperado = 0;
        calculadora = new Calculadora(3);
        calculadora.somar(-3);
        int resultadoObtido = calculadora.getMemoria();
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    public void testaMetodoSubtrairComInteiroPositivo() {
        int resultadoEsperado = 0;
        calculadora = new Calculadora(3);
        calculadora.subtrair(3);
        int resultadoObtido = calculadora.getMemoria();

        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    public void testaMetodoDividirPorZero() throws Exception {
        int resultadoEsperado = 0;
        calculadora = new Calculadora(3);
        calculadora.dividir(0);
        int resultadoObtido = calculadora.getMemoria();
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    public void testaMetodoDividirPorNumeroInteiroPositivo() throws Exception {
        int resultadoEsperado = 1;
        calculadora = new Calculadora(3);
        calculadora.dividir(3);

        assertEquals(resultadoEsperado, calculadora.getMemoria());
    }

    @Test
    public void testaMetodoMultiplicarComInteiroPositivo() {
        int resultadoEsperado = 9;
        calculadora = new Calculadora(3);
        calculadora.multiplicar(3);
        int resultadoObtido = calculadora.getMemoria();
        assertEquals(resultadoEsperado, resultadoObtido);

    }

    @Test
    public void testaMetodoExponenciarComMemoriaIgualUm() throws Exception {
        int resultadoEsperado = 1995565057;
        calculadora = new Calculadora(3);
        calculadora.exponenciar(1);

        assertEquals(resultadoEsperado, calculadora.getMemoria());
    }

    @Test
    public void testaMetodoExponenciarComMemoriaIgualDez() throws Exception {
        int resultadoEsperado = 59049;
        calculadora = new Calculadora(3);
        calculadora.exponenciar(10);

        assertEquals(resultadoEsperado, calculadora.getMemoria());
    }

}
