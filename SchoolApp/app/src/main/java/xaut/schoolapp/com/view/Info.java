package xaut.schoolapp.com.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import xaut.schoolapp.com.controller.ActivityControl;
import xaut.schoolapp.com.schoolapp.R;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_info);
        ActivityControl.addActivity(this);
    }
}
