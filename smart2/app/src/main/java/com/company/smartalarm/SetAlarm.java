package com.company.smartalarm;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

public class SetAlarm extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_set_alarm);

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.set_alarm, menu);
		return true;
	}
	
	public void btnAddAlarm_Click(View view) {
		Intent i = new Intent(this, SetSilentAlarm.class);
		i.putExtra("location", ((EditText)findViewById(R.id.txtLocation)).getText().toString());
		TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
		String time = timePicker.getCurrentHour().toString() + ":" + timePicker.getCurrentMinute().toString();
		i.putExtra("time", time);	
		startService(i);
	}
	
	public void btnPreferences_Click(View view) {
		Intent i = new Intent(this, Preferences.class);
		startActivity(i);
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event)
	  {
	   
	   if(keyCode == KeyEvent.KEYCODE_BACK)
	   {
	    AlertDialog.Builder alertDlg = new AlertDialog.Builder(this);
	      
	    alertDlg.setMessage("종료하시겠습니까?");
	    alertDlg.setPositiveButton("Yes", new DialogInterface.OnClickListener() { //확인 버튼
	     public void onClick(DialogInterface dialog, int whichButton) {
	      
	    	 System.exit(0); 
	     
	     }
	      }) ;        
	      alertDlg.setNegativeButton("No", new DialogInterface.OnClickListener() { // 취소 버튼
	       public void onClick(DialogInterface dialog, int whichButton) {         
	       
	        dialog.cancel();   
	       }
	      });
	      AlertDialog alert = alertDlg.create();
	      alert.setTitle("종료대화창"); 
	      alert.show();
	   }
	   return false;
	  }
}
