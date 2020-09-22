package com.funke.firebase.fbsample

import android.os.Parcelable
import com.google.firebase.database.IgnoreExtraProperties
import kotlinx.android.parcel.Parcelize

/**
 * Created by alexshr on 09.05.2019.
 */
@Parcelize
@IgnoreExtraProperties
class Todo(var id: String = "", var title: String = "", var timestamp: String = "") : Parcelable {
}

