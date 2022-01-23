package com.gbjm.characters.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gbjm.core.architecture.extensions.viewModelProvider
import com.gbjm.core.architecture.presentation.BaseFragment
import com.gbjm.characters.R
import com.gbjm.characters.databinding.FragmentListBinding
import com.gbjm.characters.ui.adapter.CharacterListAdapter
import com.gbjm.characters.ui.entity.UiCharacterRow
import com.gbjm.navigation.NavigationFlow
import com.gbjm.navigation.ToFlowNavigable
import javax.inject.Inject

class CharacterListFragment : BaseFragment<CharacterListViewModel, FragmentListBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: CharacterListViewModel

    private lateinit var listAdapter: CharacterListAdapter
    private lateinit var recycler : RecyclerView
    private lateinit var progress: ProgressBar

    /**
     * get the layout id
     * @return the layout Id
     */
    override fun getLayoutRes(): Int {
        return R.layout.fragment_list
    }

    /**
     * get the view model
     * @return the view model
     */
    override fun getViewModel(): CharacterListViewModel {
        viewModel = viewModelProvider(viewModelFactory)
        return viewModel
    }

    /**
     * Called to do initial creation of a fragment
     * @param savedInstanceState - If the fragment is being re-created from
     * a previous saved state, this is the state.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getViewModel()
        setupObservation()


    }

    /**
     * Observe the observables and perform the actions
     */
    private fun setupObservation() {
        viewModel.uiCharacterList.observe(this, Observer { characterList ->
            progress.visibility = View.GONE
            render(characterList)
        })

        viewModel.uiError.observe(this, Observer {
            progress.visibility = View.GONE
            if (it!=null && !it.isEmpty()) {
                showError(it)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this@CharacterListFragment
        recycler = binding.recycler
        progress  =binding.progressNetwork

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler = view.findViewById(R.id.recycler)
        listAdapter = CharacterListAdapter()

        recycler.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recycler.adapter = listAdapter

        progress.visibility = View.VISIBLE
        viewModel.onListNeeded()
    }

    fun render(list: List<UiCharacterRow>) {
        listAdapter.set(list)
        listAdapter.listener(object : CharacterListAdapter.CharacterListener {
            override fun onCharacterClicked(character: UiCharacterRow) {
                (requireActivity() as ToFlowNavigable).navigateToFlow(NavigationFlow.DetailsFlow(character.id))
            }
        })
        val layoutManager = recycler.layoutManager
        if (layoutManager is LinearLayoutManager) {
            val linearLayoutManager = layoutManager as LinearLayoutManager?
            linearLayoutManager?.scrollToPositionWithOffset(0, 0)
        }
    }

    fun showError(errorMessage: String) {
        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
    }
}