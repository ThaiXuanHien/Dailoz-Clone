package com.hienthai.dailoz_clone.screens.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.hienthai.dailoz_clone.R

sealed class Screen(
    val route: String,
    val icon: Int
) {
    object TabHome : Screen("tabhome", R.drawable.ic_home)
    object TabDocument : Screen("tabdocument",  R.drawable.ic_document)
    object TabCreate : Screen("tabcreate", R.drawable.ic_plus)
    object TabActivity : Screen("tabactivity",  R.drawable.ic_acitivity)
    object TabFolder : Screen("tabfolder", R.drawable.ic_folder_tab)
}