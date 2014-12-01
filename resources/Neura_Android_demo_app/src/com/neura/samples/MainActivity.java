
package com.neura.samples;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.neura.sdk.config.NeuraConsts;
import com.neura.sdk.object.AuthenticationRequest;
import com.neura.sdk.object.NeuraEventsRequest;
import com.neura.sdk.object.Permission;
import com.neura.sdk.util.NeuraAuthUtil;
import com.neura.sdk.util.NeuraUtil;

public class MainActivity extends Activity {

    private static final int NEURA_AUTHENTICATION_REQUEST_CODE = 0;
    private String KEY_NEURA_ACCESS_TOKEN = "com.neura.samples.KEY_NEURA_ACCESS_TOKEN";
    private Button mAuthenticateBtn;
    private Button mRegisterEventBtn;
    private EditText mAccessTokenEditText;
    private Button mForgetTokenBtn;
    private Button mCopyToCliboardBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuthenticateBtn = (Button) findViewById(R.id.activity_main_authenticate_btn);
        mRegisterEventBtn = (Button) findViewById(R.id.activity_main_event_registration_btn);

        mAuthenticateBtn.setOnClickListener(mOnAuthenticateClickedListener);
        mRegisterEventBtn.setOnClickListener(mOnRegisterEventsClickedListener);

        mCopyToCliboardBtn = (Button) findViewById(R.id.activity_main_copy_access_token_to_clipboard);
        mCopyToCliboardBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("accessToken", mAccessTokenEditText.getEditableText().toString());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(MainActivity.this, "copied access token to clipboard", Toast.LENGTH_SHORT).show();
            }
        });

        mAccessTokenEditText = (EditText) findViewById(R.id.activity_main_access_token);

        mForgetTokenBtn = (Button) findViewById(R.id.activity_main_forget_token_btn);
        mForgetTokenBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                forgetToken();
            }
        });
    }

    protected void forgetToken() {
        clearToken();
        refreshUi();
    }

    @Override
    protected void onStart() {
        super.onStart();

        refreshUi();
    }

    private void refreshUi() {
        String accessToken = getAccessToken();
        boolean alreadyAuthenticated = accessToken != null;

        mAuthenticateBtn.setEnabled(!alreadyAuthenticated);
        mRegisterEventBtn.setEnabled(alreadyAuthenticated);

        mAccessTokenEditText.setEnabled(alreadyAuthenticated);
        mCopyToCliboardBtn.setEnabled(alreadyAuthenticated);
        mAccessTokenEditText.setText(accessToken);
        mForgetTokenBtn.setEnabled(alreadyAuthenticated);
    }

    private OnClickListener mOnAuthenticateClickedListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            performNeuraAuthentication();
        }
    };

    private OnClickListener mOnRegisterEventsClickedListener = new OnClickListener() {

        @Override
        public void onClick(View v) {

            String[] permissions = getAppPermisisons();
            if (permissions != null) {
                for (int i = 0; i < permissions.length; i++) {
                    registerToNeuraSpecificEvents(getAccessToken(), MainActivity.this, permissions[i]);

                }
            }
        }
    };

    public String getAppId() {
        EditText appIdEditText = (EditText) findViewById(R.id.activity_main_app_id_edit_text);
        return appIdEditText.getEditableText().toString().trim();
    }

    public String getAppSecret() {
        EditText appSecretEditText = (EditText) findViewById(R.id.activity_main_app_secret_edit_text);
        return appSecretEditText.getEditableText().toString().trim();
    }

    public String[] getAppPermisisons() {
        EditText permissionsEditText = (EditText) findViewById(R.id.activity_main_permissions_edit_text);
        String permissionsString = permissionsEditText.getEditableText().toString().trim();
        return permissionsString.split(",");
    }

    private void performNeuraAuthentication() {

        String appId = getAppId();
        String appSecret = getAppSecret();

        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        authenticationRequest.setAppId(appId);
        authenticationRequest.setAppSecret(appSecret);

        String[] permissions = getAppPermisisons();

        /**
         * list of all existing permissions can be found in the Neura developer web site...
         */

        ArrayList<Permission> permisions = Permission.list(permissions);

        authenticationRequest.setPermissions(permisions);

        boolean neuraInstalled = NeuraAuthUtil.authenticate(this, NEURA_AUTHENTICATION_REQUEST_CODE, authenticationRequest);
        if (!neuraInstalled) {
            NeuraUtil.redirectToGooglePlayNeuraMeDownloadPage(this);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEURA_AUTHENTICATION_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String accessToken = NeuraAuthUtil.extractToken(data);
                saveAccessTokenPersistent(accessToken);
                Toast.makeText(MainActivity.this, "Authenticate Success!", Toast.LENGTH_SHORT).show();

                refreshUi();
            } else {
                int errorCode = data.getIntExtra(NeuraConsts.EXTRA_ERROR_CODE, -1);

                Toast.makeText(MainActivity.this, "Authenticate Failed: " + NeuraUtil.errorCodeToString(errorCode), Toast.LENGTH_SHORT).show();

                // TODO handle one of the error codes described in the documentation

                /**
                 * in general, this can happen if user denied permissions, there is no network, one of the parameter supplied in the authentication
                 * was wrong or missing, and other error codes as described in the documentation...
                 */

            }
        }
    }

    private void registerToNeuraSpecificEvents(String accessToken, Context context, String eventName) {
        NeuraEventsRequest eventsReuest = new NeuraEventsRequest();
        eventsReuest.setAccessToken(accessToken);
        /**
         * list of all events names listed in the Neura developer web console.
         */
        eventsReuest.setEventName(eventName);

        /**
         * App will stay registered to the event (even if the registered app is not running at all) until it will explicitly call
         * NeuraUtil.unregisterEvent()...
         */
        NeuraUtil.registerEvent(context, eventsReuest);
    }

    private void unregisterEvent(String accessToken, Context context, String eventName) {
        NeuraEventsRequest eventsReuest = new NeuraEventsRequest();
        eventsReuest.setAccessToken(accessToken);
        eventsReuest.setEventName(eventName);

        NeuraUtil.unregisterEvent(context, eventsReuest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void clearToken() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        prefs.edit().clear().commit();
    }

    public void saveAccessTokenPersistent(String accessToken) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        prefs.edit().putString(KEY_NEURA_ACCESS_TOKEN, accessToken).commit();
    }

    public String getAccessToken() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        return prefs.getString(KEY_NEURA_ACCESS_TOKEN, null);
    }
}
