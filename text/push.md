# Subscribing to events

Events are changes in [the state of a user](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/basics.md#neuras-nomenclature) that Neura delivers.  After you subscribe to an event, Neura sends that event to you, either to your server using webhook or to your mobile app through Neura's [Android app](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_Android.md). 

In this document Neura details API endpoints that you can use to subscribe to events.  The Neura API is read-only, requires HTTPS, and returns responses in JSON.  You must [be authenticated](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/authentication.md), provide a **Bearer** access token and have user permission to receive PUSH notifications.

This document consists of the following sections:  
  1. [Subscribe to an event](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md#1-subscribe-to-an-event)  
  2. [Get subscription list](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md#2-get-subscription-list)  
  3. [Get a specific subscription](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md#3-get-a-specific-subscription)  
  4. [Unsubscribe](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md#4-unsubscribe)  
  5. [Neura HTTPS request to webhook](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md#5-neura-https-request-to-webhook)  
  6. [Event list](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md#5list-of-events-available-for-subscription)  

##1. Subscribe to an event

### Resource URI  

**`POST https://wapi.theneura.com/v1/subscriptions`**  

### Request query parameters  

#### Required request parameters
- `event_name`: (string) This is the name of the event to which you are subscribing. We provide a full [list of event names](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md#events-available-for-push-notification-subscriptions) below.
- `method`: (string) How Neura will notify you about the event, either `all`, `push`, or `webhook`. Neura defaults to `method=all`.
- `identifier`: (string) The name you give to identify your subscription.
 

#### Optional request parameters
- `state`: (string) This is a value that we echo back to you with the event.
- `webhook_id`: (string) All webhooks must declared when you first register your app. This is the webhook where Neura will send this specific event. The default value is the default application subscriber URL that you define when you register your app. 

### Request headers

#### Required request headers  

- `authorization`: `Bearer <access_token>`

### Neura's response to event subscription request
`status`: Either failure or success.  
`timestamp`: The time when Neura processed the request. 

### Example subscription `<event>` request

```http
POST https://wapi.theneura.com/v1/subscriptions
Authorization: Bearer asdf1234**************************
```

### Example subscription `<event>` response

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
  "timestamp": 1418244427 
}
```

##2. Get subscription list
### Resource URI

**`GET https://wapi.theneura.com/v1/subscriptions`**

### Request query parameters

#### Required request parameters
None 

#### Optional request parameters
None

### Request headers

#### Required request headers

- `authorization`: `Bearer <access_token>`

### Neura's response to subscription list request
`status`: either failure/success  
`timestamp`: the time when the request was processed  
`size`: The number of subscription list objects in the response  
`items`: The complex object representing the subscription list   
`items`>`created_at`: The timestamp when the subscription was created  
`items`>`identifier`: The identifier of the subscription    
`items`>`event`: The event name  
`items`>`state`: The state defined for the subscription  

### Example of a subscription list request

```http
GET https://wapi.theneura.com/v1/subscriptions
Authorization: Bearer asdf1234**************************
```

### Example of a subscription list response

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
  "timestamp": 1418244427,
  "size": 1,
  "items": [
    {
    	"created_at":  1418214427,
     	"identifier":  "aaa",
     	"event":       "userStartedWalking",
     	"state":       "bbb"
     }
  ]
} 
```

##3. Get a specific subscription
### Resource URI

**`GET https://wapi.theneura.com/v1/subscriptions/<identifier>`**

### Request query parameters

#### Required request parameters
`identifier`: the subscription identifier 

#### Optional request parameters
None

### Request headers

#### Required request headers

- `authorization`: `Bearer <access_token>`

### Neura's response to subscription list request
`status`: either failure/success  
`timestamp`: the time when the request was processed  
`size`: The number of subscription list objects in the response  
`items`: The complex object representing the subscription list   
`items`>`created_at`: The timestamp when the subscription was created  
`items`>`identifier`: The identifier of the subscription    
`items`>`event`: The event name  
`items`>`state`: The state defined for the subscription  

### Example of a subscription list request

```http
GET https://wapi.theneura.com/v1/subscriptions/aaa
Authorization: Bearer asdf1234**************************
```

### Example of a subscription list response

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
  "timestamp": 1418244427,
  "data":
  {
     created_at:  1418214427,
     identifier:  "aaa",
     event:       "userStartedWalking",
     state:       "bbb"
  }
} 
```

##4. Unsubscribe
### Resource URI

**`DELETE https://wapi.theneura.com/v1/subscriptions/<identifier>`**

### Request query parameters

#### Required request parameters
`identifier`: the subscription identifier 

#### Optional request parameters
None

### Request headers

#### Required request headers

- `authorization`: `Bearer <access_token>`

### Neura's response to subscription list request
`status`: either failure/success  
`timestamp`: the time when the request was processed  

### Example of a subscription list request

```http
DELETE https://wapi.theneura.com/v1/subscriptions/aaa
Authorization: Bearer asdf1234**************************
```

### Example of a subscription list response

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
  "timestamp": 1418244427,
} 
```
##5. Neura HTTPS request to webhook
When you subscribed to an event and set webhook state, neura will send an HTTPS request to the webhook once event occurred. You should response to this request with status code 200.
### Resource URI

**`POST https://<webhook>`**

#### neura will send the following request parameters
`name`: The name of occuring event 
`timestamp`: The timestamp when the event generated
`metadata`: Metadata about the event
`state`: The state you set for the subscription
`identifier`: The identifier you set to the subscription

### Expected response to webhook request
response with status code 200

### Example of a subscription list request

```http
POST https://your_domain/asdfg
{
  name: "userStartedWalking",
  timestamp: 1418214427,
  metadata: {},
  state: "aaa",
  identifier: "bbb"
}
```

### Example of a subscription list response

#### Headers
```http
status: 200 OK
version: HTTP/1.1
Content-Type: application/json
```

##6. List of Events available for subscription
The events are detailed below, organized into events by location and events by activity.

###Events by location
`userArrivedHome`  
`userLeftHome`  
`userArrivedToWork`  
`userLeftWork`  
`userArrivedToGym`   
`userLeftGym`  


###Events by activity
`userStartedSleeping`  
`userWokeUp`  
`userStartedWalking`  
`userFinishedWalking`  
`userStartedDriving`  
`userFinishedDriving`  
`userStartedRunning`  
`userFinishedRunning`  
`userStartedCycling`  
`userFinishedCycling`  
`userStartedWorkOut`  
`userFinishedWorkOut`  


## [Return to the main page](https://github.com/NeuraLabs/Neura_documentation)











