
package com.neura.sdk.object;

import java.util.ArrayList;

/**
 * this class encapsulates request to authenticate to Neura.
 * 
 * @author Tal
 */
public class AuthenticationRequest {
    private ArrayList<Permission> mPermissions;
    private String mAppId;
    private String mAppSecret;

    public ArrayList<Permission> getPermissions() {
        return mPermissions;
    }

    /**
     * @param permissions that be associated with this authentication request. all permissions provided in this list must be enabled also at the Neura
     *            Developer console application page.
     */
    public void setPermissions(ArrayList<Permission> permissions) {
        this.mPermissions = permissions;
    }

    /**
     * @return the requesting application Id
     */
    public String getAppId() {
        return mAppId;
    }

    /**
     * @param appId which declared in the android developer console
     */
    public void setAppId(String appId) {
        this.mAppId = appId;
    }

    public String getAppSecret() {
        return mAppSecret;
    }

    public void setAppSecret(String appSecret) {
        this.mAppSecret = appSecret;
    }

}
