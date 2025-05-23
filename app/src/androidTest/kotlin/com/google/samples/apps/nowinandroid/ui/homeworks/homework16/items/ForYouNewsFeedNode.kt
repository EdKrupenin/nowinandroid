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

package com.google.samples.apps.nowinandroid.ui.homeworks.homework16.items

import androidx.compose.ui.semantics.SemanticsNode
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import com.google.samples.apps.nowinandroid.core.designsystem.TestingTag.NEWS_RESOURCE_CARD_EXPANDED
import com.google.samples.apps.nowinandroid.ui.homeworks.homework16.node.NewsResourceCardExpandedNode
import com.google.samples.apps.nowinandroid.ui.homeworks.homework25.extentions.name
import com.google.samples.apps.nowinandroid.ui.homeworks.homework25.extentions.withParent
import io.github.kakaocup.compose.node.element.lazylist.KLazyListItemNode

class ForYouNewsFeedNode(
    semanticNode: SemanticsNode,
    semanticsProvider: SemanticsNodeInteractionsProvider?,
) : KLazyListItemNode<ForYouOnboardingNode>(semanticNode, semanticsProvider) {
    val card by lazy {
        child<NewsResourceCardExpandedNode> {
            hasTestTag(NEWS_RESOURCE_CARD_EXPANDED)
        }.name(withParent("card"))
    }
}