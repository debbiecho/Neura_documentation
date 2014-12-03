
#Neura SDK for Android

You can add the Neura SDK for Android to your app to that your app can request PUSH event notifications and issue PULL requests for data objects.  Your users will need to install the Neura app on their phones, available in Google Play `google play link` **add link**.  Once your users have installed the Neura app, they'll need to grant you permission to access their events and data objects.

**Chiki, why don't we start by showing the Neura libraries to include? Don't devs need to first include libraries?**

##Authentication
The Neura Android SDK has the method `NeuraAuthUtil.authenticate` that handles authentication flow, which consists of two steps:

1.	The method verifies whether the Neura app is installed on the user's phone and returns a boolean value.
    - If `FALSE` then the method fails. You should prompt the user to download the Neura app. SDK gives util with method that redirects to the app in Google Play. 
    - If `TRUE` then the method proceeds to step 2.
2.	The method opens the authentication flow and prompts the user for authentication credentials and permissions.  

The callback of the method is the authentication result using the `Activity.onActivityResult` method, as detailed in the Android developers guide: http://developer.android.com/reference/android/app/Activity.html#onActivityResult(int, int, android.content.Intent)

Your application can identify the Neura callbacks by using the `requestCode` that was provided in the method `NeuraAuthUtil.authenticate`.  If authentication is successful then Neura returns an access token, `NeuraAuthUtil.extractToken`. The access token is permanent and can be used for subscribing to PUSH event notifications or to issue a PULL request for a data object.  If authentication fails, then Neura returns an error code.

##Class and method descriptions for authentication

###`NeuraAuthUtil.authenticate` method
`Boolean NeuraAuthUtil.authenticate(Context context, int requestCode, AuthenticationRequest authenticationRequest);` 

`Context`: Context of Activity, which must be Activity Context.  
`requestCode`: request code to identify  
`onActivityResult()`: callback for Neura authentication.  
`authenticationRequest`: AuthenticationRequest instance.  

###`AuthenticationRequest` class
`public class AuthenticationRequest`

`java.lang.String getAppId()` This is the `accessToken`**correct?** that was requested and received during app registration  
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

###Example **of what?**
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






























