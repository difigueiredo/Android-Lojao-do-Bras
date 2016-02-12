package diego.com.lojaodobras.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import diego.com.lojaodobras.model.User;

/**
 * Created by Diegopc on 11/02/2016.
 */

public class SharedPreferencesUtils {

    private static final String KEY_USER_LOGIN_PREFERENCE_USER = "key_user_login_preference_user";

    public static void setUserInSharedPreferences(Context context, User user) {
        SharedPreferences.Editor editor= getSharedEdit(context, KEY_USER_LOGIN_PREFERENCE_USER);
        editor.clear();
        editor.putString("user", new Gson().toJson(user));
        editor.commit();
    }

    public static User getUserFromSharedPreferences(Context context) {
        SharedPreferences shared = getContextShared(context, KEY_USER_LOGIN_PREFERENCE_USER);

        if (shared.getString("user", null) != null) {
            User user = new Gson().fromJson(shared.getString("user", null), User.class);
            return user;
        }
        return null;
    }

    private static SharedPreferences.Editor getSharedEdit(Context context, String key) {
        return context.getSharedPreferences(key, Context.MODE_PRIVATE).edit();
    }

    private static SharedPreferences getContextShared(Context context, String key) {
        return context.getSharedPreferences(key, Context.MODE_PRIVATE);
    }

}
