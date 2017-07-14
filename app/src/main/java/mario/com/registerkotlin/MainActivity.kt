package mario.com.registerkotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import com.example.mario.deleteme.Person
import com.example.mario.deleteme.showShortToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val listPersons : MutableList<Person> by lazy { mutableListOf<Person>() }
    private var adapter : ArrayAdapter<Person>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fabAdd.setOnClickListener {
            val intent = Intent(this,DetailActivity::class.java)
            startActivityForResult(intent,REQUEST_INSERT)
        }

        listPeople.setOnItemClickListener { _, _, position, _ ->
            showShortToast(listPersons[position].name)
        }

        adapter = ArrayAdapter<Person>(this,android.R.layout.simple_list_item_1,listPersons)
        listPeople.adapter = adapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_INSERT && resultCode == Activity.RESULT_OK){
            val person = data?.getSerializableExtra(DetailActivity.EXTRA_PERSON) as? Person
            if(person != null) {
                listPersons.add(person)
                listPersons.sortBy { it.name }
                adapter?.notifyDataSetChanged()
            }
        }
    }
    companion object {
        val REQUEST_INSERT = 0
    }
}