package e.wolfsoft1.iyedelivery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_);


        Thread shivThread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(getApplicationContext(),Main_Handler_Activity.class);
                intent.putExtra("id",1);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.slide_up_linear,R.anim.stay);
            }
        });

        shivThread.start();


    }
}
