package tech.abed_murad.ahoytask

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


fun AppCompatActivity.toast(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()