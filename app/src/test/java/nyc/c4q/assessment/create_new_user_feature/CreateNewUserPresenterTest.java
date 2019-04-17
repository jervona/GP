package nyc.c4q.assessment.create_new_user_feature;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Observable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;
import nyc.c4q.assessment.api.ApiService;
import nyc.c4q.assessment.list_of_users_feature.ListOfUserContract;
import nyc.c4q.assessment.list_of_users_feature.ListOfUserPresenter;
import nyc.c4q.assessment.pojo.NewUser;
import nyc.c4q.assessment.pojo.SuccessfulNewUserResponse;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by jervon.arnoldd on 4/17/19.
 */
public class CreateNewUserPresenterTest {

    @Mock
    CreateNewUserContract.View view;

    @Mock
    ApiService apiService;

    CreateNewUserPresenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new CreateNewUserPresenter(apiService);
        presenter.attach(view);
        RxAndroidPlugins.setMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());
    }


    @Test
    public void successfullyCreatesNewUser() throws Exception {
        NewUser user = new NewUser();
        user.name = "Jervon";
        user.job = "Driver";

        SuccessfulNewUserResponse userResponse = new SuccessfulNewUserResponse();
        userResponse.name = user.name;
        userResponse.job = user.job;
        userResponse.createdAt = "June 12 14pm";
        userResponse.id = "000";

        when(apiService.postNewUser(user.name, user.job)).thenReturn(Observable.just(userResponse));

        presenter.createNewUser(user);

        verify(view).createdNewUserSuccessful();
    }





    @Test
    public void createNewUser() throws Exception {
    }

}