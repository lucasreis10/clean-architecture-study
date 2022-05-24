package com.clean.architecture.application

abstract class UnitUseCase<IN> {

    abstract fun execute(input: IN): Void

}
