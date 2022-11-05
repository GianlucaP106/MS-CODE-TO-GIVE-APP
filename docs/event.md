[http statues](https://www.restapitutorial.com/httpstatuscodes.html)
# Endpoints

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
    "events": [
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
    ]
}
```
### else status 404


