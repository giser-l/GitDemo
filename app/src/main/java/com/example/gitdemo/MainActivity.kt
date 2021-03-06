package com.example.gitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private var number = 0
    private lateinit var button: Button
    private lateinit var buttonSub:Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.buttonAdd)
        buttonSub = findViewById(R.id.buttonSub)
        textView = findViewById(R.id.textView)
        number = savedInstanceState?.getInt("NUMBER") ?: 0

        textView.text = "$number"
        button.setOnClickListener {
            textView.text = "${++number}"
        }
        buttonSub.setOnClickListener {
            textView.text = "${--number}"
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menuReset){
            number = 0
            textView.text = "$number"
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("NUMBER",number)
    }
}