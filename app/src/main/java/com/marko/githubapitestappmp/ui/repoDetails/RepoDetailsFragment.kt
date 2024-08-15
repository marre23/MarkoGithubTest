package com.marko.githubapitestappmp.ui.repoDetails

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.marko.githubapitestappmp.GHTApp
import com.marko.githubapitestappmp.R
import com.marko.githubapitestappmp.databinding.FragmentRepoDetailsBinding
import com.marko.githubapitestappmp.ui.repoDetails.compose.ShowComposeView
import com.marko.githubapitestappmp.ui.repoDetails.compose.ShowTagList
import com.marko.githubapitestappmp.utils.hide
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

            hideProgress.observe(viewLifecycleOwner) {
                setData()
            }
        }
    }

    private fun setData() {
        binding.apply {
            progressBarLoadingData.hide()
            composeViewRepo.setContent {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    repoDetailsViewModel.apply {
                        repoItem.value?.let { repoItem ->
                            ShowComposeView(data = repoItem)
                        }
                        repoTags.value?.let { list ->
                            if (list.isNotEmpty()) {
                                ShowTagList(list)
                            } else {
                                Text(
                                    modifier = Modifier.align(Alignment.CenterHorizontally),
                                    text = stringResource(R.string.no_drafts),
                                    textAlign = TextAlign.Center,
                                    fontSize = 20.sp,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}