

package com.example.sms_mc;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsRecieve extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Object[] smsObj = (Object[]) bundle.get("pdus");


        for(Object obj: smsObj){
            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) obj);
            String number = smsMessage.getDisplayOriginatingAddress();
            String message = smsMessage.getDisplayMessageBody();
            Toast.makeText(context, number + "  :::  " + message, Toast.LENGTH_SHORT).show();
        }
    }
}
