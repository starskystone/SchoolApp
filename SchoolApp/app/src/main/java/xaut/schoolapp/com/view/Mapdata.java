package xaut.schoolapp.com.view;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import net.sf.json.JSONObject;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import xaut.schoolapp.com.controller.RequestWebServece;
import xaut.schoolapp.com.model.AppData;
import xaut.schoolapp.com.schoolapp.R;

/**
 * Created by xiaoleilei on 2017/4/9.
 */

public class Mapdata extends Fragment {
    private ListView mList;
    private EditText mEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mapview_fragment, container, false);
        mEditText = (EditText)view.findViewById(R.id.tv_SchoolName);
        mList = (ListView) view.findViewById(R.id.list_view);

        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s,int start,int count,int after) {

            }

            @Override
            public void onTextChanged(CharSequence s,int start,int before,int count) {

                String params =  mEditText.getText().toString();
                String url = new AppData().searchItem;
                try {
                    String data = new RequestWebServece().submitInfo(url,params);
                    org.json.JSONObject jsonObject = new org.json.JSONObject(data);
                    if (jsonObject.get("retCode") == "-1") {

                    }
                    if(jsonObject.get("retCode") == "0"){
                        org.json.JSONArray jsonArray = jsonObject.getJSONArray("info");
                        ArrayList<String> info = new ArrayList<>();
                        for(int i = 0 ; i < jsonArray.length(); i++){
                            info.add(jsonArray.getString(i));
                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_expandable_list_item_1, info);
                        mList.setAdapter(adapter);
                    }

                }catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });

        return view;
    }


}
