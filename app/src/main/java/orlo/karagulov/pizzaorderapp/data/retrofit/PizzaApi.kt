package orlo.karagulov.foodorderapp.data.retrofit

import orlo.karagulov.pizzaorderapp.data.models.Pizza
import retrofit2.http.GET



interface PizzaApi {

    @GET("/restaurants/restaurantId/menu?category=Pizza&orderBy=rank")
    suspend fun getPizzaMenu(): List<Pizza>

}