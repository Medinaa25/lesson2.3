package com.example.lesson23;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lesson23.databinding.FragmentBlankBinding;
import com.example.lesson23.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private @NonNull FragmentSecondBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(LayoutInflater.from(requireActivity()),container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            String textValue = getArguments().getString("KEY");
                binding.edittext2.setText(textValue);
            }
            binding.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle1  = new Bundle();
                    bundle1.putString("KEY", binding.edittext2.getText().toString());

                    ThirdFragment thirdFragment = new ThirdFragment();
                    thirdFragment.setArguments(bundle1);

                    requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, thirdFragment).addToBackStack(" ").commit();
                }
                });
            };
}
