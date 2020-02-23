package com.example.android.helloworld;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int mCount=0;
    private TextView mShowCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Log.d("MainActivity","Hello Log");
        mShowCount= findViewById(R.id.textView);
        if(savedInstanceState!=null) {
            mCount = savedInstanceState.getInt("count");
            mShowCount.setText(String.valueOf(mCount));
        }
    }

    public void showToast(View view) {
        Toast toast= Toast.makeText(this, R.string.toast_message,Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        if(mShowCount !=null)
            mShowCount.setText(Integer.toString(mCount));

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("count",mCount);
    }
}
