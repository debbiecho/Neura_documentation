
#Build with Neura 
Neura provides context. We distill raw data into contextual knowledge ***to help you*** make **smarter** apps and internet-of-things (IoT) devices.  

###Neura is ready ***to help*** you to build awesome apps
You can use the Neura API and SDKs to securely access user data by subscribing to PUSH events or requesting data objects.  User privacy is critical to us, so we ensure that users have approved access to their data with OAuth2 authentication.

### Get started in minutes
 - [Quickstart: Request wellness information for a user](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/quickstartPull.md) (5-minute project) _100% done!_
 - [Quickstart: Subscribe to a push notification for **Android**](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/quickstartPush.md) (??-minute project) _70% done -- mikimer & chiki to get app working again_
 - [Quickstart: Authenticate a user as a 3rd party app for **iOS**](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/quickstart_iOS.md) (5-minute project) _90% done -- update with new demo app image_


### Learn more
 - [An introduction to Neura](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/basics.md)  _80% done. clarify time & timezones_   
 - [Create a developer account](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/account.md) _30% done - eroc is on it_
 - [Authentication and permissions](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/authentication.md) _40% done - mikimer & berman to complete_
 - [API data objects](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/pull.md) _90% done. a few questions for Berman_  
 - [API event subscriptions](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md)  _50% done. Berman to fill in_ 
 - [SDK for Android](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_Android.md) _80% done. a few things to clarify with chiki_ 
 - [SDK for iOS](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_iOS.md) _60% done. clarify a few things with Michael_   
 - [Integrated devices that can send data to Neura](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/integrations.md) _100% done!_ 
 - [Current status of the Neura API](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/status.md) _80% done. Mikimer to chat with Triinu & Berman about how to maintain this page_ 

### Questions? Comments? Wanna grab a beer?
Reach out to us at build [at] theneura [dot] com.  We're serious about the :beer:.


----------------

#Internal Neura notes 
Mikimer has moved the API and SDK docs from Word to Github to (1) make it easier to collaborate, (2) improve formatting and readability, and (3) to create an MVP that's ready for public release.

Plans:  
- Mikimer will own this document until further notice
- Anyone else editing the doc will submit change to Mikimer for approval
- Mikimer will flag Issues for team members to address  


The source documents were:  
  - NEURA.ME API Integration Guide ver 2.docx    
  - NEURA.ME Android Integration Guide.docx  
  - NEURA ME iOS Integration Guide.docx

Throughout the document ***I've embedded italics-bold text with questions for whoever wrote the original text***.  I'm planning on sitting down with the tech team to get answers to these questions when I'm in Israel Nov 30th to Dec 12th 2014.  I'd LOVE IT if you forked the original documents and responded to these questions.  Eroc quickly became a master of the fork and pull request, so I'm confident the tech team can do it too, hehe ;)

Conventions:  
- states - instantaneous (1 sec?) moment where Neura returns where the user is / what they're doing PULL **Next step: Berman to chat w/ Ori about distinguishing between States & Events.  As of today, there are no 'States' available in the API -- we developed userIsWalking it's disabled until further notice.**
- events - change in state PUSH
- data objects - dataset for the user during a period of time PULL. **Mike to talk w/ Gilad & Ori**

Big To Do's
- Get Android sample app working. https://github.com/NeuraLabs/Neura_documentation/blob/master/text/quickstartPull.md#examine-your-own-daily_summary-data
- Go through PUSH subscription & document https://github.com/NeuraLabs/Neura_documentation/blob/master/text/quickstartPush.md 
- Go through time & timezones in Neura. Document edge cases.  


###delete internal notes before public release



#Quickstart: Subscribe to event PUSH notifications on Android
In this project you will subscribe to the Neura event PUSH notifications on Android for `userStartedWalking` for ***your personal Neura account***.  [Instructions](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/quickstartPush.md#instructions) for this project are detailed below. It should take you ***fewer*** than **XX** minutes if you've already set up your Neura account. It **requires an account** with Neura and an Android phone.

_**Get help from chiki. the sample app broke again -- i didn't get the confirmation for registration. what'd i do wrong?**_

##The response you'll recieve
![Demo app event notifications](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/demoEventNotification.png)


##Instructions

###1. Install the apps
You must have both the [Neura app](https://theneura.prefinery.com/betas/4624/testers/new?display=inline&version=2) and the [demo app](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/DemoNeura3rdPartyApp.apk) for this project.  

![Both apps installed](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/demoAppsInPhone.png)

####Be sure to activate your account with Neura.   
If you need the password to access the Neura app, contact us at build [at] theneura [dot] com and be sure to note that you're working on this project. Your Neura app should look similar to this:

![Working Neura app](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/demoNeuraApp.png)

###2. Activate the demo app
Enter the following `APP ID`, `APP SECRET`, and `PERMISSION` name in the app and click `Neura authenticate`.  

> APP ID: 3b06106c458337babc3e0eaec4e8fd2fba19edd009d41ba422e518ff4b169766  
> APP SECRET: 95767dfa44a840db4a6666b2005943ff93a832f9c54cb34411ea602139b69e61  
> PERMISSION: userStartedWalking  

Your app should now look like this:

![Demo app with completed fields](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/demoCompletedFields.png)

###3. Take it for a spin
The `userStartedWalking` event is triggered when the user leaves the building and takes a walk outside.  After you walk about 100 meters out the door, the demo app will send you a notification.

### Wanna do more?
request other permissions
use your accessToken to get your own data objects  
_**mike to draft this**_

##Congrats on finishing the quickstart project! 
We hope it gives you a small taste of the power of Neura and motivates you to integrate your apps and IoT devices with Neura.  For next steps, [learn more](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/basics.md) about Neura or [set up a developer account](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/account.md).


















#Build with Neura 
Neura provides context. We distill raw data into contextual knowledge so that you can make **smarter** apps and internet-of-things (IoT) devices.  

###Neura is ready ***to help*** you to build awesome apps
You can use the Neura API and SDKs to securely access user data by subscribing to PUSH events or requesting data objects.  User privacy is critical to us, so we ensure that users have approved access to their data with OAuth2 authentication.

### Get started in minutes
 - [Quickstart: Request wellness information for a user](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/quickstartPull.md) (5-minute project) _100% done!_
 - [Quickstart: Subscribe to a push notification for **Android**](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/quickstartPush.md) (??-minute project) _70% done -- mikimer & chiki to get app working again_
 - [Quickstart: Authenticate a user as a 3rd party app for **iOS**](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/quickstart_iOS.md) (5-minute project) _90% done -- update with new demo app image_


### Learn more
 - [An introduction to Neura](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/basics.md)  _80% done. clarify time & timezones_   
 - [Create a developer account](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/account.md) _30% done - eroc is on it_
 - [Authentication and permissions](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/authentication.md) _40% done - mikimer & berman to complete_
 - [API data objects](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/pull.md) _90% done. a few questions for Berman_  
 - [API event subscriptions](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md)  _50% done. Berman to fill in_ 
 - [SDK for Android](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_Android.md) _80% done. a few things to clarify with chiki_ 
 - [SDK for iOS](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_iOS.md) _60% done. clarify a few things with Michael_   
 - [Integrated devices that can send data to Neura](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/integrations.md) _100% done!_ 
 - [Current status of the Neura API](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/status.md) _80% done. Mikimer to chat with Triinu & Berman about how to maintain this page_ 

### Questions? Comments? Wanna grab a beer?
Reach out to us at build [at] theneura [dot] com.  We're serious about the :beer:.


----------------

#Internal Neura notes 
Mikimer has moved the API and SDK docs from Word to Github to (1) make it easier to collaborate, (2) improve formatting and readability, and (3) to create an MVP that's ready for public release.

Plans:  
- Mikimer will own this document until further notice
- Anyone else editing the doc will submit change to Mikimer for approval
- Mikimer will flag Issues for team members to address  


The source documents were:  
  - NEURA.ME API Integration Guide ver 2.docx    
  - NEURA.ME Android Integration Guide.docx  
  - NEURA ME iOS Integration Guide.docx

Throughout the document ***I've embedded italics-bold text with questions for whoever wrote the original text***.  I'm planning on sitting down with the tech team to get answers to these questions when I'm in Israel Nov 30th to Dec 12th 2014.  I'd LOVE IT if you forked the original documents and responded to these questions.  Eroc quickly became a master of the fork and pull request, so I'm confident the tech team can do it too, hehe ;)

Conventions:  
- states - instantaneous (1 sec?) moment where Neura returns where the user is / what they're doing PULL **Next step: Berman to chat w/ Ori about distinguishing between States & Events.  As of today, there are no 'States' available in the API -- we developed userIsWalking it's disabled until further notice.**
- events - change in state PUSH
- data objects - dataset for the user during a period of time PULL. **Mike to talk w/ Gilad & Ori**

Big To Do's
- Get Android sample app working. https://github.com/NeuraLabs/Neura_documentation/blob/master/text/quickstartPull.md#examine-your-own-daily_summary-data
- Go through PUSH subscription & document https://github.com/NeuraLabs/Neura_documentation/blob/master/text/quickstartPush.md 
- Go through time & timezones in Neura. Document edge cases.  


###delete internal notes before public release



#Quickstart: Subscribe to event PUSH notifications on Android
In this project you will subscribe to the Neura event PUSH notifications on Android for `userStartedWalking` for ***your personal Neura account***.  [Instructions](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/quickstartPush.md#instructions) for this project are detailed below. It should take you ***fewer*** than **XX** minutes if you've already set up your Neura account. It **requires an account** with Neura and an Android phone.

_**Get help from chiki. the sample app broke again -- i didn't get the confirmation for registration. what'd i do wrong?**_

##The response you'll recieve
![Demo app event notifications](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/demoEventNotification.png)


##Instructions

###1. Install the apps
You must have both the [Neura app](https://theneura.prefinery.com/betas/4624/testers/new?display=inline&version=2) and the [demo app](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/DemoNeura3rdPartyApp.apk) for this project.  

![Both apps installed](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/demoAppsInPhone.png)

####Be sure to activate your account with Neura.   
If you need the password to access the Neura app, contact us at build [at] theneura [dot] com and be sure to note that you're working on this project. Your Neura app should look similar to this:

![Working Neura app](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/demoNeuraApp.png)

###2. Activate the demo app
Enter the following `APP ID`, `APP SECRET`, and `PERMISSION` name in the app and click `Neura authenticate`.  

> APP ID: 3b06106c458337babc3e0eaec4e8fd2fba19edd009d41ba422e518ff4b169766  
> APP SECRET: 95767dfa44a840db4a6666b2005943ff93a832f9c54cb34411ea602139b69e61  
> PERMISSION: userStartedWalking  

Your app should now look like this:

![Demo app with completed fields](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/demoCompletedFields.png)

###3. Take it for a spin
The `userStartedWalking` event is triggered when the user leaves the building and takes a walk outside.  After you walk about 100 meters out the door, the demo app will send you a notification.

### Wanna do more?
request other permissions
use your accessToken to get your own data objects  
_**mike to draft this**_

##Congrats on finishing the quickstart project! 
We hope it gives you a small taste of the power of Neura and motivates you to integrate your apps and IoT devices with Neura.  For next steps, [learn more](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/basics.md) about Neura or [set up a developer account](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/account.md).


















#Build with Neura 
Neura provides context. We distill raw data into contextual knowledge so that you can make **smarter** apps and internet-of-things (IoT) devices.  

###Neura is ready for you to build awesome apps
You can use the Neura API and SDKs to securely access user data by subscribing to PUSH events or requesting a data object.  User privacy is critical to us, so we ensure that users have approved your access to their data with OAuth2 authentication.

### Get started in minutes
 - [Quickstart: request wellness information for a user](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/quickstartPull.md) (5-minute project) _100% done!_
 - [Quickstart: subscribe to a push notification for **Android**](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/quickstartPush.md) (??-minute project) _70% done -- mikimer & chiki to get app working again_
 - [Quickstart: authenticate a user as a 3rd party app for **iOS**](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/quickstart_iOS.md) (5-minute project) _90% done -- update with new demo app image_


### Learn more
 - [An introduction to Neura](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/basics.md)  _80% done. clarify time & timezones_   
 - [Create a developer account](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/account.md) _30% done - eroc is on it_
 - [Authentication and permissions](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/authentication.md) _40% done - mikimer & berman to complete_
 - [API data objects](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/pull.md) _90% done. a few questions for Berman_  
 - [API event subscriptions](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md)  _50% done. Berman to fill in_ 
 - [SDK for Android](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_Android.md) _80% done. a few things to clarify with chiki_ 
 - [SDK for iOS](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_iOS.md) _60% done. clarify a few things with Michael_   
 - [Integrated devices that can send data to Neura](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/integrations.md) _100% done!_ 
 - [Current status of the Neura API](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/status.md) _80% done. Mikimer to chat with Triinu & Berman about how to maintain this page_ 

### Questions? Comments? Wanna grab a beer?
Reach out to us at build [at] theneura [dot] com.  We're serious about the :beer:.


----------------

#Internal Neura notes 
Mikimer has moved the API and SDK docs from Word to Github to (1) make it easier to collaborate, (2) improve formatting and readability, and (3) to create an MVP that's ready for public release.

Plans:  
- Mikimer will own this document until further notice
- Anyone else editing the doc will submit change to Mikimer for approval
- Mikimer will flag Issues for team members to address  


The source documents were:  
  - NEURA.ME API Integration Guide ver 2.docx    
  - NEURA.ME Android Integration Guide.docx  
  - NEURA ME iOS Integration Guide.docx

Throughout the document ***I've embedded italics-bold text with questions for whoever wrote the original text***.  I'm planning on sitting down with the tech team to get answers to these questions when I'm in Israel Nov 30th to Dec 12th 2014.  I'd LOVE IT if you forked the original documents and responded to these questions.  Eroc quickly became a master of the fork and pull request, so I'm confident the tech team can do it too, hehe ;)

Conventions:  
- states - instantaneous (1 sec?) moment where Neura returns where the user is / what they're doing PULL **Next step: Berman to chat w/ Ori about distinguishing between States & Events.  As of today, there are no 'States' available in the API -- we developed userIsWalking it's disabled until further notice.**
- events - change in state PUSH
- data objects - dataset for the user during a period of time PULL. **Mike to talk w/ Gilad & Ori**

Big To Do's
- Get Android sample app working. https://github.com/NeuraLabs/Neura_documentation/blob/master/text/quickstartPull.md#examine-your-own-daily_summary-data
- Go through PUSH subscription & document https://github.com/NeuraLabs/Neura_documentation/blob/master/text/quickstartPush.md 
- Go through time & timezones in Neura. Document edge cases.  


###delete internal notes before public release


