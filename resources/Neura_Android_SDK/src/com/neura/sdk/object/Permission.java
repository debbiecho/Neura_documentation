
package com.neura.sdk.object;

import java.io.Serializable;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Permission implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String mName;
    private String mId;
    private String mDisplayName;
    private boolean mGrantedByUser = false;
    private String mDescription;
    private ArrayList<EventDefinition> mAssosiatedEvents = new ArrayList<EventDefinition>();

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        this.mId = id;
    }

    public boolean isGrantedByUser() {
        return mGrantedByUser;
    }

    public void setGrantedByUser(boolean granted) {
        this.mGrantedByUser = granted;
    }

    public static ArrayList<Permission> list(String[] array) {
        ArrayList<Permission> permissions = new ArrayList<Permission>();

        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                Permission permission = new Permission();
                permission.setName(array[i]);
                permissions.add(permission);
            }
        }

        return permissions;
    }

    public static String getStringArray(ArrayList<Permission> permissionList) {
        String permissionsString = "";
        for (Permission permission : permissionList) {
            if (permissionsString.length() != 0) {
                permissionsString += ",";
            }
            permissionsString += permission.getName();
        }

        return permissionsString;
    }

    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("granted", mGrantedByUser);
            jsonObject.put("neuraId", mId);
            jsonObject.put("name", mName);
            jsonObject.put("description", mDescription);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    public static Permission fromJson(JSONObject jsonObject) {

        Permission permission = new Permission();

        permission.setGrantedByUser(jsonObject.optBoolean("granted"));
        permission.setId(jsonObject.optString("neuraId", null));
        permission.setDisplayName(jsonObject.optString("displayName", null));
        permission.setName(jsonObject.optString("name", null));
        permission.setDescription(jsonObject.optString("description", null));

        JSONArray eventsJsonArray = jsonObject.optJSONArray("events");
        if (eventsJsonArray != null && eventsJsonArray.length() != 0) {
            ArrayList<EventDefinition> events = new ArrayList<EventDefinition>();
            for (int i = 0; i < eventsJsonArray.length(); i++) {
                JSONObject eventObject = eventsJsonArray.optJSONObject(i);
                if (eventObject != null) {
                    try {
                        EventDefinition event = EventDefinition.fromJson(eventObject);
                        events.add(event);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            permission.setAssosiatedEvents(events);
        }

        return permission;

    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDescription() {
        return mDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof Permission)) {
            return false;
        }

        Permission permission = (Permission) o;

        return permission.getId().equalsIgnoreCase(mId);
    }

    public String getDisplayName() {
        return mDisplayName;
    }

    public void setDisplayName(String displayName) {
        this.mDisplayName = displayName;
    }

    public ArrayList<EventDefinition> getAssosiatedEvents() {
        return mAssosiatedEvents;
    }

    public void setAssosiatedEvents(ArrayList<EventDefinition> assosiatedEvents) {
        this.mAssosiatedEvents = assosiatedEvents;
    }
}
