package com.santiagoweb.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.santiagoweb.Model.ComicDto.Comics;
import com.santiagoweb.R;

import java.util.ArrayList;


public class AdapterComics extends RecyclerView.Adapter<AdapterComics.RecyclerViewHolder> implements  Filterable {


    private ArrayList<Comics> dataSet;
    private ArrayList<Comics> mFilteredList;
    private Activity activity;

    public AdapterComics(ArrayList<Comics> array, Activity activity) {
        this.dataSet = array;
        this.mFilteredList = array;
        this.activity = activity;

    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_comic, viewGroup, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int i) {
        Comics comic = mFilteredList.get(i);

        if (comic.getImages().size()>0){
            System.out.println("ruta_imagen: "+comic.getImages().get(0).getPath()+"/landscape_medium."+comic.getImages().get(0).getExtension());
            Glide.with(activity)
                    .load(comic.getImages().get(0).getPath()+"/landscape_medium."+comic.getImages().get(0).getExtension())
                    .into(holder.img);
        }

        holder.text_title.setText(comic.getTitle());

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
        ImageView img;

        RecyclerViewHolder(View view) {
            super(view);
            img = view.findViewById(R.id.imageView_item);
            text_title = view.findViewById(R.id.textView_title_item);
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

                    ArrayList<Comics> filteredList = new ArrayList<>();

                    for (Comics row : dataSet) {

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
                mFilteredList = (ArrayList<Comics>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}

