package com.example.animalsandroid;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AnimalListAdapter extends RecyclerView.Adapter<AnimalListAdapter.ViewHolder> {
    private static List<Animal> animalList;
    private static OnItemClickListener listener;

    public AnimalListAdapter(List<Animal> animalList) {
        this.animalList = animalList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Animal animal = animalList.get(position);
        holder.bind(animal, listener);
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView animalNameTextView;
        private TextView animalContinentTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            animalNameTextView = itemView.findViewById(R.id.animalNameTextView);
            animalContinentTextView = itemView.findViewById(R.id.animalContinentTextView);
            itemView.setOnClickListener(this);
        }
        public void bind(Animal animal, OnItemClickListener listener) {
            animalNameTextView.setText(animal.getName());
            animalContinentTextView.setText(animal.getContinent());
            int backgroundColor = 0;
            Drawable lineDrawable = ContextCompat.getDrawable(itemView.getContext(), R.drawable.black_line);
            switch (animal.getContinent()) {
                case "Europa":
                    backgroundColor = R.color.colorEuropa;
                   animalContinentTextView.setGravity(Gravity.START);
                    animalNameTextView.setGravity(Gravity.START);
                    break;
                case "Africa":
                    backgroundColor = R.color.colorAfrica;
                    animalNameTextView.setGravity(Gravity.START);
                    animalContinentTextView.setGravity(Gravity.END);
                    break;
                case "Asia":
                    backgroundColor = R.color.colorAsia;
                    animalContinentTextView.setGravity(Gravity.CENTER);
                    animalNameTextView.setGravity(Gravity.CENTER);
                    break;
                case "America":
                    backgroundColor = R.color.colorAmerica;
                    animalNameTextView.setGravity(Gravity.END);
                    animalContinentTextView.setGravity(Gravity.END);
                    break;
                case "Australia":
                    backgroundColor = R.color.colorAustralia;
                    animalNameTextView.setGravity(Gravity.CENTER);
                    animalContinentTextView.setGravity(Gravity.CENTER);
                    break;
                default:
                    break;
            }
            itemView.setBackgroundColor(ContextCompat.getColor(itemView.getContext(), backgroundColor));

            itemView.setOnClickListener(view -> {
                if (listener != null) {
                    listener.onItemClick(animal);
                }
            });
        }
        @Override
        public void onClick(View view) {
            int position = getBindingAdapterPosition();
            if (position != RecyclerView.NO_POSITION && listener != null) {
                listener.onItemClick(animalList.get(position));
            }
        }
    }
    public interface OnItemClickListener {
        void onItemClick(Animal animal);
    }
}