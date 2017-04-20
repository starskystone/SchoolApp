package xaut.schoolapp.com.method;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoleilei on 2017/4/10.
 */

public class ActivityControl {

    public static List<Activity> mActivities = new ArrayList<>();

    public static void addActivity(Activity activity){
        mActivities.add(activity);
    }

    public static void removeActivity(Activity activity){
        mActivities.remove(activity);
    }

    public static void finishAll(){
        for(Activity activity : mActivities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
