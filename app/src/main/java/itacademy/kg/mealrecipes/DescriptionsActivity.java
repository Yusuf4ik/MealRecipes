package itacademy.kg.mealrecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DescriptionsActivity extends AppCompatActivity {
    int position;
    TextView foodName, foodTime, foodDescription;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descriptions);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        foodName = (TextView) findViewById(R.id.foodName);
        foodTime = (TextView) findViewById(R.id.foodTime);
        foodDescription = (TextView) findViewById(R.id.foodDescription);
        imageView = (ImageView) findViewById(R.id.foodImage);

        givingInfo();

    }
    public void givingInfo(){
            Meal currentItem = dataBase.mealArrayList.get(position);
            foodName.setText(currentItem.getName());
            foodTime.setText(currentItem.getTime());
            foodDescription.setText(currentItem.getDescription());
            imageView.setImageResource(currentItem.getImageResource());
    }
}