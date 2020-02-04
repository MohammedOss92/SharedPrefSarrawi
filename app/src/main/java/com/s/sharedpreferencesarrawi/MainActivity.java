package com.s.sharedpreferencesarrawi;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView tvName;
    CheckBox cbMS;
    RelativeLayout rl;
    Typeface tf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rl=(RelativeLayout) findViewById(R.id.rl1);




    }


    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        tvName=(TextView) findViewById(R.id.textView1);
        cbMS=(CheckBox) findViewById(R.id.checkBox1);
        SharedPreferences sp=PreferenceManager.getDefaultSharedPreferences(this);
        //SharedPreferences sp2=getSharedPreferences("MyPref", MODE_WORLD_WRITEABLE);

        tvName.setText( sp.getString("name","No name found"));
        cbMS.setChecked( sp.getBoolean("ms", false));
        if(sp.getInt("BackGroundColor", 0)==0)
        {
            rl.setBackgroundColor(Color.RED);

        }
        else if(sp.getInt("BackGroundColor", 0)==1)
        {
            rl.setBackgroundColor(Color.GREEN);
        }
        else if(sp.getInt("BackGroundColor", 0)==2)
        {
            rl.setBackgroundColor(Color.YELLOW);
        }


        if(sp.getInt("colorfont", 0)==0)

        {
            tvName.setTextColor(Color.RED);
        }

        else if (sp.getInt("colorfont",0)==1)
        {
            tvName.setTextColor(Color.BLUE);
        }





        if(sp.getInt("font", 0)==0)
        {
            tf=Typeface.createFromAsset(getAssets(), "fonts/Face Your Fears.ttf");

        }
        else if(sp.getInt("font", 0)==1)
        {
            tf=Typeface.createFromAsset(getAssets(), "fonts/CircleD_Font_by_CrazyForMusic.ttf");
        }
        tvName.setTypeface(tf);

    }
    public void goMansaf(View v)
    {
        Intent i=new Intent(this,SPMainActivity.class);
        startActivity(i);
    }
}
