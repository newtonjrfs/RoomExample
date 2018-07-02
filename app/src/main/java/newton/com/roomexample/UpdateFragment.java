package newton.com.roomexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateFragment extends Fragment {
    private EditText UserId, UserEmail, UserName;
    private Button BnUpdate;


    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update, container, false);

        UserEmail = view.findViewById(R.id.txt_upd_email);
        UserId = view.findViewById(R.id.txt_upd_user_id);
        UserName = view.findViewById(R.id.txt_upd_name);
        BnUpdate = view.findViewById(R.id.bn_upd_user);

        BnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = Integer.parseInt(UserId.getText().toString());
                String name = UserName.getText().toString();
                String email = UserEmail.getText().toString();

                User user = new User();
                user.setId(id);
                user.setEmail(email);
                user.setName(name);

                MainActivity.myAppDatabase.myDao().updateUser(user);

                Toast.makeText(getActivity(),"Update sucess",Toast.LENGTH_SHORT).show();

                UserId.setText("");
                UserEmail.setText("");
                UserName.setText("");

            }
        });



        return view;
    }

}
