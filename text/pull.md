# Requesting insights
Insights contain [distilled user information](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/basics.md#neuras-nomenclature), such as wellness, activity, or sleep information, during a period of time, in JSON format that you access asynchronously.  

In this document we detail Neura's API endpoints for requesting insights. (If you want to obtain instantaneous data, go to Neura [event subscriptions](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md)). The Neura API is read-only, requires HTTPS, and returns responses in JSON.  You must [be authenticated,](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/authentication.md) provide a **Bearer** access token, and have user permission to receive a response. 

##Neura insights detailed below
  - [`daily_summary`](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/pull.md#get-usersprofiledaily_summary) is a summary of the user's activity for a day
  - [`sleep`](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/pull.md#get-usersprofilesleep) is the user's sleep profile for a day 
  - [`hrv`](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/pull.md#get-usersprofilehrv) is the user's heart rate variable data

## API root endpoint
The root endpoint is `https://wapi.theneura.com/v1`. The Neura API is currently in V1 which is why the root endpoint ends with v1.

## Response to GET requests
Neura returns a `status` indicating whether your GET request was a `success` or `error`. If the `status` is `success` then Neura returns a valid response, as detailed below. If the `status` is `error` Neura returns: 

   - `status`: The status is `error`.
   - `timestamp`:  The time when Neura sent the response in [epoch time](http://en.wikipedia.org/wiki/Unix_time). 
   - `errors`: The complex object of error data.
   - `errors` > `code`: A snake_case string representing the error code. 
   - `errors` > `message`: A human-readable message describing the error.

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

`daily_summary` is an insight containing a user’s wellness information for a single day. `daily_summary` is calculated based on [a Neura day](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/basics.md#days-time-and-time-zones), from the time when the user awoke on `date` until the time the user awoke on the following calendar day (`date` + 1 day).  If Neura is unable to identfy when the user awoke, then `daily_summary` is unavailable for that day.

### Resource URI

**`https://wapi.theneura.com/v1/users/profile/daily_summary`**

### Request query parameters

#### Required request parameters
- `date`: The day for which you want information in YYYY-MM-DD format.

#### Optional request parameters
- `source`: The single partner device for which you want information. If you don't specify `source` then Neura returns data aggregated from all the user's devices.  As of October 2014, `source` is only available for NeuroSky; use the format: `source=neurosky`. 

### Request headers

#### Required request headers

- `authorization`: `Bearer <access_token>`

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
  - `data` > `weight`: The user's average body weight on `date` in kilograms (kg). (If the user weighed himself once, it will return this value, if twice, it will return the average of the two values, and if he didn't weigh himself, no data will be returned.)


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
	"timestamp": 1422053086,
	"data": {
		"date": 20141103,
		"createdAt": "2014-11-05T13:56:22Z",
		"minutesWalk": 27,
		"calories": 196.13300064956726,
		"steps": 4065,
		"heartRate": 0,
		"weight": 0,
		"workDay": 0,
		"sleepData": {
		"length": 4,
		"deepSleep": 250,
		"lightSleep": 0
		},
	"activityPlaces": [
			{
				"name": "Home",
				"steps": 1628,
				"calories": 87.21400034428402,
				"heartRate": 0
			},
			{
				"name": "Neura HQ",
				"steps": 214,
				"calories": 10.759000122551,
				"heartRate": 0
			},
			{
				"name": "Sand Hill Road. Menlo Park",
				"steps": 66,
				"calories": 2.89899992943,
				"heartRate": 0
			},
			{
				"name": "Whole Foods Market",
				"steps": 225,
				"calories": 9.8490001335833,
				"heartRate": 0
			}
		]
	}
}
```
---------

## GET /users/profile/sleep 

`sleep` is an insight containing a user’s sleep information either for a single `date` or during a period of time beginning on `start_date` and ending on `end_date`, inclusive.   

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

- `authorization`: `Bearer <access_token>`

#### Optional request headers

- `Cache-Control`: Specifies if the server should circumvent the server cache

## Response for `sleep` 

  - `status`: The status is `success`.
  - `timestamp`: The time when Neura sent the response in epoch time. 
  - `data`:  The complex object of sleep data. If data are not available for any of the sub-objects then Neura returns 0.
  - `data` > `length`: The average duration of time sleeping in minutes during the period. 
  - `data` > `deepSleep`:  The average duration of deep sleep in minutes during the period. 
  - `data` > `lightSleep`: The average duration of light sleep in minutes during the period. 
  - `data` > `efficiency`: The percentage of `deepSleep` out of the `length` of sleep.


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

`hrv` is an insight containing a user’s heart rate information either on a single `date` or during a period of time beginning on `start_date` and ending on `end_date`, inclusive. This service is only available for users that have integrated [Neurosky](http://neurosky.com/) with Neura and requires a **Bearer** authorization token.


### Resource URI

**`https://wapi.theneura.com/v1/users/profile/hrv`**

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

## Response for `hrv` 

  - `status`: The status is `success`.
  - `timestamp`: The time when Neura sent the response in epoch time. 
  - `items`:  The complex object of heart rate data. If data is not available for any of the sub-objects then Neura returns 0.   
  - `items` > `value`: The heart rate variable measure.   
  - `items` > `timestamp`: The timestamp when data was  

### Example `hrv` request

```http
GET https://wapi.theneura.com/v1/users/profile/call
Authorization: Bearer asdf1234**************************
Cache-Control: no-cache
```

## [Return to the main page](https://github.com/NeuraLabs/Neura_documentation#build-with-neura)


