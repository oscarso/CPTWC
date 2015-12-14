package co.OscarSoft.CPTWC;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import co.OscarSoft.CPTWC.models.Tweet;

public class TimelineActivity extends AppCompatActivity {

    private TwitterClient client;
    private ArrayList<Tweet> arrListTweet;
    private TweetsArrayAdapter arrAdapterTweet;
    private ListView lvTweets;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lvTweets = (ListView) findViewById(R.id.lvTweets);
        arrListTweet = new ArrayList<>();
        arrAdapterTweet = new TweetsArrayAdapter(this, arrListTweet);
        lvTweets.setAdapter(arrAdapterTweet);

        client = TwitterApplication.getRestClient();
        populateTimeline();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return true;
    }

    public void onComposeAction(MenuItem mi) {
        // handle click here
        Log.d("DEBUG", "onComposeAction");
    }

    private void populateTimeline() {

        client.getHomeTimeline(new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                //super.onSuccess(statusCode, headers, response);
                //Log.d("INFO", response.toString());
                ArrayList<Tweet> arrTweet = new ArrayList<Tweet>();
                arrAdapterTweet.addAll(Tweet.fromJSONArray(response));
                //Log.d("DEBUG", arrAdapterTweet.toString());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                //super.onFailure(statusCode, headers, responseString, throwable);
                Log.d("ERROR", "Fail 1");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                //super.onFailure(statusCode, headers, throwable, errorResponse);
                Log.d("ERROR", "Fail 2");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                //super.onFailure(statusCode, headers, throwable, errorResponse);
                Log.d("ERROR", "Fail 3");
            }
        });
    }

}
