package practicaltest01var04.eim.systems.cs.pub.ro.practicaltest01var04;

import android.app.Activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class PracticalTest01Var04PlayActivity extends Activity {


    private TextView guess = null;
    private TextView score = null;
    private Button gener = null;
    private Button check = null;
    private Button back = null;


    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        Random randomGenerator = new Random();
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.gener:
                    int nr = randomGenerator.nextInt(10);
                    guess.setText(String.valueOf(nr));
                    break;

                case R.id.back:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_play);


        guess= (TextView)findViewById(R.id.guess);
        score = (TextView)findViewById(R.id.score);
        guess.setText(String.valueOf("Guess"));
        score.setText(String.valueOf(0));

        gener = (Button)findViewById(R.id.gener);
        check = (Button)findViewById(R.id.check);
        back = (Button)findViewById(R.id.back);

        gener.setOnClickListener(buttonClickListener);
        back.setOnClickListener(buttonClickListener);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("leftCount")) {
                guess.setText(savedInstanceState.getString("leftCount"));
            } else {
                guess.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("rightCount")) {
                score.setText(savedInstanceState.getString("rightCount"));
            } else {
                score.setText(String.valueOf(0));
            }
        } else {
            guess.setText(String.valueOf(0));
            score.setText(String.valueOf(0));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.practical_test01, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("guess", guess.getText().toString());
        savedInstanceState.putString("score", score.getText().toString());
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("guess")) {
            guess.setText(savedInstanceState.getString("guess"));
        } else {
            guess.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("score")) {
            score.setText(savedInstanceState.getString("score"));
        } else {
           score.setText(String.valueOf(0));
        }
    }
}

