https://www.restapitutorial.com/httpstatuscodes.html
# Endpoints

#### Create
#### method: POST
#### path name: /gleaner/register
#### body params (inputs): 
```JSON
{
    "firstName": "firsname",
    "lastName": "lastname",
    "email": "email",
    "username": "username",
    "password": "password",
    "phoneNumber": "phoneNumber",
    "postalCode": "postalCode",
    "city": "city",
    "address": "address"
}
```
#### response: successful ? status(201) : status(406)



### method: GET
### path name: /gleaner/get-by-username/?username=username
### request PARAMETERS:
```JSON
{
    "username": "username"
}
```
### response BODY:
```JSON
{
    "firstName": "firsname",
    "lastName": "lastname",
    "email": "email",
    "username": "username",
    "password": "password",
    "phoneNumber": "phoneNumber",
    "postalCode": "postalCode",
    "city": "city",
    "address": "address"
}
```
#### else status(406)




### method: PUT
### path name: /gleaner/update
### request PARAMETERS:
```JSON
{
    "firstName": "firsname",
    "lastName": "lastname",
    "email": "email",
    "username": "username",
    "password": "password",
    "phoneNumber": "phoneNumber",
    "postalCode": "postalCode",
    "city": "city",
    "address": "address"
}
```

#### successful ? status(406) : status(406)