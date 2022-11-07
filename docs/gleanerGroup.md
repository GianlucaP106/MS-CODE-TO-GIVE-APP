https://www.restapitutorial.com/httpstatuscodes.html
# Endpoints

#### method: POST
#### path name: /gleaner-group/register
#### body params (inputs): 
```JSON
{
    "username": "username",
    "password": "password",
    "groupName": "groupName",
    "region": "region",
    "address": "address",
    "city": "city",
    "postalCode": "postalCode",
    "description": "description",
    "missionStatement": "missionStatement"
}
```
#### response: successful ? status(201) : status(406)


### method: POST
### path name: /gleaner-group/comment-producer/?username=username
### request BODY:
```JSON
{
    "gleanerGroupID": "gleanerGroupID",
    "producerId": "producerId",
    "comment": "comment"
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
    "comment": "comment"
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
    "authorType": "authorType"
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
    "comment": "comment"
}
```
#### response: successful ? status(201) : status(406)


### method : GET 
### path name : /gleaner-group/get-with-filters
### request body
```JSON
{
    "id": "id",
    "username": "username",
    "groupName": "groupName",
    "region": "region",
    "description": "description",
    "missionStatement": "missionStatement",
    "imageURL": "imageURL",
    "totalMembers": "totalMembers"
}
```
### return 
```JSON
{
    "groups": [
        {   
            "id": "id",
            "username": "username",
            "groupName": "groupName",
            "region": "region",
            "description": "description",
            "missionStatement": "missionStatement",
            "imageURL": "imageURL",
            "totalMembers": "totalMembers",
            "address": "address",
            "city": "city",
            "postalCode": "postalCode"
        }
    ]
}
```
### else status 404


#### method: PUT
#### path name: /gleaner-group/update
#### body params (inputs): 
```JSON
{
    "ID": "ID",
    "username": "username",
    "password": "password",
    "groupName": "groupName",
    "region": "region",
    "description": "description",
    "missionStatement": "missionStatement",
    "imageURL": "imageURL",
    "address": "address",
    "city": "city",
    "postalCode": "postalCode"
}
```
#### successful ? status(404) : status(404) // not found
