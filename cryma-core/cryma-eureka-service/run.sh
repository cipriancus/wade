docker build --tag "cryma-eureka" .
docker run -e "SPRING_PROFILES_ACTIVE=prod" -p 8081:8081 cryma-eureka