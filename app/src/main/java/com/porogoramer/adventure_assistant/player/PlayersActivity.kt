package com.porogoramer.adventure_assistant.player
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.TypedValue
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowInsets
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.porogoramer.adventure_assistant.ProfileActivity
import com.porogoramer.adventure_assistant.connexion.LogInActivitity
import com.porogoramer.adventure_assistant.databinding.ActivityPlayersBinding
import com.porogoramer.adventure_assistant.recycler.CharacterAdapter
import com.porogoramer.adventure_assistant.R


class PlayersActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlayersBinding
    var adapter: CharacterAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val toolbar: Toolbar = findViewById(R.id.toolbar_players)
        setSupportActionBar(toolbar)
        setTitle("Your Characters")

        this.hideStatusBar()
        this.initRecycler()
        this.fillRecycler()

        binding.tempBtn.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_disconnect) {
            startActivity(Intent(this, LogInActivitity::class.java))
        }
        return true
    }

    private fun initRecycler(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.setHasFixedSize(true);


        // use a linear layout manager
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapter = CharacterAdapter()
        recyclerView.adapter = adapter
    }

    private fun fillRecycler() {
        for (i in 0..4) {
            adapter!!.list?.add("Yensariph")
        }
        adapter!!.notifyDataSetChanged()
    }

    fun hideStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        }
    }
}