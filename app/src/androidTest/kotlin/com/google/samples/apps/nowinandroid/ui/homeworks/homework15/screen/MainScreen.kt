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
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode

class MainScreen(semanticsProvider: SemanticsNodeInteractionsProvider? = null) :
    ComposeScreen<MainScreen>(semanticsProvider) {
    val doneButton = KNode(semanticsProvider) {
        hasText("Done")
    }
    val topBarTitle = child<KNode> {
        hasTestTag("NiaTopAppBarTitle")
    }

    val navigationIcon = child<KNode> {
        hasParent(androidx.compose.ui.test.hasTestTag("niaTopAppBar"))
        hasPosition(2)
    }
}