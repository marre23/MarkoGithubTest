package com.marko.githubapitestappmp.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.marko.domain.common.ResponseResult
import com.marko.githubapitestappmp.GHTApp
import com.marko.githubapitestappmp.databinding.FragmentHomeBinding
import com.marko.githubapitestappmp.ui.home.adapters.UserListener
import com.marko.githubapitestappmp.ui.home.adapters.UsersAdapter
import com.marko.githubapitestappmp.utils.Status
import com.marko.githubapitestappmp.utils.hide
import com.marko.githubapitestappmp.utils.show
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var homeViewModel: HomeViewModel

    lateinit var usersRepoAdapter: UsersAdapter

    override fun onAttach(context: Context) {
        (requireActivity().application as GHTApp).appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        usersRepoAdapter = UsersAdapter(object : UserListener {
            override fun onUserClick(name: String) {
                homeViewModel.getData()
            }
        })

        with(binding) {
            recyclerViewUserRepos.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = usersRepoAdapter
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.apply {
            getData()

            reposDataLoading.observe(viewLifecycleOwner) {
                setVisibleItem(Status.LOADING)
            }

            reposDataError.observe(viewLifecycleOwner) {
                setVisibleItem(Status.ERROR)
            }

            reposData.observe(viewLifecycleOwner) {
                it?.let {
                    usersRepoAdapter.setData(it)
                    setVisibleItem(Status.SHOW_DATA)
                }
            }
        }
    }

    private fun setVisibleItem(status: Status) {
        with(binding) {
            progressBarLoading.hide()
            recyclerViewUserRepos.hide()
            imageViewError.hide()
            when (status) {
                Status.LOADING -> progressBarLoading.show()
                Status.SHOW_DATA -> recyclerViewUserRepos.show()
                Status.ERROR -> imageViewError.show()
            }
        }
    }
}