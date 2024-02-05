package com.example.hiltdagger2
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    //field injection
    @Inject
    lateinit var someClass: SomeClass
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println(someClass.doAThing())
        println(someClass.doSomeOtherThing())
    }
}

class SomeClass
@Inject
constructor(
    private val someOtherClass: SomeOtherClass
){
    fun doAThing():String{
        return "look i do a thing"
    }

    fun doSomeOtherThing():String{
        return someOtherClass.doSomeOtherThing()
    }
}

class SomeOtherClass
@Inject
constructor(){

    fun doSomeOtherThing():String{
        return "look Doing some other thing"
    }
}