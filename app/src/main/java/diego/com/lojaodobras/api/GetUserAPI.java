package diego.com.lojaodobras.api;

import android.content.Context;

import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import diego.com.lojaodobras.api.services.CallJsonNetwork;
import diego.com.lojaodobras.model.User;
import diego.com.lojaodobras.utils.Keys;

/**
 * Created by Diegopc on 11/02/2016.
 */
public class GetUserAPI extends CallJsonNetwork {

    public static void getUser(Context context, String id, String key, Response.Listener<JSONObject> responseListener, Response.ErrorListener errorListener) {
        callJsonObjectGet(context, HOST + API + USER + LOGIN + id + BAR + key, responseListener, errorListener);
    }
}
