package com.mayan.numbers.decimal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class DrawNumbersActivity extends AppCompatActivity {
	
	DrawNumbersView numbersView;
	
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		//this.setContentView( R.layout.activity_draw_numbers );
		String appName = this.getString( R.string.app_name );
        this.getWindow().setTitle(appName);
		try {
			Bundle bundle = this.getIntent().getExtras();
			int[] numbers = (int[])bundle.get("numbers");
			numbersView = new DrawNumbersView(this);
			numbersView.setNumbersToDraw(numbers);
			setContentView( numbersView );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	
}
