REM @FOR /f "tokens=*" %i IN ('minikube docker-env') DO @%i

docker login --username=cipriancus

mvn clean install package

docker build --tag cipriancus/cryma-convert:latest ./cryma-convert/
docker push cipriancus/cryma-convert:latest

docker build --tag cipriancus/cryma-eureka:latest ./cryma-eureka/
docker push cipriancus/cryma-eureka:latest

docker build --tag cipriancus/cryma-news:latest ./cryma-news/
docker push cipriancus/cryma-news:latest

docker build --tag cipriancus/cryma-plot:latest ./cryma-plot/
docker push cipriancus/cryma-plot:latest

docker-compose -f docker-compose.yml build
docker-compose -f docker-compose.yml up
REM kubectl apply -f ./k8s