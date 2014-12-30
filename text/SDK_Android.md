

#Neura for iOS

Neura has built an [iOS app](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_iOS.md#1-ensure-your-users-have-the-neura-app) for users  available via TestFlight as well as an [iOS SDK](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/NeuraSDKiOS.zip?raw=true) and [demo app](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/NeuraiOSDemoSourceCode.zip?raw=true) for developers.  Add Neura to your app to enable it to request data objects for your users.  Currently, event notifications are only available for Android. 

### Here's how to integrate with Neura:  
  1.  [Get](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_Android.md#1-get-the-neura-app) the Neura app
  2. [Ensure your users have the Neura app](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_Android.md#2-ensure-your-users-have-the-neura-app)  
  2. [Register](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_iOS.md#2-register-your-app-with-neura) your app with Neura  
  3. [Add](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_iOS.md#3-add-neura-to-your-app) Neura to your app  
  4. [Query](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_iOS.md#4-query-data-objects-to-better-understand-your-users) Neura for data objects to better understand your users  

##  1. Get the Neura app  
[![Request access to Neura iOS on TestFlight](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/buttonRequestAccessiOS.png)](https://theneura.prefinery.com/betas/4631/testers/new?display=inline&version=2)

Currently, Neura for iOS is available only through TestFlight so you will need to [apply for access](https://theneura.prefinery.com/betas/4631/testers/new?display=inline&version=2).  When Neura grants you access, you'll need to (1) open the TestFlight invitation in your native iPhone Mail client and (2) create an account with Neura.  Please note that **users have been unable to install TestFlight with non-native mail clients**, such as Gmail and Sparrow.  If you need expedited access to the app, contact us at build [at] theneura [dot] com.
    
![Install Neura with TestFlight](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/HowToGetNeuraAppiOSFramed.png) ![TestFlight email in native iPhone mail](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/TestFlightIniPhoneMailFramed.png) ![TestFlight email in native iPhone mail](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/CreateNeuraAccountFramed.png)  

##  2. Ensure your users have the Neura app  
[![Request access to Neura iOS on TestFlight](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/buttonRequestAccessiOS.png)](https://theneura.prefinery.com/betas/4631/testers/new?display=inline&version=2)

Currently, Neura for iOS is available only through TestFlight so your users will need to [apply for access](https://theneura.prefinery.com/betas/4631/testers/new?display=inline&version=2).  When Neura grants them access, they'll need to (1) open the TestFlight invitation in a native iPhone Mail client and (2) create an account with Neura.  Please note that **users have been unable to install TestFlight with non-native mail clients**, such as Gmail and Sparrow.  If you need expedited access to the app, contact us at build [at] theneura [dot] com.
    
![Install Neura with TestFlight](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/HowToGetNeuraAppiOSFramed.png) ![TestFlight email in native iPhone mail](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/TestFlightIniPhoneMailFramed.png) ![TestFlight email in native iPhone mail](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/CreateNeuraAccountFramed.png)  


## 3. Register your app with Neura  
[![Register your app with Neura](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/buttonRegisterApp.png)](https://dev.theneura.com)  

If you don't already have a Neura user account, you need to first [get the Neura app](https://theneura.prefinery.com/betas/4631/testers/new?display=inline&version=2) and create a user account.  You only have one account with Neura -- we do not distinguish between a user account and a developer account.  If you need expedited access, contact us at build [at] theneura [dot] com.  

Once you have an account with Neura, register your app at [Neura's developer site](https://dev.theneura.com) -- login using the same email and password as your Neura user account.  After you register your app, Neura will provide you with the credentials you'll need to add Neura into your app.      

### 3.1 [Log in](https://dev.theneura.com) to Neura's developer website

![Neura's developer website](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/NeuraDevSite.png)  

### 3.2 Let Neura know about your app
[Provide](https://dev.theneura.com/#/register) your app name, company name, a brief description of your app, and an iOS Bundle ID.  Please note that **each iOS Bundle ID must be unique** -- you cannot use the same bundle ID for multiple apps.  
![register your app](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/Registration_page_top_iOS.png)

### 3.3 Declare permissions 
Declare the [Neura data objects](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/pull.md) that you might want permission to access.  During the authentication process, you will provide a subset of these permissions which Neura will ask your users to approve.  Currently, iOS apps only have access to data objects; [Neura event subscriptions](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md) are only available for Android.  
![Declare permissions](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/Registration_page_middle_permissions.png)

### 3.4 Register
The **Register** button is enabled only after you've completed all mandatory fields.  Information for successful registration is available in https://dev.theneura.com/#/manage. Please note that **you must click the App secret** to make it visible.  

![register app](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/Registration_page_bottom.png)

### 3.5 Example registration
In this example a developer from **3rd_party_developer, Inc.** created an app called **Demo_app_number_three** that relates to '*health and wellness*' and uses the iOS Bundle ID `com.neura.sample.auth3`. They have requested permission to access users' data objects: `dailyActivitySummary`, `wellnessProfile`, and `sleepData`. Neura provides the **App UID** `ABC123***********************************` and the **App secret** `xyz789***********************************`.    

![register app](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/ExampleAppRegistrationiOS.png)

##  4. Add Neura to your app 

[![Get the Neura SDK for iOS](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/buttonGetSDKiOS.png)](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/NeuraSDKiOS.zip?raw=true)  

### 4.1 Add Neura's SDK 
The [Neura SDK for iOS](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/NeuraSDKiOS.zip?raw=true) consists of the files **Neura.h** and **libNeura.a**, which you need to add to your app.  

### 4.2 Add the Neura URL schema
Open the `.plist` file. Under **URL Schemes** you need to create only one URL schema. Create your **URL Schema** by adding the prefix `neura` to the **App UID** that Neura gave you. For example, if the **App UID** is `ASDF1234*****************************` then the **URL schema** value is `neuraASDF1234*****************************`.  


### 4.3 Add authentication code
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

####Example: failed authentication where Neura returns an error 
`neuraASDF1234********************************://?error=“ERROR_APP_MISSING_PERMISSIONS"`

####All of Neura's error codes for iOS
•	`ERROR_CODE_USER_NOT_LOGGED_IN`    
•	`ERROR_APP_MISSING_PERMISSIONS`  
•	`ERROR_USER_DENIED_PERMISSIONS`  
•	`EXTRA_ERROR_CODE`  
•	`ERROR_NOT_AUTORIZED_APP_SIGNITURE`  

### 4.4 Request permission from the user to access their data
Once your users have the Neura app and you've added Neura to your app, the final step is for them to grant you permission to access their data.  When you feel it is the right time, run the **Neura authentication code**.  Once your users grant you permission once, they won't need to do so again. 


##  5. Query Neura for data objects to better understand your users  

Now that you have your user's permission and their unique `access_token` you can query Neura's API to [request data objects](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/pull.md).  For a brief tutorial, you can refer to the [Quickstart: request wellness information](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/quickstartPull.md) project. We're always happy to consider requests, so if you'd like data objects that aren't currently available, please let us know at build [at] theneura [dot] com. 

## [Return to the main page](https://github.com/NeuraLabs/Neura_documentation)




