package id.sch.smktelkom_mlg.privateassignment.xirpl102.momovie.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import id.sch.smktelkom_mlg.privateassignment.xirpl102.momovie.DetailActivityPopular;
import id.sch.smktelkom_mlg.privateassignment.xirpl102.momovie.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl102.momovie.item.PopularItem;


/**
 * Created by Aqshal-kun on 5/15/2017.
 */

public class PopularMoviesAdapter extends RecyclerView.Adapter<PopularMoviesAdapter.ViewHolder> {

    private List<PopularItem> listItems;
    private Context context;

    public PopularMoviesAdapter(List<PopularItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public PopularMoviesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        return new PopularMoviesAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final PopularItem listItem = listItems.get(position);

        holder.textViewJudul.setText(listItem.getJudul());
        holder.textViewDesc.setText(listItem.getDesc());

        Glide.with(context)
                .load("http://image.tmdb.org/t/p/w500" + listItem.getImageUrl())
                .into(holder.imageView);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Detail for " + listItem.getJudul(), Toast.LENGTH_LONG).show();
                Intent singleBlogIntent = new Intent(context, DetailActivityPopular.class);
                singleBlogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                singleBlogIntent.putExtra("blog_id", position);
                singleBlogIntent.putExtra("judul", listItem.getJudul());

                context.startActivity(singleBlogIntent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return listItems.size();


    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewJudul;
        public TextView textViewDesc;
        public ImageView imageView;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewJudul = (TextView) itemView.findViewById(R.id.textViewJudul);
            textViewDesc = (TextView) itemView.findViewById(R.id.textViewDeskripsi);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }
}

