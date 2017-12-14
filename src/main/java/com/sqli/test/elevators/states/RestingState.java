package com.sqli.test.elevators.states;

import com.sqli.test.elevators.Elevator;

/**
 *
 * Elevator Resting State implementation.
 *
 * @author Adami Hamza.
 */
public final class RestingState implements ElevatorState {
    @Override
    public void up(final Elevator elevator, final int where) {
        elevator.setElevatorState(new GoingUpState());
        elevator.getElevatorState().up(elevator, where);
    }

    @Override
    public void down(final Elevator elevator, final int where) {
        elevator.setElevatorState(new GoingDownState());
        elevator.getElevatorState().down(elevator, where);
    }

    @Override
    public void rest(final Elevator elevator) {
        throw new IllegalStateException("Elevator already resting.");
    }

    @Override
    public void stop(Elevator elevator) {
        elevator.setElevatorState(new StopState());
    }
}
