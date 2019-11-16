package com.example.upeers.msglist

import android.net.Uri
import java.net.URI

class Message(val message: String,
              val sender: User,
              val createdAt: Long,
              val isImage: Boolean = false,
              val uri: Uri? = null)
{

}


class User (val nickname: String, val profileAvatar: Int)
{

}
