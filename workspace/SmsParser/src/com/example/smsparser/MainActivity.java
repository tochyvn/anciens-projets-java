package com.example.smsparser;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
//	private static final String LOG_TAG = "SMSReceiver";
    public static final int NOTIFICATION_ID_RECEIVED = 0x1221;
    static final String ACTION = "android.provider.Telephony.SMS_RECEIVED";
    private String secretNumber;
    String retrievingUSSD;
	SmsMessage[] msgs = null;
	String senderNumber = null;
	String message = null;
	Context context = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		IntentFilter filter = new IntentFilter(ACTION);
		BroadcastReceiver smsParser = new BroadcastReceiver() {
	        @Override
	        public void onReceive(Context context, Intent intent) { 
	        	Bundle bundle =intent.getExtras();
	        	String action = intent.getAction();

	            if (ACTION.equals(action)&&(bundle != null)) {

	            	
	            		Object[] pdus = (Object[])bundle.get("pdus");
	            		msgs = new SmsMessage[pdus.length]; 
	            		Log.d("SmsParser", "message1");
	            		for(int i=0; i<pdus.length; i++){
	            			msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);  
	            			senderNumber = msgs[i].getOriginatingAddress();
//	    					Log.d("SmsParser", "message2");
	            			message = msgs[i].getMessageBody().toString();
	            			retrievingUSSD= retrieveUSSD(message);
	            			if(retrievingUSSD != null){
	            				Toast.makeText(context, retrievingUSSD +" "+ 1, Toast.LENGTH_LONG).show();
	            				displayAlert();
	            				Toast.makeText(context, retrievingUSSD +" "+ 2, Toast.LENGTH_LONG).show();
	            			}		
	            		
	            	}
	    		}
	        }
	    };    
        this.registerReceiver(smsParser, filter);
        if(retrievingUSSD != null){
        	Log.d("MainActivity", retrievingUSSD);
        }
      
//        displayAlert();
	}

	private void displayAlert()
    {
		LayoutInflater li = LayoutInflater.from(this);
		View promptsView = li.inflate(R.layout.prompts, null);
		Intent intent = new Intent(context, MainActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // You need this if starting
		                                                //  the activity from a service
		intent.setAction(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(intent);

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				this);

		// set prompts.xml to alertdialog builder
		alertDialogBuilder.setView(promptsView);

		final EditText userInput = (EditText) promptsView
				.findViewById(R.id.editTextDialogUserInput);

		// set dialog message
		alertDialogBuilder
			.setCancelable(false)
			.setPositiveButton("OK",
			  new DialogInterface.OnClickListener() {
			    public void onClick(DialogInterface dialog,int id) {
			    	secretNumber = userInput.getText().toString();
			    	 try{
			             call();
			            }catch(Exception e){
			                e.printStackTrace();
			            }
			    
			    Log.d("popuwindow", secretNumber);
			    }
			  })
			.setNegativeButton("Cancel",
			  new DialogInterface.OnClickListener() {
			    public void onClick(DialogInterface dialog,int id) {
				dialog.cancel();
			    }
			  });

		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();

		// show it
		Toast.makeText(MainActivity.this, "test popup 1", Toast.LENGTH_LONG).show();
		alertDialog.show();
		Toast.makeText(MainActivity.this, "test popup 2", Toast.LENGTH_LONG).show();
    }

	
	private void call() {
        try {
             
            String encodedHash = Uri.encode("#");
            String encodedStar = Uri.encode("*");
            Log.d("MainActivity", retrievingUSSD+secretNumber);
            String ussd = encodedStar + retrievingUSSD+secretNumber + encodedHash;
            startActivityForResult(new Intent("android.intent.action.CALL",
            Uri.parse("tel:" + ussd)), 1);
             
        } catch (ActivityNotFoundException activityException) {
             Log.e("helloandroid dialing example", "Call failed",activityException);
        }
	}
	
	
	public String retrieveUSSD (String message){
		int beginIndex1 =0;
		int beginIndex2 =0;
		int endIndex;
		String ussd = null;
		if (message.contains("*")||message.contains("#")){
			beginIndex1 = message.indexOf("*",0);
			beginIndex2 = message.indexOf("#",0);
		}
		endIndex = message.lastIndexOf("#");
		ussd = message.substring(Math.min(beginIndex1, beginIndex2), endIndex);
		Log.d("SmsParser", ussd);
		return ussd;
	}
	
	public boolean containUSSD (String message){
		
		if(retrieveUSSD(message)==null){
			return false;
		}
		return true;	
	}
	
	@Override
	protected void onStop(){
	    super.onStop();
	    Intent intent = new Intent(this, MainActivity.class);
	    startActivity(intent);
	}
	
}
