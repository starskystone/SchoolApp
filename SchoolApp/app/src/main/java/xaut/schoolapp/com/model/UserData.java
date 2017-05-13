package xaut.schoolapp.com.model;

/**
 * Created by xiaoleilei on 2017/5/1.
 */

public class UserData {
    String mUsername;
    String mSex;
    String mPhone;
    String mUnit;

    public UserData(String username,String sex,String phone,String unit){
        super();
        mUsername = username;
        mSex = sex;
        mPhone = phone;
        mUnit = unit;
    }

    public String getUsername(){
        return mUsername;
    }

    public String getSex(){
        return mSex;
    }

    public String getPhone(){
        return mPhone;
    }

    public String getUnit(){
        return mUnit;
    }
}
