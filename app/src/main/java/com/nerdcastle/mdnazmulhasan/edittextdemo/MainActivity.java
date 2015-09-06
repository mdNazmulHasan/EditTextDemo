package com.nerdcastle.mdnazmulhasan.edittextdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.graphics.Color.*;

public class MainActivity extends Activity {
    int i = 0;
    List<EditText> allEds = new ArrayList<EditText>();
    List<String> allEdsData = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_dynamic_views);
        ScrollView scrl = new ScrollView(this);
        final LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        scrl.addView(ll);
        Button add_btn = new Button(this);
        add_btn.setText("Click to add TextViews and EditTexts");
        ll.addView(add_btn);
        for(int i=0;i<3;i++){
            TextView tv = new TextView(getApplicationContext());
            tv.setText("Number" + i);
            tv.setTextColor(BLACK);
            ll.addView(tv);
            EditText et = new EditText(getApplicationContext());
            et.setTextColor(BLACK);
            allEds.add(et);
            et.setId(i);
            et.setBackgroundResource(R.drawable.rounded_edittext);
            ll.addView(et);
        }
        add_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String[] strings = new String[allEds.size()];

                for(int i=0; i < allEds.size(); i++){
                    strings[i] = allEds.get(i).getText().toString();
                    allEdsData.add(strings[i]);
                }
                Toast.makeText(getApplicationContext(),allEdsData.toString(),Toast.LENGTH_LONG).show();

            }
        });
        this.setContentView(scrl);
    }

}