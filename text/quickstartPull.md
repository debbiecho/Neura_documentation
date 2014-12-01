
#Quickstart: Submit a PULL request for a data object
In this project you will PULL the `daily_summary` data object from Neura's API to get wellness information for Gilad, our CEO.  This project should take you less than 5 minutes; it **does not require an account** with Neura.

##Instructions
  1.  If you don't already have a [tool to test a RESTful API](http://stackoverflow.com/questions/13965959/what-tools-can-i-use-to-test-restful-api), install [Postman for Google Chrome](http://www.getpostman.com/).
  2. Select a 'Normal' `Get` request.
  3. Under `Request URL` enter `https://wapi.theneura.com/v1/users/profile/daily_summary`  
  4. Under `URL Parameter Key` enter `date`
  5. Under `URL Parameter Value` enter `2014-09-01`
  6. Under `Header` enter `Authorization`
  7. Under  `Header Value` enter `Bearer asdf1234********` **(Berman to update)**
  8. Send the `Get` request
  9. View Neura's response in JSON with a summary of Gilad's wellness information on September 1st, 2014.  Documentation explaining the response in detail is available in the [API data object](https://github.com/mikimer/Neura_documentation/blob/master/text/endpoints.md) documentation. 

###The output will be:
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
      "activityPlaces": [ 
        ]
        }
      }
```
**Update this response for Gilad's updated dataset**

-----

##Wanna do more? 
###Play with the `date` in Gilad's dataset 
Gilad's data from July to September 2014 (from `2014-07-01` to `2014-09-30`**update for what Berman creates**) is available for you to play with. 

###Examine your own `daily_summary` data
You can examine your data by getting your unique `accessToken`.  As of November 2014, this is only available for Android.  

  1. [Download Neura's Android app](https://play.google.com/store/apps/details?id=com.neura.weave&hl=en). 
  2. Download Neura's [3rd party demo app](https://github.com/mikimer/Neura_documentation/blob/master/resources/DemoNeura3rdPartyApp.apk)
  3. ... **Mikimer to work w/ Berman/Chiki to get this working.**
  4. Have fun playing around with your data. We hope it gives you a small taste of the power of Neura and motivates you to integrate your apps and IoT devices with Neura.

![DemoNeura3rdPartyApp.apk](https://github.com/mikimer/Neura_documentation/blob/master/resources/Screenshot_DemoNeura3rdPartyApp.png)
