package nyc.c4q.assessment.list_of_users_feature;

import android.util.Log;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import nyc.c4q.assessment.api.ApiService;
import nyc.c4q.assessment.pojo.NewUser;

/**
 * Created by jervon.arnoldd on 4/15/19.
 */

public class ListOfUserPresenter implements ListOfUserContract.Presenter {
    ApiService apiService;
    ListOfUserContract.View view;
    private CompositeDisposable disposable = new CompositeDisposable();


    @Inject
    public ListOfUserPresenter(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void attach(ListOfUserContract.View view) {
        this.view = view;
    }

    @Override
    public void detach() {
        this.view = null;
        disposable.clear();
    }

    @Override
    public void loadUsers() {
        view.currentlyFetchingData();
        disposable.add(
                apiService.getListOfUser()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(apiResponse -> {
                            view.doneFetchingData();
                            view.showResults(apiResponse.data);
                        }, throwable -> {
                            view.showErrorDialog();
//                            Log.e("RxError", throwable.toString());
                        })
        );
    }


    @Override
    public void createNewUser(NewUser user) {
        apiService.postNewUser(user.name, user.job)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(newUserResponse -> {
                     view.createdNewUserSuccessful();
                }, throwable -> {
                    view.showToast("Error Try Again");
                    Log.e("RxError Post", throwable.toString());
                });
    }
}
