package com.example.upeers.msglist

class Message(val message: String,
              val sender: User,
              val createdAt: Long)
{

}

class User (val nickname: String, val profileAvatar: Int)
{

}
