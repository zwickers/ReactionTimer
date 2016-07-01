package justinzwick.reactiontimer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pixplicity.easyprefs.library.Prefs;

public class ResultsActivity extends AppCompatActivity {

    private static final String ELAPSED_TIME_KEY = "elapsed time key";
    private RelativeLayout mRelativeLayout;
    private TextView mMillisecondTextView, mAverageMillisecondsLabel, mAttemptsLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        mRelativeLayout = (RelativeLayout) findViewById(R.id.resultsLayout);
        mMillisecondTextView = (TextView) findViewById(R.id.millisecondTextView);
        mAverageMillisecondsLabel = (TextView) findViewById(R.id.averageMilliseconds);
        mAttemptsLabel = (TextView) findViewById(R.id.attemptsLabel);

        Intent pastIntent = getIntent();
        long milliseconds = pastIntent.getLongExtra(ELAPSED_TIME_KEY,0);

        mMillisecondTextView.setText(milliseconds + " milliseconds");


    }
}
