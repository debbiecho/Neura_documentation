
#Neura for iOS

Neura has built an [iOS app available via TestFlight](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_iOS.md#1-ensure-your-users-have-the-neura-app) for users and an [iOS SDK
for developers](https://github.com/NeuraLabs/neura_ios_sdk/tree/master/SampleProject/NeuraAuthSampleApp/lib).  Add Neura to your app to enable it to request data objects for your users.  Currently, Neura does not offer event notifications for iOS; event notifications are only available for Android. 

### Here's how to integrate with Neura:  
  1. [Ensure](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_iOS.md#1-ensure-your-users-have-the-neura-app) your users have the Neura app  
  2. [Register](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_iOS.md#2-register-your-app-with-neura) your app with Neura  
  3. [Add](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_iOS.md#3-add-neura-to-your-app) Neura to your app  
  4. [Query](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_iOS.md#4-query-data-objects-to-better-understand-your-users) data objects to better understand your users  

##  1. Ensure your users have the Neura app  
[![Request access to Neura iOS on TestFlight](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/buttonRequestAccessiOS.png)](https://theneura.prefinery.com/betas/4631/testers/new?display=inline&version=2)

Currently, Neura for iOS is available only through TestFlight so your users will need to [apply for access](https://theneura.prefinery.com/betas/4631/testers/new?display=inline&version=2).  When Neura grants them access, they'll need to (1) open the TestFlight invitation in their native iPhone Mail client and (2) create an account with Neura.  Please note that **users have been unable to install TestFlight with non-native mail clients**, such as Gmail and Sparrow.  If you need expedited access to the app contact us at build [at] theneura [dot] com.
    
![Install Neura with TestFlight](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/HowToGetNeuraAppiOSFramed.png) ![TestFlight email in native iPhone mail](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/TestFlightIniPhoneMailFramed.png) ![TestFlight email in native iPhone mail](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/CreateNeuraAccountFramed.png)  

##  2. Register your app with Neura  
[![Register your app with Neura](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/buttonRegisterApp.png)](https://dev.theneura.com)  

If you don't already have a Neura user account, you need to first [get the Neura app](https://theneura.prefinery.com/betas/4631/testers/new?display=inline&version=2) and create a user account.  You only have one account with Neura -- we do not distinguish between a user account and a developer account.  If you need expedited access, contact us at build [at] theneura [dot] com.  

Once you have an account with Neura, register your app at [Neura's developer site](https://dev.theneura.com) -- login using the same email and password as your Neura user account.  After you register your app, Neura will provide you with the credentials you'll need to add Neura into your app.      

### 2.1 [Log in](https://dev.theneura.com) to Neura's developer website

![Neura's developer website](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/NeuraDevSite.png)  

### 2.2 Let Neura know about your app
[Provide](https://dev.theneura.com/#/register) your app name, company name, a brief description of your app, and an iOS Bundle ID.  Please note that **each iOS Bundle ID must be unique** -- you cannot use the same bundle ID for multiple apps.  
![register your app](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/Registration_page_top_iOS.png)

### 2.3 Select Neura data objects
Select the [Neura data objects](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/pull.md) that you will want permission to access.  During the authentication process, Neura will ask your users to approve permission for you to access these data objects.  (Currently, [Neura event subscriptions](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md) are only available for Android.)  
![Select data objects](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/Registration_page_middle_data_objects.png)

### 2.4 Register
The **Register** button is enabled only after you've completed all manditory fields.  Information for a successful registration is available in https://dev.theneura.com/#/manage . Please note that **you must click the App secret** to make it visible.  

![register app](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/Registration_page_bottom.png)

### 2.5 Example registration
In this example a developer from **3rd_party_developer, Inc.** created an app called **Demo_app_number_three** that relates to '*health and wellness*' and uses the iOS Bundle ID `com.neura.sample.auth3`. They have requested permission to access users' data objects: `dailyActivitySummary`, `wellnessProfile`, and `sleepData`. Neura provides the **App UID** `ABC123***********************************` and the **App secret** `xyz789***********************************`.  Again, please note that **you must click the App secret** to make it visible.  


![register app](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/ExampleAppRegistrationiOS.png)

##  3. Add Neura to your app 

[![Get the Neura SDK for iOS](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/buttonGetSDKiOS.png)](https://github.com/NeuraLabs/neura_ios_sdk/tree/master/SampleProject/NeuraAuthSampleApp/lib)  

### 3.1 Add Neura's SDK 
The [Neura SDK for iOS](https://github.com/NeuraLabs/neura_ios_sdk/tree/master/SampleProject/NeuraAuthSampleApp/lib) consists of the files **Neura.h** and **libNeura.a**, which you need to add to your app.  

### 3.2 Add the Neura URL schema
Open the `.plist` file. Under **URL Schemes** you need to create only one URL schema. Create your **URL Schema** by adding the prefix `neura` to the **App UID** that Neura gave you in the [registration process](https://github.com/NeuraLabs/Neura_documentation/tree/master/text/account.md). For example, if the **App UID** is `ASDF1234*****************************` then the **URL schema** value is `neuraASDF1234*****************************`.  


### 3.3 Add authentication code
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


##  4. Query data objects to better understand your users  

***How does this work?!***



------------

# Internal Neura notes

fix throughout. iOS uses `access_token` whereas Android uses `accessToken`.  Let's pick one convention and use it consistently throughout.

Account creation. Let's simplify and be consistent: remove the **sign up** option and simply require users to **sign in** with their Neura user credentials.   

Get a description of the error codes from Triinu what these mean. Michael says that she defined the error codes. 



