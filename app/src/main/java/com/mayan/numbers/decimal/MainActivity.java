package com.mayan.numbers.decimal;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mayan.numbers.decimal.calculator.DecimalToMayan;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 */
public class MainActivity extends Activity {
	
	private Button convertButton;
	private EditText convertText;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		convertButton = (Button)findViewById(R.id.convertButton);
		convertText = (EditText)findViewById( R.id.convertText );
		convertButton.setOnClickListener( new View.OnClickListener() {
			public void onClick(View v) {
				convertButtonClicked(v);
			}
		});

		Bundle bundle = this.getIntent().getExtras();
		if(bundle != null && bundle.containsKey("errMsg")){
			int errMsg = bundle.getInt("errMsg");
			String errorMessage = getString(errMsg);
			this.showErrorAlert(errorMessage);
		}


	}

	protected void convertButtonClicked(View v) {
		try {
			String numberText = convertText.getText().toString();
			if( numberText.length() > 0 ){
				int decimalNumber = Integer.parseInt(numberText);
				if( decimalNumber > 0 ){
					DecimalToMayan decimalToMayan = new DecimalToMayan();
					List<Integer> numbers = decimalToMayan.getNumerics(decimalNumber);
					Intent intent = new Intent( this , DrawNumbersActivity.class );
					Bundle extras = new Bundle();
					int size = numbers.size();
					int[] dec = new int[size];
					for (int i = 0; i < size; i++) {
						dec[i] = numbers.get(i);
					}
					extras.putIntArray("numbers", dec);
					intent.putExtras(extras);
					startActivity(intent);					
				}else if( decimalNumber == 0 ){
                    List<Integer> numbers = new ArrayList<>();
                    numbers.add(0);
                    Intent intent = new Intent( this , DrawNumbersActivity.class );
                    Bundle extras = new Bundle();
                    int size = numbers.size();
                    int[] dec = new int[size];
                    for (int i = 0; i < size; i++) {
                        dec[i] = numbers.get(i);
                    }
                    extras.putIntArray("numbers", dec);
                    intent.putExtras(extras);
                    startActivity(intent);
                }
			}else{
				String message = getString(R.string.empty_text_convert);
				this.showErrorAlert(message);
			}
		} catch (Exception e) {
			String errorMessage = getString(R.string.error_when_converting_big_number);
			this.showErrorAlert(errorMessage);
			e.printStackTrace();
		}
	}
	
	
	private void showErrorAlert(String message){
		new AlertDialog.Builder( this )
				.setPositiveButton(getString(R.string.ok_message),null)
				.setMessage(message)
				.show();
	}


}
