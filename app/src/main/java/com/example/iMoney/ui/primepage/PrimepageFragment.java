package com.example.iMoney.ui.primepage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.iMoney.LoginActivity;
import com.example.iMoney.R;
import com.example.iMoney.Test.TestActivity;
import com.example.iMoney.databinding.FragmentPrimepageBinding;

public class PrimepageFragment extends Fragment {

    private FragmentPrimepageBinding binding;

    @SuppressLint("SetTextI18n")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPrimepageBinding.inflate(inflater, container, false);
        TextView tv = binding.hello;
        tv.setText("Hi!");
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
