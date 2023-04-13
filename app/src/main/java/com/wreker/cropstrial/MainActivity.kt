package com.wreker.cropstrial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.wreker.cropstrial.database.Database
import com.wreker.cropstrial.databinding.ActivityMainBinding
import com.wreker.cropstrial.repository.Repository
import com.wreker.cropstrial.viewModel.MyViewModel
import com.wreker.cropstrial.viewModel.MyViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var viewModel1 : MyViewModel
    private lateinit var appBarConfiguration: AppBarConfiguration

    private lateinit var bindin : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindin = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindin.root)

        val repository = Repository(Database.getDatabase(this))
        val viewModelProviderFactory = MyViewModelFactory(repository)
        viewModel1 = ViewModelProvider(this, viewModelProviderFactory).get(MyViewModel::class.java)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf(
                R.id.allCropsFragment,
                R.id.profileFragment
            ),
            drawerLayout = bindin.drawerLayout
        )

        bindin.navView.setupWithNavController(navController)

        setupActionBarWithNavController(navController = navController, configuration = appBarConfiguration)

        bindin.navView.setCheckedItem(
            navController.graph.startDestinationId
        )

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainerView)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}