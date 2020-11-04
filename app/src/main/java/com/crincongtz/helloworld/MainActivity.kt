package com.crincongtz.helloworld

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_frame_layout.*

const val TAG = "CursoKotlin"
const val KEY_SAVED_NUMBER = "saved_number"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.v(TAG, "onCreate()")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boton1.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }


//        R.layout
//        R.drawable
//        R.dimen
//        R.color
//        R.integer
//        R.bool

    }

    fun counter(view: View) {
        var numero: Int = text_view.text.toString().toInt()
        text_view.text = numero.inc().toString()
    }

    val positiveButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(this, "OK clicked", Toast.LENGTH_SHORT).show()
    }

    fun showAlert(view: View) {
        val builder =  AlertDialog.Builder(this)
        builder.setTitle("Alerta Android!")
        builder.setMessage("Este es un mensaje de advertencia!!")
        builder.setPositiveButton("Ok",
                DialogInterface.OnClickListener(function = positiveButtonClick))
        builder.show()
    }

    override fun onStart() {
        Log.d(TAG, "onStart()")
        super.onStart()
    }

    override fun onResume() {
        Log.i(TAG, "onResume()")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause()")
        super.onPause()
    }

    override fun onStop() {
        Log.w(TAG, "onStop()")
        super.onStop()
    }

    override fun onDestroy() {
        Log.e(TAG, "onDestroy()")
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.w(TAG, "Nuestra aplicacion esta a punto de ser destruida!!")

        val numberToSave = text_view.text
        outState.putCharSequence(KEY_SAVED_NUMBER, numberToSave)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        Log.i(TAG, "Nuestra aplicacion esta siendo recreada...")
        val savedNumber = savedInstanceState.getCharSequence(KEY_SAVED_NUMBER)
        text_view.text = savedNumber
    }
}
