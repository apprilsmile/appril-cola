package com.appril.cola.test.command;

import com.appril.cola.test.TestsContainer;

/**
 * TestClassRunCmd
 *
 * @author Frank Zhang
 * @date 2020-11-17 4:42 PM
 */
public class TestClassRunCmd extends AbstractCommand {
    private String className;

    public TestClassRunCmd(String cmdRaw) {
        super(cmdRaw);
        this.className = cmdRaw;
    }

    @Override
    protected void action() {
        try {
            TestsContainer.getTestExecutor().execute(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getClassName() {
        return className;
    }
}
