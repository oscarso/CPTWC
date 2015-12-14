package co.OscarSoft.CPTWC;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import co.OscarSoft.CPTWC.models.Tweet;

/**
 * Created by oscarso on 12/13/15.
 */
public class TweetsArrayAdapter extends ArrayAdapter<Tweet> {

    // View lookup cache
    private static class ViewHolder {
        ImageView profileImage;
        TextView userName;
        TextView body;
    }

    public TweetsArrayAdapter(Context context, List<Tweet> tweets) {
        super(context, 0, tweets);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Tweet tweet = getItem(position);

        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_tweet, parent, false);
            viewHolder.profileImage = (ImageView) convertView.findViewById(R.id.ivProfileImage);
            viewHolder.profileImage.setImageResource(android.R.color.transparent);
            viewHolder.userName = (TextView) convertView.findViewById(R.id.tvUserName);
            viewHolder.body = (TextView) convertView.findViewById(R.id.tvBody);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.userName.setText(tweet.getUser().getScreenName());
        viewHolder.body.setText(tweet.getBody());
        Picasso.with(getContext()).load(tweet.getUser().getProfileImageUrl()).into(viewHolder.profileImage);

        return convertView;
    }
}
