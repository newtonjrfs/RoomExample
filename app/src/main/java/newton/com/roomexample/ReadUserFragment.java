package newton.com.roomexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadUserFragment extends Fragment {

    private TextView TxtInfo;

    public ReadUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_user, container, false);

        TxtInfo = view.findViewById(R.id.txt_display_info);

        List<User> users = MainActivity.myAppDatabase.myDao().getUser();

        String info = " ";

        for(User usr : users){

            int id = usr.getId();
            String name = usr.getName();
            String email = usr.getEmail();

            info = info + "\n\n"+"Id :"+id+"\nName :"+name+"\n"+"Email :"+email;
        }

        TxtInfo.setText(info);

        return view;
    }

}
