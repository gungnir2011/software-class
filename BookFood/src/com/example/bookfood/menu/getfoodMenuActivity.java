package com.example.bookfood.menu;

import java.util.ArrayList;
import java.util.List;

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
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class getfoodMenuActivity extends Activity {

	//private dataBaseHelper dbHelper = null;
	//private SQLiteDatabase db = null;
	//private Cursor myCursor = null;
	//private SimpleCursorAdapter adapter = null;
	private ListView lv;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		lv = new ListView(this);
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,getData()));
		setContentView(lv);
	}
	
	private List<String> getData(){
        
       List<String> data = new ArrayList<String>();
       int rand=(int)(Math.random()*10);
       data.add("你的数字是："+rand);
       data.add("测试数据2");
       data.add("测试数据3");
       data.add("测试数据4");
        
       return data;
   }
}