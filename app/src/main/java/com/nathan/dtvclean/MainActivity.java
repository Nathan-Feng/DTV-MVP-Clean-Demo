package com.nathan.dtvclean;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nathan.arch.domain.model.TipMessage;
import com.nathan.arch.presentation.presenters.IDVBPlayPresenter;
import com.nathan.arch.presentation.presenters.impl.IDVBPlayPresenterImpl;

public class MainActivity extends AppCompatActivity implements IDVBPlayPresenter.EventCallback{

    private  IDVBPlayPresenter playPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playPresenter = new IDVBPlayPresenterImpl();
        playPresenter.attach(this);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playPresenter.playChannelByNum(123);
            }
        });
    }

    @Override
    public void showChannelPlayFinish() {
        Toast.makeText(this,"Play finish",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showChannelLockPasswordDialog() {

    }

    @Override
    public void showTunerTipMessage(TipMessage tipMessage) {

    }

    @Override
    public void showTunerChannelUpdate() {

    }



    @Override
    public void showChannelPlayChange() {

    }

    @Override
    public void showPVRTunerNotEnough() {

    }

    @Override
    public void showError(String s) {

    }
}
