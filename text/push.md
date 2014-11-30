# Neura API endpoints for PUSH event subscriptions
In this document Neura details API endpoints that you can use to subscribe to PUSH notifications for events.  The Neura API is read-only, requires HTTPS, and returns responses in JSON.  **Is JSON true for PUSH events?**.  You must [be authenticated, provide a **Bearer** authorization token and have user permission](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/authentication.md) to receive PUSH notifications. 

`POST https://wapi.theneura.com/v1/subscriptions`
**Is this true? when I tested it was GET not POST**
###Neura events detailed below
  - `userIsWalking`: user is walking
  - `phoneShaking`: user is shaking their phone **Does userIsIdle / userIsNotIdle work for this? If not, Ori to decide test case per product discussion on Nov 18th**  

**Mikimer & Berman to play with more events!**

## GET a subscription to an event

### Resource URI

**`https://wapi.theneura.com/v1/users/profile/<event>`**

### Request query parameters

#### Required request parameters
- `subscription_id`: Your subscription identifier for the event. 

#### Optional request parameters
- `method`: How Neura will notify you about the event, either `all`, `push`, or `webhook`. If you don't specify a `method`, Neura defaults to `method=all`.
- `state`: Customer’s can set it. It is always included into subscribed notification event. **Clarify with Berman. This description makes no sense**- `webhook_id`: The webhook where Neura will send the event notification. The default value is the default application subscriber url that was defined in the application registration process. **Can this be clearer?**

### Request headers

#### Required request headers

- `authorization`: Bearer authorization token

#### Optional request headers

- `Cache-Control`: Specifies if the server should circumvent the server cache


## Neura notification for event subscription
- `notificationTimestamp`:  The time when Neura sent the response in epoch time. **Mike changed from Unix GTM time**- `state`: State that customer has set previously in the subscription. **clarify with Berman**    - `identifier`: Customer’s subscription id that was set in the event subscription **do we really use two different names for the same thing? why?**- `event`: The complex object of event data       -  `timestamp`: Timestamp of the event in Unix time (GTM time) **can we change this to be parallel to PULL requests? Let's be consistent wherever possible**       -  `userId`: Unique user id that had event occurred **clarify with Berman**       -  `eventName`: The name of the event you subscribed to.       -  `[metadata]`: Metadata is unique to each event, as detailed in event descriptions.


### Example subscription `<event>` request

```http
GET https://wapi.theneura.com/v1/users/profile/call
Authorization: Bearer asdf1234**************************
Cache-Control: no-cache
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
   }
```
 
## Unsubscribe from an event subscriptionDelete a subscription for the user. 

### Resource URI`DELETE https://wapi.theneura.com/v1/user/events/unsubscribe`
### Request query parameters

#### Required request parameters
None.

#### Optional request parameters
None.

### Request headers

#### Required request headers

- `authorization`: Bearer authorization token

#### Optional request headers

- `Cache-Control`: Specifies if the server should circumvent the server cache

## Response for `unsubscribe` 

**What does Neura return?**


### Example unsubscribe `unsubscribe` request

```http
GET https://wapi.theneura.com/v1/users/profile/call
Authorization: Bearer asdf1234**************************
Cache-Control: no-cache
```

### Example unsubscribe `unsubscribe` response

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

##GET a list of user events that you've subscribed to 
You can request that Neura provide you with a list of user events that you've subscribed to.### Resource URI

**`GET https://wapi.theneura.com/v1/user/events/subscriptions`**

### Request query parameters

#### Required request parameters
None.

#### Optional request parameters
- `identifier`:  Identifies the webhook to which to notify the events. If you don't specify a value, Neura will default to the application subscriber url that you defined in the application registration process. 

### Request headers

#### Required request headers

- `authorization`: Bearer authorization token

#### Optional request headers

- `Cache-Control`: Specifies if the server should circumvent the server cache

## Response for `subscriptions` 

- `userId`:The user's Neura ID
- `timestamp`: The time when Neura sent the response in epoch time. 
- `subscriptions`: Subscription complex object **Calrify with Berman**     - `subscriptionName`: Event name

### Example subscription list `subscriptions` request

```http
GET https://wapi.theneura.com/v1/users/profile/call
Authorization: Bearer asdf1234**************************
Cache-Control: no-cache
```

### Example subscription list `call` response

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
 

##`<events>` available for PUSH notification subscriptions 
The events are detailed below, organized into the following categories:  

- Events at home
- Events at work
- Events around town
- Other events

**list associated metadata**


###Events at home
`userArrivedHome`


`userStartedSleeping`

`userLeftHome`

`userWokeUp`


###Events at work
`userIsAtWork` 

`userArrivedToWork`

`userLeftWork`


###Events around town
`userIsCycling`

`userIsDriving`

`userFinishedRunning`

`userFinishedCycling`

`userStartedCycling`

`userIsAtGym`

`userStartedRunning`

`userIsRunning`

`userArrivedToGym`

`userFinishedWorkOut`

`userIsWorkingOut`

`userStartedWorkOut`

`userFinishedDriving`

`userStartedDriving`

`userLeftGym`


###Other events
`userIsWalking`

`userFinishedWalking`

`userIsIdle`

`userIsNoLongerIdle`

`userStartedWalking`












