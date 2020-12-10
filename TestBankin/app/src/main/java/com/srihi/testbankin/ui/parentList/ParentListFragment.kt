package com.srihi.testbankin.ui.parentList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.srihi.domain.model.Category
import com.srihi.testbankin.R
import timber.log.Timber


private lateinit var parentViewModel: ParentListViewModel
private lateinit var parentListAdapter: ParentListAdapter

class ParentListFragment : Fragment(), ParentListAdapter.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parentViewModel = ViewModelProvider(this).get(ParentListViewModel::class.java)
        parentListAdapter = ParentListAdapter(requireContext())
        parentListAdapter.onItemClickListener = this
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("onCreateView()")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_parent_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObservers()
    }

    private fun initView() {
        recycler_view_categories_list.layoutManager = GridLayoutManager(context, 2)
        recycler_view_categories_list.adapter = parentListAdapter
    }

    private fun initObservers() {
        parentViewModel.itemsFragmentState.observe(
            viewLifecycleOwner,
            Observer { state -> onStateChange(state) })
    }

    private fun onStateChange(fragmentState: FragmentState) =
        when (fragmentState) {
            FragmentState.Loading -> showLoadingState()
            is FragmentState.Loaded -> showLoadedState(fragmentState)
            is FragmentState.Error -> showErrorState(fragmentState)
        }

    private fun showLoadingState() {
        Timber.i("Loading state")
        progress_bar_loading_items.visibility = View.VISIBLE
    }

    private fun showLoadedState(loaded: FragmentState.Loaded) {
        Timber.i("Loaded state")
        Timber.i("Loaded state")
        progress_bar_loading_items.visibility = View.GONE

        parentListAdapter.categories = loaded.categories
        albumsListAdapter.notifyDataSetChanged()
    }

    private fun showErrorState(error: FragmentState.Error) {
        Timber.e("error ${error.message}")
        progress_bar_loading_items.visibility = View.GONE
    }

    sealed class FragmentState {
        object Loading : FragmentState()
        class Loaded(val categories: List<Category>) : FragmentState()
        class Error(val message: String) : FragmentState()
    }

    override fun onItemClick(category: Category) {
        Timber.i("Number station: ${category.id}")
        goToCategoryChild(category.id)
    }

    /**
     * To navigate to details fragment
     */
    private fun goToCategoryChild(number: Long) {
        // val action = StationListFragmentDirections.actionListFragmentToDetailFragment(number)
        //Navigation.findNavController(recycler_view_categories_list).navigate(action)
    }
}