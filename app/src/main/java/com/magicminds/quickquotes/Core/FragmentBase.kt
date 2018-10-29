package com.magicminds.quickquotes.Core

import android.support.v4.app.Fragment
import android.view.animation.Animation

/**
 * Created by saaddar on 10/28/18.
 */
class FragmentBase : android.support.v4.app.Fragment() {

    override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation {
        if (FragmentUtility.sDisableFragmentAnimations) {
            val a = object : Animation() {

            }
            a.duration = 0
            return a
        }
        return super.onCreateAnimation(transit, enter, nextAnim)
    }
}