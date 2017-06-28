package xaut.schoolapp.com.controller;



import java.util.ArrayList;
import java.util.List;

import xaut.schoolapp.com.model.Schoolinfo;


/**
 * Created by xiaoleilei on 2017/4/30.
 */

public class ResponseDataHandle {

    public ResponseDataHandle() {
    }

    public static List<Schoolinfo> handleAreaResult(String jsonData) {

        List<Schoolinfo> list = new ArrayList<>();
        try {
            if(jsonData == null){
                list = null;
            }

            org.json.JSONObject jsonObject = new org.json.JSONObject(jsonData);
            if (jsonObject.get("retCode").toString() == "-1") {
                list = null;
            }

            if(jsonObject.get("retCode").toString() == "1"){
                list = null;
            }

            if (jsonObject.get("retCode").toString() == "0") {
                org.json.JSONArray jsArray = jsonObject.getJSONArray("list");

                for (int i = 0; i < jsArray.length(); i++) {
                    org.json.JSONObject tmp = jsArray.getJSONObject(i);
                    Schoolinfo data = new Schoolinfo();
                    data.setX(tmp.getDouble("x"));
                    data.setY(tmp.getDouble("y"));
                    data.setOrganizationNo(tmp.getString("organizationNo"));
                    data.setOrganizationName(tmp.getString("organizationName"));
                    data.setRegionA(tmp.getString("regionA"));
                    data.setRegionB(tmp.getString("regionB"));
                    data.setRegionC(tmp.getString("regionC"));
                    data.setRegionD(tmp.getString("regionD"));
                    data.setRegionE(tmp.getString("regionE"));
                    data.setSchoolTypeGroup(tmp.getString("schoolTypeGroup"));
                    data.setEmail(tmp.getString("email"));
                    data.setOfficeTelephone(tmp.getString("officeTelephone"));
                    data.setZipcode(tmp.getString("zipcode"));
                    data.setCustomOwner(tmp.getString("customOwner"));
                    list.add(data);
                }

            }
        } catch (Exception e) {

            e.printStackTrace();
        }

        return list;
    }
}

