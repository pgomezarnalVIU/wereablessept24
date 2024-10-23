package com.example.musicdb.interfaces.addedit

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class AddEditMusicViewModelTest {

    lateinit var addEditMusicViewModel: AddEditMusicViewModel

    val database = FakeDatabase()

    // Reusable JUnit4 TestRule to override the Main dispatcher
    class MainDispatcherRule(
        val testDispatcher: TestDispatcher = UnconfinedTestDispatcher(),
    ) : TestWatcher() {
        override fun starting(description: Description) {
            Dispatchers.setMain(testDispatcher)
        }

        override fun finished(description: Description) {
            Dispatchers.resetMain()
        }
    }

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Before
    fun setUp() {
        addEditMusicViewModel = AddEditMusicViewModel(database)
    }

    @Test
    fun `anyadir song nueva test`() =
        runTest {
            addEditMusicViewModel.onEvent(AddEditMusicEvent.EnteredTitle("Titulo de prueba"))
            addEditMusicViewModel.onEvent(AddEditMusicEvent.EnteredGroup("Grupo de prueba"))
            addEditMusicViewModel.onEvent(AddEditMusicEvent.SaveMusic)

            val songs = database.getSongs().first()
            assertEquals(1,songs.size)
        }

}