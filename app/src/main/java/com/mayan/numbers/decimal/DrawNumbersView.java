package com.mayan.numbers.decimal;

import java.util.Hashtable;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;

public class DrawNumbersView extends View {

	int[] numbers;
	private Hashtable<String, Bitmap> numberHash = new Hashtable<String,Bitmap>();
	
	public DrawNumbersView(Context context) {
		super(context);
		
		numberHash.put( String.valueOf(0) , BitmapFactory.decodeResource(getResources(), R.drawable.n0) );
		numberHash.put( String.valueOf(1) , BitmapFactory.decodeResource(getResources(), R.drawable.n1) );
		numberHash.put( String.valueOf(2) , BitmapFactory.decodeResource(getResources(), R.drawable.n2) );
		numberHash.put( String.valueOf(3) , BitmapFactory.decodeResource(getResources(), R.drawable.n3) );
		numberHash.put( String.valueOf(4) , BitmapFactory.decodeResource(getResources(), R.drawable.n4) );
		numberHash.put( String.valueOf(5) , BitmapFactory.decodeResource(getResources(), R.drawable.n5) );
		numberHash.put( String.valueOf(6) , BitmapFactory.decodeResource(getResources(), R.drawable.n6) );
		numberHash.put( String.valueOf(7) , BitmapFactory.decodeResource(getResources(), R.drawable.n7) );
		numberHash.put( String.valueOf(8) , BitmapFactory.decodeResource(getResources(), R.drawable.n8) );
		numberHash.put( String.valueOf(9) , BitmapFactory.decodeResource(getResources(), R.drawable.n9) );
		numberHash.put( String.valueOf(10) , BitmapFactory.decodeResource(getResources(), R.drawable.n10) );
		numberHash.put( String.valueOf(11) , BitmapFactory.decodeResource(getResources(), R.drawable.n11) );
		numberHash.put( String.valueOf(12) , BitmapFactory.decodeResource(getResources(), R.drawable.n12) );
		numberHash.put( String.valueOf(13) , BitmapFactory.decodeResource(getResources(), R.drawable.n13) );
		numberHash.put( String.valueOf(14) , BitmapFactory.decodeResource(getResources(), R.drawable.n14) );
		numberHash.put( String.valueOf(15) , BitmapFactory.decodeResource(getResources(), R.drawable.n15) );
		numberHash.put( String.valueOf(16) , BitmapFactory.decodeResource(getResources(), R.drawable.n16) );
		numberHash.put( String.valueOf(17) , BitmapFactory.decodeResource(getResources(), R.drawable.n17) );
		numberHash.put( String.valueOf(18) , BitmapFactory.decodeResource(getResources(), R.drawable.n18) );
		numberHash.put( String.valueOf(19) , BitmapFactory.decodeResource(getResources(), R.drawable.n19) );
		
	}
	
	public void draw(Canvas canvas) {
		super.draw(canvas);
		try {
            Bitmap backgroundImage = BitmapFactory.decodeResource( getResources() , R.drawable.fondo_chichen_2  );
            canvas.drawBitmap(backgroundImage, 0 , 0 , null );
            int count = 0;
            for (int i = 0; i < numbers.length; i++) {
                Bitmap image = numberHash.get( String.valueOf(numbers[i]) );
                canvas.drawBitmap( image , canvas.getWidth()/2 - image.getWidth()/2 , (count * image.getHeight() )+5 , null);
                count++;
            }
        }catch(Exception ex) {
            ex.printStackTrace();
            showErrorMessageInMain();
        }
	}

	public void setNumbersToDraw(int[] numbers) {
		this.numbers = numbers;
	}

    public void showErrorMessageInMain(){
        Bundle extras = new Bundle();
        extras.putInt( "errMsg" , R.string.error_when_converting_big_number );
        Intent intent = new Intent( (Activity)getContext() , MainActivity.class );
        intent.putExtras(extras);
        getContext().startActivity(intent);
    }



}
