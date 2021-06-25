package newquizeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sagarkhurana.quizenew.R;


public class splashactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashactivity);
        ImageView imageView=findViewById(R.id.image_view);

        Glide.with(this).load((R.drawable.splash_image)).into(imageView);
        startMainScreen();
    }

    private void startMainScreen() {

        Thread git = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);

                    startActivity(new Intent(splashactivity.this, LoginActivity.class));
                } catch (Exception ex) {

                } finally {
                    finish();
                }
            }
        };
        git.start();

    }
}