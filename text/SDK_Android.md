
#Neura SDK for Android

You can add the Neura SDK for Android to your app to that your app can request PUSH event notifications and issue PULL requests for data objects.  Your users will need to install the Neura app on their phones, available in Google Play `google play link` **add link**.  Once your users have installed the Neura app, they'll need to grant you permission to access their events and data objects.


##AuthenticationThe Neura Android SDK has the method `NeuraAuthUtil.authenticate` that handles authentication flow, which consists of two steps:
1.	The method verifies whether the Neura app is installed on the user's phone and returns a boolean value.
    - If `FALSE` then the method fails. You should prompt the user to download the Neura app. SDK gives util with method that redirects to the app in Google Play. 
    - If `TRUE` then the method proceeds to step 2.
2.	The method opens the authentication flow and prompts the user for authentication credentials and permissions.  The callback of the method is the authentication result using the `Activity.onActivityResult` method, as detailed in the Android developers guide: http://developer.android.com/reference/android/app/Activity.html#onActivityResult(int, int, android.content.Intent)

Your application can identify the Neura callbacks by using the `requestCode` that was provided in the method `NeuraAuthUtil.authenticate`.  If authentication is successful then Neura returns an access token, `NeuraAuthUtil.extractToken`. The access token is permanent and can be used for subscribing to PUSH event notifications or to issue a PULL request for a data object.  If authentication fails, then Neura returns an error code.

###Class and method descriptions for authentication`Boolean NeuraAuthUtil.authenticate(Context context, int requestCode, AuthenticationRequest authenticationRequest);` `Context`: Context of Activity, which must be Activity Context.  `requestCode`: request code to identify  
`onActivityResult()` callback for Neura authentication.  
`authenticationRequest`: AuthenticationRequest instance.  ####Example `NeuraAuthUtil.authenticate` call
 `example goes here`
 
####Example `NeuraAuthUtil.authenticate` response
`TRUE` 








