package com.example.recyclerviewa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerviewa.adapter.GardenAdapter;
import com.example.recyclerviewa.adapter.GardenAdapterClickListener;
import com.example.recyclerviewa.adapter.OnLoadMoreListener;
import com.example.recyclerviewa.model.Garden;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnLoadMoreListener,GardenAdapterClickListener {

    //array list
    ArrayList<Garden> garden;
    private RecyclerView recyclerView;
    private GardenAdapter gardenAdapter;

    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        gardenAdapter = new GardenAdapter(this,this,this,gardens());

     //  layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true);
        layoutManager = new GridLayoutManager(this,2,RecyclerView.VERTICAL,true);
     //   layoutManager = new GridLayoutManager(this,2,RecyclerView.VERTICAL,true);

       recyclerView.setLayoutManager(layoutManager);
     // recyclerView.setLayoutManager(new LinearLayoutManager(this));
      //
      //  LinearLayoutManager layoutManager = new LinearLayoutManager();
        recyclerView.setAdapter(gardenAdapter);
    }
    private ArrayList<Garden> gardens(){
        garden = new ArrayList<>();
        //data
     //   garden = new ArrayList<>();
        garden.add(new Garden("Tomato","Flower","Description",R.drawable.tomato));
        garden.add(new Garden("Apple","Fruit","An apple is a sweet, edible fruit produced by an apple tree (Malus pumila). Apple trees are cultivated worldwide, and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today. Apples have been grown for thousands of years in Asia and Europe, and were brought to North America by European colonists. Apples have religious and mythological significance in many cultures, including Norse, Greek and European Christian traditions.<br><br>Apple trees are large if grown from seed. Generally apple cultivars are propagated by grafting onto rootstocks, which control the size of the resulting tree. There are more than 7,500 known cultivars of apples, resulting in a range of desired characteristics. Different cultivars are bred for various tastes and uses, including cooking, eating raw and cider production. Trees and fruit are prone to a number of fungal, bacterial and pest problems, which can be controlled by a number of organic and non-organic means. In 2010, the fruit's genome was sequenced as part of research on disease control and selective breeding in apple production.<br><br>Worldwide production of apples in 2014 was 84.6 million tonnes, with China accounting for 48% of the total.<br><br>(From <a href=\"https://en.wikipedia.org/wiki/Apple\">Wikipedia</a>)",R.drawable.apple));
        garden.add(new Garden("Beetroot","Fruit","Description",R.drawable.beetroot));
        garden.add(new Garden("Branch fruit","Fruit","Description",R.drawable.branch_and_fruit));
        garden.add(new Garden("Eggplant","Fruit","Description",R.drawable.eggplant));
        garden.add(new Garden("Tomato","Fruit","Description",R.drawable.tomato));
        garden.add(new Garden("Apple","Fruit","Description",R.drawable.apple));
        garden.add(new Garden("Beetroot","Fruit","Description",R.drawable.beetroot));
        garden.add(new Garden("Branch fruit","Category garden","Description",R.drawable.branch_and_fruit));
        garden.add(new Garden("Eggplant","Category garden","Description",R.drawable.eggplant));
        garden.add(new Garden("Tomato","Category garden","Description",R.drawable.tomato));
        garden.add(new Garden("Apple","Category garden","Description",R.drawable.apple));
        garden.add(new Garden("Beetroot","Category garden","Description",R.drawable.beetroot));
        garden.add(new Garden("Branch fruit","Category garden","Description",R.drawable.branch_and_fruit));
        garden.add(new Garden("Eggplant","Category garden","Description",R.drawable.eggplant));
        garden.add(new Garden("Tomato","Category garden","Description",R.drawable.tomato));
        garden.add(new Garden("Apple","Category garden","Description",R.drawable.apple));
        garden.add(new Garden("Beetroot","Category garden","Description",R.drawable.beetroot));
        garden.add(new Garden("Branch fruit","Category garden","Description",R.drawable.branch_and_fruit));
        garden.add(new Garden("Eggplant","Category garden","Description",R.drawable.eggplant));
        garden.add(new Garden("Tomato","Category garden","Description",R.drawable.tomato));
        garden.add(new Garden("Apple","Category garden","Description",R.drawable.apple));
        garden.add(new Garden("Beetroot","Category garden","Description",R.drawable.beetroot));
        garden.add(new Garden("Branch fruit","Category garden","Description",R.drawable.branch_and_fruit));
        garden.add(new Garden("Eggplant","Category garden","Description",R.drawable.eggplant));

        return garden;
    }

    @Override
    public void onLoadMore() {
        recyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                gardenAdapter.updateGardenData(gardens());
            }
        },2000);
    }

    @Override
    public void onGardenClick(Garden garden) {
        Toast.makeText(this, "Name Garden: " + garden.getName(), Toast.LENGTH_SHORT).show();
    }
}
