package com.example.neighbors.fragment

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.NavigationListener
import com.example.neighbors.MainActivity
import com.example.neighbors.R
import com.example.neighbors.adapters.ListNeighborHandler
import com.example.neighbors.adapters.ListNeighborsAdapter
import com.example.neighbors.data.NeighborRepository
import com.example.neighbors.models.Neighbor
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ListNeighborsFragment: Fragment(), ListNeighborHandler {

    private lateinit var recyclerView: RecyclerView
    private lateinit var addNeighbor: FloatingActionButton

    /**
     * Fonction permettant de définir une vue à attacher à un fragment
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_neighbors_fragment, container, false)

        (activity as? NavigationListener)?.let {
            it.updateTitle(R.string.list_neighbours_toolbar_name)
        }

        recyclerView = view.findViewById(R.id.neighbors_list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )

        addNeighbor = view.findViewById(R.id.addNeighbor)
        addNeighbor.setOnClickListener {
            (activity as? NavigationListener)?.let {
                it.showFragment(AddNeighbourFragment())
            }
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val neighbors = NeighborRepository.getInstance().getNeighbours()
        val adapter = ListNeighborsAdapter(neighbors)
        recyclerView.adapter = adapter
    }

    override fun onDeleteNeighbor(neighbor: Neighbor) {

        println(neighbor.name)
        NeighborRepository.getInstance().deleteNeighbour(neighbor)

        /*

        Nous n'arrivons pas à afficher le alertDialog lors du clic sur le bouton delete ...

        val alert = AlertDialog.Builder(getContext())

        // set message of alert dialog
        alert.setMessage("Do you want to delete this neighbor?")
            // if the dialog is cancelable
            .setCancelable(false)
            // positive button text and action
            .setPositiveButton(R.string.ok, DialogInterface.OnClickListener {
                    dialog, id -> NeighborRepository.getInstance().deleteNeighbour(neighbor)
            })
            // negative button text and action
            .setNegativeButton(R.string.cancel, DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })

        val alertDialog: AlertDialog = alert.create()
        // Set other dialog properties
        alertDialog.show()
    */
    }

}