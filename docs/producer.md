https://www.restapitutorial.com/httpstatuscodes.html
# Endpoints

#### method: POST
#### path name: /producer/register
#### body params (inputs): 
```JSON
{
    "firstName": "firstName",
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


### method : GET 
### path name : /producer/get-with-filters
### request body
```JSON
{
    "id": "id",
    "firstName": "firsname",
    "lastName": "lastname",
    "email": "email",
    "username": "username",
    "phoneNumber": "phoneNumber"
}
```
### return 
```JSON
{
    "producers": [
        {
            "id": "id",
            "firstName": "firsname",
            "lastName": "lastname",
            "email": "email",
            "username": "username",
            "phoneNumber": "phoneNumber"
        }
    ]
}
```
### else status 404


### method: GET
### path name: /producer/get-comments/?username=username
### request PARAMETERS:
```JSON
{
    "username": "username"
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
### path name: /producer/comment-volunteer/?username=username
### request BODY:
```JSON
{
    "producerId": "producerId",
    "volunteerId": "volunteerId",
    "comment": "comment"
}
```
#### response: successful ? status(201) : status(406)


### method: POST
### path name: /producer/comment-gleaner-group/?username=username
### request BODY:
```JSON
{
    "producerId": "producerId",
    "gleanerGroupId": "gleanerGroupId",
    "comment": "comment"
}
```
#### response: successful ? status(201) : status(406)


### method: POST
### path name: /producer/comment-organization/?username=username
### request BODY:
```JSON
{
    "producerId": "producerId",
    "organizationId": "organizationId",
    "comment": "comment"
}
```
#### response: successful ? status(201) : status(406)


### method: POST
### path name: /producer/comment-event/?username=username
### request BODY:
```JSON
{
    "producerId": "producerId",
    "eventId": "eventId",
    "comment": "comment",
    "authorType": "authorType"
}
```
#### response: successful ? status(201) : status(406)


### method: PUT
### path name: /producer/update
### request PARAMETERS:
```JSON
{
    "id" : "id",
    "firstName": "firstName",
    "lastName": "lastname",
    "email": "email",
    "username": "username",
    "password": "password",
    "phoneNumber": "phoneNumber",
    "address": "address",
    "city": "city",
    "postalCode": "postalCode"
}
```
#### successful ? status(404) : status(404) // not found


