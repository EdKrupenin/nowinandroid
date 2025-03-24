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
import com.google.samples.apps.nowinandroid.ui.homeworks.homework15.base.PageObjectIntentions
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.github.kakaocup.compose.node.builder.NodeMatcher
import io.github.kakaocup.compose.node.core.BaseNode
import io.github.kakaocup.compose.node.element.KNode

class SearchToolBarNode(
    semanticsProvider: SemanticsNodeInteractionsProvider?,
    nodeMatcher: NodeMatcher?,
    parentNode: BaseNode<*>? = null,
) : BaseNode<SearchToolBarNode>(semanticsProvider, nodeMatcher, parentNode) {
    val actions = Actions()
    val checks = Checks()

    val backBtn: KNode = child {
        hasTestTag(TestingTag.SEARCH_TOOLBAR_BACK_BTN)
    }

    val textField: KNode = child {
        hasTestTag(TestingTag.SEARCH_TEXT_FIELD_TEXT_FIELD)
    }

    val clearBtn: KNode = child {
        hasTestTag(TestingTag.SEARCH_TEXT_FIELD_CLEAR_BTN)
    }

    inner class Checks : PageObjectIntentions<Checks>() {
        fun TestContext<*>.checkBackBtn() {
            step("Check back button has click action") {
                backBtn.assertIsDisplayed()
                backBtn.assertHasClickAction()
            }
        }

        fun TestContext<*>.checkTextField() {
            step("Check search input field is displayed") {
                textField.assertIsDisplayed()
            }
        }

        fun TestContext<*>.checkClearBtn() {
            step("Check clear button") {
                clearBtn.assertIsDisplayed()
                clearBtn.assertHasClickAction()
            }
        }
    }

    inner class Actions : PageObjectIntentions<Actions>() {
        fun TestContext<*>.typeTextInput(textInput: String) {
            step("Type text $textInput in search field") {
                textField.performTextInput(textInput)
            }
        }

        fun TestContext<*>.clearBtnClick() {
            step("Click clear button") {
                clearBtn.performClick()
            }
        }

        fun TestContext<*>.backBtnClick() {
            step("Click back button") {
                backBtn.performClick()
            }
        }
    }
}