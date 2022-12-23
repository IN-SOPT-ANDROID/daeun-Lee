package org.sopt.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import coil.api.load
import org.sopt.sample.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {
    private var _binding : FragmentGalleryBinding? = null
    private val binding : FragmentGalleryBinding
        get() = requireNotNull(_binding)

    private val launcher = registerForActivityResult(ActivityResultContracts.GetContent()){
        binding.ivSample.load(it)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding.btnImage.setOnClickListener{
          //  launcher.launch("image/*")
        //}

    }
}