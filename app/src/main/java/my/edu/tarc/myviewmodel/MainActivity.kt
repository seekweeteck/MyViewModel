package my.edu.tarc.myviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    //private var counter = 0
    private lateinit var textViewCounter: TextView

    //Create an instance of ViewModel
    private lateinit var counterViewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("onCreate", "On Create")

        //Initialize a ViewModel
        counterViewModel = ViewModelProvider(this).get(CounterViewModel::class.java)

        textViewCounter = findViewById(R.id.textViewCounter)
        //textViewCounter.text = counter.toString()
        textViewCounter.text = counterViewModel.globalCounter.toString()

        val buttonIncrease = findViewById<Button>(R.id.buttonIncrease)
        buttonIncrease.setOnClickListener {
            //counter++
            counterViewModel.increaseCounter()
            textViewCounter.text = counterViewModel.globalCounter.toString()
        }

        val buttonDecrease = findViewById<Button>(R.id.buttonDecrease)
        buttonDecrease.setOnClickListener {
            //counter--
            counterViewModel.decreaseCounter()
            textViewCounter.text = counterViewModel.globalCounter.toString()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("onDestroy", "On Destroy")
    }
}