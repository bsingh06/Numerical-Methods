package com.example.android.numericalmethods;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class simpson extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simpson);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageResource(R.drawable.ic_action_name2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(simpson.this,help.class);
                startActivity(i);
            }
        });
    }

    float function(float x){
        EditText pa = (EditText)findViewById(R.id.psr1);
        EditText pb = (EditText)findViewById(R.id.psr2);
        EditText pc = (EditText)findViewById(R.id.psr3);
        float p1=0,p2=0,p3=0;
        p1 = Float.parseFloat(pa.getText().toString());
        p2 = Float.parseFloat(pb.getText().toString());
        p3 = Float.parseFloat(pc.getText().toString());
        float poly = (p1 * x * x) + (p2 * x) + p3;
        return poly;
    }
    public void calculatesimpson(View v){
        float a = 0,b = 0,h = 0,s = 0;
        int i,j,n;
        EditText aa = (EditText)findViewById(R.id.simpedit1);
        EditText bb = (EditText)findViewById(R.id.simpedit2);
        EditText nn = (EditText)findViewById(R.id.simpedit3);
        a = Float.parseFloat(aa.getText().toString());
        b = Float.parseFloat(bb.getText().toString());
        n = Integer.parseInt(nn.getText().toString());
        TextView output = (TextView)findViewById(R.id.printoutput4);

        h = (b - a)/n;
        s = function(a) + function(b);
        for(i = 1;i<=n-1;i++)
        {
            s += 2*function(a+i*h);
        }
        output.setText("Solution is \n ∫ f(x) dx = " + (h/2)*s);


    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        if(id == android.R.id.home) {
            this.finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
