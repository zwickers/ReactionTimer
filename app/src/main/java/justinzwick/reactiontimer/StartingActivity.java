package justinzwick.reactiontimer;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.pixplicity.easyprefs.library.Prefs;

public class StartingActivity extends AppCompatActivity {

    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);

        mRelativeLayout = (RelativeLayout) findViewById(R.id.startLayout);
        mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartingActivity.this,WaitActivity.class);
                startActivity(intent);
            }
        });


    }
}
