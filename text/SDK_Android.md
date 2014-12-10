
#Neura for Android

Neura has built an [Android app available in the Play Store]( ) for users and an [Android SDK
for developers](jar_file_here).  Add Neura to your app to enable it to subscribe to events and request data objects for your users.  Currently, Neura event notifications are only available for Android; Neura does not offer event notifications for iOS. 

### Here's how to integrate with Neura:  
  1. [Ensure](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_Android.md#1-ensure-your-users-have-the-neura-app) your users have the Neura app  
  2. [Register](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_Android.md#2-register-your-app-with-neura) your app with Neura  
  3. [Add](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_Android.md#3-add-neura-to-your-app-update-for-android) Neura to your app  
  4. [Query](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_Android.md#4-query-neura-for-data-objects-to-better-understand-your-users) Neura for data objects to better understand your users  
  5. [Subscribe](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_Android.md#5-subscribe-to-events-for-your-users-update-for-android) to events for your users

##  1. Ensure your users have the Neura app  
[![Get Neura's Android app](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/buttonGetAndroidApp.png)](https://theneura.prefinery.com/betas/4624/testers/new?display=inline&version=2)

Currently, Neura's for Android app is in closed beta, meaning that users will receive a password after they [apply for access](https://theneura.prefinery.com/betas/4624/testers/new?display=inline&version=2).  After Neura grants them access, they'll need to (1) open the Android app and (2) create an account with Neura. If you need expedited access to the app contact us at build [at] theneura [dot] com.  

**Developers must create a user account with an email and password**. [Neura's Developer site](https://dev.theneura.com) requires developers to login with their user credentials; if a developer creates an account with Facebook or Gmail, then they won't have the necessary credentials.
    
![Install Neura with TestFlight](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/CreateNeuraAccountFramedAndroid.png)  ![Install Neura with TestFlight](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/createDevAccountAndroidFramed.png)

##  2. Register your app with Neura  
[![Register your app with Neura](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/buttonRegisterApp.png)](https://dev.theneura.com)  

If you don't already have a Neura user account, you need to first [get the Neura app]( ) and create a user account.  **Again, make sure that create a user account using an email and password, not Facebook or Gmail.** You only have one account with Neura -- we do not distinguish between a user account and a developer account.  If you need expedited access, contact us at build [at] theneura [dot] com.  

Once you have an account with Neura, register your app at [Neura's developer site](https://dev.theneura.com) -- login using the same email and password as your Neura user account.  After you register your app, Neura will provide you with the credentials (`App UID` and `App Secret`) you'll need to add Neura into your app.      

### 2.1 [Log in](https://dev.theneura.com) to Neura's developer website

![Neura's developer website](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/NeuraDevSite.png)  

### 2.2 Let Neura know about your app
[Provide](https://dev.theneura.com/#/register) your app name, company name, a brief description of your app, package name, component class name, and key hash.     
![register your app](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/Registration_page_top_Android.png)

### 2.3 Declare permissions 
Declare the [Neura data objects](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/pull.md) and [Neura events](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md) that your app might want permission to access.  Later during the authentication process, you will specify a subset of these permissions that Neura will ask your users to approve.  Android apps have access to both events and data objects; iOS apps only have access to data objects.  
![Declare permissions](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/Registration_page_middle_permissions.png)

### 2.4 Register
The **Register** button is enabled only after you've completed all manditory fields.  If your registration is successful, it will appear in https://dev.theneura.com/#/manage . Please note that **you must click the App secret** to make it visible.  

![register app](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/Registration_page_bottom.png)

### 2.5 Example registration
In this example a developer from **3rd_party_developer, Inc.** created an app called **Demo_app_number_seven** that relates to '*smart home*' and uses the Component Name `com.3rd_party.demo.demo.NeuraReceiver`, Package Name `com.3rd_party`, and Key Hash `12344321`.  They have declared permission for events `userFinishedWalking`, `userFinishedDriving`, `userStartedDriving`, and `userStartedWalking` as well as the data objects `dailyActivitySummary` and `sleepData`.  Neura provides the **App UID** `ABC123***********************************` and the **App secret** `xyz789***********************************`.    

![register app](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/ExampleAppRegistrationAndroid.png)




##  3. Add Neura to your app ***update for Android***

[![Get the Neura SDK for iOS]( )]( )  

### 3.1 Add Neura's SDK ***update for Android***
The [Neura SDK for Android]( b) consists of the files **Neura.h** and **libNeura.a**, which you need to add to your app.  

### 3.2 Add the Neura URL schema ***update for Android***
Open the `.plist` file. Under **URL Schemes** you need to create only one URL schema. Create your **URL Schema** by adding the prefix `neura` to the **App UID** that Neura gave you in the [registration process](https://github.com/NeuraLabs/Neura_documentation/tree/master/text/account.md). For example, if the **App UID** is `ASDF1234*****************************` then the **URL schema** value is `neuraASDF1234*****************************`.  


### 3.3 Add authentication code ***update for Android***
Add this authentication code to your app to activate authentication with the Neura app -- be sure to replace the example **App UID** and **App secret** with your unique credentials shown at https://dev.theneura.com/#/manage :
```Objective-C
// Neura authentication code
- (IBAction)startNeuraAuth:(id)sender {    
    [[Neura sharedInstance] setClientId:@"ABC123***********************************"]; // replace ABC123*********************************** with the App UID that Neura provides, shown at: https://dev.theneura.com/#/manage
    [[Neura sharedInstance] setClientSecretId:@"xyz789***********************************"]; // replace xyz789*********************************** with the App Secret that Neura provides, shown at: https://dev.theneura.com/#/manage
    [[Neura sharedInstance] setPermmisions:@"dailyActivitySummary, wellnessProfile,sleepData"]; //replace with the specific premissions you requested, shown at: https://dev.theneura.com/#/manage 
    
    // If there's an error in authenticating, Neura returns it here.
    NSError *error = nil;
    [[Neura sharedInstance] AuthenticationWithError:&error];
    if (error) {
        NSLog(@"Error: %@",error.userInfo[@"NSLocalizedDescription"]);
        self.label.text = error.userInfo[@"NSLocalizedDescription"];
    }
}
```
The callback from the Neura app will return either the user's `access_token` or an error message. The `access_token` is permanent and unique to the user. You must use it when requesting the user's data objects. 
####Example: successful authentication where Neura returns an `access_token`
`neuraASDF1234********************************://?access_token=“qwer4567************************"`  

####Example: failed authentication where Neura returns an error `neuraASDF1234********************************://?error=“ERROR_APP_MISSING_PERMISSIONS"`

####All of Neura's error codes for iOS
•	`ERROR_CODE_USER_NOT_LOGGED_IN`    •	`ERROR_APP_MISSING_PERMISSIONS`  •	`ERROR_USER_DENIED_PERMISSIONS`  •	`EXTRA_ERROR_CODE`  •	`ERROR_NOT_AUTORIZED_APP_SIGNITURE`  

### 3.4 Request permission from the user to access their data
Once your users have the Neura app and you've added Neura to your app, the final step is for them to grant you permission to access their data.  When you feel it is the right time, run the **Neura authentication code**.  Once your users grant you permission once, they won't need to do so again. 


##  4. Query Neura for data objects to better understand your users  

Now that you have your user's permission and their unique `access_token` you can query Neura's API to [request data objects](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/pull.md).  For a brief tutorial, you can refer to the [Quickstart: request wellness information](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/quickstartPull.md) project. We're always happy to consider requests, so if you'd like data objects that aren't currently available, please let us know at build [at] theneura [dot] com. 

## 5. Subscribe to events for your users ***update for Android***



------


[![Neura Android SDK](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/android-sdk-image.jpg)](https://github.com/NeuraLabs/Neura_documentation/tree/master/resources/Neura_Android_SDK)

***Android demo app APK vs. source code -- make sure the devs have a link to the source code (do the same for the iOS sample project)***

What to do:
- open source code for sample project
- make sure the .jar file is there under lib


If you have trouble compiling, be sure to update your Android SDK Manager. 

The Neura SDK requries the Platform API level to be version 15 (Ice Cream Sandwich) or higher.


- SDK android version 19


***reminder for Chiki, send mikimer a new jar file***


-------------


You can add the Neura SDK for Android to your app so that your app can request PUSH event notifications and issue requests for data objects from Neura.  Your users will need to install the [Neura app from Google Play](https://play.google.com/store/apps/details?id=com.neura.weave&hl=en).  Once your users have installed the Neura app, they'll need to grant you permission to access their events and data objects.

[**Download Neura's Android SDK here**](https://github.com/NeuraLabs/Neura_documentation/tree/master/resources/Neura_Android_SDK)

##Authentication
The Neura Android SDK has the method `NeuraAuthUtil.authenticate` that handles authentication flow, which consists of two steps:

1.	The method verifies whether the Neura app is installed on the user's phone and returns a boolean value.
    - If `FALSE` then the method fails. You should prompt the user to download the Neura app. SDK gives util with method that redirects to the app in Google Play. 
    - If `TRUE` then the method proceeds to step 2.
2.	The method opens the authentication flow and prompts the user for authentication credentials and permissions.  

The callback of the method is the authentication result using the `Activity.onActivityResult` method, as detailed in the Android developers guide: http://developer.android.com/reference/android/app/Activity.html#onActivityResult(int, int, android.content.Intent)

Your application can identify the Neura callbacks by using the `requestCode` that was provided in the method `NeuraAuthUtil.authenticate`.  If authentication is successful then Neura returns an access token, `NeuraAuthUtil.extractToken`. The access token is permanent and can be used for subscribing to PUSH event notifications or to issue a request for a data object.  If authentication fails, then Neura returns an error code.

##Class and method descriptions for authentication

###`NeuraAuthUtil.authenticate` method
`Boolean NeuraAuthUtil.authenticate(Context context, int requestCode, AuthenticationRequest authenticationRequest);` 

`Context`: Context of Activity, which must be Activity Context.  
`requestCode`: request code to identify  
`onActivityResult()`: callback for Neura authentication.  
`authenticationRequest`: AuthenticationRequest instance.  

###`AuthenticationRequest` class
`public class AuthenticationRequest`

`java.lang.String getAppId()` This is the `accessToken` that was requested and received during app registration  
`void setAppId(java.lang.String appId)`   
`void setAppSecret(java.lang.String app_secret)`  
`void setPermissions(java.util.ArrayList<Permission> permissions)`   

###`Permission` class
`public class Permission`  
`boolean equals(java.lang.Object o)`   
`static Permission fromJson(JSONObject jsonObject)`   
`java.lang.String getId()`  
`java.lang.String getName()`  
`boolean isGrantedByUser()`   
`void setGrantedByUser(boolean granted)` 	  
`void setId(java.lang.String id)`   
`void setName(java.lang.String name)`   
`JSONObject toJson() `  

### Example authentication call:
```java
private void performNeuraAuthentication() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        authenticationRequest.setAppId(APP_ID);
        authenticationRequest.setAppSecret(APP_SECRET);
        ArrayList<Permission> permisions = Permission.list(new String[] {
                "userWokeUp", "userLeftGym", "userLeftHome", "userFinishedWalking", "userStartedDriving", "userIsAtWork", "userIsRunning",
                "userStartedCycling", "userIsDriving", "userIsWalking", "userFinishedRunning"
        });
        authenticationRequest.setPermissions(permisions);
        boolean neuraInstalled = NeuraAuthUtil.authenticate(this, NEURA_AUTHENTICATION_REQUEST_CODE, authenticationRequest);
        if (!neuraInstalled) {
            NeuraUtil.redirectToGooglePlayNeuraMeDownloadPage(this);
        }
    }
```

###Example authentication result 
```java
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NEURA_AUTHENTICATION_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String accessToken = NeuraAuthUtil.extractToken(data);
                saveAccessTokenPersistent(accessToken);
                Toast.makeText(MainActivity.this, "Authenticate Success!", Toast.LENGTH_SHORT).show();
                // Put here whatever code you want to execute after you acquire the access token from Neura
                refreshUi(); // For now, we just refresh the UI to represent the new state
            } else {
                int errorCode = data.getIntExtra(NeuraConsts.EXTRA_ERROR_CODE, -1);
                // TODO handle one of the error codes described in the documentation
                /**
                 * in general, this can happen if user denied permissions, there is no network, one of the parameter supplied in the authentication
                 * was wrong or missing, and other error codes as described in the documentation...
                 */
            }
        }
    }
```

##Subscribe to event notifications
Your apps can subscribe to PUSH notifications for user events, as detailed in [API event subscriptions](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md), which includes Neura's current list of [available events](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md#events-available-for-push-notification-subscriptions) -- we're always adding more. 

**Clarify the paragraph below with Chiki. Walk me through how this works -- as it's written, it isn't clear.**
You can use the Android SDK to subscribe to and receive event notifications in the background. Neither the Neura app nor your app need to be in the foreground for subscribing to or receiving notifications. 
You can use the `NeuraUtil.registerEvent` method for subscribing to events. In order to subscribe to even the mobile device must have network in order to register the events subscription in Neura Server by Neura.me application. In the case of no network connectivity the subscription fails and must be performed later again. 
`BroadcastReceiver` class is used for method callback that indicates if the subscription was successful or not. `BroadcastReceiver` class must be provided in the Registration process in Neura developer console http://dev.theneura.com 
`BroadcastReceiver` is also used for receiving the events.



Class and Method Descriptions

void NeuraUtil.registerEvent(Context context, NeuraEventsRequest request); 
Description:
PARAMETER	COMMENTS
Context	Any Context (not have to be Activity Context)
Request	NeuraEventsRequest instance

###`NeuraEventsRequest` class
`public class NeuraEventsRequest`

`java.lang.String getAccessToken()`   
`java.lang.String getEventId()`   
`Void setAccessToken(java.lang.String accessToken)` Retrieved from Neura Authentication Request process
`Void setEventId(java.lang.String eventId)` Unique Neura Event that user’s application wishes to subscribe to The list is described in Neura developer console. The current document gives also the sample list. **should this be eventId or <eventId> to indicate that the dev needs to replace <eventId>?**

###Example of `NeuraEventsRequest`
Note that `eventsReuest`, not "eventsRequest," is correct.
```java
private void registerToNeuraSpecificEvents(String accessToken, Context context, String eventId) {
        NeuraEventsRequest eventsReuest = new NeuraEventsRequest();
        eventsReuest.setAccessToken(accessToken);
        /**
         * list of all events ID's listed in the Neura developer web console.
         */
        eventsReuest.setEventId(eventId);
        /**
         * app will stay registered to the event (even if the registered app is not running at all)      *until it will explicitly call unsubscribe event NeuraUtil.unregisterEvent().
           */
        NeuraUtil.registerEvent(context, eventsReuest);
}
```

###Example subscription result 
```java
public class NeuraReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String eventName = intent.getStringExtra(NeuraConsts.EXTRA_EVENT_NAME);
        if (action.equalsIgnoreCase(NeuraConsts.ACTION_EVENT_REGISTRATION_RESPONSE)) {
            boolean success = intent.getBooleanExtra(NeuraConsts.EXTRA_SUCCESS, false);
            if (success) {
                Toast.makeText(context, "Registered successfully to event " + eventName, Toast.LENGTH_LONG).show();
            } else {
                int errorCode = intent.getIntExtra(NeuraConsts.EXTRA_ERROR_CODE, -1);
                Toast.makeText(context, "Registration to event " + eventName + " has failed! errorCode = " + errorCode, Toast.LENGTH_LONG).show();
            }
        } else {
            handleNeuraEvent(context, intent, eventName);
        }
    }
}
```

##Unsubscribe to event notifications
You can unsubscribe your app from event notifications.

`void NeuraUtil.unregisterEvent (Context context, NeuraEventsRequest request);` 

`context` Any Android Context class (it does not have to be Activity Context)  
`request` `NeuraEventsRequest` instance

###Example unsubscribe from event notifications
**Is the code sample supposed to say "reuest" instead of "request"?**
```java
    private void unregisterEvent(String accessToken, Context context, String eventId) {
        NeuraEventsRequest eventsReuest = new NeuraEventsRequest();
        eventsReuest.setAccessToken(accessToken);
        eventsReuest.setEventId(eventId);
        NeuraUtil.unregisterEvent(context, eventsRequest);
    }
```

##ProGuardIf you are using ProGuard on the release build of your app, you must add this snippet to your app's proguard-project.txt config file:`-keepnames class * implements java.io.Serializable````
-keepclassmembers class * implements java.io.Serializable {    static final long serialVersionUID;    private static final java.io.ObjectStreamField[] serialPersistentFields;    !static !transient <fields>;    private void writeObject(java.io.ObjectOutputStream);    private void readObject(java.io.ObjectInputStream);    java.lang.Object writeReplace();    java.lang.Object readResolve();}
```

##Error CodesNeura's Android SDK has the following error codes:  
    public static final int ERROR_CODE_USER_NOT_LOGGED_IN = 1;    public static final int ERROR_INVALID_APP_ID = 2;    public static final int ERROR_USER_DENIED_PERMISSIONS = 3;    public static final int ERROR_MISSING_ANDROID_PLATFORM = 4;    public static final int ERROR_SERVER_ERROR = 5;    public static final int ERROR_UNEXPECTED_SERVER_RESPONSE = 6;    public static final int ERROR_NOT_AUTORIZED_APP_SIGNITURE = 7;    public static final int ERROR_APP_MISSING_PERMISSIONS = 8;    public static final int ERROR_NO_NETWORK = 9;    public static final int ERROR_USER_CANCELED_AUTHENTICATION = 10;    public static final int ERROR_ILLEGAL_PERMISSIONS = 11;



---------

#Internal issues to discuss:

1. **Chiki, why don't we start by showing the Neura libraries to include? Don't devs need to first include libraries?**
2. I replaced `authorization key` with `accessToken` is that ok?
3. 


##remove internal issues before publishing


























