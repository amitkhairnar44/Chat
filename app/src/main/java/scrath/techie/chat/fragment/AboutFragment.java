package scrath.techie.chat.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import scrath.techie.chat.BuildConfig;
import scrath.techie.chat.R;

public class AboutFragment extends Fragment {
    TextView versionCode;
    int countClick = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        versionCode = (TextView)view.findViewById(R.id.app_version);

        versionCode.setText(""+ BuildConfig.VERSION_CODE);
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countClick++;
                if (countClick == 4)
                {
                    Snackbar snackbar = Snackbar.make(view,"Click again to exit the app!",Snackbar.LENGTH_LONG);
                    snackbar.setAction("Exit!", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            getActivity().finish();
                        }
                    });
                    snackbar.show();
                }
                else if (countClick==5)
                {
                    getActivity().finish();
                }
            }
        });
        return view;
    }


}
