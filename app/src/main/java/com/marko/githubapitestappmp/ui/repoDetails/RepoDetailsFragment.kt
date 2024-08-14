package com.marko.githubapitestappmp.ui.repoDetails

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.marko.githubapitestappmp.GHTApp
import com.marko.githubapitestappmp.databinding.FragmentRepoDetailsBinding
import com.marko.githubapitestappmp.ui.repoDetails.compose.ShowComposeView
import com.marko.githubapitestappmp.ui.repoDetails.compose.ShowTagList
import javax.inject.Inject

class RepoDetailsFragment : Fragment() {

    private var _binding: FragmentRepoDetailsBinding? = null
    private val binding get() = _binding!!

    private val args: RepoDetailsFragmentArgs by navArgs()

    @Inject
    lateinit var repoDetailsViewModel: RepoDetailsViewModel

    override fun onAttach(context: Context) {
        (requireActivity().application as GHTApp).appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRepoDetailsBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        repoDetailsViewModel.apply {
            repoName = args.repoName

            fetchData()

            repoItem.observe(viewLifecycleOwner) {
                setData()
            }
            repoTags.observe(viewLifecycleOwner){
                setData()
            }
        }
    }

    private fun setData() {
        binding.composeViewRepo.setContent {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                repoDetailsViewModel.apply {
                    repoItem.value?.let { repoItem ->
                        ShowComposeView(data = repoItem)
                    }
                    repoTags.value?.let { list->
                        if(list.isNotEmpty()){
                            ShowTagList(list)
                        }
                    }
                }
            }

        }
    }
}