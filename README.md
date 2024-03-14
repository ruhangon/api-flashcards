# API para flashcards

## Introdução

A API de flashcards é uma API que visa auxiliar no estudo usando flashcards. O usuário terá como cadastrar baralhos sobre temas diversos, consultar informações de todos os seus baralhos, consultar a próxima carta a ser estudada de um baralho específico, atualizar a fila de uma carta e também conseguirá atualizar os baralhos com mais cartas, se for do seu interesse. Para isso é usado spring boot 3 e java 17, em um projeto que usa arquitetura hexagonal.

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

* Haverá uma porta para ser implementada pela service de cadastro de baralho, para definir que essa precisará ter um método de cadastro. 
* Haverá uma porta para ser implementada pela service de cadastro de carta, para definir que essa terá métodos de cadastro, de apenas uma carta e de uma lista de cartas.
* Haverá uma porta para ser implementada pela service de atualização de carta, para definir que essa terá um método de atualização de fila da carta.
* Haverá uma porta para ser implementada pela service de busca de baralhos, para definir que essa terá um método de consulta de informações.

#### Portas de saída

* Haverá uma porta para ser implementada pela repository de cadastro de baralho, para definir que essa precisará ter um método de cadastro no banco de dados. 
* Haverá uma porta para ser implementada pela repository de cadastro de carta, para definir que essa também terá um método de cadastro no banco de dados. 
* Haverá uma porta para ser implementada pela repository de busca de baralho, para definir que essa terá um método de busca de baralho no banco de dados.
* Haverá uma porta para ser implementada pela repository de atualização de carta, para definir que essa terá um método de atualização de carta no banco de dados.
* Haverá uma porta para ser implementada pela repository de busca de carta, para definir que essa terá um método de busca de fila da carta no banco de dados, outro método para a busca da própria carta e um método para contar a quantidade de cartas de um baralho.
* Haverá uma porta para ser implementada pela repository de busca de baralhos, para definir que essa terá um método de consulta de informações no banco de dados.

#### services

* CadastroDeBaralhoServiceImpl, que contem o método para salvar um novo baralho.
* CadastroDeCartaServiceImpl, que contem o método para salvar uma nova carta.
* AtualizacaoDeCartaServiceImpl, que contem o método para atualizar a fila de uma carta.
* BuscaDeBaralhosServiceImpl, que contem o método para consultar informações dos baralhos.

As services precisam ter cobertura de linha e cobertura de mutação alcançando 100% usando o pitest.

### Adaptador

#### Controllers

* CadastroDeBaralhoController, onde é possível se cadastrar um novo baralho recebido por parâmetro com suas cartas, no path post api-flashcards/baralho/cadastrar

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

* AtualizacaoDeCartaController, onde é possível se atualizar a fila de uma carta através da avaliação do usuário recebida no corpo da requisição e também no id da carta recebido como parâmetro do path, no path patch api-flashcards/carta/{id-carta}/fila/atualizar.

Exemplo de body passado nesse patch =

{
    "carta": {
        "avaliacao": 1
    }
}

E a response de sucesso será um status 200, com o body de status 200 OK.

* CadastroDeCartaController, onde é possível se cadastrar uma nova carta em um baralho. As informações da nova carta vem no corpo da requisição, e o id do baralho vem no path. O path para essa requisição é um post para api-flashcards/baralho/{id-baralho}/carta/cadastrar.

Exemplo de body passado nesse post =

{
    "carta": {
        "frente": "Prazer em te conhecer",
        "tras": "Nice to meet you."
    }
}

E a response de sucesso será um status 201, com o body de status 201 CREATED.

* BuscaDeBaralhosController, onde é possível se consultar algumas informações dos baralhos do usuário, no path get api-flashcards/baralhos/consultar.

O body passado no get é vazio.

E a response de sucesso será um status 200, com o body a seguir =

{
    "baralhos": [
        {
            "nome": "ingles",
            "quantidade_cartas": 50
        },
        {
            "nome": "espanhol",
            "quantidade_cartas": 40
        }
    ]
}

As controllers precisam ter cobertura de linha e cobertura de mutação alcançando 100% usando o pitest.

#### DTOs

Criar as DTOs necessárias para atender ao programa.

#### repositories

Criar as repositories necessárias para o funcionamento do código, usando o Spring data JPA. Também devem ser criadas as entidades necessárias.

As repositories precisam ter cobertura de linha e cobertura de mutação alcançando 100% usando o pitest.

### Config

####BeanConfiguration

Uma classe de configuração para definirmos quais adaptadores serão usados na execução do projeto.

