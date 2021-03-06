package id.sch.smktelkom_mlg.privateassignment.xirpl102.momovie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl102.momovie.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl102.momovie.item.SavedItemList;

/**
 * Created by Aqshal-kun on 5/15/2017.
 */

public class SavedAdapter extends RecyclerView.Adapter<SavedAdapter.ViewHolder> {

    private final Context context;
    ArrayList<SavedItemList> fItem = new ArrayList<>();

    public SavedAdapter(ArrayList<SavedItemList> favouriteItem, Context context) {
        this.fItem = favouriteItem;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.saved_item_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final SavedItemList favouriteItem = fItem.get(position);
        holder.tvJudul.setText(favouriteItem.judul);
        holder.tvOverview.setText(favouriteItem.overview);

        Glide
                .with(context)
                .load("http://image.tmdb.org/t/p/w500" + favouriteItem.images)
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher)
                .into(holder.imgUrl);

        holder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final SavedItemList savedItemList1 = fItem.get(position);
                fItem.remove(position);
                savedItemList1.delete();
                SavedAdapter.this.notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return fItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvJudul;
        public TextView tvOverview;
        public ImageView imgUrl;
        public Button buttonDelete;

        public ViewHolder(View itemView) {
            super(itemView);

            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul2);
            tvOverview = (TextView) itemView.findViewById(R.id.textViewDeskripsi2);
            imgUrl = (ImageView) itemView.findViewById(R.id.imageView2);
            buttonDelete = (Button) itemView.findViewById(R.id.btDelete);
        }
    }
}
