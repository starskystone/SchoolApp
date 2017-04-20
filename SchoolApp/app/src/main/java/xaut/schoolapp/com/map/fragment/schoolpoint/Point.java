package xaut.schoolapp.com.map.fragment.schoolpoint;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.overlayutil.PoiOverlay;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiDetailSearchOption;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;

import java.util.List;

import xaut.schoolapp.com.map.fragment.BMap;

/**
 * Created by xiaoleilei on 2017/4/19.
 */
/*

public class Point {
    PoiSearch mPoiSearch;
    private OnGetPoiSearchResultListener poiSearchResultListener;
    BaiduMap mBaiduMap;

    Context c;

    public Point(Context context){
        c = context;
    }

    public void point(){

        mPoiSearch = PoiSearch.newInstance();

        poiSearchResultListener = new OnGetPoiSearchResultListener() {
            @Override
            public void onGetPoiResult(PoiResult poiResult) {
                Log.d("123",poiResult.toString());
                if((poiResult == null) || (poiResult.error == SearchResult.ERRORNO.RESULT_NOT_FOUND)){
                    Log.d("124", "onGetPoiResult: ");
                    Toast.makeText(c, "未能搜索到附近学校", Toast.LENGTH_LONG).show();
                }

                if(poiResult.error == SearchResult.ERRORNO.NO_ERROR){
                    mBaiduMap.clear();

                    Log.d("125", mPoiSearch.toString());
                    List<PoiInfo> allAddr = poiResult.getAllPoi();
                    for(PoiInfo p:allAddr){
                        Log.d("","p.name---->" + p.name + "p.location" + p.location );
                    }
                    MyPoiOverlay poiOverlay= new MyPoiOverlay(mBaiduMap);
                    poiOverlay.setData(poiResult);
                    poiOverlay.addToMap();
                    poiOverlay.zoomToSpan();
                }
            }

            @Override
            public void onGetPoiDetailResult(PoiDetailResult poiDetailResult) {

            }

            @Override
            public void onGetPoiIndoorResult(PoiIndoorResult poiIndoorResult) {

            }
        };
        Log.d("1","1111");
        mPoiSearch.setOnGetPoiSearchResultListener(poiSearchResultListener);

        PoiCitySearchOption citySearchOption = new PoiCitySearchOption();
        citySearchOption.city("西安");
        citySearchOption.keyword("小学");
        citySearchOption.pageNum(15);
        boolean xa = mPoiSearch.searchInCity(citySearchOption);
        Log.d("city",String.valueOf(xa));
        */
/*Log.v("qwe","setMarker : lat : "+ lat+" lon : " + lon);
        PoiNearbySearchOption nearbySearchOption = new PoiNearbySearchOption();
        nearbySearchOption.location(new LatLng(lat,lon));
        Log.d("159:","lat,lon:" + String.valueOf(lat)+","+String.valueOf(lon));
        nearbySearchOption.keyword("美食");
        nearbySearchOption.radius(3000);
        nearbySearchOption.pageNum(15);
        boolean xa = mPoiSearch.searchNearby(nearbySearchOption);
        Log.d("nearby",String.valueOf(xa));*//*


    }

    class MyPoiOverlay extends PoiOverlay {

        public MyPoiOverlay(BaiduMap arg0) {
            super(arg0);
        }

        // 检索Poi详细信息.获取PoiOverlay
        @Override
        public boolean onPoiClick(int arg0) {
            super.onPoiClick(arg0);
            PoiInfo poiInfo = getPoiResult().getAllPoi().get(arg0);
            mPoiSearch.searchPoiDetail(new PoiDetailSearchOption()
                    .poiUid(poiInfo.uid));
            return true;
        }
    }
}
*/
