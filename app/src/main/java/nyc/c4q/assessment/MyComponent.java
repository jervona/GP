package nyc.c4q.assessment;

import dagger.Component;
import nyc.c4q.assessment.api.ApiModule;

/**
 * Created by jervon.arnoldd on 4/15/19.
 */

@Component(modules = ApiModule.class)
public interface MyComponent {
    void inject(MainActivity mainActivity);
}
