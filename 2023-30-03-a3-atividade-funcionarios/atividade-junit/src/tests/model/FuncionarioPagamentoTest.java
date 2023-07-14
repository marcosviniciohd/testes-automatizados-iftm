package tests.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FuncionarioPagamentoTest {
    @Test
    public void testaConstrutorFuncionario() {
        //Testa se o construtor está funcionando corretamente
        Funcionario funcionario = new Funcionario("João", 40, 10);
        Assertions.assertEquals("João", funcionario.getNome());
        Assertions.assertEquals(40, funcionario.getHorasTrabalhadas());
        Assertions.assertEquals(10, funcionario.getValorPorHora());

    }

    @Test
    public void testaSetNome() {
        //Testa se o setter está funcionando corretamente
        Funcionario funcionario = new Funcionario("João", 40, 10);
        funcionario.setNome("Maria");
        Assertions.assertEquals("Maria", funcionario.getNome());
    }

    @Test
    public void testaSetHorasTrabalhadas() {
        //Testa se o setter está funcionando corretamente
        Funcionario funcionario = new Funcionario("João", 40, 10);
        funcionario.setHorasTrabalhadas(20);
        Assertions.assertEquals(20, funcionario.getHorasTrabalhadas());
    }

    @Test
    public void testaSetValorPorHora() {
        //Testa se o setter está funcionando corretamente
        Funcionario funcionario = new Funcionario("João", 40, 10);
        funcionario.setValorPorHora(20);
        Assertions.assertEquals(20, funcionario.getValorPorHora());
    }

    @Test
    public void testaCalculaPagamentoFuncionario() {
        //Testa se o calculo do pagamento está correto
        Funcionario funcionario = new Funcionario("João", 40, 10);
        Assertions.assertEquals(400, funcionario.calculaPagamento());
    }
}
