package com.fqh.java;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/19 21:29:33
 */
@SupportedAnnotationTypes("*") // 支持所有annotations
@SupportedSourceVersion(SourceVersion.RELEASE_8)  // 支持jdk8的代码
public class NameCheckProcessor extends AbstractProcessor {

  private NameChecker nameChecker;

  @Override
  public synchronized void init(ProcessingEnvironment processingEnv) {
    super.init(processingEnv);
    nameChecker = new NameChecker(processingEnv);
  }

  /**
   * 初始化命名检查插件
   * @param annotations
   * @param roundEnv
   * @return
   */
  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    if (!roundEnv.processingOver()) {
      for (Element element : roundEnv.getRootElements()) {
        nameChecker.checkNames(element);
      }
    }
    return false;
  }
}
