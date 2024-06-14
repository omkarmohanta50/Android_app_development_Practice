package com.example.mycalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mycalculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnAc.setOnClickListener {
            binding.inputText.text =""
            binding.outputText.text = ""
        }
        binding.btnzero.setOnClickListener {

            binding.inputText.append("0")
        }
        binding.btnone.setOnClickListener {
            binding.inputText.append("1")
        }
        binding.btntwo.setOnClickListener {
            binding.inputText.append("2")
        }
        binding.btnthree.setOnClickListener {
            binding.inputText.append("3")
        }

        binding.btnfour.setOnClickListener {
            binding.inputText.append("4")
        }
        binding.btnfive.setOnClickListener {
            binding.inputText.append("5")
        }
        binding.btnsix.setOnClickListener {
            binding.inputText.append("6")
        }
        binding.btnseven.setOnClickListener {
            binding.inputText.append("7")
        }
        binding.btneight.setOnClickListener {
            binding.inputText.append("8")
        }
        binding.btnnine.setOnClickListener {
            binding.inputText.append("9")
        }
        binding.btnbracketstart.setOnClickListener {
            binding.inputText.append("(")
        }
        binding.btnbracketclose.setOnClickListener {
            binding.inputText.append(")")
        }
        binding.btnDivide.setOnClickListener {
            binding.inputText.append("/")
        }
        binding.btnmultiply.setOnClickListener {
            binding.inputText.append("*")
        }
        binding.btnplus.setOnClickListener {
            binding.inputText.append("+")
        }
        binding.btnminus.setOnClickListener {
            binding.inputText.append("-")
        }
        binding.btndot.setOnClickListener {
            binding.inputText.append(".")
        }

        binding.btnequals.setOnClickListener {
            val expression = ExpressionBuilder(binding.inputText.text.toString()).build()

            val result = expression.evaluate()
            val longResult = result.toLong()

            if (result == longResult.toDouble()){
                binding.outputText.text = longResult.toString()
            }
            else{
                binding.outputText.text = result.toString()
            }
        }
    }
}