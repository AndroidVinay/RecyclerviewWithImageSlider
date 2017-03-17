package vinay.www.recyclerview_with_image_slider;

/**
 * Created by vppl-10160 on 28-02-2017.
 */

public class Item {

    private String title, picture;


    public Item(String title, String picture) {
        this.title = title;
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


}
