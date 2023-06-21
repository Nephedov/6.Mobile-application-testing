package com.netology.tabbedapplication;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTestHomework {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void mainActivityTestHomework() {
        String firstPage = "1";
        String secondPage = "2";

        ViewInteraction tabView1 = onView(withText("TAB 1"));
        tabView1.check(matches(isDisplayed()));

        ViewInteraction textView1 = onView(
                allOf(withId(R.id.section_label), isDisplayed()));
        textView1.check(matches(withText("Page: " + firstPage)));

        ViewInteraction tabView2 = onView(
                allOf(withContentDescription("Tab 2"),
                        isDisplayed()));
        tabView2.perform(click());

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.section_label),
                        isDisplayed()));
        textView2.check(matches(withText("Page: " + secondPage)));
    }
}
