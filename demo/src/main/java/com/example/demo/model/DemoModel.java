package com.example.demo.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.model
 * @ClassName: DemoModel
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-11-19  09:52
 * @Version: 1.0
 */
@Data
public class DemoModel {
    @JSONField(name = "organization_id")
    private String organizationId;

    @JSONField(name = "organization_name")
    private String organizationName;

    @JSONField(name = "organization_abbreviation")
    private String organizationAbbreviation;
}
