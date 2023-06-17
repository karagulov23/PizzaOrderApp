package orlo.karagulov.pizzaorderapp.ui.menu

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import orlo.karagulov.pizzaorderapp.data.models.Pizza
import orlo.karagulov.pizzaorderapp.databinding.ItemPizzaBinding

class MenuAdapter(private var pizzas: List<Pizza>) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

        inner class MenuViewHolder(val binding: ItemPizzaBinding): RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
            return MenuViewHolder(ItemPizzaBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }

        override fun getItemCount(): Int {
            return pizzas.size
        }

        override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
            holder.binding.apply {
                tvProductTitle.text = pizzas[position].name
                tvDescription.text = pizzas[position].toString()


            }
        }

    }
