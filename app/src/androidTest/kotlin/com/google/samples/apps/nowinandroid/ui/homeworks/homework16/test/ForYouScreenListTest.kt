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

package com.google.samples.apps.nowinandroid.ui.homeworks.homework16.test

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.google.samples.apps.nowinandroid.MainActivity
import com.google.samples.apps.nowinandroid.R
import com.google.samples.apps.nowinandroid.ui.homeworks.homework16.items.ForYouNewsFeedNode
import com.google.samples.apps.nowinandroid.feature.foryou.R as forYouR
import com.google.samples.apps.nowinandroid.feature.search.R as searchR
import com.google.samples.apps.nowinandroid.feature.bookmarks.R as bookmarksR
import com.google.samples.apps.nowinandroid.ui.homeworks.homework16.items.ForYouOnboardingNode
import com.google.samples.apps.nowinandroid.ui.homeworks.homework16.screen.ForYouScreenWithoutDSL
import com.kaspersky.components.composesupport.config.withComposeSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.compose.node.element.ComposeScreen.Companion.onComposeScreen
import io.github.kakaocup.compose.node.element.KNode
import io.github.kakaocup.compose.rule.KakaoComposeTestRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ForYouScreenListTest : TestCase(Kaspresso.Builder.withComposeSupport()) {
    @get:Rule val composeTestRule = createAndroidComposeRule<MainActivity>()

    @get:Rule val kakaoComposeTestRule = KakaoComposeTestRule(
        semanticsProvider = composeTestRule,
        useUnmergedTree = true,
    )

    @Before
    fun allowPermissions() {
        device.permissions.allowViaDialog()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun checkElementOnScreen() = run {
        onComposeScreen<ForYouScreenWithoutDSL> {
            step("Check top app bar") {
                topAppBarNode {
                    step("Check search btn") {
                        searchBtn.assertIsDisplayed()
                        searchBtn.assertHasClickAction()
                    }
                    step("Check title text") {
                        title.assertTextEquals(R.string.app_name)
                    }
                    step("Check settings btn") {
                        settingsBtn.assertIsDisplayed()
                        searchBtn.assertHasClickAction()
                    }
                }
            }
            step("Check For You screen") {
                grid {
                    childAt<ForYouOnboardingNode>(0) {
                        step("Check title") {
                            title {
                                assertIsDisplayed()
                                assertTextEquals(forYouR.string.feature_foryou_onboarding_guidance_title)
                            }
                        }
                        step("Check subtitle") {
                            subTitle {
                                assertIsDisplayed()
                                assertTextEquals(forYouR.string.feature_foryou_onboarding_guidance_subtitle)
                            }
                        }
                        step("Check list") {
                            topicSelection.assertIsDisplayed()
                        }
                        step("Check button") {
                            doneBtn.assertHasClickAction()
                            val childNode: KNode = doneBtn.child {
                                hasText(forYouR.string.feature_foryou_done)
                            }
                            childNode.assertExists()
                        }
                    }
                }
            }
            step("Check bottom nav bar") {
                navBarNode {
                    step("Check For you tab") {
                        val childNode: KNode = forYouTab.child {
                            hasText(forYouR.string.feature_foryou_title)
                        }
                        childNode.assertExists()
                    }
                    step("Check Saved tab") {
                        val childNode: KNode = savedTab.child {
                            hasText(bookmarksR.string.feature_bookmarks_title)
                        }
                        childNode.assertExists()
                    }
                    step("Check Interest tab") {
                        val childNode: KNode = interestsTab.child {
                            hasText(searchR.string.feature_search_interests)
                        }
                        childNode.assertExists()
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun listClick() = run {
        onComposeScreen<ForYouScreenWithoutDSL> {
            grid {
                childAt<ForYouOnboardingNode>(0) {
                    step("Click to topic") {
                        topicSelection {
                            firstItem { performClick() }
                        }
                    }
                }
                childAt<ForYouNewsFeedNode>(1) {
                    step("Check to topic") {
                        card.title.assertIsDisplayed()
                    }
                }
            }
        }
    }
}