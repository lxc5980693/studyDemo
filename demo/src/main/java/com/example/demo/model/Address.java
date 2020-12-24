package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.model
 * @ClassName: Address
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-11-12  10:18
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String addressName;
    private Long addressCode;
}
