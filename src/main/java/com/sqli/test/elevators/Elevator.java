package com.sqli.test.elevators;

import com.sqli.test.elevators.states.ElevatorState;

/**
 *
 * Elevator Strategy interface (open for extension)
 *
 * @author Adami Hamza
 */
public interface Elevator  {
    /**
     *
     * @return elevator current floor.
     */
    int getCurrentFloor();

    /**
     *
     * @param elevatorCurrentFloor the new Elevator Current Floor.
     */
    void setCurrentFloor(int elevatorCurrentFloor);

    /**
     *
     * @return Elevator current state.
     */
    ElevatorState getElevatorState();

    /**
     *
     * @param elevatorNewState the new Elevator State.
     */
    void setElevatorState(ElevatorState elevatorNewState);

    /**
     *
     * @return elevator building number of floor.
     */
    int getNumberOfFloors();

    /**
     *
     * @return elevator unique identifier.
     */
    String getId();

    /**
     *
     * The Elevator decides to ascend/descend based on current direction
     * Decide by Exception.
     *
     * @param floor the target floor.
     */
    void serve(int floor);

    /**
     *
     * @param floor the target floor to stop at.
     */
    void stop(int floor);
}
