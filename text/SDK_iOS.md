
#Neura SDK for iOS


[![Neura iOS SDK](https://github.com/NeuraLabs/Neura_documentation/blob/master/resources/iOS-7-SDK-icon.png)](https://github.com/NeuraLabs/Neura_documentation/tree/master/resources/Neura_iOS_SDK)


You can add the Neura SDK for iOS to your app so that your app can request PUSH event notifications and issue requests for data objects from Neura.  Your users will need to install the [app by requesting access to be a Neura beta tester on TestFlight](https://theneura.prefinery.com/betas/4631/testers/new?display=inline&version=2).  Once your users have installed the Neura app, they'll need to grant you permission to access their events and data objects.

[**Download Neura's iOS SDK here**](https://github.com/NeuraLabs/Neura_documentation/tree/master/resources/Neura_iOS_SDK)


##Register URL SchemaTo add the neura SDK to your iOS project, open the `.plist` file and set `url_schema` to prefix `neura` and use the **App UID** that was received in the [registration process](https://github.com/NeuraLabs/Neura_documentation/tree/master/text/account.md). For example, if the **App UID** is `ASDF1234*****************************` then the **url_schema** value is `neuraASDF1234*****************************`


##AuthenticationThe Neura SDK for iOS provides prebuilt UI components and buttons that you can use to start the Neura authentication flow. To authenticate the user, Neura's SDK makes a call to the Neura app on the user's phone which takes the user through the authentication process. Your client app will go through the following steps, detailed below:1.	**Set** the `client_id`, `client_secret` and client permissions2.	**Call** the authentication **What are we trying to say here? 'initiate authentication in the Neura app'?**  3.	**Receive** the access token from the Neura app  **I love this structure, but it doesn't align wiht the headers below. Make it align!**##SetThe authentication call requires to set: **Clarify**
1.	`Client_id –lreceived` in Registration process2.	`Client_secret –lreceived` in Registration process3.	Permissions list `–epermissions` are specified in the developers consoleExample:  ```
[[Neura sharedInstance] setClientId:clientId]  [[Neura sharedInstance] setClientSecretId:secret]  [[Neura sharedInstance] setPermmisions:@"got_home,left work,woke_up"];  
```
**copy & paste actual code.**###Authentication The authentication method has 2 tasks:1.	The Neura SDK verifies if the Neura app is installed on the user's phone. 
	1a. If the user does noezt have the Neura app, authentication immediately returns an error. In this case, we recommend that Consumer application suggests the user install the Neura app from iTunes. **is this what the code does? Can we change this to apply for app in TestFlight?**2.	If the user has the Neura app, then the Neura app takes the user through the authentication and permissions process. Example:  ` [[Neura sharedInstance] AuthenticationWithError:&error];`**Neura returns the following error messages**:  •	`ERROR_CODE_USER_NOT_LOGGED_IN`    •	`ERROR_APP_MISSING_PERMISSIONS`  •	`ERROR_USER_DENIED_PERMISSIONS`  •	`EXTRA_ERROR_CODE`  •	`ERROR_NOT_AUTORIZED_APP_SIGNITURE`  ###Access Token **insert method name here** Callback of the authentication gives the access token or error with the reason of failure. The access token is permanent and unique to the user. You must use it to subscribe to access the user's events and data objects. 

####Examples 
**Clarify. What does this do?**  A callback function in your code to receive an access token ```C# -(BOOL)application:(UIApplication *)application  
             openURL:(NSURL *)url
 sourceApplication:(NSString *)sourceApplication  
          annotation:(id)annotation```
The access token is given per Neura client_id:Example of access token: 
`neuraASDF1234********************************://?access_token=“qwer7890************************"`  
Example of authentication error:  
`neuraASDF1234********************************://?error=“ERROR_APP_MISSING_PERMISSIONS"`







