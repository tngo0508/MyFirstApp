package edu.fullerton.cpsc411.myfirstapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import edu.fullerton.cpsc411.myfirstapp.R.string.random

// Android extensions import statements for the two views to update
import kotlinx.android.synthetic.main.activity_second.textview_label
import kotlinx.android.synthetic.main.activity_second.textview_random
import java.util.*

class SecondActivity : AppCompatActivity() {

    companion object {
        const val TOTAL_COUNT = "total_count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        showRandomNumber()
    }

    fun showRandomNumber() {
        // Get the count from the intent extras
        val count = intent.getIntExtra(TOTAL_COUNT, 0)

        // Generate the random number
        val random = Random()
        var randomInt = 0
        // Add one because the bound is exclusive
        if (count > 0) {
            randomInt = random.nextInt(count+1)
        }

        // Display the random number
        textview_random.text = Integer.toString(randomInt)

        // Substitute the max value into the string resource
        // for the heading, and update the heading
        textview_label.text = getString(R.string.random_heading, count)
    }
}
