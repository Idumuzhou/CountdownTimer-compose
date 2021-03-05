package com.example.androiddevchallenge

/**
 *  @author: LXL
 *  @description: description
 *  @date: 2021/3/5 11:46
 */

fun formatTime(isLeadingZeroNeeded: Boolean = false, value: Int): String {
    return if (isLeadingZeroNeeded)
        String.format("%02d", value)
    else
        String.format("%2d", value)
}