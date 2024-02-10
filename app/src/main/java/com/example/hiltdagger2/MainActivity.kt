package com.example.hiltdagger2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton


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


class SomeClass
@Inject
constructor(
    private val SomeInterfaceImpl: SomeInterface,
    private val gson: Gson
) {
    fun doAThing(): String {
        return "Look I got: ${SomeInterfaceImpl.getAThing()}"
    }
}

class SomeInterfaceImpl
@Inject
constructor(
    private val someDependency:String
) : SomeInterface {
    override fun getAThing(): String {
        return "A Thing ${someDependency}"
    }
}

interface SomeInterface {
    fun getAThing(): String
}
//solving the problem of creating object of
/*
@InstallIn(SingletonComponent::class)
@Module
abstract class MyModule{
    @Singleton
    @Binds
    abstract fun bindSomeDependency(
        someImpl:SomeInterfaceImpl
    ):SomeInterface

}*/


//  if you insstall something in the activity component then scope must be activityscoped
/*@InstallIn(ActivityComponent::class)
@Module
abstract class MyModule{
    @ActivityScoped
    @Binds
    abstract fun bindSomeDependency(
        someImpl:SomeInterfaceImpl
    ):SomeInterface

    @ActivityScoped
    @Binds
    abstract fun bindGson(
        gson:Gson
    ):Gson

}*/

//using @Provides
@InstallIn(SingletonComponent::class)
@Module
 class MyModule{
    @Singleton
    @Provides
    fun provideSomeString():String{
        return "Some string"
    }

    @Singleton
    @Provides
    fun provideSomeInterface(
        someString: String
    ):SomeInterface{
        return SomeInterfaceImpl(someString)
    }

    @Singleton
    @Provides
    fun provideGson():Gson{
        return Gson()
    }
}


