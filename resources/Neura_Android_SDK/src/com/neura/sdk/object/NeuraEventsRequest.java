
package com.neura.sdk.object;

/**
 * this class encapsulates a request to register to Neura Event
 * 
 * @author Tal
 */
public class NeuraEventsRequest {
    private String mAccessToken;
    private String mEventName;

    public String getAccessToken() {
        return mAccessToken;
    }

    /**
     * @param accessToken retrieved from the Neura authentication.
     */
    public void setAccessToken(String accessToken) {
        this.mAccessToken = accessToken;
    }

    public String getEventName() {
        return mEventName;
    }

    /**
     * @param eventId the specific event to register to. list of all existing events and it's Id's can be found in the Neura developer console.
     */
    public void setEventName(String eventName) {
        this.mEventName = eventName;
    }
}
