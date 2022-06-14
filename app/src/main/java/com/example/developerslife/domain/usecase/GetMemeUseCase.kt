package com.example.developerslife.domain.usecase

import com.example.developerslife.domain.repository.IMemeRepository

class GetMemeUseCase(private val memeRepository: IMemeRepository) {

    fun execute() {
        memeRepository.getMeme()
    }
}