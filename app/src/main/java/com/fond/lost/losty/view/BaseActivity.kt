package com.fond.lost.losty.view

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.fond.lost.losty.R
import com.fond.lost.losty.view.fragments.SideMenu
import kotlinx.android.synthetic.main.base_view.*


/**
 * Created by Sahar on 16/04/2018.
 */
open class BaseActivity : AppCompatActivity(), SideMenu.MenuClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_view)

        putFragment(SideMenu.newInstance(this), R.id.content_frame)
    }

    fun putFragment(fragment : Fragment, xmlNumber : Int)
    {
        val tx = supportFragmentManager.beginTransaction()
        tx?.replace(xmlNumber, fragment)
        tx.commit()
    }

    fun addContentView(xmlNumber : Int)
    {
        val inflater = LayoutInflater.from(this)
        inflater.inflate(xmlNumber, main_frame, true)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.tool_bar_menu, menu)
        return true
    }

    fun toggleMenu(item: MenuItem?) {
        if (drawer_layout.isDrawerOpen(GravityCompat.END)) {
            drawer_layout.closeDrawer(GravityCompat.END)
        } else {
            drawer_layout.openDrawer(GravityCompat.END)
        }
    }

    override fun OnItemClick(v: View) {
        when (v.id) {
            R.id.join -> gotoLogin()
            R.id.my_adds -> "2"
            R.id.share -> share()
            R.id.write_us -> "4"
            R.id.terms_and_conditions -> "5"
        }
        toggleMenu(null)
    }

    fun share()
    {
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(Intent.EXTRA_TEXT,
                "Hey check out my app at: https://play.google.com/store/apps/details?id=com.google.android.apps.plus")
        sendIntent.type = "text/plain"
        startActivity(sendIntent)
    }

    open fun init()
    {
        toolbar_actionbar.setTitle("")
        setSupportActionBar(toolbar_actionbar)
        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar_actionbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        toggle.setDrawerIndicatorEnabled(false);
    }

    override fun onBackPressed() {

        if (drawer_layout.isDrawerOpen(GravityCompat.END)) {
            drawer_layout.closeDrawer(GravityCompat.END)
        }
        else
        {
             if(back())
             {
                 super.onBackPressed()
             }
        }
    }

    private fun gotoLogin() {
        val intent = Intent(this, JoinActivity::class.java)
        startActivity(intent)
    }

    open fun back(): Boolean {
        return true
    }
}