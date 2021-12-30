package com.darya.translator.Volley;

import android.content.Context;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.darya.translator.DataModel.DMTranslateData;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

public class ApiService {


    private static final String TAG = "ApiService";
    private Context context;
    private RequestQueue requestQueue;
    private final String WHEN_ERROR_IN_PARSE_JSON = "خطا در دریافت اطلاعات از سرور";
    private final String WHEN_ERROR_IN_SERVER = "اطلاعاتی از سرور دریافت نشد ، لطفا بعدا امتحان کنید";

    public ApiService(Context context) {
        this.context = context;
    }

    ///// .............................Message ........................///////////////////
    public void translate(String text, String from, String to, OnReceivedData receiver) {
        String title_log = "translate";
        String url = "http://api.mymemory.translated.net/get?q=" + text + "&langpair=" + from + "%7C" + to;
        Log.i(TAG, "url:" + title_log + " : " + url);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i(TAG, "onResponse:" + title_log + " : " + response.toString());
                try {
                    DMTranslateData item = new Gson().fromJson(response.toString(),
                            new TypeToken<DMTranslateData>() {
                            }.getType());
                    receiver.onReceived(item);
                } catch (JsonSyntaxException e) {
                    receiver.onError("");
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG, "onErrorResponse:" + title_log + " : " + error.toString());
                try {
                    receiver.onError(error.networkResponse.statusCode + " : " + WHEN_ERROR_IN_SERVER);
                } catch (Exception e) {
                    receiver.onError(WHEN_ERROR_IN_SERVER);
                    e.printStackTrace();
                }
            }
        }
        );
        addRequestToRequestQueue(request);
    }


    void addRequestToRequestQueue
            (JsonRequest<?> request) {
        request.setRetryPolicy(new DefaultRetryPolicy(20000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        checkRequestQueue();
        requestQueue.add(request);
    }

    void checkRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context);
        }
    }


    public interface OnReceivedData {

        void onReceived(DMTranslateData item);

        void onError(String message);
    }


}
