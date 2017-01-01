package scrath.techie.chat;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    //private static final String TAG = "Log";
    private FirebaseAuth auth;
    ProgressBar progressBar;
    EditText useremail,userpassword;
    Button login,sign;
    ImageView imageView;


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_login);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        useremail = (EditText) findViewById(R.id.user_email);
        userpassword = (EditText) findViewById(R.id.user_password);
        login = (Button) findViewById(R.id.user_login);
        sign = (Button) findViewById(R.id.sign);
        imageView = (ImageView) findViewById(R.id.logo);

        auth = FirebaseAuth.getInstance();

            sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });

//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                //mSmallBang.bang(view);
//
//            }
//        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                String email = useremail.getText().toString();
                final String password = userpassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Snackbar.make(view,"Enter email address!",Snackbar.LENGTH_LONG)
                            .show();
                    //Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Snackbar.make(view,"Enter password!",Snackbar.LENGTH_LONG)
                            .show();
                    //Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Snackbar.make(view,"Authentication failed!",Snackbar.LENGTH_LONG)
                                            .show();
                                    //Toast.makeText(LoginActivity.this, "Authentication failed.",
                                            //Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    auth = FirebaseAuth.getInstance();
                                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("email",auth.getCurrentUser().getEmail());
                                    intent.putExtras(bundle);
                                    startActivity(intent);
                                    finish();
                                }

                            }
                        });
            }
        });

    }
}
