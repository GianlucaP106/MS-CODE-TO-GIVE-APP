https://www.restapitutorial.com/httpstatuscodes.html
# Endpoints

#### method: POST
#### path name: /farm/register
#### body params (inputs): 
```JSON
{
    "farmName": "farmName",
    "description": "description",
    "missionStatement": "missionStatement",
    "imageURL": "imageURL",
    "address": "address",
    "postalCode": "postalCode",
    "city": "city",
}
```
#### response: successful ? status(201) : status(406)


### method: GET
### path name: /farm/get-by-username/?username=username
### request PARAMETERS:
```JSON
{
    "username": "username"
}
```
### response BODY:
```JSON
{
    "farmName": "farmName",
    "description": "description",
    "missionStatement": "missionStatement",
    "imageURL": "imageURL",
    "address": "address",
    "postalCode": "postalCode",
    "city": "city",
}
```
#### else status(406)