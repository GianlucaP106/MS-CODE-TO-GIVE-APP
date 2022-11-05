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


### method : GET 
### path name : /organization/get-with-filters
### request body
```JSON
{
    "id" : "id",
    "eventName": "eventName",
    "neededGleaners": "neededGleaners",
    "description": "description",
    "missionStatement": "missionStatement",
    "imageURL": "imageURL",
    "address": "address",
    "postalCode": "postalCode",
    "city": "city",
    "isUrgent": "isUrgent",
    "radius" : "radius"
}
```
### return 
```JSON
{
    "organizations": [
        {
            "id": "id",
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
    ]
}
```
### else status 404


### method: POST
### path name: /organization/comment-producer/?username=username
### request BODY:
```JSON
{
    "organizationId": "organizationId",
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
    "organizationId": "organizationId",
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
    "organizationId": "organizationId",
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
    "organizationId": "organizationId",
    "gleanerGroupId": "gleanerGroupId",
    "comment": "comment",
}
```
#### response: successful ? status(201) : status(406)


#### method: PUT
#### path name: /organization/update
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
#### successful ? status(404) : status(404) // not found
