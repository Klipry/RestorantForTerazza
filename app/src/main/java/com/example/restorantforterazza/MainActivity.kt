package com.example.restorantforterazza
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val regButton:Button = findViewById(R.id.buttonRegestration)
        val joinButton:Button=findViewById(R.id.buttonLogIn)
        val sharedPref = getSharedPreferences("myAppPreferences", Context.MODE_PRIVATE)
        val isUserLoggedIn = sharedPref.getBoolean("isUserLoggedIn", false)

        if (isUserLoggedIn) {
            val intent = Intent(this, UserMainActivity::class.java)
            startActivity(intent)
            finish()
        }


        regButton.setOnClickListener {

            val loginEditText: EditText = findViewById(R.id.phoneEditText)
            val passwordEditText: EditText = findViewById(R.id.editTextTextPassword)
            val password = passwordEditText.text.toString()
            val login = loginEditText.text.toString()
            if (login.length==11 && password.length>6) {
                val collectionName = "Users"
                val db = FirebaseFirestore.getInstance()
                val fieldName = "login"
                val loginValue = "+" + loginEditText.text.toString()
                if (login.length > 10) {

                    db.collection(collectionName)
                        .whereEqualTo(fieldName, loginValue).get()
                        .addOnSuccessListener { document ->
                            if (document.size() > 0) {
                                // Документ с таким логином уже существует
                                Toast.makeText(
                                    this,
                                    "Пользователь уже зарегистрирован",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                // Документ с таким логином не существует
                                val intent = Intent(this, RegCode::class.java)
                                intent.putExtra("login", login)
                                intent.putExtra("password", password)
                                startActivity(intent)
                            }
                        }
                        .addOnFailureListener { exception ->
                            Log.w(TAG, "Ошибка получения документа", exception)
                        }
                } else {
                    Toast.makeText(
                        this,
                        "Номер введен не корректно.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }else{
                Toast.makeText(
                    this,
                    "Номер и пароль введены не коректно",
                    Toast.LENGTH_SHORT).show()

            }
        }
        joinButton.setOnClickListener {
            val sharedPref = getSharedPreferences("myAppPreferences", Context.MODE_PRIVATE)
            with (sharedPref.edit()) {
                putBoolean("isUserLoggedIn", true)
                commit()
            }

            val loginEditText = findViewById<EditText>(R.id.phoneEditText)
            val passwordEditText = findViewById<EditText>(R.id.editTextTextPassword)
            val login = "+"+loginEditText.text.toString()
            val password = passwordEditText.text.toString()

            val usersCollection = FirebaseFirestore.getInstance().collection("Users")
            val query = usersCollection.whereEqualTo("login", login)

            query.get().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val querySnapshot = task.result
                    if (!querySnapshot.isEmpty) {
                        for (document in querySnapshot) {
                            val storedPassword = document.getString("password")
                            if (password == storedPassword) {
                                // Перейти на следующую активность
                                val intent = Intent(this, UserMainActivity::class.java)
                                val sharedPref = getSharedPreferences("myAppPreferences", Context.MODE_PRIVATE)
                                with (sharedPref.edit()) {
                                    putBoolean("isUserLoggedIn", true)
                                    putString("login", login)
                                    commit()
                                }

                                startActivity(intent)
                                return@addOnCompleteListener
                            } else {
                                Toast.makeText(this, "Пароль не верный", Toast.LENGTH_SHORT).show()
                                return@addOnCompleteListener
                            }
                        }
                    } else {
                        Toast.makeText(this, "Номер не зарегистрирован", Toast.LENGTH_SHORT).show()
                        return@addOnCompleteListener
                    }
                } else {
                    Log.e(TAG, "Error getting documents: ", task.exception)
                }
            }
        }


    }

}

