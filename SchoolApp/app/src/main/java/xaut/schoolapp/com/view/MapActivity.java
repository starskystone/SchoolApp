package xaut.schoolapp.com.view;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import xaut.schoolapp.com.imageview.ImageViewPlus;
import xaut.schoolapp.com.controller.ActivityControl;
import xaut.schoolapp.com.schoolapp.R;

public class MapActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mEditText;
    private ImageViewPlus mImage;
    private Fragment mFragment;
    private Mapdata mMapdata = new Mapdata();       //地图界面的数据
    private BMap mBMap = new BMap();                //百度地图


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setDefaultFragment(mBMap);
        setContentView(R.layout.activity_map);
        ActivityControl.addActivity(this);
        mEditText = (EditText) findViewById(R.id.tv_SchoolName);
        mImage = (ImageViewPlus) findViewById(R.id.imv_UserIcon);

        mEditText.setOnClickListener(this);     //输入学校监听
        mImage.setOnClickListener(this);        //点击用户图片监听

    }

    public void onClick(View v) {         //监听事件
        switch (v.getId()) {
            case R.id.imv_UserIcon:
                Intent intent = new Intent(MapActivity.this, Setting.class);
                startActivity(intent);
                break;

            case R.id.tv_SchoolName:
                switchContent(mMapdata);

                break;
            default:
                break;
        }

    }

    public void setDefaultFragment(Fragment fragment) {
        FragmentManager mFragmentManager;
        FragmentTransaction mFragmentTransaction;
        mFragmentManager = getFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.add(R.id.parent_fragement, fragment);
        mFragment = fragment;
    }

    public void switchContent(Fragment fragment) {
        if (mFragment != fragment) {
            FragmentManager mFragmentManager;
            FragmentTransaction mFragmentTransaction;
            mFragmentManager = getFragmentManager();
            mFragmentTransaction = mFragmentManager.beginTransaction();
            if (!fragment.isAdded()) {
                mFragmentTransaction.hide(mFragment).add(R.id.parent_fragement, fragment);
                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.commit();
            }
        }else {
                FragmentManager mFragmentManager;
                FragmentTransaction mFragmentTransaction;
                mFragmentManager = getFragmentManager();
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.hide(mBMap).show(mMapdata);
                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.commit();
            }
        //mFragment = fragment;
        }

}

