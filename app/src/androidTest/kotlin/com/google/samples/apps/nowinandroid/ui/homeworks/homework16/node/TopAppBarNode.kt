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

import androidx.annotation.StringRes
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import com.google.samples.apps.nowinandroid.core.designsystem.TestingTag
import com.google.samples.apps.nowinandroid.ui.homeworks.homework15.base.PageObjectIntentions
import com.google.samples.apps.nowinandroid.ui.homeworks.homework25.extentions.name
import com.google.samples.apps.nowinandroid.ui.homeworks.homework25.extentions.withParent
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.github.kakaocup.compose.node.builder.NodeMatcher
import io.github.kakaocup.compose.node.core.BaseNode
import io.github.kakaocup.compose.node.element.KNode

class TopAppBarNode(
    semanticsProvider: SemanticsNodeInteractionsProvider?,
    nodeMatcher: NodeMatcher,
    parentNode: BaseNode<*>? = null,
) : BaseNode<TopAppBarNode>(semanticsProvider, nodeMatcher, parentNode) {
    val actions = Actions()
    val checks = Checks()

    val title by lazy {
        child<KNode> {
            hasTestTag(TestingTag.NIA_TOP_APP_BAR_TITLE)
        }.name(withParent("card"))
    }
    val searchBtn by lazy {
        child<KNode> {
            hasTestTag(TestingTag.NIA_TOP_APP_BAR_SEARCH)
        }.name(withParent("card"))
    }
    val settingsBtn by lazy {
        child<KNode> {
            hasTestTag(TestingTag.NIA_TOP_APP_BAR_SETTINGS)
        }.name(withParent("card"))
    }

    inner class Checks : PageObjectIntentions<Checks>() {
        fun TestContext<*>.checkSearchBtn() {
            step("Check search btn") {
                searchBtn.assertIsDisplayed()
                searchBtn.assertHasClickAction()
            }
        }

        fun TestContext<*>.checkSettingsBtn() {
            step("Check settings btn") {
                settingsBtn.assertIsDisplayed()
                searchBtn.assertHasClickAction()
            }
        }

        fun TestContext<*>.checkTopAppBarTitle(
            @StringRes vararg values: Int,
        ) {
            step("Check title text") {
                title.assertTextEquals(*values)
            }
        }
    }

    inner class Actions : PageObjectIntentions<Actions>() {
        fun TestContext<*>.openSearchScreen() {
            step("Open search screen") {
                searchBtn.performClick()
            }
        }
    }
}