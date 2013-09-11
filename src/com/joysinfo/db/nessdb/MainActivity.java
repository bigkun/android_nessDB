package com.joysinfo.db.nessdb;

import org.nessdb.DB;
import org.nessdb.DBException;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		DB db = new DB("/sdcard/nessDB");
		try {
			db.open();
			byte[] key1 = "bigkun".getBytes("UTF-8");
			byte[] value1 = "11".getBytes("UTF-8");
			byte[] key2 = "I'm大坤".getBytes("UTF-8");
			byte[] value2 = "万里长城".getBytes("UTF-8");
			db.set(key1, key1.length, value1, value1.length);
			db.set(key2, key2.length, value2, value2.length);
			Log.d("KUN","info:"+db.info());
			
			db.close();
			DB ddd = new DB("/sdcard/nessDB");
			ddd.open();
			byte[] value22 = ddd.get(key2, key2.length);
			Log.d("KUN", "value:"+new String(value22, "UTF-8"));
			ddd.close();
			
		} catch (DBException e) {
			
		} catch (Exception e) {
			
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
