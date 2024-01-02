# API para flashcards

## Introdução

A API de flashcards é uma API que visa auxiliar no estudo usando flashcards. O usuário terá como cadastrar baralhos sobre temas diversos, consultar informações de todos os seus baralhos, consultar as cartas de um baralho específico e também conseguirá atualizar os baralhos com mais cartas, se for do seu interesse. Para isso é usado spring boot 3 e java 17, em um projeto que usa arquitetura hexagonal.

## Tecnologias

* Java
* Spring boot
* Spring data JPA
* Maven
* MySQL
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

Haverá uma porta para ser implementada pela repository de cadastro de baralho, para definir que essa precisará ter um método de cadastro no banco de dados. Também haverá uma porta para ser implementada pela repository de cadastro de carta, para definir que essa também terá um método de cadastro no banco de dados.

#### services

CadastroDeBaralhoService, que contem o método para salvar um novo baralho.

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

#### DTOs

CadastroDeBaralhoDTO, que contem um nome do tipo String não nulo ou vazio e uma lista de TextosCarta (que contem uma frente do tipo String e um tras do tipo String) com no mínimo 1 carta

#### repositories

Criar as repositories necessárias para o funcionamento do código, usando o Spring data JPA. Também devem ser criadas as entidades necessárias.

### Config

####BeanConfiguration

Uma classe de configuração para definirmos quais adaptadores serão usados na execução do projeto.

