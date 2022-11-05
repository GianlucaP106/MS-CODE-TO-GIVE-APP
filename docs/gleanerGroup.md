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
    "totalMembers": "totalMembers"
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


### method: GET
### path name: /gleaner-group/get-events-by-id/?id=id
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
### path name: /gleaner-group/get-events-by-username/?username=username
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


### method: GET
### path name: /gleaner-group/get-by-region/?region=region
### request PARAMETERS:
```JSON
{
    "region": "region",
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
    "totalMembers": "totalMembers"
}
```
#### else status(406)


### method: POST
### path name: /gleaner-group/comment-producer/?username=username
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
### path name: /gleaner-group/comment-organization/?username=username
### request BODY:
```JSON
{
    "gleanerId": "gleanerId",
    "organizationId": "organizationId",
    "comment": "comment",
}
```
#### response: successful ? status(201) : status(406)


### method: POST
### path name: /gleaner-group/comment-event/?username=username
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
### path name: /gleaner-group/comment-gleaner/?username=username
### request BODY:
```JSON
{
    "gleanerId": "gleanerId",
    "gleanerId": "gleanerId",
    "comment": "comment",
}
```
#### response: successful ? status(201) : status(406)

