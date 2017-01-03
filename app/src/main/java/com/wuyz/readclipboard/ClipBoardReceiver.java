package com.wuyz.readclipboard;

import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by wuyz on 2016/11/29.
 * ClipBoardReceiver
 * adb shell am broadcast -a readclipboard.action.SEND_TEXT --es key "value"
 */

public class ClipBoardReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String value = intent.getStringExtra("key");
        Log.d("readclipboard", "value: " + value);
        if (!TextUtils.isEmpty(value)) {
            ClipboardManager manager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("readclipboard", value);
            manager.setPrimaryClip(clipData);
            Toast.makeText(context, value, Toast.LENGTH_LONG).show();
        }
    }
}
