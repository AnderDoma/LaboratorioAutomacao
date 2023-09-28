#encoding: iso-8859-1
@002_Correios
Feature: 002_Correios

  @Correios_consultar_objetos
  Scenario Outline: Realizar a consulta de objetos nos correios
    Given que acesso a pagina dos correios
    And acesso a pagina de autenticacao
    And autentico o usuario no site dos correios <usuario> <senha>
    When acompanho meu objeto <num_objeto>
    Then valido o resultado da pesquisa do objeto

    Examples: 
      | num_objeto      | usuario       | senha      |
      | "12345" 				| "12345" 			| "12345" 	 |
      
  @Correios_autenticacao_invalida
  Scenario Outline: Realizar autenticacao invalida no site dos correios
    Given que acesso a pagina dos correios
    And acesso a pagina de autenticacao
    And autentico o usuario no site dos correios <usuario> <senha>
    Then valido a mensagem de erro de autenticacao

    Examples: 
      | num_objeto      | usuario       | senha      |
      | "12345" 				| "12345" 			| "12345" 	 |
