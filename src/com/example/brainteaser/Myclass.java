package com.example.brainteaser;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
//import com.example.Find.R;

public class Myclass extends Activity {
String s;
TextView test;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shal);
		test = (TextView) findViewById(R.id.textView1);
	
		Intent data = getIntent();
		Bundle baskt = data.getExtras();
		s = baskt.getString("ans");//("ans");
		test.setText(""+s);
		Thread timer = new Thread(){
			public void run(){
			
				try{
					sleep(1000);
				}
				catch(InterruptedException e){
					e.printStackTrace();
					
					
				}finally{
					Intent openStartingPoint=new Intent(Myclass.this, Find_The_Pairs.class);
					startActivity(openStartingPoint);
					
				}
			}
		};
		timer.start();
		//Intent a = new Intent(MainActivity.this, OpenedClass.class);
		// android:theme="@android:style/Theme.Dialog";
		//Dialog mDialog = new Dialog(getBaseContext(), android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
		
		//finish();
		
	}
	
	
}

