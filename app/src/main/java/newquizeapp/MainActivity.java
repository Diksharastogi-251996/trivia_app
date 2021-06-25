package newquizeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.sagarkhurana.quizenew.R;

import newquizeapp.data.User;
import newquizeapp.other.Constants;
import newquizeapp.other.SharedPref;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView tvUsername = findViewById(R.id.tvUsernameHome);
        ImageView cvStartQuiz = findViewById(R.id.quiz);

        ImageView history = findViewById(R.id.history);


        SharedPref sharedPref = SharedPref.getInstance();
        User user = sharedPref.getUser(this);
        tvUsername.setText("Hello, " + user.getUsername());

        cvStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, quizactivity.class);
                intent.putExtra(Constants.SUBJECT,getString(R.string.start_quiz));
                startActivity(intent);

            }
        });



        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, HistoryActivity.class));
            }
        });








    }


}