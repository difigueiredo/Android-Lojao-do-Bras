package diego.com.lojaodobras.activitys.Introduction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

import java.util.Arrays;

import diego.com.lojaodobras.R;
import diego.com.lojaodobras.utils.RedirectUtils;

/**
 * Created by Diegopc on 10/02/2016.
 */
public class HomeActivity extends BaseActivity {

    private EditText edtTextCpf;
    private RelativeLayout btnTapEnter;
    private RelativeLayout btnTapLoginFacebook;
    private RelativeLayout btnTapGooglem;
    private CallbackManager callbackManager;
    private LoginButton loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getActivity());
        setContentView(R.layout.activity_home);

        callbackManager = CallbackManager.Factory.create();

        facebookSettings();

        edtTextCpf = (EditText)findViewById(R.id.edt_text_cpf_home_activity);
        btnTapEnter = (RelativeLayout)findViewById(R.id.btn_tap_enter_home_activity);
        btnTapLoginFacebook = (RelativeLayout) findViewById(R.id.btn_tap_login_facebook_home_activity);
        btnTapGooglem = (RelativeLayout) findViewById(R.id.btn_tap_login_googlem_home_activity);

        btnTapEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkExistentCPF();
            }
        });

        btnTapLoginFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginFacebook();
            }
        });

        btnTapGooglem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginGooglem();
            }
        });
    }

    private void facebookSettings() {

        loginButton = (LoginButton) findViewById(R.id.login_button_facebook);
        loginButton.setReadPermissions(Arrays.asList("public_profile", "email"));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d("facebook", loginResult.getAccessToken().getUserId());
                requestGraph(loginResult);
            }

            @Override
            public void onCancel() {
                Toast.makeText(HomeActivity.this, "cancel", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(HomeActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void checkExistentCPF(){
        RedirectUtils.redirectToLoginActivity(getActivity(), edtTextCpf.getText().toString());
    }

    public void loginFacebook(){}


    private void requestGraph(LoginResult loginResult) {
        GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                System.out.print(object);
                System.out.print(response);
                RedirectUtils.redirectToWelComeViewActivity(getActivity());
            }
        });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,email, picture.type(large)");
        request.setParameters(parameters);
        request.executeAsync();

    }


    @Override
    protected void onResume() {
        super.onResume();
        AppEventsLogger.activateApp(getActivity());
    }

    @Override
    protected void onPause() {
        super.onPause();
        AppEventsLogger.deactivateApp(getActivity());
    }

    public void loginGooglem(){}


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

}
