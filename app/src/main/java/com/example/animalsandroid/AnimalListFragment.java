package com.example.animalsandroid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class AnimalListFragment extends Fragment {
    private List<Animal> animalList;
    private RecyclerView recyclerView;
    private AnimalListAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the list of animals from strings.xml
        animalList = new ArrayList<>();
        String[] animalNames = getResources().getStringArray(R.array.animal_names);
        String[] animalContinents = getResources().getStringArray(R.array.animal_continents);
        for (int i = 0; i < animalNames.length; i++) {
            animalList.add(new Animal(animalNames[i], animalContinents[i]));
        }
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.animal_list_fragment, container, false);
        recyclerView = rootView.findViewById(R.id.animalRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new AnimalListAdapter(animalList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new AnimalListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Animal animal) {
                AnimalDetailsFragment fragment = new AnimalDetailsFragment();
                Bundle args = new Bundle();
                args.putString("name", animal.getName());
                args.putString("continent", animal.getContinent());
                args.putInt("backgroundColor", animal.getBackgroundColor());
                fragment.setArguments(args);
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return rootView;
    }
}