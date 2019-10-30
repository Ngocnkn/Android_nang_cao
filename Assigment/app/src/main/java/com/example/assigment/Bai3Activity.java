package com.example.assigment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Bai3Activity extends AppCompatActivity {
    private ProfilePictureView profilePictureView;
    private TextView mTvInfo, edtLink;
    private LoginButton mBtnLoginFacebook;
    private Button btnChiaseLink;
    private CallbackManager mCallbackManager;
    private ShareDialog shareDialog;
    private ShareLinkContent shareLinkContent;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_bai3);
        mCallbackManager = CallbackManager.Factory.create();
        mTvInfo = (TextView) findViewById(R.id.tv_info);
        edtLink = findViewById(R.id.edtlink);
        btnChiaseLink = findViewById(R.id.ChiaSeLink);
        mBtnLoginFacebook = (LoginButton) findViewById(R.id.login_button);
        profilePictureView = findViewById(R.id.ProfilePicture);

        mBtnLoginFacebook.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                mTvInfo.setText("User ID: " + loginResult.getAccessToken().getUserId());

                profilePictureView.setProfileId(Profile.getCurrentProfile().getId());
            }

            @Override
            public void onCancel() {
                mTvInfo.setText("Thành công");
            }

            @Override
            public void onError(FacebookException e) {
                mTvInfo.setText("Thất bại");
            }
        });

        shareDialog = new ShareDialog(Bai3Activity.this);
        btnChiaseLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ShareDialog.canShow(ShareLinkContent.class)) {
                    shareLinkContent = new ShareLinkContent.Builder()
                            .setContentUrl(Uri.parse(edtLink.getText().toString()))
                            .build();
                }
                shareDialog.show(shareLinkContent);
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }


}







