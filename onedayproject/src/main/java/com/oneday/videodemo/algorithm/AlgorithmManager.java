package com.oneday.videodemo.algorithm;

import android.util.Log;

/**
 * 二分法
 * 条件:
 * 1.必须是一个有顺序的数组
 */
public final class AlgorithmManager {
    private static final String TAG = "AlgorithmManager";

    public static int rank(int key, int[] arr) {
        if (arr == null || arr.length <= 0) {
            Log.e(TAG, "err, arr == null || arr.length <= 0");
            return -1;
        }
        int sLocation = 0;
        int eLocation = arr.length - 1;

        while (sLocation < eLocation) {
            int mid = sLocation + (eLocation - sLocation) / 2;
            if (arr[mid] > key){
                eLocation = mid - 1;
            } else if (arr[mid] == key){
                return mid;
            } else {
                sLocation = mid + 1;
            }
        }
        return -1;
    }


}
