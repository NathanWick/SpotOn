package com.winbusiness.spoton;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

	DBHandler handler;
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	Button button5;
	Button button6;
	Button button7;
	Button button8;
	Button button9;
	Button button0;
	Button buttonBackspace;
	Button buttonEnter;
	EditText editText1;
	ArrayList<String> employeeCodes; 
	ArrayList<Employee> employees; 
	String test;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        createViewObjects();
    	Toast.makeText(getApplicationContext(), test, Toast.LENGTH_SHORT).show();
    }
    
    private void createViewObjects()
    {
    	handler = new DBHandler(this, null, null, 1);
    	handler.addEmployee(new Employee("david", "scully", 4285));
    	handler.addEmployee(new Employee("dirkensen", "jobs", 9887));
    	
    	employeeCodes = new ArrayList<String>();
    	employees = new ArrayList<Employee>();
    	handler.populateEmployeeArray(employees);
    	
    	addCodes(employeeCodes);
    	button1 = (Button) findViewById(R.id.button1);
    	button2 = (Button) findViewById(R.id.button2);
    	button3 = (Button) findViewById(R.id.button3);
    	button4 = (Button) findViewById(R.id.button4);
    	button5 = (Button) findViewById(R.id.button5);
    	button6 = (Button) findViewById(R.id.button6);
    	button7 = (Button) findViewById(R.id.button7);
    	button8 = (Button) findViewById(R.id.button8);
    	button9 = (Button) findViewById(R.id.button9);
    	button0 = (Button) findViewById(R.id.button0);
    	buttonBackspace = (Button) findViewById(R.id.buttonBack);
    	buttonEnter = (Button) findViewById(R.id.buttonEnter);
    	editText1 = (EditText) findViewById(R.id.editText1);
    	
    	Button[] buttons = {button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, buttonEnter, buttonBackspace};
    	
    	for(Button b : buttons)
    	{
    		b.setOnClickListener(this);
    		b.setTextColor(getResources().getColor(R.color.numberColor));
    	}
    }
   
    private void addCodes(ArrayList<String> ec)
    {
    	ec.add("1234");
    	ec.add("420");
    	ec.add("9999");
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

	@Override
	public void onClick(View view) 
	{
		switch (view.getId()) {
		case (R.id.button1): editText1.append("1"); break;
		case (R.id.button2): editText1.append("2"); break;
		case (R.id.button3): editText1.append("3"); break;
		case (R.id.button4): editText1.append("4"); break;
		case (R.id.button5): editText1.append("5"); break;
		case (R.id.button6): editText1.append("6"); break;
		case (R.id.button7): editText1.append("7"); break;
		case (R.id.button8): editText1.append("8"); break;
		case (R.id.button9): editText1.append("9"); break;
		case (R.id.button0): editText1.append("0"); break;
		case (R.id.buttonEnter): 
		Boolean correct = false;
		if(editText1.getText().toString().equals("1"))
		{
			startActivity(new Intent(MainActivity.this, ManagerScreenActivity.class));	
			return;
		}
		/*for(String codes : employeeCodes)
		{			
			if(editText1.getText().toString().equals(codes))
			{
				correct = true;
			}
		}
		if(correct)
		{
			Intent i = new Intent(MainActivity.this, EmployeeScreenActivity.class);
			i.putExtra("code", editText1.getText().toString());
			editText1.setText("");
			startActivity(i);
			break;
		}
		else editText1.setText(""); break;*/
		int empid = 0;
/*		for(Employee emp : employees)
		{			
			if(editText1.getText().toString().equals(String.valueOf(emp.getAccessCode())))
			{*/
				String query = "SELECT * FROM " + DBHandler.TABLE_EMPLOYEES + " WHERE accesscode = " + editText1.getText().toString();
				SQLiteDatabase db = handler.getWritableDatabase();
				Cursor c = db.rawQuery(query, null);
				c.moveToFirst();
				empid = c.getInt(c.getColumnIndex("id"));
				if(c.getCount() > 0)
				{					
					correct = true;
				}
	/*		}
		}*/
		if(correct)
		{
			Intent i = new Intent(MainActivity.this, EmployeeScreenActivity.class);
			i.putExtra("employeeId", String.valueOf(empid));
			editText1.setText("");
			startActivity(i);
			break;
		}
		else editText1.setText(""); break;
		
		case (R.id.buttonBack): 
		int length = editText1.getText().length();
		if (length > 0)
		{
		    editText1.getText().delete(length - 1, length);
		}
		break;
		default:
			break;
		}
		
	}
}
