package de.thomaslaemmlein.counter;


import android.os.Bundle;
import android.app.Activity;
import android.util.Log;

public class MainActivity extends Activity {
	
	public MainActivity()
	{		
		Log.d("MainActivity", "Constructor");
	}
	
	protected void onDestroy() 
	{
		Log.d("MainActivity", "onDestroy");
		super.onDestroy();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d("MainActivity", "onCreate");
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
}
