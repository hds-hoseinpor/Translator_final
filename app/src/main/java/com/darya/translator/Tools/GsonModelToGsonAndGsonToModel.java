package com.darya.translator.Tools;

import com.google.gson.Gson;

public class GsonModelToGsonAndGsonToModel {

    public static String ModelToJson(Object model) {
        return new Gson().toJson(model);
    }


}
