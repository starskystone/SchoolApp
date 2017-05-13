package xaut.schoolapp.com.view;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import xaut.schoolapp.com.controller.ActivityControl;
import xaut.schoolapp.com.schoolapp.R;

public class Setting extends AppCompatActivity implements View.OnClickListener{
    private ImageButton mImageButton;
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ActivityControl.addActivity(this);

        mImageButton = (ImageButton)findViewById(R.id.imv_Return);
        mButton = (Button)findViewById(R.id.btn_Exit);

        mImageButton.setOnClickListener(this);      //监听后退按钮
        mButton.setOnClickListener(this);           //监听退出按钮

    }
    public void onClick(View v){        //监听事件
        switch (v.getId()){
            case R.id.imv_Return:
                finish();
                break;
            case R.id.btn_Exit:
                ActivityControl.finishAll();
                break;
            default:
                break;
        }
    }
}
