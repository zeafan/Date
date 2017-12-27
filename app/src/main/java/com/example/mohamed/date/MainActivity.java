package com.example.mohamed.date;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> dates=GetDate();
        try {
            ArrayList<String> lst= DeleteDate(new Date(),dates);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    ArrayList<String> DeleteDate(Date date,ArrayList<String> lstdate) throws ParseException {
        ArrayList<String>newDate= new ArrayList<String>();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -15);
        Date dateBefore15Days = calendar.getTime();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        for(String dateString:lstdate) {
            Date d = format.parse(dateString);
            if(dateBefore15Days.before(d))
            {
                String de=format.format(d);
                newDate.add(de);
            }
        }

        return newDate;
    }
    ArrayList<String> GetDate()
    {
        ArrayList<String> list=new ArrayList<>();
        for(int i=1;i<26;i++)
        {
            String da="2017-12-"+i;
            list.add(da);
        }
        return list;
    }

}
