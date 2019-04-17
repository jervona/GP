package nyc.c4q.assessment.create_new_user_feature;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import nyc.c4q.assessment.GPApp;
import nyc.c4q.assessment.R;
import nyc.c4q.assessment.create_new_user_feature.CreateNewUserContract;
import nyc.c4q.assessment.create_new_user_feature.CreateNewUserPresenter;
import nyc.c4q.assessment.pojo.NewUser;


/**
 * A simple {@link Fragment} subclass.
 */
public class CreateUserFragment extends Fragment implements CreateNewUserContract.View {

    View view;
    @BindView(R.id.first_name)
    EditText first_name;
    @BindView(R.id.last_name)
    EditText last_name;
    @BindView(R.id.job)
    EditText job;
    @Inject
    CreateNewUserPresenter presenter;

    public CreateUserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_create_user, container, false);
        GPApp app = (GPApp) view.getContext().getApplicationContext();
        app.getMyComponent().inject(this);
        ButterKnife.bind(this, view);
        presenter.attach(this);

        return view;
    }

    @OnClick(R.id.create_user)
    public void createUser() {
        NewUser user = new NewUser();
        user.name = first_name.getText().toString() + last_name.getText().toString();
        user.job = job.getText().toString();
        presenter.createNewUser(user);
    }

    @Override
    public void createdNewUserSuccessful() {
        getActivity().getSupportFragmentManager().popBackStack();
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(view.getContext(), s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        presenter.detach();
        super.onDestroy();
    }
}
