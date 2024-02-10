package com.cheezycode.notesample.di

import com.cheezycode.notesample.repository.NoteRepository
import com.cheezycode.notesample.repository.UserRepository
import org.koin.dsl.module

/*
 * Created by Shahid Iqbal on 2/9/2024.
 */

val REPO_MODULE = module {
    single { NoteRepository(get()) }
    single { UserRepository(get()) }
}