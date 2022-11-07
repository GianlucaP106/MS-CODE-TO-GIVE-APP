[http statues](https://www.restapitutorial.com/httpstatuscodes.html)

# Endpoints

### method : Post

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

### method: POST

### path name: /event/create-event

### request BODY:

```JSON
{
    "farmId": "farmId",
    "eventName": "eventName",
    "neededGleaners": "neededGleaners",
    "maxGleaners": "maxGleaners",
    "description": "description",
    "imageURL": "imageURL",
    "address": "address",
    "postalCode": "postalCode",
    "city": "city",
    "isUrgent": "isUrgent",
    "date": "date"
}
```

#### response: successful ? status(201) : status(406)

### method: PUT

### path name: /producer/update-event

### request PARAMETERS:

```JSON
{
    "id" : "id",
    "eventName": "eventName",
    "neededGleaners": "neededGleaners",
    "description": "description",
    "imageURL": "imageURL",
    "address": "address",
    "postalCode": "postalCode",
    "city": "city",
    "isUrgent": "isUrgent"
}
```

#### successful ? status(404) : status(404) // not found
