[http statues](https://www.restapitutorial.com/httpstatuscodes.html)
# Endpoints

#### method: POST
#### path name: /farm/register
#### body params (inputs): 
```JSON
{
    "producerID" : "producerID",
    "farm" : {
        "farmName": "farmName",
        "description": "description",
        "address": "address",
        "postalCode": "postalCode",
        "city": "city",
        "surfaceArea": "surfaceArea"
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
    "longitude": "longitude",
    "latitude": "latitude",
    "surfaceArea": "surfaceArea"
}
```
### response BODY:
```JSON
{
    "farms": [
        {
            "id" : "id",
            "farmName": "farmName",
            "description": "description",
            "missionStatement": "missionStatement",
            "imageURL": "imageURL",
            "address": "address",
            "postalCode": "postalCode",
            "city": "city",
            "longitude": "longitude",
            "latitude": "latitude",
            "surfaceArea": "surfaceArea"
        }
    ]
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
    "surfaceArea": "surfaceArea"
}
```
#### successful ? status(406) : status(406)

