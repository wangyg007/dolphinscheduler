package org.apache.dolphinscheduler.extract.base.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserServiceImpl implements UserSevice{


    @Override
    public void select() {
        log.info("select ...");
    }

    @Override
    public void insert() {
        log.info("insert ...");
    }
}
