package com.santiagoweb.Ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.santiagoweb.Adapters.AdapterCharacter;
import com.santiagoweb.Adapters.AdapterComics;
import com.santiagoweb.Adapters.AdapterCreators;
import com.santiagoweb.Adapters.AdapterEvents;
import com.santiagoweb.Adapters.AdapterSeries;
import com.santiagoweb.Adapters.AdapterStories;
import com.santiagoweb.Model.ComicDto.Comics;
import com.santiagoweb.Model.charactersResponse;
import com.santiagoweb.Model.creatorsResponse;
import com.santiagoweb.Model.eventsResponse;
import com.santiagoweb.Model.seriesResponse;
import com.santiagoweb.Model.storiesResponse;
import com.santiagoweb.R;
import com.santiagoweb.Viewmodels.ComicsViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;

    ArrayList<Comics> articleArrayList = new ArrayList<>();
    ArrayList<charactersResponse.ResultsEntity> chareArrayList = new ArrayList<>();
    ArrayList<creatorsResponse.ResultsEntity> creatorsArrayList = new ArrayList<>();
    ArrayList<eventsResponse.ResultsEntity> eventsArrayList = new ArrayList<>();
    ArrayList<seriesResponse.ResultsEntity> seriesArrayList = new ArrayList<>();
    ArrayList<storiesResponse.ResultsEntity> storiesArrayList = new ArrayList<>();
    ComicsViewModel viewmodel;

    // TODO: Rename and change types of parameters
    private int mTypeResult;

    private OnFragmentInteractionListener mListener;

    public ListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(int param1) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTypeResult = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycler = view.findViewById(R.id.recyclerview_comics);
        InitGridRecycler(2);


        viewmodel = ViewModelProviders.of(this).get(ComicsViewModel.class);
        viewmodel.setmTypeFragment(mTypeResult);

        switch (mTypeResult){
            case 0: //characters
                InitChare();
                break;
            case 1:  //Comics
                InitComic();
                break;
            case 2:  //Comics
                InitComic();
                break;
            case 3: //creators
                InitCreators();
                break;
            case 4: //events
                InitEvents();
                break;
            case 5: //series
                InitSeries();
                break;
            case 6: //events
                InitStories();
                break;

        }
    }

    private void InitComic(){
        InitGridRecycler(2);
        adapter = new AdapterComics(articleArrayList, getActivity());
        recycler.setAdapter(adapter);

        viewmodel.init();
        viewmodel.getComicRepository().observe(this, newsResponse -> {
            System.out.println("RESULT API "+newsResponse);
            System.out.println(newsResponse.toString());
            List<Comics> newsArticles = newsResponse.getData().getComicsList();
            articleArrayList.addAll(newsArticles);
            adapter.notifyDataSetChanged();
        });
    }
    private void InitChare(){
        InitGridRecycler(1);
        adapter = new AdapterCharacter(chareArrayList, getActivity());
        recycler.setAdapter(adapter);

        viewmodel.init();
        viewmodel.getChareRepository().observe(this, newsResponse -> {
            System.out.println("RESULT API "+newsResponse);
            System.out.println(newsResponse.toString());
            List<charactersResponse.ResultsEntity> newsArticles = newsResponse.getData().getResults();
            chareArrayList.addAll(newsArticles);
            adapter.notifyDataSetChanged();
        });
    }

    private void InitCreators(){
        InitGridRecycler(2);
        adapter = new AdapterCreators(creatorsArrayList, getActivity());
        recycler.setAdapter(adapter);

        viewmodel.init();
        viewmodel.getCreatorseRepository().observe(this, newsResponse -> {
            System.out.println("RESULT API "+newsResponse);
            List<creatorsResponse.ResultsEntity> newsArticles = newsResponse.getData().getResults();
            creatorsArrayList.addAll(newsArticles);
            adapter.notifyDataSetChanged();
        });
    }


    private void InitEvents(){
        InitGridRecycler(2);
        adapter = new AdapterEvents(eventsArrayList, getActivity());
        recycler.setAdapter(adapter);

        viewmodel.init();
        viewmodel.getCreatorseRepoevents().observe(this, newsResponse -> {
            System.out.println("RESULT API "+newsResponse);
            List<eventsResponse.ResultsEntity> newsArticles = newsResponse.getData().getResults();
            eventsArrayList.addAll(newsArticles);
            adapter.notifyDataSetChanged();
        });
    }
    private void InitSeries(){
        InitGridRecycler(1);
        adapter = new AdapterSeries(seriesArrayList, getActivity());
        recycler.setAdapter(adapter);

        viewmodel.init();
        viewmodel.getCreatorseReposeries().observe(this, newsResponse -> {
            System.out.println("RESULT API "+newsResponse);
            List<seriesResponse.ResultsEntity> newsArticles = newsResponse.getData().getResults();
            seriesArrayList.addAll(newsArticles);
            adapter.notifyDataSetChanged();
        });
    }
    private void InitStories(){
        InitGridRecycler(1);
        adapter = new AdapterStories(storiesArrayList, getActivity());
        recycler.setAdapter(adapter);

        viewmodel.init();
        viewmodel.getCreatorseRepostories().observe(this, newsResponse -> {
            System.out.println("RESULT API "+newsResponse);
            List<storiesResponse.ResultsEntity> newsArticles = newsResponse.getData().getResults();
            storiesArrayList.addAll(newsArticles);
            adapter.notifyDataSetChanged();
        });
    }

    private void InitGridRecycler(int i){
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), i);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(mLayoutManager);
        recycler.setItemAnimator(new DefaultItemAnimator());
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
