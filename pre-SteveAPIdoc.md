
##Welcome to the Neura API
**Interacting with the Neura API**

You can query the Neura API to pull information about a user.  All requests for user data must include an authorization header with the value containing the user's access token:

    Authorization: Bearer asdf1234*****************

Permissions - in Android & iOS SDK guides. Specific to each platform. 

##Neura API calls

###The `daily_summary` request
You can use the `daily_summary` request to get a user’s wellness information for a single day.  

- Neura calculates values for `daily_summary` using the current dataset for the user. However,  values may change as the user syncs their devices with Neura, which may update their dataset. 
- `daily_summary` is not available for the current day; it is only available for previous days.

**Request parameters**
   URI https://wapi.theneura.com/v1/users/profile/daily_summary
**`date`**  The specific day, in YYYY-MM-DD format, for which you want information. 
**`source`** The specific partner device for which you want information.  As of October 2014, this parameter is only available for the Neurosky device, `source = neurosky`. 

**Permission** ```dailyActivitySummary```

**Example request**
In this example `daily_summary`, the client is requesting data from September 30th, 2014 for the user with access token  `asdf1234*****************`.

    GET /v1/users/profile/daily_summary?date=2014-09-30 HTTP/1.1
    Host: wapi.theneura.com
    Authorization: Bearer asdf1234**************************
    Cache-Control: no-cache



###The `daily_summary` response
**status**	
Neura returns whether your API call was a ````success```` or ````error```` 

####If status is a ````success```` Neura will return:
**timestamp**	
Neura returns the time when it sent the response in epoch time 

**data**	
The complex object of ````success```` response data. As of October 2014, Neura returns 0 if data is not available for any of the sub-objects.
*Note for mike & berman: how do other companies convey complex objects in their docs? data > stuff is a quick hack*  

**data > date**	
Neura echoes  the ````date```` in your Request parameter in the  in the format YYYY-MM-DD.   

**data > minutesWalk**	
Neura returns the number of minutes that the user was continuously active either running or walking while outside their home. 

 **data > steps**	
Neura returns the number of steps the user walked on ````date```` .   If a user has multiple step-counting devices then Neura the merges data.

**data > calories**	
Neura returns the amount of calories the user burned on ````date```` in kilocalories (kcal).
 
**data > heartRate**	
Neura returns the user's average heartRate on ````date```` 
As of October 2014, only available for users with Neurosky. 

**data > weight**	
Neura returns the user's average body weight on ````date```` in kilograms (kg). 

####If status is  ````error```` Neura will return:
**errors**	
Neura returns a human-intelligible message explaining any
If API call fails then error code and message

**errors > code **
Neura returns a snake_case string representing the error code.

** errors > message **
Neura returns a human-readable message describing the cause of the error.

-------

**Mike is picking up here**

##Build with Neura
We're excited for you to join the community of Builders that are using Neura to enhance their apps and internet-of-things (IoT) devices.  This guide includes a Quickstart project to quickly get you test-driving the Neura API.  We also provide instructions to fully benefit from Neura, including details for using the Neura API and integrating the Neura SDK with your app. 

 - Quickstart with Neura
 - The Neura API
 - The Neura SDK for Android
 - The Neura SDK for iOS
 - Permissions (move from http://dev.neura.me/#/docs)

###Quickstart project
This 10-minute project will allow you to use Neura's `daily_summary` API call to get basic wellness information for our teammate Betty **(Gili - delete PII)** who generated a test dataset   This project should take you less than 10 minutes.

####Quickstart project instructions:
  1. Install Postman for Chrome (or use your favorite REST client packaged app) **put in Postman link here**  If you're having trouble with Postman, here's a good tutorial for reference. **youtube link**
  2. Select a 'Normal' `Get` request
  3. Under `Request URL` enter https://wapi.theneura.com/v1/users/profile/daily_summary 
  4. Under `URL Parameter Key` enter `date`
  5. Under `URL Parameter Value` enter `2014-07-04`
  6. Under `Header` enter `Authorization`
  7. Under  `Header Value` enter **`Bearer asdf1234********`(update)**
  8. Send the `Get` request
  9. Check out the JSON response to see Betty's wellness information on July 4th, 2014.  To better understand the response, please see `daily_summary` in the **Neura API documentation (include link)**.
  10. You can play with the `date` value to see variations in Betty's dataset. Note that the dataset is only available from June to August 2014 (from `2014-06-01` to `2014-08-31`**define limits**). 

**show sample output here in JSON. thanks Adi!** 

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
####Examine your own data with the Quickstart project
You can examine your data by getting your unique `Authorization Key`**Is that what it's called?** from Neura for the `daily_summary` call.  

  1.  Download the Neura app on your Android or iOS mobile phone. **include app & play store links** 
  2. Email build@theneura.com to request an access code to complete installation of the app.  In the email, please be sure to note that you're a Builder working on a Quickstart project.  
  3. Neura will respond with your `Authorization Key`.
  4. Have fun playing around with your data. We hope it gives you a small taste of the power of Neura and motivates you to integrate your apps and IoT devices with Neura.

###Integrate Neura with your app
