package com.bstudio.domain.base

abstract class BaseUseCase<InputData, OutputData> {
    abstract fun execute(inputData: InputData?): OutputData?
}