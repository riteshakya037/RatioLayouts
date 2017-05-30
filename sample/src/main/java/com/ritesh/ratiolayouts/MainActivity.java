package com.ritesh.ratiolayouts;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.ritesh.ratiolayout.base.RatioBase;
import com.ritesh.ratiolayout.models.enums.FixedAttribute;

public class MainActivity extends AppCompatActivity {

    private RatioBase ratioLayout;
    private TextView ratioLayoutText;
    private SeekBar horizontalSeekBar;
    private SeekBar verticalSeekBar;
    private FixedAttribute currentFixedAttribute = FixedAttribute.WIDTH;
    private final SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            redraw();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize Views
        ratioLayout = (RatioBase) findViewById(R.id.activity_main_ratio_layout);
        ratioLayoutText = (TextView) findViewById(R.id.activity_main_ratio_layout_text);
        horizontalSeekBar = (SeekBar) findViewById(R.id.activity_main_seekbar_horizontal);
        verticalSeekBar = (SeekBar) findViewById(R.id.activity_main_seekbar_vertical);
        // Add respectiveListeners
        redraw();
        ((RadioGroup) findViewById(R.id.activity_main_radio_group)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.activity_main_radio_width:
                        currentFixedAttribute = FixedAttribute.WIDTH;
                        redraw();
                        break;
                    case R.id.activity_main_radio_height:
                        currentFixedAttribute = FixedAttribute.HEIGHT;
                        redraw();
                        break;
                }
            }
        });
        horizontalSeekBar.setOnSeekBarChangeListener(onSeekBarChangeListener);
        verticalSeekBar.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    /**
     * Set current configuration to text view and redraw layout.
     */
    private void redraw() {
        ratioLayout.setRatio(currentFixedAttribute, horizontalSeekBar.getProgress() + 1, verticalSeekBar.getProgress() + 1);
        ratioLayoutText.setText(getString(R.string.width_n1x1, currentFixedAttribute.name(), horizontalSeekBar.getProgress() + 1, verticalSeekBar.getProgress() + 1));
    }
}
