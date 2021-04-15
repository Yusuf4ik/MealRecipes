package itacademy.kg.mealrecipes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {


    RecyclerView recyclerView;
    MealAdapter adapter;
    TextView nameOfMeal2, time2, descriptions2;
    ImageView favorite, favorite2, MealImage2;

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mealList();

        dataBase.maybe = true;
        buildRecyclerView();

        favorite = findViewById(R.id.favorite1);
        adapter.setMealOnClickListener(new MealOnClickListener() {
            @Override
            public void onClickFood(int position) {
                Intent intent = new Intent(MainActivity.this, DescriptionsActivity.class);
                intent.putExtra("listMeal", String.valueOf(position));
                startActivity(intent);
            }

            @Override
            public void onClickFavorite(int position) {
                Intent intent = new Intent(MainActivity.this, FavouriteActivity.class);
                intent.putExtra("food", position);
                adapter.notifyItemChanged(position);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public  void mealList() {

        dataBase.mealArrayList.add(new Meal(R.drawable.food1, "15 MINS", "Food1", "EasyCook, just cook it", R.drawable.ic_baseline_favorite_border_24));
        dataBase.mealArrayList.add(new Meal(R.drawable.food2, "35 MINS", "Food2", "EasyCook, just cook it", R.drawable.ic_baseline_favorite_border_24));
        dataBase.mealArrayList.add(new Meal(R.drawable.food3, "50 MINS", "Food3", "EasyCook, just cook it", R.drawable.ic_baseline_favorite_border_24));
    }

    private void buildRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MealAdapter(dataBase.mealArrayList);
        recyclerView.setAdapter(adapter);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()) {
            case R.id.settings:
                dataBase.maybe = false;
                Intent  intent = new Intent(MainActivity.this, FavouriteActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    public void click() {
        Toast.makeText(MainActivity.this, "asd", Toast.LENGTH_LONG).show();
    }

}