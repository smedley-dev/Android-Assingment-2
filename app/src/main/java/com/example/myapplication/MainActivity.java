package com.example.myapplication;


import java.lang.*;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "No touching. I dont do anything", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //Array to keep track of the list
    public static String[] fruitList = new String[5];
    static String wholeList = " ";
    int i = 0;


    /**
     * Method to save a string to the array fruitList
     * @param s string to be saved to the fruitList
     */
    public void getFruit(String s){
        fruitList[i] = s;
        i++;
    }


    /**
     * Method which will make visible a button to get to the second Activity
     */
    public void showListButton(){
        TextView button = (TextView) findViewById(R.id.showList);
        button.setVisibility(View.VISIBLE);

    }

    /**
     * Method to make view invisible when clicked
     * @param view
     */
    public void fruitClick(View view) {
        view.setVisibility(view.INVISIBLE);

        //Save the name of the fruit that was clicked to the fruit list
        getFruit(view.getTag().toString());

        //If all fruits have been clicked, display show list button
       if(i == 5){
           //Loop to concatenate all elements of fruitList into one string
           for (int j = 0; j < fruitList.length; j++){
               wholeList = wholeList.concat(fruitList[j] + "\n");
           }

           //Method call to make the show list button visible
            showListButton();
        }
    }


   public void btnNewActivity_click(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("fruitList", wholeList);
        startActivity(intent);
    }

    /**
     * Method to print all elements of fruitList array when button is clicked
     * @param view print list button
     */
    public void printList(View view) {
        //Loop to go through all elements of fruitList array
        for(i = 0; i < fruitList.length; i++){
            System.out.println(fruitList[i]);
        }
    }
}


