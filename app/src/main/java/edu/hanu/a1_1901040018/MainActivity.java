package edu.hanu.a1_1901040018;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.media.MediaPlayer;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static int[] audioFile = new int[]{
            R.raw.a, R.raw.i, R.raw.u, R.raw.e, R.raw.o, R.raw.ka,
            R.raw.ki, R.raw.ku, R.raw.ke, R.raw.ko, R.raw.sa, R.raw.shi,
            R.raw.su, R.raw.se, R.raw.so, R.raw.ta, R.raw.chi, R.raw.tsu,
            R.raw.te, R.raw.to, R.raw.na, R.raw.ni, R.raw.nu, R.raw.ne,
            R.raw.no, R.raw.ha, R.raw.hi, R.raw.fu, R.raw.he, R.raw.ho,
            R.raw.ma, R.raw.mi, R.raw.mu, R.raw.me, R.raw.mo, R.raw.ya,
            R.raw.yu, R.raw.yo, R.raw.ra, R.raw.ri, R.raw.ru, R.raw.re,
            R.raw.ro, R.raw.wa, R.raw.wo, R.raw.n
    };

    public static int[] hiraganaButtonPage = new int[]{
            R.id.a, R.id.i, R.id.u, R.id.e, R.id.o, R.id.ka,
            R.id.ki, R.id.ku, R.id.ke, R.id.ko, R.id.sa, R.id.shi,
            R.id.su, R.id.se, R.id.so, R.id.ta, R.id.chi, R.id.tsu,
            R.id.te, R.id.to, R.id.na, R.id.ni, R.id.nu, R.id.ne,
            R.id.no, R.id.ha, R.id.hi, R.id.fu, R.id.he, R.id.ho,
            R.id.ma, R.id.mi, R.id.mu, R.id.me, R.id.mo, R.id.ya,
            R.id.yu, R.id.yo, R.id.ra, R.id.ri, R.id.ru, R.id.re,
            R.id.ro, R.id.wa, R.id.wo, R.id.n
    };

    public static int[] katakanaButtonPage = new int[]{
            R.id.a1, R.id.i1, R.id.u1, R.id.e1, R.id.o1, R.id.ka1,
            R.id.ki1, R.id.ku1, R.id.ke1, R.id.ko1, R.id.sa1, R.id.shi1,
            R.id.su1, R.id.se1, R.id.so1, R.id.ta1, R.id.chi1, R.id.tsu1,
            R.id.te1, R.id.to1, R.id.na1, R.id.ni1, R.id.nu1, R.id.ne1,
            R.id.no1, R.id.ha1, R.id.hi1, R.id.fu1, R.id.he1, R.id.ho1,
            R.id.ma1, R.id.mi1, R.id.mu1, R.id.me1, R.id.mo1, R.id.ya1,
            R.id.yu1, R.id.yo1, R.id.ra1, R.id.ri1, R.id.ru1, R.id.re1,
            R.id.ro1, R.id.wa1, R.id.wo1, R.id.n1
    };

    public static ImageButton[] hiraganaButton = new ImageButton[hiraganaButtonPage.length];
    public static ImageButton[] katakanaButton = new ImageButton[katakanaButtonPage.length];
    public static MediaPlayer[] mediaPlayer = new MediaPlayer[audioFile.length];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView main_title = findViewById(R.id.Main_Title);
        ScrollView hiraganaHomepage = findViewById(R.id.hiraganaMainPage);
        ScrollView katakanaHomepage = findViewById(R.id.katakanaMainPage);

        Button hiraganaChange = findViewById(R.id.hiraganaButtonPage);
        Button katakanaChange = findViewById(R.id.katakanaButtonPage);

        // Click to hiragana page
        hiraganaChange.setOnClickListener(view -> {
            hiraganaHomepage.animate().alpha(1).setDuration(1000);
            hiraganaHomepage.bringToFront();
            katakanaHomepage.animate().alpha(0).setDuration(1000);
            main_title.animate().setDuration(1000);
            main_title.setText("Hiragana");
        });
        //Click to katakana page
        katakanaChange.setOnClickListener(view -> {
            katakanaHomepage.animate().alpha(1).setDuration(1000);
            katakanaHomepage.bringToFront();
            hiraganaHomepage.animate().alpha(0).setDuration(1000);
            main_title.animate().setDuration(1000);
            main_title.setText("Katakana");
        });
        // For audio pronunciation
        for (int i = 0; i < mediaPlayer.length ; i++) {
            mediaPlayer[i] = MediaPlayer.create(MainActivity.this, audioFile[i]);
        }

        for (int i = 0; i < hiraganaButtonPage.length; i++) {
            int mediaIndex = i;
            int id = hiraganaButtonPage[i];
            hiraganaButton[i] = (ImageButton) (findViewById(id));
            hiraganaButton[i].setOnClickListener(view -> {
                mediaPlayer[mediaIndex].start();
            });
        }

        for (int i = 0; i < katakanaButtonPage.length; i++) {
            int mediaIndex = i;
            int id = katakanaButtonPage[i];
            katakanaButton[i] = (ImageButton) (findViewById(id));
            katakanaButton[i].setOnClickListener(view -> {
                mediaPlayer[mediaIndex].start();
            });
        }
    }
}