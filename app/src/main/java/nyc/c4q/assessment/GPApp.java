package nyc.c4q.assessment;

import android.app.Application;

/**
 * Created by jervon.arnoldd on 4/15/19.
 */

public class GPApp extends Application {
    MyComponent myComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        myComponent=DaggerMyComponent.create();
    }

    public MyComponent getMyComponent(){
        return myComponent;
    }
}
