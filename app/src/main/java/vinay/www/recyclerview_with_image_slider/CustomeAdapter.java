package vinay.www.recyclerview_with_image_slider;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vppl-10160 on 28-02-2017.
 */

public class CustomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final static int PAGER_VIEW = 0;
    private final static int CONTENT_VIEW = 1;
    private List<Object> moviesList;
    Context context;

    public CustomeAdapter(Context context, List<Object> moviesList) {
        this.moviesList = moviesList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == PAGER_VIEW) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_horizontal_view_item, parent, false);
            return new CustomViewHolder1(itemView);
        } else if (viewType == CONTENT_VIEW) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_vertical_view_item, parent, false);
            return new CustomViewHolder(itemView);
        }
        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        int viewType = getItemViewType(position);
        Object movie = moviesList.get(position);

        if (viewType == PAGER_VIEW) {
            CustomViewHolder1 customViewHolder1 = (CustomViewHolder1) holder;
            ArrayList<Item> dataModel = (ArrayList<Item>) moviesList.get(position);
            ImageAdapter imageAdapter = new ImageAdapter(context, dataModel);
            customViewHolder1.pager.setAdapter(imageAdapter);

        } else if (viewType == CONTENT_VIEW) {
            CustomViewHolder customViewHolder = (CustomViewHolder) holder;
            if (movie instanceof Movie) {
                Movie movie1 = (Movie) movie;
                customViewHolder.title.setText(movie1.getTitle());
                customViewHolder.genre.setText(movie1.getGenre());
                customViewHolder.year.setText(movie1.getYear());
            }
        }


    }

    @Override
    public int getItemViewType(int position) {

        if (moviesList.get(position) instanceof ArrayList) {
            return PAGER_VIEW;
        } else {
            return CONTENT_VIEW;
        }
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public CustomViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
        }
    }


    public class CustomViewHolder1 extends RecyclerView.ViewHolder {
        public ViewPager pager;

        public CustomViewHolder1(View view) {
            super(view);
            pager = (ViewPager) view.findViewById(R.id.pager);
//            genre = (TextView) view.findViewById(R.id.genre);
//            year = (TextView) view.findViewById(R.id.year);
        }
    }
}
