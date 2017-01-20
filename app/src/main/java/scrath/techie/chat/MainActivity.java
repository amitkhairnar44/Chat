package scrath.techie.chat;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import scrath.techie.chat.fragment.AboutDeveloperFragment;
import scrath.techie.chat.fragment.AboutFragment;
import scrath.techie.chat.fragment.ChatFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ChatFragment chatFragment;
    private AboutFragment aboutFragment;
    private AboutDeveloperFragment aboutDeveloperFragment;
    private FirebaseAuth mFirebaseAuth;
    private String Email="user@user.com";
    private View navHeaderView;
    TextView textView,name;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirebaseAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mFirebaseAuth=FirebaseAuth.getInstance();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navHeaderView= navigationView.inflateHeaderView(R.layout.nav_header_main);
        textView = (TextView) navHeaderView.findViewById(R.id.textView);
        name = (TextView) navHeaderView.findViewById(R.id.name);
        imageView = (ImageView) navHeaderView.findViewById(R.id.imageView);
        //textView.setText(mFirebaseAuth.getCurrentUser().getEmail());

        chatFragment = new ChatFragment();
        aboutFragment = new AboutFragment();
        aboutDeveloperFragment = new AboutDeveloperFragment();
//        updateFragment(chatFragment);
        //textView.setText(mFirebaseAuth.getCurrentUser().getEmail());
        //name.setText(mFirebaseAuth.getCurrentUser().getDisplayName());
        //imageView.setImageResource(mFirebaseAuth.getCurrentUser().getPhotoUrl());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation scrath.techie.chat.view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_chat) {
            updateFragment(chatFragment);
            setTitle("Chat");

        } else if (id == R.id.nav_dev) {
            updateFragment(aboutDeveloperFragment);
        } else if (id == R.id.nav_app) {
            updateFragment(aboutFragment);
            setTitle("About App");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    protected void updateFragment(Fragment fragment)
    {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.commit();
    }
}
