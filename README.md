# Arquitetura de referência Clean Architecture
## Objetivo
- Implementar uma arquitetura baseada em clean architecture
- Meditar sobre principais trade-off
- Meditar sobre os ganhos/pontos positivos
- Documentar todas as decisões (ou tentar) no README
- A implementação do projeto deve ser "by the book"
## Camadas
### Domain
Responsável por todas as regras de negocio
### Application
Descreve a intenção do usuário por exemplo: criar usuário, enviar e-mail, remover item do carrinho de compras
### Infrastructure
Composta por frameworks e ferramentas como o Banco de Dados, o Web Framework, etc.
![MarineGEO circle logo](assets/CleanArchitecture.jpg)
## Testar com SAM local
Inicie DynamoDB local
```shell
TODO configurar dynamodb-local 
```
Iniciar API local
```shell
sam local start-api --template sam.jvm.yaml
```



## Histórico de Definições

- Mudar estrutura do projeto de pacotes para modulos, vantagens:
    - Separa responsabilidades de forma mais organizada, contribui para "screaming architecture".
    - Evita que camadas de alto nível tenham contato com tecnologias e acessem camadas de baixo nível.
    - Isola problemas de configuração de framework na camada de mais baixo nível.
