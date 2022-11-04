https://www.restapitutorial.com/httpstatuscodes.html
# Endpoints


### method: GET
### path name: /event/get-by-username/?username=username
### request PARAMETERS:
```JSON
{
    "username": "username"
}
```
### response BODY:
```JSON
{
    "eventName": "eventName",
    "neededGleaners": "neededGleaners",
    "description": "description",
    "missionStatement": "missionStatement",
    "imageURL": "imageURL",
    "address": "address",
    "postalCode": "postalCode",
    "city": "city",
}
```
#### else status(406)

#### method: POST
#### path name: /event/register
#### body params (inputs): 
```JSON
{
    "eventName": "eventName",
    "neededGleaners": "neededGleaners",
    "description": "description",
    "missionStatement": "missionStatement",
    "imageURL": "imageURL",
    "address": "address",
    "postalCode": "postalCode",
    "city": "city",
}
```
#### response: successful ? status(201) : status(406)