https://www.restapitutorial.com/httpstatuscodes.html
# Endpoints

### method: GET
### path name: /gleaner-group/get-by-username/?username=username
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
    "groupName": "groupName",
    "region": "region",
    "description": "description",
    "missionStatement": "missionStatement",
    "imageURL": "imageURL",
}
```
#### else status(406)


#### method: POST
#### path name: /gleaner-group/register
#### body params (inputs): 
```JSON
{
    "username": "username",
    "password": "password",
    "groupName": "groupName",
    "region": "region",
    "description": "description",
    "missionStatement": "missionStatement",
    "imageURL": "imageURL",
}
```
#### response: successful ? status(201) : status(406)