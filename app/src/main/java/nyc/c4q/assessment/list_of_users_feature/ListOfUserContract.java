package nyc.c4q.assessment.list_of_users_feature;

import java.util.List;

import nyc.c4q.assessment.BaseContract;
import nyc.c4q.assessment.pojo.NewUser;
import nyc.c4q.assessment.pojo.User;

/**
 * Created by jervon.arnoldd on 4/15/19.
 */

public interface ListOfUserContract {
    interface Presenter extends BaseContract.BasePresenter<View> {
        void loadUsers();
    }

    interface View extends BaseContract.BaseView{
        void showResults(List<User> userList);
        void showToast(String s);
        void showErrorDialog();
        void currentlyFetchingData();
        void doneFetchingData();
    }
}

