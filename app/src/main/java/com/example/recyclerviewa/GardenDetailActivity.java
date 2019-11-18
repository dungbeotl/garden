package com.example.recyclerviewa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GardenDetailActivity extends AppCompatActivity {
    public TextView tvDetailName,tvDetailCategory,tvDetailDescription;
    public ImageView ivDetail;

    public String name,category,description;
    public int img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garden_detail);

        tvDetailName= findViewById(R.id.tvDetailName);
        tvDetailCategory =findViewById(R.id.tvDetailCategory);
        tvDetailDescription = findViewById(R.id.tvDetailDescription);
        ivDetail = findViewById(R.id.iv_detail);

        //Recieve date
        Intent intent = getIntent();
        name = intent.getStringExtra("Name");
        //  name = intent.getExtras().getString("Name");
        category = intent.getExtras().getString("Category");
        description = intent.getExtras().getString("Description");
        img = intent.getExtras().getInt("Thumbnail");

        //set data
        tvDetailName.setText(name);
        tvDetailCategory.setText(category);
        tvDetailDescription.setText(description);
        ivDetail.setImageResource(img);
    }
}
