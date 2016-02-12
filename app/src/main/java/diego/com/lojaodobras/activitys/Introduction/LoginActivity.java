package diego.com.lojaodobras.activitys.Introduction;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.List;

import diego.com.lojaodobras.R;
import diego.com.lojaodobras.api.GetUserAPI;
import diego.com.lojaodobras.model.User;
import diego.com.lojaodobras.utils.RedirectUtils;
import diego.com.lojaodobras.utils.SharedPreferencesUtils;

/**
 * Created by Diegopc on 10/02/2016.
 */
public class LoginActivity extends BaseActivity {

    private EditText putKey;
    private RelativeLayout btnTapEnter;
    private String cpfUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
            cpfUser = bundle.getString(getString(R.string.bundle_key_cpf));

        putKey = (EditText)findViewById(R.id.edittext_put_cpf_login_activity);
        btnTapEnter = (RelativeLayout)findViewById(R.id.btn_tap_enter_login_activity);

        btnTapEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPasswordToEnter();
            }
        });
    }


    public void checkPasswordToEnter(){
        GetUserAPI.getUser(getActivity(), cpfUser, putKey.getText().toString(), new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String messageCode = response.optString("responseCode");

                        if (messageCode.equals("200") || messageCode.equals("201"))
                            passwordOk(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.print(error);
                    }
                });
    }

    public void showModalWrongPassword(){}

    public void passwordOk(JSONObject response){
        User user = (User) User.userToJson(response);
        SharedPreferencesUtils.setUserInSharedPreferences(getActivity(), user);
        RedirectUtils.redirectToWelComeViewActivity(getActivity());
    }
}
