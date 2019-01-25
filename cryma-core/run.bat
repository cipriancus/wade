docker login --username=cipriancus
mvn clean install package

docker build --tag cipriancus/cryma-convert:latest ./cryma-convert/
docker push cipriancus/cryma-convert:latest

docker build --tag cipriancus/cryma-eureka-service:latest ./cryma-eureka-service/
docker push cipriancus/cryma-eureka-service:latest

docker build --tag cipriancus/cryma-news:latest ./cryma-news/
docker push cipriancus/cryma-news:latest

docker build --tag cipriancus/cryma-plot:latest ./cryma-plot/
docker push cipriancus/cryma-plot:latest

REM docker-compose -f docker-compose.yml build
REM docker-compose -f docker-compose.yml up

cd ./k8s