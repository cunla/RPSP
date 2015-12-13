
RecoverPoint Self-Service Portal (RPSP)
=======================================
#User Guide

###INTRODUCTION
The RecoverPoint self-service portal is a utility for service providers to enable tenants to use 
RecoverPoint functionality in a secured manner that won't allow tenants to use VMs that do not belong to them.

###OVERVIEW
It can connect to multiple RecoverPoint for Virtual Machines clusters and uses a MySQL database 
to assign VM per tenant. Each tenant can view the status of his VMs after login and do RP4VM operations
with the portal. All activities are audited. 

RPSP is deployed as a standalone jar and can be ran as a windows service (using nssm) or linux deamon. 
A standalone web-container exposes REST services and an AngularJS client for tenants.

Database holds information about
 * RP4VM connectivity 
 * Packages information (packages are the settings for RP4VM actions, e.g., ESXi, datastore)
 * VM ownership 
 * Accounts and users
 * Tenants activity

All operations are done through RP4VM REST API.

###INSTALLATION

####Deploying as a docker
It is possible to build a docker from this project. After building the project, in the project root directory
To build the docker which is based on the java8 docker, run the command `docker build -t rpsp .` (use `sudo` if you are on a linux environment)

After that you can run the docker using:
`sudo docker run --name rpsp -e DB_URL=jdbc:mysql://127.0.0.1:3306/rpsp -e DB_USER=rpsp -e DB_PASSWORD=rpsp -p 9999:8080 -d rpsp`

Alternatively you can simply run RPSP from dockerhub using
`sudo docker run --name rpsp -e DB_URL=jdbc:mysql://127.0.0.1:3306/rpsp -e DB_USER=rpsp -e DB_PASSWORD=rpsp -p 9999:8080 -d shpboris/rpsp`

Notice you need to define the environment variables to connect to the database RPSP will be using.
`DB_URL` - The jdbc URL
`DB_USER` - User to connect to database
`DB_PASSWORD` - User password to connect to database

####Installation prerequisites:
 1. Java ver 1.8 and above
 2. 100 MB of available disk space
 3. Connectivity to all RecoverPoint for Virtual Machines systems
 4. Open port (default 8080) on machine where RPSP is deployed
 
####Installation instructions:
 1. Download the RPSP code from GIT
 2. Deploy fapi-client to your local repository using the command
    `mvn install:install-file -Dfile=fapi-client-4.3.jar -DgroupId=com.emc -DartifactId=fapi-client -Dversion=4.3 -Dpackaging=jar` 
    from the root directory of the code (where the file is located).
    
 3. Set database assosiation:
    RPSP comes out of the box using H2 embedded file system database so it does not require any settings changed.
    
    However, if you like to work with other database, you can change the configuration under `src/main/resources/config/application.yml`
    You can see example of MySQL connection under `src/main/resources/config/application-dev.yml`.
    Notice the drivers that are bundled are for mysql and H2 - add to pom.xml drivers if needed.
    
    You need to set up two schemas on your database, one for RPSP data (tenants, users, RP4VM systems, etc.) and another for the audit log. 
        
 3. Compile and package RPSP using maven, using command:  `mvn package` 
 4. Run Application class from the WAR file using the command `java -jar rpsp.war`
 4.1. if you want to run in embedded DB mode use the profile `test` when running: `java -jar rpsp.war --spring.profiles.active=test`
 5. You can also deploy the WAR on your own web-container (tomcat/etc.)

####Installation as a windows service
It is recommended to configure RPSP to run as a Windows Service as explained in this guide: https://nssm.cc/usage

###Getting started
After running the app make sure that accessing the port brings a login screen.
The initial account/user/password to work with are: system/admin/123.

In order to add your first RP system and its relevant data, a support REST API was created
`GET /rpsp/data-loader/internal-data/template`
There is a template for an array of RP system configurations.
Each RP system as its clusters and its accounts.
Each account has a list of all its virtual machines registered as their vSphere ID when using DR **in** the cloud template.
When a RP system is set as DR **to** the cloud the available virtual machines for replication are found using the RP4VM REST API.
The clusters' ids can be found using:
`https://{RPSYSTEM IP}:7225/fapi/rest/4_1/system/virtual_infrastructures/state`
The
vCenter ID, ESXi ID, etc. can be found using:
`https://{RPSYSTEM IP}:7225/fapi/rest/4_3/clusters/1948638374096422771/virtual_infra_configuration`
* You can get the vmId from vSphere client or from fapi full system settings using `https://{RPSYSTEM IP}:7225/fapi/rest/4_3/settings`
Other than that, each account should have a list of users to do operations,
and a configuration for default protection ESX and datastore.



##USER OPERATIONS
To access RPSP either AngularJS client or the REST API can be used
##RPSP UI – AngularJS Client
The RPSP Web client can be accessed in: http://hostname:9999/rpsp (9999 is the default port) 

###RPSP REST API
The following methods are supported in the RPSP REST API, with base being http://*hostname*:*port*/rpsp

1. RP systems API *(admin permissions only)*
     - `GET /rest/systems` Get list of all RP4VM systems installed
     - `GET /rest/systems/{id}` Get specific RP4VM system
     - `GET /rest/testSystem/{id}` Test connectivity to system with specific ID
     - `POST /rest/addSystem` Add RP4VM system with JSON structure
         
           `{
     			"ip": "10.10.10.10",
     			"user": "admin",
     			"password": "password"
     	   }`
     	   
        The return value is all the systems with connectivity status and list of clusters found in the RP4VM system.        
     - `PUT /rest/updateClusterForSystem/{id}` Update cluster settings under specific system (id)
        
        `{
            "country":"Country Cluster reside in, for logical purposes",
            "clusterId":"The cluster to update",
            "clusterName":"Real cluster name from RP4VM",
            "friendlyName":"Cluster friendly name to appear on RPSP GUI"
        }`

2. Accounts API *(admin permissions only)*
	 - `GET /accounts`  Get all accounts
	 - `GET  /accounts?systemId=”your-system-id”` Get accounts related to specific system 
	 - `GET /accounts/{id}` Get specific account 
	 - `POST /accounts?systemId=”your-system-id”` Create account under specific system 
	 - `POST /accounts/{id}` Update specific account 
	 - `DELETE /accounts/{id}` Delete specific account 
	 - `POST /account-configs?accountId =”your-account-id”` Add account config to account
       
       `{
                               "clusterId": "32265119157574180",
                               "vcId": "0864BD09-AF20-47BA-976C-8AE3F05C5689",
                               "esxId": "4210af6f-4274-3e81-ecbf-65dbaedead42",
                               "datastoreId": "datastore-63",
                               "testNetworkId": "testNetworkId"
       }`
	
3.  Users API *(admin permissions only)*
     - `GET /users` Get all users 
     - `GET /users?accountId =”your-account-id”` Get users related to specific account 
     - `GET /users/{id}` Get specific user 
     - `POST /users?accountId =”your-account-id”` Create user under specific account 
        `{
            "vmId": "50050edd-9ab2-c72b-f82f-9a0ef42e9774",
            "vmName": "SB Reporting services VM"
         }`
     - `POST /users/{id}` Update specific user 
     - `DELETE /users/{id}` Delete specific user 

4. VMs API *(admin permissions only)*
     - `GET /vmownership` Get all vms 
     - `GET /vmownership?accountId =”your-account-id”` Get vms related to specific account 
     - `GET /vmownership/{id}` Get specific vm 
     - `POST /vmownership?accountId =”your-account-id”` Create vm under specific account 
     - `POST /vmownership/{id}`  Update specific vm 
     - `DELETE /vmownership/{id}` Delete specific vm 

5. User actions
    - `POST /login-action` Login with user
        Headers: `Content-Type: application/x-www-form-urlencoded`
        Body example: `username=user@account&password=xxxx`
    - `POST /logout-action` Logout
    - `GET /account-vms` - Full VMs hierarchy data restricted by logged in user and his related account info  (protected\unprotected\cg etc)
    - `PUT /groups/{groupId}/clusters/{clusterId}/copies/{copyId}/image-access/enable-latest` 	- Enable image access to latest image
    - `PUT /groups/{groupId}/clusters/{clusterId}/copies/{copyId}/image-access/enable` -  	Enable image access to specific bookmark or specific snapshot that is identified by the 	following properties in HTTP body:
    
	   `{
			"snapshotId": 86726505317,
			"timestamp": 1439908537855236
	   }`
	   
    - `PUT /groups/{groupId}/clusters/{clusterId}/copies/{copyId}/image-access/disable` - 	Disables the image image access to specific copy
    - `POST /groups/{groupId}/bookmarks` - Creates a bookmark for the specific group. Name of 	the bookamrk and its consistency type are passed in HTTP body.
    
	   `{
			"name": "Bookmark_A",
			"consistencyType": "app-consistency"
	   }`
	 
	- `POST /groups-sets/{group-set-id}/bookmarks` - Creates a bookmark for the specific 	group set. Name of the bookamrk and its consistency type are passed in HTTP body.
    
	   `{
			"name": "Bookmark_B",
			"consistencyType":"crash-consistency"
	   }`
   
	- `POST /groups/{groupId}/vms` - Adds VM to the specific consistency group that is 	identified by {groupId}.
	The following values are passed in the HTTP body - the id of the VM, its order in the 	boot sequence (sequenceNumber) and if it is critical or not. 

	   `{
		"id": "5005e38f-efe0-5e16-f1bc-eac6ba19f503",
		"isCritical": true,
		"sequenceNumber": 3
	   }`
   
   - `DELETE /groups/{groupId}/vms/{vm-id}` - Removes VM that is identified by {vm-id} from group that is 	identified by {groupId}.
    
###CONTRIBUTION INSTRUCTIONS
Create a fork of the project into your own repository. 
Make all your necessary changes and create a pull request with a description on what was added or removed and details explaining the changes in lines of code. If approved, project owners will merge it.

### Technologies used
#####Server side
* JAVA + maven
* Spring
* Spring-boot
* Hibernate + MySQL database
* retrofit (REST API consumption)
* jackson (json serialization)
* logback (logger)

#####Client side
* AngularJS + Bootstrap
* angular-translate
* jQuery

###LICENSING
The MIT License (MIT)
Copyright (c) 2015, Daniel Moran & Boris Shpilyuck

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

###SUPPORT
Please file bugs and issues at the Github issues page. For more general discussions you can contact the EMC Code team at [Google Groups](https://groups.google.com/forum/#!forum/emccode-users) or tagged with EMC on [Stackoverflow.com](https://stackoverflow.com/). The code and documentation are released with no warranties or SLAs and are intended to be supported through a community driven process.

