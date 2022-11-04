https://www.restapitutorial.com/httpstatuscodes.html
# Endpoints

#### method: POST
#### path name: /farm/register
#### body params (inputs): 
```JSON
{
    "farmName": "farmName",
    "description": "description",
    "missionStatement": "missionStatement",
    "imageURL": "imageURL",
    "address": "address",
    "postalCode": "postalCode",
    "city": "city",
}
```
#### response: successful ? status(201) : status(406)


### method: GET
### path name: /farm/get-by-farmname/?username=username
### request PARAMETERS:
```JSON
{
    "farmName": "farmName"
}
```
### response BODY:
```JSON
{
    "farmName": "farmName",
    "description": "description",
    "missionStatement": "missionStatement",
    "imageURL": "imageURL",
    "address": "address",
    "postalCode": "postalCode",
    "city": "city",
}
```
#### else status(406)


### method : GET
### path name: /farm/get-by-producerName?userName=userName
### request parameter :
```JSON
{
    "username" : "username"
}
```
### response
```JSON
{
    "producer" :{
        "firstName": "firsname",
        "lastName": "lastname",
        "email": "email",
        "username": "username",
        "password": "password",
        "phoneNumber": "phoneNumber"
    },
    "farms" : [
        {
            "farmName": "farmName",
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

### method: PUT
### path name: /farm/update
### request PARAMETERS:
```JSON
{
    "farmName": "farmName",
    "description": "description",
    "missionStatement": "missionStatement",
    "imageURL": "imageURL",
    "address": "address",
    "postalCode": "postalCode",
    "city": "city",
}
```

#### successful ? status(406) : status(406)

