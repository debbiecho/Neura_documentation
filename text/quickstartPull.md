
#Quickstart: Request wellness information
In this project you will request the `daily_summary` insight from Neura's API to get health and wellness information for Bob, a dummy user.  [Instructions](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/quickstartPull.md#instructions) for this project are detailed below -- it should take you less than 3 minutes; it **does not require an account** with Neura or a mobile phone.

This project demonstrates Neura's ability to provide distilled data to a third party app. A practical application of this project is that you can use it to develop an app that adapts to user behavior over time. 


##The response you'll get in JSON
```json
{
  "status": "success",
  "timestamp": 1417634391,
  "data": {
    "date": 20141114,  
    "createdAt": "2014-11-28T02:09:05Z",
    "minutesWalk": 0,
    "calories": 909.97900015116,
    "steps": 1027,
    "heartRate": 0,
    "weight": 0,
    "workDay": 0,
    "sleepData": {
      "length": 4,
      "deepSleep": 163,
      "lightSleep": 80
      },
  "activityPlaces": [ 
  ]
  }
}
```


##Instructions
  1.  If you don't already have a [tool to test a RESTful API](http://stackoverflow.com/questions/20495384/is-there-any-online-tool-to-test-rest-api), install [Postman for Google Chrome](http://www.getpostman.com/).
  2. Under the **Normal** tab, select a **GET** request.
  3. Under **Request URL** enter `https://wapi.theneura.com/v1/users/profile/daily_summary`  
  4. For **URL Parameter Key** enter `date`
  5. For **URL Parameter Value** enter `2014-11-14`
  6. For **Header** enter `Authorization`
  7. For  **Header Value** enter `Bearer b994215649adf4df0ae14579b919505a60d59f973adac419af8bea7d67cbae89`  
  8. Send the **GET** request  
  9. View Neura's response in JSON summaring Bob's wellness information on November 14th, 2014.  The [API insights](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/pull.md#get-usersprofiledaily_summary) documentation explains the response in detail, including the key-value pairs.

###What you'll send  
```
GET /v1/users/profile/daily_summary?date=2014-11-14 HTTP/1.1
Host: wapi.theneura.com
Authorization: Bearer b994215649adf4df0ae14579b919505a60d59f973adac419af8bea7d67cbae89
Cache-Control: no-cache
```

----

##Wanna do more? Play with the `date` in Bob's dataset 
Bob's data from November 1st to November 15th 2014 (`2014-11-01` to `2014-11-15`) is available for you to play with. You can see how it changes over time or additional details, such as when he weighed himself on November 13th.

##Congrats on finishing this quickstart project! 
We hope it gives you a small taste of the power of Neura and motivates you to integrate your apps and IoT devices with Neura.  For next steps, you can [learn more](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/basics.md) about Neura.

##[Return to the Main Page](https://github.com/NeuraLabs/Neura_documentation#build-with-neura)
