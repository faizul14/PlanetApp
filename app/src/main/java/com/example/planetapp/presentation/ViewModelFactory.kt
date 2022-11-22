package com.example.planetapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.planetapp.core.di.Injection
import com.example.planetapp.core.domain.usecase.UseCase
import java.lang.IllegalArgumentException

class ViewModelFactory(val useCase: UseCase) : ViewModelProvider.NewInstanceFactory() {
    companion object{
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance() : ViewModelFactory =
            INSTANCE ?: synchronized(this){
                INSTANCE ?: ViewModelFactory(Injection.provideUseCase())
            }
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlanetViewModel::class.java)){
            return PlanetViewModel(useCase) as T
        }
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)){
            return DetailViewModel(useCase) as T
        }
        throw IllegalArgumentException ("Message ${modelClass.name}")
    }

}