package co.OscarSoft.CPTWC.models;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by oscarso on 12/13/15.
 */
public class User {
    private String name;
    private long uid;
    private String screenName;
    private String profileImageUrl;

    public static User fromJSON(JSONObject jsonObj) {
        User user = new User();
        try {
            user.name = jsonObj.getString("name");
            user.uid = jsonObj.getLong("id");
            user.screenName = jsonObj.getString("screen_name");
            user.profileImageUrl = jsonObj.getString("profile_image_url");
        } catch (JSONException je) {
            Log.e("ERROR", je.toString());
        }
        return user;
    }

    public String getName() {
        return name;
    }

    public long getUid() {
        return uid;
    }

    public String getScreenName() {
        return screenName;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }
}
