# API para flashcards

## Introdução

A API de flashcards é uma API que visa auxiliar no estudo usando flashcards. O usuário terá como cadastrar baralhos sobre temas diversos, consultar informações de todos os seus baralhos, consultar as cartas de um baralho específico e também conseguirá atualizar os baralhos com mais cartas, se for do seu interesse. Para isso é usado spring boot 3 e java 17.

## Tecnologias

* Java
* Spring boot
* Spring data JPA
* Maven
* MySQL
* Testes unitários usando junit e mockito
* Testes de mutação usando pitest

## Desenvolvimento

### Controllers

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

### Models

CadastroDeBaralhoDTO, que contem um nome do tipo String não nulo ou vazio e uma lista de TextosCarta (que contem uma frente do tipo String e um tras do tipo String) com no mínimo 1 carta

Além dessa também podemos ter possíveis entidades para o funcionamento da API.

### services

CadastroDeBaralhoService, que contem o método para salvar um novo baralho.

### repositories

Criar as repositories necessárias para o funcionamento do código, usando o Spring data JPA.

