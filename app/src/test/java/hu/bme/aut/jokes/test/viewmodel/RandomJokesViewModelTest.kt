package hu.bme.aut.jokes.test.viewmodel

import co.zsmb.rainbowcake.test.assertDidObserve
import co.zsmb.rainbowcake.test.assertObserved
import co.zsmb.rainbowcake.test.assertObservedLast
import co.zsmb.rainbowcake.test.base.ViewModelTest
import co.zsmb.rainbowcake.test.observeStateAndEvents
import hu.bme.aut.jokes.ui.common.model.Joke
import hu.bme.aut.jokes.ui.randomjokes.Loading
import hu.bme.aut.jokes.ui.randomjokes.RandomJokesContent
import hu.bme.aut.jokes.ui.randomjokes.RandomJokesPresenter
import hu.bme.aut.jokes.ui.randomjokes.RandomJokesViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.stub

@ExperimentalCoroutinesApi
class RandomJokesViewModelTest : ViewModelTest() {

    companion object {
        private val mockedCategories = listOf("Dark", "Misc")
        private val mockedJokes = listOf(
            Joke(
                id = 4L,
                category = "Misc",
                joke = "Joke",
                flags = emptyList(),
                isLiked = false
            )
        )
    }

    private lateinit var mockedPresenter: RandomJokesPresenter

    @Before
    fun setup() {
        mockedPresenter = mock()

        mockedPresenter.stub {
            onBlocking { getRandomJokesByCategories(listOf(mockedCategories.first())) }.doReturn(
                emptyList()
            )
            onBlocking { getCategories() }.doReturn(mockedCategories)
        }
    }

    @Test
    fun `test correct content is emitted on load`() = runBlockingTest {
        val vm = RandomJokesViewModel(mockedPresenter)
        vm.observeStateAndEvents { stateObserver, _ ->
            vm.load()

            stateObserver.assertObserved(
                Loading,
                RandomJokesContent(categories = mockedCategories, jokes = emptyList())
            )
        }
    }

    @Test
    fun `test correct content is emitted on getJokesForCategory`() = runBlockingTest {
        val searchedCategory = mockedCategories[1]

        val vm = RandomJokesViewModel(mockedPresenter)
        mockedPresenter.stub {
            onBlocking { getRandomJokesByCategories(listOf(searchedCategory)) }.doReturn(
                mockedJokes
            )
        }

        vm.load()
        vm.observeStateAndEvents { stateObserver, _ ->
            vm.getJokesForCategory(searchedCategory)

            stateObserver.assertDidObserve(
                RandomJokesContent(
                    jokes = mockedJokes,
                    categories = mockedCategories,
                    searchedCategory = searchedCategory
                )
            )
        }
    }

    @Test
    fun `test correct content is emitted on likeJoke`() = runBlockingTest {
        val jokeToLike = mockedJokes.first()

        val vm = RandomJokesViewModel(mockedPresenter)
        mockedPresenter.stub {
            onBlocking { getRandomJokesByCategories(listOf(mockedCategories.first())) }.doReturn(
                mockedJokes
            )
        }

        vm.load()
        vm.observeStateAndEvents { stateObserver, _ ->
            vm.likeJoke(jokeToLike)

            stateObserver.assertObservedLast(
                RandomJokesContent(
                    jokes = mockedJokes.toMutableList()
                        .apply { this[0] = jokeToLike.copy(isLiked = true) },
                    categories = mockedCategories
                )
            )
        }
    }
}