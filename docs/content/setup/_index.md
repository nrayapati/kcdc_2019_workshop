+++
title = "Setup"
description = "Workshop Resources / Workstation Step instructions"
weight = 1
alwaysopen = true
lastmodifierdisplayname = "Naresh Rayapati"
+++

* **Instructions to setup your laptop**
    * Install Docker 
    * Create a folder for this workspace 
    * Pull the docker container 
    * Spin up Jenkins
    * http://localhost:8080/
  
##### Install Docker (if it wasn't installed before)

* Mac: https://docs.docker.com/docker-for-mac/
* Windows: https://docs.docker.com/docker-for-windows/install/

##### Create folder on your home folder (User's home)

```shell
cd 
mkdir kcdc
```

##### Pull the docker container

```shell
docker pull nrayapati/jenkins:latest
```

##### Or save it from the flash drive:

```shell
docker load --input jenkins-kdcd.tar
```

##### Spin up Jenkins container

```shell
docker run -d -p 8080:8080 -v ~/kcdc:/var/jenkins_home nrayapati/jenkins:latest 
```