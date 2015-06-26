package com.winbusiness.spoton;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class Employee_editor extends Activity {

	Intent intent;
	boolean newEmp;
	TextView tv;
	EditText et;
	ViewSwitcher switcher;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_employee_editor);

		instantiateVariables();
		setOnClickListeners();
	}

	private void instantiateVariables() {
		tv = (TextView) findViewById(R.id.textView2);
		newEmp = false;
		intent = getIntent();
		newEmp = intent.getBooleanExtra("newEmp", false);
		et = (EditText) findViewById(R.id.hidden_edit_view);
		switcher = (ViewSwitcher) findViewById(R.id.viewSwitcher1);
	}

	private void setOnClickListeners() {
		tv.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				switcher.showNext(); // or switcher.showPrevious();
				et.setText(tv.getText());
				// myTV.setText("value");

			}
		});

		et.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(!v.hasFocus()){
					if(!newEmp){
						switcher.showNext();
					}
					else{
						
					}
				}
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.employee_editor, menu);
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
}