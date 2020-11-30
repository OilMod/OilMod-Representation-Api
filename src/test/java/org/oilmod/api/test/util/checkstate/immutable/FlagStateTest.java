package org.oilmod.api.test.util.checkstate.immutable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.oilmod.api.util.checkstate.CheckState;
import org.oilmod.api.util.checkstate.immutable.FlagState;

import static org.junit.jupiter.api.Assertions.*;

class FlagStateTest {
    CheckState cs;

    @BeforeEach
    void init() {
        cs = new CheckState();
    }

    @Test
    void test() {
        cs.requireMaxBackup(1);
        cs.backupState();
        FlagState state = cs.getTag(this, FlagState.FACTORY);

        assertFalse(state.hasFlag());
        state.setFlag();
        assertTrue(state.hasFlag());

        cs.revertState();
        assertFalse(state.hasFlag());


        cs.backupState();
        state.setFlag();
        cs.confirmState();

        assertTrue(state.hasFlag());
    }


    @Test
    void testArray() {
        cs.requireMaxBackup(1);
        cs.backupState();
        FlagState.FlagArrayState state = cs.getTag(this, FlagState.FACTORY_ARRAY);

        assertFalse(state.isInUse());
        state.assureCreated(2);
        assertTrue(state.isInUse());


        assertFalse(state.hasFlag(0));
        state.setFlag(0);
        assertTrue(state.hasFlag(0));


        assertFalse(state.hasFlag(1));
        state.setFlag(1);
        assertTrue(state.hasFlag(1));
        assertTrue(state.hasFlag(0));


        cs.revertState();
        assertFalse(state.isInUse());



        cs.backupState();

        assertFalse(state.isInUse());
        state.assureCreated(3);
        assertTrue(state.isInUse());


        assertFalse(state.hasFlag(0));
        assertFalse(state.hasFlag(1));
        assertFalse(state.hasFlag(2));
        state.setFlag(2);


        cs.confirmState();

        assertTrue(state.isInUse());
        assertFalse(state.hasFlag(0));
        assertFalse(state.hasFlag(1));
        assertTrue(state.hasFlag(2));

    }
}