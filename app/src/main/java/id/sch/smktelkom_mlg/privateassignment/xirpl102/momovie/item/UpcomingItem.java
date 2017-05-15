package id.sch.smktelkom_mlg.privateassignment.xirpl102.momovie.item;

/**
 * Created by Aqshal-kun on 5/14/2017.
 */

public class UpcomingItem {

    private String judul;
    private String desc;
    private String imageUrl;

    public UpcomingItem(String judul, String desc, String imageUrl) {
        this.judul = judul;
        this.desc = desc;
        this.imageUrl = imageUrl;
    }

    public String getJudul() {
        return judul;
    }

    public String getDesc() {
        return desc;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}