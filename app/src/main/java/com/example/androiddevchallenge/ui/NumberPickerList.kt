package com.example.androiddevchallenge.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.formatTime
import kotlinx.coroutines.launch

/**
 *  @author: LXL
 *  @description: description
 *  @date: 2021/3/5 11:50
 */

@Composable
fun NumberPickerList(numbers: List<Int>, selectedItem: (Int) -> Unit) {
    val listState = rememberLazyListState(0, 0)
    val coroutineScope = rememberCoroutineScope()

    val isScrollInProgress = remember { derivedStateOf { listState.isScrollInProgress } }
    val firstVisibleItemIndex = remember { derivedStateOf { listState.firstVisibleItemIndex } }
    val firstVisibleItemScrollOffset =
        remember { derivedStateOf { listState.firstVisibleItemScrollOffset } }

    val textSizeState = remember { mutableStateOf(22.sp) }

    Box(modifier = Modifier.width(40.dp).height(96.dp)) {
        LazyColumn(
            state = listState
        ) {
            itemsIndexed(items = numbers) { index, item ->
                if (index == 0 || index == numbers.size - 1) {
                    Spacer(
                        modifier = Modifier.fillMaxWidth().height(32.dp),
                    )
                } else {
                    if (firstVisibleItemIndex.value != item) {
                        textSizeState.value = 18.sp
                    } else {
                        textSizeState.value = 22.sp
                        selectedItem(item)
                    }
                    Text(
                        text = formatTime(value = item),
                        fontSize = textSizeState.value,
                        modifier = Modifier.height(32.dp).fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        if (!isScrollInProgress.value) {
            coroutineScope.launch {
                // 85
                if (firstVisibleItemScrollOffset.value < 85 / 2) {
                    if (listState.layoutInfo.totalItemsCount == 0)
                        return@launch
                    listState.animateScrollToItem(index = firstVisibleItemIndex.value)
                } else {
                    listState.animateScrollToItem(index = firstVisibleItemIndex.value + 1)
                }
            }
        }
    }
}