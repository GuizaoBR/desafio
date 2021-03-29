package br.com.jeferson.git.challenge


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import org.hamcrest.Matchers.allOf
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {


    @Rule
    @JvmField
    var mActivityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    /* Iniciar a atividade no modo avião para facilitar o teste de falha no carregamento */
    @Test
    fun mainActivityTest_StartWithout_Network() {
        val textView = onView(
            allOf(
                withId(R.id.tv_empty), withText("Sem dados."),
                withParent(withParent(withId(R.id.fragment_container))),
                isDisplayed()
            )
        )

        textView.check(matches(isDisplayed()))
    }

    @Test
    fun mainActivityTest_With_ListFragments_Name() {
        val textView = onView(
            allOf(
                withText("Lista JavaPop"),
                withParent(
                    allOf(
                        withId(R.id.action_bar),
                        withParent(withId(R.id.action_bar_container))
                    )
                ),
                isDisplayed()
            )
        )
        textView.check(matches(withText("Lista JavaPop")))
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("br.com.jeferson.git.challenge", appContext.packageName)
    }
}
