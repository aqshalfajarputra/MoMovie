package id.sch.smktelkom_mlg.privateassignment.xirpl102.momovie.model;

/**
 * Created by Aqshal-kun on 5/15/2017.
 */

import com.orm.SugarRecord;

import java.io.Serializable;

public class MainListItem extends SugarRecord implements Serializable {

    private String imageUrl;
    private String head;
    private String desc;

    public MainListItem(String imageUrl, String head, String desc) {
        this.imageUrl = imageUrl;
        this.head = head;
        this.desc = desc;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }
}