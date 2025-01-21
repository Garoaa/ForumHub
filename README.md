# <h1 align="center">API ForumHub💬</h1>
<p align="center">
<img loading="lazy" src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge"/>
</p>

## Descrição
O ForumHub é uma API Rest Stateless desenvolvida em Java utilizando o Spring Boot, para operações de CRUD e 
gerenciamento de tópicos de dúvida, utilizando do Spring Security para sua segurança.

## 🔨 Funcionalidades do projeto
- `Login de usuários`
- `Criação e gerenciamento de tópicos`
- `Autenticação e autorização utilizando JWT`


## ✅ Tecnologias Utilizadas
- Java 17
- Spring Boot 3.4.1
- Spring Security
- JWT Token
- Hibernate
- MySql
- Insomnia
- Lombok
- DevTools

## 🌐 Principais Endpoints 

### Autenticação
- POST `/login` - Retorna um token JWT se o usuário estiver cadastrado

### Tópicos
- POST `/topicos` - Cadastra um token e retorna o corpo do tópico
- GET `/topicos` - Lista todos os tópicos cadastrados no banco de dados
- GET `/topicos/{id}` - Detalha um tópico específico com base no id informado
- PUT `/topicos/{id}` - Atualiza um tópico já existente
- DELETE `/topicos/{id}` - Deleta um tópico já existente baseado no seu id

## 📁Acesso ao projeto
Você pode acessar o código fonte do projeto e baixa-lo

## ⏯ Como executar o projeto
Após baixar o projeto basta configurar o ip a ser utilizado e o nome, usuario e senha de seu banco de dados, 
na aba ForumHub/src/main/resources/application.properties. Desta forma é só começar a utilizar.

