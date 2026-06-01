package com.tyron.builder.api.component.impl

class ReadOnlyMutableSet<E>(
    private val mutableSet: MutableSet<E>,
    private val addErrorMessage: String,
): ReadOnlyMutableCollection<E>(mutableSet, addErrorMessage), MutableSet<E> {

    override val size: Int
        get() = mutableSet.size

    override fun add(element: E): Boolean {
        throw UnsupportedOperationException(addErrorMessage)
    }

    override fun addAll(elements: Collection<E>): Boolean {
        throw UnsupportedOperationException(addErrorMessage)
    }

    override fun clear() {
        mutableSet.clear()
    }

    override fun contains(element: E): Boolean {
        return mutableSet.contains(element)
    }

    override fun containsAll(elements: Collection<E>): Boolean {
        return mutableSet.containsAll(elements)
    }

    override fun isEmpty(): Boolean {
        return mutableSet.isEmpty()
    }

    override fun remove(element: E): Boolean {
        throw UnsupportedOperationException(addErrorMessage)
    }

    override fun removeAll(elements: Collection<E>): Boolean {
        throw UnsupportedOperationException(addErrorMessage)
    }

    override fun retainAll(elements: Collection<E>): Boolean {
        throw UnsupportedOperationException(addErrorMessage)
    }

    override fun iterator(): MutableIterator<E> {
        return super.iterator()
    }
}