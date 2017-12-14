package com.sqli.test.elevators.states;

import com.sqli.test.elevators.Elevator;

public final class StopState implements ElevatorState {
    @Override
    public void up(Elevator elevator, int where) {
        elevator.setElevatorState(new GoingUpState());
        elevator.getElevatorState().up(elevator, where);
    }

    @Override
    public void down(Elevator elevator, int where) {
        elevator.setElevatorState(new GoingDownState());
        elevator.getElevatorState().down(elevator, where);
    }

    @Override
    public void rest(Elevator elevator) {
        elevator.setElevatorState(new RestingState());
    }

    @Override
    public void stop(Elevator elevator) {
        throw new IllegalStateException("Elevator already stopping.");
    }
}
