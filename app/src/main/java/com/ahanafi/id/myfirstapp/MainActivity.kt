package com.ahanafi.id.myfirstapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    private lateinit var rvProgrammingLanguage: RecyclerView
    private var list: ArrayList<ProgrammingLanguage> = arrayListOf()
    private var title: String = "List of Programming Language"

    private fun setActionBarTitle(title: String) {
        if(supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvProgrammingLanguage = findViewById(R.id.rv_programming_language)
        rvProgrammingLanguage.setHasFixedSize(true)

        list.addAll(ProgrammingLanguageData.listData)
        showRecyclerViewCardView()

        setActionBarTitle(title)
    }

    //Membuat menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val moveIntent = Intent(this@MainActivity, CreatorActivity::class.java)
        startActivity(moveIntent)
        return super.onOptionsItemSelected(item)
    }

    private fun showRecyclerViewList() {
        rvProgrammingLanguage.layoutManager = LinearLayoutManager(this)
        var listProgrammingLanguageAdapter = ListProgrammingLanguageAdapter(list)
        rvProgrammingLanguage.adapter = listProgrammingLanguageAdapter
    }

    private fun showRecyclerViewCardView() {
        rvProgrammingLanguage.layoutManager = LinearLayoutManager(this)
        var cardViewProgrammingLanguageAdapter = CardViewProgrammingLanguageAdapter(list)
        rvProgrammingLanguage.adapter = cardViewProgrammingLanguageAdapter

        cardViewProgrammingLanguageAdapter.setOnItemClickCallback(object: CardViewProgrammingLanguageAdapter.OnItemClickCallback {
            override fun onItemClicked(data : ProgrammingLanguage) {
                showSelectedData(data)
            }
        })
    }

    private fun showSelectedData(data : ProgrammingLanguage) {
        val detailItemActivity = Intent(this@MainActivity, DetailItemActivity::class.java)
        detailItemActivity.putExtra("EXTRA_NAME", data.name)
        detailItemActivity.putExtra("EXTRA_DESCRIPTION", data.description)
        detailItemActivity.putExtra("EXTRA_IMG", data.icon)
        startActivity(detailItemActivity)
    }

}
