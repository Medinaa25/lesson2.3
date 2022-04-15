package com.example.lesson23;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lesson23.databinding.FragmentFourthBinding;

public class FourthFragment extends Fragment {

    private FragmentFourthBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFourthBinding.inflate(LayoutInflater.from(requireActivity()), container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null){
            String value = getArguments().getString("KEY");
            binding.textview1.setText(value);
        }
        binding.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle3 = new Bundle();
                bundle3.putString("KEY",binding.textview1.toString());

                FivethFragment fivethFragment = new FivethFragment();
                fivethFragment.setArguments(bundle3);

                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fivethFragment).addToBackStack(" ").commit();

            }
        });
    }
}