package diego.com.lojaodobras.utils;

import android.app.Activity;
import android.content.Intent;

import diego.com.lojaodobras.activitys.Introduction.ConfirmRegisterActivity;
import diego.com.lojaodobras.activitys.Introduction.LoginActivity;
import diego.com.lojaodobras.activitys.Introduction.RegisterActivity;
import diego.com.lojaodobras.activitys.WelcomeViewActivity;

/**
 * Created by Diegopc on 10/02/2016.
 */

public class RedirectUtils {

    public static void redirectToLoginActivity (Activity activity, String cpf) {
        Intent intent = new Intent(activity, LoginActivity.class);
        intent.putExtra("CPF", cpf);
        activity.startActivity(intent);
        activity.finish();
    }

    public static void redirectToRegisterActivity(Activity activity){
        Intent intent = new Intent (activity, RegisterActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

    public static void redirectToConfirmRegisterActivity(Activity activity){
        Intent intent = new Intent (activity, ConfirmRegisterActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

    public static void redirectToWelComeViewActivity(Activity activity){
        Intent intent = new Intent (activity, WelcomeViewActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }
}
