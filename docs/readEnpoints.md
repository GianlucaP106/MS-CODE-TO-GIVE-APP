https://www.restapitutorial.com/httpstatuscodes.html
# Endpoints

### CRUD

#### Read


```JSON
method: GET
path name: /gleaner/get-by-username/?username=username
request PARAMETERS:
{
    username: "username"
}
response BODY:
{
    firstName: "firsname",
    lastName: "lastname",
    email: "email",
    username: "username",
    password: "password,
    phoneNumber: "phoneNumber"
    postalCode: "postalCode",
    city: "city",
    address: "address"
}
else status(406)
```


```JSON
method: GET
path name: /producer/get-by-username/?username=username
request PARAMETERS:
{
    username: "username"
}
response BODY:
{
    firstName: "firsname",
    lastName: "lastname",
    email: "email",
    username: "username",
    password: "password,
    phoneNumber: "phoneNumber"
}
else status(406)
```


```JSON
method: GET
path name: /gleaner-group/get-by-username/?username=username
request PARAMETERS:
{
    username: "username"
}
response BODY:
{
    username: "username",
    password: "password,
    groupName: "groupName",
    region: "region",
    description: "description",
    missionStatement: "missionStatement",
    imageURL: "imageURL",
}
else status(406)
```


```JSON
method: GET
path name: /organization/get-by-username/?username=username
request PARAMETERS:
{
    username: "username"
}
response BODY:
{
    username: "username",
    password: "password,
    orgName: "orgName",
    description: "description",
    missionStatement: "missionStatement",
    imageURL: "imageURL",
    address: "address",
    city: "city",
    postalCode: "postalCode",
}
else status(406)
```

```JSON
method: GET
path name: /farm/get-by-username/?username=username
request PARAMETERS:
{
    username: "username"
}
response BODY:
{
    farmName: "farmName",
    description: "description",
    missionStatement: "missionStatement",
    imageURL: "imageURL",
    address: "address",
    postalCode: "postalCode",
    city: "city",
}
else status(406)
```

```JSON
method: GET
path name: /event/get-by-username/?username=username
request PARAMETERS:
{
    username: "username"
}
response BODY:
{
    eventName: "eventName",
    neededGleaners: "neededGleaners",
    description: "description",
    missionStatement: "missionStatement",
    imageURL: "imageURL",
    address: "address",
    postalCode: "postalCode",
    city: "city",
}
else status(406)
```



