package com.example.restorantforterazza.Logic

import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.example.restorantforterazza.UserMainActivity
import com.google.firebase.auth.PhoneAuthCredential
interface AuthInterface {
    fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential)
}




