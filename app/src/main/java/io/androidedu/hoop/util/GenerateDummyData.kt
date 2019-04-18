package io.androidedu.hoop.util

import io.androidedu.hoop.R
import io.androidedu.hoop.model.CallModel
import io.androidedu.hoop.model.ChatModel
import io.androidedu.hoop.model.StatusModel


// Code with ❤️
//┌─────────────────────────────┐
//│ Created by Gökhan ÖZTÜRK    │
//│ ─────────────────────────── │
//│ GokhanOzturk@AndroidEdu.IO  │            
//│ ─────────────────────────── │
//│ 14.04.2019 - 11:05          │
//└─────────────────────────────┘

object GenerateDummyData {

    fun getDummyChatList(): ArrayList<ChatModel> = ArrayList<ChatModel>().apply {
        val chatModel = ChatModel(
                R.drawable.ic_launcher_background,
                "Can",
                "Hi bitch",
                "17.10.19")
        for(x in 0..10){
            add(chatModel)
        }
    }
}