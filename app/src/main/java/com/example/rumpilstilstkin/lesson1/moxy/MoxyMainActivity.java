package com.example.rumpilstilstkin.lesson1.moxy;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.rumpilstilstkin.lesson1.R;


public class MoxyMainActivity extends MvpAppCompatActivity implements MoxyExampleView {

    @InjectPresenter
    Presenter presenter;

    private Button btnCounter1;
    private Button btnCounter2;
    private Button btnCounter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCounter1 = findViewById(R.id.btnCounter1);
        btnCounter2 = findViewById(R.id.btnCounter2);
        btnCounter3 = findViewById(R.id.btnCounter3);
        btnCounter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.buttonClick(0);
            }
        });
        btnCounter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.buttonClick(1);
            }
        });
        btnCounter3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.buttonClick(2);
            }
        });
    }

    @Override
    public void setButtonText(int btnIndex, int value) {
        switch (btnIndex) {
            case 0:
                btnCounter1.setText(String.format(getString(R.string.summ), value));
                break;
            case 1:
                btnCounter2.setText(String.format(getString(R.string.summ), value));
                break;
            case 2:
                btnCounter3.setText(String.format(getString(R.string.summ), value));
                break;
        }
    }
}
