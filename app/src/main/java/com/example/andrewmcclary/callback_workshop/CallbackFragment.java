package com.example.andrewmcclary.callback_workshop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.security.auth.callback.Callback;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class CallbackFragment extends Fragment {

    private CallbackClass callback;
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_controller,container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.button_callback_toast)
    protected void showToastButtonClicked(){
        callback.showToast();
    }
    @OnClick(R.id.button_change_message_textview)
    protected void changeTextViewButtonClicked(){
        callback.changeTextView();

    }
    @OnClick(R.id.button_callback_change_backround_color)
    protected void changeBackroundColorClicked(){
        callback.changeBackroundColor();

    }
    @OnClick(R.id.button_remove_fragment_from_activity)
    protected void removeFragmentFromActivityClicked(){
        callback.removeFragment();
        
    }
    
    public void attachParent(CallbackClass callback){
        this.callback = callback;
    }

    public static CallbackFragment newInstance() {
        
        Bundle args = new Bundle();
        
        CallbackFragment fragment = new CallbackFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    public interface CallbackClass{

        void showToast();
        void changeTextView();
        void changeBackroundColor();
        void removeFragment();
    }
}
