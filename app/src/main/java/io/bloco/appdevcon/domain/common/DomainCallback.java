package io.bloco.appdevcon.domain.common;

public interface DomainCallback<T> {

  void onSuccess(T t);

  void onError(Throwable throwable);
}
