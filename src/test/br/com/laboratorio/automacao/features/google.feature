#encoding: iso-8859-1
@001_Google
Feature: 001_Google


  @Google_RealizaPesquisa
  Scenario Outline: Validar pesquisa google
    Given acesso a pagina do google
    When realizao uma pesquisa <dado_pesquisa>
    Then valido o resultado da pesquisa

    Examples: 
      | dado_pesquisa  | 
      | "automação com selenium" |
      

