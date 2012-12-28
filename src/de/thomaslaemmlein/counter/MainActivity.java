package de.thomaslaemmlein.counter;


import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	TextView m_CounterTextView;
	
	private int m_CurrentNumber;
	
	private int m_MaximalNumber = 99;
	
	public MainActivity()
	{
		m_CurrentNumber = 0;
		
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

	    m_CounterTextView = (TextView)findViewById(R.id.counterTextView);
	    
	    m_CounterTextView.setText( Integer.toString(m_CurrentNumber));
	}
	
	@Override
	 public boolean onTouchEvent(MotionEvent event) {
	  // TODO Auto-generated method stub
	    return gestureDetector.onTouchEvent(event);
	 }
	
	SimpleOnGestureListener simpleOnGestureListener
	   = new SimpleOnGestureListener(){


	  @Override
	  public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
	    float velocityY) {
	   String swipe = "";
	   float sensitvity = 50;
	   
	   // TODO Auto-generated method stub
	   if((e1.getX() - e2.getX()) > sensitvity){
	    swipe += "Swipe Left;";
	   }else if((e2.getX() - e1.getX()) > sensitvity){
	    swipe += "Swipe Right;";
	   }else{
	    swipe += ";";
	   }
	   
	   if((e1.getY() - e2.getY()) > sensitvity){
	    swipe += "Swipe Up;";
	    if (m_CurrentNumber < m_MaximalNumber)
	    {
		    m_CurrentNumber++;
		    m_CounterTextView.setText( Integer.toString(m_CurrentNumber));  	
	    }
	   }else if((e2.getY() - e1.getY()) > sensitvity){
		   if (m_CurrentNumber > 0)
		   {
			   m_CurrentNumber--;
			   m_CounterTextView.setText( Integer.toString(m_CurrentNumber));
		   }
	    swipe += "Swipe Down;";
	   }else{
	    swipe += ";";
	   }
	   
	   Log.d("onFling", swipe);
	   
	   return super.onFling(e1, e2, velocityX, velocityY);
	  }
	   };
	  
	   GestureDetector gestureDetector
	   = new GestureDetector(simpleOnGestureListener);
	  
}
