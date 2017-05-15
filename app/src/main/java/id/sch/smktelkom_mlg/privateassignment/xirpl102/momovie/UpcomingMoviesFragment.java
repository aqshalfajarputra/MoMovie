package id.sch.smktelkom_mlg.privateassignment.xirpl102.momovie;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import id.sch.smktelkom_mlg.privateassignment.xirpl102.momovie.adapter.UpcomingMoviesAdapter;
import id.sch.smktelkom_mlg.privateassignment.xirpl102.momovie.item.UpcomingItem;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpcomingMoviesFragment extends Fragment {

    private static final String URL_DATA = "https://api.themoviedb.org/3/movie/upcoming?api_key=cb3606bd72bdaa179217ab4e5a2d1348&language=en-US&page=1";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<UpcomingItem> upcomingItemList;


    public UpcomingMoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_upcoming_movies, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewUp);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        upcomingItemList = new ArrayList<>();
        loadRecyclerViewData();
        return view;
    }


    private void loadRecyclerViewData() {
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading data..");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            JSONArray array = jsonObject.getJSONArray("results");

                            for (int i = 0; i < array.length(); i++) {
                                JSONObject o = array.getJSONObject(i);
                                UpcomingItem item = new UpcomingItem(
                                        o.getString("title"),
                                        o.getString("overview"),
                                        o.getString("poster_path")
                                );

                                upcomingItemList.add(item);
                            }
                            adapter = new UpcomingMoviesAdapter(upcomingItemList, getActivity().getApplicationContext());
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }

}