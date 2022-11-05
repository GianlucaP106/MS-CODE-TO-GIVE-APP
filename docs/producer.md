https://www.restapitutorial.com/httpstatuscodes.html
# Endpoints

#### method: POST
#### path name: /producer/register
#### body params (inputs): 
```JSON
{
    "firstName": "firsname",
    "lastName": "lastname",
    "email": "email",
    "username": "username",
    "password": "password",
    "phoneNumber": "phoneNumber"
}
```
#### response: successful ? status(201) : status(406)


### method: GET
### path name: /producer/get-by-username/?username=username
### request PARAMETERS:
```JSON
{
    "username": "username"
}
```
### response BODY:
```JSON
{
    "firstName": "firsname",
    "lastName": "lastname",
    "email": "email",
    "username": "username",
    "password": "password",
    "phoneNumber": "phoneNumber"
}
```
#### else status(406)


### method: GET
### path name: /producer/get-comments/?username=username
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
### path name: /producer/comment-gleaner/?username=username
### request BODY:
```JSON
{
    "producerId": "producerId",
    "gleanerId": "gleanerId",
    "comment": "comment",
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
    "comment": "comment",
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
    "comment": "comment",
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
}
```
#### response: successful ? status(201) : status(406)