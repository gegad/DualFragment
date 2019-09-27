package com.gda.dualfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class PortraitDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portrait_layout);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.detailFragmentHolder);

        int position = 0;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            position = extras.getInt("Position");
        }
        fragment = AddressDetailFragment.newInstance(position);
        fragmentManager.beginTransaction()
                .replace(R.id.detailFragmentHolder, fragment)
                .commit();
    }
}
