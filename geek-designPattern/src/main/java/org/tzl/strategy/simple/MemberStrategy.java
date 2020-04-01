package org.tzl.strategy.simple;

public interface MemberStrategy<T> {

    double calcPrice(T booksPrice);
}
