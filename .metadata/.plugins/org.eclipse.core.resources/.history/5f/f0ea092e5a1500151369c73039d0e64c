package com.winbusiness.spoton;

import java.util.ArrayList;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ManagerScreenActivity extends Activity
{
	ArrayList<String> employeeList;
	DBHandler handler;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manager_screen);
		
		instantiateVariables(); 
		populateEmployeeListView();
	}
	
	@SuppressWarnings("static-access")
	private void instantiateVariables() 
	{
		employeeList = new ArrayList<String>();
		handler = new DBHandler(this, null, null, 1);
		
		/*SQLiteDatabase db = handler.getWritableDatabase();
		String query = "SELECT * FROM " + handler.TABLE_EMPLOYEES + " WHERE 1";
		
		Cursor c = db.rawQuery(query, null);
		c.moveToFirst();
		
		while(!c.isAfterLast())
		{
			if(c.getString(c.getColumnIndex(handler.COLUMN_FIRST_NAME)) != null)
			{
				employeeList.add(c.getString(c.getColumnIndex(handler.COLUMN_FIRST_NAME)));
			}
			c.moveToNext();
		}
		db.close();
*/	
		handler.datatos(employeeList);
		employeeList.add("whatuo");
		employeeList.add("wasdasdhatuo");
		employeeList.add("whatuoasdad");
		
	}

	private void populateEmployeeListView()
	{
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.employee_items, employeeList);
		
		ListView listview = (ListView) findViewById(R.id.listView1);
		listview.setAdapter(adapter);
	}
}
