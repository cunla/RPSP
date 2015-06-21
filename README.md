
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
 * VM ownership 
 * Accounts and users
 * Tenants activity

All operations are done through RP4VM REST API.

###INSTALLATION
####Installation prerequisites:
 1. Java ver 1.8 and above
 2. 100 MB of available disk space
 3. Connectivity to all RecoverPoint for Virtual Machines systems
 4. Open port (default 8080) on machine where RPSP is deployed
 
####Installation instructions:
 1. Download the RPSP code from GIT
 2. Deploy fapi-client to your local repository using
    `mvn install:install-file -Dfile=fapi_client_4_1-1.0.jar -DgroupId=com.emc -DartifactId=fapi-client -Dversion=4.1 -Dpackaging=jar`
 2. Compile and package RPSP using maven, using command:  `mvn package` 
    Note: Since RPSP uses spring-boot and H2 embedded database, it does not have any prerequisite software installed.
 3. Run Application class from the WAR file using the command `java -jar rpsp.war`
 4. You can also deploy the WAR on your own web-container (tomcat/etc.)

####INSTALLATION AS WINDOWS SERVICE
It is recommended to configure RPSP to run as a Windows Service as explained in this guide: https://nssm.cc/usage

##USER OPERATIONS
To access RPSP either AngularJS client or the REST API can be used
##RPSP UI – AngularJS Client
The QURT Web client can be accessed in: http://hostname:8080/rpsp (8080 is the default port) 

RPSP UI provides the following functionality:
 1. RPSP Configuration – Define RP systems to collect data from
	 - List RP clusters for system
	 - Assign country per cluster
	 - Update settings (i.e., change RP user/password)
 2. Generate report of #VMs per month per country
     - Select report quarter (past or current)
 
###RPSP REST API
The following methods are supported in the RPSP RESP API, with base being http://*hostname*:*port*/rpsp

1. Accounts API *(admin permissions only)*
	 - `GET /accounts`  Get all accounts
	 - `GET  /accounts?systemId=”your-system-id”` Get accounts related to specific system 
	 - `GET /accounts/{id}` Get specific account 
	 - `POST /accounts?systemId=”your-system-id”` Create account under specific system 
	 - `POST /accounts/{id}` Update specific account 
	 - `DELETE /accounts/{id}` Delete specific account 
	
2.  Users API *(admin permissions only)*
     - `GET /users` Get all users 
     - `GET /users?accountId =”your-account-id”` Get users related to specific account 
     - `GET /users/{id}` Get specific user 
     - `POST /users?accountId =”your-account-id”` Create user under specific account 
     - `POST /users/{id}` Update specific user 
     - `DELETE /users/{id}` Delete specific user 

3. VMs API *(admin permissions only)*
     - `GET /vmownership` Get all vms 
     - `GET /vmownership?accountId =”your-account-id”` Get vms related to specific account 
     - `GET /vmownership/{id}` Get specific vm 
     - `POST /vmownership?accountId =”your-account-id”` Create vm under specific account 
     - `POST /vmownership/{id}`  Update specific vm 
     - `DELETE /vmownership/{id}` Delete specific vm 

4. User actions
    - `POST /login-action` Login with user
        Headers: `Content-Type: application/x-www-form-urlencoded`
        Body example: `username=user@account&password=xxxx`
    - `POST /logout-action` Logout
    - `GET /account-vms` - Full VMs hierarchy data restricted by logged in user and his related account info  (protected\unprotected\cg etc)
    - `PUT /image-access/enable?clusterId={clusterId}&groupId={groupId}&copyId={copyId}` - Enable image access to latest image
      Additional query params:
      * snapshotId={snapshotId} - specific snapshot
      * timestamp={timestamp} - specific timestamp

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

