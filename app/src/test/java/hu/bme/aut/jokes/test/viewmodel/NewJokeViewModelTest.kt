package hu.bme.aut.jokes.test.viewmodel

import co.zsmb.rainbowcake.test.assertObserved
import co.zsmb.rainbowcake.test.assertObservedLast
import co.zsmb.rainbowcake.test.base.ViewModelTest
import co.zsmb.rainbowcake.test.observeStateAndEvents
import hu.bme.aut.jokes.domain.model.Flag
import hu.bme.aut.jokes.ui.newjoke.Loading
import hu.bme.aut.jokes.ui.newjoke.NewJokeContent
import hu.bme.aut.jokes.ui.newjoke.NewJokePresenter
import hu.bme.aut.jokes.ui.newjoke.NewJokeViewModel
import hu.bme.aut.jokes.ui.newjoke.NewJokeViewModel.JokeSaved
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.stub

@ExperimentalCoroutinesApi
class NewJokeViewModelTest : ViewModelTest() {

    companion object {
        private val mockedCategories = listOf("Dark", "Misc", "Christmas")
        private val defaultSelectedCategory = mockedCategories.first()
    }

    private lateinit var mockedPresenter: NewJokePresenter

    @Before
    fun setup() {
        mockedPresenter = mock()

        mockedPresenter.stub {
            onBlocking { getCategories() } doReturn mockedCategories
        }
    }

    @Test
    fun `test correct content is emitted on load`() = runBlockingTest {
        val vm = NewJokeViewModel(mockedPresenter)
        vm.observeStateAndEvents { stateObserver, _ ->
            vm.load()

            stateObserver.assertObserved(
                Loading,
                NewJokeContent(
                    categories = mockedCategories,
                    selectedCategory = defaultSelectedCategory
                )
            )
        }
    }

    @Test
    fun `test selected category is saved to state`() = runBlockingTest {
        val selectedCategory = mockedCategories.last()

        val vm = NewJokeViewModel(mockedPresenter)
        vm.load()

        vm.observeStateAndEvents { stateObserver, _ ->
            vm.saveSelectedCategoryToState(selectedCategory)

            stateObserver.assertObservedLast(
                NewJokeContent(
                    categories = mockedCategories,
                    selectedCategory = selectedCategory
                )
            )
        }
    }

    @Test
    fun `test isSafe is saved to state`() = runBlockingTest {
        val isSafe = false

        val vm = NewJokeViewModel(mockedPresenter)
        vm.load()

        vm.observeStateAndEvents { stateObserver, _ ->
            vm.saveIsSafeToState(isSafe)

            stateObserver.assertObservedLast(
                NewJokeContent(
                    categories = mockedCategories,
                    selectedCategory = defaultSelectedCategory,
                    isSafe = isSafe
                )
            )
        }
    }

    @Test
    fun `test flag is saved to state`() = runBlockingTest {
        val selectedFlags = listOf(Flag.SEXIST, Flag.NSFW)

        val vm = NewJokeViewModel(mockedPresenter)
        vm.load()

        vm.observeStateAndEvents { stateObserver, _ ->
            selectedFlags.forEach { vm.saveFlagToState(it, true) }

            stateObserver.assertObservedLast(
                NewJokeContent(
                    categories = mockedCategories,
                    selectedCategory = defaultSelectedCategory,
                    selectedFlags = selectedFlags
                )
            )
        }
    }

    @Test
    fun `test joke is saved to state`() = runBlockingTest {
        val joke = "joke"

        val vm = NewJokeViewModel(mockedPresenter)
        vm.load()

        vm.observeStateAndEvents { stateObserver, _ ->
            vm.saveJokeToState(joke)

            stateObserver.assertObservedLast(
                NewJokeContent(
                    categories = mockedCategories,
                    selectedCategory = defaultSelectedCategory,
                    joke = joke
                )
            )
        }
    }

    @Test
    fun `test submit joke`() = runBlockingTest {
        val vm = NewJokeViewModel(mockedPresenter)
        vm.load()

        vm.observeStateAndEvents { _, eventObserver ->
            vm.submitJoke()

            eventObserver.assertObserved(JokeSaved)
        }
    }
}