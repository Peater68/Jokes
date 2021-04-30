package hu.bme.aut.jokes.data.cache

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CategoryCache @Inject constructor() {
    var categories: List<String> = emptyList()
}