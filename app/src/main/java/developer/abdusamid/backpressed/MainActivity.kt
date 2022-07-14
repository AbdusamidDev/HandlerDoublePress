package developer.abdusamid.backpressed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import developer.abdusamid.backpressed.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var handler: Handler
    var doubleClickToExit = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onBackPressed() {
        if (doubleClickToExit) {
            super.onBackPressed()
            return
        }
        handler = Handler(Looper.getMainLooper())
        this.doubleClickToExit = true
        Toast.makeText(this, "Please Click Home Button To Quit", Toast.LENGTH_SHORT).show()
        handler.postDelayed({
            doubleClickToExit = false
        }, 2000)
    }
}