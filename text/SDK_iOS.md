
#Neura for iOS

Neura has built an iOS app for users, [available via TestFlight](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_iOS.md#1-ensure-your-users-have-the-neura-app), and an [iOS SDK
available for download here](https://github.com/NeuraLabs/neura_ios_sdk/tree/master/SampleProject/NeuraAuthSampleApp/lib).  Add the Neura SDK to your app to enable it to request data objects for your users.  Neura is event notifications for iOS; currently, event notifications are only available for Android. 

### Here's how to integrate with Neura:  
  1. Ensure your users have the Neura app  
  2. Register your 3rd party app with Neura  
  3. Add authentication code into your app  
  4. Request data objects to better understand your users  

##  1. Ensure your users have the Neura app  
[![Request access to Neura iOS on TestFlight](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/buttonRequestAccessiOS.png)](https://theneura.prefinery.com/betas/4631/testers/new?display=inline&version=2)

Currently, Neura for iOS is available only through TestFlight so your users will need to [apply for access](https://theneura.prefinery.com/betas/4631/testers/new?display=inline&version=2).  When Neura grants them access, they'll need to (1) open the TestFlight invitation in their native iPhone Mail client and (2) create an account with Neura.  Please note that **users have been unable to install TestFlight with non-native mail clients**, such as Gmail and Sparrow.  If you need expedited access to the app contact us at build [at] theneura [dot] com.
    
![Install Neura with TestFlight](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/HowToGetNeuraAppiOSFramed.png) ![TestFlight email in native iPhone mail](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/TestFlightIniPhoneMailFramed.png) ![TestFlight email in native iPhone mail](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/CreateNeuraAccountFramed.png)  

##  2. Register your 3rd party app with Neura  
[![Register your app with Neura](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/buttonRegisterApp.png)](https://dev.theneura.com)  

If you don't already have a Neura user account, you need to first [get the Neura app](https://theneura.prefinery.com/betas/4631/testers/new?display=inline&version=2) and create a user account.  If you need expedited access, contact us at build [at] theneura [dot] com.  
Register your app with Neura at the [Neura's developer site](https://dev.theneura.com) -- login using the same email and password as your Neura user account.  After you register your app, Neura will provide you with the credentials you'll need to integrate Neura into your app.      

###Log in to Neura's developer website

![Neura's developer website](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/NeuraDevSite.png)  

###Let Neura know about your app
[Let us know](https://dev.theneura.com/#/register) your app name, company name, and a few other details.  Please note that each iOS Bundle ID must be unique.  
![register your app](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/Registration_page_top_iOS.png)

###Select Neura data objects
Select the [Neura data objects](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/pull.md) that you will want permission to access.  During the authentication process, Neura will ask your users to approve permission for you to access these data objects.  (Currently, [Neura event subscriptions](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md) are only available for Android.)  
![Select data objects](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/Registration_page_middle_data_objects.png)

### Register
The **Register** button is enabled only after you've completed all manditory fields.  
![register app](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/Registration_page_bottom.png)

### Example registration
In this example a developer from **3rd_party_developer, Inc.** created an app called **Demo_app_number_three** that relates to 'health and wellness' and uses the iOS Bundle ID `com.neura.sample.auth3`. They have requested permission to access users' data objects: `dailyActivitySummary`, `wellnessProfile`, and `sleepData`. 
![register app](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/ExampleAppRegistrationiOS.png)


##  3. Add authentication code into your app  


##  4. Request data objects to better understand your users  



-----


Your users will need to install the [app by requesting access to be a Neura beta tester on TestFlight](https://theneura.prefinery.com/betas/4631/testers/new?display=inline&version=2).  

Once your users have installed the Neura app, they'll need to grant you permission to access their events and data objects.


##1. Register your app with Neura
explain how this works. 
key is this returns app UID, app secret, all permission requests

###2. Create your URL schemaOpen the `.plist` file. Under **URL Schemes** you need to create only one URL schema. Create your **URL Schema** by adding the prefix `neura` to the **App UID** that Neura gave you in the [registration process](https://github.com/NeuraLabs/Neura_documentation/tree/master/text/account.md). For example, if the **App UID** is `ASDF1234*****************************` then the **URL schema** value is `neuraASDF1234*****************************`.  

##SetThe authentication call requires 
Example:  ```Objective-C

    [[Neura sharedInstance] setClientId:@"351b465f35f56ae81fb450963c6110711bdb89fae2ee30fe7dfee876705d3a2c"]; // this is the App UID that Neura provides
    [[Neura sharedInstance] setClientSecretId :@"fc5fff21361d0dde7e6a1fa1558906f36c5c841b58d157cb61208710ccaf27d2" ]; // this is the App Secret that Neura provides
    [[Neura sharedInstance] setPermmisions:@"userIsRunning,userArrivedToSignificantLocationFromActiveZone,userStartedWalking"]; //these are the permissions that you requested for the app, which Neura echos in the manage apps page: https://dev.theneura.com/#/manage

```
**copy & paste actual code.**###Authentication The authentication method has 2 tasks:1.	The Neura SDK verifies if the Neura app is installed on the user's phone. 
	1a. If the user does not have the Neura app, authentication immediately returns an error. 	
	***yes, it's testflight. 
	SDK just returns an error.
	We suggest that you, the developer, direct your user to TestFlight to get the Neura app (link), but that's up to you.***
	2.	If the user has the Neura app, then the Neura app takes the user through the authentication and permissions process. Example:  ` [[Neura sharedInstance] AuthenticationWithError:&error];`***insert pics of the authentication processs***## Neura error messages•	`ERROR_CODE_USER_NOT_LOGGED_IN`    •	`ERROR_APP_MISSING_PERMISSIONS`  •	`ERROR_USER_DENIED_PERMISSIONS`  •	`EXTRA_ERROR_CODE`  •	`ERROR_NOT_AUTORIZED_APP_SIGNITURE`  ###Access Token The callback from the Neura app to the 3rd party app returns the access token or error with the reason of failure. The access token is permanent and unique to the user. You must use it to subscribe to access the user's events and data objects. 

```Objective-C -(BOOL)application:(UIApplication *)application  
             openURL:(NSURL *)url
 sourceApplication:(NSString *)sourceApplication  
          annotation:(id)annotation```
***the variable is returned as a `url`***
this is how it's returned:
neura594d5148be1d1ab5cc767018bfa27cf6224e871ad8e2a71e3b8d3eb6054cefa1://?access_token=4f982f3f276f6753a1f29595e7138591919348dd92a46d2f4e8103d0a527459f

The access token is given per Neura client_id:Example of access token: 
`neuraASDF1234********************************://?access_token=“qwer7890************************"`  
Example of authentication error:  
`neuraASDF1234********************************://?error=“ERROR_APP_MISSING_PERMISSIONS"`



------

##AuthenticationTo authenticate the user, Neura's SDK makes a call to the Neura app on the user's phone which takes the user through the authentication process. Your client app will go through the following steps, detailed below:1.	**Set** the **App UID**, **App secret** and client permissions2.	**Call** the authentication **What are we trying to say here? 'initiate authentication in the Neura app'?**  3.	**Receive** the access token from the Neura app  **I love this structure, but it doesn't align wiht the headers below. Make it align!**

------------

# Internal Neura notes

fix throughout. iOS uses `access_token` whereas Android uses `accessToken`.  Let's pick one convention and use it consistently throughout.

Account creation. Let's simplify and be consistent: remove the **sign up** option and simply require users to **sign in** with their Neura user credentials.   



