#Neura for Android

Neura has built an [Android app](https://play.google.com/store/apps/details?id=com.neura.weave&hl=en) for users, available in the Google Play Store, as well as an [Android SDK
](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/NeuraAndroidSDK.jar) and an [Android demo app](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/DemoNeura3rdPartyApp.apk) with [source code](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/NeuraAndroidDemoSourceCode.zip) for developers.  Add Neura to your app to enable it to subscribe to events and request data objects for your users. 

### Here's how to integrate with Neura:  
  1. [Get](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_Android.md#2-ensure-your-users-have-the-neura-app) the Neura app 
  2. [Ensure](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_Android.md#1-ensure-your-users-have-the-neura-app) your users have the Neura app  
  3. [Register](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_Android.md#2-register-your-app-with-neura) your app with Neura  
  4. [Add](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_Android.md#3-add-neura-to-your-app-update-for-android) Neura to your app  
  5. [Query](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_Android.md#4-query-neura-for-data-objects-to-better-understand-your-users) Neura for data objects to better understand your users  
  6. [Subscribe](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_Android.md#5-subscribe-to-events-for-your-users-update-for-android) to events for your users

##  1. Get the Neura app [![Get Neura's Android app](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/buttonGetAndroidApp.png)](https://theneura.prefinery.com/betas/4624/testers/new?display=inline&version=2)

Currently, Neura's for Android app is in closed beta, so you must [apply for access here](https://theneura.prefinery.com/betas/4624/testers/new?display=inline&version=2).  After Neura grants you access, you'll need to launch the app, enter your password, and create an account with Neura. If you need expedited access to the app contact us at build [at] theneura [dot] com.   

![Install Neura with TestFlight](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/CreateNeuraAccountFramedAndroid.png)  ![Install Neura with TestFlight](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/EnterPasswordAndroid.png)  

**Developers must create a user account with an email and password**. [Neura's Developer site](https://dev.theneura.com) requires developers to login with their user credentials; if a developer creates an account with Facebook or Gmail, then they won't have the necessary credentials.
    
![Install Neura with TestFlight](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/createDevAccountAndroidFramed.png)  

## 2. Ensure your users have the Neura app
Direct your users to follow the instructions listed above in #1 to help them download and register for the Neura app. Your users must have both your app and the Neura app. If they don't have the Neura app with an active account then your app will not be able to enjoy the benefits of Neura.  Currently, Neura's for Android app is in closed beta, meaning that users will receive a password after they [apply for access](https://theneura.prefinery.com/betas/4624/testers/new?display=inline&version=2).  After Neura grants them access, they'll need to launch the app, enter their password, and create an account with Neura. If you need expedited access to the app contact us at build [at] theneura [dot] com.   

## 3. Register your app with Neura  
[![Register your app with Neura](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/buttonRegisterApp.png)](https://dev.theneura.com)  

If you don't already have a Neura user account, you need to first [get the Neura app]( ) and create a user account.  **Again, make sure that you create a user account using an email and password; do not select the Facebook or Gmail options.** You only have one account with Neura -- we do not distinguish between a user account and a developer account.  If you need expedited access, contact us at build [at] theneura [dot] com.  

Once you have an account with Neura, register your app at [Neura's developer site](https://dev.theneura.com) -- login using the same email and password as your Neura user account.  After you register your app, Neura will provide you with the credentials (`App UID` and `App Secret`) you'll need to add Neura into your app.      

### 3.1 [Log in](https://dev.theneura.com) to Neura's developer website

![Neura's developer website](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/NeuraDevSite.png)  

### 3.2 Let Neura know about your app
[Provide](https://dev.theneura.com/#/register) your app name, company name, a brief description of your app, package name, component class name, and key hash.     
![register your app](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/Registration_page_top_Android.png)

### 3.3 Declare permissions 
Declare the [Neura data objects](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/pull.md) and [Neura events](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md) that your app might want permission to access.  Later during the authentication process, you will specify a subset of these permissions that Neura will ask your users to approve.  Android apps have access to both events and data objects; iOS apps only have access to data objects.  
![Declare permissions](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/Registration_page_middle_permissions.png)

### 3.4 Register
The **Register** button is enabled only after you've completed all mandatory fields.  If your registration is successful, it will appear in https://dev.theneura.com/#/manage  

![register app](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/Registration_page_bottom.png)

### 3.5 Example registration
In this example a developer from **3rd_party_developer, Inc.** created an app called **Demo_app_number_seven** that relates to '*smart home*' and uses the Component Name `com.3rd_party.demo.demo.NeuraReceiver`, Package Name `com.3rd_party`, and Key Hash `12344321`.  They have declared permission for events `userFinishedWalking`, `userFinishedDriving`, `userStartedDriving`, and `userStartedWalking` as well as the data objects `dailyActivitySummary` and `sleepData`.  Neura provides the **App UID** `ABC123***********************************` and the **App secret** `xyz789***********************************`.   Please note that **you must click the App secret** to make it visible.   

![register app](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/ExampleAppRegistrationAndroid.png)


##4. Add Neura to your app 

[![Get the Neura SDK for Android](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/buttonGetAndroidSDK.png)](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/NeuraAndroidSDK.jar?raw=true)  

[![Get the Neura Demo app for Android - source code](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/buttonGetAndroidDemoSourceCode.png)](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/NeuraAndroidDemoSourceCode.zip?raw=true)  

### 4.1 Review the source code in Neura's demo app
We've created [NeuraAndroidDemoSourceCode.zip](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/NeuraAndroidDemoSourceCode.zip) for you to view in your favorite Java IDE ([Eclipse](https://eclipse.org/), [Android Studio](https://developer.android.com/sdk/index.html), etc.) so that you can see a working 3rd party app in action.  The app is simple: it allows a user to enter credentials to subscribe to events and get an `accessToken` to query data objects.  We've heavily commented the classes `MainActivity.java` and `NeuraReceiver.java` so that it's clear what's going on.

### 4.2 Add Neura's SDK 
The [Neura SDK for Android](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/NeuraAndroidSDK.jar) consists of the file **NeuraAndroidSDK.jar**, which you need to add to your app.  The Neura SDK requries the Platform API level to be version 15 (Ice Cream Sandwich) or higher. Also, ensure the SDK android is version 19 or higher. Make sure that the **.jar** file is under `lib`. If you have trouble compiling, be sure to update your Android SDK Manager. 

### 4.3 Add authentication code
Add the following **authentication code** to your app to authenticate with the Neura app. You need replace your **App ID** (`ABC123***********************************`) and **App Secret** (`xyz789***********************************`) with your unique credentials as well as the **permmissions** list (`userStartedWalking` and `dailyActivitySummary`) with a subset of the permissions you declared. All of your app information is available at https://dev.theneura.com/#/manage:

```java
	// Authenticate with Neura, where the app launches authorization within the Neura app -- the user will see a Neura screen
	// Request from Neura an accessToken for this user for the requested permissions; the callback is onActivityResult
	// These permissions must be a subset of permissions you declared on Neura's developer website, https://dev.theneura.com/#/manage
	private void performNeuraAuthentication() {

		AuthenticationRequest authenticationRequest = new AuthenticationRequest();
		authenticationRequest.setAppId("ABC123***********************************");
		authenticationRequest.setAppSecret("xyz789***********************************");

		authenticationRequest.setPermissions(new ArrayList<String>() {{  
	  	  add("dailyActivitySummary");  
	     add("userStartedWalking");  
	  }};);
		
		boolean neuraInstalled = NeuraAuthUtil.authenticate(MainActivity.this,
			NEURA_AUTHENTICATION_REQUEST_CODE, authenticationRequest);
		
		// check whether the user has installed the Neura app. 
		// If not, we created a method for you in the Neura SDK to easily direct the user to the Play Store to get the app
		if (!neuraInstalled) {
			NeuraUtil.redirectToGooglePlayNeuraMeDownloadPage(this);
		}
	}
```	

### 4.4 Add authentication callback handling
When you run the **authentication code** your app will launch authentication in the Neura app.  After the user completes authentication with Neura, the Neura app will send you a callback to the `onActivityResult` function. 

```java
	// The demo app reacts to the callback of authentication request
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		// Hendeling callback of authentication request
		if (requestCode == NEURA_AUTHENTICATION_REQUEST_CODE) {
			if (resultCode == RESULT_OK) {
				String accessToken = NeuraAuthUtil.extractToken(data);
				Toast.makeText(MainActivity.this, "Authenticate Success!",
						Toast.LENGTH_SHORT).show();
			} else {
				int errorCode = data.getIntExtra(NeuraConsts.EXTRA_ERROR_CODE,
						-1);

				Toast.makeText(
						MainActivity.this,
						"Authenticate Failed: "
								+ NeuraUtil.errorCodeToString(errorCode),
						Toast.LENGTH_SHORT).show();
			}
		}
	}
```

## 5. Subscribe to events in the Android SDK 
After your user has authenticated with Neura, you can subscribe to the for which they granted you permission. Replace the **access token** (`asdf**************************`) with the `accessToken` that Neura sent you for the user, and the **event name** (`userStartedWalking`) with the event you want to subscribe to.     
```java
	// Subscribe to this app to receive events from Neura
	// In order to receive events, the user must have first granted permission
	private void registerToNeuraSpecificEvents(String accessToken, Context context, String eventName) {
		NeuraEventsRequest eventsReuest = new NeuraEventsRequest();
		eventsReuest.setAccessToken("asdf********************");

		eventsReuest.setEventName("userStartedWalking");

		/**
		 * App will stay registered to the event (even if the registered app is
		 * not running at all) until it will explicitly call
		 * NeuraUtil.unregisterEvent()...
		 */
		NeuraUtil.registerEvent(context, eventsReuest);
	}
```

### 5.1 Implement your `broadcastReceiver`  
Neura will broadcast to the `broadcatReceiver` that [you declared](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_Android.md#22-let-neura-know-about-your-app) as the **component name** both (1) a response to your subscription request and (2) events. You need to implement your `broadcastReceiver` to handle both broadcasts.  

```java
public class NeuraReceiver extends BroadcastReceiver {

	// Determine whether the broadcast is in response to the app registering an event or whether Neura is sending an event notification
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
          String error = NeuraUtil.errorCodeToString(errorCode);
          String message = "Registration to event " + eventName + " has failed! error = " + error;
          Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }

      } else {
        handleNeuraEvent(context, intent, eventName);
      }
    }
```
```java	
   // This event handler executes when Neura sends an event broadcast  
    // For the demo app, we simply have a notification pop up on the user's phone
    // In your app, we hope that you're much more creative. Turn on a light, lock a door, let the magic flow
    private void handleNeuraEvent(Context context, Intent intent, String eventName) {

        /**
         * the intent Bundle will contain key value pairs of additional parameters related to the event, according to the documentation
         */

        String title = "Neura Event";
        String message = "Event Accured: " + eventName + ", ";

        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = new Notification.Builder(context).setSound(uri).setSmallIcon(R.drawable.ic_launcher).setContentTitle(title)
                .setContentText(message).build();
        notificationManager.notify(45, notification);
    }
}
```

##6. Query Neura for data objects to better understand your users  

Now that you have your user's permission and their unique `access_token` you can query Neura's API to [request data objects](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/pull.md).  For a brief tutorial, you can refer to the [Quickstart: request wellness information](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/quickstartPull.md) project. We're always happy to consider requests, so if you'd like data objects that aren't currently available, please let us know at build [at] theneura [dot] com. 


##ProGuard
If you are using ProGuard on the release build of your app, you must add this snippet to your app's proguard-project.txt config file:
`-keepnames class * implements java.io.Serializable`

```
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    !static !transient <fields>;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}
```

##Error Codes
Neura's Android SDK has the following error codes:  

    public static final int ERROR_CODE_USER_NOT_LOGGED_IN = 1;
    public static final int ERROR_INVALID_APP_ID = 2;
    public static final int ERROR_USER_DENIED_PERMISSIONS = 3;
    public static final int ERROR_MISSING_ANDROID_PLATFORM = 4;
    public static final int ERROR_SERVER_ERROR = 5;
    public static final int ERROR_UNEXPECTED_SERVER_RESPONSE = 6;
    public static final int ERROR_NOT_AUTORIZED_APP_SIGNITURE = 7;
    public static final int ERROR_APP_MISSING_PERMISSIONS = 8;
    public static final int ERROR_NO_NETWORK = 9;
    public static final int ERROR_USER_CANCELED_AUTHENTICATION = 10;
    public static final int ERROR_ILLEGAL_PERMISSIONS = 11;

## [Return to the main page](https://github.com/NeuraLabs/Neura_documentation)
