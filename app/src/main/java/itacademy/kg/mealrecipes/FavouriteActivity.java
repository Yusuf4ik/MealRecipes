package itacademy.kg.mealrecipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;

public class FavouriteActivity extends AppCompatActivity {

    ImageView favoriteBold, MealImage2;
    RecyclerView recyclerView;
    TextView time2, descriptions2, nameOfMeal2;
    ArrayList<Meal> mealList;
    MealAdapter adapter;

    Meal meal;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent =getIntent();
        position = intent.getIntExtra("food", 0);
        MealImage2 = (ImageView) findViewById(R.id.mealImage1);
        time2 = (TextView) findViewById(R.id.time1);
        descriptions2 = (TextView) findViewById(R.id.description1);
        nameOfMeal2 = (TextView) findViewById(R.id.nameOfMeal1);

        mealList = Meal.meals;

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MealAdapter(mealList);
        recyclerView.setAdapter(adapter);
//      givingInfo();


    }

//    public void givingInfo() {
//
//        Meal currentItem = dataBase.mealArrayList.get(position);
//        time2.setText(currentItem.getTime());
//        descriptions2.setText(currentItem.getDescription());
//        nameOfMeal2.setText(currentItem.getName());
//        MealImage2.setImageResource(currentItem.getImageResource());
//
//    }

}