package com.example.project_1.ui.find;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.project_1.R;
import com.example.project_1.databinding.FragmentAshareBinding;

public class AshareFragment extends Fragment {
    private FragmentAshareBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAshareBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button b1 = binding.b1;
        b1.setOnClickListener(v->Navigation.findNavController(getView()).navigate(R.id.AsharetoIndex));
        Button b2 = binding.b3;
        b2.setOnClickListener(v->Navigation.findNavController(getView()).navigate(R.id.AsharetoKnowledge));
        Button bt1 = binding.b4;
        bt1.setOnClickListener(v->Navigation.findNavController(getView()).navigate(R.id.AsharetoRanking));
        Button bt2 = binding.b5;
        bt2.setOnClickListener(v->Navigation.findNavController(getView()).navigate(R.id.AsharetoRanking));
        Button bt3 = binding.b8;
        bt3.setOnClickListener(v->Navigation.findNavController(getView()).navigate(R.id.AsharetoRanking));
        Button bt4 = binding.b11;
        bt4.setOnClickListener(v->Navigation.findNavController(getView()).navigate(R.id.AsharetoRanking));
        Button bt5 = binding.b15;
        bt5.setOnClickListener(v->Navigation.findNavController(getView()).navigate(R.id.AsharetoTiger));
        Button bt6 = binding.b16;
        bt6.setOnClickListener(v->Navigation.findNavController(getView()).navigate(R.id.AsharetoTiger));
        Button bt7 = binding.b17;
        bt7.setOnClickListener(v->Navigation.findNavController(getView()).navigate(R.id.AsharetoTiger));
        Button bt8 = binding.b19;
        bt8.setOnClickListener(v->Navigation.findNavController(getView()).navigate(R.id.AsharetoFlow));
        Button bt9 = binding.b20;
        bt9.setOnClickListener(v->Navigation.findNavController(getView()).navigate(R.id.AsharetoFlow));
        Button bt10 = binding.b22;
        bt10.setOnClickListener(v->Navigation.findNavController(getView()).navigate(R.id.AsharetoFlow));
        Button bt11 = binding.b23;
        bt11.setOnClickListener(v->Navigation.findNavController(getView()).navigate(R.id.AsharetoFlow));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
