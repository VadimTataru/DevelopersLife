package com.example.developerslife.domain.usecase

import com.example.developerslife.data.models.MemeModel
import com.example.developerslife.domain.repository.IMemeRepository
import io.reactivex.Single

class GetMemeUseCase(private val memeRepository: IMemeRepository) {

    fun execute(): Single<MemeModel> {
        return memeRepository.getMeme()
    }
}