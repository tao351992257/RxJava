package com.example.rxjava

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.bean1.Person
import com.example.bean1.PersonRespon
import com.example.bean2.Plan
import io.reactivex.Observable
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

    private fun map2() {

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

    private fun map() {
        var person1 = Person("张三", 25, "say hello")
        var person2 = Person("李四", 25, "say hello")
        var listPerson = ArrayList<Person>()
        listPerson.add(person1)
        listPerson.add(person2)
        Observable.just(listPerson).map(object : Function<List<Person>, PersonRespon> {
            override fun apply(t: List<Person>): PersonRespon {
                if (t.isNotEmpty()) {
                    for (person in t) {
                        Log.d("name", "${person.name}")
                        return PersonRespon(person.name)
                    }
                    t.forEach { person -> Log.d("person.name:", "${person.name}") }
                }
                return PersonRespon("")
            }
        })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<PersonRespon> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: PersonRespon) {
                    Log.d("onNext", "${t.id}")
                }

                override fun onError(e: Throwable) {
                    Log.d("onError", "$e")
                }
            })

    }

    private fun flatMap() {
        var personList = ArrayList<com.example.bean2.Person>()
        val planList1 = ArrayList<Plan>()
        val planList2 = ArrayList<Plan>()
        planList1.add(Plan("张三", "我要去爬山"))
        planList2.add(Plan("李四", "我要去滑雪"))
        personList.add(com.example.bean2.Person("张三", planList1))
        personList.add(com.example.bean2.Person("李四", planList2))
        Observable.fromIterable(personList)
            .flatMap { personList -> Observable.fromIterable(personList.planList) }
            .flatMap { planList -> Observable.fromIterable(planList.actionList) }
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
}
