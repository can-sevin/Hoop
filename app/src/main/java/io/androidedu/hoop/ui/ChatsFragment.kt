package io.androidedu.hoop.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import io.androidedu.hoop.Dao.ChatDao
import io.androidedu.hoop.Database.Daatabase
import io.androidedu.hoop.Entity.ChatEntity
import io.androidedu.hoop.R
import io.androidedu.hoop.adapter.ChatListAdapter
import io.androidedu.hoop.model.ChatModel
import kotlinx.android.synthetic.main.fragment_chats.*
import kotlin.concurrent.thread

class ChatsFragment : Fragment() {
    private var DataInstance:Daatabase? = null
    private var chatdao:ChatDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataInstance = Daatabase.getInstance(activity!!)
        chatdao = DataInstance!!.getChatDao()
        thread (start = true){
            DataToDB()
        }
    }
    private fun DataToDB() {
        if (chatdao?.retrieveAllChatList()!!.isEmpty()) {

            val chat1 = ChatEntity(PPhoto = R.drawable.yildiz,
                Name = "Yıldız Tilbe",
                Message = "Orospu Seyhan",
                Date = "26 Nisan")

            val chat2 = ChatEntity(PPhoto = R.drawable.banu,
                Name = "Banu Alkan",
                Message = "Ahlaksız bir kadın değilim",
                Date = "21 Nisan")

            val chat3 = ChatEntity(PPhoto = R.drawable.ersoy,
                Name = "Bülent Ersoy",
                Message = "Seni yolup,yerim yavrum",
                Date = "20 Nisan")

            val chat4 = ChatEntity(PPhoto = R.drawable.seda,
                Name = "Seda Bacı",
                Message = "Herkes kalbinin ekmeğini yer",
                Date = "21 Nisan")

            val chat5 = ChatEntity(PPhoto = R.drawable.seren,
                Name = "Seren Serengil",
                Message = "Gülben :(",
                Date = "19 Nisan")

            val chat6 = ChatEntity(PPhoto = R.drawable.gulben,
                Name = "Gülben Ergen",
                Message = "Zengin evli erkek yok mu?",
                Date = "12 Nisan")


            chatdao?.insertChat(chat1)
            chatdao?.insertChat(chat2)
            chatdao?.insertChat(chat3)
            chatdao?.insertChat(chat4)
            chatdao?.insertChat(chat5)
            chatdao?.insertChat(chat6)
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_chats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        thread (start = true){
            with(recycChatList) {
                adapter = ChatListAdapter(ReChatData()) { chatModel ->
                    Toast.makeText(activity, "${chatModel.userName}", Toast.LENGTH_SHORT).show()
                }
                layoutManager = GridLayoutManager(activity, 4)
            }
        }
    }

    private fun ReChatData(): ArrayList<ChatModel> {
        val chatModelList: ArrayList<ChatModel> = ArrayList()
        val chatEntityList = chatdao?.retrieveAllChatList()
        chatEntityList?.forEach {
            val chatModel = ChatModel(it.PPhoto, it.Name, it.Message, it.Date)
            chatModelList.add(chatModel)
        }

        if (chatModelList.isEmpty()) {
            val chatModel = ChatModel(R.drawable.ic_camera_black, "null", "null", "null")
            chatModelList.add(chatModel)
        }
        return chatModelList
    }


    companion object {
        @JvmStatic
        fun newInstance() = ChatsFragment()
    }
}
