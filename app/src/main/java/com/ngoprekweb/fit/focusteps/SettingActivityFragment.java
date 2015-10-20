package com.ngoprekweb.fit.focusteps;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class SettingActivityFragment extends Fragment {
    private  static final String TAG = SettingActivityFragment.class.getSimpleName();

    private SeekBar mSeekBar;

    private TextView mTextViewProgress;

    private static final int MAX_PROGRESS = 100;
    private static final int SCALE_PROGRESS = 500;
    private static final int DEFAULT_GOAL = 1000;

    public SettingActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_setting, container, false);

        mTextViewProgress=(TextView)rootView.findViewById(R.id.text_view_progress);
        mSeekBar=(SeekBar)rootView.findViewById(R.id.seek_bar_goal);

        int goal = getGoal();

        mSeekBar.setMax(MAX_PROGRESS);
        mSeekBar.setProgress(goal/SCALE_PROGRESS);
        mTextViewProgress.setText(String.valueOf(goal));

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mTextViewProgress.setText(String.valueOf(progress*SCALE_PROGRESS));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int goal = seekBar.getProgress() * SCALE_PROGRESS;
                saveGoal(goal);
            }
        });

        return rootView;
    }

    private void saveGoal(int goal){
        Log.v(TAG, String.valueOf(goal));

        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(getString(R.string.saved_goal_pref), goal);
        editor.commit();
    }

    private int getGoal(){
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        return sharedPref.getInt(getString(R.string.saved_goal_pref), DEFAULT_GOAL);
    }
}
