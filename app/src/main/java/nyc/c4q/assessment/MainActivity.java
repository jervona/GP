package nyc.c4q.assessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import nyc.c4q.assessment.list_of_users_feature.ListOfUserContract;
import nyc.c4q.assessment.pojo.User;

public class MainActivity extends AppCompatActivity implements ListOfUserContract.View {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GPApp app = (GPApp) getApplicationContext();
        app.getMyComponent().inject(this);
        ButterKnife.bind(this);
    }

    @Override
    public void showResults(List<User> userList) {

    }

    @Override
    public void showToast(String s) {

    }

    @Override
    public void showErrorDialog() {

    }

    @Override
    public void currentlyFectchingData() {

    }

    @Override
    public void doneFectingData() {

    }
}
