package nyc.c4q.assessment.create_new_user_feature;

import android.util.Log;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import nyc.c4q.assessment.api.ApiService;
import nyc.c4q.assessment.pojo.NewUser;

/**
 * Created by jervon.arnoldd on 4/16/19.
 */

public class CreateNewUserPresenter implements CreateNewUserContract.Presenter {
    ApiService apiService;
    private CreateNewUserContract.View view;
    private CompositeDisposable disposable = new CompositeDisposable();


    @Inject
    public CreateNewUserPresenter(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void attach(CreateNewUserContract.View view) {
        this.view = view;
    }

    @Override
    public void detach() {
        this.view = null;
        disposable.clear();
    }

    @Override
    public void createNewUser(NewUser user) {
        disposable.add(
                apiService.postNewUser(user.name, user.job)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(newUserResponse -> {
                            Log.e("Running in rx","rx");
                            view.createdNewUserSuccessful();
                        }, throwable -> {
                            view.showToast("Error Try Again");
                            Log.e("RxError Post", throwable.toString());
                        })
        );


    }
}
