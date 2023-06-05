# Gerenciador de Contas
![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)

# Índice 

* [Índice](#índice)
* [Descrição do Projeto](#descrição-do-projeto)
* [Funcionalidades](#funcionalidades)
* [Acesso ao Projeto](#acesso-ao-projeto)
* [Tecnologias utilizadas](#tecnologias-utilizadas)
* [Pessoas Desenvolvedoras do Projeto](#pessoas-desenvolvedoras)
* [Conclusão](#conclusão)

# Descrição do Projeto

# Funcionalidades
- CRUD de usuários
- Autenticação via JWT

# Endpoints



| Endpoint | Http Method | Descrição |
| -------- | --------- | ----------
| /register | POST | Cria um novo usuário |
| /login | POST | Cria um novo usuário |
| /users | GET | Retorna todos os usuários (apenas você estiver autenticado) |
| /users/{id} | GET | Retorna um usuário específico (apenas você estiver autenticado) |
| /update/{id} | PUT | Atualiza os dados de um usuário específico (apenas você estiver autenticado) |
| /delete/{id} | DEL | Deleta um usuário específico (apenas você estiver autenticado) |

 #### ⚠️ Atenção! para que os métodos GET, PUT, e DEL funcionem, é necessario pegar o token gerado após o login e passar na aba Authorization da requisição, definindo o type com "Baerer Token" e inserindo no campo token. Exemplo abaixo:
![Captura de tela 2023-06-03 071644](https://github.com/JoelFnandes/AccountManager/assets/60944861/f29630fe-1b44-4bad-ab7f-424f6304cb8d)



# Acesso ao Projeto
 - Certifique-se de ter o JDK e o MongoDB devidamente instalados em sua máquina.
 - No MongoDB, crie uma Database com o nome "account-manager" e uma Collection com o nome "users". 
 - Após baixar o Gerenciador de Contas, será necessário descompactar o projeto e importá-lo em uma IDE para desenvolvimento Java.
 - Talvez seja necessário instalar o Apache Maven e adicionar o caminho da pasta 'bin' do Maven ao variável de ambiente 'path' do sistema operacional.
 - Com o projeto aberto na sua IDE é interessante atualizar o Maven.  Os passos podem variar um pouco entre as IDEs, mas no Eclipse, você pode simplesmente clicar com o botão direito do mouse no projeto e selecionar Maven -> Update Project. Alternativamente, você pode usar o atalho ALT + F5.
 - Será necessario uma ferramenta para enviar as solicitações HTTP para a API. Recomendo o Postman ou o Insomnia.

# Tecnologias utilizadas

- ``Java``
- ``Spring`` 
- ``InteliJ IDEA``
- ``Eclipse``
- ``MongoDB``
- ``Postman``

# Pessoas Desenvolvedoras do Projeto

| [<img src="https://avatars.githubusercontent.com/u/60944861?v=4" width=115><br><sub>Joel Fernandes</sub>](https://github.com/JoelFnandes) 
| :---: 
