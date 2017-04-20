package xaut.schoolapp.com.map.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

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

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_expandable_list_item_1, data());
        mList.setAdapter(adapter);

        return view;
    }

    public ArrayList<String> data(){
        ArrayList<String> data = new ArrayList<>();

        for(int i=0; i<30; i++){
            data.add("测试数据"+i);
        }

        return data;
    }

}
