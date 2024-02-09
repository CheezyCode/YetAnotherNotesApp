package com.cheezycode.notesample.di;

import com.cheezycode.notesample.ui.login.AuthViewModel
import com.cheezycode.notesample.ui.note.NoteViewModel
import com.cheezycode.notesample.utils.TokenManager
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/*
 * Created by Shahid Iqbal on 2/9/2024.
 */

val APP_MODULE = module {

    single { TokenManager(get()) }
    viewModel { AuthViewModel(get()) }
    viewModel { NoteViewModel(get()) }
}