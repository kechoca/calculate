package com.example.sampletes;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.ceylonlabs.imageviewpopup.ImagePopup;

public class MainActivity extends AppCompatActivity {

    EditText edit_text;
    Button bt_cal;
    TextView txt_num;
    ImageView img_price;

    long price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        onClick();
        popup();

    }

    public void initView(){
        edit_text = (EditText) findViewById(R.id.num);
        bt_cal = (Button) findViewById(R.id.btnCal);
        txt_num = (TextView) findViewById(R.id.txtNum);
        img_price = (ImageView) findViewById(R.id.imgPrice);

    }

    public void onClick(){
        bt_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long cNumber = 0;
                String t = edit_text.getText().toString();

                if(!t.equals("")) {
                    cNumber = Integer.parseInt(edit_text.getText().toString());
                }else {
                    cNumber = 0;
                }

                if(cNumber != 0){
                    calculateNumber(cNumber);
                }else {
                    Toast.makeText(MainActivity.this , "Please fill number !!" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void calculateNumber(long num){
        if(num<101){
            price = num*2000;
        }
        else if(num>100 && num<201){
            price = num*2100;
        }
        else if(num>200 && num<301){
            price = num*2250;
        }
        else if(num>300 && num<401){
            price = num*2450;
        }
        else if(num>400){
            price = num*2700;
        }

        String txt = price + " " + "บาท";
        txt_num.setText(txt);
    }

    public void popup(){
        final ImagePopup imagePopup = new ImagePopup(this);
        imagePopup.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imagePopup.setBackgroundColor(Color.BLACK);
        imagePopup.setFullScreen(true);
        imagePopup.setHideCloseIcon(true);
        imagePopup.setImageOnClickClose(true);
        imagePopup.initiatePopup(img_price.getDrawable());

        img_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagePopup.viewPopup();
            }
        });
    }

}
