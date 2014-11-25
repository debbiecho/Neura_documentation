
#Neura SDK for Android

You can add the Neura SDK for Android to your app to that your app can request PUSH event notifications and issue PULL requests for data objects.  Your users will need to install the Neura app on their phones, available in Google Play `google play link` **add link**.  Once your users have installed the Neura app, they'll need to grant you permission to access their events and data objects.


##AuthenticationThe Neura Android SDK has the method `NeuraAuthUtil.authenticate` that handles authentication flow, which consists of two steps:
1.	The method verifies whether the Neura app is installed on the user's phone and returns a boolean value.
    - If `FALSE` then the method fails. You should prompt the user to download the Neura app. SDK gives util with method that redirects to the app in Google Play. 
    - If `TRUE` then the method proceeds to step 2.
2.	The method opens the authentication flow and prompts the user for authentication credentials and permissions.  The callback of the method is the authentication result using the `Activity.onActivityResult` method, as detailed in the Android developers guide: http://developer.android.com/reference/android/app/Activity.html#onActivityResult(int, int, android.content.Intent)

Your application can identify the Neura callbacks by using the `requestCode` that was provided in the method `NeuraAuthUtil.authenticate`.  If authentication is successful then Neura returns an access token, `NeuraAuthUtil.extractToken`. The access token is permanent and can be used for subscribing to PUSH event notifications or to issue a PULL request for a data object.  If authentication fails, then Neura returns an error code.

##Class and method descriptions for authentication###`NeuraAuthUtil.authenticate` method`Boolean NeuraAuthUtil.authenticate(Context context, int requestCode, AuthenticationRequest authenticationRequest);` `Context`: Context of Activity, which must be Activity Context.  `requestCode`: request code to identify  
`onActivityResult()`: callback for Neura authentication.  
`authenticationRequest`: AuthenticationRequest instance.  ####Example `NeuraAuthUtil.authenticate` call
 `example goes here`
 
####Example `NeuraAuthUtil.authenticate` response
`TRUE` 

###`AuthenticationRequest` class
`public class AuthenticationRequest``java.lang.String getAppId()` This is the **Application Key** that was requested and received during app registration  `void setAppId(java.lang.String appId)`   `void setAppSecret(java.lang.String app_secret)`  `void setPermissions(java.util.ArrayList<Permission> permissions)`   


###`Permission` class`public class Permission``boolean equals(java.lang.Object o)` `static Permission fromJson(JSONObject jsonObject)` `java.lang.String getId()` `java.lang.String getName()boolean isGrantedByUser() void	setGrantedByUser(boolean granted) 	void	setId(java.lang.String id) void	setName(java.lang.String name) JSONObject	toJson() `### Example authentication call:```javaprivate void performNeuraAuthentication() {        AuthenticationRequest authenticationRequest = new AuthenticationRequest();        authenticationRequest.setAppId(APP_ID);        authenticationRequest.setAppSecret(APP_SECRET);        ArrayList<Permission> permisions = Permission.list(new String[] {                "userWokeUp", "userLeftGym", "userLeftHome", "userFinishedWalking", "userStartedDriving", "userIsAtWork", "userIsRunning",                "userStartedCycling", "userIsDriving", "userIsWalking", "userFinishedRunning"        });        authenticationRequest.setPermissions(permisions);        boolean neuraInstalled = NeuraAuthUtil.authenticate(this, NEURA_AUTHENTICATION_REQUEST_CODE, authenticationRequest);        if (!neuraInstalled) {            NeuraUtil.redirectToGooglePlayNeuraMeDownloadPage(this);        }    }```###Example authentication result ```java
@Override    protected void onActivityResult(int requestCode, int resultCode, Intent data) {        super.onActivityResult(requestCode, resultCode, data);        if (requestCode == NEURA_AUTHENTICATION_REQUEST_CODE) {            if (resultCode == RESULT_OK) {                                String accessToken = NeuraAuthUtil.extractToken(data);                saveAccessTokenPersistent(accessToken);                Toast.makeText(MainActivity.this, "Authenticate Success!", Toast.LENGTH_SHORT).show();                refreshUi();            } else {                int errorCode = data.getIntExtra(NeuraConsts.EXTRA_ERROR_CODE, -1);                // TODO handle one of the error codes described in the documentation                /**                 * in general, this can happen if user denied permissions, there is no network, one of the parameter supplied in the authentication                 * was wrong or missing, and other error codes as described in the documentation...                 */            }        }    }
```

