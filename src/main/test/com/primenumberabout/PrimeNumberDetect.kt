package com.algrithmntest.com.primenumberabout

import java.util.*

/**
 * Created by liudeyu on 2019/10/16.
 */

class PrimeNumberDetect {


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
        if (testNum <= 1) {
            return false;
        }
        var tStart = 2;
        val tSqrt = Math.sqrt(testNum.toDouble()).toInt();
        while (tStart <= tSqrt) {
            if (testNum % tStart == 0) {
                return false
            }
            tStart = tStart + 1
        }
        return true
    }


}