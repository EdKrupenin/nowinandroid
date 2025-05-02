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

package com.google.samples.apps.nowinandroid.ui.homeworks.homework25

import android.util.Log
import com.google.samples.apps.nowinandroid.ui.homeworks.homework16.items.SingleTopicButton
import com.google.samples.apps.nowinandroid.ui.homeworks.homework25.extentions.action
import com.google.samples.apps.nowinandroid.ui.homeworks.homework25.extentions.check
import com.google.samples.apps.nowinandroid.ui.homeworks.homework25.extentions.getText
import com.google.samples.apps.nowinandroid.ui.homeworks.homework25.tools.BaseTest
import io.github.kakaocup.compose.node.element.ComposeScreen.Companion.onComposeScreen
import org.junit.Test

class NamedTest : BaseTest() {
    @Test
    fun checkElementOnScreen() = run {
        onComposeScreen<NamedForYouScreen> {
            check {
                topAppBarNode {
                    isDisplayed(searchBtn)
                    hasClickAction(searchBtn)
                    textEQ(title, "Now in Android")
                    isDisplayed(settingsBtn)
                    hasClickAction(settingsBtn)
                }
                forYouOnboardingNode {
                    isDisplayed(title)
                    textEQ(title, "What are you interested in?")
                    isDisplayed(subTitle)
                    textEQ(
                        subTitle,
                        "Updates from topics you follow will appear here. Follow some things to get started.",
                    )
                    isDisplayed(topicSelection)
                    hasClickAction(doneBtn)
                }
            }
        }
    }

    @Test
    fun listClick() = run {
        onComposeScreen<NamedForYouScreen> {
            forYouOnboardingNode {
                action {
                    singleTopicButtonByPredicate(4) {
                        testLogger.i("В 4м элементе ${text.getText()}")
                        click(this)
                    }
                    singleTopicButtonByPredicate(0) {
                        testLogger.i("В 0м элементе ${text.getText()}")
                        click(this)
                    }
                    singleTopicButtonByPredicate(1) {
                        testLogger.i("В 1м элементе ${text.getText()}")
                        click(this)
                    }
                    topicSelection.childAt<SingleTopicButton>(4) {
                        testLogger.i("ТОЧНО В 4м элементе ${text.getText()}")
                    }
                }
            }
            forYouNewsFeedNode(1) {
                check {
                    isDisplayed(card.title)
                }
            }
        }
    }
}