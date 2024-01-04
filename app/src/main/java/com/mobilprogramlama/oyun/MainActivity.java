package com.mobilprogramlama.oyun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText edt;
    EditText edt2;
    EditText edt3;
    Button btn,TemizBtn;

    ImageView resim;

    int oyuncu1=0;
    int oyuncu2=0;
    int sayac=0;
    int hak=1;
    String sonuc="durum";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=(Button) findViewById(R.id.button);
        edt=(EditText) findViewById(R.id.editText);
        edt2=(EditText) findViewById(R.id.editText2);
        edt3=(EditText) findViewById(R.id.editText3);
        TemizBtn=(Button) findViewById(R.id.button2);
        resim=(ImageView) findViewById(R.id.imageView);




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (sayac<6)
                {
                    int number;
                    Random random = new Random();
                    number = random.nextInt(6) + 1;
                    edt.setText(String.valueOf(number));

                    String adres = "zar" + String.valueOf(number);
                    int id = getResources().getIdentifier(adres, "drawable", getPackageName());
                    resim.setImageResource(id);
                    if (hak==1)
                    {
                        oyuncu1=oyuncu1+number;
                        hak=2;
                        sayac++;
                        edt2.setText(String.valueOf(oyuncu1));
                    }else if(hak==2)
                    {
                        oyuncu2=oyuncu2+number;
                        hak=1;
                        sayac++;
                        edt3.setText(String.valueOf(oyuncu2));
                    }

                }

                if ((oyuncu1>oyuncu2) & (sayac==6)) {
                    sonuc=" Oyuncu 1 kazandı";
                    Toast.makeText(getApplicationContext(),String.valueOf(sonuc),Toast.LENGTH_LONG).show();
                } else if ((oyuncu1<oyuncu2)& (sayac==6)) {
                    sonuc=" Oyuncu 2 kazandı";
                    Toast.makeText(getApplicationContext(),String.valueOf(sonuc),Toast.LENGTH_LONG).show();
                }else if ((oyuncu1==oyuncu2)& (sayac==6)){
                    sonuc=" Berabere";
                    Toast.makeText(getApplicationContext(),String.valueOf(sonuc),Toast.LENGTH_LONG).show();
                }


                Toast.makeText(getApplicationContext(),String.valueOf(sayac),Toast.LENGTH_LONG).show();




            }
        });


        TemizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt.setText("");
                edt2.setText("");
                edt3.setText("");
                sayac=0;
                oyuncu1=0;
                oyuncu2=0;
                hak=1;
                resim.setImageResource(R.drawable.ugur);

            }
        });

    }
}