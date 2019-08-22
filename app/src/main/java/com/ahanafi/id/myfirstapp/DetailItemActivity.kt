package com.ahanafi.id.myfirstapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail_item.*

class DetailItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_item)

        val bundle : Bundle = intent.extras

        val name = bundle.getString("EXTRA_NAME")
        val description = bundle.getString("EXTRA_DESCRIPTION")
        val img_icon = bundle.getString("EXTRA_IMG")

        tv_name.text = name
        tv_description.text = description
        val iv_img_icon : ImageView = findViewById(R.id.img_icon)

        Glide.with(this)
            .load(img_icon)
            .into(iv_img_icon)
    }
}
