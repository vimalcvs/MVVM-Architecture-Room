package com.vimalcvs.mvp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.vimalcvs.mvp.adapter.CategoryAdapter
import com.vimalcvs.mvp.databinding.ActivityMainBinding
import com.vimalcvs.mvp.intent.CategoryViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var categoryViewModel: CategoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        categoryViewModel = ViewModelProvider(this)[CategoryViewModel::class.java]

        val adapter = CategoryAdapter()
        binding.recyclerView.adapter = adapter

        categoryViewModel.allCategories.observe(this) { categories ->
            categories?.let { adapter.setCategories(it) }
        }
        adapter.onItemClick = { category ->
            val intent = Intent(this@MainActivity, ActivityDetail::class.java)
            intent.putExtra("EXTRA_CATEGORY", category)
            startActivity(intent)
        }
    }
}
