package com.sparta.todotaskpartyapp.entity;

import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

public class QThread extends EntityPathBase<Thread> {
    private static final long serialVersionUID = 1L;

    public static final QThread thread = new QThread("thread");

    public final NumberPath<Long> id = createNumber("id", Long.class);
    public final StringPath title = createString("title");
    public final StringPath content = createString("content");

    public QThread(String variable) {
        super(Thread.class, variable);
    }

    public QThread(Class<? extends Thread> type, String variable) {
        super(type, variable);
    }
}
