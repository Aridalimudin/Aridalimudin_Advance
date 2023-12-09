package com.example.aridalimudin

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
public class user (
    val username:String,
    val password:String
): Parcelable

