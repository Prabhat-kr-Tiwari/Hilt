package com.example.hiltdagger2
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
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

    }
}

//first issue of constructor injection with using the interface

/*
class SomeClass
@Inject
constructor(
    private val SomeInterfaceImpl: SomeInterface
){
    fun doAThing(): String{
        return "Look I got: ${SomeInterfaceImpl.getAThing()}"
    }
}

class SomeInterfaceImpl
@Inject
constructor():SomeInterface{
    override fun getAThing() : String{
        return "A Thing"
    }
}
interface SomeInterface{
    fun getAThing():String
}*/


// second issue
class SomeClass
@Inject
constructor(

    //this is from third party library
    private val gson: Gson
){
    fun doAThing(): String{
        return "something"
    }
}

class SomeInterfaceImpl
@Inject
constructor():SomeInterface{
    override fun getAThing() : String{
        return "A Thing"
    }
}
interface SomeInterface{
    fun getAThing():String
}