# fuckyeahmarkdown.com

CopyHTML  with Readability 

[Source](https://www.automatic.com/developer/documentation/ "Permalink to Automatic API Documentation | Automatic Developer")

# Automatic API Documentation | Automatic Developer

## Contents

## Status

The API is in beta. Whenever possible, we'll give developers 45 days notice of any breaking changes to the API.

## Privacy

HTTPS is required for all Automatic Event Webhook APIs because private user information will be transmitted. Users trust your application with this info and Automatic expects you not to violate this trust. We require that your application not retransmit insecurely, retain indefinitely or share with 3rd parties and data sent via the Automatic Webhook API. Need to host an app with https, but don't want to have the hassle of obtaining your own SSL certificate? [Heroku provides free piggyback SSL][1] certificates on *.herokuapp.com sites by default.

## Authentication

OAuth2 is required to authenticate.

### 1\. Redirect users to request Automatic access


    GET https://www.automatic.com/oauth/authorize


#### Parameters



| Name            |                       | Description                                                                                     |
| --------------- | --------------------- | ----------------------------------------------------------------------------------------------- |
| `client_id`     | _Required_ **string** | The client ID for your application                                                              |
| `scope`         | _Required_ **string** | Space separated list of scopes that your application needs                                      |
| `response_type` | _Required_ **string** | Value should be "code"                                                                          |
| `state`         | _Optional_ **string** | An unguessable random string. It is used to protect against cross-site request forgery attacks. |



As an example, the authorize URL formatted for the [Tripviewer app][2]:


    https://www.automatic.com/oauth/authorize/?client_id=Yqsysr3zkbAvDTkMRdzB&response_type=code&scope=scope:trip%20scope:location%20scope:vehicle:profile%20scope:vehile:events


For convenience, a formatted authorize URL including your `client_id` is provided for each application in the [Developer Dashboard][3]

### 2\. Automatic redirects back to your site

If the user accepts your request, Automatic redirects back to your site with a temporary code in a `code` GET parameter as well as the state you provided in the previous step in a state parameter. If the states don't match, the request has been created by a third party and the process should be aborted.

Exchange this for an access token:


    POST https://www.automatic.com/oauth/access_token


#### Parameters



| Name            |                           | Description                                    |
| --------------- | ------------------------- | ---------------------------------------------- |
| `client_id`     | _Required_ **string**     | The client ID for your application             |
| `client_secret` | _Required_ **string**     | The client secret for your application         |
| `code`          | _Required_ **string**     | The code you received as a response to Step 1. |
| `grant_type`    | _Required_ **grant_type** | Value should be "authorization_code"           |



#### Response

The response will be in JSON format:


        {
          "access_token": "PrBfQ1sp534wDaaU7tbBTVObqj83QUekVemnEsXs",
          "expires_in": 31535999,
          "scope": "scope:vehicle:events",
          "refresh_token": "3ddcc6ec0cb968a10fb235ecf90f534244d2b759",
          "token_type": "Bearer"
        }


#### Example

Enter `client_secret`, `client_id` and `code` (from step 1 above) for this curl statement to work.


    curl --data "client_id=YOUR_CLIENT_ID&client_secret=YOUR_CLIENT_SECRET&code=YOUR_CODE_FROM_STEP_1&grant_type=authorization_code" https://www.automatic.com/oauth/access_token


### 3\. Use the access token to access the API

The access token allows you to make requests to the API on a behalf of a user.


    $ curl -H "Authorization: token YOUR-OAUTH-TOKEN" "https://api.automatic.com/v1/trips"


### 4\. Refresh Tokens

Once the access token eventually expires, you can exchange the refresh token for a new access token


    POST https://www.automatic.com/oauth/access_token


#### Parameters



| Name            |                       | Description                                                    |
| --------------- | --------------------- | -------------------------------------------------------------- |
| `client_id`     | _Required_ **string** | The client ID for your application                             |
| `client_secret` | _Required_ **string** | The client secret for your application                         |
| `refresh_token` | _Required_ **string** | The refresh token obtained with the (now expired) access token |
| `grant_type`    | _Required_ **string** | Value MUST be set to "refresh_token"                           |



#### Response

The response is the same format as the `/oauth/access_token` endpoint.


        {
          "access_token": "PrBfQ1sp534wDaaU7tbBTVObqj83QUekVemnEsXs",
          "expires_in": 31535999,
          "scope": "scope:vehicle:events",
          "refresh_token": "3ddcc6ec0cb968a10fb235ecf90f534244d2b759",
          "token_type": "Bearer"
        }


## Scopes

Scopes let you specify exactly what type of access your application needs. Scopes limit access for OAuth tokens. They do not grant any additional permission beyond that which the user already has.

Requested scopes will be displayed to the user on the authorize form.



| Scope Name               | Description                                                                          |
| ------------------------ | ------------------------------------------------------------------------------------ |
| `scope:public`           | Access to public information about user.                                             |
| `scope:user:profile`     | Access to user's profile (i.e. `first_name`, `last_name`).                           |
| `scope:user:follow`      | Follow other users.                                                                  |
| `scope:location`         | Access to location. Applies to all events.                                           |
| `scope:current_location` | Access to user's current location.                                                   |
| `scope:vehicle:profile`  | Access to vehicle information (i.e. `year`, `make`, `model`). Applies to all events. |
| `scope:vehicle:events`   | Access to real-time vehicle events (i.e. `hard_brake`, `hard_accel`).                |
| `scope:vehicle:vin`      | Access to vehicle VIN.                                                               |
| `scope:trip`             | Access to user's trips.                                                              |
| `scope:behavior`         | Access to user's driving profile.                                                    |



The Automatic Event Webhook API lets you register a URL to which we will send an HTTP POST request anytime an event happens for a user and scope for which your application is authorized. Your server will receive a POST request where the body is a JSON object. Each JSON object will contain a `type` parameter which will match one of the event types listed below.

## Responding to a Webhook

Your application should respond with a `200` HTTP status code to acknowledge successful receipt of a webhook. Any non 200-range response will indicate that you did not receive the webhook. As of now, requests will not be retried.

## Common Uses for Automatic Webhooks

* Notifying someone based on an event, such as "ignition" on.

* Getting data about MIL (check engine) light status.

* Trigger some action based on a user's location.

## Testing Webhooks

You can test the webhooks by logging into the [Developer Console][4] and using the "Test Webhook" section under "Testing Tools".

## Types of Webhooks

## Sample Event Objects

Note that in order to get `vehicle` and `location` objects, an app must request the appropriate scope.

### `trip:finished`


        {
          "id": "E_63db5c25ffd955ba",
          "user": {
            "id": "U_ffd955ba63db5c25"
          },
          "type": "trip:finished",
          "created_at": 1383448450201,
          "time_zone": "America/Los_Angeles",
          "location": {
            "lat": 37.757076,
            "lon": -122.448120,
            "accuracy_m": 10
          },
          "vehicle": {
            // Vehicle Object
          },
          "trip" {
            // Trip Object
          }
        }


Requires `scope:trip` scope.

See [trip object][5]

See [vehicle object][6]

### `ignition:on`


        {
          "id": "E_63db5c25ffd955ba",
          "user": {
            "id": "U_ffd955ba63db5c25"
          },
          "type": "ignition:on",
          "created_at": 1383448450201,
          "time_zone": "America/Los_Angeles",
          "location": {
            "lat": 37.757076,
            "lon": -122.448120,
            "accuracy_m": 10
          },
          "vehicle": {
            // Vehicle Object
          }
        }


Requires `scope:vehicle:events` scope.

See [vehicle object][6]

### `ignition:off`


        {
          "id": "E_63db5c25ffd955ba",
          "user": {
            "id": "U_ffd955ba63db5c25"
          },
          "type": "ignition:off",
          "created_at": 1383448450201,
          "time_zone": "America/Los_Angeles",
          "location": {
            "lat": 37.757076,
            "lon": -122.448120,
            "accuracy_m": 10
          },
          "vehicle": {
            // Vehicle Object
          }
        }


Requires `scope:vehicle:events` scope.

See [vehicle object][6]

### `notification:speeding`


        {
          "id": "E_63db5c25ffd955ba",
          "user": {
            "id": "U_ffd955ba63db5c25"
          },
          "type": "notification:speeding",
          "created_at": 1383448450201,
          "time_zone": "America/Los_Angeles",
          "location": {
            "lat": 37.757076,
            "lon": -122.448120,
            "accuracy_m": 10
          },
          "vehicle": {
            // Vehicle Object
          },
          "speed_mph": 70
        }


Requires `scope:vehicle:events` scope.

See [vehicle object][6]

### `notification:hard_brake`


        {
          "id": "E_63db5c25ffd955ba",
          "user": {
            "id": "U_ffd955ba63db5c25"
          },
          "type": "notification:hard_brake",
          "created_at": 1383448450201,
          "time_zone": "America/Los_Angeles",
          "location": {
            "lat": 37.757076,
            "lon": -122.448120,
            "accuracy_m": 10
          },
          "vehicle": {
            // Vehicle Object
          },
          "g_force": 0.3
        }


Requires `scope:vehicle:events` scope.

### `notification:hard_accel`


        {
          "id": "E_63db5c25ffd955ba",
          "user": {
            "id": "U_ffd955ba63db5c25"
          },
          "type": "notification:hard_accel",
          "created_at": 1383448450201,
          "time_zone": "America/Los_Angeles",
          "location": {
            "lat": 37.757076,
            "lon": -122.448120,
            "accuracy_m": 10
          },
          "vehicle": {
            // Vehicle Object
          },
          "g_force": 0.3
        }


Requires `scope:vehicle:events` scope.

See [vehicle object][6]

### `mil:on`


        {
          "id": "E_63db5c25ffd955ba",
          "user": {
            "id": "U_ffd955ba63db5c25"
          },
          "type": "mil:on",
          "created_at": 1383448450201,
          "time_zone": "America/Los_Angeles",
          "location": {
            "lat": 37.757076,
            "lon": -122.448120,
            "accuracy_m": 10
          },
          "vehicle": {
            // Vehicle Object
          },
          "dtcs": [
            {
              "code": "P0442",
              "description": "Small fuel vapor leak in EVAP system",
              "start": 1383448450301
            }
          ]
        }


Requires `scope:vehicle:events` scope.

Note that `dtcs` is an array and can include more than one trouble code, if more than one contributed to the MIL event.

Also, more than one `mil:on` events may be fired before an `mil:off` event if additional DTC codes come on after the initial `mil:on` event.

See [vehicle object][6]

### `mil:off`


        {
          "id": "E_63db5c25ffd955ba",
          "user": {
            "id": "U_ffd955ba63db5c25"
          },
          "type": "mil:off",
          "created_at": 1383448450201,
          "time_zone": "America/Los_Angeles",
          "location": {
            "lat": 37.757076,
            "lon": -122.448120,
            "accuracy_m": 10
          },
          "vehicle": {
            // Vehicle Object
          },
          "dtcs": [
            {
              "code": "P0442",
              "description": "Small fuel vapor leak in EVAP system",
              "start": 1383448450301
            }
          ],
          "user_cleared": true
        }


Requires `scope:vehicle:events` scope.

Note that `dtcs` is an array and can include more than one trouble code, if more than one contributed to the MIL event.

See [vehicle object][6]

The Automatic REST API allows your application to request data. The base URL end point at this time is - `https://api.automatic.com/v1/`

## Authentication

A valid OAuth token must be present in the `Authorization` header of each request.


    $ curl -H "Authorization: token YOUR-OAUTH-TOKEN" "PATH-TO-RESOURCE"


For Example:


    $ curl -H "Authorization: token PrBfQ1sp534wDaaU7tbBTVObqj83QUekVemnEsXs" "https://api.automatic.com/v1/trips"


## Trips

### List trips for authenticated user


    GET /trips


#### Scopes

Requires the `scope:trip` scope.

#### Parameters



| Name       |                        | Description                                                                                                         |
| ---------- | ---------------------- | ------------------------------------------------------------------------------------------------------------------- |
| `start`    | _Optional_ **integer** | Unix timestamp in milliseconds to query for trips newer than. Uses trip `start_time`. For example: `1401666528657`. |
| `end`      | _Optional_ **integer** | Unix timestamp in milliseconds to query for trips older than. Uses trip `start_time`. For example: `1405907957600`. |
| `page`     | _Optional_ **integer** | Page number to retrieve. Default is page 1.                                                                         |
| `per_page` | _Optional_ **integer** | Number of trips per page to return. Default is 100.                                                                 |



#### Response

The response will be an array of [trip objects][5]. If a `start` or `end` parameter are included with the request, these will be honored. Otherwise, the most recent trip will be returned first.


        [
          {
            "uri": "https://api.automatic.com/v1/trips/524da549e4b08d1af17f6dca",
            "id": "T_8e7b567626c26695",
            "user": {
              "id": "U_ffd955ba63db5c25"
            },
            "vehicle": {
              // Vehicle Object
            },
            "start_location": {
              "name": "Ashbury St, SF, CA",
              "display_name": "Home",
              "lat": 37.7692903,
              "lon": -122.4465469,
              "accuracy_m": 5
            },
            "start_time": 1383448450201,
            "start_time_zone": "America/Los_Angeles",
            "end_location": {
              "name": "5th St, SF, CA",
              "display_name": "Work",
              "lat": 37.78270046281092,
              "lon": -122.4064556183999,
              "accuracy_m": 97.88124084472656
            },
            "end_time": 1383449950201,
            "end_time_zone": "America/Los_Angeles",
            "path": "uioeFxycjVxDMvAGBjATlJXrLaIZHvCFhCHpCaI^i@@",
            "distance_m": 6573.416666666661,
            "hard_accels": 0,
            "hard_brakes": 1,
            "duration_over_80_s": 0,
            "duration_over_75_s": 2,
            "duration_over_70_s": 3,
            "fuel_cost_usd": 1.0428111627932486,
            "fuel_volume_gal": 0.2465857561582522,
            "average_mpg": 16.56434586845349,
            "drive_events": [
              {
                "type": "speeding",
                "start_distance_m": 4193.749999999999,
                "end_distance_m": 4383.416666666666,
                "start_time": 1383448690201,
                "end_time": 1383448692301,
                "velocity_mph": 70
              },
              {
                "type": "hard_accel",
                "lat": 38.4184716230387,
                "lon": -122.71354039973721,
                "ts": 1383449948101,
                "g": 0.351
              },
              {
                "type": "hard_brake",
                "lat": 37.82475806798236,
                "lon": -122.31403562609702,
                "ts": 1383449946901,
                "g": 0.611
              }
            ]
          }
        ]


#### Pagination

100 results will be returned by default. An optional `?page` parameter can be added to specify which page to return. To control the size of the page, the `?per_page` parameter can be added.

Note that page numbering is 1-based and that omitting the `?page` parameter will return the first page.

##### Example


    GET /trips?page=2&per_page=30


##### Link Header

Pagination info is included in a [Link Header][7]. The link header includes links, where relevant to the `next`, `previous`, `first` and `last` pages.


    Link: ; rel="next",
        ; rel="last"


The type of link is shown as the `rel` attribute.

### Get a single trip


    GET /trips/:id


#### Scopes

Requires the `scope:trip` scope.

#### Parameters



| Name |                       | Description                             |
| ---- | --------------------- | --------------------------------------- |
| `id` | _Required_ **string** | ID of a the trip you'd like to retrieve |



#### Response

The response will be a single [trip object][5].

## User

### Get info about the authenticated user


    GET /user


#### Scopes

No specific scope required

#### Response


    {
      "id": "U_ffd955ba63db5c25",
      "first_name": "Mary",
      "last_name": "Driverton",
      "email": "developer@automatic.com"
    }




| Name         | Description                                                                    |
| ------------ | ------------------------------------------------------------------------------ |
| `id`         | The user ID of the authenticated user.                                         |
| `first_name` | The first name of the authenticated user. Requires `scope:user:profile` scope. |
| `last_name`  | The last name of the authenticated user. Requires `scope:user:profile` scope.  |
| `email`      | The email of the authenticated user. Requires `scope:user:profile` scope.      |



## Vehicles

### List vehicles for authenticated user


    GET /vehicles


#### Scopes

If the app had the `scope:vehicle:profile` scope, then information about each vehicle will be returned. If the app does not have this scope, only the `id` field will be returned.

#### Response

The response will be an array of [vehicle objects][6].


        [
          {
            "uri": "https://api.automatic.com/v1/vehicles/524da549e4b08d1af17f6dca",
            "id": "C_8e7b567626c26695",
            "year": "2001",
            "make": "Acura",
            "model": "MDX",
            "color": "#d15fed",
            "display_name": "My Speed Demon"
          }
        ]


### Get a single vehicle


    GET /vehicles/:id


#### Scopes

Requires the `scope:vehicle:profile` scope.

#### Parameters



| Name |                       | Description                                |
| ---- | --------------------- | ------------------------------------------ |
| `id` | _Required_ **string** | ID of a the vehicle you'd like to retrieve |



#### Response

The response will be a single [vehicle object][6].

## Errors

Errors are sent as JSON with a `message` attribute with an approproate HTTP status code.

### Example Error response


        {
            "message": "Invalid OAuth Token"
        }


### Error List

Below is a full list of errors that the Automatic REST API may respond with.



| Status Code | Message                       | Description                                                                                                           |
| ----------- | ----------------------------- | --------------------------------------------------------------------------------------------------------------------- |
| 403         | Invalid Scope                 | The token attached to the request did not have the scope needed to access this endpoint. See the [list of scopes][8]. |
| 404         | Not Found                     | The resource requested doesn't exist, or the token attached to the request doesn't have access.                       |
| 404         | Use https://api.automatic.com | All API requests must use https. Make sure you are requesting https://api.automatic.com.                              |
| 500         | Server Error                  | Something is wrong on our servers. Try again, or [let us know about the issue][9].                                    |



## The Trip Object



| Name                 | Description                                                                                                                                      |
| -------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------ |
| `uri`                | API URI to the trip object.                                                                                                                      |
| `id`                 | A unique identifier for the trip.                                                                                                                |
| `user`               | An object containing `id` which is a unique identifier for the user.                                                                             |
| `vehicle`            | A [vehicle object][6]                                                                                                                            |
| `start_location`     | The start location of the trip as a location object with `name`, `display_name`, `lat`, `lon` and `accuracy_m`. Requires `scope:location` scope. |
| `start_time`         | The start time of the trip started in as unix timestamp in milliseconds.                                                                         |
| `start_time_zone`    | The start timezone of the trip.                                                                                                                  |
| `end_location`       | The end location of the trip as a location object with `name`, `display_name`, `lat`, `lon` and `accuracy_m`. Requires `scope:location` scope.   |
| `end_time`           | The end time of the trip started as unix timestamp in milliseconds.                                                                              |
| `end_time_zone`      | The end timezone of the trip                                                                                                                     |
| `path`               | The trip path as an [encoded polyline][10]. Requires `scope:location` scope                                                                      |
| `distance_m`         | The trip distance in meters.                                                                                                                     |
| `hard_accels`        | The number of hard acceleration events during the trip. Requires `scope:trip:events` scope.                                                      |
| `hard_brakes`        | The number of hard braking events during the trip. Requires `scope:trip:events` scope.                                                           |
| `duration_over_80_s` | The number of seconds over 80 mph during the trip. Requires `scope:trip:events` scope.                                                           |
| `duration_over_75_s` | The number of seconds over 75 mph during the trip. Requires `scope:trip:events` scope.                                                           |
| `duration_over_70_s` | The number of seconds over 70 mph during the trip. Requires `scope:trip:events` scope.                                                           |
| `fuel_cost_usd`      | The fuel cost in USD for the trip.                                                                                                               |
| `fuel_volume_gal`    | The volume of fuel used for the trip in gallons.                                                                                                 |
| `average_mpg`        | The average miles per gallon for the trip.                                                                                                       |
| `drive_events`       | An array of drive events (hard brakes, hard accels and speeding) during the trip. Requires `scope:vehicle:events` scopes.                        |



### Example Trip Object


        {
          "uri": "https://api.automatic.com/v1/trips/524da549e4b08d1af17f6dca",
          "id": "T_db5c2635ffd955ba",
          "user": {
            "id": "U_ffd955ba63db5c25"
          },
          "vehicle": {
            "uri": "https://api.automatic.com/v1/vehicles/529e5772e4b00a2ddb562f1f",
            "id": "C_8e7b567626c26695",
            "year": 2001,
            "make": "Acura",
            "model": "MDX",
            "color": "#d15fed",
            "display_name": "My Speed Demon"
          },
          "start_location": {
            "name": "Ashbury St, SF, CA",
            "display_name": "Home",
            "lat": 37.7692903,
            "lon": -122.4465469,
            "accuracy_m": 5
          },
          "start_time": 1383448450201,
          "start_time_zone": "America/Los_Angeles",
          "end_location": {
            "name": "5th St, SF, CA",
            "display_name": "Work",
            "lat": 37.78270046281092,
            "lon": -122.4064556183999,
            "accuracy_m": 97.88124084472656
          },
          "end_time": 1383449950201,
          "end_time_zone": "America/Los_Angeles",
          "path": "uioeFxycjVxDMvAGBjATlJXrLaIZHvCFhCHpCaI^i@@",
          "distance_m": 6573.416666666661,
          "hard_accels": 0,
          "hard_brakes": 1,
          "duration_over_80_s": 0,
          "duration_over_75_s": 2,
          "duration_over_70_s": 3,
          "fuel_cost_usd": 1.0428111627932486,
          "fuel_volume_gal": 0.2465857561582522,
          "average_mpg": 16.56434586845349,
          "drive_events": [
            {
              "type": "speeding",
              "start_distance_m": 4193.749999999999,
              "end_distance_m": 4383.416666666666,
              "start_time": 1383448690201,
              "end_time": 1383448692301,
              "velocity_mph": 70
            },
            {
              "type": "hard_accel",
              "lat": 38.4184716230387,
              "lon": -122.71354039973721,
              "ts": 1383449948101,
              "g": 0.351
            },
            {
              "type": "hard_brake",
              "lat": 37.82475806798236,
              "lon": -122.31403562609702,
              "ts": 1383449946901,
              "g": 0.611
            }
          ]
        }


## The Vehicle Object



| Name           | Description                                                                                                                                                                                                            |
| -------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `uri`          | API URI to the vehicle object.                                                                                                                                                                                         |
| `id`           | A globally unique identifier for the vehicle.                                                                                                                                                                          |
| `year`         | Year of the vehicle.                                                                                                                                                                                                   |
| `make`         | Make of the vehicle.                                                                                                                                                                                                   |
| `model`        | Model of the vehicle.                                                                                                                                                                                                  |
| `color`        | The vehicle color, set by the user in hexidecimal RGB.                                                                                                                                                                 |
| `display_name` | A nicely formatted name of the vehicle. If a custom name has been set by the user, it is used. Otherwise a string with vehicle make and model is provided (i.e. "Acura MDX"). Use this in the UI to identify vehicles. |



Note that all fields expect `uri` and `id` require the `scope:vehicle:profile` scope.

### Example Vehicle Object


        {
            "uri": "https://api.automatic.com/v1/vehicles/529e5772e4b00a2ddb562f1f",
            "id": "C_8e7b567626c26695",
            "year": 2001,
            "make": "Acura",
            "model": "MDX",
            "color": "#d15fed",
            "display_name": "My Speed Demon"
        }


[1]: https://blog.heroku.com/archives/2012/5/3/announcing_better_ssl_for_your_app
[2]: https://tripviewer.herokuapp.com
[3]: https://automatic.com/developer/dashboard/
[4]: http://automatic.com/developer/dashboard
[5]: https://www.automatic.com#the-trip-object
[6]: https://www.automatic.com#the-vehicle-object
[7]: http://tools.ietf.org/html/rfc5988
[8]: https://www.automatic.com#scopes
[9]: mailto:developer%40automatic.com
[10]: https://developers.google.com/maps/documentation/utilities/polylinealgorithm?csw=1
  
 NIGHT MODE