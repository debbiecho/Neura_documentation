
package com.neura.sdk.object;

import java.io.Serializable;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.neura.sdk.config.NeuraConsts;

public class EventDefinition implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private long mRelevancyTimespan; // how much time since the event happend it's will be still relevant
    private long mDuplicationAvoidenceTimespan;
    private String mCode;
    private String mName;
    private String mDescription;
    private ArrayList<Permission> mAssosiatedPermissions = new ArrayList<Permission>();

    public long getRelevancyTimespan() {
        return mRelevancyTimespan;
    }

    public void setRelevancyTimespan(long mRelevancyTimespan) {
        this.mRelevancyTimespan = mRelevancyTimespan;
    }

    public long getDuplicationAvoidenceTimespan() {
        return mDuplicationAvoidenceTimespan;
    }

    public void setDuplicationAvoidenceTimespan(long mDuplicationAvoidenceTimespan) {
        this.mDuplicationAvoidenceTimespan = mDuplicationAvoidenceTimespan;
    }

    public String getCode() {
        return mCode;
    }

    public void setCode(String code) {
        this.mCode = code;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public static EventDefinition fromJson(JSONObject jsonObject) throws JSONException {
        EventDefinition eventDefinition = new EventDefinition();

        eventDefinition.setDescription(jsonObject.optString("description", null));

        long duplicationAvoidenceTimestamp = NeuraConsts.TEN_MINUTES;
        if (jsonObject.has("frequencyThreshold")) {
            duplicationAvoidenceTimestamp = jsonObject.getLong("frequencyThreshold") * 1000;

        }

        eventDefinition.setDuplicationAvoidenceTimespan(duplicationAvoidenceTimestamp);

        eventDefinition.setCode(jsonObject.optString("code", null));
        eventDefinition.setName(jsonObject.optString("name", null));

        long experationTrashold = NeuraConsts.TEN_MINUTES;
        if (jsonObject.has("expirationThreshold")) {
            experationTrashold = jsonObject.getLong("expirationThreshold") * 1000;

        }

        eventDefinition.setRelevancyTimespan(experationTrashold);

        JSONArray permissionsjsonArray = jsonObject.optJSONArray("permissions");
        if (permissionsjsonArray != null) {
            ArrayList<Permission> assosiatedPermissions = new ArrayList<Permission>();

            for (int i = 0; i < permissionsjsonArray.length(); i++) {
                Permission permission = Permission.fromJson(permissionsjsonArray.getJSONObject(i));
                if (permission != null) {
                    assosiatedPermissions.add(permission);
                }
            }

            eventDefinition.setAssosiatedPermissions(assosiatedPermissions);
        }

        return eventDefinition;
    }

    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("description", mDescription);
            jsonObject.put("frequencyThreshold", mDuplicationAvoidenceTimespan / 1000);
            jsonObject.put("expirationThreshold", mRelevancyTimespan / 1000);
            jsonObject.put("name", mName);
            jsonObject.put("code", mCode);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public ArrayList<Permission> getAssosiatedPermissions() {
        return mAssosiatedPermissions;
    }

    public void setAssosiatedPermissions(ArrayList<Permission> permissions) {
        this.mAssosiatedPermissions = permissions;
    }

}
