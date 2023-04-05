package com.example.coder_proprement.ui.comics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.iem.model.Comic
import fr.iem.useCase.GetAllComicsUseCase
import kotlinx.coroutines.launch

class ComicsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    val data: MutableLiveData<MutableList<Comic>>
        get() = _data
    private val _data = MutableLiveData<MutableList<Comic>>()

    init {
        getEveryComic()

    }

    private fun getEveryComic () {
        viewModelScope.launch {
            GetAllComicsUseCase().invoke()?.let {
                data.postValue(it.data.results.toMutableList())
            }

            //data.value = GetAllComicsUseCase().invoke()!!.data.results.toMutableList()
        }
    }

}