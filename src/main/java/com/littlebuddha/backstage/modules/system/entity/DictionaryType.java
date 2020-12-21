package com.littlebuddha.backstage.modules.system.entity;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author ck
 * @date 2020/12/21 15:53
 */
public class DictionaryType {

    private String type;		// 类型
    private String description;		// 描述
    private List<DictionaryValue> dictValueList = Lists.newArrayList();		// 子表列表

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DictionaryValue> getDictValueList() {
        return dictValueList;
    }

    public void setDictValueList(List<DictionaryValue> dictValueList) {
        this.dictValueList = dictValueList;
    }
}
