package com.example.myapplication

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class MainActivity : AppCompatActivity() {

    private var number: Int = 0
    private val logFileName = "lifecycle_log.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logLifecycleEvent("MainActivity onCreate()")
    }

    override fun onStart() {
        super.onStart()
        logLifecycleEvent("MainActivity onStart()")
    }

    override fun onResume() {
        super.onResume()
        logLifecycleEvent("MainActivity onResume()")
    }

    override fun onPause() {
        super.onPause()
        logLifecycleEvent("MainActivity onPause()")
    }

    override fun onStop() {
        super.onStop()
        logLifecycleEvent("MainActivity onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        logLifecycleEvent("MainActivity onDestroy()")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        number++
        logLifecycleEvent("MainActivity onConfigurationChanged(). Number: $number")
    }

    private fun logLifecycleEvent(message: String) {
        val logFile = File(filesDir, logFileName)
        logFile.appendText("$message\n")
    }

    fun goToSecondActivity(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("number", number)
        startActivity(intent)
    }
}