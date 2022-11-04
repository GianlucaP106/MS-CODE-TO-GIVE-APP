https://www.restapitutorial.com/httpstatuscodes.html
# Endpoints


#### method: POST
#### path name: /organization/register
#### body params (inputs): 
```JSON
{
    "username": "username",
    "password": "password",
    "orgName": "orgName",
    "description": "description",
    "missionStatement": "missionStatement",
    "imageURL": "imageURL",
    "address": "address",
    "city": "city",
    "postalCode": "postalCode",
}
```
#### response: successful ? status(201) : status(406)


### method: GET
### path name: /organization/get-by-username/?username=username
### request PARAMETERS:
```JSON
{
    "username": "username"
}
```
### response BODY:
```JSON
{
    "username": "username",
    "password": "password",
    "orgName": "orgName",
    "description": "description",
    "missionStatement": "missionStatement",
    "imageURL": "imageURL",
    "address": "address",
    "city": "city",
    "postalCode": "postalCode",
}
```
#### else status(406)