package catch_the_turing.example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    val frequency : Long = 1000
    var score : Int = 0

    var arr = ArrayList <ImageView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        arr= arrayListOf(imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8, imageView9,imageView10,imageView11,imageView12, imageView13,imageView14,imageView15,imageView16 )

    }

    fun start(view: View){
        score=0
        score_disp.text= "Score : $score"

        object : CountDownTimer(20*1000, frequency){
            override fun onFinish() {

                Toast.makeText(applicationContext,"Game Over",Toast.LENGTH_LONG).show()
                val xyz=Intent(applicationContext,ScoreBoard::class.java)
                xyz.putExtra("key",score)
                startActivity(xyz)
            }

            override fun onTick(time_left: Long) {
                time.text="Time Left : " + time_left/1000
                animate()

            }
        }.start()
    }

    fun animate(){

        for(image in arr)
            image.visibility=View.INVISIBLE

        val x= java.util.Random()
        val index:Int= x.nextInt(15)

        arr[index].visibility=View.VISIBLE

    }

    fun increase_score(view:View){
        score++
        score_disp.text= "Score : $score"
    }

}
