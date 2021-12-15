package com.example.footballcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private int ros = 0;
private int germ = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        resetUI();
    }

    @Override
    protected void onSaveInstanceState(Bundle outstate) {
        super.onSaveInstanceState(outstate);
        outstate.putInt("argcount", ros);
        outstate.putInt("jamcount", germ);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null &&
                savedInstanceState.containsKey("argcount")&&savedInstanceState.containsKey("jamcount")) {
            ros = savedInstanceState.getInt("argcount");
            germ = savedInstanceState.getInt("jamcount");}


    }

    private void resetUI() {
        ((TextView) findViewById(R.id.jam)).setText("" + germ);
        ((TextView) findViewById(R.id.arg)).setText("" + ros);
    }



    public void addArg(View view) {
        ros++;
        TextView counterView = (TextView)findViewById(R.id.arg);
        counterView.setText(""+ros);
    }
    public void addJam(View view) {
        germ++;
        TextView counterView = (TextView)findViewById(R.id.jam);
        counterView.setText(""+germ);
    }
    public void resetAll(View view) {
        ros=0;
        germ=0;
        TextView counterView = (TextView)findViewById(R.id.arg);
        counterView.setText(""+ros);
        counterView = (TextView)findViewById(R.id.jam);
        counterView.setText(""+germ);
    }
}