package com.communisolve.runningtrackerapp.ui.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.communisolve.runningtrackerapp.R
import com.communisolve.runningtrackerapp.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class RunFragment:Fragment(R.layout.fragment_run) {

    private val viewModel:MainViewModel by viewModels()
}