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
import java.sql.*;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    DBHandler handler;
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, buttonBackspace, buttonEnter;
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

    private void createViewObjects() {
        handler = new DBHandler(this, null, null, 1);

        employees = new ArrayList<Employee>();
        handler.populateEmployeeArray(employees);

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

        for (Button b : buttons) {
            b.setOnClickListener(this);
            b.setTextColor(getResources().getColor(R.color.numberColor));
        }
    }

    public class Java2MySql {
        public void dbsetup(String[] args) {
            String url = "";
            String dbName = "employees";
            String driver = "com.mysql.jdbc.Driver";
            String userName = "TimeOut";
            String password = "tavern";
            try {
                Class.forName(driver).newInstance();
                Connection conn = DriverManager.getConnection(url+dbName,userName,password);

                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.button1):
                editText1.append("1");
                break;
            case (R.id.button2):
                editText1.append("2");
                break;
            case (R.id.button3):
                editText1.append("3");
                break;
            case (R.id.button4):
                editText1.append("4");
                break;
            case (R.id.button5):
                editText1.append("5");
                break;
            case (R.id.button6):
                editText1.append("6");
                break;
            case (R.id.button7):
                editText1.append("7");
                break;
            case (R.id.button8):
                editText1.append("8");
                break;
            case (R.id.button9):
                editText1.append("9");
                break;
            case (R.id.button0):
                editText1.append("0");
                break;
            case (R.id.buttonEnter):
                Boolean correct = false;
                if (editText1.getText().toString().equals("1")) {
                    startActivity(new Intent(MainActivity.this, ManagerScreenActivity.class));
                    return;
                }

                int empid = 0;

                String query = "SELECT * FROM " + DBHandler.TABLE_EMPLOYEES + " WHERE accesscode = " + editText1.getText().toString();
                SQLiteDatabase db = handler.getWritableDatabase();
                Cursor c = db.rawQuery(query, null);
                c.moveToFirst();
                empid = c.getInt(c.getColumnIndex("id"));
                if (c.getCount() > 0) {
                    correct = true;
                }

                if (correct) {
                    Intent i = new Intent(MainActivity.this, EmployeeScreenActivity.class);
                    i.putExtra("employeeId", String.valueOf(empid));
                    editText1.setText("");
                    startActivity(i);
                    break;
                } else editText1.setText("");
                break;

            case (R.id.buttonBack):
                int length = editText1.getText().length();
                if (length > 0) {
                    editText1.getText().delete(length - 1, length);
                }
                break;
            default:
                break;
        }

    }
}
