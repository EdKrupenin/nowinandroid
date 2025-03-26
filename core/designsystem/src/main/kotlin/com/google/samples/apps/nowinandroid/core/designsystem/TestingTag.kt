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

package com.google.samples.apps.nowinandroid.core.designsystem

import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver

object TestingTag {
    const val NIA_TOP_APP_BAR = "niaTopAppBar"
    const val NIA_TOP_APP_BAR_TITLE = "NiaTopAppBarTitle"
    const val NIA_TOP_APP_BAR_SEARCH= "NiaTopAppBarSearch"
    const val NIA_TOP_APP_BAR_SETTINGS= "NiaTopAppBarSettings"
    const val FOR_YOU_SCREEN_TITLE = "ForYouScreenTitle"
    const val FOR_YOU_SCREEN_SUBTITLE = "ForYouScreenSubtitle"
    const val FOR_YOU_SCREEN_DONE_BTN = "ForYouScreenDoneBtn"
    const val NIA_NAV_ITEM = "NiaNavItem"
    const val NIA_NAV_BAR = "niaNavBar"
    const val SEARCH_TOOLBAR = "SearchToolbar"
    const val SEARCH_TOOLBAR_BACK_BTN = "SearchToolbarBackBtn"
    const val SEARCH_TEXT_FIELD_TEXT_FIELD = "SearchTextFieldTextField"
    const val SEARCH_TEXT_FIELD_CLEAR_BTN = "SearchTextFieldClearBtn"
    object Button {
        const val BUTTON_DONE = "ButtonDone"
        const val SINGLE_TOPIC_BUTTON = "SingleTopicButton"
        const val NIA_ICON_TOGGLE_BUTTON = "NiaIconToggleButton"
    }
    object List {
        const val TOPIC_SELECTION = "forYou:topicSelection"
        const val FOR_YOU_FEED = "forYou:feed"
    }
    const val NEWS_RESOURCE_TITLE = "NewsResourceTitle"
    const val NEWS_RESOURCE_CARD_EXPANDED = "NewsResourceCardExpanded"
    const val TOPIC_ICON =" TopicIcon"
    const val SINGLE_TOPIC_BUTTON_TEXT ="SINGLE_TOPIC_BUTTON_TEXT"
}

val LazyListItemPositionSemantics = SemanticsPropertyKey<Int>("LazyListItemPosition")
var SemanticsPropertyReceiver.lazyListItemPosition by LazyListItemPositionSemantics

val LazyListLengthSemantics = SemanticsPropertyKey<Int>("LazyListLength")
var SemanticsPropertyReceiver.lazyListLength by LazyListLengthSemantics