package com.example.boltapplication.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.example.boltapplication.R
import com.google.android.material.bottomsheet.BottomSheetDialog

class PaymentsActivity : AppCompatActivity() {
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var craditCard: View
    private lateinit var viewHide :View
    private lateinit var hideImage: ImageView
    private lateinit var hideCradit : ImageView
    private lateinit var hideTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payments)
        craditCard = findViewById(R.id.setuppayment)
        viewHide= findViewById(R.id.hideview)
        hideImage= findViewById(R.id.hideimage)
        hideCradit= findViewById(R.id.hidecraditcard)
        hideTextView= findViewById(R.id.hidetextview)
        toolbar = findViewById(R.id.toolbar_actionbar4)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val bottomSheetDialog = BottomSheetDialog(this)
        val bottomSheetView = this.layoutInflater.inflate(R.layout.craditcard_bottomsheet, null)
        with(bottomSheetDialog) {
            setContentView(bottomSheetView)
        }
        craditCard.setOnClickListener {
            showDialogNotificationAction(bottomSheetDialog)
                // your code here
               viewHide.visibility= View.GONE
               hideCradit.visibility= View.GONE
               hideImage.visibility= View.GONE
               hideTextView.visibility= View.GONE
            }


        bottomSheetView.findViewById<Button>(R.id.btnforaddcard).setOnClickListener {
            val intent= Intent(this, AddCardActivity::class.java)
            startActivity(intent)
            bottomSheetDialog.dismiss()

        }
    }

    private fun showDialogNotificationAction(bottomSheetDialog: BottomSheetDialog) {
        bottomSheetDialog.show()
        val bottomSheetDialogFrameLayout =
            bottomSheetDialog.findViewById<FrameLayout>(com.google.android.material.R.id.design_bottom_sheet)
        bottomSheetDialogFrameLayout?.background = null
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }
}


