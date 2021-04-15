package itacademy.kg.mealrecipes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.MealHolder> {

    private MealOnClickListener listener;


    public void setMealOnClickListener(MealOnClickListener listener) {
        this.listener = listener;
    }

    public static class MealHolder extends RecyclerView.ViewHolder {

        ImageView mealImage, favorite;
        TextView nameOfMeal, description, time;

        public MealHolder(@NonNull View itemView, MealOnClickListener listener, ArrayList<Meal> mealArrayList) {
            super(itemView);
            mealImage = itemView.findViewById(R.id.mealImage);
            nameOfMeal = itemView.findViewById(R.id.nameOfMeal);
            description = itemView.findViewById(R.id.description);
            time = itemView.findViewById(R.id.time);
            favorite = itemView.findViewById(R.id.favorite1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    listener.onClickFood(position);
                }
            });

            favorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    listener.onClickFavorite(position);

                    Meal meal = mealArrayList.get(getAdapterPosition());
                        favorite.setImageResource(R.drawable.ic_baseline_favorite_24);
                        Meal.addMeals(meal);



                }
            });
        }
    }

    private ArrayList<Meal> mealArrayList;

    public MealAdapter(ArrayList<Meal> meals) {
        this.mealArrayList = meals;
    }

    @NonNull
    @Override
    public MealAdapter.MealHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MealHolder mealHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_item, parent, false);
        mealHolder = new MealHolder(view, listener, mealArrayList);
        return mealHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MealAdapter.MealHolder holder, int position) {
        Meal currentItem = mealArrayList.get(position);
        holder.mealImage.setImageResource(currentItem.getImageResource());
        holder.nameOfMeal.setText(currentItem.getName());
        holder.description.setText(currentItem.getDescription());
        holder.time.setText(currentItem.getTime());

    }

    @Override
    public int getItemCount() {
        return mealArrayList.size();
    }
}
