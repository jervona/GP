package nyc.c4q.assessment;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;
import nyc.c4q.assessment.api.ApiService;
import nyc.c4q.assessment.list_of_users_feature.ListOfUserContract;
import nyc.c4q.assessment.list_of_users_feature.ListOfUserPresenter;
import nyc.c4q.assessment.pojo.ApiResponse;
import nyc.c4q.assessment.pojo.NewUser;
import nyc.c4q.assessment.pojo.SuccessfulNewUserResponse;
import nyc.c4q.assessment.pojo.User;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Created by jervon.arnoldd on 4/16/19.
 */
public class ListOfUserPresenterTest {

    @Mock
    ListOfUserContract.View view;

    @Mock
    ApiService apiService;

    ListOfUserPresenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new ListOfUserPresenter(apiService);
        presenter.attach(view);
        RxAndroidPlugins.setMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());
    }


    @Test
    public void returnsListofUsers() throws Exception {
        List<User> userList = new ArrayList<>();
        userList.add(new User());
        userList.add(new User());
        userList.add(new User());
        ApiResponse temp = new ApiResponse();
        temp.data = userList;


        when(apiService.getListOfUser()).thenReturn(Observable.just(temp));

        presenter.loadUsers();

        verify(view).showResults(userList);
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

}