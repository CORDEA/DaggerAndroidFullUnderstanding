package jp.cordea.daggerandroidfullunderstanding

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.google.android.material.bottomappbar.BottomAppBar
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import jp.cordea.daggerandroidfullunderstanding.ui.add.AddBottomSheetDialogFragment
import jp.cordea.daggerandroidfullunderstanding.ui.menu.MenuBottomSheetDialogFragment
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    private val navController by lazy { findNavController(R.id.main_nav_fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(bar)

        fab.setOnClickListener {
            AddBottomSheetDialogFragment.newInstance().show(supportFragmentManager)
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.createTagFragment -> {
                    bar.navigationIcon = null
                    bar.replaceMenu(R.menu.menu_main_empty)
                    bar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
                }
                else -> {
                    bar.setNavigationIcon(R.drawable.ic_menu_white_24dp)
                    bar.replaceMenu(R.menu.menu_main)
                    bar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            R.id.action_settings -> true
            android.R.id.home -> {
                MenuBottomSheetDialogFragment.newInstance().show(supportFragmentManager)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    override fun onSupportNavigateUp(): Boolean = navController.navigateUp()

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}
