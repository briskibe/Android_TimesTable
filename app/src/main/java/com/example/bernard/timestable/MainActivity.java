package com.example.bernard.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        ListView listView = (ListView) findViewById(R.id.listview);

        ArrayList<Integer> timesTableList = new ArrayList<Integer>();
        for (int i = 1; i < 11; i++)
            timesTableList.add(i);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, timesTableList);

        listView.setAdapter(adapter);

        seekBar.setProgress(1);
        seekBar.setMax(20);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress < 1) {
                    progress = 1;
                    seekBar.setProgress(progress);
                }

                ListView listView = (ListView) findViewById(R.id.listview);
                ArrayList<Integer> timesTableList = new ArrayList<Integer>();
                for (int i = 1; i < 11; i++)
                    timesTableList.add(i * progress);

                ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, timesTableList);

                listView.setAdapter(adapter);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //
            }
        });
    }
}
