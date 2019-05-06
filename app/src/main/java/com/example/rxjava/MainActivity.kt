package com.example.rxjava

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.bean1.PersonRespon
import com.example.bean2.Person
import com.example.bean2.Plan
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_map.setOnClickListener {
            flatMap()
        }
    }

    private fun map() {

        Observable.just(1, 2, 3, 4, 5)
            .map { int -> "$int" }
            .subscribe(object : Observer<String> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: String) {
                    Log.d("onNext", "$t")
                }

                override fun onError(e: Throwable) {

                }
            })
    }

    private fun flatMap() {
        val nameList = listOf<String>("张三", "李四", "王五")
        Observable.just(nameList)
            .flatMap { list ->
                Observable.fromIterable(list)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<String> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: String) {
                    Toast.makeText(this@MainActivity, "$t", Toast.LENGTH_SHORT).show()
                }

                override fun onError(e: Throwable) {

                }
            })
    }
}
