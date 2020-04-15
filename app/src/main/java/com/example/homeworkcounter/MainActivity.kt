package com.example.homeworkcounter

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val LOG_TAG = MainActivity::class.java.simpleName
    val EXTRA_MESSAGE = "com.example.homeworkcounter.extra.MESSAGE"
    val TEXT_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(LOG_TAG, "-------")
        Log.d(LOG_TAG, "onCreate")

        buttonCount.setOnClickListener {
            var count = textViewCount.text.toString().toInt()
            count++
            textViewCount.text = count.toString()
        }
    }

    fun launchSecondActivity(view: View?) {
        Log.d(LOG_TAG, "Button clicked!")
        val intent = Intent(this, SecondActivity::class.java)
        val message: String = mMessageEditText.text.toString()
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivityForResult(intent, TEXT_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                if(data != null){
                    val reply = data.getStringExtra("EXTRA_REPLY")
                    mReplyHeadTextView.visibility = View.VISIBLE
                    mReplyTextView.text = reply
                    mReplyTextView.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume")
    }
    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop")
    }
    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy")
    }

}

//region Answers

//Questions 1 -
//Questions 2 -
//Questions 3 -
//Questions 4 -

//endregion
