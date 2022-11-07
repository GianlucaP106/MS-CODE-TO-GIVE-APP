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
    "websiteLink": "websiteLink"
}
```
#### response: successful ? status(201) : status(406)


### method : GET 
### path name : /organization/get-with-filters
### request body (attribute)
```JSON
{
    "ID": "ID",
    "username": "username",
    "orgName": "orgName",
    "description": "description",
    "missionStatement": "missionStatement",
    "imageURL": "imageURL",
    "address": "address",
    "city": "city",
    "postalCode": "postalCode",
    "maxDistance": "maxDistance",
    "websiteLink": "websiteLink"
}
```
### return 
```JSON
{
    "organizations": [
        {
            "ID": "ID",
            "username": "username",
            "orgName": "orgName",
            "description": "description",
            "missionStatement": "missionStatement",
            "imageURL": "imageURL",
            "address": "address",
            "city": "city",
            "postalCode": "postalCode",
            "maxDistance": "maxDistance",
            "websiteLink": "websiteLink"
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
    "organizationID": "organizationID",
    "producerID": "producerID",
    "comment": "comment",
    "authorType": "authorType"
}
```
#### response: successful ? status(201) : status(406)


### method: POST
### path name: /organization/comment-gleaner/
### request BODY:
```JSON
{
    "organizationID": "organizationID",
    "gleanerID": "gleanerID",
    "comment": "comment",
    "authorType": "authorType"
}
```
#### response: successful ? status(201) : status(406)


### method: POST
### path name: /organization/comment-event/
### request BODY:
```JSON
{
    "organizationID": "organizationID",
    "eventID": "eventID",
    "comment": "comment",
    "authorType": "authorType"
}
```
#### response: successful ? status(201) : status(406)


### method: POST
### path name: /organization/comment-gleaner-group/
### request BODY:
```JSON
{
    "organizationID": "organizationID",
    "gleanerGroupID": "gleanerGroupID",
    "comment": "comment",
    "authorType": "authorType"
}
```
#### response: successful ? status(201) : status(406)


#### method: PUT
#### path name: /organization/update
#### body params (inputs): 
```JSON
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
    "maxDistance": "maxDistance",
    "websiteLink": "websiteLink"
}
```
#### successful ? status(404) : status(404) // not found


### method : POST
### path name: /organization/event-register
### request PARAMETERS:
```JSON
{
    "organizationId" : "organizationId",
    "eventID" : "eventID"
}
```
#### successful ? status(201) : status(406)
