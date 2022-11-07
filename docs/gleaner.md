[http statues](https://www.restapitutorial.com/httpstatuscodes.html)
# Endpoints

#### Create
#### method: POST
#### path name: /volunteer/register
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


### method: GET
### path name: /volunteer/get-by-filter
### request PARAMETERS:
```JSON
{
    "ID": "id",
    "firstName": "firsname",
    "lastName": "lastname",
    "email": "email",
    "username": "username",
    "phoneNumber": "phoneNumber",
    "postalCode": "postalCode",
    "city": "city",
    "address": "address"
}
```
### response BODY:
```JSON
{
    "gleaners": [
        {
            "ID": "ID",
            "firstName": "firsname",
            "lastName": "lastname",
            "email": "email",
            "username": "username",
            "phoneNumber": "phoneNumber",
            "postalCode": "postalCode",
            "city": "city",
            "address": "address"
        }
    ]
}
```
#### else status(406)

### method: PUT
### path name: /volunteer/update
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
### path name: /volunteer/eventRegister
### request PARAMETERS:
```JSON
{
    "volunteerId" : "volunteerId",
    "eventID" : "eventID"
}
```
#### successful ? status(201) : status(406)


### method: GET
### path name: /volunteer/get-events/?username=username
### request PARAMETERS:
```JSON
{
    "username": "username"
}
```
### response BODY:
```JSON
{
    "events": [
        {
            "ID" : "id",
            "eventName": "eventName",
            "description": "description",
            "missionStatement": "missionStatement",
            "imageURL": "imageURL",
            "address": "address",
            "postalCode": "postalCode",
            "city": "city"
        }
    ]
}
```
#### else status(406)


### method: GET
### path name: /volunteer/get-comments/?username=username
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
### path name: /volunteer/comment-producer/?username=username
### request BODY:
```JSON
{
    "volunteerId": "volunteerId",
    "producerId": "producerId",
    "comment": "comment"
}
```
#### response: successful ? status(201) : status(406)


### method: POST
### path name: /volunteer/comment-organization/?username=username
### request BODY:
```JSON
{
    "volunteerId": "volunteerId",
    "organizationId": "organizationId",
    "comment": "comment"
}
```
#### response: successful ? status(201) : status(406)


### method: POST
### path name: /volunteer/comment-event/
### request BODY:
```JSON
{
    "volunteerId": "volunteerId",
    "eventId": "eventId",
    "comment": "comment"
}
```
#### response: successful ? status(201) : status(406)


### method: POST
### path name: /volunteer/comment-gleaner-group/?username=username
### request BODY:
```JSON
{
    "volunteerId": "volunteerId",
    "gleanerGroupId": "gleanerGroupId",
    "comment": "comment"
}
```
#### response: successful ? status(201) : status(406)


### method: POST
### path name: /volunteer/accept-volunteer/?username=username
### request BODY:
```JSON
{
    "gleanerAcceptingId": "gleanerAcceptingId",
    "gleanerRequestingId": "gleanerRequestingId",
    "eventId": "eventId"
}
```
#### response: successful ? status(201) : status(406)


### method: POST
### path name: /volunteer/request-team
### request BODY:
```JSON
{
    "volunteerId": "volunteerId",
    "volunteerGroupNumber": "volunteerGroupNumber",
    "eventId": "eventId"
}
```
#### response: successful ? status(201) : status(406)


### method: POST
### path name: /volunteer/create-team
### request BODY:
```JSON
{
    "volunteerId": "volunteerId",
    "eventId": "eventId"
}
```
#### response: successful ? status(201) : status(406)






