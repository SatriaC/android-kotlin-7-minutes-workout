package com.fromzerotohero.a7minutesworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.fromzerotohero.a7minutesworkout.databinding.ActivityHistoryBinding
import kotlinx.coroutines.launch

class HistoryActivity : AppCompatActivity() {
    private var binding: ActivityHistoryBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarHistory)
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = "HISTORY"
        }
        binding?.toolbarHistory?.setNavigationOnClickListener {
            onBackPressed()
        }
        val historyDao = (application as WorkoutApp).db.historyDao()
        getAllCompletedDates(historyDao)
    }

    private fun getAllCompletedDates(historyDao: HistoryDao) {
        lifecycleScope.launch {
            historyDao.fetchAllDates().collect { allCompletedDatesList ->
                if(allCompletedDatesList.isNotEmpty()){
                    binding?.rvItemList?.visibility = View.VISIBLE
                    binding?.tvNoRecordsAvailable?.visibility = View.GONE

                    binding?.rvItemList?.layoutManager = LinearLayoutManager(this@HistoryActivity)
                    val dates = ArrayList<String>()
                    for (date in allCompletedDatesList){
                        dates.add(date.date)
                    }
                    val historyAdapter = HistoryAdapter(dates)
                    binding?.rvItemList?.adapter = historyAdapter
                } else {
                    binding?.rvItemList?.visibility = View.GONE
                    binding?.tvNoRecordsAvailable?.visibility = View.VISIBLE

                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}