package com.example.jing_dong.fr;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jing_dong.R;

/**
 * Created by Administrator on 2017/11/6.
 */

public class Fragment3 extends Fragment{

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view==null) {
            view = View.inflate(getContext(), R.layout.f3, null);
        }
        return view;

    }
}
