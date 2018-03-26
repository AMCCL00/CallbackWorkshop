package com.example.andrewmcclary.callback_workshop;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements CallbackFragment.CallbackClass{


    @BindView(R.id.button_change_message_textview)
    protected TextView callbackMessageTextview;
    @BindView(R.id.activity_layout)
    protected ConstraintLayout activityLayout;
    private CallbackFragment callbackFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_fragment_launcher)
    protected void fragmentLauncherButtonClicked(){

        CallbackFragment fragment = CallbackFragment.newInstance();

        callbackFragment.attachParent(MainActivity.this);

        getSupportFragmentManager().beginTransaction().replace(R.id.layout_fragment_holder,callbackFragment).commit();
    }

    @Override
    public void showToast() {
        Toast.makeText(this, "The Main Activity is Toasting the Fragment.", Toast.LENGTH_LONG).show();

    }

    @Override
    public void changeTextView() {
        callbackMessageTextview.setText("Callback Recieved");
    }

    @Override
    public void changeBackroundColor() {
        activityLayout.setBackgroundColor(Color.CYAN);
    }

    @Override
    public void removeFragment() {
        getSupportFragmentManager().beginTransaction().remove(callbackFragment).commit();
    }
}
