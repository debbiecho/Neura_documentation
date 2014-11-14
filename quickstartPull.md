
###Quickstart: Pull data from Neura
This 5-minute project will allow you to use Neura's `daily_summary` API call to get basic wellness information for our teammate Betty **(Gili - delete PII)** who generated a test dataset   This project should take you less than 5 minutes.

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

**Your output should look like this:**

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
###Wanna do more? Examine your own `daily_summary` data
You can examine your data by getting your unique **Authorization Key** **(Is that what it's called?)** from Neura for the `daily_summary` call.  

  1.  Download the Neura app on your Android or iOS mobile phone. **include app & play store links** 
  2. Email `build [at] theneura [dot] com` to request an access code to complete installation of the app.  In the email, please be sure to note that you're a Builder working on a Quickstart project.  
  3. Neura will respond with your `Authorization Key`.
  4. Have fun playing around with your data. We hope it gives you a small taste of the power of Neura and motivates you to integrate your apps and IoT devices with Neura.

