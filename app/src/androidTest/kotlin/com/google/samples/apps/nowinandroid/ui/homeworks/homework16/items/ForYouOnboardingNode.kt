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
import com.google.samples.apps.nowinandroid.core.designsystem.LazyListItemPositionSemantics
import com.google.samples.apps.nowinandroid.core.designsystem.LazyListLengthSemantics
import com.google.samples.apps.nowinandroid.core.designsystem.TestingTag
import io.github.kakaocup.compose.node.element.KNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListItemNode
import io.github.kakaocup.compose.node.element.list.KListNode

class ForYouOnboardingNode(
    semanticNode: SemanticsNode,
    semanticsProvider: SemanticsNodeInteractionsProvider?
) : KLazyListItemNode<ForYouOnboardingNode>(semanticNode, semanticsProvider) {
    val title: KNode = child {
        hasTestTag(TestingTag.FOR_YOU_SCREEN_TITLE)
    }

    val subTitle: KNode = child {
        hasTestTag(TestingTag.FOR_YOU_SCREEN_SUBTITLE)
    }

    val topicSelection = KListNode(
        testTag = TestingTag.List.TOPIC_SELECTION,
        itemIndexSemanticsPropertyKey = LazyListItemPositionSemantics,
        lengthSemanticsPropertyKey = LazyListLengthSemantics,
    )

    val doneBtn: KNode = child {
        hasTestTag(TestingTag.FOR_YOU_SCREEN_DONE_BTN)
    }
}