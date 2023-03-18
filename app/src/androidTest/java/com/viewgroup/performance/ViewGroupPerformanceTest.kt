package com.viewgroup.performance

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.system.measureNanoTime

@RunWith(AndroidJUnit4::class)
class ViewGroupPerformanceTest {

    private val layoutInflater by lazy { LayoutInflater.from(getInstrumentation().targetContext) }

    @Test
    fun test_case1() {
        Log.i(TAG, "test case 1")
        Log.i(TAG, "$CONSTRAINT ${measureTime(R.layout.test_case1_constraint)}")
        Log.i(TAG, "$LINEAR ${measureTime(R.layout.test_case1_linear)}")
    }

    @Test
    fun test_case2() {
        Log.i(TAG, "test case 2")
        Log.i(TAG, "$CONSTRAINT ${measureTime(R.layout.test_case2_constraint)}")
        Log.i(TAG, "$LINEAR ${measureTime(R.layout.test_case2_linear)}")
        Log.i(TAG, "$FRAME ${measureTime(R.layout.test_case2_frame)}")
    }

    @Test
    fun test_case3() {
        Log.i(TAG, "test case 3")
        Log.i(TAG, "$CONSTRAINT ${measureTime(R.layout.test_case3_constraint)}")
        Log.i(TAG, "$LINEAR ${measureTime(R.layout.test_case3_linear)}")
        Log.i(TAG, "$RELATIVE ${measureTime(R.layout.test_case3_relative)}")
    }

    @Test
    fun test_case4() {
        Log.i(TAG, "test case 4")
        Log.i(TAG, "$CONSTRAINT ${measureTime(R.layout.test_case4_constraint)}")
        Log.i(TAG, "$LINEAR ${measureTime(R.layout.test_case4_linear)}")
    }

    private fun measureTime(@LayoutRes layoutRes: Int): Long {
        return measureTimeInNano(layoutRes) / REPEATS
    }

    private fun measureTimeInNano(@LayoutRes layoutRes: Int) = measureNanoTime {
        for (i in 0 until REPEATS) {
            layoutInflater.inflate(layoutRes, null).apply {
                layoutParams = ViewGroup.LayoutParams(0, 0)
                measure(
                    View.MeasureSpec.makeMeasureSpec(1000, View.MeasureSpec.EXACTLY),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
                )
                layout(0, 0, measuredWidth, measuredHeight)
            }
        }
    }

    companion object {
        private const val TAG = "---->"
        private const val REPEATS = 1_000
        private const val LINEAR = "----> linear:\t\t"
        private const val FRAME = "----> frame:\t\t\t"
        private const val RELATIVE = "----> relative:\t\t"
        private const val CONSTRAINT = "----> constraint:\t"
    }
}
