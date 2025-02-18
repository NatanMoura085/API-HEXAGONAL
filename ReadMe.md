# API de Pedidos

## Descrição
A **API de Pedidos** é um sistema RESTful para gerenciamento de pedidos, permitindo criação, consulta, atualização e exclusão de pedidos. A API foi desenvolvida utilizando **Spring Boot**, **PostgreSQL** e segue boas práticas de arquitetura.

## Tecnologias Utilizadas
- **Java 17**
- **Spring Boot** (Spring Web, Spring Data JPA, Spring Security)
- **PostgreSQL**
- **JWT para Autenticação**
- **Flyway para Migração de Banco de Dados**
- **Swagger (SpringDoc) para Documentação**
- **Docker e Kubernetes (EKS - AWS)**

## Instalação

### Requisitos
- **JDK 17**
- **Maven**
- **Docker (caso queira rodar via container)**
- **PostgreSQL rodando localmente**

### Configuração do Banco de Dados
Caso esteja rodando localmente, crie um banco de dados no PostgreSQL:

```sql
CREATE DATABASE pedidos;
```

Defina as configurações no `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/pedidos
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

### Executando o Projeto

1. Clone o repositório:
   ```sh
   git clone https://github.com/seu-usuario/api-pedidos.git
   cd api-pedidos
   ```
2. Execute o projeto com Maven:
   ```sh
   mvn spring-boot:run
   ```
3. Acesse a API em:
   ```sh
   http://localhost:8080
   ```
4. Acesse a documentação Swagger:
   ```sh
   http://localhost:8081/swagger-ui/index.html
   ```

## Endpoints Principais

### Autenticação
- `POST /auth/login` - Gera token JWT
- `POST /auth/register` - Registra novo usuário

### Pedidos
- `GET /pedidos` - Lista todos os pedidos
- `GET /pedidos/{id}` - Consulta um pedido específico
- `POST /pedidos` - Cria um novo pedido
- `PUT /pedidos/{id}` - Atualiza um pedido existente
- `DELETE /pedidos/{id}` - Exclui um pedido

## Deploy no AWS EKS

### Criando o Cluster EKS
```sh
eksctl create cluster --name pedidos-cluster --region us-west-2 --nodegroup-name pedidos-nodes --node-type t2.medium --nodes 2
```

### Construindo e Enviando a Imagem Docker
```sh
docker build -t api-pedidos .
aws ecr get-login-password --region us-west-2 | docker login --username AWS --password-stdin <aws_account_id>.dkr.ecr.us-west-2.amazonaws.com
docker tag api-pedidos:latest <aws_account_id>.dkr.ecr.us-west-2.amazonaws.com/api-pedidos:latest
docker push <aws_account_id>.dkr.ecr.us-west-2.amazonaws.com/api-pedidos:latest
```

### Aplicando os Manifests Kubernetes
```sh
kubectl apply -f k8s/deployment.yaml
kubectl apply -f k8s/service.yaml
kubectl apply -f k8s/ingress.yaml
```

## Contribuição
Sinta-se à vontade para contribuir enviando pull requests!

## Licença
MIT License

