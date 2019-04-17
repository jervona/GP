package nyc.c4q.assessment.create_new_user_feature;

import nyc.c4q.assessment.BaseContract;
import nyc.c4q.assessment.pojo.NewUser;

/**
 * Created by jervon.arnoldd on 4/16/19.
 */

public interface CreateNewUserContract {
    interface Presenter extends BaseContract.BasePresenter<View> {
        void createNewUser(NewUser user);
    }

    interface View extends BaseContract.BaseView{
        void createdNewUserSuccessful();

        void showToast(String s);
    }
}
