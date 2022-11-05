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

### method: GET
### path name: /organization/get-events-by-id/?id=id
### request PARAMETERS:
```JSON
{
    "id": "id",
}
```
### response BODY:
```JSON
{
    "events": [
        {
            "id" : "id",
            "eventName": "eventName",
            "description": "description",
            "missionStatement": "missionStatement",
            "imageURL": "imageURL",
            "address": "address",
            "postalCode": "postalCode",
            "city": "city",
        }
    ]
}
```
#### else status(406)


### method: GET
### path name: /organization/get-events-by-username/?username=username
### request PARAMETERS:
```JSON
{
    "username": "username",
}
```
### response BODY:
```JSON
{
    "events": [
        {
            "id" : "id",
            "eventName": "eventName",
            "description": "description",
            "missionStatement": "missionStatement",
            "imageURL": "imageURL",
            "address": "address",
            "postalCode": "postalCode",
            "city": "city",
        }
    ]
}
```
#### else status(406)


### method: POST
### path name: /organization/comment-producer/?username=username
### request BODY:
```JSON
{
    "gleanerId": "gleanerId",
    "producerId": "producerId",
    "comment": "comment",
}
```
#### response: successful ? status(201) : status(406)


### method: POST
### path name: /organization/comment-gleaner/?username=username
### request BODY:
```JSON
{
    "gleanerId": "gleanerId",
    "gleanerId": "gleanerId",
    "comment": "comment",
}
```
#### response: successful ? status(201) : status(406)


### method: POST
### path name: /organization/comment-event/?username=username
### request BODY:
```JSON
{
    "gleanerId": "gleanerId",
    "eventId": "eventId",
    "comment": "comment",
}
```
#### response: successful ? status(201) : status(406)


### method: POST
### path name: /organization/comment-gleaner-group/?username=username
### request BODY:
```JSON
{
    "gleanerId": "gleanerId",
    "gleanerGroupId": "gleanerGroupId",
    "comment": "comment",
}
```
#### response: successful ? status(201) : status(406)