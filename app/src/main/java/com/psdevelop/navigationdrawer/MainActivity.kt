package com.psdevelop.navigationdrawer


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

import android.widget.Toast

import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView



class MainActivity : AppCompatActivity() {

   private lateinit var toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Home"

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

}