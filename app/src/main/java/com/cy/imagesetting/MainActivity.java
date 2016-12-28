package com.cy.imagesetting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.hisilicon.android.HiDisplayManager;

public class MainActivity extends AppCompatActivity {

    private TextView textBrightness;
    private SeekBar seekBarBrightness;
    private HiDisplayManager displayManager;
    private TextView textHue;
    private SeekBar seekBarHue;
    private TextView textContrast;
    private SeekBar seekBarContrast;
    private TextView textSaturation;
    private SeekBar seekBarSaturation;
    private int initBrightness;
    private int initHue;
    private int initContrast;
    private int initSaturation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayManager = new HiDisplayManager();
        initView();
        initListener();
    }

    private void initListener() {
        seekBarBrightness.setOnSeekBarChangeListener(new BrightnessSeekBarChangeListener());
        seekBarHue.setOnSeekBarChangeListener(new HueSeekBarChangeListener());
        seekBarContrast.setOnSeekBarChangeListener(new ContrastSeekBarChangeListener());
        seekBarSaturation.setOnSeekBarChangeListener(new SaturationSeekBarChangeListener());
    }

    private void initView() {
        /*brightness*/
        textBrightness = (TextView) findViewById(R.id.tv_image_setting_brightness);
        seekBarBrightness = (SeekBar) findViewById(R.id.sb_image_setting_brightness);
        seekBarBrightness.setMax(100);
        initBrightness = displayManager.getBrightness();
        if(initBrightness <0|| initBrightness >100){
            initBrightness =50;
        }
        seekBarBrightness.setProgress(initBrightness);
        textBrightness.setText(String.valueOf(initBrightness));
        /*Hue*/
        textHue = (TextView) findViewById(R.id.tv_image_setting_Hue);
        seekBarHue = (SeekBar) findViewById(R.id.sb_image_setting_Hue);
        seekBarBrightness.setMax(100);
        initHue = displayManager.getHue();
        if(initHue <0|| initHue >100){
            initHue =50;
        }
        seekBarHue.setProgress(initHue);
        textHue.setText(String.valueOf(initHue));
        /*contrast*/
        textContrast = (TextView) findViewById(R.id.tv_image_setting_contrast);
        seekBarContrast = (SeekBar) findViewById(R.id.sb_image_setting_contrast);
        seekBarBrightness.setMax(100);
        initContrast = displayManager.getContrast();
        if(initContrast <0|| initContrast >100){
            initContrast =50;
        }
        seekBarContrast.setProgress(initContrast);
        textContrast.setText(String.valueOf(initContrast));
        /*saturation*/
        textSaturation = (TextView) findViewById(R.id.tv_image_setting_saturation);
        seekBarSaturation = (SeekBar) findViewById(R.id.sb_image_setting_saturation);
        seekBarSaturation.setMax(100);
        initSaturation = displayManager.getSaturation();
        if(initSaturation <0|| initSaturation >100){
            initSaturation =50;
        }
        seekBarSaturation.setProgress(initSaturation);
        textSaturation.setText(String.valueOf(initSaturation));
    }

    public void saveParamImageSetting(View view) {
        displayManager.SaveParam();
        finish();
    }

    public void initParamImageSetting(View view) {
        displayManager.setBrightness(initBrightness);
        displayManager.setHue(initHue);
        displayManager.setContrast(initContrast);
        displayManager.setSaturation(initSaturation);
        finish();
    }

    private class BrightnessSeekBarChangeListener implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            seekBar.setProgress(progress);
            textBrightness.setText(String.valueOf(progress));
            displayManager.setBrightness(progress);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }

    private class HueSeekBarChangeListener implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            seekBar.setProgress(progress);
            textHue.setText(String.valueOf(progress));
            displayManager.setHue(progress);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }

    private class ContrastSeekBarChangeListener implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            seekBar.setProgress(progress);
            textContrast.setText(String.valueOf(progress));
            displayManager.setContrast(progress);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }

    private class SaturationSeekBarChangeListener implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            seekBar.setProgress(progress);
            textSaturation.setText(String.valueOf(progress));
            displayManager.setSaturation(progress);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }
}
