package vinay.www.recyclerview_with_image_slider;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    RecyclerView mRecyclerView;
    CustomeAdapter customeAdapter;
    private List<Object> movieList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Object> pictureList = new ArrayList<>();
        Item item = new Item("Mad Max: Fury Road", "http://www.wun.ac.uk/images/researchgroups/data.jpg");
        pictureList.add(item);

        item = new Item("Mad Max: Fury Road", "http://bigdatasp.com/wp-content/uploads/2015/06/bd2.jpg");
        pictureList.add(item);

        item = new Item("Mad Max: Fury Road", "http://bigdatasp.com/wp-content/uploads/2015/06/bd2.jpg");
        pictureList.add(item);

        item = new Item("Mad Max: Fury Road", "http://bigdatasp.com/wp-content/uploads/2015/06/bd2.jpg");
        pictureList.add(item);

        item = new Item("Mad Max: Fury Road", "http://bigdatasp.com/wp-content/uploads/2015/06/bd2.jpg");
        pictureList.add(item);
        
        movieList.add(pictureList);
        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);
        movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);
        movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);
        movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);
        movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);
        movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        movieList.add(movie);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);
        customeAdapter = new CustomeAdapter(getApplicationContext(), movieList);

        mRecyclerView.setAdapter(customeAdapter);

    }
}
