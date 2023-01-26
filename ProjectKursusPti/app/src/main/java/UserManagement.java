import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.projectkursuspti.MainActivity;

public class UserManagement {
    Context context;
    SharedPreferences sharedPreferences;

    public SharedPreferences.Editor editor;
    public static final String PREF_NAME = "User_Login";
    public static final String LOGIN = "is_user_login";
        public static final String NAMALENGKAP = "namalengkap";
        public static final String EMAIL = "email";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    public UserManagement(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public boolean isUserLogin(){
        return sharedPreferences.getBoolean(LOGIN, false);
    }
    public void UserSessionManage (String namalengkap, String email, String username, String password){
        editor.putBoolean(LOGIN, true);
        editor.putString(NAMALENGKAP, email);
        editor.putBoolean(EMAIL, true);
        editor.putBoolean(EMAIL, true);
        editor.putBoolean(LOGIN, true);
        editor.apply();;


    }

    public void checkLogin(){
        if(!this.isUserLogin());
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
//        ((ProfileActivity) context).Fini);
    }


}
