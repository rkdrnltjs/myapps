package com.example.kks.alarm.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.kks.alarm.R;
import com.example.kks.alarm.dialog.AlarmUpdateDialog;

import java.util.ArrayList;

/**
 * Created by KKS on 2017-01-26.
 */

public class AlarmAdapter extends RecyclerView.Adapter<AlarmViewHolder> {

    private  Context mContext;
    public  ArrayList<AlarmItem> alarmItems;
    private AlarmUpdateDialog updateDialog;

    public AlarmAdapter(Context context, ArrayList<AlarmItem> items) {
        mContext = context;
        alarmItems = items;
        updateDialog = new AlarmUpdateDialog(mContext, this);
    }


    @Override
    public AlarmViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = View.inflate(mContext, R.layout.alarm_item, null);
        AlarmViewHolder alarmViewHolder = new AlarmViewHolder(itemView, this);
        return alarmViewHolder;
    }

    @Override
    public void onBindViewHolder(AlarmViewHolder holder, int position) {

        AlarmItem item = alarmItems.get(position);
        holder.tvClock.setText(item.getYear()+"-"+item.getMonth()+"-"+item.getDay()+" "+item.getHour()+" : "+item.getMinute());
        holder.tvDetail.setText(item.getDetail());

    }
    public void remove(int position) {
        alarmItems.remove(position);
        this.notifyDataSetChanged();
    }

    public void setItem(ArrayList<AlarmItem> alarmItems) {
        for(int i = 0 ; i < alarmItems.size() ; i++) {
            this.remove(i);
        }
        this.notifyDataSetChanged();
        this.alarmItems= alarmItems;
    }

    @Override
    public int getItemCount() {
        return alarmItems.size();
    }


    //수정버튼
    public void onUpdateClciked(int position) {

        updateDialog.show();

    }


}
