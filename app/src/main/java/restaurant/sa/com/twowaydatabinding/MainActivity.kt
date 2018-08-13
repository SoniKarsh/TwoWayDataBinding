package restaurant.sa.com.twowaydatabinding

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import restaurant.sa.com.twowaydatabinding.databinding.ActivityMainBinding
import restaurant.sa.com.twowaydatabinding.model.Data
import restaurant.sa.com.twowaydatabinding.viewmodel.DataBindingViewModel

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity";
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = Data()

        val dataBindingViewModel = DataBindingViewModel(this, data)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.data = data
        Log.d(TAG, "onCreate: ");
        binding.dataBindingModel = dataBindingViewModel
//        binding.setVariable(BR.dataBindingModel, binding.dataBindingModel)
//        binding.executePendingBindings()

    }
}
