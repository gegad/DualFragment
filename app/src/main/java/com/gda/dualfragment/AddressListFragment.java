package com.gda.dualfragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.ListFragment;

import java.util.ArrayList;

public class AddressListFragment extends ListFragment {
    private ArrayList<NameAndAdress> mNameAndAdresses;
    private ActivityComs mActivityComs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mNameAndAdresses = AddressBook.getInstance().getBook();
        AddressListAdapter adapter = new AddressListAdapter(mNameAndAdresses);
        setListAdapter(adapter);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivityComs = (ActivityComs) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivityComs = null;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        mActivityComs.onListItemSelected(position);
    }

    private class AddressListAdapter extends ArrayAdapter {
        public AddressListAdapter (ArrayList<NameAndAdress> nameAndAdressArrayList) {
            super(getActivity(), R.layout.list_item, nameAndAdressArrayList);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) getActivity().getLayoutInflater();
                convertView = inflater.inflate(R.layout.list_item, null);
            }
            NameAndAdress temp = (NameAndAdress) getItem(position);
            TextView txtName = (TextView) convertView.findViewById(R.id.txtName);
            txtName.setText(temp.getName());
            return convertView;
        }
    }
}
