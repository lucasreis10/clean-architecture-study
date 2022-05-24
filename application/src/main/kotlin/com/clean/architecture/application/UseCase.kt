package com.clean.architecture.application

abstract class UseCase<INP, OUT> {

    abstract fun execute(input: INP): OUT?

}
