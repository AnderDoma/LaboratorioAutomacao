#encoding: iso-8859-1
@002_Correios
Feature: 002_Correios

  @Correios_consultar_objetos
  Scenario Outline: Realizar a consulta de objetos nos correios
    Given que acesso a pagina dos correios
    And autentico o usuario no site dos correios <usuario> <senha>
    When acompanho meu objeto <num_objeto>
    Then valido o resultado da pesquisa do objeto <num_objeto>

    Examples: 
      | num_objeto      | usuario       | senha      |
      | "12345" 				| "12345" 			| "12345" 	 |
