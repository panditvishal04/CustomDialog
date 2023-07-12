package com.vishal.customdialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.vishal.customdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnUpdate.setOnClickListener {
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.custom_dialog)
            dialog.getWindow()?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            var btnOk = dialog.findViewById<Button>(R.id.btn_ok)
            var etName = dialog.findViewById<EditText>(R.id.et_name)
            var etCollege = dialog.findViewById<EditText>(R.id.et_college)
            etName.setText(binding.etN.text.toString())
            etCollege.setText(binding.etC.text.toString())
            btnOk.setOnClickListener {
                binding.etN.setText(etName.text.toString())
                binding.etC.setText(etCollege.text.toString())
                if(etName.text.toString().isEmpty()){
                    etName.error = "Enter your name"
                }else if(etCollege.text.toString().isEmpty()) {
                    etCollege.error = "enter your college name"
                }
                    else{
                        dialog.dismiss()
                    }

                }
                dialog.show()
            }

        binding.btnClear.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Do you want to clear")
                .setMessage("click any option")
                .setCancelable(false)
                .setPositiveButton("Yes"){_,_->
                    binding.etN.setText(" ")
                    binding.etC.setText(" ")
                    Toast.makeText(this, "Yes Clicked", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("No"){_,_->
                    Toast.makeText(this, "No Clicked", Toast.LENGTH_SHORT).show()
                }
                .setNeutralButton("Don't say"){_,_->
                    Toast.makeText(this, "Don't say", Toast.LENGTH_SHORT).show()

                }
                .show()
        }

    }
}

