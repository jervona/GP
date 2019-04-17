package nyc.c4q.assessment.list_of_users_feature;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import nyc.c4q.assessment.GPApp;
import nyc.c4q.assessment.R;
import nyc.c4q.assessment.create_new_user_feature.CreateUserFragment;
import nyc.c4q.assessment.pojo.User;

public class MainActivity extends AppCompatActivity implements ListOfUserContract.View {

    @Inject
    ListOfUserPresenter presenter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.loading_progresss)
    ProgressBar loading_progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GPApp app = (GPApp) getApplicationContext();
        app.getMyComponent().inject(this);
        ButterKnife.bind(this);
        presenter.attach(this);
        presenter.loadUsers();
    }

    @Override
    public void showResults(List<User> userList) {
        recyclerView.setAdapter(new UserListAdaptor(userList));
    }

    @OnClick(R.id.create_new_user)
    public void inflateCreateUserFragment() {
        CreateUserFragment createUserFragment = new CreateUserFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, createUserFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorDialog() {
        //show Dialog
    }

    @Override
    public void currentlyFetchingData() {
        loading_progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void doneFetchingData() {
        loading_progress.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        presenter.detach();
        super.onDestroy();
    }
}