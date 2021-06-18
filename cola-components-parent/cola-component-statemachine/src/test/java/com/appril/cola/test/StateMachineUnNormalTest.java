package com.appril.cola.test;

import com.appril.cola.statemachine.Action;
import com.appril.cola.statemachine.Condition;
import com.appril.cola.statemachine.StateMachine;
import com.appril.cola.statemachine.builder.StateMachineBuilder;
import com.appril.cola.statemachine.builder.StateMachineBuilderFactory;
import com.appril.cola.statemachine.impl.StateMachineException;
import org.junit.Assert;
import org.junit.Test;

/**
 * StateMachineUnNormalTest
 *
 * @author Frank Zhang
 * @date 2020-02-08 5:52 PM
 */
public class StateMachineUnNormalTest {

    @Test
    public void testConditionNotMeet(){
        StateMachineBuilder<StateMachineTest.States, StateMachineTest.Events, StateMachineTest.Context> builder = StateMachineBuilderFactory.create();
        builder.externalTransition()
                .from(StateMachineTest.States.STATE1)
                .to(StateMachineTest.States.STATE2)
                .on(StateMachineTest.Events.EVENT1)
                .when(checkConditionFalse())
                .perform(doAction());

        StateMachine<StateMachineTest.States, StateMachineTest.Events, StateMachineTest.Context> stateMachine = builder.build("NotMeetConditionMachine");
        StateMachineTest.States target = stateMachine.fireEvent(StateMachineTest.States.STATE1, StateMachineTest.Events.EVENT1, new StateMachineTest.Context());
        Assert.assertEquals(StateMachineTest.States.STATE1,target);
    }


    @Test(expected = StateMachineException.class)
    public void testDuplicatedTransition(){
        StateMachineBuilder<StateMachineTest.States, StateMachineTest.Events, StateMachineTest.Context> builder = StateMachineBuilderFactory.create();
        builder.externalTransition()
                .from(StateMachineTest.States.STATE1)
                .to(StateMachineTest.States.STATE2)
                .on(StateMachineTest.Events.EVENT1)
                .when(checkCondition())
                .perform(doAction());

        builder.externalTransition()
                .from(StateMachineTest.States.STATE1)
                .to(StateMachineTest.States.STATE2)
                .on(StateMachineTest.Events.EVENT1)
                .when(checkCondition())
                .perform(doAction());
    }

    @Test(expected = StateMachineException.class)
    public void testDuplicateMachine(){
        StateMachineBuilder<StateMachineTest.States, StateMachineTest.Events, StateMachineTest.Context> builder = StateMachineBuilderFactory.create();
        builder.externalTransition()
                .from(StateMachineTest.States.STATE1)
                .to(StateMachineTest.States.STATE2)
                .on(StateMachineTest.Events.EVENT1)
                .when(checkCondition())
                .perform(doAction());

        builder.build("DuplicatedMachine");
        builder.build("DuplicatedMachine");
    }

    private Condition<StateMachineTest.Context> checkCondition() {
        return (ctx) -> {return true;};
    }

    private Condition<StateMachineTest.Context> checkConditionFalse() {
        return (ctx) -> {return false;};
    }

    private Action<StateMachineTest.States, StateMachineTest.Events, StateMachineTest.Context> doAction() {
        return (from, to, event, ctx)->{
            System.out.println(ctx.operator+" is operating "+ctx.entityId+"from:"+from+" to:"+to+" on:"+event);
        };
    }
}
