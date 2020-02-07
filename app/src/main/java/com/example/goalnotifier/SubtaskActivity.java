package com.example.goalnotifier;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubtaskActivity extends AppCompatActivity {
    TextView start_date,end_date,start_time,end_time,remaining_time;
    EditText et_subtask;
    Button btn_submit;
    Spinner sp_remainder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_subtask);

        start_date=(TextView)findViewById(R.id.start_date);
        end_date=(TextView)findViewById(R.id.end_date);
        start_time=(TextView)findViewById(R.id.start_time);
        end_time=(TextView)findViewById(R.id.end_time);
        et_subtask=(EditText)findViewById(R.id.et_subtask_name);
        btn_submit=(Button) findViewById(R.id.btn_set_subtask);
        sp_remainder=(Spinner)findViewById(R.id.sp_remainder);

        final Calendar calendar=Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener startDate=new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                start_date.setText("");
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                int m=month+1;
                start_date.setText(dayOfMonth+"/"+m+"/"+year);
            }
        };
        final DatePickerDialog.OnDateSetListener endDate=new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                end_date.setText("");
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                int m=month+1;
                end_date.setText(dayOfMonth+"/"+m+"/"+year);
            }
        };


        final TimePickerDialog.OnTimeSetListener startTime=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                start_time.setText("");
                calendar.set(Calendar.HOUR,hourOfDay);
                calendar.set(Calendar.MINUTE,minute);
                if(hourOfDay<10 && minute<10)
                {
                    start_time.setText("0"+hourOfDay+":0"+minute);
                }
                else if(hourOfDay<10)
                {
                    start_time.setText("0"+hourOfDay+":"+minute);
                }
                else if(minute<10)
                {
                    start_time.setText(""+hourOfDay+":0"+minute);
                }
                else
                start_time.setText(hourOfDay+":"+minute);
            }
        };
        final TimePickerDialog.OnTimeSetListener endTime=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                end_time.setText("");
                calendar.set(Calendar.HOUR,hourOfDay);
                calendar.set(Calendar.MINUTE,minute);
                if(hourOfDay<10 && minute<10)
                {
                    end_time.setText("0"+hourOfDay+":0"+minute);
                }
                else if(hourOfDay<10)
                {
                    end_time.setText("0"+hourOfDay+":"+minute);
                }
                else if(minute<10)
                {
                    end_time.setText(""+hourOfDay+":0"+minute);
                }
                else
                    end_time.setText(hourOfDay+":"+minute);

            }
        };

        //set event listner for date and timing---------------------
        start_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               new DatePickerDialog(SubtaskActivity.this,startDate,
                       calendar.get(Calendar.YEAR),
                       calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        end_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(SubtaskActivity.this,endDate,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });


        start_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(SubtaskActivity.this,startTime,
                        calendar.get(Calendar.HOUR),calendar.get(Calendar.MINUTE),true).show();

            }
        });

        end_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(SubtaskActivity.this,endTime,
                        calendar.get(Calendar.HOUR),calendar.get(Calendar.MINUTE),true).show();

            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSubtask();
            }
        });

    }

    public void setSubtask(){
        String subtask_name=et_subtask.getText().toString();
        String sDate=start_date.getText().toString();
        String eDate=end_date.getText().toString();
        String sTime=start_time.getText().toString();
        String eTime=end_time.getText().toString();
        String remainderTime=sp_remainder.getSelectedItem().toString();

        Toast.makeText(getApplicationContext(),subtask_name+"\n"+sDate+"\n"+eDate+"\n"+sTime+"\n"+eTime+"\n"+remainderTime,Toast.LENGTH_LONG).show();
    }
}
