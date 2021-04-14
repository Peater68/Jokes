package hu.bme.aut.jokes.domain.model

data class DomainCategories(
    val categories: List<String>,
    val categoryAliases: List<DomainCategoryAlias>
)
