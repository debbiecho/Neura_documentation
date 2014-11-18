# Neura API Documentation

## Neura conventions
**How do dates work? Timezones? Flight/travel?**
**What is the expected latency on push events?** 
**Even if we don't have perfect answers, let's address upfront.**

###Privacy
HTTPS is required for all Neura APIs because private user information will be transmitted. Users trust your application with this info and Neura expects you respect this trust. We require that your application not retransmit insecurely, retain indefinitely or share with 3rd parties any data sent via the Neura API. 

## Authentication

You can query the Neura API to pull information about a user. All requests for user data must include an **authorization header** containing the user's access token:

**Example**

```
Authorization: Bearer asdf1234*****************
```

**We need to explain how to get the auth token**

## API root endpoint

The Neura API is currently in V1 so each call starts with `https://wapi.theneura.com/v1`. **What else do we need to say about the root endpoint?**

### Response to GET requests
Neura returns whether your GET request was a `success` or `error`. If the status is  `error` Neura returns: 

   - `status = errors`
   -  `errors` > `code` A snake_case string representing the error code. 
   -  `errors > message` A human-readable message describing the error.

###Neura **data objects** available for a PULL request
  - `daily_summary`: a summary of the user's activity
  - `activity`: Wellness Activity Profile -  
  - `hrv`: Heart Rate Variable (for Neurosky only) 
  - `sleep`: Sleep Profile - 

**what's the difference between `daily_summary` and `activity`? It seems like it's just that `activity` is for multiple days.**

---------


## GET /users/profile/daily_summary

Get's a user’s wellness information for a single day. Requires a **Bearer** authorization token.

### Resource URI

**`https://wapi.theneura.com/v1/users/profile/daily_summary`**

### Request query parameters

#### Required  request parameters
- `date`  The day for which you want information in YYYY-MM-DD format
**feedback from Eric @ Zenobase: what timezone? when does date start and end? how do we align different datasets?**

#### Optional request parameters
- `source` The single partner device for which you want information. If you don't specify `source` the Neura returns data aggregated from all the user's devices.  As of October 2014, `source` is only available for Neurosky; use the format: `source = neurosky`. 

### Request headers

#### Required request headers

- `authorization`: Bearer authorization token

#### Optional request headers

- `Cache-Control`: Specifies if the server should circumvent the server cache

## Response for `daily_summary` 

If status is `success` Neura returns:

  - `timestamp`: The time when Neura sent the response in epoch time. 
  - `data`:  The complex object of response data. If data is not available for any of the sub-objects then Neura returns 0.
  - `data` > `date` Neura echoes the `date` in your Request parameter in the in the format YYYY-MM-DD.   
**feedback from Eric @ Zenobase: what timezone? when does date start and end? how do we align different datasets?**
  - `data` > `minutesWalk`: The number of minutes that the user was continuously active either running or walking while outside their home. **this is confusing. let's clarify or hold off releasing it. questions: what if they have a treadmill/bike? rename from 'Walk' to 'Active'?**
  - `data` > `steps` The number of steps the user walked on `date`.  If the user has multiple step-counting devices then Neura the merges data to best reflect total steps walked without double counting.
  - `data` > `calories` The amount of calories the user burned on `date` in kilocalories (kcal).
   - `data` > `heartRate` The user's average heartRate on `date`.  As of October 2014, `heartRate` is only available for users with Neurosky. 
  - `data` > `weight`: The user's average body weight on `date` in kilograms (kg). **is this if the user measured their weight that day? how does this work exactly?**


### Example `daily_summary` request

```http
GET https://wapi.theneura.com/v1/users/profile/daily_summary?date=2014-09-30
Authorization: Bearer asdf1234**************************
Cache-Control: no-cache
```

### Example `daily_summary` response

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
 

---------


## GET /users/profile/call TEMPLATE

DESCRIPTION OF THE CALL

### Resource URI

**`https://wapi.theneura.com/v1/users/profile/call`**

### Request query parameters

#### Required request parameters
- `required_parameter`:  description

#### Optional request parameters
- `optional_parameter`: description

### Request headers

#### Required request headers

- `authorization`: Bearer authorization token

#### Optional request headers

- `Cache-Control`: Specifies if the server should circumvent the server cache

## Response for `call` 

parameters returned & descriptions


### Example `call` request

```http
GET https://wapi.theneura.com/v1/users/profile/call
Authorization: Bearer asdf1234**************************
Cache-Control: no-cache
```

### Example `call` response

#### Headers
```http
status: 200 OK
version: HTTP/1.1
Content-Type: application/json
```
#### Body
```json
{
   }
```
 

---------


## GET /users/profile/call TEMPLATE

DESCRIPTION OF THE CALL

### Resource URI

**`https://wapi.theneura.com/v1/users/profile/call`**

### Request query parameters

#### Required request parameters
- `required_parameter`:  description

#### Optional request parameters
- `optional_parameter`: description

### Request headers

#### Required request headers

- `authorization`: Bearer authorization token

#### Optional request headers

- `Cache-Control`: Specifies if the server should circumvent the server cache

## Response for `call` 

parameters returned & descriptions


### Example `call` request

```http
GET https://wapi.theneura.com/v1/users/profile/call
Authorization: Bearer asdf1234**************************
Cache-Control: no-cache
```

### Example `call` response

#### Headers
```http
status: 200 OK
version: HTTP/1.1
Content-Type: application/json
```
#### Body
```json
{
   }
```
 

---------


## GET /users/profile/call TEMPLATE

DESCRIPTION OF THE CALL

### Resource URI

**`https://wapi.theneura.com/v1/users/profile/call`**

### Request query parameters

#### Required request parameters
- `required_parameter`:  description

#### Optional request parameters
- `optional_parameter`: description

### Request headers

#### Required request headers

- `authorization`: Bearer authorization token

#### Optional request headers

- `Cache-Control`: Specifies if the server should circumvent the server cache

## Response for `call` 

parameters returned & descriptions


### Example `call` request

```http
GET https://wapi.theneura.com/v1/users/profile/call
Authorization: Bearer asdf1234**************************
Cache-Control: no-cache
```

### Example `call` response

#### Headers
```http
status: 200 OK
version: HTTP/1.1
Content-Type: application/json
```
#### Body
```json
{
   }
```
 




