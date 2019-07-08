package com.santiagoweb.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;

import com.santiagoweb.R;

public class MainActivity extends AppCompatActivity implements ListFragment.OnFragmentInteractionListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        int valor = getIntent().getExtras().getInt("TypeResult");

        ManagerFragment(new ListFragment().newInstance(valor), false);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void ManagerFragment(Fragment fragment, Boolean back) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.left_in, R.anim.left_out, R.anim.right_in, R.anim.right_out);
        fragmentTransaction.replace(R.id.content_menu, fragment).commit();
        //overridePendingTransition(R.anim.left_in, R.anim.left_out);
        if (back) {
            fragmentTransaction.addToBackStack(null);
        }
    }
}
