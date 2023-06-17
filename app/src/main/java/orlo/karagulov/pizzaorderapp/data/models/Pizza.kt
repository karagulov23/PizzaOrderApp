package orlo.karagulov.pizzaorderapp.data.models

data class Pizza(
    val category: String,
    val id: Int,
    val name: String,
    val price: Int,
    val rank: Int,
    val topping: List<String>
)