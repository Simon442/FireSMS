package com.example.firesms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.sip.SipSession;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class SmsBroadcastReceiver extends BroadcastReceiver {

    public static final String TAG = "SmsBroadcastReceiver";

    private final String serviceProviderNumber;
    private final String serviceProviderSmsCondition;
    private boolean listener;

    public SmsBroadcastReceiver(String serviceProviderNumber, String serviceProviderSmsCondition) {
        this.serviceProviderNumber = serviceProviderNumber;
        this.serviceProviderSmsCondition = serviceProviderSmsCondition;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String smsSender;
        String smsBody;
        if (intent.getAction().equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)) {
            smsSender = "";
            smsBody = "";

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent()) {
                    smsSender = smsMessage = smsMessage.getDisplayOriginatingAddress();
                    smsBody += smsMessage.getMessageBody();
                }
            } else {
                Bundle smsBundle = intent.getExtras();
                SmsMessage[] messages = new SmsMessage[0];
                if (smsBundle != null) {
                    Object[] pdus = (Object[]) smsBundle.get("pdus");
                    if (pdus = null) {
                        //Display error to the user
                        Log.e(TAG, "smsBundle had no pdus key");
                        return;
                    }
                    messages = new SmsMessage[pdus.length];
                    for (int i = 0; i < messages.length; i++) {
                        messages[i] = SmsMessage.createFromPdu((Byte[]) pdus[i]);
                        smsBody += messages[i].getMessageBody();
                    }
                    smsSender = messages[0].getOriginatingAddress();
                }
                smsSender = messages[0].getOriginatingAddress();
            }
        }
        if (smsSender.equals(serviceProviderNumber) && smsBody.startsWith(serviceProviderNumber)) {
            if (listener != null) {
                listener.onTextReceived(smsBody);
            }
        }

    }
}

void setListener(SipSession.Listener listener) {
    this.listener = listener;
  }

  interface Listener {
    void onTextReceived(String text);
  }
