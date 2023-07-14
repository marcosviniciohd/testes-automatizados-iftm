package tests;

public class FuncionarioTest {
    /*
    Sugestão: Faça seguindo o princípio do TDD (escreva os testes antes de fazer as classes
    Funcionário e FuncionárioTerceirizado).
    - Necessário no mínimo dois commits no github, um com a criação dos testes e outro com o código
    desenvolvido. Entretanto pode ter mais commits, versões diferentes, refatoração.
    - Caso você venha a não utilizar o github, precisará entregar no mínimo duas versões do projeto.
     */
    /*Emrpesa possui funcionarios proprios e terceirizados
    * Para cada funcionario vamos resgistrar nome, horas trabalhadas e valor por hora
    * Funcionario terceirizado possui uma despesa adicional
    * O pagamento dos funcionarios corresponde ao valor da hora multiplicado pelas horas trabalhadas,
    * sendo que os funcionarios terceirizados ainda recebem um bônus correspondente a 110% de sua despesa adicional.
    * As regras para o cálculo do pagamento são as seguintes:
        ● O valor do pagamento dos funcionários deve ser maior ou igual ao valor atual do salário mínimo,
        que corresponde a R$ 1320.00.
        ● Os funcionários podem trabalhar por no máximo 40 horas.
        ● O valor por hora precisa ser entre 4% e 10% do salário mínimo.
        ● O valor das despesas adicionais não pode ultrapassar R$ 1000.00.
        *
        * Crie testes para validar os métodos da classe, inclusive o construtor e os setters. No caso do
           construtor e setters, você deve cobrir pelo menos dois cenários para cada: quando os dados
           satisfazem, e quando não satisfazem a regra de negócio (um total de pelo menos 10 testes).
        *
     * */

    public void testaConstrutorFuncionario(){
        //Testa se o construtor está funcionando corretamente

    }

}
