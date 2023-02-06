#!/bin/bash

docker compose build --build-arg mode=dev
# docker image prune -f
docker compose up -d --remove-orphans