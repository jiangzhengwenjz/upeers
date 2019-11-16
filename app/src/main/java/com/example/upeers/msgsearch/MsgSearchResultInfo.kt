package com.example.upeers.msgsearch

import com.example.upeers.ui.message.MessageUserInfo
import java.util.*

class MsgSearchResultInfo(label: String,
                          name: String,
                          active: Boolean,
                          lastMsg: String,
                          timeLastMsg: Date,
                          avatar: Int,
                          val searchResultContent : List<String>) : MessageUserInfo(label, name, active, lastMsg, timeLastMsg, avatar) {
}
