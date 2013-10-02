package com.example.bookfood.menu;

import java.util.ArrayList;
import java.util.List;

import com.example.bookfood.MainActivity;
import com.example.bookfood.R;
import com.example.bookfood.database.dataBaseHelper;
import com.example.bookfood.dialog.detailMenuDialog;
import com.example.bookfood.metadata.bookfoodDatabaseMetadata;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class getfoodMenuActivity extends Activity implements SensorEventListener {

	//private dataBaseHelper dbHelper = null;
	//private SQLiteDatabase db = null;
	//private Cursor myCursor = null;
	//private SimpleCursorAdapter adapter = null;
	private ListView lv;
	//private Button roll_btn;
	private SensorManager sensor_man;
	private Sensor sensor;
	private float gravity[] = new float[3]; 
	private List<String> data = new ArrayList<String>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.getfood_layout);
		lv = (ListView) findViewById(R.id.getfood_listview);
		sensor_man = (SensorManager) this.getSystemService(SENSOR_SERVICE);
		sensor = sensor_man.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,getData()));
		//setContentView(R.layout.getfood_layout);
		//setContentView(lv);
	}
	
	private List<String> getData(){
        
       
       int rand=(int)(Math.random()*10);
       data.add("你的数字是："+rand);
        
       return data;
   }
	
	@Override
	protected void onResume(){
		super.onResume();
		sensor_man.registerListener(this, sensor, sensor_man.SENSOR_DELAY_NORMAL);
	}
	
	@Override
	protected void onPause(){
		super.onPause();
		sensor_man.unregisterListener(this);
	}
	
	public void onSensorChanged(SensorEvent event){
		int sensorType = event.sensor.getType();
		float[] values = event.values;  
		if(sensorType == Sensor.TYPE_ACCELEROMETER){ 
		   if((Math.abs(values[0])>14||Math.abs(values[1])>14||Math.abs(values[2])>14)){  
			   lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,getData()));
		   }
		}
	}

	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
}