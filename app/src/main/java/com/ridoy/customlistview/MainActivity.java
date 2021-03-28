package com.ridoy.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    ArrayList<listitem> universitynames=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listviewid);

        universitynames.add(new listitem("1",R.drawable.ic_launcher_background));
        universitynames.add(new listitem("2",R.drawable.ic_launcher_background));
        universitynames.add(new listitem("3",R.drawable.ic_launcher_background));
        universitynames.add(new listitem("4",R.drawable.ic_launcher_background));
        universitynames.add(new listitem("5",R.drawable.ic_launcher_background));
        universitynames.add(new listitem("6",R.drawable.ic_launcher_background));
        universitynames.add(new listitem("7",R.drawable.ic_launcher_background));
        universitynames.add(new listitem("8",R.drawable.ic_launcher_background));
        universitynames.add(new listitem("9",R.drawable.ic_launcher_background));
        listView.setAdapter(new customadapter(MainActivity.this,R.layout.listitemlayout,universitynames));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);

        MenuItem menuitem= menu.findItem(R.id.searchid);

        SearchView searchView= (SearchView) menuitem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                ArrayList<listitem> result= new ArrayList<>();
                for (listitem x: universitynames)
                {
                    if (x.university_name.contains(newText))
                    {
                        result.add(x);
                    }

                }
                ((customadapter)listView.getAdapter()).update(result);

                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}