package xaut.schoolapp.com.Util;

import android.widget.Toast;

import xaut.schoolapp.com.Application.MyApplicaition;

/**
 * Created by xiaoleilei on 2017/5/9.
 */

public class ToastUtil {

    private static  Toast toast;

    /**
     *显示short Toast*/
    public static void ToastShort(String msg){
       if(toast == null) {
            Toast.makeText(MyApplicaition.getInstance(),msg,Toast.LENGTH_SHORT).show();
        }
     else{
           toast.setText(msg);
       }
    }

    /**
     * 显示long Toast*/
    public static void ToastLong(String msg){
        if(toast == null){
            Toast.makeText(MyApplicaition.getInstance(),msg,Toast.LENGTH_LONG).show();
        }
        else {
            toast.setText(msg);
        }
    }
}
