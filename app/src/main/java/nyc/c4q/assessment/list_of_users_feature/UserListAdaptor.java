package nyc.c4q.assessment.list_of_users_feature;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import nyc.c4q.assessment.R;
import nyc.c4q.assessment.pojo.User;

/**
 * Created by jervon.arnoldd on 4/15/19.
 */

public class UserListAdaptor extends RecyclerView.Adapter<UserListAdaptor.ViewHolder> {
    private List<User> userList;

    public UserListAdaptor(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserListAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserListAdaptor.ViewHolder viewHolder, int i) {
        viewHolder.onBind(userList.get(i));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.first_name)
        TextView first_name;

        @BindView(R.id.last_name)
        TextView last_name;

        @BindView(R.id.image)
        ImageView use_avatar;


        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        void onBind(User user) {
            first_name.setText(user.firstName);
            last_name.setText(user.lastName);

            Picasso.get()
                    .load(user.avatar)
                    .placeholder(R.mipmap.ic_launcher_round)
                    .into(use_avatar);
        }
    }
}
