package ca.sivasai.rolldice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ca.sivasai.rolldice.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var history:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        history="Roll history: "

        binding.roll1.setOnClickListener {
            binding.Dice1Text.text=Roll().toString()
            binding.Dice2Layout.visibility= View.GONE
        }
        binding.roll2.setOnClickListener {
            binding.Dice2Layout.visibility= View.VISIBLE
            binding.Dice1Text.text=Roll().toString()
            binding.Dice2Text.text=Roll().toString()
        }
        binding.createButton.setOnClickListener {
            binding.diceEdit.toString()
        }
    }
    private fun Roll():Int {
        val maxRngValue: Int = binding.diceSpinner.selectedItem.toString().toInt()+1
        val rngNum = Random.nextInt(1, maxRngValue)
        history = history+rngNum+", "
        binding.history.text=history
        return rngNum
    }
}