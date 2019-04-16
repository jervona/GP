package nyc.c4q.assessment.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import nyc.c4q.assessment.R;
import nyc.c4q.assessment.pojo.NewUser;


/**
 * A simple {@link Fragment} subclass.
 */
public class CreateUserFragment extends Fragment {


    CreateUserFragment.NewUserListener createdListener;
    View view;

    @BindView(R.id.first_name)
    EditText first_name;
    @BindView(R.id.last_name)
    EditText last_name;
    @BindView(R.id.job)
    EditText job;


    public CreateUserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_create_user, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.create_user)
    public void createUser(){
        NewUser user = new NewUser();
        user.name = first_name.getText().toString() + last_name.getText().toString();
        user.job =  job.getText().toString();
        createdListener.newUserListener(user);
    }

    public void createdUserListener(MainActivity mainActivity) {
        createdListener=mainActivity;
    }

    public interface NewUserListener {
        void newUserListener(NewUser user);
    }
}
