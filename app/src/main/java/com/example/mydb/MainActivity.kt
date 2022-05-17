package com.example.mydb

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mydb.ui.theme.MydbTheme
import java.lang.Exception

class MainActivity : ComponentActivity() {
    //lateinit var db: SQLiteDatabase
    var dbHelper:DBH = DBH(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MydbTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }

        try{
            var user1 = UserModel("ToA","50")
            dbHelper.insertUser(user1)
            var user2 = UserModel("ToB","50")
            dbHelper.insertUser(user2)
            //dbHelper.delUser("To")

        }catch (e: Exception){
            Toast.makeText(applicationContext, e.toString(), Toast.LENGTH_LONG).show()
        }

        var users = dbHelper.showAllUser()


        var tstr = ""
        for(user in users){
            tstr += user.name+","+user.age+"\n"
        }
        totalStr.value = tstr
        //Toast.makeText(applicationContext, totalText, Toast.LENGTH_LONG).show()

    }
}

var totalStr = mutableStateOf("")

@Composable
fun Greeting(name: String) {
    Text(text = "Hello ${totalStr.value}!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MydbTheme {
        Greeting("Android")
    }
}