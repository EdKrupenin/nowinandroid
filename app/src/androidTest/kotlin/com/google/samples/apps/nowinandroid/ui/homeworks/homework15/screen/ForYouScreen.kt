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

package com.google.samples.apps.nowinandroid.ui.homeworks.homework15.screen

import androidx.annotation.StringRes
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.junit4.ComposeTestRule
import com.google.samples.apps.nowinandroid.core.designsystem.LazyListItemPositionSemantics
import com.google.samples.apps.nowinandroid.core.designsystem.LazyListLengthSemantics
import com.google.samples.apps.nowinandroid.core.designsystem.TestingTag
import com.google.samples.apps.nowinandroid.ui.homeworks.homework15.base.PageObjectIntentions
import com.google.samples.apps.nowinandroid.ui.homeworks.homework16.items.SingleTopicButton
import com.google.samples.apps.nowinandroid.ui.homeworks.homework16.node.NavBarNode
import com.google.samples.apps.nowinandroid.ui.homeworks.homework16.node.TopAppBarNode
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode
import io.github.kakaocup.compose.node.element.list.KListNode

class ForYouScreen(
    semanticsProvider: SemanticsNodeInteractionsProvider? = defaultRule,
) : ComposeScreen<ForYouScreen>(semanticsProvider = semanticsProvider) {
    val checks = Checks()
    val actions = Action()

    val topAppBarNode: TopAppBarNode = child {
        hasTestTag(TestingTag.NIA_TOP_APP_BAR)
    }

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

    val navBarNode: NavBarNode = child {
        hasTestTag(TestingTag.NIA_NAV_BAR)
    }

    inner class Action : PageObjectIntentions<Action>() {
        fun TestContext<*>.performClickOnItemWithTitle(text: String) {
            step("Клик на абстрактный элемент списка с заголовком (text: '$text')") {
                topicSelection.childWith<SingleTopicButton>(
                    { hasAnyDescendant(androidx.compose.ui.test.hasTextExactly(text)) },
                ) {
                    iconToggleButton.performClick()
                }
            }
        }
    }

    inner class Checks : PageObjectIntentions<Checks>() {
        fun TestContext<*>.checkTitleText(@StringRes vararg values: Int) {
            step("Check title") {
                title {
                    assertIsDisplayed()
                    assertTextEquals(*values)
                }
            }
        }

        fun TestContext<*>.checkSubtitleText(@StringRes vararg values: Int) {
            step("Check subtitle") {
                subTitle {
                    assertIsDisplayed()
                    assertTextEquals(*values)
                }
            }
        }

        fun TestContext<*>.checkDoneBtn(@StringRes values: Int) {
            step("Check button") {
                doneBtn.assertHasClickAction()
                val childNode: KNode = doneBtn.child {
                    hasText(values)
                }
                childNode.assertExists()
            }
        }
    }

    companion object {
        private var defaultRule: SemanticsNodeInteractionsProvider? = null

        fun initRule(composeTestRule: ComposeTestRule) {
            defaultRule = object : SemanticsNodeInteractionsProvider {
                override fun onNode(
                    matcher: SemanticsMatcher,
                    useUnmergedTree: Boolean,
                ) = composeTestRule.onNode(matcher, useUnmergedTree = true)

                override fun onAllNodes(
                    matcher: SemanticsMatcher,
                    useUnmergedTree: Boolean,
                ) = composeTestRule.onAllNodes(matcher, useUnmergedTree = true)
            }
        }
    }
}