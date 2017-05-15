package id.sch.smktelkom_mlg.privateassignment.xirpl102.momovie.model;

/**
 * Created by Aqshal-kun on 5/15/2017.
 */

import com.orm.SugarRecord;

import java.io.Serializable;

public class FavouriteItem extends SugarRecord implements Serializable {
    public String judul;
    public String deskripsi;
    public String urlgambar;

    public FavouriteItem() {
    }

    public FavouriteItem(String judul, String deskripsi, String urlgambar) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.urlgambar = urlgambar;
    }
}
