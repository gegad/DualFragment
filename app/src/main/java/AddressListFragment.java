import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.gda.dualfragment.R;

import java.util.ArrayList;

public class AddressListFragment extends ListFragment {
    private ArrayList<NameAndAdress> mNameAndAdresses;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mNameAndAdresses = AddressBook.getInstance().getBook();
        AddressListAdapter adapter = new AddressListAdapter(mNameAndAdresses);
        setListAdapter(adapter);
    }

    private class AddressListAdapter extends ArrayAdapter {
        public AddressListAdapter (ArrayList<NameAndAdress>) {
            super(getActivity(), R.layout.list_item, mNameAndAdresses);
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
