
package com.neura.sdk.util;

import com.neura.sdk.config.NeuraConsts;
import com.neura.sdk.object.NeuraEventsRequest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class NeuraUtil {
    /**
     * register to events Neura Services process is exposing. the callback will be received directly as explicit broadcast to the BroadcastReceiver
     * full component name declared in the Neura Developer console.
     * 
     * @param context
     * @param request
     */
    public static void registerEvent(Context context, NeuraEventsRequest request) {
        Intent intent = new Intent(NeuraConsts.ACTION_REGISTER_EVENT);
        intent.putExtra(NeuraConsts.EXTRA_TOKEN, request.getAccessToken());
        intent.putExtra(NeuraConsts.EXTRA_EVENT_NAME, request.getEventName());
        context.sendBroadcast(intent);
    }

    /**
     * unregister to Neura Event.
     * 
     * @param context
     * @param request
     */
    public static void unregisterEvent(Context context, NeuraEventsRequest request) {
        Intent intent = new Intent(NeuraConsts.ACTION_UNREGISTER_EVENT);
        intent.putExtra(NeuraConsts.EXTRA_TOKEN, request.getAccessToken());
        intent.putExtra(NeuraConsts.EXTRA_EVENT_NAME, request.getEventName());
        context.sendBroadcast(intent);
    }

    public static void redirectToGooglePlayNeuraMeDownloadPage(Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("market://details?id=com.neura.weave"));
        context.startActivity(intent);
    }

    public static String errorCodeToString(int errorCode) {
        String retString = "Unkown error";

        switch (errorCode) {
            case NeuraConsts.ERROR_APP_MISSING_PERMISSIONS:
                retString = "ERROR_APP_MISSING_PERMISSIONS";
                break;
            case NeuraConsts.ERROR_ILLEGAL_PERMISSIONS:
                retString = "ERROR_ILLEGAL_PERMISSIONS";
                break;
            case NeuraConsts.ERROR_INVALID_APP_ID:
                retString = "ERROR_INVALID_APP_ID";
                break;
            case NeuraConsts.ERROR_MISSING_ANDROID_PLATFORM:
                retString = "ERROR_MISSING_ANDROID_PLATFORM";
                break;
            case NeuraConsts.ERROR_NO_NETWORK:
                retString = "ERROR_NO_NETWORK";
                break;
            case NeuraConsts.ERROR_NOT_AUTORIZED_APP_SIGNITURE:
                retString = "ERROR_NOT_AUTORIZED_APP_SIGNITURE";
                break;
            case NeuraConsts.ERROR_SERVER_ERROR:
                retString = "ERROR_SERVER_ERROR";
                break;
            case NeuraConsts.ERROR_UNEXPECTED_SERVER_RESPONSE:
                retString = "ERROR_UNEXPECTED_SERVER_RESPONSE";
                break;
            case NeuraConsts.ERROR_USER_CANCELED_AUTHENTICATION:
                retString = "ERROR_USER_CANCELED_AUTHENTICATION";
                break;
            case NeuraConsts.ERROR_USER_DENIED_PERMISSIONS:
                retString = "ERROR_USER_DENIED_PERMISSIONS";
                break;
            case NeuraConsts.ERROR_INVALID_ACCESS_TOKEN:
                retString = "ERROR_INVALID_ACCESS_TOKEN";
                break;
            default:
                break;
        }

        return retString;
    }
}
