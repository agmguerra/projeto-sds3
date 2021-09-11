# projeto-sds3
Este projeto foi criado para ser o repositório da semana devsuperior. É um exemplo de desenvolvimento de um projeto fullstack com backend Spring Boot e frontend React

O backend está dísponível no HEROKU juntamente com o database POSTGRES

O frontend está disponibilizado no Netlify

## Banco de Dados local
Para iniciar o Postgres foi utilizado um container docker:
  
**docker run -d -p 5432:5432 --name postgres -e POSTGRES_PASSWORD=1234567 -e POSTGRES_DB=db_projeto_sds3 postgres:12-alpine**

Dentro do projeto backend existe um arquivo create.sql com os scripts para criação de tabela e carga inicial


