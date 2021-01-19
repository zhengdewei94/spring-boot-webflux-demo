package com.zdw.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.Instant;

/**
 * entity
 *
 * @author zheng dewei
 * @since 2021-01-14 17:10:52
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class User {

    private String name;

    private Instant instant;
}
