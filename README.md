# Gerenciador de Contas

*Endpoints:*
| Endpoint | Http Method | Descrição |
| -------- | --------- | ----------
| account-manager/v1/users | GET | Retorna todas os usuários existentes |
| account-manager/v1/users/{id} | GET | Retorna o usuário especificado pelo id |
| account-manager/v1/users/{id}/apps | GET | Retorna todos os aplicativos relacionados ao usuário com este id |
| account-manager/v1/users | POST | Salva um usuário   |
| account-manager/v1/users | PUT | Atualiza um usuário   |
| account-manager/v1/users/{id} | DELETE | Remove um usuário  com o id especificado |
| account-manager/v1/apps | GET | Retorna todas os aplicativos existentes |
| account-manager/v1/apps/{id} | GET | Retorna o aplicativo especificado pelo id |
| account-manager/v1/apps | POST | Salva um aplicativo relacionando-o a um usuário   |
| account-manager/v1/apps | PUT | Atualiza um aplicativo   |
| account-manager/v1/apps/{id} | DELETE | Remove um aplicativo  com o id especificado |

### Detalhamento do Contrato da API

Uma especificação mais detalhada, porém ainda com um alto nível será encontrada [aqui](https://github.com/marciotenorio/account-manager/tree/main/src/main/resources/contracts). 

### Casos de uso: Gerenciador de Contas

-  CRUD de usuários

-  Pesquisa de todos os aplicativos relacionados a determinado usuário

- CRUD de aplicativos
  
  
