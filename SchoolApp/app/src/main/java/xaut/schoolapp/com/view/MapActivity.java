package xaut.schoolapp.com.view;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import xaut.schoolapp.com.controller.RequestWebServece;

import xaut.schoolapp.com.controller.ResponseDataHandle;
import xaut.schoolapp.com.imageview.ImageViewPlus;
import xaut.schoolapp.com.controller.ActivityControl;
import xaut.schoolapp.com.model.Schoolinfo;
import xaut.schoolapp.com.model.UrlData;
import xaut.schoolapp.com.schoolapp.R;

public class MapActivity extends AppCompatActivity implements View.OnClickListener {
    //private EditText mEditText;
    private ImageViewPlus mImage;
    private ProgressDialog mydialog;
    private AutoCompleteTextView mTextView;
    private Handler handler;
    private ArrayAdapter<String> arrayAdapter = null;
    private ArrayList<String> info;
    private BMap mBMap;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Bundle bundle = new Bundle();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*setDefaultFragment(mBMap);*/
        mBMap = new BMap();
        registerFragment(mBMap);
        setContentView(R.layout.activity_map);
        ActivityControl.addActivity(this);
        handler=new Handler();

        mTextView = (AutoCompleteTextView) findViewById(R.id.tv_SchoolName) ;

        mTextView.setDropDownHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        mTextView.setThreshold(1);
        mImage = (ImageViewPlus) findViewById(R.id.imv_UserIcon);
        ImageButton imageButton = (ImageButton) findViewById(R.id.tv_Search);

        mydialog=new ProgressDialog(this);

        mImage.setOnClickListener(this);        //点击用户图片监听
        imageButton.setOnClickListener(new View.OnClickListener() {
            List<Schoolinfo> mList = new ArrayList();
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            String url =  new UrlData().searchSchool;
                            String param = mTextView.getText().toString();
                            Log.d("233",param);
                            String data = new RequestWebServece().submitSchoolName(url,param);
                            mList = new ResponseDataHandle().handleAreaResult(data);
                            if(mList == null){
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(MapActivity.this,"未查询到结果",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                            /*else if(mList.get(0).toString() == "非法参数"){
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(MapActivity.this,"输入学校有误，请重新输出",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }*/
                            else {
                                BMap bMap = new BMap();
                                ArrayList list = new ArrayList();
                                list.add(0,mList);
                                bundle.putStringArrayList("list",list);
                                bMap.setArguments(bundle);
                                fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.map_fragment,bMap);
                                fragmentTransaction.commit();
                                /*handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        mydialog.dismiss();
                                        addInfosOverlay(mList);
                                    }});*/

                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });


        try{
        mTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s,int start,int count,int after) {
                mydialog.show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String params =  mTextView.getText().toString();
                        String url = new UrlData().searchItem;
                        arrayAdapter = null;
                        try {

                            String data = new RequestWebServece().submitInfo(url,params);
                            JSONObject jsonObject = new JSONObject(data);
                            if (jsonObject.get("retCode").toString() == "-1") {
                                return;
                            }
                            if(jsonObject.get("retCode").toString() == "0"){
                                JSONArray jsonArray = jsonObject.getJSONArray("info");
                                info = new ArrayList<>();
                                for(int i = 0 ; i < jsonArray.length(); i++){
                                    info.add(jsonArray.getString(i));
                                }
                                Log.d("dasd","dsadas");
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        if(arrayAdapter == null){
                                            arrayAdapter = new ArrayAdapter(MapActivity.this,android.R.layout.simple_dropdown_item_1line,info);
                                            mTextView.setAdapter(arrayAdapter);
                                        }else{
                                            arrayAdapter.notifyDataSetChanged();
                                        }
                                    }
                                });
                            }
                        }catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }).start();
                mydialog.dismiss();
            }

            @Override
            public void onTextChanged(CharSequence s,int start,int before,int count) {
                mydialog.show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String params =  mTextView.getText().toString();
                        String url = new UrlData().searchItem;arrayAdapter = null;
                        try {
                            String data = new RequestWebServece().submitInfo(url,params);
                            JSONObject jsonObject = new JSONObject(data);
                            if (jsonObject.get("retCode").toString() == "-1") {
                                return;
                            }
                            if(jsonObject.get("retCode").toString() == "0"){
                                JSONArray jsonArray = jsonObject.getJSONArray("info");
                                info = new ArrayList<>();
                                for(int i = 0 ; i < jsonArray.length(); i++){
                                    info.add(jsonArray.getString(i));
                                }
                                Log.d("dasd","dsadas");
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        if(arrayAdapter==null){
                                            arrayAdapter = new ArrayAdapter(MapActivity.this,android.R.layout.simple_dropdown_item_1line,info);
                                            mTextView.setAdapter(arrayAdapter);
                                        }else{
                                            arrayAdapter.notifyDataSetChanged();
                                        }

                                    }
                                });

                            }

                        }catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }).start();
                mydialog.dismiss();
            }

            @Override
            public void afterTextChanged(Editable s) {
                mydialog.show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String params =  mTextView.getText().toString();
                        String url = new UrlData().searchItem;arrayAdapter = null;
                        try {
                            String data = new RequestWebServece().submitInfo(url,params);
                            JSONObject jsonObject = new JSONObject(data);
                            if (jsonObject.get("retCode").toString() == "-1") {
                                return;
                            }
                            if(jsonObject.get("retCode").toString() == "0"){
                                JSONArray jsonArray = jsonObject.getJSONArray("info");
                                info = new ArrayList<>();
                                for(int i = 0 ; i < jsonArray.length(); i++){
                                    info.add(jsonArray.getString(i));
                                }
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        if(arrayAdapter==null){
                                            arrayAdapter = new ArrayAdapter(MapActivity.this,android.R.layout.simple_dropdown_item_1line,info);
                                            mTextView.setAdapter(arrayAdapter);
                                        }else{
                                            arrayAdapter.notifyDataSetChanged();
                                        }

                                    }
                                });

                            }

                        }catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }).start();
                mydialog.dismiss();
            }
        });
    }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void onClick(View v) {         //监听事件
        switch (v.getId()) {
            case R.id.imv_UserIcon:
                Intent intent = new Intent(MapActivity.this, Setting.class);
                startActivity(intent);
                break;

            default:
                break;
        }

    }
    public void registerFragment(Fragment fragment) {
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.map_fragment,fragment);
        fragmentTransaction.commit();
    }
}

