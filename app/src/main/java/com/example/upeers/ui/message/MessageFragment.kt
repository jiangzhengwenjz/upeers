package com.example.upeers.ui.message

import android.os.Bundle
import android.view.*
import androidx.core.app.ActivityCompat.invalidateOptionsMenu
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.upeers.R

class MessageFragment : Fragment() {

    private lateinit var messageViewModel: MessageViewModel
    private lateinit var recyclerView: RecyclerView;
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        messageViewModel =
            ViewModelProviders.of(this).get(MessageViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_message, container, false)

        viewManager = LinearLayoutManager(activity)
        viewAdapter = MessageUserInfoAdapter(messageViewModel.mydata)

        recyclerView = root.findViewById<RecyclerView>(R.id.msg_recycler_view).apply {
            setHasFixedSize(true)

            layoutManager = viewManager

            adapter = viewAdapter
        }

        // val userInfoListView: RecyclerView = root.findViewById(R.id.msg_recycler_view)
        // messageViewModel.text.observe(this, Observer {
        //     textView.text = it
        // })

        activity?.invalidateOptionsMenu()
        setHasOptionsMenu(true);
        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.toolbar_menu, menu)
    }
}
