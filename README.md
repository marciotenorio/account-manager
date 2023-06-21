# Gerenciador de Contas
![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)
# Índice 

* [Índice](#índice)
* [Endpoints](#endpoints)
* [Detalhamento do Contrato da API](#detalhamento-do-contrato-da-api)
* [Casos de uso: Gerenciador de Contas](#casos-de-uso-gerenciador-de-contas)
* [Tecnologias utilizadas](#tecnologias-utilizadas)
* [Pessoas Desenvolvedoras do Projeto](#pessoas-desenvolvedoras-do-projeto)
  
## *Endpoints:*
| Endpoint | Http Method | Descrição |
| -------- | --------- | ----------
| account-manager/users | GET | Retorna todas os usuários existentes |
| account-manager/users/{id} | GET | Retorna o usuário especificado pelo id |
| account-manager/users/cpf/90909090901 | GET | Retorna o usuário especificado pelo cpf |
| account-manager/users/cnpj/90909090901 | GET | Retorna o usuário especificado pelo cnpj |
| account-manager/users/{id}/apps | GET | Retorna todos os aplicativos relacionados ao usuário com este id |
| account-manager/users | POST | Salva um usuário   |
| account-manager/users | PUT | Atualiza um usuário   |
| account-manager/users/{id} | DELETE | Remove um usuário  com o id especificado |
| account-manager/apps | GET | Retorna todas os aplicativos existentes |
| account-manager/apps/{id} | GET | Retorna o aplicativo especificado pelo id |
| account-manager/apps | POST | Salva um aplicativo relacionando-o a um usuário   |
| account-manager/apps | PUT | Atualiza um aplicativo   |
| account-manager/apps/{id} | DELETE | Remove um aplicativo  com o id especificado |

### Detalhamento do Contrato da API

Uma especificação mais detalhada, porém ainda com um alto nível será encontrada [aqui](https://github.com/marciotenorio/account-manager/tree/main/src/main/resources/contracts). 

### Casos de uso: Gerenciador de Contas

-  CRUD de usuários

-  Pesquisa de todos os aplicativos relacionados a determinado usuário

- CRUD de aplicativos

### Tecnologias utilizadas

- ``Java``
- ``Spring`` 
- ``InteliJ IDEA``
- ``Eclipse``
- ``MongoDB``
- ``Postman``

### Pessoas Desenvolvedoras do Projeto

| [<img src="https://avatars.githubusercontent.com/u/32425824?v=4" width=115><br><sub>Márcio Tenório</sub>](https://github.com/marciotenorio) | [<img src="https://avatars.githubusercontent.com/u/85880875?v=4" width=115><br><sub>Dimitri-Code56</sub>](https://github.com/Dimitri-Code56) | [<img src="https://avatars.githubusercontent.com/u/60944861?v=4" width=115><br><sub>Joel Fernandes</sub>](https://github.com/JoelFnandes) |
| :---: | :---: | :---: |
