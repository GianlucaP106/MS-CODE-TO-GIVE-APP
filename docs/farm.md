[http statues](https://www.restapitutorial.com/httpstatuscodes.html)
# Endpoints

#### method: POST
#### path name: /farm/register
#### body params (inputs): 
```JSON
{
    "producer" : "producerID",
    "farm" : {
        "id" : "id",
        "farmName": "farmName",
        "description": "description",
        "missionStatement": "missionStatement",
        "imageURL": "imageURL",
        "address": "address",
        "postalCode": "postalCode",
        "city": "city",
    }
}
```
#### response: successful ? status(201) : status(406)


### method: GET
### path name: /farm/get-by-filter
### request PARAMETERS:
```JSON
{
    "id" : "id",
    "farmName": "farmName",
    "description": "description",
    "missionStatement": "missionStatement",
    "imageURL": "imageURL",
    "address": "address",
    "postalCode": "postalCode",
    "city": "city",
    "radius" : "radius",
}
```
### response BODY:
```JSON
{
    "id" : "id",
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


### method: PUT
### path name: /farm/update
### request PARAMETERS:
```JSON
{
    "farmID" : "id",
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

