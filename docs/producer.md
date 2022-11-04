https://www.restapitutorial.com/httpstatuscodes.html
# Endpoints

#### method: POST
#### path name: /producer/register
#### body params (inputs): 
```JSON
{
    "firstName": "firsname",
    "lastName": "lastname",
    "email": "email",
    "username": "username",
    "password": "password",
    "phoneNumber": "phoneNumber"
}
```
#### response: successful ? status(201) : status(406)


### method: GET
### path name: /producer/get-by-username/?username=username
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
    "phoneNumber": "phoneNumber"
}
```
#### else status(406)