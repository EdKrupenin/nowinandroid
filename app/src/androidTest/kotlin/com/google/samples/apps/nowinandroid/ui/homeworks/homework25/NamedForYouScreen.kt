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

package com.google.samples.apps.nowinandroid.ui.homeworks.homework25

import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import com.google.samples.apps.nowinandroid.core.designsystem.LazyListItemPositionSemantics
import com.google.samples.apps.nowinandroid.core.designsystem.LazyListLengthSemantics
import com.google.samples.apps.nowinandroid.core.designsystem.TestingTag
import com.google.samples.apps.nowinandroid.core.designsystem.TestingTag.List.FOR_YOU_FEED
import com.google.samples.apps.nowinandroid.ui.homeworks.homework16.items.ForYouNewsFeedNode
import com.google.samples.apps.nowinandroid.ui.homeworks.homework16.items.ForYouOnboardingNode
import com.google.samples.apps.nowinandroid.ui.homeworks.homework16.node.NavBarNode
import com.google.samples.apps.nowinandroid.ui.homeworks.homework16.node.TopAppBarNode
import com.google.samples.apps.nowinandroid.ui.homeworks.homework25.extentions.NamedComposeScreen
import com.google.samples.apps.nowinandroid.ui.homeworks.homework25.extentions.invokeChildAtIndex
import com.google.samples.apps.nowinandroid.ui.homeworks.homework25.extentions.invokeFirstChild
import com.google.samples.apps.nowinandroid.ui.homeworks.homework25.extentions.name
import io.github.kakaocup.compose.node.element.lazylist.KLazyListNode

class NamedForYouScreen(
    semanticsProvider: SemanticsNodeInteractionsProvider? = null,
) : NamedComposeScreen<NamedForYouScreen>(semanticsProvider) {
    override val screenName: String = "NamedForYoyScreen"

    val topAppBarNode by lazy {
        child<TopAppBarNode> {
            hasTestTag(TestingTag.NIA_TOP_APP_BAR)
        }.name(withParent("Top App Bar"))
    }

    val grid by lazy {
        KLazyListNode(
            semanticsProvider = semanticsProvider,
            viewBuilderAction = { hasTestTag(FOR_YOU_FEED) },
            itemTypeBuilder = {
                itemType(::ForYouOnboardingNode)
                itemType(::ForYouNewsFeedNode)
            },
            positionMatcher = { position ->
                SemanticsMatcher.expectValue(
                    LazyListItemPositionSemantics,
                    position,
                )
            },
            lengthSemanticsPropertyKey = LazyListLengthSemantics,
        ).name(withParent("Feed"))
    }

    val navBarNode by lazy {
        child<NavBarNode> {
            hasTestTag(TestingTag.NIA_NAV_BAR)
        }.name(withParent("Nav Bar Node"))
    }

    fun forYouOnboardingNode(function: ForYouOnboardingNode.() -> Unit) {
        grid.invokeFirstChild(function)
    }

    fun forYouNewsFeedNode(index: Int, function: ForYouNewsFeedNode.() -> Unit) {
        grid.invokeChildAtIndex(index, function)
    }
}