package com.communisolve.runningtrackerapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.communisolve.runningtrackerapp.Database.RunDao
import com.communisolve.runningtrackerapp.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

private const val TAG = "MainActivity"
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        bottomNavigationView.setupWithNavController(navHostFragment.findNavController())

        navHostFragment.findNavController()
            .addOnDestinationChangedListener { controller, destination, arguments ->
                when(destination.id){
                    R.id.settingsFragment,R.id.statisticsFragment, R.id.runFragment ->{
                        bottomNavigationView.visibility = View.VISIBLE
                    }else ->{
                    bottomNavigationView.visibility = View.GONE
                }
                }
            }
    }


}