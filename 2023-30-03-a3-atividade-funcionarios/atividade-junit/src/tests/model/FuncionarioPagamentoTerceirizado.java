package tests.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FuncionarioPagamentoTerceirizado {
    @Test
    public void testaConstrutorFuncionarioTerceirizado() {
        //Testa se o construtor está funcionando corretamente
        FuncionarioPagamentoTerceirizado funcionarioTerceirizado = new FuncionarioPagamentoTerceirizado("Marcos", 40, 10, 100);
        Assertions.assertEquals("João", funcionarioTerceirizado.getNome());
        Assertions.assertEquals(40, funcionarioTerceirizado.getHorasTrabalhadas());
        Assertions.assertEquals(10, funcionarioTerceirizado.getValorPorHora());
        Assertions.assertEquals(100, funcionarioTerceirizado.getDespesaAdicional());

    }


    @Test
    public void testaSetDespesaAdicional() {
        //Testa se o setter está funcionando corretamente
        FuncionarioPagamentoTerceirizado funcionarioTerceirizado = new FuncionarioPagamentoTerceirizado("Marcos", 40, 10, 100);
        funcionarioTerceirizado.setDespesaAdicional(200);
        Assertions.assertEquals(200, funcionarioTerceirizado.getDespesaAdicional());
    }


    @Test
    public void testaCalculaPagamentoFuncionarioTerceirizado() {
        //Testa se o calculo do pagamento está correto
        FuncionarioPagamentoTerceirizado funcionarioTerceirizado = new FuncionarioPagamentoTerceirizado("Marcos", 40, 10, 100);
        Assertions.assertEquals(510, funcionarioTerceirizado.calculaPagamento());
    }

    @Test
    public void testaCalculaPagamentoFuncionarioTerceirizadoDespesaAdicionalMaiorQueMil() {
        //Testa se o calculo do pagamento está correto
        FuncionarioPagamentoTerceirizado funcionarioTerceirizado = new FuncionarioPagamentoTerceirizado("Marcos", 40, 10, 1000);
        Assertions.assertEquals(1320, funcionarioTerceirizado.calculaPagamento());
    }

    @Test
    public void testaCalculaPagamentoFuncionarioTerceirizadoDespesaAdicionalIgualMil() {
        //Testa se o calculo do pagamento está correto
        FuncionarioPagamentoTerceirizado funcionarioTerceirizado = new FuncionarioPagamentoTerceirizado("Marcos", 40, 10, 1000);
        Assertions.assertEquals(1320, funcionarioTerceirizado.calculaPagamento());
    }

}
