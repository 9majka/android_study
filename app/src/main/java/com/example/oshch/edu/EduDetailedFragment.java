package com.example.oshch.edu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;


public class EduDetailedFragment extends Fragment {

    public static final String EXTRA_ITEM_ID = "com.example.oshch.edu.item_id";
    private EduModelItem mModelItem;
    private EditText mEntry;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detailed, container, false);

        mEntry = (EditText)v.findViewById(R.id.item_title);
        mEntry.setText(mModelItem.getTitle());

        mDateButton = (Button)v.findViewById(R.id.item_date);
        mDateButton.setText(mModelItem.getDate().toString());
        mDateButton.setEnabled(false);

        mSolvedCheckBox = (CheckBox)v.findViewById(R.id.item_solved);
        mSolvedCheckBox.setChecked(mModelItem.isSolved());
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mModelItem.setSolved(isChecked);
            }
        });

        return v;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID itemId = (UUID)getArguments().getSerializable(EXTRA_ITEM_ID);
        mModelItem = EduModel.get(getActivity()).getModelItem(itemId);
    }

    public static EduDetailedFragment getInstance(UUID id){
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_ITEM_ID, id);
        EduDetailedFragment fragment = new EduDetailedFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
