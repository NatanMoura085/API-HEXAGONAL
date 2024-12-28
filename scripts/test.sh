#!/bin/bash

echo "Executando testes automatizados..."
mvn test

if [ $? -eq 0 ]; then
  echo "Todos os testes passaram!"
else
  echo "Falhas nos testes. Corrija antes de continuar."
  exit 1
fi
