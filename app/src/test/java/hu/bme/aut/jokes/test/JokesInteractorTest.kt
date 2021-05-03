package hu.bme.aut.jokes.test

import hu.bme.aut.jokes.domain.JokesInteractor
import hu.bme.aut.jokes.mock.disk.MockJokeDao
import hu.bme.aut.jokes.testInjector
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.robolectric.RobolectricTestRunner
import javax.inject.Inject

@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING) //Needed to test deletion
class JokesInteractorTest {
    @Inject
    lateinit var jokesInteractor: JokesInteractor

    @Before
    fun setup() {
        testInjector.inject(this)
    }

    @Test
    fun `test random jokes are as expected`() = runBlockingTest {
        val randomJokes = jokesInteractor.getJokesByCategories(emptyList())
        Assert.assertEquals(randomJokes.size, 7)
        Assert.assertTrue(randomJokes.any { it.category == "1" })
    }

    @Test
    fun `test categories are as expected`() = runBlockingTest {
        val categories = jokesInteractor.getCategories()
        Assert.assertEquals(categories.size, 3)
        Assert.assertTrue(categories.contains("Dark"))
    }

    @Test
    fun `test get jokes by category`() = runBlockingTest {
        val category = "Dark"

        val darkJokes = jokesInteractor.getJokesByCategories(listOf(category))
        Assert.assertEquals(darkJokes.first().category, "${category}1")
    }

    @Test
    fun `test liked joke is saved and read correctly`() = runBlockingTest {
        val randomJokes = jokesInteractor.getJokesByCategories(emptyList())
        jokesInteractor.saveLikedJoke(randomJokes.first())

        val likedJokes = jokesInteractor.getLikedJokes()
        Assert.assertTrue(likedJokes.contains(randomJokes.first()))
    }

    @Test
    fun `test joke is liked`() = runBlockingTest {
        val isJokeLiked = jokesInteractor.isJokeLiked(MockJokeDao.EXAMPLE_LIKED_JOKE_ID)
        Assert.assertTrue(isJokeLiked)
    }

    @Test
    fun `test joke is not liked`() = runBlockingTest {
        val isJokeLiked = jokesInteractor.isJokeLiked(MockJokeDao.EXAMPLE_MY_JOKE_ID)
        Assert.assertFalse(isJokeLiked)
    }

    @Test
    fun `test my joke is saved and read correctly`() = runBlockingTest {
        val randomJokes = jokesInteractor.getJokesByCategories(emptyList())
        jokesInteractor.saveMyJoke(randomJokes.first())

        val myJokes = jokesInteractor.getMyJokes()
        Assert.assertTrue(myJokes.contains(randomJokes.first()))
    }

    @Test
    fun `test set joke state to not liked`() = runBlockingTest {
        val randomJoke = jokesInteractor.getJokesByCategories(emptyList()).last()
        jokesInteractor.saveLikedJoke(randomJoke)

        jokesInteractor.setJokeLike(randomJoke.id, false)

        val likedJokes = jokesInteractor.getLikedJokes()
        Assert.assertFalse(likedJokes.contains(randomJoke))
    }

    @Test
    fun `tezt delete all jokes`() = runBlockingTest {
        jokesInteractor.deleteAllJokes()

        val likedJokes = jokesInteractor.getLikedJokes()
        Assert.assertTrue(likedJokes.isEmpty())
        val myJokes = jokesInteractor.getMyJokes()
        Assert.assertTrue(myJokes.isEmpty())
    }
}