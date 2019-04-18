package io.androidedu.hoop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.hoop.R
import io.androidedu.hoop.model.ChatModel


class ChatListViewHolder(parent: ViewGroup)
    : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).
    inflate(R.layout.adapter_item_chat_list, parent, false)) {

    private val imgProfile: ImageView
    private val txtUserName: TextView
    private val txtUserMessage: TextView
    private val txtDate: TextView

    init {
        imgProfile = itemView.findViewById(R.id.imgProfile)
        txtUserName = itemView.findViewById(R.id.txt_contact)
        txtUserMessage = itemView.findViewById(R.id.last_msj)
        txtDate = itemView.findViewById(R.id.txtDate)
    }

    fun bind(chatModel: ChatModel, onItemClickListener: (chatModel: ChatModel) -> Unit) {

        imgProfile.setBackgroundResource(chatModel.profilePhoto)
        txtUserName.text = chatModel.userName
        txtUserMessage.text = chatModel.userMessage
        txtDate.text = chatModel.date

        itemView.setOnClickListener {
            onItemClickListener(chatModel)
        }
    }
}