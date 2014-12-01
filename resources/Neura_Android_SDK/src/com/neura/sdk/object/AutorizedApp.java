
package com.neura.sdk.object;

import java.io.Serializable;
import java.util.ArrayList;

public class AutorizedApp implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String mName;

    private ArrayList<Permission> mPermissions = new ArrayList<Permission>();

    private ArrayList<String> mApprovedHashKeys = new ArrayList<String>();

    private String mAccessToken;

    private String mAppId;

    private String mPackageName;

    private String mBroadcastReceiverName;

    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public boolean hasAndroidMetadata() {
        return mPackageName != null && mBroadcastReceiverName != null;
    }

    public String getBroadcastReceiverName() {
        return mBroadcastReceiverName;
    }

    public String getPackageName() {
        return mPackageName;
    }

    public ArrayList<Permission> getPermissions() {
        return mPermissions;
    }

    public void setPackageName(String packageName) {
        mPackageName = packageName;
    }

    public void setBroadcastReceiverName(String receiverName) {
        mBroadcastReceiverName = receiverName;
    }

    public void setPermissions(ArrayList<Permission> permissions) {
        mPermissions = permissions;
    }

    public ArrayList<String> getApprovedHashKeys() {
        return mApprovedHashKeys;
    }

    public void setApprovedHashKeys(ArrayList<String> approvedHashKeys) {
        this.mApprovedHashKeys = approvedHashKeys;
    }

    public boolean hashKeyIsValid(String requestingAppHashKey) {
        if (mApprovedHashKeys == null || requestingAppHashKey == null) {
            return false;
        }

        for (String hashkey : mApprovedHashKeys) {
            if (hashkey.equalsIgnoreCase(requestingAppHashKey)) {
                return true;
            }
        }

        return false;
    }

    public boolean containsAll(ArrayList<Permission> permissions) {
        return mPermissions.containsAll(permissions);
    }

    public void markPermissionsAsGranted(ArrayList<Permission> grantedPemissions) {
        for (Permission permission : grantedPemissions) {
            permission.setGrantedByUser(true);
        }

        mPermissions.removeAll(grantedPemissions);
        mPermissions.addAll(grantedPemissions);
    }

    public String getAccessToken() {
        return mAccessToken;
    }

    public void setAccessToken(String mAccessToken) {
        this.mAccessToken = mAccessToken;
    }

    public String getAppId() {
        return mAppId;
    }

    public void setAppId(String appId) {
        this.mAppId = appId;
    }
}
