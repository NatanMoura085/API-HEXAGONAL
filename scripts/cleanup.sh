#!/bin/bash

echo "Iniciando limpeza do ambiente..."

docker-compose down


docker volume prune -f


docker image prune -a -f


docker container prune -f


echo "Limpeza concluída!"
