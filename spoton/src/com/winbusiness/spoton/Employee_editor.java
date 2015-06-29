package com.winbusiness.spoton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class Employee_editor extends Activity implements android.view.View.OnFocusChangeListener, android.view.View.OnClickListener{

	Intent intent;
	boolean newEmp;
	TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7;
	EditText et1, et2, et3, et4, et5, et6, et7;
	ViewSwitcher switcher1, switcher2, switcher3, switcher4, switcher5, switcher6, switcher7;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_employee_editor);

		instantiateVariables();
		setOnClickListeners();
	}

	private void instantiateVariables() {
		newEmp = false;
		intent = getIntent();
		newEmp = intent.getBooleanExtra("newEmp", false);

		tv1 = (TextView) findViewById(R.id.textView2);
		et1 = (EditText) findViewById(R.id.hidden_edit_view1);
		switcher1 = (ViewSwitcher) findViewById(R.id.viewSwitcher1);

		tv2 = (TextView) findViewById(R.id.textView4);
		et2 = (EditText) findViewById(R.id.hidden_edit_view2);
		switcher2 = (ViewSwitcher) findViewById(R.id.viewSwitcher2);

		tv3 = (TextView) findViewById(R.id.textView6);
		et3 = (EditText) findViewById(R.id.hidden_edit_view3);
		switcher3 = (ViewSwitcher) findViewById(R.id.viewSwitcher3);

		tv4 = (TextView) findViewById(R.id.textView8);
		et4 = (EditText) findViewById(R.id.hidden_edit_view4);
		switcher4 = (ViewSwitcher) findViewById(R.id.viewSwitcher4);

		tv5 = (TextView) findViewById(R.id.textView10);
		et5 = (EditText) findViewById(R.id.hidden_edit_view5);
		switcher5 = (ViewSwitcher) findViewById(R.id.viewSwitcher5);

		tv6 = (TextView) findViewById(R.id.textView12);
		et6 = (EditText) findViewById(R.id.hidden_edit_view6);
		switcher6 = (ViewSwitcher) findViewById(R.id.viewSwitcher6);

		tv7 = (TextView) findViewById(R.id.textView14);
		et7 = (EditText) findViewById(R.id.hidden_edit_view7);
		switcher7 = (ViewSwitcher) findViewById(R.id.viewSwitcher7);
	}


	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		switch (v.getId()){
			case (R.id.hidden_edit_view1):
				if(switcher1.getCurrentView() == findViewById(R.id.hidden_edit_view1))
				{
					switcher1.showNext();
					tv1.setText(et1.getText());
				}
				break;
			case (R.id.hidden_edit_view2):
				switcher2.showNext();
				tv2.setText(et2.getText());
				break;

		}

	}


	@Override
	public void onClick(View v) {
		Toast.makeText(getApplicationContext(), String.valueOf(v.getId()) + " " + String.valueOf(R.id.textView1), Toast.LENGTH_SHORT).show();
		switch (v.getId()){
			case (R.id.textView2):
				//Toast.makeText(getApplicationContext(), "DERP", Toast.LENGTH_SHORT).show();
				switcher1.showNext(); // or switcher.showPrevious();
				et1.setText(tv1.getText());
				et1.setFocusable(true);
				et1.requestFocus();
				et1.setOnFocusChangeListener(this);
				break;
		}
	}

	private void setOnClickListeners() {
		tv1.setOnClickListener(this);
		/*tv1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {



			}
		});*/

		/*et.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {

				Toast toast = Toast.makeText(getApplicationContext(), String.valueOf(hasFocus), Toast.LENGTH_SHORT);
				toast.show();
				if (!hasFocus) {

					if (!newEmp) {

					}
				}
				if (hasFocus) {
				}
			}
		});*/
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
