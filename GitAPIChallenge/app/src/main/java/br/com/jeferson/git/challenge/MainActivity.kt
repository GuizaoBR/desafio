package br.com.jeferson.git.challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import br.com.jeferson.git.challenge.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<MainActivityBinding>(this, R.layout.main_activity)
        drawerLayout = binding.drawerLayout
        val navController = supportFragmentManager.findFragmentById(R.id.fragment_container)?.findNavController()

        navController?.let {
            NavigationUI.setupActionBarWithNavController(this, it, drawerLayout)
            appBarConfiguration = AppBarConfiguration(it.graph, drawerLayout)
            it.addOnDestinationChangedListener { nc: NavController, nd: NavDestination, _: Bundle? ->
                if (nd.id == nc.graph.startDestination) {
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
                } else {
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
                }
            }
            NavigationUI.setupWithNavController(binding.navigationView, it)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = supportFragmentManager.findFragmentById(R.id.fragment_container)?.findNavController()
        return navController?.let { NavigationUI.navigateUp(it, appBarConfiguration) } ?: false
    }
}