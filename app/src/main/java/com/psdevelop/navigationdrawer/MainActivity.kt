package com.psdevelop.navigationdrawer


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

import android.widget.Toast

import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import java.util.ArrayList


class MainActivity : AppCompatActivity() {

   private lateinit var toggle : ActionBarDrawerToggle
    private lateinit var newRecyclerView : RecyclerView
    private lateinit var newArrayList : ArrayList<news>
    private lateinit var titleImage : Array<Int>
    private lateinit var heading : Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Home"

        titleImage = arrayOf(
            R.drawable.photo11,
            R.drawable.aa,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.k,







            )
        heading = arrayOf(

            "I am very excited because this is my first recycler view app and i am trying to make it good",
            "I am very excited because this is my first recycler view app and i am trying to make it good",
            "I am very excited because this is my first recycler view app and i am trying to make it good",
            "I am very excited because this is my first recycler view app and i am trying to make it good",
            "I am very excited because this is my first recycler view app and i am trying to make it good",
            "I am very excited because this is my first recycler view app and i am trying to make it good",
            "I am very excited because this is my first recycler view app and i am trying to make it good",
            "I am very excited because this is my first recycler view app and i am trying to make it good",
            "I am very excited because this is my first recycler view app and i am trying to make it good",
            "I am very excited because this is my first recycler view app and i am trying to make it good",
            "I am very excited because this is my first recycler view app and i am trying to make it good",
        )


        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)




        newArrayList = arrayListOf<news>()
        getUserdata()



        val drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout)
        val navView : NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout,R.string.open , R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            when (it.itemId){
                R.id.nav_home -> Toast.makeText(applicationContext, "You Clicked On Home", Toast.LENGTH_SHORT).show()
                R.id.nav_setting -> Toast.makeText(applicationContext, "You Clicked On Setting", Toast.LENGTH_SHORT).show()
                R.id.nav_email -> Toast.makeText(applicationContext, "You Clicked On email", Toast.LENGTH_SHORT).show()
                R.id.nav_rate -> Toast.makeText(applicationContext, "You Clicked On Rate", Toast.LENGTH_SHORT).show()
                R.id.nav_donate -> Toast.makeText(applicationContext, "You Clicked On Donate", Toast.LENGTH_SHORT).show()
                R.id.nav_share -> Toast.makeText(applicationContext, "You Clicked On Share", Toast.LENGTH_SHORT).show()
                R.id.nav_logout -> Toast.makeText(applicationContext, "You Clicked On Logout", Toast.LENGTH_SHORT).show()
                R.id.nav_delete -> Toast.makeText(applicationContext, "You Clicked On Delete", Toast.LENGTH_SHORT).show()


            }
            true



        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }
    private fun getUserdata() {

        for (i in titleImage.indices){

            val News = news(titleImage[i] , heading[i])
            newArrayList.add(News)

        }

        var adaptor = MyAdaptor(newArrayList)
        newRecyclerView.adapter = adaptor
        adaptor.setOnItemClickListener((object : MyAdaptor.onItemClickLestener{
            override fun onItemClick(position: Int) {
                Toast.makeText(this@MainActivity, "You Click On Number $position", Toast.LENGTH_SHORT).show()
            }


        }))





    }

}