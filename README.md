# Agenda API - Documentação Técnica

Este projeto consiste em uma API REST para gerenciamento de agenda pessoal, desenvolvida com o ecossistema Spring Boot. A aplicação utiliza autenticação JWT para garantir a privacidade dos dados e o mapeamento relacional JPA para a persistência em banco de dados.

## 1. Segurança e Autenticação (Spring Security)

A camada de segurança foi implementada utilizando Spring Security com o modelo de sessão Stateless.

### Arquitetura JWT
O sistema não armazena o estado da sessão no servidor. A identificação do usuário é feita através de um token JSON Web Token (JWT) assinado digitalmente.

### JwtFilter e Contexto de Segurança
Um filtro customizado (JwtFilter) intercepta as requisições HTTP antes que cheguem aos controllers:
- Extração: O filtro recupera o token do cabeçalho "Authorization".
- Validação: O TokenService valida a assinatura e extrai o "subject" (username).
- Autenticação: O usuário é inserido no SecurityContextHolder. Isso permite que o sistema saiba quem é o usuário logado sem a necessidade de passar o ID no corpo do JSON das requisições.

### Configuração de Acesso
A classe de configuração define as rotas públicas (como /auth/login e /usuarios/cadastro) e protege todas as demais rotas, exigindo a presença de um token válido.

---

## 2. Mapeamento de Relacionamentos (JPA/Hibernate)

A estrutura de dados utiliza os conceitos de relacionamentos bidirecionais do Jakarta Persistence (JPA).

### One-to-Many (@OneToMany)
Na entidade Usuario, a anotação @OneToMany define que um usuário pode possuir diversos registros.
- O parâmetro "mappedBy" é utilizado para indicar que o mapeamento é espelhado pelo campo "usuario" na classe filha.
- O uso de "CascadeType.ALL" garante que operações realizadas no usuário possam refletir em seus registros vinculados.

### Many-to-One (@ManyToOne)
Na entidade Registro, a anotação @ManyToOne estabelece o vínculo de muitos registros para um único usuário.
- @JoinColumn: Define a criação da chave estrangeira "usuario_id" na tabela de registros.
- @JsonIgnore: Esta anotação é crucial no lado Many do relacionamento para interromper a recursão infinita durante a serialização Jackson. Sem ela, o sistema entraria em um loop infinito ao tentar renderizar o usuário dentro do registro e o registro dentro do usuário.

---

## 3. Instruções de Uso

### Fluxo de Teste
1. Realizar uma requisição POST para /auth/login enviando as credenciais.
2. Copiar o token JWT gerado na resposta.
3. Nas requisições de criação de registros, configurar o cabeçalho de autorização como "Bearer Token" no Postman.

### Exemplo de JSON para Criação de Registro
O ID do usuário não é necessário no JSON, pois o sistema o identifica via Token.

{
    "titulo": "Desenvolvimento de API",
    "description": "Finalizar implementação do Spring Security",
    "dataAgenda": "2026-02-27",
    "horaAgenda": "18:00"
}

---
Projeto desenvolvido com foco em persistência de dados e segurança em camadas.
