package id.sch.smktelkom_mlg.privateassignment.xirpl102.momovie.item;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by Aqshal-kun on 5/15/2017.
 */

public class SavedItemList extends SugarRecord implements Serializable {
    public String judul;
    public String judulasli;
    public String tahun;
    public String rating;
    public String overview;
    public String images;

    public SavedItemList() {

    }

    public SavedItemList(String judul, String judulasli, String tahun, String rating, String overview, String images) {
        this.judul = judul;
        this.judulasli = judulasli;
        this.tahun = tahun;
        this.rating = rating;
        this.overview = overview;
        this.images = images;
    }
}
