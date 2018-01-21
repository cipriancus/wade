cd cryma-core

cf login -a https://api.run.pivotal.io

cd cryma-eureka-service\target
cf push cryma-eureka-service -m 750M -k 512M -p cryma-eureka-service-0.0.1-SNAPSHOT.jar

cd ..\..\cryma-zuul-apigateway\target
cf push cryma -m 750M -k 512M -p cryma-zuul-apigateway-0.0.1-SNAPSHOT.jar

heroku login

cd ..\..\cryma-news\target
heroku create cryma-news
heroku deploy:jar .\cryma-news-0.0.1-SNAPSHOT.jar --app cryma-news

cd ..\..\cryma-plot\target
heroku create cryma-plot
heroku deploy:jar .\cryma-plot-0.0.1-SNAPSHOT.jar --app cryma-plot


cd ..\..\cryma-prediction\target
heroku create cryma-prediction
heroku deploy:jar .\cryma-prediction-0.0.1-SNAPSHOT.jar --app cryma-prediction


cd ..\..\cryma-python-prediction\target
heroku create cryma-python-prediction
heroku deploy:jar .\cryma-python-prediction-0.0.1-SNAPSHOT.jar --app cryma-python-prediction