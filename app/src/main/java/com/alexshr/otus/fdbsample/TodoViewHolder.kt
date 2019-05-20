package com.alexshr.otus.fdbsample

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

/**
 * Created by alexshr on 09.05.2019.
 */
class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(
        todo: Todo,
        editClickListener: View.OnClickListener,
        deleteClickListener: View.OnClickListener
    ) {
        itemView.tag = todo.id
        itemView.titleTw.text = todo.title
        itemView.timestampTw.text = todo.timestamp

        itemView.editBtn.setOnClickListener(editClickListener)
        itemView.delBtn.setOnClickListener(deleteClickListener)
    }
}