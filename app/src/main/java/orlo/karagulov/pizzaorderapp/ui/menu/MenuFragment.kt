package orlo.karagulov.pizzaorderapp.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.launch
import orlo.karagulov.foodorderapp.data.retrofit.RetrofitInstance
import orlo.karagulov.pizzaorderapp.R
import orlo.karagulov.pizzaorderapp.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {
    private lateinit var binding: FragmentMenuBinding
    private lateinit var adapter: MenuAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMenuBinding.bind(view)

        binding.rvMenu.layoutManager = LinearLayoutManager(activity)

        lifecycleScope.launch {
            val pizzas = RetrofitInstance.PizzaApi.getPizzaMenu()
            adapter = MenuAdapter(pizzas)
            binding.rvMenu.adapter = adapter
        }

        binding.apply {
            btnPizza.setOnClickListener {
                btnPizza.isSelected = !btnPizza.isSelected
            }
            btnCombo.setOnClickListener {
                btnCombo.isSelected = !btnCombo.isSelected
            }
            btnDessert.setOnClickListener {
                btnDessert.isSelected = !btnDessert.isSelected
            }
            btnDrinks.setOnClickListener {
                btnDrinks.isSelected = !btnDrinks.isSelected
            }
        }
    }
}