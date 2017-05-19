package xaut.schoolapp.com.view;

import android.app.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;


import android.text.TextPaint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;

import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.overlayutil.DrivingRouteOverlay;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.route.BikingRouteResult;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.IndoorRouteResult;
import com.baidu.mapapi.search.route.MassTransitRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
import com.baidu.mapapi.search.route.TransitRoutePlanOption;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRouteResult;


import org.json.JSONException;

import java.util.*;
import java.util.Map;


import xaut.schoolapp.com.Util.ToastUtil;
import xaut.schoolapp.com.controller.RequestWebServece;
import xaut.schoolapp.com.controller.ResponseDataHandle;
import xaut.schoolapp.com.model.AppData;
import xaut.schoolapp.com.model.Schoolinfo;
import xaut.schoolapp.com.schoolapp.R;

/**
 * Created by xiaoleilei on 2017/4/15.
 */

public class BMap extends Fragment {

    private MapView mMapView;
    private boolean isFirstLocation = true;

    Marker mMarker;

    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new MyLocationListener();
    public BaiduMap mBaiduMap;

    private RouteLine mRouteLine = null;
    private RoutePlanSearch mRoutePlanSearch = null;

    private PlanNode stNode = null;
    private PlanNode enNode = null;
    private ImageView infoImg;
    private TextView schoolName;
    private Button schoolInfo;
    private Button busRoute;

    private ProgressDialog mydialog;
    private double lat;  //纬度
    private double lon;  //经度
    Handler handler;

    private DrivingRouteOverlay mRouteOverlay;


    public View onCreateView(final LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        SDKInitializer.initialize(getActivity().getApplication());
        final View view = inflater.inflate(R.layout.map_fragment, container, false);

        infoImg = (ImageView)view.findViewById(R.id.school_image);
        schoolName = (TextView)view.findViewById(R.id.text_school);
        schoolInfo = (Button)view.findViewById(R.id.schoolInfo);            //学校详情按钮
        busRoute = (Button)view.findViewById(R.id.bus_route);
        schoolName.getBackground().setAlpha(5);
        busRoute.getBackground().setAlpha(5);

        mMapView = (MapView) view.findViewById(R.id.bmap_view);
        final LinearLayout linearLayout = (LinearLayout)view.findViewById(R.id.marker_info);
        mBaiduMap = mMapView.getMap();
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);

        //定位自己
        mBaiduMap.setMyLocationEnabled(true);
        //声明LocationClient类
        mLocationClient = new LocationClient(getActivity().getApplicationContext());
        //注册监听函数
        mLocationClient.registerLocationListener(myListener);
        //配置定位参数
        initLocation();
        //开始定位
        mLocationClient.start();
        handler=new Handler();
        mydialog=new ProgressDialog(getActivity());
        mydialog.show();



      new Thread(new Runnable() {
            @Override
            public void run() {
                Map<String, String> params = new HashMap();
                params.put("district","'新城区'");
                params.put("type","'小学'");

                String url = new AppData().loginSchool;

                try {
                    String data = new RequestWebServece().submitdata(url,params);
                    Log.d("233", data);
                    final List<Schoolinfo>  list2 = new ResponseDataHandle().handleAreaResult(data);
                    Log.d("233",list2.toString());
                    if (list2 == null){
                        ToastUtil.ToastShort("未查询到结果");
                    }
                        if(list2 != null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            mydialog.dismiss();
                            addInfosOverlay(list2);
                        }
                    });}

                }catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        }).start();


        mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                //获得marker的数据
                Schoolinfo mapinfo = (Schoolinfo) marker.getExtraInfo().get("mapinfo");

                linearLayout.setVisibility(View.VISIBLE);
                popuInfo(mapinfo);

                return true;
            }
        });

        mBaiduMap.setOnMapClickListener(new BaiduMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng arg0) {
                linearLayout.setVisibility(View.INVISIBLE);
            }

            @Override
            public boolean onMapPoiClick(MapPoi mapPoi) {
                return false;
            }
        });

        return view;
    }


    //底部信息
    private void popuInfo(final Schoolinfo schoolinfo){
        schoolName.setText(schoolinfo.getOrganizationName());
        infoImg.setImageResource(R.drawable.cc3);
        schoolInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这里click后转到网页

            }
        });

        busRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchRoute(schoolinfo);

    }});
    }


    //路线搜索
    private void searchRoute(Schoolinfo schoolinfo){
        mRoutePlanSearch = RoutePlanSearch.newInstance();
        if(mRouteLine != null){
            mRouteLine = null;
        }
        if(mRouteOverlay != null){
            mRouteOverlay.removeFromMap();
        }
        OnGetRoutePlanResultListener routelistener = new OnGetRoutePlanResultListener() {
            @Override
            public void onGetWalkingRouteResult(WalkingRouteResult walkingRouteResult) {

            }

            @Override
            public void onGetTransitRouteResult(TransitRouteResult transitRouteResult) {

            }

            @Override
            public void onGetMassTransitRouteResult(MassTransitRouteResult massTransitRouteResult) {

            }

            @Override
            public void onGetDrivingRouteResult(DrivingRouteResult drivingRouteResult) {
                if(drivingRouteResult == null || drivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR){
                    ToastUtil.ToastShort("抱歉没找到结果");
                }
                if(drivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_KEYWORD){
                    return;
                }
                if(drivingRouteResult.error == SearchResult.ERRORNO.NO_ERROR){
                    mRouteLine = drivingRouteResult.getRouteLines().get(0);
                    DrivingRouteOverlay overlay = new DrivingRouteOverlay(mBaiduMap);
                    overlay.setData(drivingRouteResult.getRouteLines().get(0));
                    overlay.addToMap();
                    overlay.zoomToSpan();
                }
            }

            @Override
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {

            }

            @Override
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {

            }
        };
        mRoutePlanSearch.setOnGetRoutePlanResultListener(routelistener);

        LatLng stlatlng = new LatLng(lat,lon);
        LatLng enlatlng = new LatLng(schoolinfo.getY(),schoolinfo.getX());

        stNode = PlanNode.withLocation(stlatlng);
        enNode = PlanNode.withLocation(enlatlng);
        mRoutePlanSearch.transitSearch((new TransitRoutePlanOption()).from(stNode).to(enNode).city("西安"));

        mRoutePlanSearch.destroy();

    }
    /**
     * 添加marker
     */
    //本人marker
    private Marker setMarker(Marker mMarker) {
        Log.v("pcw","setMarker : lat : "+ lat+" lon : " + lon);
        //定义Maker坐标点
        LatLng point = new LatLng(lat, lon);
        //构建Marker图标
        BitmapDescriptor bitmap = BitmapDescriptorFactory
                .fromResource(R.drawable.point);
        //构建MarkerOption，用于在地图上添加Marker
        OverlayOptions option = new MarkerOptions()
                .position(point)
                .icon(bitmap);
        //在地图上添加Marker，并显示
        mMarker = (Marker) (mBaiduMap.addOverlay(option));
        return mMarker;
    }

    /**
     * 设置中心点
     */
    private void setUserMapCenter() {
        Log.v("pcw","setUserMapCenter : lat : "+ lat+" lon : " + lon);
        LatLng cenpt = new LatLng(lat,lon);
        //定义地图状态
        MapStatus mMapStatus = new MapStatus.Builder()
                .target(cenpt)
                .zoom(13)
                .build();
        //定义MapStatusUpdate对象，以便描述地图状态将要发生的变化
        MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
        //改变地图状态
        mBaiduMap.setMapStatus(mMapStatusUpdate);

    }

    /**
     * 配置定位参数
     */
    private void initLocation(){
        Log.d("initLocation", "initLocation: ");
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy
        );//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        option.setScanSpan(3000);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(true);//可选，默认tr4ue，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤gps仿真结果，默认需要
        mLocationClient.setLocOption(option);
    }

    /**
     * 实现定位监听 位置一旦有所改变就会调用这个方法
     * 可以在这个方法里面获取到定位之后获取到的一系列数据
     */
    public class MyLocationListener implements BDLocationListener {


        @Override
        public void onReceiveLocation(BDLocation location) {
            //Receive Location
            StringBuffer sb = new StringBuffer(256);
            sb.append("time : ");
            sb.append(location.getTime());
            sb.append("\nerror code : ");
            sb.append(location.getLocType());
            sb.append("\nlatitude : ");
            sb.append(location.getLatitude());
            sb.append("\nlontitude : ");
            sb.append(location.getLongitude());
            sb.append("\nradius : ");
            sb.append(location.getRadius());

            if (location.getLocType() == BDLocation.TypeGpsLocation) {// GPS定位结果
                sb.append("\nspeed : ");
                sb.append(location.getSpeed());// 单位：公里每小时
                sb.append("\nsatellite : ");
                sb.append(location.getSatelliteNumber());
                sb.append("\nheight : ");
                sb.append(location.getAltitude());// 单位：米
                sb.append("\ndirection : ");
                sb.append(location.getDirection());// 单位度
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());
                sb.append("\ndescribe : ");
                sb.append("gps定位成功");

            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {// 网络定位结果
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());
                //运营商信息
                sb.append("\noperationers : ");
                sb.append(location.getOperators());
                sb.append("\ndescribe : ");
                sb.append("网络定位成功");
            } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {// 离线定位结果
                sb.append("\ndescribe : ");
                sb.append("离线定位成功，离线定位结果也是有效的");
            } else if (location.getLocType() == BDLocation.TypeServerError) {
                sb.append("\ndescribe : ");
                sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");
            } else if (location.getLocType() == BDLocation.TypeNetWorkException) {
                sb.append("\ndescribe : ");
                sb.append("网络不同导致定位失败，请检查网络是否通畅");
            } else if (location.getLocType() == BDLocation.TypeCriteriaException) {
                sb.append("\ndescribe : ");
                sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");
            }
            sb.append("\nlocationdescribe : ");
            sb.append(location.getLocationDescribe());// 位置语义化信息
            List<Poi> list = location.getPoiList();// POI数据
            if (list != null) {
                sb.append("\npoilist size = : ");
                sb.append(list.size());
                for (Poi p : list) {
                    sb.append("\npoi= : ");
                    sb.append(p.getId() + " " + p.getName() + " " + p.getRank());
                }
            }
            lat = location.getLatitude();
            lon = location.getLongitude();

            //这个判断是为了防止每次定位都重新设置中心点和marker
            if(isFirstLocation){
                isFirstLocation = false;
                setUserMapCenter();
            }
            if(mMarker == null){
                mMarker = setMarker(mMarker);
            }
            if(mMarker != null){
                mMarker.remove();
                mMarker = setMarker(mMarker);
            }
            Log.d("pcw","lat : " + lat +" lon : " + lon);
            Log.i("BaiduLocationApiDem", sb.toString());
        }

        public void onConnectHotSpotMessage(String s, int i) {
        }
    }

    //添加覆盖物
    public void addInfosOverlay(List<Schoolinfo> mapinfos){
        mBaiduMap.clear();
        LatLng latLng = null;
        OverlayOptions overlayOptions = null;
        Marker marker = null;
        for (Schoolinfo mapinfo: mapinfos){
            BitmapDescriptor bitmap = null;
            switch (mapinfo.getSchoolTypeGroup()) {
                case "小学" : bitmap = BitmapDescriptorFactory.fromResource(R.drawable.xiao);
                    break;
                case "幼儿园": bitmap = BitmapDescriptorFactory.fromResource(R.drawable.v);
                    break;
                case "高级中学": bitmap = BitmapDescriptorFactory.fromResource(R.drawable.gao);
                    break;
                case "完全中学" :bitmap = BitmapDescriptorFactory.fromResource(R.drawable.zhong);
                    break;
                case "初级中学" :bitmap = BitmapDescriptorFactory.fromResource(R.drawable.cc);
                    break;
                case "职业高中学校": bitmap = BitmapDescriptorFactory.fromResource(R.drawable.gong);
                    break;
                case "其他特教学校": bitmap = BitmapDescriptorFactory.fromResource(R.drawable.te);
            }

            latLng = new LatLng(mapinfo.getY(), mapinfo.getX());
            overlayOptions = new MarkerOptions().position(latLng)
                    .icon(bitmap).zIndex(5);
            marker = (Marker)(mBaiduMap.addOverlay(overlayOptions));

            Bundle bundle = new Bundle();
            bundle.putSerializable("mapinfo", mapinfo);
            marker.setExtraInfo(bundle);
        }
    }
    /**
     * 必须要实现
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }

    /**
     * 必须要实现
     */
    @Override
    public void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }

    /**
     * 必须要实现
     */
    @Override
    public void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }
}

