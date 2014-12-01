
package com.neura.sdk.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.StrictMode.VmPolicy;
import android.support.v4.app.FragmentActivity;

import com.neura.sdk.config.NeuraConsts;
import com.neura.sdk.object.AuthenticationRequest;

/**
 * an helper class to perform directly inter process comunication with Neua Services process in order to perform Neura authentication.
 * 
 * @author Tal
 */
public class NeuraAuthUtil {

    /**
     * this method must be called from an Activity/FragmentActivity context! the authentication callback should be consumed from the
     * onActivityResult() callback.
     * 
     * @param context the calling Activity or FragmentActivity context
     * @param requestCode request code to identify onActivityResult() callback for the Neura authentication
     * @param registrationRequest
     * @return true if Neura application is installed
     */
    public static boolean authenticate(Context context, int requestCode, AuthenticationRequest authenticationRequest) {

        if (!Utils.isPackageInstalled("com.neura.weave", context)) {
            return false;
        }

        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.neura.weave", "com.neura.dashboard.activity.AppAuthenticationActivity"));
        intent.putExtra(NeuraConsts.EXTRA_APP_HASH_KEY, Utils.getHashKeyForApp(context, context.getPackageName()));
        intent.putExtra(NeuraConsts.EXTRA_APP_ID, authenticationRequest.getAppId());
        intent.putExtra(NeuraConsts.EXTRA_APP_SECRET, authenticationRequest.getAppSecret());
        intent.putExtra(NeuraConsts.EXTRA_PERMISSIONS, authenticationRequest.getPermissions());

        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            activity.startActivityForResult(intent, requestCode);
        } else if (context instanceof FragmentActivity) {
            FragmentActivity activity = (FragmentActivity) context;
            activity.startActivityForResult(intent, requestCode);
        }

        return true;
    }

    public static String extractToken(Intent intent) {
        String token = intent.getStringExtra(NeuraConsts.EXTRA_TOKEN);

        return token;
    }
}
