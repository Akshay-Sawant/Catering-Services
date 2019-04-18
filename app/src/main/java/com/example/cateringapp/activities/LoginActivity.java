package com.example.cateringapp.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cateringapp.R;
import com.example.cateringapp.database.DatabaseHelper;
import com.example.cateringapp.fragments.UsersListFragment;
import com.example.cateringapp.utils.CustomSnackBarHelper;
import com.example.cateringapp.utils.InputValidation;
import com.example.cateringapp.utils.PrefManager;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context;

    private RelativeLayout mRelativeLayout;
    private TextInputLayout mTextInputLayoutEmail, mTextInputLayoutPassword;
    private TextInputEditText mTextInputEditTextEmail, mTextInputEditTextPassword;

    private AppCompatButton mAppCompatButtonLogin, mAppCompatTextViewLinkRegister;
    private InputValidation mInputValidation;
    private DatabaseHelper mDatabaseHelper;
    private CheckBox rememberMeCheckbox;

    private String mEmail, mPassword;
    PrefManager prefManager;
    private Intent accountsIntent;
    private Snackbar loginSnackBar;
    private CustomSnackBarHelper loginCustomSnackBarHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context = LoginActivity.this;

        prefManager = new PrefManager(LoginActivity.this);
        /**
         * Calling functions
         *
         * Binding function
         * Initialize Listeners function
         * Initialize Objects function
         * */

        loginCustomSnackBarHelper = new CustomSnackBarHelper();

        bindingViewsByIdFunc();
        initializeListenersFunc();
        initializeObjectsFunc();
    }

    public void bindingViewsByIdFunc() {

        //Binding the nested scrollview
        mRelativeLayout = findViewById(R.id.relative_layout);

        //Binding the text input layout fields for EMAIL and PASSWORD
        mTextInputLayoutEmail = findViewById(R.id.textInputLayoutEmail);
        mTextInputLayoutPassword = findViewById(R.id.textInputLayoutPassword);

        //Binding the text input edit text for EMAIL and PASSWORD
        mTextInputEditTextEmail = findViewById(R.id.textInputEditTextEmail);
        mTextInputEditTextPassword = findViewById(R.id.textInputEditTextPassword);

        //Binding the Login Button
        mAppCompatButtonLogin = findViewById(R.id.appCompatButtonLogin);

        //Binding the link for REGISTRATION
        mAppCompatTextViewLinkRegister = findViewById(R.id.textViewLinkRegister);

        //Binding the REMEMBER ME check box
        rememberMeCheckbox = findViewById(R.id.remember_me_checkbox);

        prefManager = new PrefManager(this);
    }

    /**
     * This method is to initialize listeners
     */
    private void initializeListenersFunc() {
        mAppCompatButtonLogin.setOnClickListener(this);
        mAppCompatTextViewLinkRegister.setOnClickListener(this);
    }

    /**
     * This method is to initialize objects to be used
     */
    private void initializeObjectsFunc() {
        mDatabaseHelper = new DatabaseHelper(this);
        mInputValidation = new InputValidation(this);

    }

    /**
     * This implemented method is to listen the click on view
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.appCompatButtonLogin:
                verifyFromSQLiteFunc();
                break;
            case R.id.textViewLinkRegister:
                Intent intentRegister = new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(intentRegister);
                break;
        }
    }

    /**
     * Method to validate and verify
     * <p>
     * Validate the input text fields
     * Verify login credentials using SQLite
     */
    @SuppressLint("Range")
    private void verifyFromSQLiteFunc() {
        mEmail = "shobhachaudhary421@gmail.com";
        mPassword = "shobha123";

        if (!mInputValidation.isInputEditTextFilledFunc(mTextInputEditTextEmail, mTextInputLayoutEmail,
                getString(R.string.error_message_email))) {
            return;
        }
        if (!mInputValidation.isInputEditTextEmailFunc(mTextInputEditTextEmail, mTextInputLayoutEmail,
                getString(R.string.error_message_email))) {
            return;
        }
        if (!mInputValidation.isInputEditTextFilledFunc(mTextInputEditTextPassword, mTextInputLayoutPassword,
                getString(R.string.error_message_email))) {
            return;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (rememberMeCheckbox.isChecked() && mDatabaseHelper.checkForUsers(Objects.requireNonNull(mTextInputEditTextEmail.getText()).toString().trim()
                    , Objects.requireNonNull(mTextInputEditTextPassword.getText()).toString().trim()) && rememberMeCheckbox.isChecked()) {
                PrefManager.setUsername(this, mTextInputEditTextEmail.getText().toString().trim());
                PrefManager.setPassword(this, mTextInputEditTextPassword.getText().toString().trim());
                accountsIntent = new Intent(context, HomeScreenActivity.class);
                emptyInputEditText();
                startActivity(accountsIntent);
                finish();
            } else if (mDatabaseHelper.checkForUsers(Objects.requireNonNull(mTextInputEditTextEmail.getText()).toString().trim()
                    , Objects.requireNonNull(mTextInputEditTextPassword.getText()).toString().trim())) {
                accountsIntent = new Intent(context, HomeScreenActivity.class);
                emptyInputEditText();
                startActivity(accountsIntent);
                finish();
            } else if (mTextInputEditTextEmail.getText().toString().trim().equals(mEmail) && mTextInputEditTextPassword.getText().toString().trim().equals(mPassword)) {
                startActivity(new Intent(LoginActivity.this, AdminActivity.class));
                finish();
            } else {
                // Snack Bar to show success message that record is wrong
                loginCustomSnackBarHelper.snackBarFunc(context, mRelativeLayout, getString(R.string.error_valid_email_password), Snackbar.LENGTH_SHORT);
            }
        }
    }

    /**
     * This method is to empty all input edit text
     */
    private void emptyInputEditText() {
        mTextInputEditTextEmail.setText(null);
        mTextInputEditTextPassword.setText(null);
    }

    @Override
    public void onBackPressed() {
        exitFromAppFunc();
    }

    public void exitFromAppFunc() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.app_close_alert_title);
        builder.setMessage(R.string.app_close_alert_message);
        builder.setPositiveButton(R.string.yes_button_of_alert, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton(R.string.no_button_of_alert, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
}