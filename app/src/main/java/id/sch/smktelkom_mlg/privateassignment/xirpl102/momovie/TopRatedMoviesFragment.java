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

import id.sch.smktelkom_mlg.privateassignment.xirpl102.momovie.adapter.TopRatedMoviesAdapter;
import id.sch.smktelkom_mlg.privateassignment.xirpl102.momovie.item.TopRatedItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopRatedMoviesFragment extends Fragment {

    private static final String URL_DATA = "https://api.themoviedb.org/3/movie/top_rated?api_key=cb3606bd72bdaa179217ab4e5a2d1348&language=en-US&page=1";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<TopRatedItem> topRatedItems;


    public TopRatedMoviesFragment() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top_rated_movies, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewTop);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        topRatedItems = new ArrayList<>();
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
                                TopRatedItem item = new TopRatedItem(
                                        o.getString("title"),
                                        o.getString("overview"),
                                        o.getString("poster_path")
                                );

                                topRatedItems.add(item);
                            }
                            adapter = new TopRatedMoviesAdapter(topRatedItems, getActivity().getApplicationContext());
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