package com.code2concept.seekbarswipecontrol.activity;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;

import com.code2concept.seekbarswipecontrol.R;
import com.code2concept.seekbarswipecontrol.helper.OnScrollTouchListenerControl;
import com.code2concept.seekbarswipecontrol.i.ISwipeRefresh;


public class MainActivity extends Activity implements ISwipeRefresh ,SeekBar.OnSeekBarChangeListener {

    private final static String TAG = MainActivity.class.getName();
    private SeekBar horizontalSeekB;
    private SeekBar verticalSeekbarB;
    private TextView verticalStatusTv;
    private TextView horizontalStatusTv;
    private int MIN_PROGRESS = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {

        findViewById(R.id.mainContainer).setOnTouchListener(new OnScrollTouchListenerControl(this, this));

        horizontalSeekB     = (SeekBar)findViewById(R.id.horizontalSeekBar);

        horizontalSeekB.setMax(100);

        verticalSeekbarB     = (SeekBar)findViewById(R.id.verticalSeek);

        verticalSeekbarB.setMax(100);

        verticalStatusTv    = (TextView)findViewById(R.id.verticalStatusTv);

        horizontalStatusTv  = (TextView)findViewById(R.id.horizontalStatusTv);

        verticalSeekbarB.setOnSeekBarChangeListener(this);
        horizontalSeekB.setOnSeekBarChangeListener(this);
    }

    @Override
    public void leftSwipe() {
        horizontalSeekB.setProgress(horizontalSeekB.getProgress() - MIN_PROGRESS);
    }

    @Override
    public void rightSwipe() {
        horizontalSeekB.setProgress(horizontalSeekB.getProgress() + MIN_PROGRESS);
    }

    @Override
    public void upSwipe() {
        verticalSeekbarB.setProgress(verticalSeekbarB.getProgress() - MIN_PROGRESS);
    }

    @Override
    public void downSwipe() {
        verticalSeekbarB.setProgress(verticalSeekbarB.getProgress() + MIN_PROGRESS);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        if (seekBar == verticalSeekbarB){
            verticalStatusTv.setText(String.format("%s" , ""+progress));
        }else if (seekBar == horizontalSeekB){
            horizontalStatusTv.setText(String.format("%s" , ""+progress));
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
