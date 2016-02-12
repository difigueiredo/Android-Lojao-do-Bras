package diego.com.lojaodobras.api.services;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;

import org.json.JSONObject;

/**
 * Created by Diegopc on 11/02/2016.
 */
public class CallJsonNetwork {

    public static String HOST = "http://54.207.115.150/br-com-bc9-lojaodobras-service/";
    public static String API = "api/";
    public static String USER = "usuario/";
    public static String LOGIN = "login/";
    public static String CUPONS = "cupons/";
    public static String BAR = "/";



    public static void callJsonObjectGet(Context context, String url, Response.Listener<JSONObject> responseListener, Response.ErrorListener errorListener) {
        RequestQueue mRequestQueue = VolleySingleton.getInstance(context).getRequestQueue();
        CustomJsonObjectRequest request = new CustomJsonObjectRequest(Request.Method.GET, url, responseListener, errorListener);

        mRequestQueue.add(request);
    }

    public static void callJsonObjectPost(Context context, String url, Response.Listener<JSONObject> responseListener, Response.ErrorListener errorListener) {
        RequestQueue mRequestQueue = VolleySingleton.getInstance(context).getRequestQueue();
        CustomJsonObjectRequest request = new CustomJsonObjectRequest(Request.Method.POST, url, responseListener, errorListener);

        mRequestQueue.add(request);
    }

    public static void callJsonObjectPut(Context context, String url, Response.Listener<JSONObject> responseListener, Response.ErrorListener errorListener) {
        RequestQueue mRequestQueue = VolleySingleton.getInstance(context).getRequestQueue();
        CustomJsonObjectRequest request = new CustomJsonObjectRequest(Request.Method.PUT, url, responseListener, errorListener);

        mRequestQueue.add(request);
    }

    public static void callJsonObjectDelete(Context context, String url, Response.Listener<JSONObject> responseListener, Response.ErrorListener errorListener) {
        RequestQueue mRequestQueue = VolleySingleton.getInstance(context).getRequestQueue();
        CustomJsonObjectRequest request = new CustomJsonObjectRequest(Request.Method.DELETE, url, responseListener, errorListener);

        mRequestQueue.add(request);
    }
}
