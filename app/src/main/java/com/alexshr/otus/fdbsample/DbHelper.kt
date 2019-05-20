package com.alexshr.otus.fdbsample

import androidx.lifecycle.LifecycleOwner
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.text.DateFormat
import java.util.*

/**
 * Created by alexshr on 19.05.2019.
 */
const val PATH = "todos"
const val TITLE_PATH = "title"
const val TIMESTAMP_PATH = "timestamp"

class DbHelper {
    private val todosRef: DatabaseReference

    init {
        todosRef = FirebaseDatabase.getInstance().getReference(PATH)
        todosRef.keepSynced(true)
    }

    public fun saveTodo(todo: Todo) {
        if (todo.id == "") createTodo(todo)
        else updateTodo(todo)
    }

    private fun createTodo(todo: Todo) {

        todo.id = todosRef.push().key!!
        todo.timestamp = getTimestamp()
        todosRef.child(todo.id).setValue(todo)
    }

    private fun updateTodo(todo: Todo) {

        todosRef.child(todo.id).child(TITLE_PATH).setValue(todo.title)
        todosRef.child(todo.id).child(TIMESTAMP_PATH).setValue(getTimestamp())
    }

    public fun deleteTodo(todo: Todo) {
        todosRef.child(todo.id).setValue(null)
    }

    public fun getRecyclerOptions(owner: LifecycleOwner) = FirebaseRecyclerOptions.Builder<Todo>()
        .setQuery(todosRef.orderByKey(), Todo::class.java)
        .setLifecycleOwner(owner)
        .build()

    private fun getTimestamp(): String {
        val date = Calendar.getInstance().time
        val dateFormat = DateFormat.getDateTimeInstance()
        return dateFormat.format(date)
    }
}