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
    "address": "address",
    "city": "city",
    "postalCode": "postalCode",
    "maxDistance": "maxDistance",
    "websiteLink": "websiteLink",
}
```
#### response: successful ? status(201) : status(406)


### method : GET 
### path name : /organization/get-with-filters
### request body (attribute)
```JSON
{
    "id": "id",
    "username": "username",
    "orgName": "orgName",
    "description": "description",
    "missionStatement": "missionStatement",
    "imageURL": "imageURL",
    "address": "address",
    "city": "city",
    "postalCode": "postalCode",
    "maxDistance": "maxDistance",
    "websiteLink": "websiteLink",
}
```
### return 
```JSON
{
    "organizations": [
        {
            "id": "id",
            "username": "username",
            "orgName": "orgName",
            "description": "description",
            "missionStatement": "missionStatement",
            "imageURL": "imageURL",
            "address": "address",
            "city": "city",
            "postalCode": "postalCode",
            "maxDistance": "maxDistance",
            "websiteLink": "websiteLink",
        }
    ]
}
```
### else status 404


### method: POST
### path name: /organization/comment-producer/
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
### path name: /organization/comment-gleaner/
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
### path name: /organization/comment-event/
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
### path name: /organization/comment-gleaner-group/
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
    "maxDistance": "maxDistance",
    "websiteLink": "websiteLink",
}
```
#### successful ? status(404) : status(404) // not found
