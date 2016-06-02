package com.example.raja.gibbrfullstories;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class Main2Activity extends AppCompatActivity {

    public static ArrayList<String> playerList = new ArrayList<String>();
    public static ArrayList<String> playerList1 = new ArrayList<String>();
    String playerlist[];
    private EditText et;
    private TextView cout;
    int r;
    int k=0;
    String story;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //Bundle b = getIntent().getExtras();
        cout = (TextView)findViewById(R.id.count);
        et = (EditText) findViewById(R.id.my_edit_text);
        //et.setText("Welcome ,"+getIntent().getExtras().getString("username"));
        String s = getIntent().getExtras().getString("username");
        story = getIntent().getExtras().getString("user");
        String[] er = s.split(">");
        r = er.length-1;
        cout.setText("Fill Blank Options:");
        Button more = (Button) findViewById(R.id.button1);
        more.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view){
                cout.setText("NO of Blank Options:"+r);
                if(r==0){
                    View b = findViewById(R.id.button1);
                    b.setVisibility(View.GONE);
                    et.setVisibility(view.GONE);
                }
                String ag=et.getText().toString().trim();
                if(ag.length() != 0){
                    playerList.add(ag);
                    et.setText(""); // adds text to arraylist and make edittext blank again
                    r--;
                }
            }
        });
        Button done = (Button) findViewById(R.id.done_button);
        done.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view){

                String h="";
                String[] e = story.split(" ");
                for(int i=0;i<e.length;i++){
                    String temp = e[i];
                    int flag=0;
                    char[] chars = temp.toCharArray();
                    for (int j = 0; j <chars.length ; j++) {
                        if(chars[0] == '<' && chars[chars.length-1]=='>'){
                            flag=1;
                        }
                    }
                    if(flag==1){
                        playerList1.add(playerList.get(k));
                        k++;
                    }
                    else{
                        playerList1.add(temp);
                    }

                }
                Toast.makeText(getBaseContext(),playerList1
                        .toString(), Toast.LENGTH_LONG)
                        .show();
                Log.d("dadssd",playerList1.toString());
                // start new activity
                /*Intent myIntent = new Intent(view.getContext(),
                        MainActivity.class);
                myIntent.putExtra("Stringarray",playerList);
                startActivity(myIntent);
                finish();*/

            }
        });
        Log.d("ad",r+"da");
        Toast.makeText(getBaseContext(),story, Toast.LENGTH_LONG)
                .show();


        //et.setText(b.getCharSequence("name"));
        // String theText = et.getText().toString();
        //Intent i = new Intent(this, MainActivity.class);
        //i.putExtra("text_label", theText);
        //startActivity(i);
    }

}
