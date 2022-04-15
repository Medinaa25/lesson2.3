package com.example.lesson23;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lesson23.databinding.FragmentThirdBinding;

public class ThirdFragment extends Fragment {

    private FragmentThirdBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentThirdBinding.inflate(LayoutInflater.from(requireActivity()),container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
        String value = getArguments().getString("KEY");
            binding.edittext3.setText(value);
        }
        binding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.edittext3.getText().toString() != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("KEY", binding.edittext3.getText().toString());
                    if (binding.edittext3.getText().toString().equals(" ")) {
                        binding.edittext3.setText("ERROR!");
                    }

                    FourthFragment fourthFragment = new FourthFragment();
                    fourthFragment.setArguments(bundle2);

                    requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fourthFragment).addToBackStack(" ").commit();
                }
            }
        });
    }
}