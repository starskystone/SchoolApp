package xaut.schoolapp.com.Application;

import android.app.Application;
import android.content.Context;

import xaut.schoolapp.com.Util.ToastUtil;

/**
 * Created by xiaoleilei on 2017/5/9.
 */

public class MyApplicaition extends Application{

    private static Context context;
    @Override
    public void onCreate() {
        context=this;
        super.onCreate();

    }

    public static  Context getInstance(){
        return context;
    }
}
