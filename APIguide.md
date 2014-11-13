# Neura API Documentation

## Authentication

You can query the Neura API to pull information about a user. All requests for user data must include an **authorization header** with the value containing the user's access token:

**Example**

```
Authorization: Bearer asdf1234*****************
```

## API Root Endpoint

The current version of the Neura API is V1 and each call to the V1 API will start with:

 `https://wapi.theneura.com/v1`

## GET /users/profile/daily_summary

Get's a user’s wellness information for a single day. Requires a **Bearer** authorization token.

### Resource URI

**`https://wapi.theneura.com/v1/users/profile/daily_summary`**

### Query Parameters

#### Required
- `date`: Date of the summary to retrieve in YYYY-MM-DD format

#### Optional
- `source`: The source device to retrieve data for. For example, if Neurosky device data is requested then this parameter should be set to "Neurosky".

### Headers

#### Required

- `authorization`: Bearer authorization token

#### Optional

- `Cache-Control`: Specifies if the server should circumvent the server cache

### Example Request

```http
GET https://wapi.theneura.com/v1/users/profile/daily_summary?date=2014-09-30
Authorization: Bearer asdf1234**************************
Cache-Control: no-cache
```

### Example Response

#### Headers
```http
status: 200 OK
version: HTTP/1.1
Content-Type: application/json
```
#### Body
```json
{
   "status": "success",
   "timestamp": 1415768620,
   "data": {
	   "date": 20141108,
	   "createdAt": "2014-11-10T12:34:01Z",
	   "minutesWalk": 169,
	   "calories": 2471.0398383140564,
	   "steps": 19665,
	   "heartRate": 0,
	   "weight": 0,
	   "workDay": 0,
	   "sleepData": {
	   "length": 290,
	   "deepSleep": 0,
	   "lightSleep": 0
   },
   "activityPlaces": [ ]
   }
}
```
 

