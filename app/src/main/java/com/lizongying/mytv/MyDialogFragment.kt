package com.lizongying.mytv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.lizongying.mytv.databinding.DialogBinding


class MyDialogFragment(private val versionName: String, private val channelReversal: Boolean) :
    DialogFragment() {

    private var _binding: DialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogBinding.inflate(inflater, container, false)
        _binding?.version?.text =
            "当前版本: $versionName\n获取最新: https://github.com/lizongying/my-tv/releases/"

        val switchView = _binding?.switchView
        switchView?.isChecked = channelReversal
        switchView?.setOnCheckedChangeListener { _, isChecked ->
            (activity as MainActivity).saveChannelReversal(isChecked)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "MyDialogFragment"
    }
}

