package com.clml.clmaplication.interactor;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0006\u0010\u000e\u001a\u00020\bR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/clml/clmaplication/interactor/LoginInteractor;", "", "()V", "repo", "Lcom/clml/clmaplication/repository/LoginRepository;", "getRepo", "()Lcom/clml/clmaplication/repository/LoginRepository;", "forgotPassword", "", "login", "Lcom/clml/clmaplication/domain/login/LoginResult;", "data", "Lcom/clml/clmaplication/domain/login/LoginData;", "(Lcom/clml/clmaplication/domain/login/LoginData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "register", "app_debug"})
public final class LoginInteractor {
    @org.jetbrains.annotations.NotNull()
    private final com.clml.clmaplication.repository.LoginRepository repo = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.clml.clmaplication.repository.LoginRepository getRepo() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object login(@org.jetbrains.annotations.NotNull()
    com.clml.clmaplication.domain.login.LoginData data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.clml.clmaplication.domain.login.LoginResult> p1) {
        return null;
    }
    
    public final void forgotPassword() {
    }
    
    public final void register() {
    }
    
    public LoginInteractor() {
        super();
    }
}