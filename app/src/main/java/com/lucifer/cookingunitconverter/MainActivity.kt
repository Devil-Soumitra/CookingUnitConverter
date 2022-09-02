package com.lucifer.cookingunitconverter

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.content.ContextCompat.getSystemService
import com.lucifer.cookingunitconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.convertUnit.setOnClickListener{ calculateUnit() }
        binding.baseUnit.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode) }
}

    private fun calculateUnit() {
        val stringInTextField = binding.baseUnit.text.toString()
        val unitProvide = stringInTextField.toDoubaleOrNull()

        if (unitProvide == null || unitProvide == 0.0) {
            displayUnit(0.0)
            return
        }

        val convater = if (binding.baseUnitGroup.checkedRadioButtonId == R.id.unit_cup && binding.convertedUnitGroup.checkedRadioButtonId == R.id.converted_unit_gm) {
            convater(123)
        }
        else

        val baseUnitName = when (binding.baseUnitGroup.checkedRadioButtonId) {
            R.id.unit_gm -> R.string.gm
            R.id.unit_kg -> R.string.kg
            R.id.unit_cup -> R.string.cup
            R.id.unit_teaspoon -> R.string.Teaspoon
            R.id.unit_tablespoon -> R.string.tablespoon
            R.id.unit_li -> R.string.li
            else -> R.string.ml
        }

        val convertedUnitName = when (binding.convertedUnitGroup.checkedRadioButtonId) {
            R.id.converted_unit_gm -> R.string.gm
            R.id.converted_unit_kg -> R.string.kg
            R.id.converted_unit_cup -> R.string.cup
            R.id.converted_unit_teaspoon -> R.string.Teaspoon
            R.id.converted_unit_tablespoon -> R.string.tablespoon
            R.id.converted_unit_li -> R.string.li
            else -> R.string.ml
        }
    }

    private fun handleKeyEvent (view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }


}
