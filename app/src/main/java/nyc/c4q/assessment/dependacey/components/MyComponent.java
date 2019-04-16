package nyc.c4q.assessment.dependacey.components;


import javax.inject.Singleton;

import dagger.Component;
import nyc.c4q.assessment.ui.MainActivity;
import nyc.c4q.assessment.api.ApiModule;

/**
 * Created by jervon.arnoldd on 4/15/19.
 */

@Singleton
@Component(modules = ApiModule.class)
public interface MyComponent {
    void inject(MainActivity mainActivity);
}
