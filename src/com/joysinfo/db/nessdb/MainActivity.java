package com.joysinfo.db.nessdb;

import org.nessdb.DB;
import org.nessdb.DBException;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

import java.io.*;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		DB db = new DB("/sdcard/nessDB");
		try {
//			db.open();
//			byte[] key1 = "bigkun".getBytes("UTF-8");
//			byte[] value1 = "11".getBytes("UTF-8");
//			byte[] key2 = "I'm大坤".getBytes("UTF-8");
//			byte[] value2 = "万里长城".getBytes("UTF-8");
//			db.set(key1, key1.length, value1, value1.length);
//			db.set(key2, key2.length, value2, value2.length);
//			Log.d("KUN","info:"+db.info());
//
//			db.close();
//			DB ddd = new DB("/sdcard/nessDB");
//			ddd.open();
//			byte[] value22 = ddd.get(key2, key2.length);
//			Log.d("KUN", "value:"+new String(value22, "UTF-8"));
//			ddd.close();
            StudyClass studyClass = new StudyClass();
            studyClass.Chinese = "中文";
            studyClass.English = "english";
            studyClass.math = 100;
            NessBean1 nessBean1 = new NessBean1();
            nessBean1.label = "ss哈哈 撒旦";
            nessBean1.name = "张宏坤";
            nessBean1.studyClass = studyClass;

            db.open();
            byte [] keyObject = "study1".getBytes();
            byte [] valueObject = serialize(nessBean1);
            long time1 = System.currentTimeMillis();
            db.set(keyObject, keyObject.length, valueObject, valueObject.length);
            long time2 = System.currentTimeMillis();
            byte[] getValue = db.get(keyObject, keyObject.length);
            long time3 = System.currentTimeMillis();

            NessBean1 nessBean11 = (NessBean1)deserialize(getValue);
            long time4 = System.currentTimeMillis();
            Log.d("NESS", "set:"+(time2-time1));
            Log.d("NESS", "get:"+(time3-time2));
            Log.d("NESS", "des:"+(time4-time3));
            Log.d("NESS", "name:"+nessBean11.name+" label:"+nessBean11.label);
            Log.d("NESS", "chinse:"+nessBean11.studyClass.Chinese+" En:"+nessBean11.studyClass.English
            +" math:"+nessBean11.studyClass.math);
            db.close();
			
		} catch (DBException e) {
            e.printStackTrace();
		} catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

    public static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(out);
        os.writeObject(obj);
        return out.toByteArray();
    }
    public static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ObjectInputStream is = new ObjectInputStream(in);
        return is.readObject();
    }

}
