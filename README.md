# API para flashcards

## Introdução

A API de flashcards é uma API que visa auxiliar no estudo usando flashcards. O usuário terá como cadastrar baralhos sobre temas diversos, consultar informações de todos os seus baralhos, consultar as cartas de um baralho específico e também conseguirá atualizar os baralhos com mais cartas, se for do seu interesse. Para isso é usado spring boot 3 e java 17, em um projeto que usa arquitetura hexagonal.

O código terá uma grande cobertura de testes unitários, além de também ter cobertura de testes de integração.

## Tecnologias

* Java
* Spring boot
* Maven
* MySQL
* Spring data JPA
* Testes unitários usando junit e mockito
* Testes de mutação usando pitest

## Desenvolvimento

O projeto é dividido em 3 pastas principais. A primeira é para a camada de domínio onde teremos as classes de domínio do projeto, as portas de entrada, as portas de saída e as services. A segunda é para a camada de adaptador, que visa conter a parte do projeto que interage com o exterior, onde teremos nossas controllers e repositories. Por fim, a terceira será uma pasta de config, para termos classes de configuração para o projeto.

### Domínio

Teremos duas classes de domínio, são elas Baralho e Carta.

Baralho terá um id, um nome e uma lista de cartas.

Carta terá um id, uma frente, uma trás e uma fila.

#### Portas de entrada

Haverá uma porta para ser implementada pela service de cadastro de baralho, para definir que essa precisará ter um método de cadastro. Também haverá uma porta para ser implementada pela service de cadastro de carta, para definir que essa também terá um método de cadastro.

#### Portas de saída

Haverá uma porta para ser implementada pela repository de cadastro de baralho, para definir que essa precisará ter um método de cadastro no banco de dados. Também haverá uma porta para ser implementada pela repository de cadastro de carta, para definir que essa também terá um método de cadastro no banco de dados. Além dessas haverá uma porta para ser implementada pela repository de busca de baralho, para definir que essa terá um método de busca de baralho.

#### services

CadastroDeBaralhoServiceImpl, que contem o método para salvar um novo baralho.

CadastroDeCartaServiceImpl, que contem o método para salvar uma nova carta.

As services precisam ter cobertura de linha e cobertura de mutação alcançando 100% usando o pitest.

### Adaptador

#### Controllers

CadastroDeBaralhoController, onde é possível se cadastrar um novo baralho recebido por parâmetro com suas cartas, no path post api-flashcards/baralhos/cadastrar

Exemplo de body passado nesse post =

{
    "baralho": {
        "nome": "ingles",
        "cartas": [
            {
                "frente": "qual é o seu nome?",
                "tras": "what is your name?"
            },
            {
                "frente": "como vai você?",
                "tras": "how are you?"
            }
        ]
    }
}

E a response de sucesso será um status 201, com o body de status 201 CREATED.

As controllers precisam ter cobertura de linha e cobertura de mutação alcançando 100% usando o pitest.

#### DTOs

Criar as DTOs necessárias para atender ao programa.

#### repositories

Criar as repositories necessárias para o funcionamento do código, usando o Spring data JPA. Também devem ser criadas as entidades necessárias.

As repositories precisam ter cobertura de linha e cobertura de mutação alcançando 100% usando o pitest.

### Config

####BeanConfiguration

Uma classe de configuração para definirmos quais adaptadores serão usados na execução do projeto.

