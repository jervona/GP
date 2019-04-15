package nyc.c4q.assessment.list_of_users_feature;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import nyc.c4q.assessment.api.ApiService;

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
        this.view=view;
    }

    @Override
    public void detach() {
      this.view=null;
      disposable.clear();
    }

    @Override
    public void loadUsers() {

    }

    @Override
    public void createNewUser() {

    }
}
