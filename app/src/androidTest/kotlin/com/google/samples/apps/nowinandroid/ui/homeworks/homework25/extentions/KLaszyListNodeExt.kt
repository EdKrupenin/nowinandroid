/*
 * Copyright 2025 The Android Open Source Project
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

package com.google.samples.apps.nowinandroid.ui.homeworks.homework25.extentions

import androidx.compose.ui.test.ExperimentalTestApi
import io.github.kakaocup.compose.node.builder.ViewBuilder
import io.github.kakaocup.compose.node.element.lazylist.KLazyListItemNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListNode

@OptIn(ExperimentalTestApi::class)
inline fun <reified T : KLazyListItemNode<*>> KLazyListNode.invokeChildAtIndex(
    index: Int,
    function: T.() -> Unit,
) {
    val list = this
    childAt<T>(position = index) {
        name(list.withParent("$index"))
        function()
    }
}

@OptIn(ExperimentalTestApi::class)
inline fun <reified T : KLazyListItemNode<*>> KLazyListNode.invokeFirstChild(function: T.() -> Unit) {
    val list = this
    firstChild<T> {
        name(list.withParent("first"))
        function()
    }
}

@OptIn(ExperimentalTestApi::class)
inline fun <reified T : KLazyListItemNode<*>> KLazyListNode.invokeChildAtMatcher(
    noinline viewBuilderAction: ViewBuilder.() -> Unit,
    description: String,
    crossinline function: () -> Unit,
) {
    val list = this
    childWith<T>(childMatcher = viewBuilderAction).perform {
        name(list.withParent(description))
        function()
    }
}