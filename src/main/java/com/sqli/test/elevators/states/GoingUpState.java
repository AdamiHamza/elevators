package com.sqli.test.elevators.states;

import com.sqli.test.elevators.Elevator;

import java.util.logging.Logger;

/**
 *
 * Elevator Going Up State implementation.
 *
 * @author Adami Hamza.
 */
public final class GoingUpState implements ElevatorState {
    private static final Logger LOGGER = Logger.getLogger(GoingUpState.class.getName());

    @Override
    public void up(final Elevator elevator, final int where) {
        if (elevator.getCurrentFloor() != where) {
            LOGGER.info("Going Up to Floor : " + (elevator.getCurrentFloor() + 1));
            elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
            up(elevator, where);
        } else {
            this.rest(elevator);
        }
    }

    @Override
    public void down(final Elevator elevator, final int where) {
        throw new IllegalStateException("Elevator is ascending, Wait until it reach top floor.");
    }

    @Override
    public void rest(final Elevator elevator) {
        LOGGER.info("Open Elevator, Resting ...");
        elevator.setElevatorState(new RestingState());
        if (elevator.getCurrentFloor() != elevator.getNumberOfFloors()) {
            LOGGER.info("Close Elevator, Continue ...");
            elevator.setElevatorState(this);
        } else {
            LOGGER.info("Elevator reaches the top floor, Switch direction.");
            elevator.setElevatorState(new GoingDownState());
        }
    }


    @Override
    public void stop(Elevator elevator) {
        elevator.setElevatorState(new StopState());
    }
}
