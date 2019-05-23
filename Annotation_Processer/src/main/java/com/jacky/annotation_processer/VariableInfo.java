package com.jacky.annotation_processer;

import javax.lang.model.element.VariableElement;

/**
 * Created by jackyshu at 2019/5/23
 *
 * @description:
 */
public class VariableInfo {
    // 被注解 View 的 Id 值
    int viewId;
    // 被注解 View 的信息：变量名称、类型
    VariableElement variableElement;

    public VariableElement getVariableElement() {
        return variableElement;
    }

    public void setVariableElement(VariableElement variableElement) {
        this.variableElement = variableElement;
    }

    public int getViewId() {
        return viewId;
    }

    public void setViewId(int viewId) {
        this.viewId = viewId;
    }
}
