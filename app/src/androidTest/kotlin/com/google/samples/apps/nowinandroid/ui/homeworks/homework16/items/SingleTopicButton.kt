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

import com.google.samples.apps.nowinandroid.core.designsystem.TestingTag.Button.NIA_ICON_TOGGLE_BUTTON
import com.google.samples.apps.nowinandroid.core.designsystem.TestingTag.SINGLE_TOPIC_BUTTON_TEXT
import com.google.samples.apps.nowinandroid.core.designsystem.TestingTag.TOPIC_ICON
import com.google.samples.apps.nowinandroid.ui.homeworks.homework25.extentions.name
import com.google.samples.apps.nowinandroid.ui.homeworks.homework25.extentions.withParent
import io.github.kakaocup.compose.node.element.KNode
import io.github.kakaocup.compose.node.element.list.KListItemNode

class SingleTopicButton : KListItemNode<SingleTopicButton>() {

    val icon by lazy {
        KNode{
            hasTestTag(TOPIC_ICON)
        }.name(withParent("icon"))
    }

    val text by lazy {
        KNode{
            hasTestTag(SINGLE_TOPIC_BUTTON_TEXT)
        }.name(withParent("text"))
    }

    val iconToggleButton by lazy {
        KNode{
            hasTestTag(NIA_ICON_TOGGLE_BUTTON)
        }.name(withParent("iconToggleButton"))
    }
}