package br.com.iftm.edu.marcos.vinicio.calculadora;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    @Test
    public void testarSomaDoisInteirosSucesso(){
        //Arrange - Definir o cenário
        Calculadora calculadora = new Calculadora();
        int entradaNumeroUm = 10;
        int entradaNumeroDois = 5;
        int saidaEsperada = 15;
        //Act - Executar métodos que estão testados
        int saidaObtida = calculadora.somar(entradaNumeroUm, entradaNumeroDois);
        //Assign - Validar o resultado obtido
        Assertions.assertEquals(saidaEsperada, saidaObtida);

    }

    @Test
    public void testarDivisaoPorZeroRetornarErro(){
        //Arrange - Definir o cenário
        Calculadora calculadora = new Calculadora();
        int entradaNumeroUm = 10;
        int entradaNumeroDois = 0;
        int saidaEsperada = 0;
        //Act - Executar métodos que estão testados
        Assertions.assertThrows(ArithmeticException.class, ()-> calculadora.dividir(entradaNumeroUm, entradaNumeroDois));

    }
}
