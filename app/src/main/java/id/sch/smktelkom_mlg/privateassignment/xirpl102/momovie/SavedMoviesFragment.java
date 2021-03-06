package id.sch.smktelkom_mlg.privateassignment.xirpl102.momovie;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl102.momovie.adapter.SavedAdapter;
import id.sch.smktelkom_mlg.privateassignment.xirpl102.momovie.item.SavedItemList;

/**
 * Created by Aqshal-kun on 5/15/2017.
 */

public class SavedMoviesFragment extends Fragment {

    ArrayList<SavedItemList> fList;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;


    public SavedMoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_saved, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewSaved);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        fList = new ArrayList<>();

        adapter = new SavedAdapter(fList, getActivity().getApplicationContext());
        recyclerView.setAdapter(adapter);

        fList.addAll(SavedItemList.listAll(SavedItemList.class));
        adapter.notifyDataSetChanged();


        return view;

    }

}

