package com.gbjm.detail.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.gbjm.core.architecture.extensions.viewModelProvider
import com.gbjm.core.architecture.presentation.BaseFragment
import com.gbjm.detail.R
import com.gbjm.detail.databinding.FragmentCharacterDetailBinding
import com.gbjm.detail.ui.adapters.AppearanceListAdapter
import com.gbjm.detail.ui.entity.UiAppearanceRow
import com.gbjm.detail.ui.entity.UiCharacterDetail
import com.gbjm.detail.ui.entity.UiDetailHeader
import com.google.android.material.tabs.TabLayout
import com.squareup.picasso.Picasso
import javax.inject.Inject

class CharacterDetailFragment: BaseFragment<CharacterDetailViewModel, FragmentCharacterDetailBinding>() {
    //  private val characterDetailFragmentArgs: CharacterDetailFragmentArgs by navArgs()
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: CharacterDetailViewModel

    private var tabLayout: TabLayout? = null

    private lateinit var listAdapter: AppearanceListAdapter
    private lateinit var recycler : RecyclerView

    private lateinit var image: ImageView
    private lateinit var title: TextView
    private lateinit var description: TextView

    /**
     * get the layout id
     * @return the layout Id
     */
    override fun getLayoutRes(): Int {
        return R.layout.fragment_character_detail
    }

    /**
     * get the view model
     * @return the view model
     */
    override fun getViewModel(): CharacterDetailViewModel {
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
        viewModel.uiCharacterDetail.observe(this, Observer { detail ->
            renderHeader(detail.header)
            tabLayout?.let { tabLayout ->
                if (tabLayout.tabCount == 0) {
                    if (detail.comics.isNotEmpty()) {
                        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.comics)))
                    }
                    if (detail.series.isNotEmpty()) {
                        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.series)))
                    }
                    if (detail.stories.isNotEmpty()) {
                        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.stories)))
                    }
                    if (detail.events.isNotEmpty()) {
                        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.events)))
                    }
                }
            }
            setupTabLayout(detail)
        })

        viewModel.uiError.observe(this, Observer {
            if (it!=null && !it.isEmpty()) {
                showError(it)
            }
        })
    }

    private fun setupTabLayout(uiCharacterDetail: UiCharacterDetail) {
        tabLayout?.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    if (tab.text == getString(R.string.comics)){
                        renderAppearance(uiCharacterDetail.comics)
                    } else if (tab.text == getString(R.string.series)) {
                        renderAppearance(uiCharacterDetail.series)
                    } else if (tab.text == getString(R.string.stories)) {
                        renderAppearance(uiCharacterDetail.stories)
                    } else if (tab.text == getString(R.string.events)) {
                        renderAppearance(uiCharacterDetail.events)
                    }
                }
            }
        })

        tabLayout?.getTabAt(1)?.select()
        tabLayout?.getTabAt(0)?.select()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this@CharacterDetailFragment
        recycler = binding.recycler
        image = binding.ivCharacterDetail
        title = binding.tvCharacterTitle
        description = binding.tvCharacterDescription

        tabLayout = binding.tabLayout

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listAdapter = AppearanceListAdapter()
        recycler.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recycler.adapter = listAdapter

        arguments?.getInt("characterId")?.let {
            viewModel.onCharacterDetailNeeded(it)
        }
    }

    fun renderHeader(detailHeader: UiDetailHeader) {
        Picasso.get().isLoggingEnabled = true
        Picasso.get()
            .load(detailHeader.image)
            .fit()
            .centerCrop()
            .placeholder(R.drawable.place_holder)
            .error(R.drawable.image_error)
            .into(image)

        title.text = detailHeader.title
        description.text = detailHeader.description
    }

    fun renderAppearance(appearanceList: List<UiAppearanceRow>) {
        listAdapter.set(appearanceList)
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