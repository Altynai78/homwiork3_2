package com.example.homwiork3_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class MeinFragment extends Fragment {

    private Button plus;
    private Button minus;
    private Button reset;
    private TextView zero;
    private Integer counter;

    private final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_minus:
                    counter--;
                    zero.setText(Integer.toString(counter));
                    break;
                case R.id.btn_plus:
                    counter++;
                    zero.setText(Integer.toString(counter));
                    break;
                case R.id.btn_reset:
                    initCounter();
                    break;
            }
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mein, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initListener();
        initCounter();
    }

    private void initCounter() {
        counter = 0;
        zero.setText(Integer.toString(counter));
    }

    private void initListener() {
        minus.setOnClickListener(onClickListener);
        plus.setOnClickListener(onClickListener);
        reset.setOnClickListener(onClickListener);
    }

    private void initView() {
        minus = requireActivity().findViewById(R.id.btn_minus);
        plus = requireActivity().findViewById(R.id.btn_plus);
        reset = requireActivity().findViewById(R.id.btn_reset);
        zero = requireActivity().findViewById(R.id.tv_zero);
    }
}