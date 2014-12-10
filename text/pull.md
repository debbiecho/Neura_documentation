# Requesting data objects
Data objects contain [distilled user information](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/basics.md#neuras-nomenclature), such as wellness, activity, or sleep information, during a period of time, in JSON format that you access asynchronously.  

In this document we detail Neura's API endpoints for requesting data objects. (If you want to obtain instantaneous data, go to Neura [API endpoints for PUSH event subscriptions](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md)). The Neura API is read-only, requires HTTPS, and returns responses in JSON.  You must [be authenticated, provide a **Bearer** authorization token, and have user permission](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/authentication.md) to receive a response. 

##Neura data objects detailed below
  - `daily_summary`: Summary of the user's activity
  - `activity`: Wellness Activity Profile   
  - `sleep`: Sleep Profile 
  - `hrv`: Heart Rate Variable (for [NeuroSky](http://neurosky.com/) only) 

## API root endpoint
The Neura API is currently in V1 so each call starts with `https://wapi.theneura.com/v1`. 
**What else do we need to say about the root endpoint?** ask Berman

## Response to GET requests
Neura returns a `status` indicating whether your GET request was a `success` or `error`. If the `status` is `success` then Neura returns a valid response, as detailed below. If the `status` is `error` Neura returns: 

   - `status`: The status is `error`.
   - `timestamp`:  The time when Neura sent the response in [epoch time](http://en.wikipedia.org/wiki/Unix_time). 
   - `errors`: The complex object of error data.
   -  `errors` > `code`: A snake_case string representing the error code. 
   -  `errors` > `message`: A human-readable message describing the error.

###Example `error` response
```json
{
   "status": "error",
   "timestamp": 1416537411,
   "errors": [
      {
      "code": "invalid_format",
      "message": "date parameter format is invalid."
      }
    ]
}
```



---------


## GET /users/profile/daily_summary

`daily_summary` is a data object containing a user’s wellness information for a single day. `daily_summary` is calculated based on [a Neura day](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/basics.md#time-and-timezones), from the time when the user awoke on `date` until the time the user awoke on the following calendar day (`date` + 1 day).  If Neura is unable to identfy when the user awoke, then `daily_summary` is unavailable for that day.

### Resource URI

**`https://wapi.theneura.com/v1/users/profile/daily_summary`**

### Request query parameters

#### Required  request parameters
- `date`: The day for which you want information in YYYY-MM-DD format.

#### Optional request parameters
- `source`: The single partner device for which you want information. If you don't specify `source` then Neura returns data aggregated from all the user's devices.  As of October 2014, `source` is only available for NeuroSky; use the format: `source=neurosky`. 

### Request headers

#### Required request headers

- `authorization`: Bearer authorization token

#### Optional request headers

- `Cache-Control`: Specifies if the server should circumvent the server cache

## Response for `daily_summary` 

  - `status`: The status is `success`.
  - `timestamp`: The time when Neura sent the response in epoch time. 
  - `data`:  The complex object of wellness data. If data is not available for any of the sub-objects then Neura returns 0.
  - `data` > `date`: Neura echoes the `date` in your Request parameter in the format YYYY-MM-DD.   
  - `data` > `minutesWalk`: The number of minutes that the user was continuously active either running or walking while outside their home. 
  - `data` > `steps`: The number of steps the user walked on `date`.  If the user has multiple step-counting devices, then Neura the merges datasets to best reflect total steps walked without double-counting.
  - `data` > `calories`: The amount of calories the user burned on `date` in kilocalories (kcal).
   - `data` > `heartRate`: The user's average heartRate on `date`.  As of October 2014, `heartRate` is only available for users with NeuroSky. 
  - `data` > `weight`: The user's average body weight on `date` in kilograms (kg). 

  **is this if the user measured their weight that day? how does this work exactly?**


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


## GET /users/profile/activity 

`Activity` is a data object containing a user’s wellness information during a period of time beginning on `start_date` and ending on `end_date`, inclusive.  

### Resource URI

**`https://wapi.theneura.com/v1/users/profile/activity`**

### Request query parameters

#### Required request parameters
- `start_date`  The first day for which you want information in YYYY-MM-DD format.
- `end_date`  The last day for which you want information in YYYY-MM-DD format.

#### Optional request parameters
None.

### Request headers

#### Required request headers

- `authorization`: Bearer authorization token  **Is this the same as `accessToken`?**

#### Optional request headers

- `Cache-Control`: Specifies if the server should circumvent the server cache

## Response for `activity` 

  - `status`: The status is `success`.
  - `timestamp`: The time when Neura sent the response in epoch time. 
  - `data`:  The complex object of wellness data. If data are not available for any of the sub-objects then Neura returns 0.
  - `data` > `steps`: Neura returns the average daily steps during the period.
  - `data` > `calories`: Neura returns the average calories burned during the period.   
  - `data` > `activityPlaces`: The complex object of places and the activities that the user does at those locations. 
  - `data` > `activityPlaces` > `type`: The type of location either `work` or `workout`.   **In the Word doc it looks like there's a different response for `work` vs. `workout`. Is that true? If so, update text below**
  - `data` > `activityPlaces` > `type` > `steps`: The average steps at the location. 
  - `data` > `activityPlaces` > `type` > `calories`: The average calories burned at the location. 
  - `data` > `activityPlaces` > `type` > `length`: The average time spent at the location in minutes. 
  - **the word doc lists `numOfTimesInDay` but that doesn't show up in Postman. Do we still include it? how does it work exactly?**

### Example `activity` request

```http
GET https://wapi.theneura.com/v1/users/profile/activity
Authorization: Bearer asdf1234**************************
Cache-Control: no-cache
```

### Example `activity` response

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
"timestamp": 1416526587,
"data": {
  "calories": 1914.8622890088939,
  "steps": 11096.583672086723,
  "activityPlaces": [
    {
    "label": "workout",
    "steps": 2216.2600026130676,
    "calories": 148.26000261306763
    }
    ]
  }
}
```
 

---------


## GET /users/profile/sleep 

`sleep` is a data object containing a user’s sleep information either for a single `date` or during a period of time beginning on `start_date` and ending on `end_date`, inclusive.   

### Resource URI

**`https://wapi.theneura.com/v1/users/profile/sleep`**

### Request query parameters

#### Required request parameters
Use the single `date` for a data on a single day or the `start_date` and `end_date` parameters for a period.  If you include all 3 parameters Neura will return an `error`.  
- `date`: The day for which you want information in YYYY-MM-DD format.  
OR
- `start_date`: The first day for which you want information in YYYY-MM-DD format.
- `end_date`: The last day for which you want information in YYYY-MM-DD format.

#### Optional request parameters
None.

### Request headers

#### Required request headers

- `authorization`: Bearer authorization token

#### Optional request headers

- `Cache-Control`: Specifies if the server should circumvent the server cache

## Response for `sleep` 

  - `status`: The status is `success`.
  - `timestamp`: The time when Neura sent the response in epoch time. 
  - `data`:  The complex object of sleep data. If data are not available for any of the sub-objects then Neura returns 0.
  - `data` > `length`: The average duration of time sleeping in minutes during the period. 
  - `data` > `deepSleep`:  The average duration of deep sleep in minutes during the period. **how are we defining deep sleep? benchmark w/ fitbit, jawbone**
  - `data` > `lightSleep`: The average duration of light sleep in minutes during the period. **what does it mean when this is 0 as in the example below?**
  - `data` > `efficiency`: The average sleep efficiency during the period. **what does sleep efficiency mean to Neura? how are we measuring/defining it?**


### Example `sleep` request

```http
GET https://wapi.theneura.com/v1/users/profile/sleep
Authorization: Bearer asdf1234**************************
Cache-Control: no-cache
```

### Example `sleep` response

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
"timestamp": 1416526654,
"data": {
  "length": 5,
  "deepSleep": 62.3125,
  "lightSleep": 0,
  "efficiency": 47.28778345315291
  }
}
```
 

---------

## GET /users/profile/hrv 

`hrv` is a data object containing a user’s heart rate information either on a single `date` or during a period of time beginning on `start_date` and ending on `end_date`, inclusive. This service is only available for users that have integrated Neurosky with Neura and requires a **Bearer** authorization token.


### Resource URI

**`https://wapi.theneura.com/v1/users/profile/hrv`**

### Request query parameters

#### Required request parameters
Use the single `date` for a data on a single day or the `start_date` and `end_date` parameters for a period.  If you include all 3 parameters Neura will return an `error`. **have neura return `error`. currently we return `success` and an empty data object**
- `date`: The day for which you want information in YYYY-MM-DD format.  
OR
- `start_date`: The first day for which you want information in YYYY-MM-DD format.
- `end_date`: The last day for which you want information in YYYY-MM-DD format.

#### Optional request parameters
None.

### Request headers

#### Required request headers

- `authorization`: Bearer authorization token

#### Optional request headers

- `Cache-Control`: Specifies if the server should circumvent the server cache

## Response for `hrv` 

  - `status`: The status is `success`.
  - `timestamp`: The time when Neura sent the response in epoch time. 
  - `items`:  The complex object of heart rate data. If data are not available for any of the sub-objects then Neura returns 0. **why is this `items` and all other data objects use `data`?**
  - `items` > `value`: The heart rate variable measure. **clarify this**
  - `items` > `timestamp`: The timestamp when data were queried 

### Example `hrv` request

```http
GET https://wapi.theneura.com/v1/users/profile/call
Authorization: Bearer asdf1234**************************
Cache-Control: no-cache
```

### Example `hrv` response

#### Headers
```http
status: 200 OK
version: HTTP/1.1
Content-Type: application/json
```
#### Body
```json
{
**mikimer to get example from berman -- i couldn't get this from Postman**
   }
```
 




-----







