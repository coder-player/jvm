package com.fqh.java;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/18 21:54:46
 */
public abstract class Animal {

  public abstract void eat();

  @Override
  public String toString() {
    return "我是: " + this.getClass().getSimpleName();
  }

}
