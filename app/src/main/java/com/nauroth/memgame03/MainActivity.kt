package com.nauroth.memgame03

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tblLayout1: TableLayout
    private lateinit var tblLayout2: TableLayout

    override fun onClick(view: View?) {
        val btn = view as Button
        if (btn.text == "Switch to Layout 2") {
            setContentView(tblLayout2)
        } else {
            setContentView(tblLayout1)
        }
    }

    private fun createLayout(text: String): TableLayout {
        val tblLayout = TableLayout(this)
        val tblRow = TableRow(this)

        val btn = Button(this).apply {
            this.text = text
            setOnClickListener(this@MainActivity)
        }

        val txtView = TextView(this).apply {
            this.text = text
            textAlignment = View.TEXT_ALIGNMENT_CENTER
        }

        tblRow.addView(btn)
        tblRow.addView(txtView)
        tblLayout.addView(tblRow)

        return tblLayout
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tblLayout1 = createLayout("Switch to Layout 2")
        tblLayout2 = createLayout("Switch to Layout 1")
        setContentView(tblLayout1)
        // setContentView(R.layout.activity_main)
    }
}
