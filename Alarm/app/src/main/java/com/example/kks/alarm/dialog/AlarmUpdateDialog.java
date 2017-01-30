package com.example.kks.alarm.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import com.example.kks.alarm.MainActivity;
import com.example.kks.alarm.R;
import com.example.kks.alarm.database.AlarmDatabase;
import com.example.kks.alarm.database.AlarmWrite;
import com.example.kks.alarm.recycler.AlarmAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by KKS on 2017-01-26.
 */

public class AlarmUpdateDialog extends Dialog {


    private EditText etDetail;
    private ToggleButton tgOne, tgTwo, tgThree, tgFour, tgFive, tgSix, tgSeven;
    private Button btnSave, btnCancel;
    private DatePicker datePicker;
    private TimePicker timePicker;
    int myear, mmonth, mday;
    int mhour, mminute;
    private String detail;
    private SimpleDateFormat dateFormat;
    private Context mcontext;
    private AlarmAdapter adapter;
    private MainActivity mainActivity;

    public AlarmUpdateDialog(Context context, AlarmAdapter alarmAdapter) {
        super(context);
        mcontext = context;
        this.adapter = alarmAdapter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.alarm_updatedialog);

        datePicker = (DatePicker) findViewById(R.id.datePicker);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        etDetail = (EditText) findViewById(R.id.et_detail);
        tgOne = (ToggleButton) findViewById(R.id.tg_one);
        tgTwo = (ToggleButton) findViewById(R.id.tg_two);
        tgThree = (ToggleButton) findViewById(R.id.tg_three);
        tgFour = (ToggleButton) findViewById(R.id.tg_four);
        tgFive = (ToggleButton) findViewById(R.id.tg_five);
        tgSix = (ToggleButton) findViewById(R.id.tg_six);
        tgSeven = (ToggleButton) findViewById(R.id.tg_seven);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnCancel = (Button) findViewById(R.id.btn_cancel);
        mainActivity = new MainActivity();

        initDate();
        button();

    }



    //달력 초기화 및 리스너
    private void initDate() {

        long now = System.currentTimeMillis();
        Date date = new Date(now);
        dateFormat = new SimpleDateFormat("yyyy", java.util.Locale.getDefault());
        myear = Integer.valueOf(dateFormat.format(date));
        dateFormat = new SimpleDateFormat("MM", java.util.Locale.getDefault());
        mmonth = Integer.valueOf(dateFormat.format(date));
        dateFormat = new SimpleDateFormat("dd", java.util.Locale.getDefault());
        mday = Integer.valueOf(dateFormat.format(date));
        dateFormat = new SimpleDateFormat("HH", java.util.Locale.getDefault());
        mhour = Integer.valueOf(dateFormat.format(date));
        dateFormat = new SimpleDateFormat("mm", java.util.Locale.getDefault());
        mminute = Integer.valueOf(dateFormat.format(date));


        datePicker.init(myear, mmonth, mday, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                myear = year;
                mday = dayOfMonth;
                mmonth = monthOfYear;

            }
        });

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                mhour = hourOfDay;
                mminute = minute;

            }
        });
    }

    //SAVE , CANCEL 버튼
    private void button() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DB 저장

                insert_db();
                cancel();

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
                //취소
            }
        });
    }

    private void insert_db() {

        detail = etDetail.getText().toString();

        AlarmDatabase alarmDatabase = new AlarmDatabase();
        AlarmWrite alarmWrite = new AlarmWrite();

        alarmDatabase.setYear(myear);
        alarmDatabase.setMonth(mmonth);
        alarmDatabase.setDay(mday);
        alarmDatabase.setHour(mhour);
        alarmDatabase.setMinute(mminute);
        alarmDatabase.setDetail(detail);

        alarmWrite.write(mcontext, alarmDatabase);

        mainActivity.refreshList();
        adapter.notifyDataSetChanged();

    }


    public EditText getEtDetail() {
        return etDetail;
    }

    public void setEtDetail(EditText etDetail) {
        this.etDetail = etDetail;
    }

    public ToggleButton getTgOne() {
        return tgOne;
    }

    public void setTgOne(ToggleButton tgOne) {
        this.tgOne = tgOne;
    }

    public ToggleButton getTgTwo() {
        return tgTwo;
    }

    public void setTgTwo(ToggleButton tgTwo) {
        this.tgTwo = tgTwo;
    }

    public ToggleButton getTgThree() {
        return tgThree;
    }

    public void setTgThree(ToggleButton tgThree) {
        this.tgThree = tgThree;
    }

    public ToggleButton getTgFour() {
        return tgFour;
    }

    public void setTgFour(ToggleButton tgFour) {
        this.tgFour = tgFour;
    }

    public ToggleButton getTgFive() {
        return tgFive;
    }

    public void setTgFive(ToggleButton tgFive) {
        this.tgFive = tgFive;
    }

    public ToggleButton getTgSix() {
        return tgSix;
    }

    public void setTgSix(ToggleButton tgSix) {
        this.tgSix = tgSix;
    }

    public ToggleButton getTgSeven() {
        return tgSeven;
    }

    public void setTgSeven(ToggleButton tgSeven) {
        this.tgSeven = tgSeven;
    }

    public Button getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(Button btnSave) {
        this.btnSave = btnSave;
    }

    public Button getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(Button btnCancel) {
        this.btnCancel = btnCancel;
    }


}
