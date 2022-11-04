https://www.restapitutorial.com/httpstatuscodes.html
# Endpoints


### method: GET
### path name: /event/get-by-username/?username=username
### request PARAMETERS:
```JSON
{
    "eventName": "eventName"
}
```
### response BODY:
```JSON
{
    "eventName": "eventName",
    "neededGleaners": "neededGleaners",
    "description": "description",
    "missionStatement": "missionStatement",
    "imageURL": "imageURL",
    "address": "address",
    "postalCode": "postalCode",
    "city": "city",
}
```
#### else status(404) // not found

### method: PUT
### path name: /event/update
### request PARAMETERS:
```JSON
{
    "eventName": "eventName",
    "neededGleaners": "neededGleaners",
    "description": "description",
    "missionStatement": "missionStatement",
    "imageURL": "imageURL",
    "address": "address",
    "postalCode": "postalCode",
    "city": "city",
}
```

#### successful ? status(404) : status(404) // not found