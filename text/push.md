# Subscribing to events

Events are changes in [the state of a user](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/basics.md#neuras-nomenclature).  After you subscribe to an event, Neura sends that event to you, either to your server using webhook or to your mobile app through Neura's [Android app](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_Android.md#neura-for-android). 

In this document Neura details API endpoints that you can use to subscribe to events for a single user.  **You can only subscribe to events for one user at a time.**   The Neura API is read-only, requires HTTPS, and returns responses in JSON.  You must [be authenticated](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/authentication.md#authentication), provide an access token and have user permission to receive PUSH notifications.

This document consists of the following sections:  
  1. [Subscribe to an event](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md#1-subscribe-to-an-event)  
  2. [Get a list of your event subscriptions](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md#2-get-a-list-of-your-event-subscriptions)  
  3. [Get information for an existing subscription](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md#3-get-information-for-an-existing-subscription)  
  4. [Unsubscribe](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md#4-unsubscribe)  
  5. [Neura POSTs an event to your webhook](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md#5-neura-posts-an-event-to-your-webhook)  
  6. [Event list](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md#6-list-of-events-available-for-subscription)  

##1. Subscribe to an event

### Resource URI  

**`POST https://wapi.theneura.com/v1/subscriptions`**  

### Request query parameters  

#### Required request parameters
- `event_name`: (string) This is the name of the event to which you are subscribing. We provide a full [list of event names](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md#6-list-of-events-available-for-subscription) below.
- `method`: (string) How Neura will notify you about the event, either `all`, `push`, or `webhook`. Neura defaults to `method=all`.  If you specify `method=webhook` then Neura will [POST to your webhook](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md#5-neura-posts-an-event-to-your-webhook) every time the event occurs.  If you specify `method=push` then Neura will PUSH to your mobile app (only available [for Android](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_Android.md#neura-for-android)).  If you specify `method=all` then Neura will do both.
- `identifier`: (string) The name you give to identify your subscription.  

#### Optional request parameters
- `state`: (string) This is a value that we echo back to you with the event.
- `webhook_id`: (string) This is the webhook where Neura will send this specific event. You must declare all webhooks when you first register your app.  The default value is the default application subscriber URL that you define when you register your app. 

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

##2. Get a list of your event subscriptions
Neura can provide you a list of your event subscriptions for a user, identified by their unique `access_token`.

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
`status`: Either failure or success.  
`timestamp`: The time when Neura processed the request.  
`size`: The number of subscription list objects in the response.  
`items`: The complex object representing the subscription list.   
`items`>`created_at`: The timestamp when you created the subscription.  
`items`>`identifier`: The identifier of the subscription that you created.   
`items`>`event`: The event name from the [list below](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md#6-list-of-events-available-for-subscription).   
`items`>`state`: Neura echos back the state you defined for the subscription.  

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
     	"identifier":  "my_first_event",
     	"event":       "userStartedWalking",
     	"state":       "send_me_this_message"
     }
  ]
} 
```

##3. Get information for an existing subscription
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

### Neura's response  
`status`: Either failure or success.  
`timestamp`: The time when Neura processed the request.  
`data`: The complex object representing the subscription info.   
`data`>`created_at`: The timestamp when you created the subscription.  
`data`>`identifier`: The identifier of the subscription that you created.   
`data`>`event`: The event name from the [list below](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md#6-list-of-events-available-for-subscription).   
`data`>`state`: Neura echos back the state you defined for the subscription.  



### Example request

```http
GET https://wapi.theneura.com/v1/subscriptions/my_first_event
Authorization: Bearer asdf1234**************************
```

### Example response

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
    	"created_at":  1418214427,
     	"identifier":  "my_first_event",
     	"event":       "userStartedWalking",
     	"state":       "send_me_this_message"
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
DELETE https://wapi.theneura.com/v1/subscriptions/my_first_event
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

##5. Neura POSTs an event to your webhook
After you've successfully [subscribed to an event](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md#1-subscribe-to-an-event) then Neura will POST to your webhook every time the event occurs, if you set `method=all` or `method=webhook`.

### The resource URI that you provide

**`POST https://<your webhook>`**

#### Neura will send the following request parameters
`name`: Neura's name of event  
`timestamp`: The timestamp when Neura recognized the event  
`metadata`: Metadata about the event  
`state`: The state you set for the subscription  
`identifier`: The identifier you set to the subscription  

### Expected response to webhook request
Neura expects you to respond with status code 200.

### Example request

```http
POST https://your_domain.com/send_my_event_here
{
  "name": "userStartedWalking",
  "timestamp": 1418214427,
  "metadata": {},
  "state": "my_first_event",
  "identifier": "send_me_this_message"
}
```

### Example response

#### Headers
```http
status: 200 OK
version: HTTP/1.1
Content-Type: application/json
```

##6. List of events available for subscription
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


## [Return to the main page](https://github.com/NeuraLabs/Neura_documentation#build-with-neura)



