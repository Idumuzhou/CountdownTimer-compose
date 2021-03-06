/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
