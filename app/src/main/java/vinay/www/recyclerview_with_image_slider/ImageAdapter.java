package vinay.www.recyclerview_with_image_slider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by vppl-10160 on 28-02-2017.
 */

public class ImageAdapter extends PagerAdapter {

    Context context;

    ArrayList<Item> mediaGallary;
    LayoutInflater mLayoutInflater;

    public ImageAdapter(Context context, ArrayList<Item> mediaGallary) {
        this.context = context;
        this.mediaGallary = mediaGallary;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return null == mediaGallary ? 0 : mediaGallary.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
//        imageView.setImageResource(mediaGallary[position]);
        Picasso.with(context)
                .load(mediaGallary.get(position).getPicture().toString())
                .into(imageView);

        imageView.setImageResource(R.drawable.image1);
        container.addView(itemView);

        return itemView;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);

    }

}
