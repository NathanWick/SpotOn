package com.winbusiness.spoton;

import java.util.ArrayList;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ManagerScreenActivity extends Activity
{
	ArrayList<Employee> employeeList;
	ArrayList<String> employeeTitle;
	DBHandler handler;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manager_screen);

		instantiateVariables(); 
		populateEmployeeListView();
	}
	
	private void instantiateVariables() 
	{
		employeeList = new ArrayList<Employee>();
		employeeTitle = new ArrayList<String>();
		handler = new DBHandler(this, null, null, 1);
		
		handler.populateEmployeeArray(employeeList);
		
		
	}

	private void populateEmployeeListView()
	{
		for(Employee emp :  employeeList)
		{
			employeeTitle.add(emp.getFirstName() + " " + emp.getLastName());
		}
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.employee_items, employeeTitle);
		
		ListView listview = (ListView) findViewById(R.id.listView1);
		listview.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.manager_activity_action, menu);
		return true;	
	}
	

}
