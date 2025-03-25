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

package com.google.samples.apps.nowinandroid.ui.homeworks.homework15.test

import com.google.samples.apps.nowinandroid.R
import com.google.samples.apps.nowinandroid.ui.homeworks.homework15.base.BaseTestCase
import com.google.samples.apps.nowinandroid.feature.foryou.R as forYouR
import com.google.samples.apps.nowinandroid.feature.search.R as searchR
import com.google.samples.apps.nowinandroid.feature.bookmarks.R as bookmarksR
import com.google.samples.apps.nowinandroid.ui.homeworks.homework15.screen.ForYouScreen
import com.google.samples.apps.nowinandroid.ui.homeworks.homework16.screen.SearchScreen
import io.github.kakaocup.compose.node.element.ComposeScreen.Companion.onComposeScreen
import org.junit.Before
import org.junit.Test

class ForYouScreenTest : BaseTestCase() {
    @Before
    fun init() {
        ForYouScreen.initRule(composeTestRule)
    }

    @Test
    fun checkForYouScreenElements() = run {
        val mainScreenPO = ForYouScreen()
        mainScreenPO {
            step("Check top app bar") {
                topAppBarNode.checks {
                    checkSearchBtn()
                    checkSettingsBtn()
                    checkTopAppBarTitle(R.string.app_name)
                }
            }
            step("Check For You screen") {
                checks {
                    checkTitleText(forYouR.string.feature_foryou_onboarding_guidance_title)
                    checkSubtitleText(forYouR.string.feature_foryou_onboarding_guidance_subtitle)
                    checkDoneBtn(forYouR.string.feature_foryou_done)
                }
            }
            step("Check bottom nav bar") {
                navBarNode.checks {
                    checkForYouTab(forYouR.string.feature_foryou_title)
                    checkSavedTab(bookmarksR.string.feature_bookmarks_title)
                    checkInterestsTab(searchR.string.feature_search_interests)

                }
            }
        }
    }

    @Test
    fun checkSearchScreenElements() = run {
        onComposeScreen<ForYouScreen> {
            topAppBarNode.actions {
                openSearchScreen()
            }
        }
        onComposeScreen<SearchScreen> {
            searchToolBarNode {
                checks {
                    checkBackBtn()
                    checkTextField()
                }
                actions {
                    typeTextInput("compose")
                }
                checks {
                    checkClearBtn()
                }
                actions {
                    clearBtnClick()
                    backBtnClick()
                }
            }
        }
    }
}