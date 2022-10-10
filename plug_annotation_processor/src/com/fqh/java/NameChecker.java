package com.fqh.java;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/19 21:49:26
 */

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.*;
import javax.lang.model.util.ElementScanner8;
import javax.tools.Diagnostic.Kind.*;

import java.util.EnumSet;

import static javax.lang.model.element.ElementKind.*;
import static javax.lang.model.element.Modifier.*;
import static javax.tools.Diagnostic.Kind.WARNING;

/**
 * 程序命名规范的编译器插件
 * 程序名称不规范 将会输出一个编译器的WARNING信息
 */
public class NameChecker {

  private final Messager messager;

  NameCheckerScanner nameCheckerScanner = new NameCheckerScanner();

  NameChecker(ProcessingEnvironment processingEnv) {
    this.messager = processingEnv.getMessager();
  }

  /**
   * 对Java程序命名进行检查
   * <ul>
   * <li> 1.类或接口: 符合驼峰命名法 首字母大写
   * <li> 2.方法: 符合驼峰命名法 首字母小写
   * <li> 3.字段:
   * <li> 4.类 实例变量: 符合驼峰命名法 首字母小写
   * <li> 5.常量: 要求全部大写
   * </ul>
   */
  public void checkNames(Element element) {
    nameCheckerScanner.scan(element);
  }
  /**
   * 名称检查器实现类 继承JDK6 中新提供的ElementScanner<br>
   * 将会以Visitor模式方法抽象语法树的元素
   */
  private class NameCheckerScanner extends ElementScanner8<Void, Void> {

    @Override
    public Void visitType(TypeElement e, Void unused) {
      scan(e.getTypeParameters(), unused);
      checkCnameCase(e, true);
      super.visitType(e,unused);
      return null;
    }

    @Override
    public Void visitExecutable(ExecutableElement e, Void unused) {
      if (e.getKind() == METHOD) {
        Name name = e.getSimpleName();
        if (name.contentEquals(e.getEnclosingElement().getSimpleName()))
          messager.printMessage(WARNING, "一个普通方法  " + name + "  不应当与类名重复 避免与构造函数产生混淆", e);
        checkCnameCase(e, false);
      }
      super.visitExecutable(e,unused);
      return null;
    }


    /**
     * 检查变量名是否合法
     * @param e
     * @param unused
     * @return
     */
    @Override
    public Void visitVariable(VariableElement e, Void unused) {
      // 如果这个Variable是枚举或常量 则按照大写命名检查 否则按照驼峰命名规则检查
      if (e.getKind() == ENUM_CONSTANT || e.getConstantValue() != null || heuristicallyConstant(e)) {
        checkAllCaps(e);
      } else {
        checkCnameCase(e,false);
      }
      return null;
    }

    /**
     * 判断一个变量是否是常量
     * @param e
     * @return
     */
    private boolean heuristicallyConstant(VariableElement e) {
      if (e.getEnclosingElement().getKind() == INTERFACE) {
        return true;
      } else if (e.getKind() == FIELD && e.getModifiers().containsAll(EnumSet.of(PUBLIC, STATIC, FINAL))) {
        return true;
      } else {
        return false;
      }
    }

    /**
     * 检查传入的Element是否符合驼峰命名 如果不符合 则输出警告信息
     * @param e
     * @param initialCase
     */
    private void checkCnameCase(Element e, boolean initialCase) {
      String name = e.getSimpleName().toString();
      boolean previousUpper = false;
      boolean conventional = true;
      int firstCodePoint = name.codePointAt(0);

      if (Character.isUpperCase(firstCodePoint)) {
        previousUpper = true;
        if (!initialCase) {
          messager.printMessage(WARNING, "名称  " + name + "  应当以小写字母开头", e);
          return;
        }
      } else if (Character.isLowerCase(firstCodePoint)) {
        if (initialCase) {
          messager.printMessage(WARNING, "名称  " + name + "  应当以大写字母开头", e);
          return;
        }
      } else {
        conventional = false;
      }
      if (conventional) {
        int cp = firstCodePoint;
        for (int i = Character.charCount(cp); i < name.length(); i += Character.charCount(cp)) {
          cp = name.codePointAt(i);
          if (Character.isUpperCase(cp)) {
            if (previousUpper) {
              conventional = false;
              break;
            }
            previousUpper = true;
          } else {
            previousUpper = false;
          }
        }
      }
    }
  }

  private void checkAllCaps(Element e) {
    String name = e.getSimpleName().toString();
    boolean conventional = true;
    int firstCodePoint = name.codePointAt(0);

    if (!Character.isUpperCase(firstCodePoint)) {
      conventional = false;
    } else {
      boolean previousUnderscore = false;
      int cp = firstCodePoint;
      for (int i = Character.charCount(cp); i < name.length(); i += Character.charCount(cp)) {
        cp = name.codePointAt(i);
        if (cp == (int) '_') {
          if (previousUnderscore) {
            conventional = false;
            break;
          } else {
            previousUnderscore = false;
            if (!Character.isUpperCase(cp) && !Character.isDigit(cp)) {
              conventional = false;
              break;
            }
          }
        }
      }
    }
    if (!conventional) {
      messager.printMessage(WARNING, "常量  " + name + "  应当全部以大写字母或下划线命名 并且以字符开头", e);
    }
  }

}
