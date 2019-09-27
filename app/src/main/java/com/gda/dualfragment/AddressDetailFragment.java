package com.gda.dualfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class AddressDetailFragment extends Fragment {
    private ArrayList<NameAndAdress> mNameAndAdressArrayList;
    private NameAndAdress mCurrentNameAndAdress;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNameAndAdressArrayList = AddressBook.getInstance().getBook();
        int position = (int) getArguments().getInt("Position");
        mCurrentNameAndAdress = mNameAndAdressArrayList.get(position);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_fragment, container, false);

        TextView txtName = view.findViewById(R.id.txtName);
        TextView txtAddres1 = view.findViewById(R.id.txtAddress1);
        TextView txtAddres2 = view.findViewById(R.id.txtAddress2);
        TextView txtZipCode = view.findViewById(R.id.txtZipCode);

        txtName.setText(mCurrentNameAndAdress.mName);
        txtAddres1.setText(mCurrentNameAndAdress.mAddress1);
        txtAddres2.setText(mCurrentNameAndAdress.mAddress2);
        txtZipCode.setText(mCurrentNameAndAdress.mZipCode);

        return view;
    }

    public static AddressDetailFragment newInstance(int position) {
        Bundle args = new Bundle();
        args.putInt("Position", position);

        AddressDetailFragment fragment = new AddressDetailFragment();
        fragment.setArguments(args);

        return fragment;
    }

}
