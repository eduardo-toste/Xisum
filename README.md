# Xisum

> 🚧 **Em desenvolvimento.** Este README será substituído por uma versão completa quando o projeto for finalizado.

## O que é

Xisum é uma plataforma de duelos de conhecimento entre estudantes. Cada jogador escolhe ano escolar, matéria e conteúdo, cria uma sala, convida um amigo por link, e os dois competem respondendo perguntas ao vivo para ver quem domina melhor o assunto.

O foco não é substituir listas de exercícios ou professores — é tornar a revisão mais engajante através de competição amigável entre colegas.

## Stack

- **Java + Spring Boot** — REST API e WebSocket (STOMP)
- **PostgreSQL** — dados permanentes (tópicos, questões, resultados)
- **Redis** — estado das salas em andamento
- **Flyway** — versionamento de schema

## Arquitetura, em resumo

- Criar sala, entrar em sala e listar conteúdo passam por REST.
- Durante o duelo, WebSocket mantém os dois jogadores sincronizados em tempo real.
- Um `DuelEngine` central concentra a lógica de pontuação e regras, desacoplado de HTTP e WebSocket — a mesma lógica é reaproveitada por diferentes portas de entrada.
- O banco de questões é consumido pelo projeto, mas populado por um processo externo — geração e curadoria de conteúdo não fazem parte deste repositório.

## Status

Em desenvolvimento ativo. Documentação completa, instruções de setup e endpoints serão adicionados quando o projeto avançar.