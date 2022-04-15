package com.example.lesson23;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lesson23.databinding.FragmentBlankBinding;


public class BlankFragment extends Fragment {

   private FragmentBlankBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBlankBinding.inflate(LayoutInflater.from(requireActivity()),container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (binding.edittext1.length() > 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString("KEY", binding.edittext1.getText().toString());

                    SecondFragment secondFragment = new SecondFragment();
                    secondFragment.setArguments(bundle);


                    requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, secondFragment).addToBackStack(" ").commit();
                }else {
                    binding.edittext1.setText("ERROR!");
                }
            }
            
        });
    }
}