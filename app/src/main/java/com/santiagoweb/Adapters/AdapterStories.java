package com.santiagoweb.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.santiagoweb.Model.seriesResponse;
import com.santiagoweb.Model.storiesResponse;
import com.santiagoweb.R;

import java.util.ArrayList;


public class AdapterStories extends RecyclerView.Adapter<AdapterStories.RecyclerViewHolder> implements  Filterable {


    private ArrayList<storiesResponse.ResultsEntity> dataSet;
    private ArrayList<storiesResponse.ResultsEntity> mFilteredList;
    private Activity activity;

    public AdapterStories(ArrayList<storiesResponse.ResultsEntity> array, Activity activity) {
        this.dataSet = array;
        this.mFilteredList = array;
        this.activity = activity;

    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_caracter, viewGroup, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int i) {
        storiesResponse.ResultsEntity data = mFilteredList.get(i);
        holder.text_title.setText(data.getTitle());
        holder.itemView.setOnClickListener(view -> {
//            Intent startIntent = new Intent(activity, DetailMovieActivity.class);
//            startIntent.putExtra("ItemDetail", item);
//            activity.startActivity(startIntent,
//                    ActivityOptions.makeSceneTransitionAnimation(activity).toBundle());
        });

    }

    @Override
    public int getItemCount() {
        return mFilteredList.size();
    }


    static  class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView text_title;

        RecyclerViewHolder(View view) {
            super(view);
            text_title = view.findViewById(R.id.textView_name);
        }

    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty()) {
                    mFilteredList = dataSet;
                } else {

                    ArrayList<storiesResponse.ResultsEntity> filteredList = new ArrayList<>();

                    for (storiesResponse.ResultsEntity row : dataSet) {

//                        if (row.getNombre().toLowerCase().contains(charString) ){ //|| androidVersion.getName().toLowerCase().contains(charString) || androidVersion.getVer().toLowerCase().contains(charString)) {
//                            filteredList.add(row);
//                        }
                    }
                    mFilteredList = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (ArrayList<storiesResponse.ResultsEntity>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}

