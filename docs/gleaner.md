[http statues](https://www.restapitutorial.com/httpstatuscodes.html)
# Endpoints

#### Create
#### method: POST
#### path name: /gleaner/register
#### body params (inputs): 
```JSON
{
    "firstName": "firsname",
    "lastName": "lastname",
    "email": "email",
    "username": "username",
    "password": "password",
    "phoneNumber": "phoneNumber",
    "postalCode": "postalCode",
    "city": "city",
    "address": "address"
}
```
#### response: successful ? status(201) : status(406)


### method: GET
### path name: /gleaner/get-by-username/?username=username
### request PARAMETERS:
```JSON
{
    "firstName": "firsname",
    "lastName": "lastname",
    "email": "email",
    "username": "username",
    "password": "password",
    "phoneNumber": "phoneNumber",
    "postalCode": "postalCode",
    "city": "city",
    "address": "address"
}
```
### response BODY:
```JSON
{
    "ID": "ID",
    "firstName": "firsname",
    "lastName": "lastname",
    "email": "email",
    "username": "username",
    "password": "password",
    "phoneNumber": "phoneNumber",
    "postalCode": "postalCode",
    "city": "city",
    "address": "address"
}
```
#### else status(406)

### method: PUT
### path name: /gleaner/update
### request PARAMETERS:
```JSON
{
    "ID": "ID",
    "firstName": "firsname",
    "lastName": "lastname",
    "email": "email",
    "username": "username",
    "password": "password",
    "phoneNumber": "phoneNumber",
    "postalCode": "postalCode",
    "city": "city",
    "address": "address"
}
```
#### successful ? status(406) : status(406)


### method : POST
### path name: /gleaner/eventRegister
### request PARAMETERS:
```JSON
{
    "gleanerID" : "gleanerID",
    "eventID" : "eventID",
    "isOwner" : "isOwner",
}
```
#### successful ? status(201) : status(406)


### method: GET
### path name: /gleaner/get-events/?username=username
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
### path name: /gleaner/get-comments/?username=username
### request PARAMETERS:
```JSON
{
    "username": "username",
}
```
### response BODY:
```JSON
{
    "comments": [
        {
            "comment": "comment"
        }
    ]
}
```
#### else status(406)


### method: POST
### path name: /gleaner/comment-producer/?username=username
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
### path name: /gleaner/comment-organization/?username=username
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
### path name: /gleaner/comment-event/?username=username
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
### path name: /gleaner/comment-gleaner-group/?username=username
### request BODY:
```JSON
{
    "gleanerId": "gleanerId",
    "gleanerGroupId": "gleanerGroupId",
    "comment": "comment",
}
```
#### response: successful ? status(201) : status(406)




