package com.google.samples.apps.nowinandroid.ui.homeworks.homework25.extentions

import android.content.res.Resources.NotFoundException
import android.util.Log
import io.github.kakaocup.compose.node.builder.ViewBuilder
import io.github.kakaocup.compose.node.element.list.KListItemNode
import io.github.kakaocup.compose.node.element.list.KListNode
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import kotlin.math.min

inline fun <reified T : KListItemNode<*>> KListNode.invokeChildAtIndex(
    index: Int,
    function: T.() -> Unit,
) {
    val list = this
    childAt<T>(index) {
        name(list.withParent("$index"))
        function()
    }
}

inline fun <reified T : KListItemNode<*>> KListNode.invokeFirstChild(function: T.() -> Unit) {
    val list = this
    firstChild<T> {
        name(list.withParent("first"))
        function()
    }
}

inline fun <reified T : KListItemNode<*>> KListNode.invokeChildAtMatcher(
    noinline viewBuilderAction: ViewBuilder.() -> Unit,
    description: String,
    function: T.() -> Unit,
) {
    val list = this
    childWith<T>(viewBuilderAction = viewBuilderAction) {
        name(list.withParent(description))
        function()
    }
}

inline fun <reified T : KListItemNode<*>> KListNode.findByPredicate(
    targetIndex: Int,
    blockName: String,
    limiter: Int,
    predicate: T.() -> Boolean,
): T {
    val list = this
    var findBlockCounter = 0
    val max = min(limiter, getSize())
    for (i in 0 until max) {
        childAt<T>(i) {
            if (predicate()) {
                if (findBlockCounter == targetIndex) {
                    name(list.name().withParent("$targetIndex's block of $blockName"))
                    return this
                }
                findBlockCounter++
            }
        }
    }
    throw NotFoundException("Not found block with $targetIndex index of $blockName")
}

inline fun <reified T : KListItemNode<*>> KListNode.invokeByPredicate(
    targetIndex: Int,
    blockName: String,
    limiter: Int,
    predicate: T.() -> Boolean,
    function: T.() -> Unit,
) {
    val list = this
    var findBlockCounter = 0
    val max = min(limiter, getSize())
    for (i in 0 until max) {
        childAt<T>(i) {
            Log.d(
                "KASPRESSO",
                "Проход №$i, ${getText()}, targetIndex = $targetIndex, findBlockCounter = $findBlockCounter",
            )
            if (predicate()) {
                Log.d("KASPRESSO", "Предикат сработал")
                if (findBlockCounter == targetIndex) {
                    Log.d("KASPRESSO", "Каунтер сработал")
                    name(list.name().withParent("$targetIndex's block of $blockName"))
                    function()
                    return
                }
                findBlockCounter++
            }
        }
    }
    throw NotFoundException("Not found block with $targetIndex index of $blockName")
}