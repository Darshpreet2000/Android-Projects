package com.example.justjava;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**

 This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**This Method is called when + is clicked
     */
    int q=2;
    public void Incr(View view){
        if(q>100){
            Toast.makeText(getApplicationContext(),"Cannot order more than 99 coffees",Toast.LENGTH_SHORT).show();
            return;
        }
        q=q+1;
        display(q);
    }
    public void Decr(View view){
        if(q<=1){
            Toast.makeText(getApplicationContext(),"Cannot order lesser than 1 coffee",Toast.LENGTH_SHORT).show();
            display(q);
            return;
        }
        q=q-1;
        display(q);
    }

     /**This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText Nameis=findViewById(R.id.getname);
        Editable name=Nameis.getText();
       CheckBox choco=findViewById(R.id.chocolate);
       boolean ischoco=choco.isChecked();
        CheckBox whippedcream=(CheckBox)findViewById(R.id.whipped_cream);
        boolean haswhippedcream=whippedcream.isChecked();
        int price=q*5;
        if(whippedcream.isChecked()){
            price+=q*1;
        }
        if(choco.isChecked()){
            price+=q*2;
        }
        Log.v("Main Activity","Has Whipped Cream. " + haswhippedcream);
      createOrderSummary(price,q,haswhippedcream,ischoco,name);
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(message);
    }
    /**

     This method displays the given quantity value on the screen.
     */

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */
    /*This Method creates the order summary
    */
    public void createOrderSummary(int price,int number,boolean haswhippedcream,boolean ischoco,Editable name){
        String message="Name: "+name+"\nAdd whipped cream?"+haswhippedcream + "\nAdd Chocolate?" + ischoco + "\nQuantity: " + number + "\nTotal:Rs "+ price+ "\nThankyou!";
        displayMessage(message);
     composeEmail(message,"Order of coffees,");
    }
    public void composeEmail(String addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_TEXT, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}