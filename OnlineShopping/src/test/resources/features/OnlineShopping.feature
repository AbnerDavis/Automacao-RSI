#Author: contato.casttro@outlook.com

Feature: Criar cadastro para clientes 
  Eu como usuario quero gerar um cadastro de forma automatizada 

  Scenario: Criando cadastro 
    Given esteja na tela de cadastro de cliente
    When informar todos os dados obrigatorios
    Then cadastro realizada com sucesso