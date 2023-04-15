package com.example.animalsandroid;

import static java.security.AccessController.getContext;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class AnimalDetailsFragment extends Fragment {
    private TextView nameTextView;
    private TextView continentTextView;
    private int backgroundColor;
    public AnimalDetailsFragment() {
    }

    public static AnimalDetailsFragment newInstance(String name, String continent, int backgroundColor) {
        AnimalDetailsFragment fragment = new AnimalDetailsFragment();
        Bundle args = new Bundle();
        args.putString("name", name);
        args.putString("continent", continent);
        args.putInt("backgroundColor", backgroundColor);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.animal_fragment_details, container, false);
        nameTextView = view.findViewById(R.id.animalNameTextView);
        continentTextView = view.findViewById(R.id.animalContinentTextView);
        Bundle args = getArguments();
        String name = args.getString("name");
        String continent = args.getString("continent");
        backgroundColor = args.getInt("backgroundColor");
        nameTextView.setText(name);
        continentTextView.setText(continent);
        view.setBackgroundColor(ContextCompat.getColor(getContext(), backgroundColor));
        return view;
    }
}