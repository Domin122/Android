package com.example.dialog
import android.app.ProgressDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun OknoDialogowe(v: View) {
        val progressDialog = ProgressDialog(this)
        progressDialog.setCancelable(false)
        progressDialog.setIcon(R.mipmap.ic_launcher)
        progressDialog.setTitle("Pobieram dane...")
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)

        progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK") { dialog, which ->
            Toast.makeText(baseContext, "Kliknięto OK", Toast.LENGTH_SHORT).show()
        }

        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Anuluj") { dialog, which ->
            Toast.makeText(baseContext, "Kliknięto Anuluj", Toast.LENGTH_SHORT).show()
        }
            Thread {
                for (i in 1..10) {
                    try {
                           progressDialog.incrementProgressBy(10)
                           Thread.sleep(1000)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
                progressDialog.dismiss()
            }.start()

        progressDialog.show()
    }
}




