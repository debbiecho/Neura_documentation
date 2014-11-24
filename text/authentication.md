
## Authentication

You can query the Neura API to pull information about a user. All requests for user data must include an **authorization header** containing the user's access token:

**Example**

```
Authorization: Bearer asdf1234*****************
```

**We need to explain how to get the auth token**

##Managing users
Neura manages users with a unique `userId` for each user that you can use to subscribe to PUSH events or submit requests for data objects.

 