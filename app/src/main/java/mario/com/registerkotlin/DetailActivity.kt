package mario.com.registerkotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.mario.deleteme.Person
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        btnSave.setOnClickListener {
            val name = edName.text.toString()
            val age = edAge.text.toString().toInt()
            val person = Person(name,age)

            val intent = Intent()
            intent.putExtra(EXTRA_PERSON,person)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }

    companion object {
        val EXTRA_PERSON = "person"
    }
}
