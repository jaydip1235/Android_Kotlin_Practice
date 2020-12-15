package com.example.login_ui

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.*
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern


class MainActivity : AppCompatActivity() {
        private val PASSWORD_PATTERN: Pattern = Pattern.compile(
            "^" +
                    "(?=.*[a-zA-Z])" +  //any letter
                    ".{4,}" +  //at least 4 characters
                    "$"
    )
    private val NAME_PATTERN : Pattern = Pattern.compile(
            "^" +
                    "(?=.*[a-zA-Z])"
    )
    private var password: TextInputLayout? = null
    private var confirmPassword: TextInputLayout? = null
    var textname: TextView? = null
    var textpassword : TextView? = null
    var textcpass : TextView? = null
    var textmail : TextView? = null
    var name: EditText? = null
    var email: EditText? = null
    var img : ImageView? = null
    var welcome :  TextView? = null
    var button : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textname = findViewById<TextView>(R.id.nameText)
        email = findViewById<EditText>(R.id.email)
        name = findViewById<EditText>(R.id.name)
        textpassword = findViewById<TextView>(R.id.passText)
        textcpass = findViewById<TextView>(R.id.cpassText)
        textmail = findViewById<TextView>(R.id.emailText)
        password = findViewById<TextInputLayout>(R.id.password);
        confirmPassword = findViewById<TextInputLayout>(R.id.confirmPassword)
        img = findViewById<ImageView>(R.id.imageView4)
        welcome = findViewById<TextView>(R.id.welome)
        button =  findViewById<Button>(R.id.button)

    }
    private fun validatePassword(): Boolean {
         val p = password!!.editText!!.text.toString().trim { it <= ' ' }
        return if (p.isEmpty()) {
            password!!.error = "Field can't be empty"
            false
        } else if (!PASSWORD_PATTERN.matcher(p).matches()) {
            password!!.error = "At least 4 alphabets req."
            false
        } else {
            password!!.error = null
            true
        }
    }
    private fun validateconfirmPassword(): Boolean {
        val p = confirmPassword!!.editText!!.text.toString().trim { it <= ' ' }
        return if (p.isEmpty()) {
            confirmPassword!!.error = "Field can't be empty"
            false
        } else if (!p.equals(password!!.editText!!.text.toString().trim { it <= ' ' })) {
            confirmPassword!!.error = "Password doesn't match"
            false
        } else {
            confirmPassword!!.error = null
            true
        }
    }
    private fun validateEmail(): Boolean {
        val emailInput = email?.text.toString()
        return if (emailInput.isEmpty()) {
            Toast.makeText(this,"Email Field cannot be empty", LENGTH_LONG).show()
            false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            Toast.makeText(this,"please Enter a valid email address", LENGTH_LONG).show()
            false
        } else {
            true
        }
    }
    private fun validateName(): Boolean {
        val nameInput = name?.text.toString()
        return if (nameInput.isEmpty()) {
            Toast.makeText(this,"Name Field cannot be empty", LENGTH_LONG).show()
            false
        }  else {
            true
        }
    }
    fun confirm(v: View?) {
        if ( !validatePassword() or !validateconfirmPassword() or !validateEmail() or !validateName()) {
         return
        }
        else
        {
            password?.setVisibility(View.INVISIBLE)
            email?.setVisibility(View.INVISIBLE)
            name?.setVisibility(View.INVISIBLE)
           textname?.setVisibility(View.INVISIBLE)
            textpassword?.setVisibility(View.INVISIBLE)
            textcpass?.setVisibility(View.INVISIBLE)
            textmail?.setVisibility(View.INVISIBLE)
            password?.setVisibility(View.INVISIBLE)
            confirmPassword?.setVisibility(View.INVISIBLE)
            button?.setVisibility(View.INVISIBLE)
            var text = "Welcome ${name?.text.toString()}"
            welcome?.text=text
            welcome?.setVisibility(View.VISIBLE)
           img?.setVisibility(View.VISIBLE)

            Toast.makeText(this, "Login success", LENGTH_LONG).show()
        }
    }
}