
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


#How to subscribe for a daily summary ?

###well, that's a good question and we will show you how :) 

    1. POST /api/oauth/authorize
       Host: http://pulsa.theneura.com
       Authorization: Bearer bd8832a62e49cf7e6ae1151ffc7442563774ee7c0cb0e6e538dab1535a4eb19f
       
       Body:

      {
        "client_id":"7ec55c01f**********************************************************",
        "client_secret":"d75bb20********************************************************",
        "permissions": "userHasBeenIdleMoreThan60Minutes,userArrivedToSignificantLocationFromActiveZone,userArrivedToGym,user         IsAtGym,userWokeUp,userArrivedAtActiveZone,userFinishedWorkOutInSignificantPlace,userIsOnTheWayToActiveZone,userLeftA         ctiveZone,dailyActivitySummary,neuroskyHeartRateVariable,wellnessProfile,activitySummaryPerPlace,sleepData"
      }
      
        Cache-Control: no-cache
        
##The response you'll get in JSON:

     {
  "status": "success",
  "timestamp": 1423056121,
  "data": {
    "token": "0dd36f9dc44071217f18125d38cea9fce2549a803af734be3e433191df69ca74",
    "permissions": [
      {
        "name": "userArrivedToWork",
        "displayName": "User arrived to work",
        "neuraId": "pq6ody6iw"
      },
      {
        "name": "userIsAtWork",
        "displayName": "User is at work",
        "neuraId": "pxzx064c1"
      },
      {
        "name": "userIsRunning",
        "displayName": "User is running",
        "neuraId": "p5im398j8"
      },
      {
        "name": "userArrivedToSignificantLocationFromActiveZone",
        "displayName": "User arrived to significant location from active zone",
        "neuraId": "paye7va2c"
      },
      {
        "name": "userIsDriving",
        "displayName": "User is driving",
        "neuraId": "pkxmsmw8x"
      },
      {
        "name": "userArrivedToGym",
        "displayName": "User arrived to gym",
        "neuraId": "pqol9hhmm"
      },
      {
        "name": "userFinishedCycling",
        "displayName": "User finished cycling",
        "neuraId": "p745n0jjc"
      },
      {
        "name": "userArrivedToSignificantLocationByCommute",
        "displayName": "User arrived to significant location by commute",
        "neuraId": "prjvnae2u"
      },
      {
        "name": "userIsCycling",
        "displayName": "User is cycling",
        "neuraId": "pkgcn73aq"
      },
      {
        "name": "userStartedCycling",
        "displayName": "User started cycling",
        "neuraId": "pci0vbfov"
      },
      {
        "name": "userIsAtGym",
        "displayName": "User is at gym",
        "neuraId": "pd2i72qd"
      },
      {
        "name": "userFinishedRunning",
        "displayName": "User finished running",
        "neuraId": "pkjfacf9r"
      },
      {
        "name": "userArrivedToSignificantLocationAfterWorkout/Running",
        "displayName": "User arrived to significant location after workout/running",
        "neuraId": "pul8nrqgh"
      },
      {
        "name": "userStartedRunning",
        "displayName": "User started running",
        "neuraId": "pylix0rx4"
      },
      {
        "name": "userFinishedWalking",
        "displayName": "User finished walking",
        "neuraId": "psxpf4fe4"
      },
      {
        "name": "userIsWalking",
        "displayName": "User is walking",
        "neuraId": "pqt7f4g0d"
      },
      {
        "name": "userIsIdle",
        "displayName": "User is idle",
        "neuraId": "praxizz37"
      },
      {
        "name": "userIsNoLongerIdle",
        "displayName": "User is no longer idle",
        "neuraId": "pcs8pb5r6"
      },
      {
        "name": "userWokeUp",
        "displayName": "User woke up",
        "neuraId": "pflbulvdw"
      },
      {
        "name": "userStartedSleeping",
        "displayName": "User started sleeping",
        "neuraId": "p6425ktr"
      },
      {
        "name": "userFinishedWorkOut",
        "displayName": "User finished work out",
        "neuraId": "ps70x1aze"
      },
      {
        "name": "userIsWorkingOut",
        "displayName": "User is working out",
        "neuraId": "pj2xcqwfp"
      },
      {
        "name": "userStartedWorkOut",
        "displayName": "User started work out",
        "neuraId": "pw2rtuuox"
      },
      {
        "name": "userArrivedAtActiveZone",
        "displayName": "User arrived at active zone",
        "neuraId": "ptk35d1n5"
      },
      {
        "name": "userFinishedDriving",
        "displayName": "User finished driving",
        "neuraId": "pdxo3q15x"
      },
      {
        "name": "userFinishedWorkOutInSignificantPlace",
        "displayName": "User finished work out in significant place",
        "neuraId": "pzgeclkwo"
      },
      {
        "name": "userIsWorkingOutInSignificantPlace",
        "displayName": "User is working out in significant place",
        "neuraId": "p23rwuxen"
      },
      {
        "name": "userIsAtActiveZone",
        "displayName": "User is at active zone",
        "neuraId": "p2epubdsh"
      },
      {
        "name": "userStartedWorkOutInSignificantPlace",
        "displayName": "User started work out in significant place",
        "neuraId": "pf5t9sw6o"
      },
      {
        "name": "userStartedDriving",
        "displayName": "User started driving",
        "neuraId": "pmxmrt9s8"
      },
      {
        "name": "userStartedWalking",
        "displayName": "User started walking",
        "neuraId": "p8u1k1zfb"
      },
      {
        "name": "userArrivedHome",
        "displayName": "User arrived home",
        "neuraId": "pa2png0au"
      },
      {
        "name": "userIsAtHome",
        "displayName": "User is at home",
        "neuraId": "p3kev1ojz"
      },
      {
        "name": "userIsOnTheWayToActiveZone",
        "displayName": "User is on the way to active zone",
        "neuraId": "pj8ks7amc"
      },
      {
        "name": "userLeftWork",
        "displayName": "User left work",
        "neuraId": "p94slwjji"
      },
      {
        "name": "userLeftGym",
        "displayName": "User left gym",
        "neuraId": "pmrgg9wbn"
      },
      {
        "name": "userLeftHome",
        "displayName": "User left home",
        "neuraId": "pg4itlqms"
      },
      {
        "name": "userLeftActiveZone",
        "displayName": "User left active zone",
        "neuraId": "pjg4i9vnk"
      },
      {
        "name": "userHasBeenIdleMoreThan60Minutes",
        "displayName": "User has been idle more than 60 minutes",
        "neuraId": "ppr22l3s6"
      },
      {
        "name": "userHasBeenSleepingMoreThan30Minutes",
        "displayName": "User has been sleeping more than 30 minutes",
        "neuraId": "p4c17y93p"
      },
      {
        "name": "userArrivedToSignificantLocationFromSignificantLocation",
        "description": "",
        "displayName": "User arrived to significant location from significant location",
        "neuraId": "pwnudrjpn"
      },
      {
        "name": "userHasBeenRunningMoreThan10Minutes",
        "displayName": "User has been running more than 10 minutes",
        "neuraId": "p23sa4tmi"
      },
      {
        "name": "userHasBeenWalkingMoreThan10Minutes",
        "displayName": "User has been walking more than 10 minutes",
        "neuraId": "pmc2xsw2i"
      },
      {
        "name": "userHasBeenActiveMoreThan30Minutes",
        "displayName": "User has been active more than 30 minutes",
        "neuraId": "po43xj8db"
      },
      {
        "name": "dailyActivitySummary",
        "description": "gives the user’s number of steps, calories, weight, heart rate variability etc per day",
        "displayName": "Daily activity summary",
        "neuraId": "pklnx21g9"
      },
      {
        "name": "activitySummaryPerPlace",
        "description": "Overview of users activity behaviors at the current place",
        "displayName": "Activity summary per place",
        "neuraId": "p39lf8xvf"
      },
      {
        "name": "wellnessProfile",
        "description": "Enables to receive average number of steps/calories per day and per time at work and at workout",
        "displayName": "Wellness profile",
        "neuraId": "pbpzhu02u"
      },
      {
        "name": "neuroskyHeartRateVariable",
        "description": "The service gives all the heart rate data measure collections per requested time period",
        "displayName": "Neurosky heart rate variable",
        "neuraId": "pjl0ncfil"
      },
      {
        "name": "sleepData",
        "description": "Gives the overview of user’s sleep data per requested period of time",
        "displayName": "Sleep data",
        "neuraId": "pukvfpsum"
      }
    ]
  }
}
        
##[Return to the Main Page](https://github.com/NeuraLabs/Neura_documentation#build-with-neura)
