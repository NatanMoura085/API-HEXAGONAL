#!/bin/bash

echo "Limpando dependências antigas..."
mvn clean

echo "Compilando o projeto..."
mvn package -DskipTests

echo "Construindo imagem Docker..."
docker build -t api-hexagonal:latest .

echo "Build concluído com sucesso!"
