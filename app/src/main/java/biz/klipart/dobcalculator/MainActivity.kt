package biz.klipart.dobcalculator

import android.app.DatePickerDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var btn: Button
    lateinit var insta: ImageView
    lateinit var facebook: ImageView
    lateinit var whatsapp: ImageView
    lateinit var twitter: ImageView
    lateinit var linkedin: ImageView
    private var text_date: TextView? = null
    private var text_mins: TextView? = null
    lateinit var spin_unit: Spinner
    lateinit var txt_below:TextView
     var count : Int? = null

    var inicount : Int? = null
    var valueconvert : Long? = null
    var valueconverth : Double? = null

   // var stringToStoreDate: String? = null

    val unit_values = arrayOf("Select a value","picosecond","nanosecond","microsecond","millisecond","second","minute","kilosecond","hour","day","week","month","year","decade","galactic year")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spin_unit = findViewById(R.id.spin_unit)
        txt_below = findViewById(R.id.change_unit_txt)



        val arrayAdapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,unit_values)

        spin_unit.adapter = arrayAdapter

        btn = findViewById(R.id.date_picker)
        text_date = findViewById(R.id.selected_date)
        text_mins = findViewById(R.id.mins_date)

        insta = findViewById(R.id.insta_bt)
        facebook = findViewById(R.id.facebook_bt)
        whatsapp = findViewById(R.id.whatsapp_bt)
        twitter = findViewById(R.id.tweet_bt)
        linkedin = findViewById(R.id.linke_bt)

        inicount = spin_unit.selectedItemPosition

        spin_unit.setSelection(inicount!!,false)


        spin_unit.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                Toast.makeText(this@MainActivity,
                    "You selected :" + " " +
                            "" + unit_values[p2], Toast.LENGTH_SHORT).show()

                txt_below.text = "In "+ spin_unit.selectedItem.toString() + " till date"


                count = p2




              clickDatePicker()




            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }



        insta.setOnClickListener {

            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.instagram.com/thecodedeed/")
            startActivity(openURL)
        }

        facebook.setOnClickListener {

            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.facebook.com/profile.php?id=100090092490341")
            startActivity(openURL)
        }

        whatsapp.setOnClickListener {

            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://wa.me/message/K3L5X5CAQ54VB1")
            startActivity(openURL)
        }

        twitter.setOnClickListener {

            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://twitter.com/vedantprabhu32")
            startActivity(openURL)
        }

        linkedin.setOnClickListener {

            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.linkedin.com/company/appdeed/")
            startActivity(openURL)
        }


        btn.setOnClickListener { view ->
               clickDatePicker()
        }

    }

    fun clickDatePicker(){

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(this,{ _, selectedYear, selectedMonth, selectedDayOfMonth ->

            val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"

          //  stringToStoreDate = selectedDate

            text_date?.text= selectedDate



            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

            val theDate = sdf.parse(selectedDate)

            theDate?.let {

                val selectedDateInMinutes = theDate.time/60000

                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                currentDate?.let {

                    val currentDateToMinutes = currentDate.time/60000

                    val differenceInMinutes = currentDateToMinutes - selectedDateInMinutes


                    when (count) {


                        0 -> {

                        }

                        1 -> {

                            valueconvert = differenceInMinutes * 60000000000000
                            text_mins?.text = valueconvert.toString()
                        }

                        2 -> {

                            valueconvert = differenceInMinutes * 60000000000
                            text_mins?.text = valueconvert.toString()
                        }

                        3 -> {

                            valueconvert = differenceInMinutes * 60000000
                            text_mins?.text = valueconvert.toString()

                        }

                        4 -> {

                            valueconvert = differenceInMinutes * 60000
                            text_mins?.text = valueconvert.toString()

                        }

                        5 -> {

                            valueconvert = differenceInMinutes * 60
                            text_mins?.text = valueconvert.toString()

                        }

                        6 -> {

                            valueconvert = differenceInMinutes
                            text_mins?.text = valueconvert.toString()

                        }

                        7 -> {

                            valueconverth = differenceInMinutes * 0.06
                            text_mins?.text = valueconvert.toString()

                        }

                        8 -> {

                            valueconverth = differenceInMinutes * 0.0166666667
                            text_mins?.text = valueconverth.toString()

                        }



                        9 -> {

                            valueconverth = differenceInMinutes * 0.0006944444
                            text_mins?.text = valueconverth.toString()

                        }

                        10 -> {

                            valueconverth = differenceInMinutes * 0.0000992063
                            text_mins?.text = valueconverth.toString()

                        }

                        11 -> {

                            valueconverth = differenceInMinutes * 0.0000228311
                            text_mins?.text = valueconverth.toString()

                        }

                        12 -> {

                            valueconverth = differenceInMinutes * 0.0000019012852688417
                            text_mins?.text = valueconverth.toString()

                        }

                        13 -> {

                            valueconverth = differenceInMinutes * 0.00000019012852688417
                            text_mins?.text = valueconverth.toString()

                        }

                        14 -> {

                            valueconverth = differenceInMinutes * 0.0000000000000082721196479386
                            text_mins?.text = valueconverth.toString()

                        }

                        else -> {
                            text_mins?.text = "Select some value"
                            txt_below.text = "Select some value"

                        }
                    }


                }
            }
        },
            year,month,day)

        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dpd.show()

    }
}