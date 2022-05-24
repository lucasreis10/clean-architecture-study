package com.clean.architecture.application

abstract class NullaryUseCase<OUT> {

    abstract fun execute(): OUT;

}
