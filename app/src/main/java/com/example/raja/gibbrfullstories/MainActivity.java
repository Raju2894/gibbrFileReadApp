package com.example.raja.gibbrfullstories;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.buttn);
        //findAllViewsId();

        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View arg0)
            {
                //TextView txtContent=(TextView)findViewById(R.id.tv1);
                AssetManager assetManager=getAssets();
                ArrayList<String> arrayList = new ArrayList<String>();

                InputStream input;

                String data = "";
                StringBuffer sbuffer = new StringBuffer();
                try {
                    input = assetManager.open("text.txt");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    if (input != null) {
                        try {
                            while ((data = reader.readLine()) != null) {

                                //String[] words = data.split(" ");
                                arrayList.add(data);
                                sbuffer.append(data + "\n");
                                //txtContent.setText(sbuffer.toString());
                            }
                            input.close();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    String s = sbuffer.toString();
                    String[] yo = s.split(" ");
                    StringBuffer swords = new StringBuffer();
                    int r =0;
                    for (int i = 0; i < yo.length; i++) {
                        String temp = yo[i];
                        Log.d("pooh",temp);
                        int flag = 0;
                        char[] chars = temp.toCharArray();
                        for (int j = 0; j <chars.length ; j++) {
                            if(chars[0] == '<' && chars[chars.length-1]=='>'){
                                flag = 1;
                            }
                        }
                        if(flag  == 1){
                            swords.append(temp);
                            r = r+1;
                            //Log.d("pooh",temp);
                        }
                    }
                    String fill = swords.toString();
                    //String[] fillw = fill.split(" ");
                    //txtContent.setText(swords.toString());

                    String uname  = fill;
                    if(!uname.equals("") )
                    {
                        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                        intent.putExtra("username",uname);
                        intent.putExtra("user",sbuffer.toString());
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,sbuffer, Toast.LENGTH_LONG).show();
                    }
                    Toast.makeText(getBaseContext(), swords.toString(), Toast.LENGTH_LONG)
                            .show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
    private void findAllViewsId() {
       // TextView txtContent=(TextView)findViewById(R.id.tv1);
        AssetManager assetManager=getAssets();
        ArrayList<String> arrayList = new ArrayList<String>();

        InputStream input;

        String data = "";
        StringBuffer sbuffer = new StringBuffer();
        try {
            input = assetManager.open("text.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            if (input != null) {
                try {
                    while ((data = reader.readLine()) != null) {

                        //String[] words = data.split(" ");
                        arrayList.add(data);
                        sbuffer.append(data + "\n");
                        //txtContent.setText(sbuffer.toString());
                    }
                    input.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            String s = sbuffer.toString();
            String[] yo = s.split(" ");
            StringBuffer swords = new StringBuffer();

            for (int i = 0; i < yo.length; i++) {
                String temp = yo[i];
                Log.d("pooh",temp);
                int flag = 0;
                char[] chars = temp.toCharArray();
                for (int j = 0; j <chars.length ; j++) {
                    if(chars[0] == '<' && chars[chars.length-1]=='>'){
                        flag = 1;
                    }
                }
                if(flag  == 1){
                    swords.append(temp);
                    //Log.d("pooh",temp);
                }
            }
            String fill = swords.toString();
            String[] fillw = fill.split(" ");
            //txtContent.setText(swords.toString());


            Toast.makeText(getBaseContext(), swords.toString(), Toast.LENGTH_LONG)
                    .show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
