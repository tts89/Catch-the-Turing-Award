package catch_the_turing.example

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_score_board.*

class ScoreBoard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score_board)

        val xyz= intent
        val score : Int= xyz.getIntExtra("key",0)

        val store= this.getSharedPreferences("catch_the_turing.example", Context.MODE_PRIVATE )

        val temp=store.getInt("high",0)

        if(temp<score)
        {
            store.edit().putInt("high",score).apply()
            textView2.text= "HighScore : $score"
        }
        else
        {
            textView2.text= "HighScore : $temp"
        }

    }
}



