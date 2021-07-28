package sg.edu.rp.c346.id20022404.ourndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Song> songList;

    public CustomAdapter(Context context, int resource, ArrayList<Song> objects) {
        super(context,resource,objects);

        parent_context = context;
        layout_id = resource;
        songList = objects;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvYear = rowView.findViewById(R.id.textViewYear);
        TextView tvSinger = rowView.findViewById(R.id.textViewSinger);
        ImageView ivNew = rowView.findViewById(R.id.imageView);
        RatingBar ratingBar = rowView.findViewById(R.id.ratingBar);

        Song currentSong = songList.get(position);

        tvTitle.setText(currentSong.getTitle());
        tvYear.setText(currentSong.getYearReleased());
        tvSinger.setText(currentSong.getSingers());
        ratingBar.setRating(currentSong.getStars());

        if (currentSong.getYearReleased() >= 2019) {
            ivNew.setImageResource(R.drawable.newsong);
        } else {
            ivNew.setVisibility((View.INVISIBLE));
        }

        return rowView;
    }

}
