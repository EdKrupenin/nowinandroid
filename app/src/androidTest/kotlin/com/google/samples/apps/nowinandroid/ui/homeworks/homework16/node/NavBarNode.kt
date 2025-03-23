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

package com.google.samples.apps.nowinandroid.ui.homeworks.homework16.node

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import com.google.samples.apps.nowinandroid.core.designsystem.TestingTag
import io.github.kakaocup.compose.node.builder.NodeMatcher
import io.github.kakaocup.compose.node.core.BaseNode
import io.github.kakaocup.compose.node.element.KNode
import io.github.kakaocup.compose.utilities.getResourceString
import com.google.samples.apps.nowinandroid.feature.foryou.R as forYouR
import com.google.samples.apps.nowinandroid.feature.search.R as searchR
import com.google.samples.apps.nowinandroid.feature.bookmarks.R as bookmarksR

class NavBarNode(
    semanticsProvider: SemanticsNodeInteractionsProvider?,
    nodeMatcher: NodeMatcher,
    parentNode: BaseNode<*>? = null,
) : BaseNode<NavBarNode>(semanticsProvider, nodeMatcher, parentNode) {
    val forYouTab: KNode = child {
        hasTestTag(TestingTag.NIA_NAV_ITEM)
        hasAnyChild(
            androidx.compose.ui.test.hasText(
                getResourceString(forYouR.string.feature_foryou_title),
                substring = false,
                ignoreCase = false,
            ),
        )
    }
    val savedTab: KNode = child {
        hasTestTag(TestingTag.NIA_NAV_ITEM)
        hasAnyChild(
            androidx.compose.ui.test.hasText(
                getResourceString(bookmarksR.string.feature_bookmarks_title),
                substring = false,
                ignoreCase = false,
            ),
        )
    }
    val interestsTab: KNode = child {
        hasTestTag(TestingTag.NIA_NAV_ITEM)
        hasAnyChild(
            androidx.compose.ui.test.hasText(
                getResourceString(searchR.string.feature_search_interests),
                substring = false,
                ignoreCase = false,
            ),
        )
    }
}