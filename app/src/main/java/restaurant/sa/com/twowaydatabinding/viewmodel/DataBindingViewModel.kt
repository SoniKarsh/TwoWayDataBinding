package restaurant.sa.com.twowaydatabinding.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.util.Log
import restaurant.sa.com.twowaydatabinding.BR
import restaurant.sa.com.twowaydatabinding.model.Data
import java.util.*
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.content.Intent
import android.view.View
import restaurant.sa.com.twowaydatabinding.DataApp
import restaurant.sa.com.twowaydatabinding.datalistview.DataActivity
import kotlin.collections.ArrayList

class DataBindingViewModel(val context: Context, private val data: Data): Observer, BaseObservable() {

    private val TAG = "DataBindingViewModel"
    private var dataList: MutableLiveData<List<Data>>? = null
    private var listOfData: ArrayList<Data> = ArrayList()
    var dataToStore : Data = Data()
    
    init {
        data.addObserver(this)
    }

//    fun getDataList(): LiveData<List<Data>> {
//        if (dataList == null) {
//            dataList = MutableLiveData<Any>()
//            loadData()
//        }
//        return dataList!!
//    }

//    fun loadData(){
//        val myHandler = Handler()
//        myHandler.postDelayed({
//            val dataStringList = ArrayList()
//            fruitsStringList.add("Mango")
//            fruitsStringList.add("Apple")
//            fruitsStringList.add("Orange")
//            fruitsStringList.add("Banana")
//            fruitsStringList.add("Grapes")
//            val seed = System.nanoTime()
//            Collections.shuffle(fruitsStringList, Random(seed))
//
//            fruitList.setValue(fruitsStringList)
//        }, 5000)
//    }

    val name: String
        @Bindable get() {
            dataToStore.firstName = data.firstName
            dataToStore.lastName = data.lastName
            return data.firstName + " " + data.lastName
        }

    override fun update(o: Observable?, p1: Any?) {
        if (p1 is String) {
            if (p1 == "firstName" || p1 == "lastName") {
                notifyPropertyChanged(BR.name)
            }
        }
    }

    fun onAddClick(view: View){
        DataApp.database!!.dataDao().insertData(dataToStore)
    }

    fun onSeeList(view: View){
        listOfData = DataApp.database!!.dataDao().getAll() as ArrayList<Data>
        Log.d(TAG, "onSeeList: ${DataApp.database!!.dataDao().getAll()}")
        context.startActivity(Intent(context, DataActivity::class.java).putExtra("LIST", listOfData))
    }

}