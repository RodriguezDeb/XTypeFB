package com.example.xtypee;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.

 */
public class InmueblesFragment extends Fragment {

    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;


    public InmueblesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_inmuebles, container, false);
        // Inflate the layout for this fragment
        int[] imageList = {R.drawable.huno,R.drawable.hdos,R.drawable.htres,R.drawable.hcuatro,R.drawable.hcinco};
        String[] tamanoList = {"120","221","321","98","165"};
        String[] nameList = {"Casa bonita 1","Casa bonita 2","Casa bonita 3","Casa bonita 4","Casa bonita 5"};
        String[] garageList = {"1","2","1","0","1"};
        String[] banoList = {"1","2","1","3","1"};
        String[] habiList = {"3","2","3","5","5"};
        String[] precioList = {"1200000","990000","3200000","980000","1650000"};
        String[] descList = {"Muy Bonito","Muy Pro","Muy Tilin","Muy Papoi","Muy XType"};

        for(int i=0; i < imageList.length; i++){
            listData = new ListData(nameList[i],tamanoList[i],garageList[i],descList[i],banoList[i],habiList[i],precioList[i],imageList[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new ListAdapter(getActivity(), dataArrayList);
        ListView listView = rootView.findViewById(R.id.listview);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), DetallesActivity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("garage", garageList[i]);
                intent.putExtra("tamano", tamanoList[i]);
                intent.putExtra("bano", banoList[i]);
                intent.putExtra("habitaciones", habiList[i]);
                intent.putExtra("precio", precioList[i]);
                intent.putExtra("descripcion", descList[i]);
                intent.putExtra("imagen", imageList[i]);
                startActivity(intent);
            }
        });
        return rootView;
    }
}