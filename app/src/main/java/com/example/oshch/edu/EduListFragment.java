package com.example.oshch.edu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class EduListFragment extends ListFragment{
    private ArrayList<EduModelItem> mModelItems;

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        EduModelItem item = (EduModelItem)(getListAdapter().getItem(position));

        Intent intent = new Intent(getActivity(), EduDetailedActivity.class);
        intent.putExtra(EduDetailedFragment.EXTRA_ITEM_ID, item.getId());
        startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.edu_title);

        mModelItems = EduModel.get(getActivity()).getModelItems();
        ModelItemAdapter adapter = new ModelItemAdapter(mModelItems);

        setListAdapter(adapter);
    }

    private class ModelItemAdapter extends ArrayAdapter<EduModelItem> {
        public ModelItemAdapter(ArrayList<EduModelItem> items) {
            super(getActivity(), 0, items);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_model_item, null);
            }

            EduModelItem item = getItem(position);
            TextView titleTextView = (TextView)convertView.findViewById(R.id.item_list_title);
            titleTextView.setText(item.getTitle());
            TextView dateTextView = (TextView)convertView.findViewById(R.id.item_list_date);
            dateTextView.setText(item.getDate().toString());
            CheckBox solvedCheckBox = (CheckBox)convertView.findViewById(R.id.item_list_checkBox);
            solvedCheckBox.setChecked(item.isSolved());
            return convertView;
        }
    }
}
