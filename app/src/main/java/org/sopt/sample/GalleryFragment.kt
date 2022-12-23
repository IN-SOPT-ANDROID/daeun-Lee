package org.sopt.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Gallery
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import coil.api.load
import org.sopt.sample.base.BindingFragment
import org.sopt.sample.databinding.FragmentGalleryBinding
import org.sopt.sample.databinding.FragmentSearchBinding

class GalleryFragment : BindingFragment<FragmentGalleryBinding>(R.layout.fragment_gallery)
