package com.bdjobs.barchart

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var barDataSet = BarDataSet(getData(),"Score")
        barDataSet.setColors(Color.parseColor("#2C786C"))

        var barData : BarData = BarData(barDataSet)
        barData.barWidth = .13f
        var xAxis : XAxis = chart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM

        var names = ArrayList<String>()
        names.add("Physics")
        names.add("Algorithm")
        names.add("Data Structure")
        names.add("Database")
        var formatter = IndexAxisValueFormatter(names)
        xAxis.granularity = 1f
        xAxis.valueFormatter = formatter

        chart.apply {
            data = barData
            setFitBars(true)
            //animateXY(5000,5000)
            invalidate()
        }
    }

    fun getData() : ArrayList<BarEntry>
    {
        var entries = ArrayList<BarEntry>()

        entries.add(BarEntry(0f,300f))
        entries.add(BarEntry(1f,100f))
        entries.add(BarEntry(2f,900f))
        entries.add(BarEntry(3f,500f))

        return entries
    }
}
