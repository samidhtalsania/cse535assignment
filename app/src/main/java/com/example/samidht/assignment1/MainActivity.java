package com.example.samidht.assignment1;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int state = 0;
    private static int random_numbers = 50;
    private static int label_numbers = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final float[] randoms = new float[random_numbers];
        final String[] hlabels = new String[]{"10","20","30","40","50","60","70","80","90","100"};
        final String[] vlabels = new String[]{"500","1000","1500","2000"};

        Random random = new Random();

        for (int i=0;i<random_numbers;i++){
            randoms[i] = random.nextFloat();
        }



        final GraphView gv = new GraphView(this, randoms, "Assignment 1 ST", hlabels,vlabels,true );
        final GraphView gvEmpty = new GraphView(this, new float[50], "Assignment 1 ST", hlabels,vlabels,true );
        final LinearLayout ll = (LinearLayout) findViewById(R.id.gvContainer);

        Button startBtn = (Button) findViewById(R.id.runBtn);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(state == 0) {
                    state = 1;
                    ll.removeAllViews();
                    ll.addView(gv,0,new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                }

            }
        });

        Button stopBtn = (Button) findViewById(R.id.stopBtn);
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(state == 1) {
                    state = 0;

                    ll.addView(gvEmpty,0,new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                }
            }
        });

    }
}
