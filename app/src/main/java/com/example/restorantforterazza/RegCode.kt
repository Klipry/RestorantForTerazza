package com.example.restorantforterazza

import android.content.Intent
import android.os.Bundle
import android.text.InputFilter
import android.text.InputFilter.LengthFilter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import java.util.concurrent.TimeUnit


class RegCode : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var sendButton: Button
    private lateinit var codeEditText: EditText
    private lateinit var login: String
    private lateinit var password: String
    private lateinit var userCollection: CollectionReference
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks

    private var verificationId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg_code)

        auth = FirebaseAuth.getInstance()
        userCollection = FirebaseFirestore.getInstance().collection("Users")

        login = "+" + intent.getStringExtra("login")
        password = intent.getStringExtra("password")!!

        sendButton = findViewById(R.id.buttonSend)
        codeEditText = findViewById(R.id.editTextTextSmsCode)
        val filters = arrayOfNulls<InputFilter>(1)
        filters[0] = LengthFilter(6)
        codeEditText.filters = filters


        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                signInWithPhoneAuthCredential(credential)
            }

            override fun onVerificationFailed(e: FirebaseException) {
                Toast.makeText(this@RegCode, "Ошибка при отправке смс", Toast.LENGTH_SHORT).show()
            }

            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken,
            ) {
                this@RegCode.verificationId = verificationId
                Toast.makeText(this@RegCode, "Код отправлен на номер $login", Toast.LENGTH_SHORT).show()
            }
        }

        sendButton.setOnClickListener {
            val code = codeEditText.text.toString().trim()

            if (code.isEmpty()) {
                Toast.makeText(this, "Введите код", Toast.LENGTH_SHORT).show()
            } else {
                val credential = PhoneAuthProvider.getCredential(verificationId!!, code)
                signInWithPhoneAuthCredential(credential)
            }
        }

        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(login)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(this)
            .setCallbacks(callbacks)
            .build()

        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser

                    val userData = hashMapOf(
                        "login" to login,
                        "password" to password
                    )

                    userCollection.document(user!!.uid)
                        .set(userData)
                        .addOnSuccessListener {
                            Toast.makeText(
                                this,
                                "Регистрация успешно завершена",
                                Toast.LENGTH_SHORT
                            ).show()
                            finish()
                        }
                        .addOnFailureListener {
                            Toast.makeText(
                                this,
                                "Ошибка при сохранении данных",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    val intent = Intent(this,UserMainActivity::class.java)
                    startActivity(intent    )
                } else {
                    Toast.makeText(this, "Неверный код", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
