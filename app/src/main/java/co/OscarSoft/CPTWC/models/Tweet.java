package co.OscarSoft.CPTWC.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by oscarso on 12/13/15.
 */
public class Tweet {
    private String body;
    private long uid;
    private User user;
    private String createdAt;

    public static Tweet fromJSON(JSONObject jsonObj) {
        Tweet tweet = new Tweet();
        try {
            tweet.body = jsonObj.getString("text");
            tweet.uid = jsonObj.getLong("id");
            tweet.createdAt = jsonObj.getString("created_at");
            tweet.user = User.fromJSON(jsonObj.getJSONObject("user"));
        } catch (JSONException je) {
            Log.e("ERROR", je.toString());
        }
        return tweet;
    }

    public static ArrayList<Tweet> fromJSONArray(JSONArray jsonArray) {
        ArrayList<Tweet> arrTweet = new ArrayList<Tweet>();
        for (int i=0; i < jsonArray.length(); i++) {
            try {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                Tweet tweet = Tweet.fromJSON(jsonObj);
                if (tweet != null) {
                    arrTweet.add(tweet);
                }
            } catch (JSONException je) {
                Log.e("ERROR", je.toString());
                continue;
            }
        }
        return arrTweet;
    }

    public String getBody() {
        return body;
    }

    public long getUid() {
        return uid;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
