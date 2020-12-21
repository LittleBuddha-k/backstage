package com.littlebuddha.backstage.modules.system.entity;

/**
 * @author ck
 * @date 2020/12/21 15:55
 */
public class DictionaryValue {

    private String label;		// 标签名
    private String value;		// 键值
    private String sort;		// 排序
    private DictionaryType dictType;		// 外键 父类

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public DictionaryType getDictType() {
        return dictType;
    }

    public void setDictType(DictionaryType dictType) {
        this.dictType = dictType;
    }
}
