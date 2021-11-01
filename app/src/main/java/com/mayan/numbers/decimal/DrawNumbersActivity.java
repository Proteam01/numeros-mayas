package com.mayan.numbers.decimal;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ScrollView;
import androidx.appcompat.app.AppCompatActivity;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 */
public class DrawNumbersActivity extends AppCompatActivity {
	
	DrawNumbersView numbersView;
	
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		String appName = this.getString( R.string.app_name );
        this.getWindow().setTitle(appName);
		try {
			Bundle bundle = this.getIntent().getExtras();
			int[] numbers = (int[])bundle.get("numbers");
			ScrollView scrollViewNumbers = (ScrollView) this.findViewById(R.id.scrollViewNumbers);
			numbersView = new DrawNumbersView(this);
			numbersView.setNumbersToDraw(numbers);
			setContentView( numbersView );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.draw_numbers_menu,menu);
		return super.onCreateOptionsMenu(menu);
	}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.back_menu:
                returnToMain();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void returnToMain(){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        this.getApplicationContext().startActivity(intent);
    }


}
