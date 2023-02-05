# catmash-api
vote for the cutest cat

# start db + API (exposed on port 8090)
docker compose up -d
docker compose up -d --force-recreate

# stop (variations : delete data, delete docker images)
docker compose down
docker compose down -v 
docker compose down --rmi all