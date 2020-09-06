package com.algrithmntest.com.primenumberabout

import com.com.ldy.java.Util.ArrayUtils
import java.util.*

/**
 * Created by liudeyu on 2019/10/16.
 */


class PrimeNumberDetect {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val detector = PrimeNumberDetect()
            ArrayUtils.displayArray(detector.detectPrimeNumber(2, 10000))
        }
    }


    fun detectPrimeNumber(start: Int, end: Int): List<Int> {
        val rawNumContainer = ArrayList<Int>()
        val result = ArrayList<Int>()
        var tmp = start
        while (tmp <= end) {
            rawNumContainer.add(tmp++)
        }
        tmp = start
        while (tmp <= end) {
            if (isPrimeNum(tmp)) {
                var mutiplePri = tmp * 2;
                while (mutiplePri <= end) {
                    rawNumContainer.set((mutiplePri - start), -1)
                    mutiplePri = mutiplePri + tmp
                }
            }
            tmp++
        }
        rawNumContainer.forEach({
            if (it != -1) {
                result.add(it)
            }
        })
        return result

    }

    private fun isPrimeNum(testNum: Int): Boolean {
      return false;
    }


}