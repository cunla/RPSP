`GET http://localhost:8080/app/rest/login?user={user}&password={password}`
Login using account {user} and {password}
Returns HTTP 200 OK in case of success or HTTP 401 Unauthorized in case of failure

`GET http://localhost:8080/app/rest/ping`
If logged in:
Returns the connected user full name and account
If not logged in:
Returns HTTP 401 Unauthorized

`POST http://localhost:8080/app/rest/createUser`
Create a user for account. Requires to be connected as admin.
POST JSON data structure:
```
{account:101,
 username:user,
 password:password,
 fullname:"Full user name"}
```
Returns HTTP 201 Created in case of success, 
HTTP 401 Unauthorized in case not logged in as admin,
HTTP 409 Conflict if username already exists for this account.

`DELETE http://localhost:8080/app/rest/deleteUser?account={account}&user={user}`
Delete user account. Requires to be connected as admin.
Returns HTTP 204 No Content in case of success, 
HTTP 401 Unauthorized in case not logged in as admin,
HTTP 404 Not found if username doesn't exist for account.


`GET http://localhost:8080/rest/mgmt/accounts`
List all accounts
`POST http://localhost:8080/rest/mgmt/accounts` 
Create account
`GET http://localhost:8080/rest/mgmt/users` 
List all users
`POST http://localhost:8080/rest/mgmt/users`
Create user

`GET http://localhost:8080/rest/mgmt/vms` 
List all vms
`GET http://localhost:8080/rest/mgmt/assign/{vm}/{account}` 
Assign virtual machine to a specific device


`POST http://localhost:8080/rest/user/login?user={user}&password={password}` 
Login
`GET http://localhost:8080/rest/account/vms` 
List VMs of account (according to BASICAUTH)

`GET http://localhost:8080/rest/protectVm/{vmId}` 
Protect VM
`POST http://localhost:8080/rest/imageAccess/{vmId}` 
Image access VM
`POST http://localhost:8080/rest/testReplication/{vmId}` 
Test replication of VM
`POST http://localhost:8080/rest/recover/{vm}`
Recover a production VM from a copy
