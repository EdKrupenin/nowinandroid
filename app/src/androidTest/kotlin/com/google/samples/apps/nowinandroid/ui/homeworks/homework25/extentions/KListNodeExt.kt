package com.google.samples.apps.nowinandroid.ui.homeworks.homework25.extentions

import android.content.res.Resources.NotFoundException
import io.github.kakaocup.compose.node.builder.ViewBuilder
import io.github.kakaocup.compose.node.element.list.KListItemNode
import io.github.kakaocup.compose.node.element.list.KListNode
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