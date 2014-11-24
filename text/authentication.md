
## Authentication

You can query the Neura API to pull information about a user. All requests for user data must include an **authorization header** containing the user's access token:

**Example**

```
Authorization: Bearer asdf1234*****************
```

**We need to explain how to get the auth token**

##Managing users
Neura manages users with a unique `userId` for each user that you can use to subscribe to PUSH events or submit requests for data objects.```httpGET https://wapi.theneura.com/v1/userUser’s access token must be sent in the header, for example``````httpGET /v1/user HTTP/1.1Host: wapi.theneura.comAuthorization: Bearer asdf1234*****************Cache-Control: no-cache```
##Response`userId`: Neura user identifier that is used in any Neura events and services`timezone`: User’s mobile device timezone##User permissionsThe user much grant you permission to access their data.
 