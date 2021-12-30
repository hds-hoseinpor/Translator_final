package com.darya.translator.Tools;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.darya.translator.R;

public class Tools {
    public static void hideKyboardWhenClicked(View mainLayout, Context context) {

// Then just use the following:
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);
    }

    public static void showCustomToast(String message, Context context) {
        if (message.isEmpty()) return;
        if (message.contains("403") || message.contains("500")) {
            return;
        }
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_simple, (ViewGroup) ((Activity) context).findViewById(R.id.toast_layout_root));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText(message);

        Toast toast = new Toast(((Activity) context).getApplicationContext());
        if (message.length() < 40) {
            toast.setDuration(Toast.LENGTH_SHORT);
        } else {
            toast.setDuration(Toast.LENGTH_LONG);
        }
        toast.setView(layout);
        toast.show();
    }

}
