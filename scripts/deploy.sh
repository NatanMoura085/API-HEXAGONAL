#!/bin/bash
# Script para fazer o deploy da aplicação na AWS

# Configurações (alterar conforme necessário)
APP_NAME="myapp"
DOCKER_HUB_USER="seu-usuario-docker"
AWS_INSTANCE="ec2-user@seu-servidor-aws"
DEPLOY_PATH="/var/www/myapp"

echo "Fazendo login no Docker Hub..."
docker login -u "$DOCKER_HUB_USER" -p "$DOCKER_PASSWORD"

echo "Subindo imagem para o Docker Hub..."
docker tag $APP_NAME:latest $DOCKER_HUB_USER/$APP_NAME:latest
docker push $DOCKER_HUB_USER/$APP_NAME:latest

echo "Conectando ao servidor AWS..."
ssh $AWS_INSTANCE << EOF
  echo "Parando contêiner existente..."
  docker stop $APP_NAME || true && docker rm $APP_NAME || true

  echo "Baixando nova imagem..."
  docker pull $DOCKER_HUB_USER/$APP_NAME:latest

  echo "Subindo nova versão da aplicação..."
  docker run -d --name $APP_NAME -p 8080:8080 $DOCKER_HUB_USER/$APP_NAME:latest
EOF

echo "Deploy concluído com sucesso!"
