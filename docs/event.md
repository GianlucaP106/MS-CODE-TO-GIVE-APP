[http statues](https://www.restapitutorial.com/httpstatuscodes.html)
# Endpoints

### method: PUT
### path name: /event/update
### request PARAMETERS:
```JSON
{
    "id" : "id",
    "eventName": "eventName",
    "neededGleaners": "neededGleaners",
    "description": "description",
    "missionStatement": "missionStatement",
    "imageURL": "imageURL",
    "address": "address",
    "postalCode": "postalCode",
    "city": "city",
    "isUrgent": "isUrgent"
}
```
#### successful ? status(404) : status(404) // not found


### method : GET 
### path name : /event/get-with-filters
### request body
```JSON
{
    "id" : "id",
    "eventName": "eventName",
    "neededGleaners": "neededGleaners",
    "description": "description",
    "missionStatement": "missionStatement",
    "imageURL": "imageURL",
    "address": "address",
    "postalCode": "postalCode",
    "city": "city",
    "isUrgent": "isUrgent",
    "radius" : "radius"
}
```
### return 
```JSON
{
    "status" : "200",
    "id" : "id",
    "eventName": "eventName",
    "neededGleaners": "neededGleaners",
    "description": "description",
    "missionStatement": "missionStatement",
    "imageURL": "imageURL",
    "address": "address",
    "postalCode": "postalCode",
    "city": "city",
    "isUrgent": "isUrgent"
}
```
### else status 404