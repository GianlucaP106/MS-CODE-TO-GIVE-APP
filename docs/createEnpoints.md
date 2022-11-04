https://www.restapitutorial.com/httpstatuscodes.html
# Endpoints

### CRUD

#### Create
```JSON
method: POST
path name: /gleaner/register
body params (inputs): 
{
    firstName: "firsname",
    lastName: "lastname",
    email: "email",
    username: "username",
    password: "password,
    phoneNumber: "phoneNumber"
    postalCode: "postalCode"
    city: "city",
    address: "address"
}
response: successful ? status(201) : status(406)
```

```JSON
method: POST
path name: /producer/register
body params (inputs): 
{
    firstName: "firsname",
    lastName: "lastname",
    email: "email",
    username: "username",
    password: "password,
    phoneNumber: "phoneNumber"
}
response: successful ? status(201) : status(406)
```

```JSON
method: POST
path name: /gleaner-group/register
body params (inputs): 
{
    username: "username",
    password: "password,
    groupName: "groupName",
    region: "region",
    description: "description",
    missionStatement: "missionStatement",
    imageURL: "imageURL",
}
response: successful ? status(201) : status(406)
```

```JSON
method: POST
path name: /organization/register
body params (inputs): 
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
response: successful ? status(201) : status(406)
```

```JSON
method: POST
path name: /farm/register
body params (inputs): 
{
    farmName: "farmName",
    description: "description",
    missionStatement: "missionStatement",
    imageURL: "imageURL",
    address: "address",
    postalCode: "postalCode",
    city: "city",
}
response: successful ? status(201) : status(406)
```


```JSON
method: POST
path name: /event/register
body params (inputs): 
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
response: successful ? status(201) : status(406)
```





