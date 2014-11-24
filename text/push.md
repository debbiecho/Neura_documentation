# Neura API Endpoints for PUSH event subscriptions
In this document Neura details API endpoints that you can use to subscribe to PUSH notifications for events.  The Neura API is read-only, requires HTTPS, and returns responses in JSON  **Is this true for PUSH events?**.  


`POST https://wapi.theneura.com/v1/subscriptions`
**Is this true? when I tested it was GET not POST**
###Neura **events** available for a PUSH subscription
  - `userIsWalking`: user is walking
  - `phoneShaking`: user is shaking their phone **Does userIsIdle / userIsNotIdle work for this? If not, Ori to decide test case per product discussion on Nov 18th**  




## GET /users/profile/call TEMPLATE

DESCRIPTION OF THE CALL

### Resource URI

**`https://wapi.theneura.com/v1/users/profile/call`**

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

- `notificationTimestamp`:  The time when Neura sent the response in epoch time. **Mike changed from Unix GTM time**- `state`: State that customer has set previously in the subscription. **clarify with Berman**    - `identifier`: Customer’s subscription id that was set in the event subscription **do we really use two different names for the same thing? why?**- `event`: The complex object of event data       -  `timestamp`: Timestamp of the event in Unix time (GTM time) **can we change this to be parallel to PULL requests? Let's be consistent wherever possible**       -  `userId`: Unique user id that had event occurred       -  `eventName`: Event name that is also used for subscribing to the service       -  `metadata`: Metadata that is defined event specific. Look at service codes and their metadata list below


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
 


