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

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import com.google.samples.apps.nowinandroid.core.designsystem.TestingTag
import com.google.samples.apps.nowinandroid.ui.homeworks.homework16.node.NavBarNode
import com.google.samples.apps.nowinandroid.ui.homeworks.homework16.node.TopAppBarNode
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode

class ForYouScreen(semanticsProvider: SemanticsNodeInteractionsProvider? = null) :
    ComposeScreen<ForYouScreen>(semanticsProvider) {
//    val checks = Checks()

    val topAppBarNode: TopAppBarNode = child {
        hasTestTag(TestingTag.NIA_TOP_APP_BAR)
    }

    val title: KNode = child {
        hasTestTag(TestingTag.FOR_YOU_SCREEN_TITLE)
    }

    val subTitle: KNode = child {
        hasTestTag(TestingTag.FOR_YOU_SCREEN_SUBTITLE)
    }

    val doneBtn: KNode = child {
        hasTestTag(TestingTag.FOR_YOU_SCREEN_DONE_BTN)
    }

    val navBarNode: NavBarNode = child {
        hasTestTag(TestingTag.NIA_NAV_BAR)
    }

//    inner class Checks : PageObjectIntentions<Checks>() {
//
//    }
}