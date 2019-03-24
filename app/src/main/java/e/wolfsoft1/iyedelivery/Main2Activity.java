package e.wolfsoft1.iyedelivery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView screen1,screen2,screen3,screen4,screen5,screen6,screen7,screen8,screen9,
            screen10,screen11,screen12,screen13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        screen1=(TextView)findViewById(R.id.screen1);
        screen2=(TextView)findViewById(R.id.screen2);
        screen3=(TextView)findViewById(R.id.screen3);
        screen4=(TextView)findViewById(R.id.screen4);
        screen5=(TextView)findViewById(R.id.screen5);
        screen6=(TextView)findViewById(R.id.screen6);
        screen7=(TextView)findViewById(R.id.screen7);
        screen8=(TextView)findViewById(R.id.screen8);
        screen9=(TextView)findViewById(R.id.screen9);
        screen10=(TextView)findViewById(R.id.screen10);
        screen11=(TextView)findViewById(R.id.screen11);
        screen12=(TextView)findViewById(R.id.screen12);
        screen13=(TextView)findViewById(R.id.screen13);

        screen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main2Activity.this,LoginActivity.class);
                startActivity(intent);
            }
        });


        screen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main2Activity.this,CartActivity.class);
                startActivity(intent);
            }
        });


        screen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main2Activity.this,Shipping.class);
                startActivity(intent);
            }
        });

        screen4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main2Activity.this,EnterMobileActivity.class);
                startActivity(intent);
            }
        });

        screen5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main2Activity.this,OtpVerificationActivity.class);
                startActivity(intent);
            }
        });

        screen6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main2Activity.this,MenuActivity.class);
                startActivity(intent);
            }
        });

        screen7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main2Activity.this,HomeActivity.class);
                startActivity(intent);
            }
        });


        screen9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main2Activity.this,PaymentActivity.class);
                startActivity(intent);
            }
        });
        screen10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main2Activity.this,ConfirmOrderActivity.class);
                startActivity(intent);
            }
        });
        screen11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main2Activity.this,MyOrders.class);
                startActivity(intent);
            }
        });
        screen8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main2Activity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });
        screen12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main2Activity.this,RestaurantProfile.class);
                startActivity(intent);
            }
        });
        screen13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main2Activity.this,HomeActivity.class);
                startActivity(intent);
            }
        });


    }
}
