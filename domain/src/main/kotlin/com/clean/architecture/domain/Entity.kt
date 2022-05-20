package com.clean.architecture.domain

import java.util.Objects

abstract class Entity<ID: Identifier> constructor (id: ID) {

    init {
        Objects.requireNonNull(id, "'id' não pode ser nulo")
    }

}
