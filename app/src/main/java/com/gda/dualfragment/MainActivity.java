package com.gda.dualfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
implements ActivityComs {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dualfragment);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.listFragmentHolder, new AddressListFragment());
        ft.commit();
    }

    public void onListItemSelected(int position) {
        if (findViewById(R.id.detailFragmentHolder) == null) {
//          Portrait mode
            Intent i = new Intent(this, PortraitDetailActivity.class);
            i.putExtra("Position", position);
            startActivity(i);
        } else {
//          Landscape mode
            Fragment fragment = AddressDetailFragment.newInstance(position);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.detailFragmentHolder, fragment);
            ft.commit();
        }
    }
}
