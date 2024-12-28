#!/bin/bash

AWS_INSTANCE="ec2-user@seu-servidor-aws"
PREVIOUS_IMAGE="myapp:previous"

echo "Conectando ao servidor AWS..."
ssh $AWS_INSTANCE << EOF
  echo "Parando a versão atual..."
  docker stop myapp || true && docker rm myapp || true

  echo "Revertendo para a versão anterior..."
  docker run -d --name myapp -p 8080:8080 $PREVIOUS_IMAGE
EOF

echo "Rollback concluído!"
