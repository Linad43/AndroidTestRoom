package com.example.androidtestroom

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.androidtestroom.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val users = mutableListOf<User>()
    private lateinit var adapter:RecyclerAdapter
    private var db:UserDatabase? = null
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = UserDatabase.getDatabase(this)
//        readDatabase(db!!)
        adapter = RecyclerAdapter(users)
        binding.recyclerRV.layoutManager = LinearLayoutManager(this)
        binding.recyclerRV.adapter = adapter

        binding.addBTN.setOnClickListener {
            val user = User(
                binding.firstName.text.toString(),
                binding.lastName.text.toString()
            )
//            addUser(db!!, user)
//            readDatabase(db!!)
            adapter.notifyDataSetChanged()
        }
    }
//    @OptIn(DelicateCoroutinesApi::class)
//    private fun addUser(db: UserDatabase, user: User) =
//        GlobalScope.async {
//            db.userDao().insert(user)
//        }
//    @OptIn(DelicateCoroutinesApi::class)
//    private fun readDatabase(db: UserDatabase) =
//        GlobalScope.async {
//            val list = db.userDao().getAll()
//            users.clear()
//            list.forEach{
//                users.add(it)
//            }
//        }
}