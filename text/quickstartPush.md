
#Quickstart: Subscribe to events on Android
In this project you will use Neura's [3rd party Android demo app](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/DemoNeura3rdPartyApp.apk) to subscribe to Neura events on Android for `userStartedWalking` for your personal Neura user account.  [Instructions](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/quickstartPush.md#instructions) for this project are detailed below -- it should take you less than 5 minutes, if you've already set up your Neura user account; it **requires an account** with Neura and an Android phone.  

This project demonstrates Neura's ability to notify a third party app about user events. A practical application of this project would be to develop an app that reacts intelligently to users' actions in real time, such as turning on the lights when they wake up or locking the door when they leave home. 

##The response you'll receive
![Demo app event notifications](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/demoEventNotification.png)


##Instructions

###1. Install the apps
You must have both the [Neura app](https://theneura.prefinery.com/betas/4624/testers/new?display=inline&version=2) and the [third party Android demo app](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/DemoNeura3rdPartyApp.apk) for this project.  Be sure that you're logged into your Neura account -- it should like similar to the picture below.  If you need the password to access the Neura app, contact us at build [at] theneura [dot] com and be sure to note that you're working on this Quickstart project. 

![Both apps installed](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/demoAppsInPhone.png)  ![Working Neura app](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/demoNeuraApp2.png)

###2. Activate the demo app
Enter the following `APP UID`, `APP SECRET`, and `PERMISSION` name in the app and click **Neura authenticate**.  

> APP UID: 3b06106c458337babc3e0eaec4e8fd2fba19edd009d41ba422e518ff4b169766  
> APP SECRET: 95767dfa44a840db4a6666b2005943ff93a832f9c54cb34411ea602139b69e61  
> PERMISSION: userStartedWalking  

Your app should now look like this:

![Demo app with completed fields](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/demoCompletedFields.png)

###3. Take it for a spin
The `userStartedWalking` event is triggered when the user leaves the building and takes a walk outside.  After you walk about 100 meters out the door, the demo app will send you the notification.

------

### Wanna do more?
You can request other permissions and subscribe to more events including `userFinishedWalking`, `userStartedDriving`, and `userFinishedDriving`.  You can also copy your `accessToken` from this project and use it in the [Quickstart: request data](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/quickstartPull.md) project to view your own wellness information.


##Congrats on finishing this quickstart project! 
We hope it gives you a small taste of the power of Neura and motivates you to integrate your apps and IoT devices with Neura.  For next steps, [learn more](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/basics.md) about Neura or [set up a developer account](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/account.md).



