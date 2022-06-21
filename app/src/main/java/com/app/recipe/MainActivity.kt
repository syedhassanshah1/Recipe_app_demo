package com.app.recipe

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.app.recipe.databinding.ActivityMainBinding
import com.app.recipe.screens.searchRecipe.SearchRecipeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var viewBinding: ActivityMainBinding? = null

    val mTitleBar
        get() = viewBinding?.headerMain

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewBinding?.isDataLoading = false
        initListeners()
        initApp()
    }

    private fun initApp() {
        navigateTo(SearchRecipeFragment())
    }

    fun showLoader(loading: Boolean) {
        viewBinding?.isDataLoading = loading
    }

    private fun initListeners() {
        mTitleBar?.let {
            it.setBackButtonListener {
                onBackPressed()
            }
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) super.onBackPressed() else finish()
    }
    fun navigateTo(destination: Fragment) {
        val transaction = supportFragmentManager
                .beginTransaction()
        transaction
                .replace(R.id.fragmentContainer, destination)
                .addToBackStack(if (supportFragmentManager.backStackEntryCount == 0) "firstFragment" else null)
                .commit()
    }

    /**
     * @param entryIndex is the index of fragment to be popped to, for example the
     * first fragment will have a index 0;
     */
    fun popBackStackTillEntry(entryIndex: Int) {
        if (supportFragmentManager.backStackEntryCount <= entryIndex) return
        val entry = supportFragmentManager.getBackStackEntryAt(
                entryIndex)
        supportFragmentManager.popBackStack(entry.id,
                FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    fun popFragment() {
        supportFragmentManager.popBackStack()
    }

}
