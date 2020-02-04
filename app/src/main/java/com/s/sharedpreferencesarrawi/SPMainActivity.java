package com.s.sharedpreferencesarrawi;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;


public class SPMainActivity extends Activity {

    String x[]={"Red","Green","white"};

    String fonts[]={"Face","Circle"};

    String color [] = {"احمر","ازرق"};

    int theSelectedBaackGroundColorposition;
    int theSelectedFontPosition;
    int theselectedcolorfont;



    ArrayAdapter<String> a,b,c;

    EditText etName;

    CheckBox cbMS;

    Spinner spBackGroundColor,spFont,colorfont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spmain);

        etName=(EditText) findViewById(R.id.editText1);
        cbMS=(CheckBox) findViewById(R.id.checkBox1);
        a=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,x);
        b=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,fonts);
        c=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,color);

        spBackGroundColor=(Spinner) findViewById(R.id.spinner1);
        spFont=(Spinner) findViewById(R.id.spinner2);
        colorfont=(Spinner) findViewById(R.id.spinner3);

        spBackGroundColor.setAdapter(a);
        spFont.setAdapter(b);
        colorfont.setAdapter(c);

        spBackGroundColor.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                theSelectedBaackGroundColorposition=position;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });


        spFont.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                theSelectedFontPosition=position;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });

        colorfont.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                theselectedcolorfont=position;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });



    }


    public void saveMansaf(View v)
    {
        SharedPreferences sp=PreferenceManager.getDefaultSharedPreferences(this);
        //SharedPreferences sp2=getSharedPreferences("MyPref", MODE_WORLD_WRITEABLE);
        SharedPreferences.Editor e=sp.edit();
        e.putString("name", etName.getText().toString());
        e.putBoolean("ms", cbMS.isChecked());
        e.putInt("BackGroundColor", theSelectedBaackGroundColorposition);
        e.putInt("font", theSelectedFontPosition);
        e.putInt("colorfont", theselectedcolorfont);
        e.commit();

    }


    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();

        SharedPreferences sp=PreferenceManager.getDefaultSharedPreferences(this);
        //SharedPreferences sp2=getSharedPreferences("MyPref", MODE_WORLD_WRITEABLE);

        etName.setText( sp.getString("name","No name found"));
        cbMS.setChecked( sp.getBoolean("ms", false));
        if(sp.getInt("BackGroundColor", 0)==0)
        {

            spBackGroundColor.setSelection(0);
        }
        else if(sp.getInt("BackGroundColor", 0)==1)
        {
            spBackGroundColor.setSelection(1);
        }


        if(sp.getInt("font", 0)==0)
        {

            spFont.setSelection(0);
        }
        else if(sp.getInt("font", 0)==1)
        {
            spFont.setSelection(1);
        }


        if(sp.getInt("colorfont", 0)==0)
        {
            colorfont.setSelection(0);
        }

        else if(sp.getInt("colorfont", 0)==1)
        {
            colorfont.setSelection(1);
        }

    }
}
