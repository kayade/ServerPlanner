# clone a tomcat image in your local machine from Docker Hub

docker image pull tomcat

# create and start a tomcat container from the image

docker container create --publish 8082:8080 --name my-tomcat-container tomcat

# create a docker image file for your .war and deploy it in docker

# build docker image file for the application from Dockerfile

docker image build -t kayode/serverplanner-image ./

# create and start your new container

docker container run -it --publish 8081:8080 kayode/serverplanner-image


# you can also deploy the war file into GlassFish or Tomcat Application Server


1) Once you have started the application, you can now communicate with the API via the URL http://yourIPAddress:8081/ServerPlanner/webresource/splanner

2) You can send a text or JSON to the API service

3) The format of the message should be similar to this
	{
    "sType": "{CPU: 2, RAM: 32, HDD: 100}",
    "vMachines": "[{CPU: 1, RAM: 16, HDD: 10}, {CPU: 1, RAM: 16, HDD: 10}, {CPU: 2, RAM: 32, HDD: 100}]"
	}
4) You will receive the result