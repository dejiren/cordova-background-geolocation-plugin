package com.marianhello.bgloc.data;

import com.marianhello.utils.CloneHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;

import androidx.annotation.Nullable;

public class GisAPILocationTemplate extends HashMapLocationTemplate {

    // copy constructor
    public GisAPILocationTemplate(GisAPILocationTemplate tpl) {
        super(tpl);
    }

    public GisAPILocationTemplate(HashMap map) {
        super(map);
    }
    @Override
    public boolean needJsonAsArray() {
        return false;
    }

    static boolean isSupportLocationTemplate(Object json) {
        if (json instanceof JSONObject) {
            try {
                String appId = ((JSONObject) json).getString("appId");
                JSONObject Location = ((JSONObject) json).getJSONArray("locations").getJSONObject(0);
                return !(appId.isEmpty() || Location == null);
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }
}
