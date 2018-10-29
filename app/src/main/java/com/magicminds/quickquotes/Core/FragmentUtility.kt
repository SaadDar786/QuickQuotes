package com.magicminds.quickquotes.Core
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.magicminds.quickquotes.R


/**
 * Created by saaddar on 10/28/18.
 */
class FragmentUtility {

    companion object {

        var sDisableFragmentAnimations = false

        fun  replaceFragment(fragment: Fragment, fragmentManager: FragmentManager, resourceId: Int,
                             tag: String, addtoBackStack: Boolean, animate: Boolean) {

            val fragmentTransaction = fragmentManager.beginTransaction()

            if (addtoBackStack)
                fragmentTransaction.addToBackStack(tag)

            if (animate)
                fragmentTransaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right)

            fragmentTransaction.replace(resourceId, fragment, tag)
            fragmentTransaction.commit()


        }

        fun replaceFragment(fragment: Fragment, fragmentManager: FragmentManager,
                            tag: String, addtoBackStack: Boolean) {

            FragmentUtility.replaceFragment(fragment, fragmentManager, R.id.mainLayout, tag, addtoBackStack, true)
        }

        fun popFragemnt(fragmentManager: FragmentManager, tag: String, animate: Boolean) {

            if (animate)
                fragmentManager.popBackStack(tag, 1)
            else {
                FragmentUtility.popBackStackWithoutAnimation(fragmentManager)
            }
        }

        fun popBackStackWithoutAnimation(fragmentManager: FragmentManager) {
            FragmentUtility.sDisableFragmentAnimations = true
            fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            FragmentUtility.sDisableFragmentAnimations = false
        }
    }


}