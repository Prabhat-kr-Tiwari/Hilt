package com.example.hiltdagger2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject
import javax.inject.Singleton


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    //field injection
/*    @Inject
    lateinit var someClass: SomeClass*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      /*  println(someClass.doAThing())*/

    }
}
@AndroidEntryPoint
class MyFragment : Fragment() {
    @Inject
    lateinit var someClass: SomeClass

}

//@Singleton

//@ActivityScoped
//@FragmentScoped

@ActivityScoped
class SomeClass
@Inject
constructor(
) {
    fun doAThing(): String {
        return "look i do a thing"
    }
}

