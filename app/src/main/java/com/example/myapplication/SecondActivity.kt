package com.example.myapplication
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*
import java.io.File

class SecondActivity : AppCompatActivity() {

    private val logFileName = "lifecycle_log.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        logLifecycleEvent("SecondActivity onCreate()")
        val number = intent.getIntExtra("number", 0)
        displaySquaredNumber(number)
    }

    override fun onStart() {
        super.onStart()
        logLifecycleEvent("SecondActivity onStart()")
    }

    override fun onResume() {
        super.onResume()
        logLifecycleEvent("SecondActivity onResume()")
    }

    override fun onPause() {
        super.onPause()
        logLifecycleEvent("SecondActivity onPause()")
    }

    override fun onStop() {
        super.onStop()
        logLifecycleEvent("SecondActivity onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        logLifecycleEvent("SecondActivity onDestroy()")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        logLifecycleEvent("SecondActivity onConfigurationChanged()")
    }

    private fun displaySquaredNumber(number: Int) {
        textView.text = "Squared Number: ${number * number}"
    }

    private fun logLifecycleEvent(message: String) {
        val logFile = File(filesDir, logFileName)
        logFile.appendText("$message\n")
    }
}
