package com.example.cateringapp.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.cateringapp.R;
import com.example.cateringapp.utils.PrefManager;

import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout mUserProfileRelativeLayout;
    private CircleImageView mUserProfileCircleImageView;
    private TextView mUserNameTextView, mEmailAddressTextView, mMobileNoTextView, mPasswordTextView;
    private EditText mMobileNoEditText;
    private ImageButton mEditUserMobileNoImageButton;
    private Snackbar userProfileSnackBar;
    private Button saveUserMobileNoBtn;

    private Context mUserProfileContext;
    private AlertDialog.Builder mUserProfileActivityBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mUserProfileContext = UserProfileActivity.this;

        bindingUserProfileFragmentViewsFunc();
        settingDataToTheViewsFunc();
    }

    public void bindingUserProfileFragmentViewsFunc() {
        //Binding root view
        mUserProfileRelativeLayout = findViewById(R.id.user_prole_relative_layout);

        //Binding Users Profile Picture
        mUserProfileCircleImageView = findViewById(R.id.user_profile_picture_circle_image_view);

        //Binding all the Text Views
        mUserNameTextView = findViewById(R.id.user_name_text_view);
        mEmailAddressTextView = findViewById(R.id.user_email_id_text_view);
        mMobileNoTextView = findViewById(R.id.user_mobile_no_text_view);
        mPasswordTextView = findViewById(R.id.user_password_text);

        mMobileNoEditText = findViewById(R.id.user_mobile_no_edit_text);

        saveUserMobileNoBtn = findViewById(R.id.save_mobile_no_btn);

        //Binding Edit Mobile No Image Button
        mEditUserMobileNoImageButton = findViewById(R.id.edit_mobile_number);

        saveUserMobileNoBtn.setOnClickListener(this);
        mEditUserMobileNoImageButton.setOnClickListener(this);
    }

    public void settingDataToTheViewsFunc() {
        mUserNameTextView.setText(PrefManager.getUserFullName(mUserProfileContext));
        mEmailAddressTextView.setText(PrefManager.getUsername(mUserProfileContext));
        mPasswordTextView.setText(PrefManager.getPassword(mUserProfileContext));
        mPasswordTextView.setTransformationMethod(new AsteriskPasswordTransformationMethod());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edit_mobile_number:
                editUserMobileNoImageButtonFunc();
                break;
            case R.id.save_mobile_no_btn:
                saveUserMobileNoFunc();
                break;
        }
    }

    public void editUserMobileNoImageButtonFunc() {
        mEditUserMobileNoImageButton.setVisibility(View.GONE);
        mMobileNoTextView.setVisibility(View.GONE);
        mMobileNoEditText.setVisibility(View.VISIBLE);
        saveUserMobileNoBtn.setVisibility(View.VISIBLE);
    }

    public void saveUserMobileNoFunc() {
        mMobileNoEditText.setVisibility(View.GONE);

        mMobileNoTextView.setVisibility(View.VISIBLE);
        mEditUserMobileNoImageButton.setVisibility(View.VISIBLE);

        PrefManager.setMobileNo(this, String.valueOf(mMobileNoEditText.getText()));
        mMobileNoTextView.setText(PrefManager.getMobileNo(this));

        snackBarFunc();
    }

    /**
     * Inner Class created to convert the password into ASTERISK format
     * Inherited PasswordTransformationMethod class to get the required properties
     */
    public class AsteriskPasswordTransformationMethod extends PasswordTransformationMethod {
        @Override
        public CharSequence getTransformation(CharSequence source, View view) {
            return new PasswordCharSequence(source);
        }

        private class PasswordCharSequence implements CharSequence {
            private CharSequence mSource;

            private PasswordCharSequence(CharSequence source) {
                mSource = source; // Store char sequence
            }

            public char charAt(int index) {
                return '*'; // This is the important part
            }

            public int length() {
                return mSource.length(); // Return default
            }

            public CharSequence subSequence(int start, int end) {
                return mSource.subSequence(start, end); // Return default
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void snackBarFunc() {
        userProfileSnackBar = Snackbar
                .make(mUserProfileRelativeLayout, "Item added to your cart", Snackbar.LENGTH_INDEFINITE)
                .setAction("Ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        saveUserMobileNoBtn.setVisibility(View.GONE);
                    }
                });
        userProfileSnackBar.setActionTextColor(Color.WHITE);

        View snackbarView = userProfileSnackBar.getView();
        snackbarView.setBackgroundColor(mUserProfileRelativeLayout.getResources().getColor(R.color.blue));
        TextView snackbarTextView = snackbarView.findViewById(android.support.design.R.id.snackbar_text);
        snackbarTextView.setTextColor(Color.WHITE);
        userProfileSnackBar.show();
    }
}
