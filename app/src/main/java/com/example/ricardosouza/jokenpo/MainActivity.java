package com.example.ricardosouza.jokenpo;

import android.animation.Animator;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ImageButton pedra=(ImageButton)findViewById(R.id.buttonPedra);
        ImageButton papel=(ImageButton)findViewById(R.id.buttonPapel);
        ImageButton tesoura=(ImageButton)findViewById(R.id.buttonTesoura);
        TextView vencedort=(TextView)findViewById(R.id.textVencedor);
        ImageView jogada1=(ImageView)findViewById(R.id.imageJogada1);
        ImageView jogada2=(ImageView)findViewById(R.id.imageJogada2);

        onClick(pedra);
        onClick(papel);
        onClick(tesoura);


    }

    public void onClick(View v)
    {
        v.setOnClickListener(new View.OnClickListener()
                             {
                                 @Override
                                 public void onClick(View v)
                                 {
                                     int j1=0;
                                     int j2=0;

                                     int vencedor=0;

                                     TextView vencedort=(TextView)findViewById(R.id.textVencedor);
                                     ImageView jogada1=(ImageView)findViewById(R.id.imageJogada1);
                                     ImageView jogada2=(ImageView)findViewById(R.id.imageJogada2);
                                     TextView vs=(TextView)findViewById(R.id.textVs);

                                     RelativeLayout princ=(RelativeLayout)findViewById(R.id.principal);

                                     int x = jogada1.getWidth()/2;
                                     int y = jogada1.getHeight()/2;

                                     int x2 = jogada2.getWidth()/2;
                                     int y2 = jogada2.getHeight()/2;

                                     int startRadius = 0;
                                     int endRadius = (int) Math.hypot(princ.getWidth()/2, princ.getHeight()/2);

                                     Animator anim = ViewAnimationUtils.createCircularReveal (jogada1, x, y, startRadius, endRadius);
                                     Animator anim2 = ViewAnimationUtils.createCircularReveal (jogada2, x2, y2, startRadius, endRadius);

                                     anim.setDuration(1000);
                                     anim2.setDuration(1000);
                                     anim.start();
                                     anim2.start();

                                     switch(v.getId())
                                     {
                                         case R.id.buttonPedra:j1=1;break;
                                         case R.id.buttonPapel:j1=2;break;
                                         case R.id.buttonTesoura:j1=3;break;
                                     }


                                     j2=(int)(Math.random()*100)%3+1;
                                     if(j1==1)
                                     {
                                         if(j2==1)
                                         {
                                             vencedor=0;
                                         }
                                         else if(j2==2)
                                         {
                                             vencedor=2;
                                         }
                                         else if(j2==3)
                                         {
                                             vencedor=1;
                                         }
                                     }
                                     else if(j1==2)
                                     {
                                         if(j2==1)
                                         {
                                             vencedor=1;
                                         }
                                         else if(j2==2)
                                         {
                                             vencedor=0;
                                         }
                                         else if(j2==3)
                                         {
                                             vencedor=2;
                                         }
                                     }
                                     else if(j1==3)
                                     {
                                         if(j2==1)
                                         {
                                             vencedor=2;
                                         }
                                         else if(j2==2)
                                         {
                                             vencedor=1;
                                         }
                                         else if(j2==3)
                                         {
                                             vencedor=0;
                                         }
                                     }
                                     jogada1.setVisibility(View.VISIBLE);
                                     jogada2.setVisibility(View.VISIBLE);
                                     vencedort.setVisibility(View.VISIBLE);
                                     vs.setVisibility(View.VISIBLE);
                                     {
                                         if (j1 == 1) {
                                             jogada1.setImageResource(R.drawable.pedra_recortada);

                                         } else if (j1 == 2) {
                                             jogada1.setImageResource(R.drawable.papel_recortado);
                                         } else if (j1 == 3) {
                                             jogada1.setImageResource(R.drawable.tesoura_recortada);
                                         }
                                     }
                                     {
                                         if (j2 == 1) {
                                             jogada2.setImageResource(R.drawable.pedra_recortada);

                                         } else if (j2 == 2) {
                                             jogada2.setImageResource(R.drawable.papel_recortado);
                                         } else if (j2 == 3) {
                                             jogada2.setImageResource(R.drawable.tesoura_recortada);
                                         }
                                     }
                                     {
                                         if (vencedor == 0) {
                                             vencedort.setText("Empate");
                                         } else {
                                             if (vencedor == 1) {
                                                 vencedort.setText("Você venceu");
                                             } else {
                                                 if (vencedor == 2) {
                                                     vencedort.setText("Você perdeu");
                                                 }
                                             }
                                         }
                                     }

                                 }
                             }
        );
    }


}
