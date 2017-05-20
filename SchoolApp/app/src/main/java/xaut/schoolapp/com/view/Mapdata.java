package xaut.schoolapp.com.view;

import android.app.Fragment;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ListView;


import com.baidu.mapapi.map.BaiduMap;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import xaut.schoolapp.com.controller.RequestWebServece;
import xaut.schoolapp.com.controller.ResponseDataHandle;
import xaut.schoolapp.com.model.AppData;
import xaut.schoolapp.com.model.Schoolinfo;
import xaut.schoolapp.com.schoolapp.R;

/**
 * Created by xiaoleilei on 2017/4/9.
 */

public class Mapdata extends Fragment {
    private ListView mList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mapview_fragment, container, false);

        mList = (ListView) view.findViewById(R.id.list_view);

        Bundle bundle = getArguments();
        final ArrayList<String> info = bundle.getStringArrayList("info");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_expandable_list_item_1, info);
        if(info == null){
            adapter = null;
            mList.setAdapter(adapter);
        }
        else {
            Log.d("233",adapter.toString());
            mList.setAdapter(adapter);
        }

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,View view,int position,long id) {
                try {
                    String data = info.get(position);
                    String url = new AppData().searchSchool;

                    String schoolInfo = RequestWebServece.submitSchoolName(url,data);
                    final List<Schoolinfo>  list2 = new ResponseDataHandle().handleAreaResult(schoolInfo);
                    BMap m = new BMap();
                    m.addInfosOverlay(list2);

                }catch (JSONException e){
                    e.printStackTrace();
                }}
        });

        return view;
    }


}
