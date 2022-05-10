package com.example.boltapplication.Activities

import android.Manifest
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.OpenableColumns
import android.view.View
import android.widget.ImageView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.ContextCompat
import com.example.boltapplication.R
import java.io.File

class TakephotoActivity : AppCompatActivity() {
    private lateinit var takePhoto: ImageView
    private lateinit var imageView: ImageView
    private lateinit var cameraIcon: ImageView
    private var isCamera: Boolean = true
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private var currentImagePath: String? = null
    private var our_request_code: Int = 123

    companion object {
        private const val IMAGE_PICK_CODE = 1000
        private const val CAMERA_REQUEST = 1888

    }
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_takephoto)
        takePhoto = findViewById(R.id.takephoto)
        imageView = findViewById(R.id.imageview)
        cameraIcon = findViewById(R.id.cameraicon)
        takePhoto.setOnClickListener {
            val intent = Intent(this, RideCompletedActivity::class.java)
            startActivity(intent)
        }
        cameraIcon.setOnClickListener {

                //intent to open camera app
                takephoto(view = View(this))
                cameraIcon.visibility= View.GONE

            }
        }

    fun takephoto(view: View) {

        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(cameraIntent, our_request_code)
        }
    }
       override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){
           super.onActivityResult(requestCode, resultCode, data)
           if (requestCode == our_request_code && resultCode == RESULT_OK){
               val imageView: ImageView = findViewById(R.id.imageview)
               val bitmap = data?.extras?.get("data") as Bitmap
               imageView.setImageBitmap(bitmap)
           }
       }

    }







//    private fun openCamera() {
//        isCamera = true
//        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//        resultLauncher.launch(intent)
//    }
//    @RequiresApi(Build.VERSION_CODES.M)
//    private fun askCameraPermission() {
//        if (ContextCompat.checkSelfPermission(
//                this,
//                Manifest.permission.CAMERA
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            requestPermissions(arrayOf(Manifest.permission.CAMERA), Companion.CAMERA_REQUEST)
//
//        } else {
//            openCamera()
//        }
//    }
//    private var resultLauncher =
//        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//            if (result.resultCode == RESULT_OK) {
//                // There are no request codes
//                if (isCamera) {
//                    val data = result.data
//                    val bitmap: Bitmap = data?.extras?.get("data") as Bitmap
//                    imageView.setImageBitmap(bitmap)
//                } else {
//                    val data: Intent? = result.data
//                    val uri: Uri? = data?.data
//                    val inputStream =this.contentResolver.openInputStream(uri!!)
//                    val cursor = this.contentResolver.query(uri, null, null, null, null)
//                    cursor?.use { c ->
//                        val nameIndex = c.getColumnIndex(OpenableColumns.DISPLAY_NAME)
//                        if (c.moveToFirst()) {
//                            val name = c.getString(nameIndex)
//                            inputStream?.let { inputStream ->
//                                // create same file with same name
//                                val file = File(this.cacheDir, name)
//                                val os = file.outputStream()
//                                os.use {
//                                    inputStream.copyTo(it)
//                                }
//                                val options: BitmapFactory.Options = BitmapFactory.Options()
//                                options.inSampleSize = 3
//                                var bitmap = BitmapFactory.decodeFile(file.absolutePath, options)
//                                imageView.setImageBitmap(bitmap)
//
//                            }
//                        }
//                    }
//                }
//            }
//        }



