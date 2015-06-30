package com.winbusiness.spoton;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class ManagerScreenActivity extends Activity {
    ArrayList<Employee> employeeList;
    ArrayList<String> employeeTitle;
    DBHandler handler;
    EditText sqlText;
    Button executeSql;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_screen);

        instantiateVariables();
        populateEmployeeListView();
    }

    private void instantiateVariables() {
        employeeList = new ArrayList<Employee>();
        employeeTitle = new ArrayList<String>();
        handler = new DBHandler(this, null, null, 1);

        handler.populateEmployeeArray(employeeList);

        sqlText = (EditText) findViewById(R.id.editText);
        sqlText.setText("insert into employees (firstname, lastname, accesscode) select 'casey', 'wickland', 100 union all select 'john', 'wickland', 48 union all select 'nathan', 'wickland', 21 union all select 'Tracy', 'Loney', 30 union all select 'Rambo', 'Orth', 87 union all select 'Jessica', '', 96 union all select 'T.J.', '', 303 union all select 'Alissa', '', 44 union all select 'Mike', '', 578 union all select 'johnny', 'neal', 420");
        executeSql = (Button) findViewById(R.id.Executebutton);

        executeSql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = handler.getWritableDatabase();
                db.execSQL(sqlText.getText().toString());
                finish();
                startActivity(getIntent());
            }
        });
    }

    private void populateEmployeeListView() {
        for (Employee emp : employeeList) {
            employeeTitle.add(emp.getFirstName() + " " + emp.getLastName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.employee_items, employeeTitle);

        ListView listview = (ListView) findViewById(R.id.listView1);
        listview.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.manager_activity_action, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_employee:
                startActivity(new Intent(ManagerScreenActivity.this, Employee_editor.class).putExtra("newEmp", true));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
