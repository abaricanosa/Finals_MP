package com.example.finals_mp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNv;
    private FrameLayout frameLayout;
    static RoomDatabaseClass roomDatabaseClass;
    FragmentManager fragmentManager;
    private  RecyclerAdapter recyclerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roomDatabaseClass= Room.databaseBuilder(getApplicationContext(),RoomDatabaseClass.class,"mydb").allowMainThreadQueries().build();
        initComponents();
        if(savedInstanceState == null){

            getSupportFragmentManager().beginTransaction().replace(R.id.main_framelayout,
                    new HomeFragment()).commit();
        }
        bottomNv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.home_n:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_framelayout,
                                new HomeFragment()).commit();
                        break;
                    case R.id.add_n:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_framelayout,
                                new AddDataFragment()).commit();
                        break;
                    case R.id.update_n:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_framelayout,
                                new UpdateFragment()).commit();
                        break;
                }
                return true;
            }
        });

    }

    private void initComponents(){


        bottomNv = findViewById(R.id.main_bottom_nav);
        frameLayout = findViewById(R.id.main_framelayout);
    }


}