package com.winbusiness.spoton;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EmployeeScreenActivity extends ActionBarActivity implements
		OnClickListener {

	Button clockIn;
	Button clockOut;
	TextView welcomeText;
	Intent thisIntent;
	Bundle bundle;
	String employeeCode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_employee_screen);

		createViewObjects();
		setWelcomeText();
	}

	private void setWelcomeText() {

		switch (employeeCode)
		{
		case "1234": welcomeText.setText("Welcome Jessica!"); break;
		case "420": welcomeText.setText("Welcome Johnny!"); break;
		case "9999": welcomeText.setText("Welcome Rambo!"); break;
		default: break;
		}
	}

	private void createViewObjects() {
		thisIntent = getIntent();
		bundle = thisIntent.getExtras();
		clockIn = (Button) findViewById(R.id.buttonClockIn);
		clockOut = (Button) findViewById(R.id.buttonClockOut);
		welcomeText = (TextView) findViewById(R.id.textView1);

		Button[] buttons = { clockIn, clockOut };

		for (Button b : buttons) {
			b.setOnClickListener(this);
			b.setTextColor(getResources().getColor(R.color.numberColor));
		}

		if (bundle != null) {
			employeeCode = bundle.getString("code");
			Toast.makeText(getApplicationContext(), "code is " + employeeCode, Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.employee_screen, menu);
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
	public void onClick(View view) {
		switch (view.getId()) {
		case (R.id.buttonClockIn):
			Toast.makeText(getApplicationContext(), "Clocked In",
					Toast.LENGTH_SHORT).show();
			break;
		case (R.id.buttonClockOut):
			Toast.makeText(getApplicationContext(), "Clocked Out",
					Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}

	}
}
