package com.example.kks.alarm.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kks.alarm.R;

/**
 * Created by KKS on 2017-01-26.
 */

public class AlarmViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView tvDetail, tvClock;
    public Button btnUpdate, btnDelete;
    private AlarmAdapter adapter;

    public AlarmViewHolder(View itemView, AlarmAdapter alarmAdapter) {
        super(itemView);
        adapter = alarmAdapter;

        tvClock = (TextView) itemView.findViewById(R.id.tv_clock);
        tvDetail = (TextView) itemView.findViewById(R.id.tv_detail);
        btnUpdate = (Button) itemView.findViewById(R.id.bt_update);
        btnDelete = (Button) itemView.findViewById(R.id.bt_delete);

        btnUpdate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        int position = getAdapterPosition();

        switch (v.getId()) {
            case R.id.bt_update:
                adapter.onUpdateClciked(position);
                break;
            case R.id.bt_delete:
                break;

        }


    }
}
