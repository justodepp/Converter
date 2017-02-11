package application.converter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	//public variables
	public EditText text;
	
	//default function
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*findViewById(id) = Find a view  that was identified by the attribute
         * 					 from the XML that was processed in onCreate()*/
        
        //(EditText) = type a cast
        text = (EditText) findViewById(R.id.editText1);
    }

    // default function
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    /*
     * Will executed by clicking on the calculate button because we assigned
     * "calculate" to the "onClick" Proprety! 
     */
	public void onClick(View v){
    	
    	RadioButton mileButton = (RadioButton) findViewById(R.id.radio0);
    	RadioButton kmhButton = (RadioButton) findViewById(R.id.radio1);
    	
    	Toast toast = new Toast(this);
    	
    	switch(v.getId()){
    		case R.id.button1:
		    	//if the text field is empty show the message "enter a valid number"
		    	if(text.getText().length() == 0){
		    		//Toast = focused floating view that will be show over the main application
		    		Toast.makeText(this, "enter a valid number", Toast.LENGTH_LONG).show();
		    		return;
		    	}else {
		    		//parse input value from text field
		    		double inputValue = Double.parseDouble(text.getText().toString());
		    		//convert to...
		    		if(mileButton.isChecked()){
		    			toast = Toast.makeText(this, String.valueOf(convertToMile(inputValue)), Toast.LENGTH_SHORT);
		    			toast.show();
		    			toast.setGravity(Gravity.CENTER, 0, 0);
		    			//text.setText(String.valueOf(convertToMile(inputValue)));
		    			/*
		    			//uncheck "to miles" Button
		    			mileButton.setChecked(false);
		    			kmhButton.setChecked(true);
		    			*/
		    		}else if(kmhButton.isChecked()){
		    			toast = Toast.makeText(this, String.valueOf(convertToKhm(inputValue)), Toast.LENGTH_SHORT);
		    			toast.show();
		    			toast.setGravity(Gravity.CENTER, 0, 0);
		    			//text.setText(String.valueOf(convertToKhm(inputValue)));
		    			/*
		    			// uncheck "to km/h" Button  
		    			kmhButton.setChecked(false);  
		                // check "to miles" Button  
		                mileButton.setChecked(true);
		                */
		    		}	
		    	}
		    	break;
    	}
    }
   
    private double convertToMile(double inputValue){
    	//convert Kmh to Miles
    	return (inputValue * 1.609344);
    }
    
    private double convertToKhm(double inputValue){
    	//convert Mile to Kmh
    	return (inputValue * 0.621372);
    }
}
