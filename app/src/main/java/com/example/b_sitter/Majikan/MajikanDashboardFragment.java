package com.example.b_sitter.Majikan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.b_sitter.R;

public class MajikanDashboardFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.majikan_dashboard_fragment, container, false);
        final TextView textView = root.findViewById(R.id.text_home);

        return root;
    }
}