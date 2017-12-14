package com.sqli.test.elevators.states;

import com.sqli.test.elevators.Elevator;

/**
 *
 * Elevator State.
 *
 * Allow Elevator to alter its behaviour when the its internal state changes.
 * The Elevator will appear to change its class.
 *
 * @author Adami Hamza.
 */
public interface ElevatorState {
    /**
     * Going up from Elevator current floor to a specific
     * floor {@code where}.
     *
     * @param elevator Elevator.
     * @param where The floor to ascend to.
     */
    void up(Elevator elevator, int where);
    /**
     * Going down from Elevator current floor to a specific
     * floor {@code where} .
     *
     * @param elevator Target Elevator.
     * @param where The floor to descend to.
     */
    void down(Elevator elevator, int where);
    /**
     * Stop to serve someone & switch elevator direction (State)
     * when reaching Top/Bottom Floor.
     *
     * @param elevator Target Elevator.
     */
    void rest(Elevator elevator);

    void stop(Elevator elevator);
}
