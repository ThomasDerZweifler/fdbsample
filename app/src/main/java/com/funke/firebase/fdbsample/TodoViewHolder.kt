package com.funke.firebase.fbsample

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item.*

/**
Created by alexshr on 09.05.2019.

implements LayoutContainer ("kotlin for android developers" 15.2)
for use cache and direct access to container views

 */
class TodoViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(
        todo: Todo,
        editClickListener: View.OnClickListener,
        deleteClickListener: View.OnClickListener
    ) {
        containerView.tag = todo.id
        titleTw.text = todo.title
        timestampTw.text = todo.timestamp

        editBtn.setOnClickListener(editClickListener)
        delBtn.setOnClickListener(deleteClickListener)
    }
}