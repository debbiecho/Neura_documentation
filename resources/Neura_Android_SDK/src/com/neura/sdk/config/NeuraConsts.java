
package com.neura.sdk.config;

public class NeuraConsts {
    public static final String EXTRA_APP_ID = "com.neura.android.EXTRA_APP_ID";
    public static final String EXTRA_PERMISSIONS = "com.neura.android.REQUESTED_PERMISSIONS";
    public static final String EXTRA_APP_HASH_KEY = "com.neura.android.EXTRA_APP_HASH_KEY";
    public static final String EXTRA_TOKEN = "com.neura.android.EXTRA_TOKEN";
    public static final String EXTRA_EVENT_NAME = "com.neura.android.EXTRA_EVENT_NAME";
    public static final String EXTRA_SUCCESS = "com.neura.android.EXTRA_SUCCESS";
    public static final String EXTRA_APP_SECRET = "com.neura.android.EXTRA_APP_SECRET";

    public static final String ACTION_REGISTER_EVENT = "com.neura.android.ACTION_REGISTER_EVENT";
    public static final String ACTION_UNREGISTER_EVENT = "com.neura.android.ACTION_UNREGISTER_EVENT";
    public static final String ACTION_NEURA_EVENT = "com.neura.android.ACTION_NEURA_EVENT";

    public static String EXTRA_ERROR_CODE = "com.neura.android.EXTRA_ERROR_CODE";
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
    public static final int ERROR_INVALID_ACCESS_TOKEN = 12;

    public static final String ACTION_EVENT_REGISTRATION_RESPONSE = "com.neura.android.ACTION_EVENT_REGISTRATION_RESPONSE";

    public static final String ACCESS_TOKEN_MISSING = "access_token_missing";
    public static final long TEN_MINUTES = 1000 * 60 * 10;

}
